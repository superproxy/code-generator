package com.github.superproxy.codegenerator.support.domain.convert;

import com.github.superproxy.codegenerator.support.domain.bean.JavaField;
import com.github.superproxy.codegenerator.support.domain.bean.ColumnInfo;

public interface JavaFieldConvert {

    JavaField convert(ColumnInfo columnSchema);

}
