package com.github.superproxy.codegenerator.support.domain.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class DomainField {

    private String displayName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String columnType;
    private String columnComment;

    public DomainField() {
    }

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



    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getDisplayName() {
        return displayName;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }


}
