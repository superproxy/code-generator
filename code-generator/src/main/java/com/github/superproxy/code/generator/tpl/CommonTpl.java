package com.github.superproxy.code.generator.tpl;

import com.github.superproxy.code.generator.core.modelgen.Model;

public class CommonTpl implements Tpl {

    String tplPath;
    String outPath;
    String id;

    public CommonTpl() {
    }

    public CommonTpl(String id, String tplPath, String outPath) {
        this.id = id;
        this.outPath = outPath;
        this.tplPath = tplPath;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public void setTplPath(String tplPath) {
        this.tplPath = tplPath;
    }

    @Override
    public String getTplPath() {
        return tplPath;
    }

    @Override
    public String getOutPath(Model model) {
        return tplPath;
    }

    @Override
    public String getId() {
        return id;
    }
}
