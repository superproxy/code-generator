package com.github.superproxy.code.generator.config;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 模块的配置信息  数据库 包   路径
 */
public class ModuleConfig implements Serializable {
    private ProjectConfig projectConfig;

    public ProjectConfig getProjectConfig() {
        return projectConfig;
    }

    public void setProjectConfig(ProjectConfig projectConfig) {
        this.projectConfig = projectConfig;
    }


    private String moduleName;

    private String tableName;
    private String tablePrefix;

    private List<ModulePartConfig> modulePartConfigList = new ArrayList<ModulePartConfig>();

    public List<ModulePartConfig> getModulePartConfigList() {
        return modulePartConfigList;
    }

    public void setModulePartConfigList(List<ModulePartConfig> modulePartConfigList) {
        this.modulePartConfigList = modulePartConfigList;
    }


    public void addModulePartConfig(ModulePartConfig modulePartConfig) {
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
