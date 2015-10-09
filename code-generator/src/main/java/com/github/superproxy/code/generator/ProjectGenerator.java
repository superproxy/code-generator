package com.github.superproxy.code.generator;

import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelGeneratorConfig;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelTemplateGenerator;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfigConvertImpl;
import com.github.superproxy.code.generator.support.model.DbJavaModelGenerator;

public class ProjectGenerator {
    public static void process(ProjectConfig projectConfig) throws Exception {
        for (ModuleConfig moduleConfig : projectConfig.getModules()) {
            moduleConfig.setProjectConfig(projectConfig); // 查找节点方便
            for (ModulePartConfig partConfig : moduleConfig.getModulePartConfigList()) {
                partConfig.setModuleConfig(moduleConfig); // 查找节点方便
                ModelGeneratorConfig modelGeneratorConfig = new DbJavaModelConfigConvertImpl().convert(projectConfig, moduleConfig, partConfig);
                ModelTemplateGenerator generator = new DbJavaModelGenerator();
                generator.generator(modelGeneratorConfig);
            }
        }
    }

//    private static ModelTemplateGenerator getModelTemplateGenerator(ModulePartConfig partConfig) throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
//        ModelTemplateGenerator generator = (ModelTemplateGenerator) GeneratorFactory.getGenerator(partConfig.getGenerator());
//        if (generator == null) {
//            Constructor<?> constructor = Class.forName(partConfig.getGenerator()).getConstructor();
//            generator = (ModelTemplateGenerator) constructor.newInstance();
//            GeneratorFactory.registerGenerator(generator);
//        }
//        ModelTemplateGenerator generator = new ModelTemplateGenerator();
//        return generator;
//    }


}
