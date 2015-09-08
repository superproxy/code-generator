package com.github.superproxy.code.generator.plugins.service;


import com.github.superproxy.code.generator.core.model.Model;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.ModuleConfig;

import java.util.Map;

public class ServiceExtendHandler implements ModelExtendHandler {
    private ModuleConfig moduleConfig;

    public ServiceExtendHandler(ModuleConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    @Override
    public void extendModel(Model model, Map sqlMap) {
        sqlMap.put("name", getSqlMapName(model));
    }

    private String getSqlMapName(Model model) {
        return model.getTableName().replace(moduleConfig.getTablePrefix() + "_", "");
    }

    @Override
    public String handlerId() {
        return "service";
    }

}
