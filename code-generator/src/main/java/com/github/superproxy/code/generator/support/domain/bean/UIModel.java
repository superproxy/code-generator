package com.github.superproxy.code.generator.support.domain.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * UI相关模型
 */
public class UIModel {

    List<UIElement> elementList = new ArrayList<UIElement>();

    public List<UIElement> getElementList() {
        return elementList;
    }

    public void setElementList(List<UIElement> elementList) {
        this.elementList = elementList;
    }

    public void addElement(UIElement element) {
        elementList.add(element);
    }
}
