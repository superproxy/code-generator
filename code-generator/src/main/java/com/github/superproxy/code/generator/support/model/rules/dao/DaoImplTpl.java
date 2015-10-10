package com.github.superproxy.code.generator.support.model.rules.dao;

import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.support.model.CommonModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.tpl.Tpl;

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
        CommonModel commonModel = (CommonModel) model;
        DbJavaModelConfig modelConfig = commonModel.getDbJavaModelConfig();
        String pkgDir = modelConfig.getOutPath();

        pkgDir += File.separator + modelConfig.getPackageName().replace(".", File.separator);
        String module = modelConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + modelConfig.getModuleName();
        }
        new File(pkgDir).mkdirs();
        String filepath = pkgDir + File.separator + commonModel.getJavaBean().getClassName() + ".java";
        return filepath;
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
