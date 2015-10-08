package com.github.superproxy.code.generator.support.model.db;


import com.github.superproxy.code.generator.support.model.DbJavaModel;
import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelExtendHandler;
import com.github.superproxy.code.generator.config.ModelConfig;
import com.github.superproxy.code.generator.support.model.java.service.ServiceExtendModel;

import java.util.Map;

public class DbExtendHandler implements ModelExtendHandler {

    private String getSqlMapName(DbJavaModel dbJavaModel, ModelConfig modelConfig) {
        return dbJavaModel.getTableName().replace(modelConfig.getTablePrefix() + "_", "");
    }

    @Override
    public String handlerId() {
        return DbExtendModel.ID;
    }

    @Override
    public void extendModel(Model model, Map extend) {
        DbJavaModel dbJavaModel = (DbJavaModel) model;
        extend.put(ServiceExtendModel.NAME, getSqlMapName(dbJavaModel, dbJavaModel.getModelConfig()));
    }

}
