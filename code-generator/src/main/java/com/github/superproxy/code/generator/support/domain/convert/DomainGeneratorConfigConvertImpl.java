package com.github.superproxy.code.generator.support.domain.convert;

import com.github.superproxy.code.generator.ModelGeneratorConfigConvert;
import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.core.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.modelgen.ModelGeneratorConfig;
import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.DomainConfig;

import java.util.logging.Logger;

public class DomainGeneratorConfigConvertImpl implements ModelGeneratorConfigConvert {
    private static final Logger LOGGER = Logger.getLogger(DomainGeneratorConfigConvertImpl.class.getName());


    public static DomainConfig covert2ModuleConfig(ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        DomainConfig domainConfig = new DomainConfig();
        domainConfig.setAuthor(projectConfig.getAuthor());
        domainConfig.setDate(projectConfig.getDate());
        domainConfig.setOutPath(projectConfig.getOutPath());
        domainConfig.setTplsRoot(projectConfig.getTplRoot());
        domainConfig.setTableName(moduleConfig.getTableName());
        domainConfig.setTablePrefix(moduleConfig.getTablePrefix());
        domainConfig.setModuleName(moduleConfig.getModuleName());
        domainConfig.setClassPostfix(modulePartConfig.getClassPostfix());
        domainConfig.setPackageName(modulePartConfig.getPackageName());
        LOGGER.info("DomainConfig" + domainConfig);
        return domainConfig;
    }

    public static ModelGeneratorConfig buildGeneratorContext(Domain domain, DomainConfig domainConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        ModelGeneratorConfig modelGeneratorConfig
                = new ModelGeneratorConfig();
        modelGeneratorConfig.setModel(domain);
        modelGeneratorConfig.setTplPath(modulePartConfig.getTplPath());
        modelGeneratorConfig.setOutPath(modulePartConfig.getTplOutPath(domain));
        modelGeneratorConfig.setTplsRoot(projectConfig.getTplRoot());
        modelGeneratorConfig.setTemplateEngine(new FreeMarkerTplEngine());
        return modelGeneratorConfig;
    }

    public static Domain getDbJavaModel(DomainConfig domainConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        return new DomainFromDbReader().reader(domainConfig, projectConfig, moduleConfig, modulePartConfig);
    }


}
