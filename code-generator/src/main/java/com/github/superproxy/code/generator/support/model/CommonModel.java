package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.source.db.ColumnInfo;
import com.github.superproxy.code.generator.source.db.TableInfo;
import com.github.superproxy.code.generator.support.model.java.lang.CommonField;
import com.github.superproxy.code.generator.support.model.java.lang.JavaBean;
import com.github.superproxy.code.generator.support.model.java.ui.UIModel;

import java.util.List;

/**
 * 独立模型，映射到JavaBean ，映射到Table，映射到UI Control
 */
public class CommonModel extends TableInfo implements Model {  // implements JavaBean {
    private List<CommonField> fieldList;
    private List<CommonField> pkFieldList;
    private DbJavaModelConfig dbJavaModelConfig;
    private UIModel uiModel;

    public DbJavaModelConfig getDbJavaModelConfig() {
        return dbJavaModelConfig;
    }

    public void setDbJavaModelConfig(DbJavaModelConfig dbJavaModelConfig) {
        this.dbJavaModelConfig = dbJavaModelConfig;
    }

    public CommonField buildField(ColumnInfo columnInfo) {
        for (CommonField field : pkFieldList) {
            if (columnInfo.getColumnName().equals(field.getColumnName())) {
                System.out.println(field);
                return field;
            }
        }

        for (CommonField field : fieldList) {
            if (columnInfo.getColumnName().equals(field.getColumnName())) {
                System.out.println(field);
                return field;
            }

        }
        return null;
    }

    public List<CommonField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<CommonField> fieldList) {
        this.fieldList = fieldList;
    }


    public List<CommonField> getPkFieldList() {
        return pkFieldList;
    }

    public void setPkFieldList(List<CommonField> pkFieldList) {
        this.pkFieldList = pkFieldList;
    }

    public void setJavaBean(JavaBean javaBean) {
        this.javaBean = javaBean;
    }

    private JavaBean javaBean;
    private TableInfo tableInfo;

    public TableInfo getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
    }

    public JavaBean getJavaBean() {
        return javaBean;
    }

    public void setUIModel(UIModel uiModel) {
        this.uiModel = uiModel;
    }
}
