package com.github.superproxy.codegenerator.support.domain.extend.java.lang;


import com.github.superproxy.codegenerator.core.generator.modelgen.Model;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.JavaBean;
import com.github.superproxy.codegenerator.support.domain.convert.JavaBeanConvert;
import com.github.superproxy.codegenerator.support.domain.convert.JavaBeanConvertImpl;
import com.github.superproxy.codegenerator.support.domain.convert.JavaFieldConvertImpl;

import java.util.Map;

public class JavaBeanExtendHandler implements ModelAndModelMapExtendHandler {

    private JavaBeanConvert javaBeanConvert = new JavaBeanConvertImpl(new JavaFieldConvertImpl());


    @Override
    public String handlerId() {
        return "java";
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        ComposeModel domain = (ComposeModel) model;
        JavaBean javaBean = domain.getJavaBean();
        extend.put("javaBean", javaBean);
        extend.put("package", javaBean.getPackageName());
        extend.put("shortClassName", javaBean.getShortClassName());
        extend.put("className", javaBean.getClassName());
        extend.put("serialVersionUID", javaBean.getSerialVersionUID());
    }

    @Override
    public void extendModel(Model model) {
        ComposeModel domain = (ComposeModel) model;
        JavaBean javaBean = javaBeanConvert.convert(domain);
        domain.setJavaBean(javaBean);
    }

}
