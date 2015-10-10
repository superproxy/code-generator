package com.github.superproxy.code.generator.support.domain;

import com.github.superproxy.code.generator.core.modelgen.ModelAndModelMapHandlerManager;
import com.github.superproxy.code.generator.core.modelgen.ModelTemplateGenerator;
import com.github.superproxy.code.generator.support.domain.extend.db.DbExtendHandler;
import com.github.superproxy.code.generator.support.domain.extend.java.lang.JavaBeanExtendHandler;
import com.github.superproxy.code.generator.support.domain.extend.java.service.ServiceExtendHandler;
import com.github.superproxy.code.generator.support.domain.extend.java.sqlmap.SqlMapMethodExtendHandler;
import com.github.superproxy.code.generator.support.domain.extend.project.ProjectModelMapExtendHandler;

public class DomainGenerator extends ModelTemplateGenerator {
    public DomainGenerator() {
        ModelAndModelMapHandlerManager modelAndModelMapHandlerManager = new ModelAndModelMapHandlerManager();
        modelAndModelMapHandlerManager.registerModelMapHandler(new ProjectModelMapExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new JavaBeanExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new DbExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new ServiceExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new SqlMapMethodExtendHandler());
        this.setModelAndModelMapHandlerManager(modelAndModelMapHandlerManager);
    }
}
