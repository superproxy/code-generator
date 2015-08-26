package com.suning.dal.generator.core.model.db2java.impl;

import com.suning.dal.generator.core.model.ModuleConfig;
import com.suning.dal.generator.core.model.db.TableInfo;
import com.suning.dal.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.suning.dal.generator.core.model.java.JavaBean;
import com.suning.dal.generator.util.StringUtils;

public class JavaBeanConvertStrategyImpl implements JavaBeanConvertStrategy {

    private ModuleConfig moduleConfig;

    public JavaBeanConvertStrategyImpl(ModuleConfig moduleConfig
    ) {
        this.moduleConfig = moduleConfig;
    }


    @Override
    public JavaBean convert(final TableInfo tableInfo) {
        return new JavaBean() {
            @Override
            public String getClassName() {
                return getString(tableInfo) + moduleConfig.getClassPostfix();
            }

            @Override
            public String getShortClassName() {
                return getString(tableInfo);
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

    private String getString(TableInfo tableInfo) {
        String name = tableInfo.getTableName();
        if (moduleConfig.getTablePrefix() != null) {
            name = tableInfo.getTableName().replace(moduleConfig.getTablePrefix(), "");
        }
        return StringUtils.upperFirst(StringUtils.removeUnderLineUpper(name));
    }
}
