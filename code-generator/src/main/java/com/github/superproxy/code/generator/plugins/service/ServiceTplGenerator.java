package com.github.superproxy.code.generator.plugins.service;

import com.github.superproxy.code.generator.core.DbModel;
import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.MConfig;

import java.io.File;

public class ServiceTplGenerator extends DbModelTplGenerator {

    public ServiceTplGenerator() {
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler();
        registerHandler(modelExtendHandler);
    }

    @Override
    protected String getTplPath(DbModel dbModel) {
        return "Service.ftl";
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
        return pkgDir + File.separator + model.getClassName() + ".java";
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }

}
