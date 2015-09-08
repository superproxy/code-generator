package com.github.superproxy.code.generator.app;

import java.io.Serializable;

public class ModulePartConfig implements Serializable {

    private String generator;
    private String packageName;
    private String classPostfix;

    public ModulePartConfig() {
    }

    public ModulePartConfig(String generator, String packageName, String classPostfix) {
        this.classPostfix = classPostfix;
        this.generator = generator;
        this.packageName = packageName;
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
}
