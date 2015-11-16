package com.github.superproxy.codegenerator;

import com.github.superproxy.codegenerator.core.generator.modelgen.ModelAndModelMapHandlerManager;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelTemplateGenerator;
import com.github.superproxy.codegenerator.support.domain.extend.db.DbExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.java.lang.JavaBeanExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.java.service.ServiceExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.java.sqlmap.SqlMapMethodExtendHandler;
import com.github.superproxy.codegenerator.support.domain.extend.project.ProjectModelMapExtendHandler;

public class ThreadLayerGenerator extends ModelTemplateGenerator {
    public ThreadLayerGenerator() {
        ModelAndModelMapHandlerManager modelAndModelMapHandlerManager = new ModelAndModelMapHandlerManager();
        modelAndModelMapHandlerManager.registerModelMapHandler(new ProjectModelMapExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new JavaBeanExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new DbExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new ServiceExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new SqlMapMethodExtendHandler());
        this.setModelAndModelMapHandlerManager(modelAndModelMapHandlerManager);
    }
}
