package com.github.superproxy.code.generator.support.model.rules.service;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.support.model.CommonModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;
import com.github.superproxy.code.generator.tpl.Tpl;

import java.io.File;

public class ServiceTpl implements Tpl {

    public ServiceTpl() {
    }

    @Override
    public String getTplPath() {
        return "Service.ftl";
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
        return pkgDir + File.separator +  commonModel.getJavaBean().getClassName() + ".java";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }

}
