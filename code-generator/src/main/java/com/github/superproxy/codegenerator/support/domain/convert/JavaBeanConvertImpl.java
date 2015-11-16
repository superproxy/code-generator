package com.github.superproxy.codegenerator.support.domain.convert;

import com.github.superproxy.codegenerator.support.domain.bean.*;
import com.github.superproxy.codegenerator.util.StringUtils;

public class JavaBeanConvertImpl implements JavaBeanConvert {

    public JavaBeanConvertImpl() {

    }

    public JavaBeanConvertImpl(JavaFieldConvert javaFieldConvert) {
        this.javaFieldConvert = javaFieldConvert;

    }

    JavaFieldConvert javaFieldConvert;

    public JavaFieldConvert getJavaFieldConvert() {
        return javaFieldConvert;
    }

    public void setJavaFieldConvert(JavaFieldConvert javaFieldConvert) {
        this.javaFieldConvert = javaFieldConvert;
    }

    @Override
    public JavaBean convert(ComposeModel domain) {
        final TableInfo tableInfo = domain.getTableInfo();
        final DomainConfig domainConfig = domain.getDomainConfig();

        JavaBean javaBean = new JavaBean();

        String className = getString(tableInfo, domainConfig) + domainConfig.getClassPostfix();
        javaBean.setClassName(className);
        javaBean.setShortClassName(getString(tableInfo, domainConfig));
        javaBean.setPackageName(getName(domainConfig));
        javaBean.setSerialVersionUID(getSerialVersionUID());

        for (ColumnInfo columnInfo : tableInfo.getAllColumnInfoList()) {
            JavaField javaField = javaFieldConvert.convert(columnInfo);

            javaBean.addJavaField(javaField);
        }

        return javaBean;
    }

    private String getName(DomainConfig domainConfig) {
        if (StringUtils.isEmpty(domainConfig.getModuleName())) {
            return domainConfig.getPackageName();
        } else {
            return domainConfig.getPackageName() + "." + domainConfig.getModuleName();
        }
    }

    public String getSerialVersionUID() {
        return String.valueOf(System.currentTimeMillis()).hashCode() + "L";
    }

    private String getString(TableInfo tableInfo, DomainConfig domainConfig) {
        String name = tableInfo.getTableName();
        if (domainConfig.getTablePrefix() != null) {
            name = tableInfo.getTableName().replace(domainConfig.getTablePrefix(), "");
        }
        return StringUtils.upperFirst(StringUtils.removeUnderLineUpper(name));
    }
}
