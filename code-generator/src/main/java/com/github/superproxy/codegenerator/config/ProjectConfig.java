package com.github.superproxy.codegenerator.config;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectConfig implements Serializable {
    /**
     * 作者
     */
    private String author;
    /**
     * 时间信息
     */
    private String date;
    /**
     * 模版地址
     */
    private String tplRoot;
    /**
     * 输出路径
     */
    private String outPath;

    /**
     * 模型类型
     */
    private String modelType;

    private List<ModuleConfig> modules = new ArrayList<ModuleConfig>();

    /**
     * 数据库配置
     */
    private DbConfig dbConfig;

    public List<ModuleConfig> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public void setModules(List<ModuleConfig> modules) {
        this.modules = modules;
    }

    public DbConfig getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public String getTplRoot() {
        return tplRoot;
    }

    public void setTplRoot(String tplRoot) {
        this.tplRoot = tplRoot;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void addModule(ModuleConfig moduleConfig) {
        modules.add(moduleConfig);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
