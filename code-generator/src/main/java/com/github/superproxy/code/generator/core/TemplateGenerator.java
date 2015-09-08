package com.github.superproxy.code.generator.core;

import com.github.superproxy.code.generator.core.engine.TemplateEngine;
import com.github.superproxy.code.generator.core.engine.TplInfo;
import com.github.superproxy.code.generator.core.model.MConfig;

/**
 * 基于模版机制的代码生成器
 */
public abstract class TemplateGenerator implements Generator<TplInfo> {
    protected MConfig mConfig;

    protected TemplateEngine templateEngine;



    public TemplateGenerator() {
    }

    public MConfig getmConfig() {
        return mConfig;
    }

    public void setmConfig(MConfig mConfig) {
        this.mConfig = mConfig;
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
