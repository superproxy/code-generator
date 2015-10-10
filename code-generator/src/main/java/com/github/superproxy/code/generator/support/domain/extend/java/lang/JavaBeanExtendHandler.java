package com.github.superproxy.code.generator.support.domain.extend.java.lang;


import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.core.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.JavaBean;
import com.github.superproxy.code.generator.support.domain.convert.JavaBeanConvertStrategy;
import com.github.superproxy.code.generator.support.domain.convert.JavaBeanConvertStrategyImpl;

import java.util.Map;

public class JavaBeanExtendHandler implements ModelAndModelMapExtendHandler {

    private JavaBeanConvertStrategy javaBeanConvertStrategy = new JavaBeanConvertStrategyImpl();


    @Override
    public String handlerId() {
        return "java";
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        Domain domain = (Domain) model;
        JavaBean javaBean = domain.getJavaBean();
        extend.put("javaBean", javaBean);
        extend.put("package", javaBean.getPackageName());
        extend.put("shortClassName", javaBean.getShortClassName());
        extend.put("className", javaBean.getClassName());
        extend.put("serialVersionUID", javaBean.getSerialVersionUID());
    }

    @Override
    public void extendModel(Model model) {
        Domain domain = (Domain) model;
        JavaBean javaBean = javaBeanConvertStrategy.convert(domain);
        domain.setJavaBean(javaBean);
    }

}
