package com.github.superproxy.code.generator.core.model.db2java;

import com.github.superproxy.code.generator.core.model.ModuleConfig;
import com.github.superproxy.code.generator.core.model.db.TableInfo;
import com.github.superproxy.code.generator.core.model.java.JavaBean;

public interface JavaBeanConvertStrategy {

    JavaBean convert(TableInfo tableInfo, ModuleConfig moduleConfig);
}
