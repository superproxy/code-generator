package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.source.db.ColumnInfo;
import com.github.superproxy.code.generator.source.db.TableInfo;
import com.github.superproxy.code.generator.support.model.java.lang.Field;

import java.util.List;

/**
 * 模型1
 *
 */
public class DbJavaModel extends TableInfo implements Model {  // implements JavaBean {
    private List<Field> fieldList;
    private List<Field> pkFieldList;
    private DbJavaModelConfig dbJavaModelConfig;

    public DbJavaModelConfig getDbJavaModelConfig() {
        return dbJavaModelConfig;
    }

    public void setDbJavaModelConfig(DbJavaModelConfig dbJavaModelConfig) {
        this.dbJavaModelConfig = dbJavaModelConfig;
    }

    public Field buildField(ColumnInfo columnInfo) {
        for (Field field : pkFieldList) {
            if (columnInfo.getColumnName().equals(field.getColumnName())) {
                System.out.println(field);
                return field;
            }
        }

        for (Field field : fieldList) {
            if (columnInfo.getColumnName().equals(field.getColumnName())) {
                System.out.println(field);
                return field;
            }

        }
        return null;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }




    public List<Field> getPkFieldList() {
        return pkFieldList;
    }

    public void setPkFieldList(List<Field> pkFieldList) {
        this.pkFieldList = pkFieldList;
    }

}
