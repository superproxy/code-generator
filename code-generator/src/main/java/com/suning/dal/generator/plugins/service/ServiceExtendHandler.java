package com.suning.dal.generator.plugins.service;


import com.suning.dal.generator.core.handler.ExtendHandler;
import com.suning.dal.generator.core.model.Model;
import com.suning.dal.generator.core.model.ModuleConfig;

import java.util.Map;

public class ServiceExtendHandler implements ExtendHandler {
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
