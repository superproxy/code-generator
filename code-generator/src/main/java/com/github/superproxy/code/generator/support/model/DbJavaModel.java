package com.github.superproxy.code.generator.support.model;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.config.ModelConfig;
import com.github.superproxy.code.generator.source.db.ColumnInfo;
import com.github.superproxy.code.generator.source.db.TableInfo;
import com.github.superproxy.code.generator.support.model.java.lang.Field;

import java.util.List;

/**
 * 需要渲染的model
 * 方便模板引擎渲染
 */
public class DbJavaModel extends TableInfo implements Model {  // implements JavaBean {
    private List<Field> fieldList;
    private List<Field> pkFieldList;
//    private JavaBeanConvertStrategy javaBeanConvertStrategy;

    private ModelConfig modelConfig;

    public ModelConfig getModelConfig() {
        return modelConfig;
    }

    public void setModelConfig(ModelConfig modelConfig) {
        this.modelConfig = modelConfig;
    }

//    public String getShortClassName() {
//        return javaBeanConvertStrategy.convert(this, modelConfig).getShortClassName();
//    }
//
//    @Override
//    public String getPackage() {
//        return javaBeanConvertStrategy.convert(this, modelConfig).getPackage();
//    }


//    public Model(JavaBeanConvertStrategy javaBeanConvertStrategy, ModelConfig modelConfig) {
////        this.javaBeanConvertStrategy = javaBeanConvertStrategy;
//        this.modelConfig = modelConfig;
//    }


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

//    /**
//     * 全名
//     *
//     * @return
//     */
//    @Override
//    public String getClassName() {
//        return javaBeanConvertStrategy.convert(this, modelConfig).getClassName();
//    }
//
//    @Override
//    public String getSerialVersionUID() {
//        return javaBeanConvertStrategy.convert(this, modelConfig).getSerialVersionUID();
//
//    }

//    public JavaBeanConvertStrategy getJavaBeanConvertStrategy() {
//        return javaBeanConvertStrategy;
//    }
//
//    public void setJavaBeanConvertStrategy(JavaBeanConvertStrategy javaBeanConvertStrategy) {
//        this.javaBeanConvertStrategy = javaBeanConvertStrategy;
//    }

    public List<Field> getPkFieldList() {
        return pkFieldList;
    }

    public void setPkFieldList(List<Field> pkFieldList) {
        this.pkFieldList = pkFieldList;
    }

}
