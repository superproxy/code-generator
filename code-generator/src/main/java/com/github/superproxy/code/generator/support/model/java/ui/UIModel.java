package com.github.superproxy.code.generator.support.model.java.ui;

/**
 * UI相关模型
 */
public class UIModel {

    String name;
    String displayName;

    String controlType;

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
