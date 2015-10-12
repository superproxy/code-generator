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

}
