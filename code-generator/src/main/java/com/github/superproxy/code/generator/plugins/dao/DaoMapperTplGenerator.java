package com.github.superproxy.code.generator.plugins.dao;

import com.github.superproxy.code.generator.core.DbModel;
import com.github.superproxy.code.generator.core.generator.ModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.ModelConfig;
import com.github.superproxy.code.generator.core.handler.support.java.service.ServiceExtendHandler;

import java.io.File;

public class DaoMapperTplGenerator extends ModelTplGenerator {

    public DaoMapperTplGenerator() {
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler();
        registerHandler(modelExtendHandler);
    }

    @Override
    protected String getTplPath(DbModel dbModel) {
        return "DaoMapper.ftl";
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
        String filepath = pkgDir + File.separator + dbModel.getModel().getClassName() + ".java";
        return filepath;
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }

    @Override
    public String getDesciprtion() {
        return null;
    }
}
