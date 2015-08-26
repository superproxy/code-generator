package com.suning.dal.generator.core.model.db2java;

import com.suning.dal.generator.core.model.db.ColumnInfo;
import com.suning.dal.generator.core.model.java.JavaField;

public interface JavaFieldConvertStrategy {

    JavaField convert(ColumnInfo columnSchema);

}
