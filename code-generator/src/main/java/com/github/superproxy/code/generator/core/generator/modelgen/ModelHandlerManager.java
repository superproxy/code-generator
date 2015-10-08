package com.github.superproxy.code.generator.core.generator.modelgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模型扩展管理器
 */
public class ModelHandlerManager {
    private List<ModelExtendHandler> modelExtendHandlerList = new ArrayList<ModelExtendHandler>();

    public void registerHandler(ModelExtendHandler handler) {
        modelExtendHandlerList.add(handler);
    }

    public Map handler(Model model) {
        Map extendMap = new HashMap();
        for (ModelExtendHandler modelExtendHandler : modelExtendHandlerList) {
//            model.getExtra().put(modelExtendHandler.handlerId(), extendMap);
            modelExtendHandler.extendModel(model, extendMap);
        }
        return extendMap;
    }
}
