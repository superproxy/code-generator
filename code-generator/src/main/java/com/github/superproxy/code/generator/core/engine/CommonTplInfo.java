package com.github.superproxy.code.generator.core.engine;

import java.util.Map;

public class CommonTplInfo implements TplInfo {

    private String tplPath;

    public void setTplRoot(String tplRoot) {
        this.tplRoot = tplRoot;
    }

    private String tplRoot;

    @Override
    public String getTplRoot() {
        return tplRoot;
    }

    private String outPath;
    private Map model;

    @Override
    public Map getModel() {
        return model;
    }

    public void setModel(Map model) {
        this.model = model;
    }

    @Override
    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    @Override
    public String getTplPath() {
        return tplPath;
    }


    public void setTplPath(String tplPath) {
        this.tplPath = tplPath;
    }
}
