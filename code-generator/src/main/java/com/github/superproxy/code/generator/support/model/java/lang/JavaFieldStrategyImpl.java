package com.github.superproxy.code.generator.support.model.java.lang;

import com.github.superproxy.code.generator.source.db.ColumnInfo;
import com.github.superproxy.code.generator.core.bean.support.db2java.TypeMapper;
import com.github.superproxy.code.generator.util.StringUtils;

public class JavaFieldStrategyImpl implements JavaFieldConvertStrategy {
    @Override
    public JavaField convert(final ColumnInfo column) {

        return new JavaField() {
            @Override
            public String getJavaName() {
                // 下划线，去掉，然后首字母大写
                return StringUtils.removeUnderLineUpper(column.getColumnName());
            }

            @Override
            public String getSetName() {
                return "set"+ StringUtils.upperFirst(StringUtils.removeUnderLineUpper(column.getColumnName()));
            }

            @Override
            public String getGetName() {
                return "get"+ StringUtils.upperFirst(StringUtils.removeUnderLineUpper(column.getColumnName()));
            }

            @Override
            public TypeMapper.JdbcTypeInformation getJavaType() {
                return   TypeMapper.getType(column.getColumnJdbcType());
            }

            @Override
            public String getShortJavaType() {
                return   TypeMapper.getType(column.getColumnJdbcType()).getFullyQualifiedJavaType().getShortName();
            }
        };

    }
}
