package com.github.superproxy.code.generator.app;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectConfig implements Serializable {
    private String author;
    private String date;
    /**
     * 模版地址
     */
    private String tplsPath;
    /**
     * 输出路径
     */
    private String outPath;
    private List<MConfig> modules = new ArrayList<MConfig>();

    public List<MConfig> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public void setModules(List<MConfig> modules) {
        this.modules = modules;
    }

    public String getTplsPath() {
        return tplsPath;
    }

    public void setTplsPath(String tplsPath) {
        this.tplsPath = tplsPath;
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


    public void addModule(MConfig mConfig) {
        modules.add(mConfig);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
