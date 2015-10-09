package com.github.superproxy.code.generator.support.model.rules.dao;

import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.tpl.Tpl;

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
    public String getOutPath() {
//        //  model
//        ModelConfig modelConfig = dbModel.getModelConfig();
//        //  model
//        String pkgDir = modelConfig.getOutPath();
//
//        pkgDir += File.separator + modelConfig.getPackageName().replace(".", File.separator);
//        String module = modelConfig.getModuleName();
//        if (module != null) {
//            pkgDir += File.separator + modelConfig.getModuleName();
//        }
//        new File(pkgDir).mkdirs();
//        String filepath = pkgDir + File.separator + dbModel.getModel().getClassName() + ".java";
//        return filepath;

        return "daoImpl.java";
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
