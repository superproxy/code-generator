package com.suning.dal.generator.core.handler;

import com.suning.dal.generator.core.model.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 扩展管理器
 */
public class HandlerManager {
    private List<ExtendHandler> extendHandlerList = new ArrayList<ExtendHandler>();

    public void registerHandler(ExtendHandler handler) {
        extendHandlerList.add(handler);
    }

    public void handler(Model model, Map root) {
        for (ExtendHandler extendHandler : extendHandlerList) {
            Map extendMap = new HashMap();
            model.getExtra().put(extendHandler.handlerId(), extendMap);
            extendHandler.extendModel(model, extendMap);
        }
    }


}
