package com.github.superproxy.codegenerator.support.domain.rules.dao;

import com.github.superproxy.codegenerator.config.ModulePartConfig;
import com.github.superproxy.codegenerator.core.generator.modelgen.Model;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.DomainConfig;
import com.github.superproxy.codegenerator.core.tpl.Tpl;

import java.io.File;

public class DaoImplTpl implements Tpl {

    private ModulePartConfig moduleConfig;

    public DaoImplTpl() {
    }

    public DaoImplTpl(ModulePartConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    @Override
    public String getTplPath() {
        return "DaoImpl.ftl";
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
        String filepath = pkgDir + File.separator + domain.getJavaBean().getClassName() + ".java";
        return filepath;
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
