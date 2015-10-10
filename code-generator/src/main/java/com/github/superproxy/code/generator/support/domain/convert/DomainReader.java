package com.github.superproxy.code.generator.support.domain.convert;

import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.DomainConfig;

public interface DomainReader {
    Domain reader(DomainConfig domainConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig);
}
