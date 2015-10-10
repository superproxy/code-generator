package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;

public interface DbJavaModelReader {
    CommonModel reader(DbJavaModelConfig dbJavaModelConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig);
}
