package com.github.superproxy.code.generator.support.domain.bean;

import com.github.superproxy.code.generator.core.modelgen.Model;

import java.util.List;

/**
 * 平台独立的模型，映射到JavaBean ，映射到Table，映射到UI Control
 * <p/>
 * 支持 table->domain
 * 支持 new domain
 */
public class Domain implements Model {
    private String name;
    private String comment;
    private List<DomainField> fieldList;
    private List<DomainField> pkFieldList;
    private DomainConfig domainConfig;
    private JavaBean javaBean;
    private TableInfo tableInfo;
    private UIModel uiModel;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UIModel getUiModel() {
        return uiModel;
    }

    public void setUiModel(UIModel uiModel) {
        this.uiModel = uiModel;
    }

    public DomainConfig getDomainConfig() {
        return domainConfig;
    }

    public void setDomainConfig(DomainConfig domainConfig) {
        this.domainConfig = domainConfig;
    }

    public List<DomainField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<DomainField> fieldList) {
        this.fieldList = fieldList;
    }

    public List<DomainField> getPkFieldList() {
        return pkFieldList;
    }

    public void setPkFieldList(List<DomainField> pkFieldList) {
        this.pkFieldList = pkFieldList;
    }

    public void setJavaBean(JavaBean javaBean) {
        this.javaBean = javaBean;
    }


    public TableInfo getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
    }

    public JavaBean getJavaBean() {
        return javaBean;
    }

}
