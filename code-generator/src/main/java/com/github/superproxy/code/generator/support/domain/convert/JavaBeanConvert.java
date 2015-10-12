package com.github.superproxy.code.generator.support.domain.convert;

import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;
import com.github.superproxy.code.generator.support.domain.bean.JavaBean;

public interface JavaBeanConvert {
    JavaBean convert(ComposeModel domain);
}
