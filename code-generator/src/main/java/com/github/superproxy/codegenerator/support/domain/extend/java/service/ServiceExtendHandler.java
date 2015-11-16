package com.github.superproxy.codegenerator.support.domain.extend.java.service;


import com.github.superproxy.codegenerator.core.generator.modelgen.Model;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelMapExtendHandler;

import java.util.Map;

public class ServiceExtendHandler implements ModelMapExtendHandler {

    public ServiceExtendHandler() {
    }


    @Override
    public void extendModelMap(Model model, Map extend) {
    }

    @Override
    public String handlerId() {
        return ServiceExtendModel.ID;
    }

}
