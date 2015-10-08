package com.github.superproxy.code.generator.support.model.java.lang;

import com.github.superproxy.code.generator.core.bean.support.db2java.TypeMapper;
import com.github.superproxy.code.generator.source.db.ColumnInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Field extends ColumnInfo implements JavaField {
    private JavaFieldConvertStrategy javaNameStrategy;


    public Field(JavaFieldConvertStrategy javaNameStrategy) {
        this.javaNameStrategy = javaNameStrategy;
    }

    @Override
    public String getJavaName() {
        return javaNameStrategy.convert(this).getJavaName();
    }

    @Override
    public String getSetName() {
        return javaNameStrategy.convert(this).getSetName();
    }

    @Override
    public String getGetName() {
        return javaNameStrategy.convert(this).getGetName();
    }

    @Override
    public TypeMapper.JdbcTypeInformation getJavaType() {
        return javaNameStrategy.convert(this).getJavaType();
    }

    @Override
    public String getShortJavaType() {
        return javaNameStrategy.convert(this).getShortJavaType();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
