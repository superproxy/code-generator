package com.suning.dal.generator.core.model.java;

import com.suning.dal.generator.core.model.db2java.TypeMapper;

/**
 * Created by 14120295 on 2014/12/30.
 */
public interface JavaField {
    String getJavaName();

    String getSetName();

    String getGetName();

    TypeMapper.JdbcTypeInformation getJavaType();

    String getShortJavaType();

}
