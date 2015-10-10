package com.github.superproxy.code.generator.support.domain.extend.db;


import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.core.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.TableInfo;

import java.util.Map;

public class DbExtendHandler implements ModelAndModelMapExtendHandler {


    @Override
    public String handlerId() {
        return DbExtendModel.ID;
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        Domain domain = (Domain) model;
//        extend.put(ServiceExtendModel.NAME, getSqlMapName(dbJavaModel, dbJavaModel.getDbJavaModelConfig()));
        extend.put("table", domain.getTableInfo());
//        extend.put("fields", domain.getFieldList());
//        extend.put("fieldList", domain.getFieldList());
//        extend.put("pkFieldList", domain.getPkFieldList());
//        extend.put("pkFields", domain.getPkFieldList());
    }

    @Override
    public void extendModel(Model model) {
        Domain domain = (Domain) model;
        if (domain.getTableInfo() == null) {
            domain.setTableInfo(convert(domain));
        }

    }

    private TableInfo convert(Domain domain) {
        throw new UnsupportedOperationException("unsupported covert");
    }

}
