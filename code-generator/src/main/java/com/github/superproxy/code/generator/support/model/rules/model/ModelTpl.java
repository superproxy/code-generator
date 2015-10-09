package com.github.superproxy.code.generator.support.model.rules.model;

import com.github.superproxy.code.generator.tpl.Tpl;

public class ModelTpl implements Tpl {

    @Override
    public String getTplPath() {
        return "Model.ftl";
    }

    @Override
    public String getOutPath() {
//        ModelConfig modelConfig = dbModel.getModelConfig();
//        String pkgDir = modelConfig.getOutPath();
//        pkgDir += File.separator + modelConfig.getPackageName().replace(".", File.separator);
//        String module = modelConfig.getModuleName();
//        if (module != null) {
//            pkgDir += File.separator + modelConfig.getModuleName();
//        }
//
//        new File(pkgDir).mkdirs();
//        return pkgDir + File.separator + dbModel.getModel().getClassName() + ".java";
        return "model.java";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
