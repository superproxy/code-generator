package com.github.superproxy.code.generator.support.domain.rules.contoller;

import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;
import com.github.superproxy.code.generator.support.domain.bean.DomainConfig;
import com.github.superproxy.code.generator.tpl.Tpl;

import java.io.File;

public class ControllerTpl implements Tpl {

    private ModulePartConfig moduleConfig;

    public ControllerTpl() {
    }

    public ControllerTpl(ModulePartConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    @Override
    public String getTplPath() {
        return "Controller.ftl";
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
