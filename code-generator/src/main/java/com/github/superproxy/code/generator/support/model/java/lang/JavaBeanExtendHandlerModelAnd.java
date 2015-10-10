package com.github.superproxy.code.generator.support.model.java.lang;


import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.code.generator.support.model.CommonModel;

import java.util.Map;

public class JavaBeanExtendHandlerModelAnd implements ModelAndModelMapExtendHandler {

    private JavaBeanConvertStrategy javaBeanConvertStrategy = new JavaBeanConvertStrategyImpl();


    @Override
    public String handlerId() {
        return "java";
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        CommonModel commonModel = (CommonModel) model;
        JavaBean javaBean = commonModel.getJavaBean();
        extend.put("package", javaBean.getPackage());
        extend.put("shortClassName", javaBean.getShortClassName());
        extend.put("className", javaBean.getClassName());
        extend.put("serialVersionUID", javaBean.getSerialVersionUID());
    }

    @Override
    public void extendModel(Model model) {
        CommonModel commonModel = (CommonModel) model;
        JavaBean javaBean = javaBeanConvertStrategy.convert(commonModel);
        commonModel.setJavaBean(javaBean);
    }

}
