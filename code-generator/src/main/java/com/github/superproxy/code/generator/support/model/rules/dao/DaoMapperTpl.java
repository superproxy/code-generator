package com.github.superproxy.code.generator.support.model.rules.dao;

import com.github.superproxy.code.generator.tpl.Tpl;

public class DaoMapperTpl implements Tpl {

    public DaoMapperTpl() {
    }

    @Override
    public String getTplPath() {
        return "DaoMapper.ftl";
    }

    @Override
    public String getOutPath() {
//        ModelConfig modelConfig = dbModel.getModelConfig();
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
        return "daoMapper.sql";
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
