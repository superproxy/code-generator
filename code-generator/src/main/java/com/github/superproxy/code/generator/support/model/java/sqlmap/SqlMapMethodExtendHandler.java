package com.github.superproxy.code.generator.support.model.java.sqlmap;

import com.github.superproxy.code.generator.core.generator.modelgen.ModelExtendHandler;
import com.github.superproxy.code.generator.support.model.DbJavaModel;

public interface SqlMapMethodExtendHandler extends ModelExtendHandler {

    String getInsertGenerator(DbJavaModel dbJavaModel);

    String getInsert2Generator(DbJavaModel dbJavaModel);

    String updateGenerator(DbJavaModel dbJavaModel);

    String queryByIdGenerator(DbJavaModel dbJavaModel);

    String queryCountGenerator(DbJavaModel dbJavaModel);

    String queryByPageGenerator(DbJavaModel dbJavaModel);

    String deleteByIdGenerator(DbJavaModel dbJavaModel);
}
