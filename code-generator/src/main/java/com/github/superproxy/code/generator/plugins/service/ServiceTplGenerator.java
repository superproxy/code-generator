package com.github.superproxy.code.generator.plugins.service;

import com.github.superproxy.code.generator.core.DbModel;
import com.github.superproxy.code.generator.core.generator.ModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.handler.support.java.service.ServiceExtendHandler;
import com.github.superproxy.code.generator.core.model.ModelConfig;

import java.io.File;

public class ServiceTplGenerator extends ModelTplGenerator {

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
        ModelConfig modelConfig = dbModel.getModelConfig();
        String pkgDir = modelConfig.getOutPath();

        pkgDir += File.separator + modelConfig.getPackageName().replace(".", File.separator);
        String module = modelConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + modelConfig.getModuleName();
        }
        new File(pkgDir).mkdirs();
        return pkgDir + File.separator +  dbModel.getModel().getClassName() + ".java";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }

}
