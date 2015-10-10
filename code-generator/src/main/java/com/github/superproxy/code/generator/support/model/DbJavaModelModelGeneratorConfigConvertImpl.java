package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.ModelGeneratorConfigConvert;
import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.core.generator.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelGeneratorConfig;

import java.util.logging.Logger;

public class DbJavaModelModelGeneratorConfigConvertImpl implements ModelGeneratorConfigConvert {
    private static final Logger LOGGER = Logger.getLogger(DbJavaModelModelGeneratorConfigConvertImpl.class.getName());


    public static DbJavaModelConfig covert2ModuleConfig(ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        DbJavaModelConfig dbJavaModelConfig = new DbJavaModelConfig();
        dbJavaModelConfig.setAuthor(projectConfig.getAuthor());
        dbJavaModelConfig.setDate(projectConfig.getDate());
        dbJavaModelConfig.setOutPath(projectConfig.getOutPath());
        dbJavaModelConfig.setTplsRoot(projectConfig.getTplRoot());
        dbJavaModelConfig.setTableName(moduleConfig.getTableName());
        dbJavaModelConfig.setTablePrefix(moduleConfig.getTablePrefix());
        dbJavaModelConfig.setModuleName(moduleConfig.getModuleName());
        dbJavaModelConfig.setClassPostfix(modulePartConfig.getClassPostfix());
        dbJavaModelConfig.setPackageName(modulePartConfig.getPackageName());
        LOGGER.info("dbJavaModelConfig" + dbJavaModelConfig);
        return dbJavaModelConfig;
    }

    public static ModelGeneratorConfig buildGeneratorContext(CommonModel commonModel, DbJavaModelConfig dbJavaModelConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        ModelGeneratorConfig modelGeneratorConfig
                = new ModelGeneratorConfig();
        modelGeneratorConfig.setModel(commonModel);
        modelGeneratorConfig.setTplPath(modulePartConfig.getTplPath());
        modelGeneratorConfig.setOutPath(modulePartConfig.getTplOutPath(commonModel));
        modelGeneratorConfig.setTplsRoot(projectConfig.getTplRoot());
        modelGeneratorConfig.setTemplateEngine(new FreeMarkerTplEngine());
        return modelGeneratorConfig;
    }

    public static CommonModel getDbJavaModel(DbJavaModelConfig dbJavaModelConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        return new DbJavaModelFromDbReader().reader(dbJavaModelConfig, projectConfig, moduleConfig, modulePartConfig);
    }


}
