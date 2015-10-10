package com.github.superproxy.code.generator.core.bean.convert;

import com.github.superproxy.code.generator.support.model.CommonModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.source.db.ColumnInfo;
import com.github.superproxy.code.generator.source.db.TableInfo;
import com.github.superproxy.code.generator.support.model.java.lang.CommonField;
import com.github.superproxy.code.generator.support.model.java.lang.JavaBeanConvertStrategy;
import com.github.superproxy.code.generator.support.model.java.lang.JavaFieldConvertStrategy;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DbModelConvert {

    public static CommonModel convert(TableInfo tableInfo, DbJavaModelConfig dbJavaModelConfig, JavaFieldConvertStrategy javaFieldConvertStrategy,
                                JavaBeanConvertStrategy javaBeanConvertStrategy) {
        CommonModel commonModel = new CommonModel();
        try {

            // 基础表信息
            BeanUtils.copyProperties(commonModel, tableInfo);

            // 主键
            commonModel.setPkColumnList(tableInfo.getPkColumnList());
            List<CommonField> pkFieldList = new ArrayList<CommonField>();
            for (ColumnInfo c : commonModel.getPkColumnList()) {

                CommonField field = new CommonField(javaFieldConvertStrategy);
                BeanUtils.copyProperties(field, c);
                pkFieldList.add(field);
            }
            commonModel.setPkFieldList(pkFieldList);


            //  非主键
            commonModel.setColumnInfoList(tableInfo.getColumnInfoList());
            List<CommonField> fieldList = new ArrayList<CommonField>();
            for (ColumnInfo c : commonModel.getColumnInfoList()) {

                CommonField field = new CommonField(javaFieldConvertStrategy);
                BeanUtils.copyProperties(field, c);
                fieldList.add(field);
            }
            commonModel.setFieldList(fieldList);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return commonModel;
    }

}
