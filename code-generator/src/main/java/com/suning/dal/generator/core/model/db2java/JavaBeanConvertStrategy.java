package com.suning.dal.generator.core.model.db2java;

import com.suning.dal.generator.core.model.db.TableInfo;
import com.suning.dal.generator.core.model.java.JavaBean;

public interface JavaBeanConvertStrategy {

    JavaBean convert(TableInfo tableInfo);
}
