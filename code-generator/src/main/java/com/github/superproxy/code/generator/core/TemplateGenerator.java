package com.github.superproxy.code.generator.core;

import com.github.superproxy.code.generator.core.engine.TemplateEngine;
import com.github.superproxy.code.generator.core.engine.TplInfo;

/**
 * 基于模版机制的代码生成器
 */
public abstract class TemplateGenerator implements Generator {

    protected TemplateEngine templateEngine;

    public TemplateGenerator() {
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public void generator(Object o) {
        if (o instanceof TplInfo) {
            templateEngine.process((TplInfo) o);
        }
    }
}
