package com.github.superproxy.code.generator.support.model.java.lang;

import com.github.superproxy.code.generator.source.db.ColumnInfo;

public interface JavaFieldConvertStrategy {

    JavaField convert(ColumnInfo columnSchema);

}
