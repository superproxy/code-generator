package com.github.superproxy.codegenerator.support.domain.convert;

import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.JavaBean;

public interface JavaBeanConvert {
    JavaBean convert(ComposeModel domain);
}
