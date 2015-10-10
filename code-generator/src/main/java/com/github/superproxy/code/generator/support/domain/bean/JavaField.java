package com.github.superproxy.code.generator.support.domain.bean;

public class JavaField {
    private String javaName;
    private String setName;
    private String getName;
//    private TypeMapper.JdbcTypeInformation javaType;
    private String javaType;

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
}
