package com.github.superproxy.code.generator.core.generator.tplgen;

import com.github.superproxy.code.generator.core.generator.Generator;
import com.github.superproxy.code.generator.core.generator.engine.TplConfig;
import com.github.superproxy.code.generator.core.generator.engine.TemplateEngine;

/**
 * 基于模版机制的代码生成器
 */
public abstract class AbstractTemplateGenerator implements Generator {


    protected TemplateEngine templateEngine;

    public AbstractTemplateGenerator() {
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public void generator(Object o) {
        if (o instanceof TplConfig) {
            TplConfig tplConfig = (TplConfig) o;
            generator(tplConfig);
        }
        throw new UnsupportedOperationException("");
    }

    public void generator(TplConfig tplConfig) {
        this.templateEngine = tplConfig.getTemplateEngine();
        templateEngine.process(tplConfig.getTplModel());
    }

}
