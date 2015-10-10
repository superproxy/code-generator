package com.github.superproxy.code.generator;

import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelGeneratorConfig;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelAndModelMapHandlerManager;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelTemplateGenerator;
import com.github.superproxy.code.generator.support.model.CommonModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.support.model.DbJavaModelModelGeneratorConfigConvertImpl;
import com.github.superproxy.code.generator.support.model.DbJavaModelGenerator;
import com.github.superproxy.code.generator.support.model.db.DbExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.java.lang.JavaBeanExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.java.service.ServiceExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.java.sqlmap.SqlMapMethodExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.java.ui.UIExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.project.ProjectModelAndModelMapExtendHandler;

public abstract class ProjectGenerator {
    protected void process(ProjectConfig projectConfig) throws Exception {
        for (ModuleConfig moduleConfig : projectConfig.getModules()) {
            moduleConfig.setProjectConfig(projectConfig); // 查找节点方便
            for (ModulePartConfig partConfig : moduleConfig.getModulePartConfigList()) {
                partConfig.setModuleConfig(moduleConfig); // 查找节点方便
                ModelTemplateGenerator generator = new DbJavaModelGenerator();
                DbJavaModelConfig dbJavaModelConfig = DbJavaModelModelGeneratorConfigConvertImpl.covert2ModuleConfig(projectConfig, moduleConfig, partConfig);
                CommonModel commonModel = new DbJavaModelModelGeneratorConfigConvertImpl().getDbJavaModel(dbJavaModelConfig, projectConfig, moduleConfig, partConfig);

                ModelAndModelMapHandlerManager modelAndModelMapHandlerManager = new ModelAndModelMapHandlerManager();
                modelAndModelMapHandlerManager.registerModelHandler(new JavaBeanExtendHandlerModelAnd());
                modelAndModelMapHandlerManager.registerModelHandler(new DbExtendHandlerModelAnd());
                modelAndModelMapHandlerManager.registerModelHandler(new UIExtendHandlerModelAnd());

                modelAndModelMapHandlerManager.registerModelMapHandler(new ProjectModelAndModelMapExtendHandler());
                modelAndModelMapHandlerManager.registerModelMapHandler(new JavaBeanExtendHandlerModelAnd());
                modelAndModelMapHandlerManager.registerModelMapHandler(new DbExtendHandlerModelAnd());
                modelAndModelMapHandlerManager.registerModelMapHandler(new ServiceExtendHandlerModelAnd());
                modelAndModelMapHandlerManager.registerModelMapHandler(new SqlMapMethodExtendHandlerModelAnd());
                modelAndModelMapHandlerManager.registerModelMapHandler(new UIExtendHandlerModelAnd());


                modelAndModelMapHandlerManager.extendModel(commonModel);
                generator.setModelAndModelMapHandlerManager(modelAndModelMapHandlerManager);
                ModelGeneratorConfig modelGeneratorConfig = DbJavaModelModelGeneratorConfigConvertImpl.buildGeneratorContext(commonModel, dbJavaModelConfig, projectConfig, moduleConfig, partConfig);
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
