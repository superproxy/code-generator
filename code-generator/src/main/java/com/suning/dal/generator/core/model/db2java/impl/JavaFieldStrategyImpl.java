package com.suning.dal.generator.core.model.db2java.impl;

import com.suning.dal.generator.core.model.db.ColumnInfo;
import com.suning.dal.generator.core.model.db2java.JavaFieldConvertStrategy;
import com.suning.dal.generator.core.model.db2java.TypeMapper;
import com.suning.dal.generator.core.model.java.JavaField;
import com.suning.dal.generator.util.StringUtils;

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
