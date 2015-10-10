package com.github.superproxy.code.generator.support.domain.convert;

import com.github.superproxy.code.generator.support.domain.bean.JavaField;
import com.github.superproxy.code.generator.support.domain.bean.ColumnInfo;

public interface JavaFieldConvertStrategy {

    JavaField convert(ColumnInfo columnSchema);

}
