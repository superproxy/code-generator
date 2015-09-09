package com.github.superproxy.code.generator.plugins.service;

import com.github.superproxy.code.generator.core.DbModel;
import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.MConfig;

import java.io.File;

public class ServiceImplTplGenerator extends DbModelTplGenerator {

    public ServiceImplTplGenerator() {
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler();
        registerHandler(modelExtendHandler);
    }

    @Override
    protected String getTplPath(DbModel dbModel) {
        return "ServiceImpl.ftl";
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
        String filepath = pkgDir + File.separator +  dbModel.getModel().getClassName() + ".java";
        return filepath;
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
