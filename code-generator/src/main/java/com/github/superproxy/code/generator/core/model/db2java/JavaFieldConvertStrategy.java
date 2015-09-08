package com.github.superproxy.code.generator.core.model.db2java;

import com.github.superproxy.code.generator.core.model.db.ColumnInfo;
import com.github.superproxy.code.generator.core.model.java.JavaField;

public interface JavaFieldConvertStrategy {

    JavaField convert(ColumnInfo columnSchema);

}
