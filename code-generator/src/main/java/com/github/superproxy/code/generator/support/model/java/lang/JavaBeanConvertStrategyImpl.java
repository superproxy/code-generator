package com.github.superproxy.code.generator.support.model.java.lang;

import com.github.superproxy.code.generator.support.model.DbJavaModel;
import com.github.superproxy.code.generator.config.ModelConfig;
import com.github.superproxy.code.generator.source.db.TableInfo;
import com.github.superproxy.code.generator.util.StringUtils;

public class JavaBeanConvertStrategyImpl implements JavaBeanConvertStrategy {
    @Override
    public JavaBean convert(DbJavaModel dbJavaModel) {
        final TableInfo tableInfo = dbJavaModel;
        final ModelConfig modelConfig =null; // model.getModelConfig();
        return new

                JavaBean() {
                    @Override
                    public String getClassName() {
                        return getString(tableInfo, modelConfig) + modelConfig.getClassPostfix();
                    }

                    @Override
                    public String getShortClassName() {
                        return getString(tableInfo, modelConfig);
                    }

                    @Override
                    public String getPackage() {
                        if (StringUtils.isEmpty(modelConfig.getModuleName())) {
                            return modelConfig.getPackageName();
                        } else {
                            return modelConfig.getPackageName() + "." + modelConfig.getModuleName();
                        }
                    }

                    @Override
                    public String getSerialVersionUID() {
                        return String.valueOf(System.currentTimeMillis()).hashCode() + "L";
                    }
                };

    }

    private String getString(TableInfo tableInfo, ModelConfig modelConfig) {
        String name = tableInfo.getTableName();
        if (modelConfig.getTablePrefix() != null) {
            name = tableInfo.getTableName().replace(modelConfig.getTablePrefix(), "");
        }
        return StringUtils.upperFirst(StringUtils.removeUnderLineUpper(name));
    }
}
