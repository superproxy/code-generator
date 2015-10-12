package com.github.superproxy.code.generator.support.domain.extend.java.sqlmap;

import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;

public interface SqlMapMethod{

    String getInsertGenerator(ComposeModel domain);

    String getInsert2Generator(ComposeModel domain);

    String updateGenerator(ComposeModel domain);

    String queryByIdGenerator(ComposeModel domain);

    String queryCountGenerator(ComposeModel domain);

    String queryByPageGenerator(ComposeModel domain);

    String deleteByIdGenerator(ComposeModel domain);
}
