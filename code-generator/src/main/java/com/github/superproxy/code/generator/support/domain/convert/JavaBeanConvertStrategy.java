package com.github.superproxy.code.generator.support.domain.convert;

import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.JavaBean;

public interface JavaBeanConvertStrategy {
    JavaBean convert(Domain domain);
}
