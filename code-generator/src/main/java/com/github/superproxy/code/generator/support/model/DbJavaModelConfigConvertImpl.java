package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.ConfigConvert;
import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.core.generator.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelGeneratorConfig;

import java.util.logging.Logger;

public class DbJavaModelConfigConvertImpl implements ConfigConvert {
    private static final Logger LOGGER = Logger.getLogger(DbJavaModelConfigConvertImpl.class.getName());

    @Override
    public ModelGeneratorConfig convert(ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        DbJavaModelConfig dbJavaModelConfig = covert2ModuleConfig(projectConfig, moduleConfig, modulePartConfig);
        return buildGeneratorContext(dbJavaModelConfig, projectConfig, moduleConfig, modulePartConfig);
    }

    private static DbJavaModelConfig covert2ModuleConfig(ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        DbJavaModelConfig dbJavaModelConfig = new DbJavaModelConfig();
        dbJavaModelConfig.setAuthor(projectConfig.getAuthor());
        dbJavaModelConfig.setDate(projectConfig.getDate());
        dbJavaModelConfig.setOutPath(projectConfig.getOutPath());
        dbJavaModelConfig.setTplsRoot(projectConfig.getTplRoot());
        dbJavaModelConfig.setTableName(moduleConfig.getTableName());
        dbJavaModelConfig.setModuleName(moduleConfig.getModuleName());
        dbJavaModelConfig.setClassPostfix(modulePartConfig.getClassPostfix());
        dbJavaModelConfig.setPackageName(modulePartConfig.getPackageName());

        LOGGER.info("dbJavaModelConfig" + dbJavaModelConfig);
        return dbJavaModelConfig;
    }

    private static ModelGeneratorConfig buildGeneratorContext(DbJavaModelConfig dbJavaModelConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        ModelGeneratorConfig modelGeneratorContext = new ModelGeneratorConfig();
//        modelGeneratorContext.setModelConfig(modelConfig);
        DbJavaModel model = new DbJavaModelFromDbReader().reader(dbJavaModelConfig, projectConfig, moduleConfig, modulePartConfig);
        modelGeneratorContext.setModel(model);
        modelGeneratorContext.setTplPath(modulePartConfig.getTplPath());
        modelGeneratorContext.setOutPath(modulePartConfig.getTplOutPath());
        modelGeneratorContext.setTplsRoot(projectConfig.getTplRoot());
//        modelGeneratorContext.setJavaBeanConvertStrategy(new JavaBeanConvertStrategyImpl());
//        modelGeneratorContext.setJavaFieldConvertStrategy(new JavaFieldStrategyImpl());
        modelGeneratorContext.setTemplateEngine(new FreeMarkerTplEngine());
        return modelGeneratorContext;
    }


}
