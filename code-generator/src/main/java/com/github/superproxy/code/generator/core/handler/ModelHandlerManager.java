package com.github.superproxy.code.generator.core.handler;

import com.github.superproxy.code.generator.core.model.Model;

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

    public void handler(Model model, Map root) {
        for (ModelExtendHandler modelExtendHandler : modelExtendHandlerList) {
            Map extendMap = new HashMap();
            model.getExtra().put(modelExtendHandler.handlerId(), extendMap);
            modelExtendHandler.extendModel(model, extendMap);
        }
    }


}
