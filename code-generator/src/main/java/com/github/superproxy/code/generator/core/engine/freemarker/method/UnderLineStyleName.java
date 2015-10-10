package com.github.superproxy.code.generator.core.engine.freemarker.method;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

import java.util.List;


public class UnderLineStyleName implements TemplateMethodModel {
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        String s = (String) arguments.get(0);
        return NameUtil.getUnderLineName(s);
    }

}
