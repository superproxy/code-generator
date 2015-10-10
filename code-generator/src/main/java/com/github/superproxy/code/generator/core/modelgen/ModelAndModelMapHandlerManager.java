package com.github.superproxy.code.generator.core.modelgen;

import java.util.*;

/**
 * 模型扩展管理器
 */
public class ModelAndModelMapHandlerManager {
    private List<ModelMapExtendHandler> modelMapExtendHandlerList = new ArrayList<ModelMapExtendHandler>();
    private List<ModelExtendHandler> modelExtendHandlerList = new ArrayList<ModelExtendHandler>();

    public void registerModelMapHandler(ModelMapExtendHandler handler) {
        modelMapExtendHandlerList.add(handler);
    }

    public void registerModelHandler(ModelExtendHandler handler) {
        modelExtendHandlerList.add(handler);
    }

    public void extendModel(Model model) {
        for (ModelExtendHandler modelMapExtendHandler : modelExtendHandlerList) {
            modelMapExtendHandler.extendModel(model);
        }
    }

    public Map extendMap(Model model) {
        Map extendMap = new HashMap();
        for (ModelMapExtendHandler modelMapExtendHandler : modelMapExtendHandlerList) {
//            model.getExtra().put(modelMapExtendHandler.handlerId(), extendMap);
            modelMapExtendHandler.extendModelMap(model, extendMap);
        }

        Set<Map.Entry<Object, Object>> set = extendMap.entrySet();
        for (Map.Entry<Object, Object> entry : set) {
            System.out.println("key:" + entry.getKey() + "  value:" + entry.getValue());
        }
        return extendMap;
    }


}
