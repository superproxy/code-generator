package com.github.superproxy.code.generator.core;

import com.github.superproxy.code.generator.core.engine.TemplateEngine;
import com.github.superproxy.code.generator.core.engine.TplInfo;
import com.github.superproxy.code.generator.core.model.ModuleConfig;

/**
 * 基于模版机制的代码生成器
 */
public abstract class TemplateGenerator implements Generator<TplInfo> {
    protected ModuleConfig moduleConfig;

    protected TemplateEngine templateEngine;



    public TemplateGenerator() {
    }

    public ModuleConfig getModuleConfig() {
        return moduleConfig;
    }

    public void setModuleConfig(ModuleConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public void generator() {
        TplInfo tplInfo = getTplInfo();
        templateEngine.process((TplInfo) tplInfo);
    }

    public abstract TplInfo getTplInfo();
}
