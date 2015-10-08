package com.github.superproxy.code.generator.support.model.java.lang;

import com.github.superproxy.code.generator.support.model.DbJavaModel;

public interface JavaBeanConvertStrategy {

    JavaBean convert(DbJavaModel dbJavaModel);
}
