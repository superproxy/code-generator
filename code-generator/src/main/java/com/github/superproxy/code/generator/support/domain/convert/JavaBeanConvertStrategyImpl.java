package com.github.superproxy.code.generator.support.domain.convert;

import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.DomainConfig;
import com.github.superproxy.code.generator.support.domain.bean.JavaBean;
import com.github.superproxy.code.generator.support.domain.bean.TableInfo;
import com.github.superproxy.code.generator.util.StringUtils;

public class JavaBeanConvertStrategyImpl implements JavaBeanConvertStrategy {
    @Override
    public JavaBean convert(Domain domain) {
        final TableInfo tableInfo = domain.getTableInfo();
        final DomainConfig domainConfig = domain.getDomainConfig();
        return new JavaBean() {
            public String getClassName() {
                return getString(tableInfo, domainConfig) + domainConfig.getClassPostfix();
            }

            public String getShortClassName() {
                return getString(tableInfo, domainConfig);
            }

            public String getPackageName() {
                if (StringUtils.isEmpty(domainConfig.getModuleName())) {
                    return domainConfig.getPackageName();
                } else {
                    return domainConfig.getPackageName() + "." + domainConfig.getModuleName();
                }
            }

            public String getSerialVersionUID() {
                return String.valueOf(System.currentTimeMillis()).hashCode() + "L";
            }
        };

    }

    private String getString(TableInfo tableInfo, DomainConfig domainConfig) {
        String name = tableInfo.getTableName();
        if (domainConfig.getTablePrefix() != null) {
            name = tableInfo.getTableName().replace(domainConfig.getTablePrefix(), "");
        }
        return StringUtils.upperFirst(StringUtils.removeUnderLineUpper(name));
    }
}
