package com.github.superproxy.code.generator.support.domain.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class JavaField {
    private String javaName;
    private String setName;
    private String getName;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //    private TypeMapper.JdbcTypeInformation javaType;
    private String javaType;

    public String getShortJavaType() {
        return shortJavaType;
    }

    public void setShortJavaType(String shortJavaType) {
        this.shortJavaType = shortJavaType;
    }

    private String shortJavaType;

    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
