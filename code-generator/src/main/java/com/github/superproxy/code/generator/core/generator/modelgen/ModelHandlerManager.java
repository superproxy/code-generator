package com.github.superproxy.code.generator.core.generator.modelgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模型扩展管理器
 */
public class ModelHandlerManager {
    private List<ModelMapExtendHandler> modelMapExtendHandlerList = new ArrayList<ModelMapExtendHandler>();

    public void registerHandler(ModelMapExtendHandler handler) {
        modelMapExtendHandlerList.add(handler);
    }

    public Map handler(Model model) {
        Map extendMap = new HashMap();
        for (ModelMapExtendHandler modelMapExtendHandler : modelMapExtendHandlerList) {
//            model.getExtra().put(modelMapExtendHandler
// .handlerId(), extendMap);
            modelMapExtendHandler.extendModelMap(model, extendMap);
        }
        return extendMap;
    }
}
