package com.github.superproxy.code.generator.support.domain.extend.java.sqlmap;

import com.github.superproxy.code.generator.support.domain.bean.Domain;

public interface SqlMapMethod{

    String getInsertGenerator(Domain domain);

    String getInsert2Generator(Domain domain);

    String updateGenerator(Domain domain);

    String queryByIdGenerator(Domain domain);

    String queryCountGenerator(Domain domain);

    String queryByPageGenerator(Domain domain);

    String deleteByIdGenerator(Domain domain);
}
