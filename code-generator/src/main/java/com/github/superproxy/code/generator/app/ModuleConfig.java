package com.github.superproxy.code.generator.app;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModuleConfig implements Serializable {
    private String tablePrefix;
    private String moduleName;
    private String tableName;

    public List<ModulePartConfig> getModulePartConfigList() {
        return modulePartConfigList;
    }

    public void setModulePartConfigList(List<ModulePartConfig> modulePartConfigList) {
        this.modulePartConfigList = modulePartConfigList;
    }

    private List<ModulePartConfig> modulePartConfigList = new ArrayList<ModulePartConfig>();

    public void addLayerConfig(ModulePartConfig modulePartConfig) {
        modulePartConfigList.add(modulePartConfig);
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
