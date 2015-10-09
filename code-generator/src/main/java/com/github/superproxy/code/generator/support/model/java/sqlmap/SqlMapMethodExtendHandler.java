package com.github.superproxy.code.generator.support.model.java.sqlmap;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelMapExtendHandler;
import com.github.superproxy.code.generator.source.db.ColumnInfo;
import com.github.superproxy.code.generator.support.model.DbJavaModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.support.model.java.lang.Field;

import java.util.HashMap;
import java.util.Map;

public class SqlMapMethodExtendHandler implements SqlMapMethod, ModelMapExtendHandler {
    public static final String CONDITION = "<#if %1$s?exists && %1$s != \"\"> \r\n AND %1$s = :%2$s </#if>";
    public static final String INSERT_CHOOSE_1 = "<#if %1$s?exists && %1$s != \"\"> %2$s, </#if>";
    public static final String INSERT_CHOOSE_2 = "<#if %1$s?exists && %1$s != \"\"> %2$s </#if>";
    public static final String INSERT_CHOOSE_3 = "<#if %1$s?exists && %1$s != \"\"> :%1$s, </#if>";
    public static final String INSERT_CHOOSE_4 = "<#if %1$s?exists && %1$s != \"\"> :%1$s </#if>";

    public SqlMapMethodExtendHandler() {
    }

    @Override
    public String getInsert2Generator(DbJavaModel dbJavaModel) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO " + dbJavaModel.getTableName() + " (");

//        // 自动增长，不出现
//        for (ColumnInfo c : model.getPkColumnList()) {
//            if (!c.isAutoIncreament()) {
//                sb.append(c.getColumnName());
//                appendGap(sb);
//            }
//        }
        nextLine(sb);
        for (int i = 0, size = dbJavaModel.getAllColumnInfoList().size(); i < size; i++) {
            ColumnInfo c = dbJavaModel.getAllColumnInfoList().get(i);
            Field field = dbJavaModel.buildField(c);
            if (i != size - 1) {
                sb.append(String.format(INSERT_CHOOSE_1, field.getJavaName(), c.getColumnName()));
            } else {
                sb.append(String.format(INSERT_CHOOSE_2, field.getJavaName(), c.getColumnName()));
            }
            nextLine(sb);
        }
        sb.append(")");
        nextLine(sb);
        sb.append("VALUES(");
        nextLine(sb);

//        if (model.getPkColumnList().size() == 1) {  //一个主键
//
//            for (ColumnInfo c : model.getPkColumnList()) {
//                if (!c.isAutoIncreament()) {
//                    Field field = model.getFied(c);
//                    sb.append(":" + field.getJavaName());
//                    appendGap(sb);
//                }
//            }
//        } else {
//            for (ColumnInfo c : model.getPkColumnList()) {
//                if (!c.isAutoIncreament()) {
//                    Field field = model.getFied(c);
//                    sb.append(":" + field.getJavaName());
//                    appendGap(sb);
//                }
//            }
//        }


        for (int i = 0, size = dbJavaModel.getAllColumnInfoList().size(); i < size; i++) {
            ColumnInfo c = dbJavaModel.getAllColumnInfoList().get(i);
            Field field = dbJavaModel.buildField(c);
            if (i != size - 1) {
                sb.append(String.format(INSERT_CHOOSE_3, field.getJavaName()));
            } else {
                sb.append(String.format(INSERT_CHOOSE_4, field.getJavaName()));
            }
            nextLine(sb);
        }

        sb.append(")");
        return sb.toString();
    }

    @Override
    public String getInsertGenerator(DbJavaModel dbJavaModel) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO " + dbJavaModel.getTableName() + " (");

        // 自动增长，不出现
        for (ColumnInfo c : dbJavaModel.getAllColumnInfoList()) {
            if (!c.isAutoIncreament()) {
                sb.append(c.getColumnName());
                appendGap(sb);
            }
        }
        removeLastChar(sb);
        sb.append(")");
        nextLine(sb);
        sb.append("VALUES(");
        if (dbJavaModel.getPkColumnList().size() == 1) {  //一个主键

            for (ColumnInfo c : dbJavaModel.getPkColumnList()) {
                if (!c.isAutoIncreament()) {
                    Field field = dbJavaModel.buildField(c);
                    sb.append(":" + field.getJavaName());
                    appendGap(sb);
                }
            }
        } else {
            for (ColumnInfo c : dbJavaModel.getPkColumnList()) {
                if (!c.isAutoIncreament()) {
                    Field field = dbJavaModel.buildField(c);
                    sb.append(":" + field.getJavaName());
                    appendGap(sb);
                }
            }
        }
        for (ColumnInfo c : dbJavaModel.getColumnInfoList()) {
            if (!c.isAutoIncreament()) {
                Field field = dbJavaModel.buildField(c);
                sb.append(":" + field.getJavaName());
                appendGap(sb);
            }
        }
        removeLastChar(sb);
        sb.append(")");
        return sb.toString();
    }

    private void appendGap(StringBuilder sb) {
        sb.append(", ");
    }

    private void removeLastChar(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
    }

