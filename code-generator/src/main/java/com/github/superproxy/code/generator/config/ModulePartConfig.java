package com.github.superproxy.code.generator.config;

import com.github.superproxy.code.generator.tpl.Tpl;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 模块的配置信息
 */
public class ModulePartConfig implements Serializable {
    private ModuleConfig moduleConfig;

    public ModuleConfig getModuleConfig() {
        return moduleConfig;
    }

    public void setModuleConfig(ModuleConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    private String packageName;
    private String classPostfix;
    private String tplPath;

    public String getTplOutPath() {
        return tplOutPath;
    }

    public void setTplOutPath(String tplOutPath) {
        this.tplOutPath = tplOutPath;
    }

    private String tplOutPath;

    public String getTplPath() {
        return tplPath;
    }

    public void setTplPath(String tplPath) {
        this.tplPath = tplPath;
    }

    public ModulePartConfig() {
    }

    public ModulePartConfig(Tpl tpl, String packageName, String classPostfix) {
        this.classPostfix = classPostfix;
        this.tplOutPath = tpl.getOutPath();
        this.tplPath = tpl.getTplPath();
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassPostfix() {
        return classPostfix;
    }

    public void setClassPostfix(String classPostfix) {
        this.classPostfix = classPostfix;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
