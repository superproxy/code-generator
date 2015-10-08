package com.github.superproxy.code.generator.support.model.java.lang;


import com.github.superproxy.code.generator.support.model.DbJavaModel;
import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelExtendHandler;

import java.util.Map;

public class JavaBeanExtendHandler implements ModelExtendHandler {

    private JavaBeanConvertStrategy javaBeanConvertStrategy = new JavaBeanConvertStrategyImpl();

    public String getShortClassName(DbJavaModel dbJavaModel) {
        return javaBeanConvertStrategy.convert(dbJavaModel).getShortClassName();
    }

    public String getPackage(DbJavaModel dbJavaModel) {
        return javaBeanConvertStrategy.convert(dbJavaModel).getPackage();
    }


    @Override
    public String handlerId() {
        return "java";
    }

    @Override
    public void extendModel(Model model, Map extend) {
        DbJavaModel dbJavaModel = (DbJavaModel) model;
        extend.put("package", getPackage(dbJavaModel));
        extend.put("shortClassName", getShortClassName(dbJavaModel));
    }

}
