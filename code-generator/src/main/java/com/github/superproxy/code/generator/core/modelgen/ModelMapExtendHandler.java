package com.github.superproxy.code.generator.core.modelgen;


import java.util.Map;

/**
 * 扩展模型处理
 */
public interface ModelMapExtendHandler {
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
     * @param extend
     */
    void extendModelMap(Model model, Map extend);
}
