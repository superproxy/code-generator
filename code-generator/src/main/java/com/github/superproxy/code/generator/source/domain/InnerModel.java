package com.github.superproxy.code.generator.source.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 需要渲染的model
 * <p/>
 * 独立的中间模型，不依赖数据库，不依赖语言
 * <p/>
 * 能够转换成不同数据的库数据类型
 * 能够转换成java
 */
public class InnerModel {
    //  tableInfo
    //  language
    //  innerMode

    /**
     * 名称
     */
    private String domainName;

    /**
     * 描述
     */
    private String doaminDescption;
    private List<InnerField> innerFieldList = new ArrayList<InnerField>();

    public String getDoaminDescption() {
        return doaminDescption;
    }

    public void setDoaminDescption(String doaminDescption) {
        this.doaminDescption = doaminDescption;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public List<InnerField> getInnerFieldList() {
        return innerFieldList;
    }

    public void setInnerFieldList(List<InnerField> innerFieldList) {
        this.innerFieldList = innerFieldList;
    }
}
