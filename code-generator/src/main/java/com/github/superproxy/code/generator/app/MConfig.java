package com.github.superproxy.code.generator.app;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MConfig implements Serializable {
    private String tablePrefix;
    private String moduleName;
    private String tableName;
    private List<ModulePartConfig> javaGeneratorList = new ArrayList<ModulePartConfig>();

    public List<ModulePartConfig> getLayerConfig() {
        return javaGeneratorList;
    }

    public void setLayerConfig(List<ModulePartConfig> javaGeneratorList) {
        this.javaGeneratorList = javaGeneratorList;
    }

    public void addLayerConfig(ModulePartConfig javaGenerator) {
        javaGeneratorList.add(javaGenerator);
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
