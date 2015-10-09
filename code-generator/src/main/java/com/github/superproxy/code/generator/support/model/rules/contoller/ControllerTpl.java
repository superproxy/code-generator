package com.github.superproxy.code.generator.support.model.rules.contoller;

import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.tpl.Tpl;

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
    public String getOutPath() {
//        ModuleConfig  modelConfig = dbModel.getModelConfig();
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

        return "controller.java";
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }


}
