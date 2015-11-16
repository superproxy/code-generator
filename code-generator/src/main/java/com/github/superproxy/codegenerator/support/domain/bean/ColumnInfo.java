package com.github.superproxy.codegenerator.support.domain.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 数据库列对应的模型
 */
public class ColumnInfo {

    private String columnName;
    private String columnType;
    private String columnComment;

    private boolean isPk;

    private boolean isNull;

    private boolean isAutoCreament;

    public boolean isPk() {
        return isPk;
    }

    public void setPk(boolean isPk) {
        this.isPk = isPk;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean isNull) {
        this.isNull = isNull;
    }

    public boolean isAutoIncreament() {
        return isAutoCreament;
    }

    public void setAutoCreament(boolean isAutoCreament) {
        this.isAutoCreament = isAutoCreament;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }


    public String getColumnName() {
        return columnName;
    }


    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }

    private String columnJdbcType;

    public String getColumnJdbcType() {
        return columnJdbcType;
    }

    public void setColumnJdbcType(String columnJdbcType) {
        this.columnJdbcType = columnJdbcType;
    }
}
