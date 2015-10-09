package com.github.superproxy.code.generator.support.model.java.lang;


import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelMapExtendHandler;
import com.github.superproxy.code.generator.support.model.DbJavaModel;

import java.util.Map;

public class JavaBeanExtendHandler implements ModelMapExtendHandler {

    private JavaBeanConvertStrategy javaBeanConvertStrategy = new JavaBeanConvertStrategyImpl();

    public String getShortClassName(DbJavaModel dbJavaModel) {
        return javaBeanConvertStrategy.convert(dbJavaModel).getShortClassName();
    }

    public String getPackage(DbJavaModel dbJavaModel) {
        return javaBeanConvertStrategy.convert(dbJavaModel).getPackage();
    }

    public String getClassName(DbJavaModel dbJavaModel) {
        return javaBeanConvertStrategy.convert(dbJavaModel).getClassName();
    }

    public String getSerialVersionUID(DbJavaModel dbJavaModel) {
        return javaBeanConvertStrategy.convert(dbJavaModel).getSerialVersionUID();

    }


    @Override
    public String handlerId() {
        return "java";
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        DbJavaModel dbJavaModel = (DbJavaModel) model;
        extend.put("package", getPackage(dbJavaModel));
        extend.put("shortClassName", getShortClassName(dbJavaModel));
        extend.put("className", getClassName(dbJavaModel));
        extend.put("serialVersionUID", getSerialVersionUID(dbJavaModel));
    }

}
