package com.github.superproxy.code.generator.core.bean.convert;

import com.github.superproxy.code.generator.support.model.DbJavaModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.source.db.ColumnInfo;
import com.github.superproxy.code.generator.source.db.TableInfo;
import com.github.superproxy.code.generator.support.model.java.lang.Field;
import com.github.superproxy.code.generator.support.model.java.lang.JavaBeanConvertStrategy;
import com.github.superproxy.code.generator.support.model.java.lang.JavaFieldConvertStrategy;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DbModelConvert {

    public static DbJavaModel convert(TableInfo tableInfo, DbJavaModelConfig dbJavaModelConfig, JavaFieldConvertStrategy javaFieldConvertStrategy,
                                JavaBeanConvertStrategy javaBeanConvertStrategy) {
        DbJavaModel dbJavaModel = new DbJavaModel();
        try {

            // 基础表信息
            BeanUtils.copyProperties(dbJavaModel, tableInfo);

            // 主键
            dbJavaModel.setPkColumnList(tableInfo.getPkColumnList());
            List<Field> pkFieldList = new ArrayList<Field>();
            for (ColumnInfo c : dbJavaModel.getPkColumnList()) {

                Field field = new Field(javaFieldConvertStrategy);
                BeanUtils.copyProperties(field, c);
                pkFieldList.add(field);
            }
            dbJavaModel.setPkFieldList(pkFieldList);


            //  非主键
            dbJavaModel.setColumnInfoList(tableInfo.getColumnInfoList());
            List<Field> fieldList = new ArrayList<Field>();
            for (ColumnInfo c : dbJavaModel.getColumnInfoList()) {

                Field field = new Field(javaFieldConvertStrategy);
                BeanUtils.copyProperties(field, c);
                fieldList.add(field);
            }
            dbJavaModel.setFieldList(fieldList);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dbJavaModel;
    }

}
