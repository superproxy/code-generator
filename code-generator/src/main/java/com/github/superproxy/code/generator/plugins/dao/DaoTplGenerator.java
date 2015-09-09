package com.github.superproxy.code.generator.plugins.dao;

import com.github.superproxy.code.generator.core.DbModel;
import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.plugins.service.ServiceExtendHandler;

import java.io.File;

public class DaoTplGenerator extends DbModelTplGenerator {

    public DaoTplGenerator() {
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler();
        registerHandler(modelExtendHandler);
    }


    @Override
    protected String getTplPath(DbModel dbModel) {
        return "Dao.ftl";
    }

    @Override
    protected String getOutPath(DbModel dbModel) {
        MConfig mConfig = dbModel.getmConfig();
        String pkgDir = mConfig.getOutPath();

        pkgDir += File.separator + mConfig.getPackageName().replace(".", File.separator);
        String module = mConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + mConfig.getModuleName();
        }
        new File(pkgDir).mkdirs();
        String filepath = pkgDir + File.separator + getModel().getClassName() + ".java";
        return filepath;
    }


    @Override
    public String getType() {
        return this.getClass().getName();
    }
}
