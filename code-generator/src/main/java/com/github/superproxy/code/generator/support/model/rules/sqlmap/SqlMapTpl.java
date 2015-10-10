package com.github.superproxy.code.generator.support.model.rules.sqlmap;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.support.model.CommonModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.tpl.Tpl;

import java.io.File;

public class SqlMapTpl implements Tpl {

    public SqlMapTpl() {
    }

    @Override
    public String getTplPath() {
        return "SqlMap.ftl";
    }


    @Override
    public String getOutPath(Model model) {
        CommonModel commonModel = (CommonModel) model;
        DbJavaModelConfig modelConfig = commonModel.getDbJavaModelConfig();
        String pkgDir = modelConfig.getOutPath();
        String module = modelConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + modelConfig.getModuleName();
        }

//        pkgDir += File.separator + projectConfig.getPackageName().replace(".", File.separator);
        new File(pkgDir).mkdirs();
        return pkgDir + File.separator + "sqlMap_" +
                commonModel.getJavaBean().getShortClassName().substring(0, 1).toLowerCase() +
                commonModel.getJavaBean().getShortClassName().substring(1) + ".xml";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
