package com.github.superproxy.code.generator.core.generator.engine;

import java.util.Map;

public class CommonTplModel implements TplModel {

    private String tplPath;

    public void setTplsRoot(String tplsRoot) {
        this.tplsRoot = tplsRoot;
    }

    private String tplsRoot;

    @Override
    public String getTplsRoot() {
        return tplsRoot;
    }

    private String outPath;
    private Map modelMap;

    @Override
    public Map getModelMap() {
        return modelMap;
    }

    public void setModelMap(Map modelMap) {
        this.modelMap = modelMap;
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
