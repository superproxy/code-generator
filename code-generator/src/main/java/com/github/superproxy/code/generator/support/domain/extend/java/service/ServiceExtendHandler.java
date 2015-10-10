package com.github.superproxy.code.generator.support.domain.extend.java.service;


import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.core.modelgen.ModelMapExtendHandler;

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
