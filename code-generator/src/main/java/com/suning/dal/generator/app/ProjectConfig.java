package com.suning.dal.generator.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 14120295 on 2015/8/11.
 */
public class ProjectConfig {
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

    private Map<String, MConfig> modules = new HashMap<String, MConfig>();

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

    public Map<String, MConfig> getModules() {
        return modules;
    }

    public void setModules(Map<String, MConfig> modules) {
        this.modules = modules;
    }
}
