package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.core.generator.modelgen.ModelAndModelMapHandlerManager;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelTemplateGenerator;
import com.github.superproxy.code.generator.support.model.db.DbExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.java.lang.JavaBeanExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.java.service.ServiceExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.java.sqlmap.SqlMapMethodExtendHandlerModelAnd;
import com.github.superproxy.code.generator.support.model.project.ProjectModelAndModelMapExtendHandler;

public class DbJavaModelGenerator extends ModelTemplateGenerator {
    public DbJavaModelGenerator() {

        ModelAndModelMapHandlerManager modelAndModelMapHandlerManager = new ModelAndModelMapHandlerManager();
        modelAndModelMapHandlerManager.registerModelMapHandler(new ProjectModelAndModelMapExtendHandler());
        modelAndModelMapHandlerManager.registerModelMapHandler(new JavaBeanExtendHandlerModelAnd());
        modelAndModelMapHandlerManager.registerModelMapHandler(new DbExtendHandlerModelAnd());
        modelAndModelMapHandlerManager.registerModelMapHandler(new ServiceExtendHandlerModelAnd());
        modelAndModelMapHandlerManager.registerModelMapHandler(new SqlMapMethodExtendHandlerModelAnd());
        this.setModelAndModelMapHandlerManager(modelAndModelMapHandlerManager);
    }
}
