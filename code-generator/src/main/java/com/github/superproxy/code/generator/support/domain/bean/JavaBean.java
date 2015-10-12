package com.github.superproxy.code.generator.support.domain.bean;


import java.util.ArrayList;
import java.util.List;

public class JavaBean {
    private String className;
    private String shortClassName;
    private String packageName;
    private String serialVersionUID;

    private List<JavaField> fieldList = new ArrayList<JavaField>();

    public List<JavaField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<JavaField> fieldList) {
        this.fieldList = fieldList;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(String serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public String getShortClassName() {
        return shortClassName;
    }

    public void setShortClassName(String shortClassName) {
        this.shortClassName = shortClassName;
    }

    public void addJavaField(JavaField javaField) {
        fieldList.add(javaField);
    }
}
