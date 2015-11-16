package com.github.superproxy.codegenerator.core.generator.engine.freemarker.method;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

import java.util.List;

public class LowerName implements TemplateMethodModel {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        return NameUtil.getLowerCase((String) arguments.get(0));
    }
}
