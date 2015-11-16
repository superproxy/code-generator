package com.github.superproxy.codegenerator.support.domain.extend.db;


import com.github.superproxy.codegenerator.core.generator.modelgen.Model;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.TableInfo;

import java.util.Map;

public class DbExtendHandler implements ModelAndModelMapExtendHandler {


    @Override
    public String handlerId() {
        return DbExtendModel.ID;
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        ComposeModel domain = (ComposeModel) model;
//        extend.put(ServiceExtendModel.NAME, getSqlMapName(dbJavaModel, dbJavaModel.getDbJavaModelConfig()));
        extend.put("table", domain.getTableInfo());
//        extend.put("fields", domain.getFieldList());
//        extend.put("fieldList", domain.getFieldList());
//        extend.put("pkFieldList", domain.getPkFieldList());
//        extend.put("pkFields", domain.getPkFieldList());
    }

    @Override
    public void extendModel(Model model) {
        ComposeModel domain = (ComposeModel) model;
        if (domain.getTableInfo() == null) {
            domain.setTableInfo(convert(domain));
        }

    }

    private TableInfo convert(ComposeModel domain) {
        throw new UnsupportedOperationException("unsupported covert");
    }

}
