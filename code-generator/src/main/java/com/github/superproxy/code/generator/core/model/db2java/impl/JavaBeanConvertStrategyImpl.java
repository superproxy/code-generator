package com.github.superproxy.code.generator.core.model.db2java.impl;

import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.core.model.db.TableInfo;
import com.github.superproxy.code.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.github.superproxy.code.generator.core.model.java.JavaBean;
import com.github.superproxy.code.generator.util.StringUtils;

public class JavaBeanConvertStrategyImpl implements JavaBeanConvertStrategy {

    @Override
    public JavaBean convert(final TableInfo tableInfo, final MConfig mConfig) {
        return new JavaBean() {
            @Override
            public String getClassName() {
                return getString(tableInfo, mConfig) + mConfig.getClassPostfix();
            }

            @Override
            public String getShortClassName() {
                return getString(tableInfo, mConfig);
            }

            @Override
            public String getPackage() {
                if (StringUtils.isEmpty(mConfig.getModuleName())) {
                    return mConfig.getPackageName();
                } else {
                    return mConfig.getPackageName() + "." + mConfig.getModuleName();
                }
            }

            @Override
            public String getSerialVersionUID() {
                return String.valueOf(System.currentTimeMillis()).hashCode() + "L";
            }
        };

    }

    private String getString(TableInfo tableInfo, MConfig mConfig) {
        String name = tableInfo.getTableName();
        if (mConfig.getTablePrefix() != null) {
            name = tableInfo.getTableName().replace(mConfig.getTablePrefix(), "");
        }
        return StringUtils.upperFirst(StringUtils.removeUnderLineUpper(name));
    }
}
