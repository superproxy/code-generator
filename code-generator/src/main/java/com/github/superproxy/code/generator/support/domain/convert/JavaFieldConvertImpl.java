package com.github.superproxy.code.generator.support.domain.convert;

import com.github.superproxy.code.generator.support.domain.bean.ColumnInfo;
import com.github.superproxy.code.generator.support.domain.bean.JavaField;
import com.github.superproxy.code.generator.util.StringUtils;

public class JavaFieldConvertImpl implements JavaFieldConvert {


    @Override
    public JavaField convert(final ColumnInfo column) {
        JavaField javaField = new JavaField();
        javaField.setJavaName(getJavaName(column));
        javaField.setSetName(getSetName(column));
        javaField.setGetName(getGetName(column));
        javaField.setJavaType(getJavaType(column));
        javaField.setShortJavaType(getJavaType(column));
        javaField.setComment(column.getColumnComment());
        return javaField;
    }


    public String getJavaName(ColumnInfo column) {
        // 下划线，去掉，然后首字母大写
        return StringUtils.removeUnderLineUpper(column.getColumnName());
    }

    public String getSetName(ColumnInfo column) {
        return "set" + StringUtils.upperFirst(StringUtils.removeUnderLineUpper(column.getColumnName()));
    }


    public String getGetName(ColumnInfo column) {
        return "get" + StringUtils.upperFirst(StringUtils.removeUnderLineUpper(column.getColumnName()));
    }

    public String getJavaType(ColumnInfo column) {
        return TypeMapper.getType(column.getColumnJdbcType()).getFullyQualifiedJavaType().getShortName();
    }

    public TypeMapper.JdbcTypeInformation getFullJavaType(ColumnInfo column) {
        return TypeMapper.getType(column.getColumnJdbcType());
    }
}
