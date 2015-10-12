package com.github.superproxy.code.generator.support.domain.extend.java.sqlmap;

import com.github.superproxy.code.generator.support.domain.bean.ColumnInfo;
import com.github.superproxy.code.generator.support.domain.bean.TableInfo;
import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;
import com.github.superproxy.code.generator.support.domain.bean.JavaBean;

public class SqlMapMethodImpl implements SqlMapMethod {
    public static final String CONDITION = "<#if %1$s?exists && %1$s != \"\"> \r\n AND %1$s = :%2$s </#if>";
    public static final String INSERT_CHOOSE_1 = "<#if %1$s?exists && %1$s != \"\"> %2$s, </#if>";
    public static final String INSERT_CHOOSE_2 = "<#if %1$s?exists && %1$s != \"\"> %2$s </#if>";
    public static final String INSERT_CHOOSE_3 = "<#if %1$s?exists && %1$s != \"\"> :%1$s, </#if>";
    public static final String INSERT_CHOOSE_4 = "<#if %1$s?exists && %1$s != \"\"> :%1$s </#if>";

    public SqlMapMethodImpl() {
    }

    @Override
    public String getInsert2Generator(ComposeModel domain) {

        TableInfo tableInfo = domain.getTableInfo();
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO " + tableInfo.getTableName() + " (");

//        // 自动增长，不出现
//        for (ColumnInfo c : model.getPkColumnList()) {
//            if (!c.isAutoIncreament()) {
//                sb.append(c.getColumnName());
//                appendGap(sb);
//            }
//        }
        nextLine(sb);
        for (int i = 0, size = tableInfo.getAllColumnInfoList().size(); i < size; i++) {
            ColumnInfo c = tableInfo.getAllColumnInfoList().get(i);
            JavaBean javaBean = domain.getJavaBean();
            if (i != size - 1) {
                sb.append(String.format(INSERT_CHOOSE_1, javaBean.getShortClassName(), c.getColumnName()));
            } else {
                sb.append(String.format(INSERT_CHOOSE_2, javaBean.getShortClassName(), c.getColumnName()));
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
//                    sb.append(":" + field.getShortClassName());
//                    appendGap(sb);
//                }
//            }
//        } else {
//            for (ColumnInfo c : model.getPkColumnList()) {
//                if (!c.isAutoIncreament()) {
//                    Field field = model.getFied(c);
//                    sb.append(":" + field.getShortClassName());
//                    appendGap(sb);
//                }
//            }
//        }


        for (int i = 0, size = tableInfo.getAllColumnInfoList().size(); i < size; i++) {
            ColumnInfo c = tableInfo.getAllColumnInfoList().get(i);
            JavaBean field = domain.getJavaBean();
            if (i != size - 1) {
                sb.append(String.format(INSERT_CHOOSE_3, field.getShortClassName()));
            } else {
                sb.append(String.format(INSERT_CHOOSE_4, field.getShortClassName()));
            }
            nextLine(sb);
        }

        sb.append(")");
        return sb.toString();
    }

    @Override
    public String getInsertGenerator(ComposeModel domain) {
        TableInfo tableInfo = domain.getTableInfo();
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO " + tableInfo.getTableName() + " (");

        // 自动增长，不出现
        for (ColumnInfo c : tableInfo.getAllColumnInfoList()) {
            if (!c.isAutoIncreament()) {
                sb.append(c.getColumnName());
                appendGap(sb);
            }
        }
        removeLastChar(sb);
        sb.append(")");
        nextLine(sb);
        sb.append("VALUES(");
        if (tableInfo.getPkColumnList().size() == 1) {  //一个主键

            for (ColumnInfo c : tableInfo.getPkColumnList()) {
                if (!c.isAutoIncreament()) {
                    JavaBean field = domain.getJavaBean();
                    sb.append(":" + field.getShortClassName());
                    appendGap(sb);
                }
            }
        } else {
            for (ColumnInfo c : tableInfo.getPkColumnList()) {
                if (!c.isAutoIncreament()) {
                    JavaBean field = domain.getJavaBean();
                    sb.append(":" + field.getShortClassName());
                    appendGap(sb);
                }
            }
        }
        for (ColumnInfo c : tableInfo.getColumnInfoList()) {
            if (!c.isAutoIncreament()) {
                JavaBean field = domain.getJavaBean();
                sb.append(":" + field.getShortClassName());
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
    public String updateGenerator(ComposeModel domain) {
        TableInfo tableInfo = domain.getTableInfo();

//        update t_nb_user set nick = :nick, sex = :sex, face_url = :face_url,
//                update_time = :update_time where id = :id

        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE " + tableInfo.getTableName());
        nextLine(sb);
        sb.append("SET ");
        for (ColumnInfo c : tableInfo.getColumnInfoList()) {
            JavaBean field = domain.getJavaBean();
            sb.append(c.getColumnName() + " = :" + field.getShortClassName());
            appendGap(sb);
        }
        removeLastChar(sb);

        nextLine(sb);
        sb.append("WHERE ");
        for (ColumnInfo c : tableInfo.getPkColumnList()) {
            if (!c.isAutoIncreament()) {
                JavaBean field = domain.getJavaBean();
                sb.append(c.getColumnName() + " = :" + field.getShortClassName());
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
    public String queryByIdGenerator(ComposeModel domain) {
//        SELECT t.*
//        FROM t_nb_user t WHERE t.id = :id
        TableInfo tableInfo = domain.getTableInfo();
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT *");
        nextLine(sb);
        sb.append("FROM  " + tableInfo.getTableName());
        nextLine(sb);
        sb.append("WHERE ");
        for (ColumnInfo c : tableInfo.getPkColumnList()) {
            if (!c.isAutoIncreament()) {
                JavaBean field = domain.getJavaBean();
                sb.append(c.getColumnName() + " = :" + field.getShortClassName());
                appendGap(sb);
            }
        }
        removeLastChar(sb);
        return sb.toString();
    }

    @Override
    public String queryCountGenerator(ComposeModel domain) {
        TableInfo tableInfo = domain.getTableInfo();
//        SELECT COUNT(1) AS count FROM t_nb_user c
//        WHERE 1=1
//                <#if id?exists&& id!=""> and c.id = :id </#if>
//        <#if sex?exists&& sex!=""> and c.sex = :sex </#if>
//        <#if nick?exists&& nick!=""> and c.nick like "%" :nick"%" </#if>
//        <#if disabled?exists&& disabled!=""> and c.disabled = :disabled </#if>

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT COUNT(1) AS count ");
        sb.append("FROM  " + tableInfo.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : tableInfo.getPkColumnList()) {
            {
                JavaBean field = domain.getJavaBean();
                String condition = String.format(CONDITION, c.getColumnName(), field.getShortClassName());
                sb.append(condition);
                nextLine(sb);
            }
        }
        for (ColumnInfo c : tableInfo.getColumnInfoList()) {
            JavaBean field = domain.getJavaBean();
            String condition = String.format(CONDITION, c.getColumnName(), field.getShortClassName());
            sb.append(condition);
            nextLine(sb);
        }
        return sb.toString();
    }

    @Override
    public String queryByPageGenerator(ComposeModel domain) {
        TableInfo tableInfo = domain.getTableInfo();
//        SELECT c.* FROM t_nb_user c
//        WHERE 1=1
//                <#if id?exists&& id!=""> and c.id = :id </#if>
//        <#if sex?exists&& sex!=""> and c.sex = :sex </#if>
//        <#if nick?exists&& nick!=""> and c.nick like "%":nick"%" </#if>
//        <#if disabled?exists&& disabled!=""> and c.disabled = :disabled </#if>
//        limit :startIndex,:maxCount

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM  " + tableInfo.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : tableInfo.getPkColumnList()) {
            {
                JavaBean field = domain.getJavaBean();
                String condition = String.format(CONDITION, c.getColumnName(), field.getShortClassName());
                sb.append(condition);
                nextLine(sb);
            }
        }
        for (ColumnInfo c : tableInfo.getColumnInfoList()) {
            JavaBean field = domain.getJavaBean();
            String condition = String.format(CONDITION, c.getColumnName(), field.getShortClassName());
            sb.append(condition);
            nextLine(sb);
        }
        return sb.toString();
    }


    @Override
    public String deleteByIdGenerator(ComposeModel domain) {
        TableInfo tableInfo = domain.getTableInfo();
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE ");
        sb.append("FROM " + tableInfo.getTableName());
        nextLine(sb);
        sb.append("WHERE 1=1 AND");
        nextLine(sb);
        for (ColumnInfo c : tableInfo.getPkColumnList()) {
            {
                JavaBean field = domain.getJavaBean();
                String condition = String.format(CONDITION, c.getColumnName(), field.getShortClassName());
                sb.append(condition);
                nextLine(sb);
            }
        }

        return sb.toString();
    }
}
