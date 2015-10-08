package com.github.superproxy.code.generator.config;

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

    private String generator;
    private String packageName;
    private String classPostfix;
    private String tlpPath;

    public String getTlpPath() {
        return tlpPath;
    }

    public void setTlpPath(String tlpPath) {
        this.tlpPath = tlpPath;
    }

    public ModulePartConfig() {
    }

    public ModulePartConfig(String generator, String packageName, String classPostfix) {
        this.classPostfix = classPostfix;
        this.generator = generator;
        this.packageName = packageName;
    }

    public ModulePartConfig(String generator, String packageName, String classPostfix, String tlpPath) {
        this.classPostfix = classPostfix;
        this.generator = generator;
        this.packageName = packageName;
        this.tlpPath = tlpPath;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
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
