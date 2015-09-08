package com.github.superproxy.code.generator.plugins.service;


import com.github.superproxy.code.generator.core.model.Model;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.MConfig;

import java.util.Map;

public class ServiceExtendHandler implements ModelExtendHandler {
    private MConfig mConfig;

    public ServiceExtendHandler(MConfig mConfig) {
        this.mConfig = mConfig;
    }

    @Override
    public void extendModel(Model model, Map sqlMap) {
        sqlMap.put("name", getSqlMapName(model));
    }

    private String getSqlMapName(Model model) {
        return model.getTableName().replace(mConfig.getTablePrefix() + "_", "");
    }

    @Override
    public String handlerId() {
        return "service";
    }

}
