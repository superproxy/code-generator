package com.github.superproxy.code.generator.core.model;

import com.github.superproxy.code.generator.core.engine.TemplateEngine;
import com.github.superproxy.code.generator.core.model.db.DbSchema;
import com.github.superproxy.code.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.github.superproxy.code.generator.core.model.db2java.JavaFieldConvertStrategy;

public class GeneratorContext {
    private MConfig mConfig;
    private DbSchema dbSchema;

    private JavaBeanConvertStrategy javaBeanConvertStrategy;
    private JavaFieldConvertStrategy javaFieldConvertStrategy;

    private TemplateEngine templateEngine;

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public GeneratorContext() {
    }

    public GeneratorContext(DbSchema dbSchema, JavaBeanConvertStrategy javaBeanConvertStrategy, JavaFieldConvertStrategy javaFieldConvertStrategy, MConfig mConfig, TemplateEngine templateEngine) {
        this.dbSchema = dbSchema;
        this.javaBeanConvertStrategy = javaBeanConvertStrategy;
        this.javaFieldConvertStrategy = javaFieldConvertStrategy;
        this.mConfig = mConfig;
        this.templateEngine = templateEngine;
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
}
