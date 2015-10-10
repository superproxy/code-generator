package com.github.superproxy.code.generator.core.engine.freemarker.method;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

import java.util.List;

public class PascalStyleName implements TemplateMethodModel
{
    @Override
    public Object exec(List arguments) throws TemplateModelException
    {
        return NameUtil.getPascalStyleName((String) arguments.get(0));
    }
}
