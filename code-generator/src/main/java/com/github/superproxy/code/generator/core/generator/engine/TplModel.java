package com.github.superproxy.code.generator.core.generator.engine;

import java.util.Map;

public interface TplModel {

    String getTplPath();

    String getTplsRoot();

    String getOutPath();

    Map getModelMap();
}
