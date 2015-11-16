package com.github.superproxy.codegenerator.support.domain.rules.sqlmap;

import com.github.superproxy.codegenerator.core.generator.modelgen.Model;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.DomainConfig;
import com.github.superproxy.codegenerator.core.tpl.Tpl;

import java.io.File;

public class SqlMapTpl implements Tpl {

    public SqlMapTpl() {
    }

    @Override
    public String getTplPath() {
        return "SqlMap.ftl";
    }


    @Override
    public String getOutPath(Model model) {
        ComposeModel domain = (ComposeModel) model;
        DomainConfig modelConfig = domain.getDomainConfig();
        String pkgDir = modelConfig.getOutPath();
        String module = modelConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + modelConfig.getModuleName();
        }

//        pkgDir += File.separator + projectConfig.getPackageName().replace(".", File.separator);
        new File(pkgDir).mkdirs();
        return pkgDir + File.separator + "sqlMap_" +
                domain.getJavaBean().getShortClassName().substring(0, 1).toLowerCase() +
                domain.getJavaBean().getShortClassName().substring(1) + ".xml";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
