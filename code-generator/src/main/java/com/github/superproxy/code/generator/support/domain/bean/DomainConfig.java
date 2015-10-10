package com.github.superproxy.code.generator.support.domain.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * projectconfig和moduleConfig的合集 内部模型对应的配置
 */
public class DomainConfig {
    private String author;
    private String packageName;
    private String date;
    private String tablePrefix;
    private String moduleName;

    private String classPostfix;
    /**
     * 模版地址
     */
    private String tplsRoot;

    private String tplPath;

    public String getTplPath() {
        return tplPath;
    }

    public void setTplPath(String tplPath) {
        this.tplPath = tplPath;
    }

    /**
     * 输出路径
     */
    private String outPath;
    private String tableName;

    public String getClassPostfix() {
        return classPostfix;
    }

    public void setClassPostfix(String classPostfix) {
        this.classPostfix = classPostfix;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTplsRoot() {
        return tplsRoot;
    }

    public void setTplsRoot(String tplsRoot) {
        this.tplsRoot = tplsRoot;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
