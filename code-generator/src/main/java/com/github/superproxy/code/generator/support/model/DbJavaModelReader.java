package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.support.model.DbJavaModel;

public interface DbJavaModelReader {

    DbJavaModel reader(ProjectConfig projectConfig);
}
