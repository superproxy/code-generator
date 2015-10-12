package com.github.superproxy.code.generator.support.domain.rules.dao;

import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;
import com.github.superproxy.code.generator.support.domain.bean.DomainConfig;
import com.github.superproxy.code.generator.tpl.Tpl;

import java.io.File;

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
        String filepath = pkgDir + File.separator +  domain.getJavaBean().getClassName() + ".java";
        return filepath;
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
