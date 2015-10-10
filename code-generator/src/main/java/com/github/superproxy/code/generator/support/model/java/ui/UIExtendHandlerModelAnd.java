package com.github.superproxy.code.generator.support.model.java.ui;


import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.code.generator.support.model.CommonModel;

import java.util.Map;

public class UIExtendHandlerModelAnd implements ModelAndModelMapExtendHandler {


    @Override
    public String handlerId() {
        return "ui";
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
//        DbJavaModel dbJavaModel = (DbJavaModel) model;
//        JavaBean javaBean = dbJavaModel.getJavaBean();
//        extend.put("package", javaBean.getPackage());
//        extend.put("shortClassName", javaBean.getShortClassName());
//        extend.put("className", javaBean.getClassName());
//        extend.put("serialVersionUID", javaBean.getSerialVersionUID());
    }

    @Override
    public void extendModel(Model model) {
        CommonModel commonModel = (CommonModel) model;
        commonModel.setUIModel(new UIModel());
    }

}
