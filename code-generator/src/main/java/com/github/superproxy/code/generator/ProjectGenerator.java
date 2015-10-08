package com.github.superproxy.code.generator;

import com.github.superproxy.code.generator.core.generator.GeneratorFactory;
import com.github.superproxy.code.generator.core.generator.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelGeneratorConfig;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelTemplateGenerator;
import com.github.superproxy.code.generator.config.ModelConfig;
import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.support.model.java.service.ServiceExtendHandler;

import java.lang.reflect.Constructor;

public class ProjectGenerator {
    public static void process(ProjectConfig projectConfig) throws Exception {
        for (ModuleConfig moduleConfig : projectConfig.getModules()) {
            moduleConfig.setProjectConfig(projectConfig); // 查找节点方便
            for (ModulePartConfig partConfig : moduleConfig.getModulePartConfigList()) {
                partConfig.setModuleConfig(moduleConfig); // 查找节点方便

                ModelConfig modelConfig = covert2ModuleConfig(projectConfig, moduleConfig, partConfig);
                ModelGeneratorConfig modelGeneratorContext = buildGeneratorContext(modelConfig, projectConfig, moduleConfig);
                ModelTemplateGenerator generator = (ModelTemplateGenerator) GeneratorFactory.getGenerator(partConfig.getGenerator());
                if (generator == null) {
                    Constructor<?> constructor = Class.forName(partConfig.getGenerator()).getConstructor();
                    generator = (ModelTemplateGenerator) constructor.newInstance();
                    GeneratorFactory.registerGenerator(generator);
                }
                generator.registerHandler(new ServiceExtendHandler());
                generator.generator(modelGeneratorContext);
            }
        }
    }

    private static ModelConfig covert2ModuleConfig(ProjectConfig projectConfig, ModuleConfig mConfig, ModulePartConfig partConfig) {
        ModelConfig moduleConfig = new ModelConfig();
        moduleConfig.setAuthor(projectConfig.getAuthor());
        moduleConfig.setDate(projectConfig.getDate());
        moduleConfig.setOutPath(projectConfig.getOutPath());
        moduleConfig.setTplsRoot(projectConfig.getTplRoot());
        moduleConfig.setTableName(mConfig.getTableName());
        moduleConfig.setModuleName(mConfig.getModuleName());
        moduleConfig.setClassPostfix(partConfig.getClassPostfix());
        moduleConfig.setPackageName(partConfig.getPackageName());
        return moduleConfig;
    }


    private static ModelGeneratorConfig buildGeneratorContext(ModelConfig modelConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig) throws Exception {
        ModelGeneratorConfig modelGeneratorContext = new ModelGeneratorConfig();
//        modelGeneratorContext.setModelConfig(modelConfig);
//        modelGeneratorContext.setModel(model);
//        modelGeneratorContext.setJavaBeanConvertStrategy(new JavaBeanConvertStrategyImpl());
//        modelGeneratorContext.setJavaFieldConvertStrategy(new JavaFieldStrategyImpl());
        modelGeneratorContext.setTemplateEngine(new FreeMarkerTplEngine());
        return modelGeneratorContext;
    }


}
