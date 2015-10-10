package com.github.superproxy.code.generator.support.model.java.service;


import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelMapExtendHandler;

import java.util.Map;

public class ServiceExtendHandlerModelAnd implements ModelMapExtendHandler {

    public ServiceExtendHandlerModelAnd() {
    }


    @Override
    public void extendModelMap(Model model, Map extend) {
    }

    @Override
    public String handlerId() {
        return ServiceExtendModel.ID;
    }

}
