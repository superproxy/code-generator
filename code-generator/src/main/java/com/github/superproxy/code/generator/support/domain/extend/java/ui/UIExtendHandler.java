package com.github.superproxy.code.generator.support.domain.extend.java.ui;


import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.core.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.DomainField;
import com.github.superproxy.code.generator.support.domain.bean.UIElement;
import com.github.superproxy.code.generator.support.domain.bean.UIModel;

import java.util.Map;

public class UIExtendHandler implements ModelAndModelMapExtendHandler {


    @Override
    public String handlerId() {
        return "ui";
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        Domain dbJavaModel = (Domain) model;
        UIModel uiModel = dbJavaModel.getUiModel();
        extend.put("ui", uiModel);
    }

    @Override
    public void extendModel(Model model) {
        Domain domain = (Domain) model;
        UIModel uiModel = buildUIModel(domain);
        domain.setUiModel(uiModel);
    }

    private UIModel buildUIModel(Domain domain) {
        UIModel uiModel = new UIModel();
        for (DomainField field : domain.getFieldList()) {
            UIElement element = new UIElement();
            element.setName(field.getName());
            element.setDisplayName(field.getDisplayName());
            element.setControlType(convet(field));
            uiModel.addElement(element);
        }
        return uiModel;
    }

    /**
     * 返回控件类型
     *
     * @param field
     * @return
     */
    private String convet(DomainField field) {
        return "input";
    }

}
