package com.github.superproxy.code.generator.support.model.java.lang;

import com.github.superproxy.code.generator.core.bean.support.db2java.TypeMapper;

public interface JavaField {
    String getJavaName();

    String getSetName();

    String getGetName();

    TypeMapper.JdbcTypeInformation getJavaType();

    String getShortJavaType();

}
