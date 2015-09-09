package com.github.superproxy.code.generator.core;

import com.github.superproxy.code.generator.core.handler.ModelHandlerManager;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.core.model.Model;
import com.github.superproxy.code.generator.core.model.db.DbSchema;
import com.github.superproxy.code.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.github.superproxy.code.generator.core.model.db2java.JavaFieldConvertStrategy;

public class DbModel {

    private String templatePath;

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    private DbSchema dbSchema;
    private JavaFieldConvertStrategy javaFieldConvertStrategy;
    private JavaBeanConvertStrategy javaBeanConvertStrategy;
    private MConfig mConfig;

    private Model model;

    private ModelHandlerManager modelHandlerManager = new ModelHandlerManager();

    public DbModel() {

    }


    public DbModel(GeneratorContext generatorContext) {
        this.mConfig = generatorContext.getmConfig();
        this.dbSchema = generatorContext.getDbSchema();
        this.javaBeanConvertStrategy = generatorContext.getJavaBeanConvertStrategy();
        this.javaFieldConvertStrategy = generatorContext.getJavaFieldConvertStrategy();
    }


    public DbSchema getDbSchema() {
        return dbSchema;
    }

    public void setDbSchema(DbSchema dbSchema) {
        this.dbSchema = dbSchema;
    }

    public JavaBeanConvertStrategy getJavaBeanConvertStrategy() {
        return javaBeanConvertStrategy;
    }

    public void setJavaBeanConvertStrategy(JavaBeanConvertStrategy javaBeanConvertStrategy) {
        this.javaBeanConvertStrategy = javaBeanConvertStrategy;
    }

    public JavaFieldConvertStrategy getJavaFieldConvertStrategy() {
        return javaFieldConvertStrategy;
    }

    public void setJavaFieldConvertStrategy(JavaFieldConvertStrategy javaFieldConvertStrategy) {
        this.javaFieldConvertStrategy = javaFieldConvertStrategy;
    }


    public MConfig getmConfig() {
        return mConfig;
    }

    public void setmConfig(MConfig mConfig) {
        this.mConfig = mConfig;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return this.model;
    }


}
