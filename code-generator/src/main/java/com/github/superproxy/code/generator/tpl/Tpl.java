package com.github.superproxy.code.generator.tpl;

/**
 * 每个模版的描述信息
 */
public interface Tpl {
    String getTplPath();

    String getOutPath();

    String getId();
}