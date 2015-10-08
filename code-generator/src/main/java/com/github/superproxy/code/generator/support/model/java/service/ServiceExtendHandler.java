package com.github.superproxy.code.generator.support.model.java.service;


import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.support.model.DbJavaModel;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelExtendHandler;

import java.util.Map;

public class ServiceExtendHandler implements ModelExtendHandler {

    public ServiceExtendHandler() {
    }


    @Override
    public void extendModel(Model model, Map extend) {
        extend.put(ServiceExtendModel.NAME, getSqlMapName((DbJavaModel) model));
    }

    private String getSqlMapName(DbJavaModel dbJavaModel) {
        return dbJavaModel.getTableName().replace(dbJavaModel.getModelConfig().getTablePrefix() + "_", "");
    }

    @Override
    public String handlerId() {
        return ServiceExtendModel.ID;
    }

}
