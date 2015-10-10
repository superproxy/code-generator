package com.github.superproxy.code.generator.support.model.db;


import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.code.generator.support.model.CommonModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;

import java.util.Map;

public class DbExtendHandlerModelAnd implements ModelAndModelMapExtendHandler {

    private String getSqlMapName(CommonModel commonModel, DbJavaModelConfig dbJavaModelConfig) {
        return commonModel.getTableName().replace(dbJavaModelConfig.getTablePrefix() + "_", "");
    }

    @Override
    public String handlerId() {
        return DbExtendModel.ID;
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        CommonModel commonModel = (CommonModel) model;
//        extend.put(ServiceExtendModel.NAME, getSqlMapName(dbJavaModel, dbJavaModel.getDbJavaModelConfig()));
        extend.put("fields", commonModel.getFieldList());
        extend.put("fieldList", commonModel.getFieldList());
        extend.put("pkFieldList", commonModel.getPkFieldList());
        extend.put("pkFields", commonModel.getPkFieldList());
    }

    @Override
    public void extendModel(Model model) {
        //  reader
        CommonModel commonModel = (CommonModel) model;
        if (commonModel.getTableInfo() == null) {
            commonModel.setTableInfo(commonModel);
        }

    }

}
