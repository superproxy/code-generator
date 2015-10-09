package com.github.superproxy.code.generator.support.model.java.sqlmap;

import com.github.superproxy.code.generator.core.generator.modelgen.ModelMapExtendHandler;
import com.github.superproxy.code.generator.support.model.DbJavaModel;

public interface SqlMapMethod{

    String getInsertGenerator(DbJavaModel dbJavaModel);

    String getInsert2Generator(DbJavaModel dbJavaModel);

    String updateGenerator(DbJavaModel dbJavaModel);

    String queryByIdGenerator(DbJavaModel dbJavaModel);

    String queryCountGenerator(DbJavaModel dbJavaModel);

    String queryByPageGenerator(DbJavaModel dbJavaModel);

    String deleteByIdGenerator(DbJavaModel dbJavaModel);
}
