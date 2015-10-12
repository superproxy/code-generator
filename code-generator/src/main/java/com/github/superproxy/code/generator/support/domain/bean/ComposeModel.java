package com.github.superproxy.code.generator.support.domain.bean;

import com.github.superproxy.code.generator.core.modelgen.Model;

/**
 * 平台独立的模型，映射到JavaBean ，映射到Table，映射到UI Control
 * <p/>
 * 支持 table->domain
 * 支持 new domain
 */
public class ComposeModel implements Model {
    private DomainConfig domainConfig;

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    private Domain domain;
    private JavaBean javaBean;
    private TableInfo tableInfo;
    private UIModel uiModel;

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
