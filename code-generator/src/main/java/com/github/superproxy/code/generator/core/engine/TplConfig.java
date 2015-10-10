package com.github.superproxy.code.generator.core.engine;

import java.io.Serializable;

public class TplConfig implements Serializable {

    protected TplModel tplModel;

    protected TemplateEngine templateEngine;

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public TplModel getTplModel() {
        return tplModel;
    }

    public void setTplModel(TplModel tplModel) {
        this.tplModel = tplModel;
    }
}
