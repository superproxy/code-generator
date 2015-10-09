package com.github.superproxy.code.generator.support.model.rules.dao;

import com.github.superproxy.code.generator.tpl.Tpl;

public class DaoTpl  implements Tpl {


    public DaoTpl() {
//        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler();
//        registerHandler(modelExtendHandler);
    }


    @Override
    public String getTplPath() {
        return "Dao.ftl";
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
//        String filepath = pkgDir + File.separator +  dbModel.getModel().getClassName() + ".java";
//        return filepath;

        return "dao.java";
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
