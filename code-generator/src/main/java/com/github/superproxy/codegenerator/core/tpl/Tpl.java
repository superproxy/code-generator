package com.github.superproxy.codegenerator.core.tpl;

import com.github.superproxy.codegenerator.core.generator.modelgen.Model;

/**
 * 每个模版的描述信息
 */
public interface Tpl {
    String getTplPath();

    String getOutPath(Model model);

    String getId();
}