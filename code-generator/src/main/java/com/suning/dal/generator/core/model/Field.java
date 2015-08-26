package com.suning.dal.generator.core.model;

import com.suning.dal.generator.core.model.db.ColumnInfo;
import com.suning.dal.generator.core.model.db2java.JavaFieldConvertStrategy;
import com.suning.dal.generator.core.model.db2java.TypeMapper;
import com.suning.dal.generator.core.model.java.JavaField;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by 14120295 on 2014/12/30.
 */
public class Field extends ColumnInfo implements JavaField {
    JavaFieldConvertStrategy javaNameStrategy;


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
