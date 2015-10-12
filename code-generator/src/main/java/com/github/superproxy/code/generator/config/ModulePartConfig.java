package com.github.superproxy.code.generator.config;

import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;
import com.github.superproxy.code.generator.tpl.Tpl;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * 模块的配置信息
 */
public class ModulePartConfig implements Serializable {


    private String tplClass;
    private ModuleConfig moduleConfig;

    private String packageName;
    private String classPostfix;
    private String tplPath;
    private String tplOutPath;

    public ModulePartConfig() {
    }

    public ModulePartConfig(Tpl tpl, String packageName, String classPostfix) {
        this.classPostfix = classPostfix;
        this.tplPath = tpl.getTplPath();
        this.tplClass = tpl.getClass().getName();
        this.packageName = packageName;
    }

    public String getTplOutPath(ComposeModel domain) {
        try {
            Constructor<?> constructor = Class.forName(tplClass).getConstructor();
            Tpl tpl = (Tpl) constructor.newInstance();
            tplOutPath = tpl.getOutPath(domain);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return tplOutPath;
    }


    public ModuleConfig getModuleConfig() {
        return moduleConfig;
    }

    public void setModuleConfig(ModuleConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    public void setTplOutPath(String tplOutPath) {
        this.tplOutPath = tplOutPath;
    }


    public String getTplClass() {
        return tplClass;
    }

    public void setTplClass(String tplClass) {
        this.tplClass = tplClass;
    }

    public String getTplOutPath() {
        return tplOutPath;
    }

    public String getTplPath() {
        return tplPath;
    }

    public void setTplPath(String tplPath) {
        this.tplPath = tplPath;
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
