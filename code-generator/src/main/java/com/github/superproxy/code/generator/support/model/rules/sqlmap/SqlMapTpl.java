package com.github.superproxy.code.generator.support.model.rules.sqlmap;

import com.github.superproxy.code.generator.tpl.Tpl;

public class SqlMapTpl implements Tpl {


    public SqlMapTpl() {
    }

    @Override
    public String getTplPath() {
        return "SqlMap.ftl";
    }


    @Override
    public String getOutPath() {
//        ModelConfig modelConfig = dbModel.getModelConfig();
//        String pkgDir = modelConfig.getOutPath();
//        String module = modelConfig.getModuleName();
//        if (module != null) {
//            pkgDir += File.separator + modelConfig.getModuleName();
//        }
//
////        pkgDir += File.separator + projectConfig.getPackageName().replace(".", File.separator);
//
//        new File(pkgDir).mkdirs();
//        return pkgDir + File.separator + "sqlMap_" +
//                dbModel.getModel().getShortClassName().substring(0, 1).toLowerCase() +
//                dbModel.getModel().getShortClassName().substring(1) + ".xml";
        return "SqlMap.java";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
