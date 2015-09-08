package com.github.superproxy.code.generator.plugins.sqlmap;

import com.github.superproxy.code.generator.core.model.Model;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;

public interface SqlMapMethodGenerator extends ModelExtendHandler {

    String getInsertGenerator(Model model);

    String getInsert2Generator(Model model);

    String updateGenerator(Model model);

    String queryByIdGenerator(Model model);

    String queryCountGenerator(Model model);

    String queryByPageGenerator(Model model);

    String deleteByIdGenerator(Model model);
}
