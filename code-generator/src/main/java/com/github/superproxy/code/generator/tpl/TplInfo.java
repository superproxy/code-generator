package com.github.superproxy.code.generator.tpl;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 每个模版的描述信息
 */
public class TplInfo {
    String tplPath;
    String tplName;
    String tplDescription;

    public String getTplDescription() {
        return tplDescription;
    }

    public void setTplDescription(String tplDescription) {
        this.tplDescription = tplDescription;
    }

    public String getTplName() {
        return tplName;
    }

    public void setTplName(String tplName) {
        this.tplName = tplName;
    }

    public String getTplPath() {
        return tplPath;
    }

    public void setTplPath(String tplPath) {
        this.tplPath = tplPath;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
