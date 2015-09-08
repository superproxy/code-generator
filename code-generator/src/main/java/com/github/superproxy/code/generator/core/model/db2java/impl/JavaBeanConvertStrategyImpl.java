package com.github.superproxy.code.generator.core.model.db2java.impl;

import com.github.superproxy.code.generator.core.model.ModuleConfig;
import com.github.superproxy.code.generator.core.model.db.TableInfo;
import com.github.superproxy.code.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.github.superproxy.code.generator.core.model.java.JavaBean;
import com.github.superproxy.code.generator.util.StringUtils;

public class JavaBeanConvertStrategyImpl implements JavaBeanConvertStrategy {

    @Override
    public JavaBean convert(final TableInfo tableInfo, final ModuleConfig moduleConfig) {
        return new JavaBean() {
            @Override
            public String getClassName() {
                return getString(tableInfo, moduleConfig) + moduleConfig.getClassPostfix();
            }

            @Override
            public String getShortClassName() {
                return getString(tableInfo, moduleConfig);
            }

            @Override
            public String getPackage() {
                if (StringUtils.isEmpty(moduleConfig.getModuleName())) {
                    return moduleConfig.getPackageName();
                } else {
                    return moduleConfig.getPackageName() + "." + moduleConfig.getModuleName();
                }
            }

            @Override
            public String getSerialVersionUID() {
                return String.valueOf(System.currentTimeMillis()).hashCode() + "L";
            }
        };

    }

    private String getString(TableInfo tableInfo, ModuleConfig moduleConfig) {
        String name = tableInfo.getTableName();
        if (moduleConfig.getTablePrefix() != null) {
            name = tableInfo.getTableName().replace(moduleConfig.getTablePrefix(), "");
        }
        return StringUtils.upperFirst(StringUtils.removeUnderLineUpper(name));
    }
}
