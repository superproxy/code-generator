package com.github.superproxy.code.generator.tpl;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;

/**
 * 每个模版的描述信息
 */
public interface Tpl {
    String getTplPath();

    String getOutPath(Model model);

    String getId();
}