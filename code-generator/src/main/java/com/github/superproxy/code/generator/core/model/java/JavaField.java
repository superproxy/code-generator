package com.github.superproxy.code.generator.core.model.java;

import com.github.superproxy.code.generator.core.model.db2java.TypeMapper;

public interface JavaField {
    String getJavaName();

    String getSetName();

    String getGetName();

    TypeMapper.JdbcTypeInformation getJavaType();

    String getShortJavaType();

}
