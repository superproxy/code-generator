package com.github.superproxy.code.generator.plugins.sqlmap;

import com.github.superproxy.code.generator.core.model.Model;
import com.github.superproxy.code.generator.core.model.db.ColumnInfo;
import com.github.superproxy.code.generator.core.model.Field;
import com.github.superproxy.code.generator.core.model.MConfig;

import java.util.Map;

public class SqlMapMethodGeneratorImpl implements SqlMapMethodGenerator {
    public static final String CONDITION = "<#if %1$s?exists && %1$s != \"\"> \r\n AND %1$s = :%2$s </#if>";
    public static final String INSERT_CHOOSE_1 = "<#if %1$s?exists && %1$s != \"\"> %2$s, </#if>";
    public static final String INSERT_CHOOSE_2 = "<#if %1$s?exists && %1$s != \"\"> %2$s </#if>";
    public static final String INSERT_CHOOSE_3 = "<#if %1$s?exists && %1$s != \"\"> :%1$s, </#if>";
    public static final String INSERT_CHOOSE_4 = "<#if %1$s?exists && %1$s != \"\"> :%1$s </#if>";
    MConfig mConfig;

    public SqlMapMethodGeneratorImpl(MConfig mConfig) {
        this.mConfig = mConfig;
    }

    @Override
    public String getInsert2Generator(Model model) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO " + model.getTableName() + " (");

//        // 自动增长，不出现
//        for (ColumnInfo c : model.getPkColumnList()) {
//            if (!c.isAutoIncreament()) {
//                sb.append(c.getColumnName());
//                appendGap(sb);
//            }
//        }
        nextLine(sb);
        for (int i = 0, size = model.getAllColumnInfoList().size(); i < size; i++) {
            ColumnInfo c = model.getAllColumnInfoList().get(i);
            Field field = model.getFied(c);
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


        for (int i = 0, size = model.getAllColumnInfoList().size(); i < size; i++) {
            ColumnInfo c = model.getAllColumnInfoList().get(i);
            Field field = model.getFied(c);
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
    public String getInsertGenerator(Model model) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO " + model.getTableName() + " (");

        // 自动增长，不出现
        for (ColumnInfo c : model.getAllColumnInfoList()) {
            if (!c.isAutoIncreament()) {
                sb.append(c.getColumnName());
                appendGap(sb);
            }
        }
        removeLastChar(sb);
        sb.append(")");
        nextLine(sb);
        sb.append("VALUES(");
        if (model.getPkColumnList().size() == 1) {  //一个主键

            for (ColumnInfo c : model.getPkColumnList()) {
                if (!c.isAutoIncreament()) {
                    Field field = model.getFied(c);
                    sb.append(":" + field.getJavaName());
                    appendGap(sb);
                }
            }
        } else {
            for (ColumnInfo c : model.getPkColumnList()) {
                if (!c.isAutoIncreament()) {
                    Field field = model.getFied(c);
                    sb.append(":" + field.getJavaName());
                    appendGap(sb);
                }
            }
        }
        for (ColumnInfo c : model.getColumnInfoList()) {
            if (!c.isAutoIncreament()) {
                Field field = model.getFied(c);
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
    public String updateGenerator(Model model) {

//        update t_nb_user set nick = :nick, sex = :sex, face_url = :face_url,
//                update_time = :update_time where id = :id

        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE " + model.getTableName());
        nextLine(sb);
        sb.append("SET ");
        for (ColumnInfo c : model.getColumnInfoList()) {
            Field field = model.getFied(c);
            sb.append(c.getColumnName() + " = :" + field.getJavaName());
            appendGap(sb);
        }
        removeLastChar(sb);

        nextLine(sb);
        sb.append("WHERE ");
        for (ColumnInfo c : model.getPkColumnList()) {
            if (!c.isAutoIncreament()) {
                Field field = model.getFied(c);
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
    public String queryByIdGenerator(Model model) {
//        SELECT t.*
//        FROM t_nb_user t WHERE t.id = :id
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT *");
        nextLine(sb);
        sb.append("FROM  " + model.getTableName());
        nextLine(sb);
        sb.append("WHERE ");
        for (ColumnInfo c : model.getPkColumnList()) {
            if (!c.isAutoIncreament()) {
                Field field = model.getFied(c);
                sb.append(c.getColumnName() + " = :" + field.getJavaName());
                appendGap(sb);
            }
        }
        removeLastChar(sb);
        return sb.toString();
    }

    @Override
    public String queryCountGenerator(Model model) {
//        SELECT COUNT(1) AS count FROM t_nb_user c
//        WHERE 1=1
//                <#if id?exists&& id!=""> and c.id = :id </#if>
//        <#if sex?exists&& sex!=""> and c.sex = :sex </#if>
//        <#if nick?exists&& nick!=""> and c.nick like "%" :nick"%" </#if>
//        <#if disabled?exists&& disabled!=""> and c.disabled = :disabled </#if>

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT COUNT(1) AS count");
        sb.append("FROM  " + model.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : model.getPkColumnList()) {
            {
                Field field = model.getFied(c);
                String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
                sb.append(condition);
                nextLine(sb);
            }
        }
        for (ColumnInfo c : model.getColumnInfoList()) {
            Field field = model.getFied(c);
            String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
            sb.append(condition);
            nextLine(sb);
        }
        return sb.toString();
    }

    @Override
    public String queryByPageGenerator(Model model) {
//        SELECT c.* FROM t_nb_user c
//        WHERE 1=1
//                <#if id?exists&& id!=""> and c.id = :id </#if>
//        <#if sex?exists&& sex!=""> and c.sex = :sex </#if>
//        <#if nick?exists&& nick!=""> and c.nick like "%":nick"%" </#if>
//        <#if disabled?exists&& disabled!=""> and c.disabled = :disabled </#if>
//        limit :startIndex,:maxCount

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM  " + model.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : model.getPkColumnList()) {
            {
                Field field = model.getFied(c);
                String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
                sb.append(condition);
                nextLine(sb);
            }
        }
        for (ColumnInfo c : model.getColumnInfoList()) {
            Field field = model.getFied(c);
            String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
            sb.append(condition);
            nextLine(sb);
        }
        return sb.toString();
    }


    public void extendModel(Model model, Map sqlMap) {
        //  下划线的  account_history
        sqlMap.put("name", getSqlMapName(model));
        sqlMap.put("insert", getInsertGenerator(model));
        sqlMap.put("insert2", getInsert2Generator(model));
        sqlMap.put("update", updateGenerator(model));
        sqlMap.put("queryById", queryByIdGenerator(model));
        sqlMap.put("queryByPage", queryByPageGenerator(model));
        sqlMap.put("queryCount", queryCountGenerator(model));
        sqlMap.put("deleteById", deleteByIdGenerator(model));
    }

    private String getSqlMapName(Model model) {
        return model.getTableName().replace(mConfig.getTablePrefix() + "_", "");
    }

    public String handlerId() {
        return "sqlMap";
    }

    @Override
    public String deleteByIdGenerator(Model model) {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE  ");
        sb.append("FROM  " + model.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : model.getPkColumnList()) {
            {
                Field field = model.getFied(c);
                String condition = String.format(CONDITION, c.getColumnName(), field.getJavaName());
                sb.append(condition);
                nextLine(sb);
            }
        }

        return sb.toString();
    }
}
