package com.github.superproxy.code.generator.core.modelgen;


/**
 * 扩展模型处理
 */
public interface ModelExtendHandler {
    /**
     * 扩展ID
     *
     * @return
     */
    String handlerId();
    /**
     * 扩展模型
     *
     * @param model
     */
    void extendModel(Model model);
}
