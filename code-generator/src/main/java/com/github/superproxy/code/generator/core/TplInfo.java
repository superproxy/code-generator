package com.github.superproxy.code.generator.core;

import java.util.Map;

public interface TplInfo {

    String getTplPath();

    String getTplRoot();

    String getOutPath();

    Map getModel();
}
