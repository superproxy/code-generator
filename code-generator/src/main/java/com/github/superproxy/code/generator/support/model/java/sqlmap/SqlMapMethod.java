package com.github.superproxy.code.generator.support.model.java.sqlmap;

import com.github.superproxy.code.generator.support.model.CommonModel;

public interface SqlMapMethod{

    String getInsertGenerator(CommonModel commonModel);

    String getInsert2Generator(CommonModel commonModel);

    String updateGenerator(CommonModel commonModel);

    String queryByIdGenerator(CommonModel commonModel);

    String queryCountGenerator(CommonModel commonModel);

    String queryByPageGenerator(CommonModel commonModel);

    String deleteByIdGenerator(CommonModel commonModel);
}
