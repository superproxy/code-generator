package com.github.superproxy.code.generator.support.domain.extend.java.ui;


import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.core.modelgen.ModelAndModelMapExtendHandler;
import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;
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
        ComposeModel dbJavaModel = (ComposeModel) model;
        UIModel uiModel = dbJavaModel.getUiModel();
        extend.put("ui", uiModel);
    }

    @Override
    public void extendModel(Model model) {
        ComposeModel domain = (ComposeModel) model;
        UIModel uiModel = buildUIModel(domain);
        domain.setUiModel(uiModel);
    }

    private UIModel buildUIModel(ComposeModel composeModel) {
        UIModel uiModel = new UIModel();
        for (DomainField field : composeModel.getDomain().getFieldList()) {
            UIElement element = new UIElement();
            element.setName(field.getName());
            element.setDisplayName(field.getDisplayName());
            element.setControlType(convert(field));
            element.setHtml(convertHtml(element));
            uiModel.addElement(element);
        }
        return uiModel;
    }

    String s = " <input class=\"required\" type=\"text\" id=\"${field.name}\" name=\"${field.name}\" value=\"\"\n" +
            "        readonly=\"${field.readonly}\">";

    String date = " <input type=\"text\" name=\"buyDate\" class=\"date\" dateFmt=\"yyyy-MM-dd HH:mm:ss\"\n" +
            "        class=\"required\" readonly=\"true\"/>\n" +
            "        <a class=\"inputDateButton\" href=\"javascript:;\">选择</a>";

    private String convertHtml(UIElement field) {
        if ("date".equals(field.getControlType())) {
            return date;
        } else {
            return s;
        }
    }

    /**
     * 返回控件类型
     *
     * @param field
     * @return
     */
    private String convert(DomainField field) {
        return "input";
    }

}
