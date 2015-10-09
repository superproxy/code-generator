package com.github.superproxy.code.generator.support.model.db;


import com.github.superproxy.code.generator.support.model.DbJavaModel;
import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelMapExtendHandler;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.support.model.java.service.ServiceExtendModel;

import java.util.Map;

public class DbExtendHandler implements ModelMapExtendHandler {

    private String getSqlMapName(DbJavaModel dbJavaModel, DbJavaModelConfig dbJavaModelConfig) {
        return dbJavaModel.getTableName().replace(dbJavaModelConfig.getTablePrefix() + "_", "");
    }

    @Override
    public String handlerId() {
        return DbExtendModel.ID;
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        DbJavaModel dbJavaModel = (DbJavaModel) model;
//        extend.put(ServiceExtendModel.NAME, getSqlMapName(dbJavaModel, dbJavaModel.getDbJavaModelConfig()));
          extend.put("fields", dbJavaModel.getFieldList());
          extend.put("fieldList", dbJavaModel.getFieldList());
          extend.put("pkFieldList", dbJavaModel.getPkFieldList());
          extend.put("pkFields", dbJavaModel.getPkFieldList());
    }

}
