package com.github.superproxy.code.generator.support.domain.rules.model;

import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.DomainConfig;
import com.github.superproxy.code.generator.tpl.Tpl;

import java.io.File;

public class ModelTpl implements Tpl {

    @Override
    public String getTplPath() {
        return "Model.ftl";
    }

    @Override
    public String getOutPath(Model model) {
        Domain domain = (Domain) model;
        DomainConfig modelConfig = domain.getDomainConfig();
        String pkgDir = modelConfig.getOutPath();
        pkgDir += File.separator + modelConfig.getPackageName().replace(".", File.separator);
        String module = modelConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + modelConfig.getModuleName();
        }

        new File(pkgDir).mkdirs();
        return pkgDir + File.separator + domain.getJavaBean().getClassName() + ".java";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
