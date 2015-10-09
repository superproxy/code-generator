package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.core.generator.modelgen.ModelTemplateGenerator;
import com.github.superproxy.code.generator.support.model.db.DbExtendHandler;
import com.github.superproxy.code.generator.support.model.java.lang.JavaBeanExtendHandler;
import com.github.superproxy.code.generator.support.model.java.service.ServiceExtendHandler;
import com.github.superproxy.code.generator.support.model.java.sqlmap.SqlMapMethodExtendHandler;
import com.github.superproxy.code.generator.support.model.project.ProjectModelMapExtendHandler;

public class DbJavaModelGenerator extends ModelTemplateGenerator {
    public DbJavaModelGenerator() {
        registerHandler(new ProjectModelMapExtendHandler());
        registerHandler(new JavaBeanExtendHandler());
        registerHandler(new DbExtendHandler());
        registerHandler(new ServiceExtendHandler());
        registerHandler(new SqlMapMethodExtendHandler());
    }
}
