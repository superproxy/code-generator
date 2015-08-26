package com.suning.dal.generator.core.handler;

import com.suning.dal.generator.core.model.Model;

import java.util.Map;

/**
 * 扩展模型处理
 */
public interface ExtendHandler {
    /**
     * 扩展ID
     *
     * @return
     */
    String handlerId();

    /**
     * 对Model额外的信息处理，不同的handler支持不同的类型
     *
     * @param model
     * @param root
     */
    void extendModel(Model model, Map root);
}
