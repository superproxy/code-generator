package com.github.superproxy.codegenerator;

import com.github.superproxy.codegenerator.config.ConfigYamlUtils;
import com.github.superproxy.codegenerator.config.ModuleConfig;
import com.github.superproxy.codegenerator.config.ModulePartConfig;
import com.github.superproxy.codegenerator.config.ProjectConfig;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelAndModelMapHandlerManager;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelGeneratorConfig;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelTemplateGenerator;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.DomainConfig;
import com.github.superproxy.codegenerator.support.domain.convert.DomainGeneratorConfigConvertImpl;
import com.github.superproxy.codegenerator.support.domain.extend.db.DbExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.java.lang.JavaBeanExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.java.service.ServiceExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.java.sqlmap.SqlMapMethodExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.java.ui.UIExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.project.ProjectModelMapExtendHandler;

public abstract class ProjectGenerator {
    protected void process(ProjectConfig projectConfig) throws Exception {

        int i = 0;
        for (ModuleConfig moduleConfig : projectConfig.getModules()) {
            moduleConfig.setProjectConfig(projectConfig); // 查找节点方便
            for (ModulePartConfig partConfig : moduleConfig.getModulePartConfigList()) {
                partConfig.setModuleConfig(moduleConfig); // 查找节点方便
                ModelTemplateGenerator generator = new ThreadLayerGenerator();
                DomainConfig domainConfig = DomainGeneratorConfigConvertImpl.covert2ModuleConfig(projectConfig, moduleConfig, partConfig);
                ComposeModel domain = new DomainGeneratorConfigConvertImpl().getDbJavaModel(domainConfig, projectConfig, moduleConfig, partConfig);

                ModelAndModelMapHandlerManager handlerManager = new ModelAndModelMapHandlerManager();
                handlerManager.registerModelHandler(new JavaBeanExtendHandler());
                handlerManager.registerModelHandler(new DbExtendHandler());
                handlerManager.registerModelHandler(new UIExtendHandler());

                handlerManager.registerModelMapHandler(new ProjectModelMapExtendHandler());
                handlerManager.registerModelMapHandler(new JavaBeanExtendHandler());
                handlerManager.registerModelMapHandler(new DbExtendHandler());
                handlerManager.registerModelMapHandler(new ServiceExtendHandler());
                handlerManager.registerModelMapHandler(new SqlMapMethodExtendHandler());
                handlerManager.registerModelMapHandler(new UIExtendHandler());


                handlerManager.extendModel(domain);

                i++;
                ConfigYamlUtils.writeDomain(domain, "domain" + i + ".yaml");
                generator.setModelAndModelMapHandlerManager(handlerManager);
                ModelGeneratorConfig modelGeneratorConfig = DomainGeneratorConfigConvertImpl.buildGeneratorContext(domain, domainConfig, projectConfig, moduleConfig, partConfig);
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
