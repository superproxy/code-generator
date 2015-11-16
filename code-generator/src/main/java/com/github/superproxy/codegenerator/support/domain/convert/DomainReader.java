package com.github.superproxy.codegenerator.support.domain.convert;

import com.github.superproxy.codegenerator.config.ModuleConfig;
import com.github.superproxy.codegenerator.config.ModulePartConfig;
import com.github.superproxy.codegenerator.config.ProjectConfig;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.DomainConfig;

public interface DomainReader {
    ComposeModel reader(DomainConfig domainConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig);
}