    @Override
    public String updateGenerator(DbJavaModel dbJavaModel) {

//        update t_nb_user set nick = :nick, sex = :sex, face_url = :face_url,
//                update_time = :update_time where id = :id

        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE " + dbJavaModel.getTableName());
        nextLine(sb);
        sb.append("SET ");
        for (ColumnInfo c : dbJavaModel.getColumnInfoList()) {
            Field field = dbJavaModel.buildField(c);
            sb.append(c.getColumnName() + " = :" + field.getJavaName());
            appendGap(sb);
        }
        removeLastChar(sb);

        nextLine(sb);
        sb.append("WHERE ");
        for (ColumnInfo c : dbJavaModel.getPkColumnList()) {
            if (!c.isAutoIncreament()) {
                Field field = dbJavaModel.buildField(c);
                sb.append(c.getColumnName() + " = :" + field.getJavaName());
                appendGap(sb);
            }
        }
        removeLastChar(sb);

        return sb.toString();
    }

    private void nextLine(StringBuilder sb) {
        sb.append("\n");
        sb.append(space(8));
    }

    private char[] space(int count) {
        char[] chars = new char[count];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = ' ';
        }
        return chars;
    }

    @Override
    public String queryByIdGenerator(DbJavaModel dbJavaModel) {
//        SELECT t.*
//        FROM t_nb_user t WHERE t.id = :id
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT *");
        nextLine(sb);
        sb.append("FROM  " + dbJavaModel.getTableName());
        nextLine(sb);
        sb.append("WHERE ");
        for (ColumnInfo c : dbJavaModel.getPkColumnList()) {
            if (!c.isAutoIncreament()) {
                Field field = dbJavaModel.buildField(c);
                sb.append(c.getColumnName() + " = :" + field.getJavaName());
                appendGap(sb);
            }
        }
        removeLastChar(sb);
        return sb.toString();
    }

    @Override
    public String queryCountGenerator(DbJavaModel dbJavaModel) {
//        SELECT COUNT(1) AS count FROM t_nb_user c
//        WHERE 1=1
//                <#if id?exists&& id!=""> and c.id = :id </#if>
//        <#if sex?exists&& sex!=""> and c.sex = :sex </#if>
//        <#if nick?exists&& nick!=""> and c.nick like "%" :nick"%" </#if>
//        <#if disabled?exists&& disabled!=""> and c.disabled = :disabled </#if>

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT COUNT(1) AS count");
        sb.append("FROM  " + dbJavaModel.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : dbJavaModel.getPkColumnList()) {
            {
                Field field = dbJavaModel.buildField(c);
                String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
                sb.append(condition);
                nextLine(sb);
            }
        }
        for (ColumnInfo c : dbJavaModel.getColumnInfoList()) {
            Field field = dbJavaModel.buildField(c);
            String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
            sb.append(condition);
            nextLine(sb);
        }
        return sb.toString();
    }

    @Override
    public String queryByPageGenerator(DbJavaModel dbJavaModel) {
//        SELECT c.* FROM t_nb_user c
//        WHERE 1=1
//                <#if id?exists&& id!=""> and c.id = :id </#if>
//        <#if sex?exists&& sex!=""> and c.sex = :sex </#if>
//        <#if nick?exists&& nick!=""> and c.nick like "%":nick"%" </#if>
//        <#if disabled?exists&& disabled!=""> and c.disabled = :disabled </#if>
//        limit :startIndex,:maxCount

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM  " + dbJavaModel.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : dbJavaModel.getPkColumnList()) {
            {
                Field field = dbJavaModel.buildField(c);
                String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
                sb.append(condition);
                nextLine(sb);
            }
        }
        for (ColumnInfo c : dbJavaModel.getColumnInfoList()) {
            Field field = dbJavaModel.buildField(c);
            String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
            sb.append(condition);
            nextLine(sb);
        }
        return sb.toString();
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        DbJavaModel dbJavaModel = (DbJavaModel) model;

        Map map = new HashMap();
        map.put(SqlMapExtendModel.NAME, getSqlMapName(dbJavaModel, dbJavaModel.getDbJavaModelConfig()));
        map.put(SqlMapExtendModel.INSERT, getInsertGenerator(dbJavaModel));
        map.put(SqlMapExtendModel.INSERT2, getInsert2Generator(dbJavaModel));
        map.put(SqlMapExtendModel.UPDATE, updateGenerator(dbJavaModel));
        map.put(SqlMapExtendModel.QUERY_BY_ID, queryByIdGenerator(dbJavaModel));
        map.put(SqlMapExtendModel.QUERY_BY_PAGE, queryByPageGenerator(dbJavaModel));
        map.put(SqlMapExtendModel.QUERY_COUNT, queryCountGenerator(dbJavaModel));
        map.put(SqlMapExtendModel.DELETE_BY_ID, deleteByIdGenerator(dbJavaModel));

        extend.put("sqlMap", map);

        extend.put("name", getSqlMapName((DbJavaModel) model));
    }

    private String getSqlMapName(DbJavaModel dbJavaModel) {
        return dbJavaModel.getTableName().replace(dbJavaModel.getDbJavaModelConfig().getTablePrefix() + "_", "");
    }


    private String getSqlMapName(DbJavaModel dbJavaModel, DbJavaModelConfig dbJavaModelConfig) {
        return dbJavaModel.getTableName().replace(dbJavaModelConfig.getTablePrefix() + "_", "");
    }

    public String handlerId() {
        return SqlMapExtendModel.ID;
    }

    @Override
    public String deleteByIdGenerator(DbJavaModel dbJavaModel) {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE  ");
        sb.append("FROM  " + dbJavaModel.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : dbJavaModel.getPkColumnList()) {
            {
                Field field = dbJavaModel.buildField(c);
                String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
                sb.append(condition);
                nextLine(sb);
            }
        }

        return sb.toString();
    }
}
