package com.github.superproxy.code.generator.support.model.java.lang;

import com.github.superproxy.code.generator.support.model.CommonModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.source.db.TableInfo;
import com.github.superproxy.code.generator.util.StringUtils;

public class JavaBeanConvertStrategyImpl implements JavaBeanConvertStrategy {
    @Override
    public JavaBean convert(CommonModel commonModel) {
        final TableInfo tableInfo = commonModel;
        final DbJavaModelConfig dbJavaModelConfig = commonModel.getDbJavaModelConfig();
        return new JavaBean() {
                    @Override
                    public String getClassName() {
                        return getString(tableInfo, dbJavaModelConfig) + dbJavaModelConfig.getClassPostfix();
                    }

                    @Override
                    public String getShortClassName() {
                        return getString(tableInfo, dbJavaModelConfig);
                    }

                    @Override
                    public String getPackage() {
                        if (StringUtils.isEmpty(dbJavaModelConfig.getModuleName())) {
                            return dbJavaModelConfig.getPackageName();
                        } else {
                            return dbJavaModelConfig.getPackageName() + "." + dbJavaModelConfig.getModuleName();
                        }
                    }

                    @Override
                    public String getSerialVersionUID() {
                        return String.valueOf(System.currentTimeMillis()).hashCode() + "L";
                    }
                };

    }

    private String getString(TableInfo tableInfo, DbJavaModelConfig dbJavaModelConfig) {
        String name = tableInfo.getTableName();
        if (dbJavaModelConfig.getTablePrefix() != null) {
            name = tableInfo.getTableName().replace(dbJavaModelConfig.getTablePrefix(), "");
        }
        return StringUtils.upperFirst(StringUtils.removeUnderLineUpper(name));
    }
}
