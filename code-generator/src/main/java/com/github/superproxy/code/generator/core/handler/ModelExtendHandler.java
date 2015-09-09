package com.github.superproxy.code.generator.core.handler;

import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.core.model.Model;

import java.util.Map;

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
     * 对Model额外的信息处理，不同的handler支持不同的类型
     *
     * @param mConfig
     * @param model
     * @param root
     */
    void extendModel(MConfig mConfig, Model model, Map root);
}
