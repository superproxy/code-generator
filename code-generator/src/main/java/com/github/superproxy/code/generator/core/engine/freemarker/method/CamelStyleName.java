package com.github.superproxy.code.generator.core.engine.freemarker.method;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

import java.util.List;

public class CamelStyleName implements TemplateMethodModel
{
    @Override
    public Object exec(List arguments) throws TemplateModelException
    {
        return NameUtil.getCamelStyleName((String) arguments.get(0));
    }
}
