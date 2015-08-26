package com.suning.dal.generator.plugins.sqlmap;

import com.suning.dal.generator.core.handler.ExtendHandler;
import com.suning.dal.generator.core.model.Model;

public interface SqlMapMethodGenerator extends ExtendHandler {

    String getInsertGenerator(Model model);

    String getInsert2Generator(Model model);

    String updateGenerator(Model model);

    String queryByIdGenerator(Model model);

    String queryCountGenerator(Model model);

    String queryByPageGenerator(Model model);

    String deleteByIdGenerator(Model model);
}
