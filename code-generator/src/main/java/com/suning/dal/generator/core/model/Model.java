package com.suning.dal.generator.core.model;

import com.suning.dal.generator.core.model.db.ColumnInfo;
import com.suning.dal.generator.core.model.db.TableInfo;
import com.suning.dal.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.suning.dal.generator.core.model.java.JavaBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14120295 on 2014/12/30.
 * 需要渲染的model
 */
public class Model extends TableInfo implements JavaBean {
    private List<Field> fieldList;
    private List<Field> pkFieldList;
    private JavaBeanConvertStrategy javaBeanConvertStrategy;


//    private String className;
//    private String shortClassName;

    public String getShortClassName() {
        return javaBeanConvertStrategy.convert(this).getShortClassName();
    }

    @Override
    public String getPackage() {
        return javaBeanConvertStrategy.convert(this).getPackage();
    }

    private Map extra = new HashMap();

    /**
     * 扩展的信息
     *
     * @return
     */
    public Map getExtra() {
        return extra;
    }

    public void setExtra(Map extra) {
        this.extra = extra;
    }

    public Model(JavaBeanConvertStrategy javaBeanConvertStrategy) {
        this.javaBeanConvertStrategy = javaBeanConvertStrategy;
    }


    public Field getFied(ColumnInfo columnInfo) {
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

    /**
     * 全名
     *
     * @return
     */
    @Override
    public String getClassName() {
        return javaBeanConvertStrategy.convert(this).getClassName();
    }

    @Override
    public String getSerialVersionUID() {
        return javaBeanConvertStrategy.convert(this).getSerialVersionUID();

    }

    public JavaBeanConvertStrategy getJavaBeanConvertStrategy() {
        return javaBeanConvertStrategy;
    }

    public void setJavaBeanConvertStrategy(JavaBeanConvertStrategy javaBeanConvertStrategy) {
        this.javaBeanConvertStrategy = javaBeanConvertStrategy;
    }

    public List<Field> getPkFieldList() {
        return pkFieldList;
    }

    public void setPkFieldList(List<Field> pkFieldList) {
        this.pkFieldList = pkFieldList;
    }

}
