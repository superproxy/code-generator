package com.github.superproxy.code.generator.plugins.service;


import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.core.model.Model;

import java.util.Map;

public class ServiceExtendHandler implements ModelExtendHandler {

    public ServiceExtendHandler() {
    }

    @Override
    public void extendModel(MConfig mConfig, Model model, Map sqlMap) {
        sqlMap.put("name", getSqlMapName(model, mConfig));
    }

    private String getSqlMapName(Model model, MConfig mConfig) {
        return model.getTableName().replace(mConfig.getTablePrefix() + "_", "");
    }

    @Override
    public String handlerId() {
        return "service";
    }

}
