package com.github.superproxy.codegenerator.support.domain.rules.service;

import com.github.superproxy.codegenerator.core.generator.modelgen.Model;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.DomainConfig;
import com.github.superproxy.codegenerator.core.tpl.Tpl;

import java.io.File;

public class ServiceTpl implements Tpl {

    public ServiceTpl() {
    }

    @Override
    public String getTplPath() {
        return "Service.ftl";
    }

    @Override
    public String getOutPath(Model model) {
        ComposeModel domain = (ComposeModel) model;
        DomainConfig modelConfig = domain.getDomainConfig();
        String pkgDir = modelConfig.getOutPath();

        pkgDir += File.separator + modelConfig.getPackageName().replace(".", File.separator);
        String module = modelConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + modelConfig.getModuleName();
        }
        new File(pkgDir).mkdirs();
        return pkgDir + File.separator +  domain.getJavaBean().getClassName() + ".java";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }

}
