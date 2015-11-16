package com.github.superproxy.codegenerator.core.generator.modelgen;

import com.github.superproxy.codegenerator.core.generator.engine.TemplateEngine;

public class ModelGeneratorConfig {

    private Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    private String tplPath;

    public void setTplsRoot(String tplsRoot) {
        this.tplsRoot = tplsRoot;
    }

    private String tplsRoot;

    public String getTplsRoot() {
        return tplsRoot;
    }

    private String outPath;

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public String getTplPath() {
        return tplPath;
    }


    public void setTplPath(String tplPath) {
        this.tplPath = tplPath;
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    private TemplateEngine templateEngine;
}
