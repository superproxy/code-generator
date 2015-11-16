package com.github.superproxy.codegenerator.support.domain.convert;

import com.github.superproxy.codegenerator.config.ModuleConfig;
import com.github.superproxy.codegenerator.config.ModulePartConfig;
import com.github.superproxy.codegenerator.config.ProjectConfig;
import com.github.superproxy.codegenerator.core.generator.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelGeneratorConfig;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.DomainConfig;

import java.util.logging.Logger;

public class DomainGeneratorConfigConvertImpl implements DomainGeneratorConfigConvert {
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

    public static ModelGeneratorConfig buildGeneratorContext(ComposeModel domain, DomainConfig domainConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        ModelGeneratorConfig modelGeneratorConfig
                = new ModelGeneratorConfig();
        modelGeneratorConfig.setModel(domain);
        modelGeneratorConfig.setTplPath(modulePartConfig.getTplPath());
        modelGeneratorConfig.setOutPath(modulePartConfig.getTplOutPath(domain));
        modelGeneratorConfig.setTplsRoot(projectConfig.getTplRoot());
        modelGeneratorConfig.setTemplateEngine(new FreeMarkerTplEngine());
        return modelGeneratorConfig;
    }

    public static ComposeModel getDbJavaModel(DomainConfig domainConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        return new DomainFromDbReader().reader(domainConfig, projectConfig, moduleConfig, modulePartConfig);
    }


}
