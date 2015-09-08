package com.github.superproxy.code.generator.plugins.service;

import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.GeneratorContext;

import java.io.File;

public class ServiceImplTplGenerator extends DbModelTplGenerator {

    public ServiceImplTplGenerator(GeneratorContext generatorContext) {
        super(generatorContext);
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler(moduleConfig);
        registerHandler(modelExtendHandler);
    }

    @Override
    protected String getTemplatePath() {
        return "ServiceImpl.ftl";
    }

    @Override
    protected String getOutPath() {
        String pkgDir = moduleConfig.getOutPath();

        pkgDir += File.separator + moduleConfig.getPackageName().replace(".", File.separator);
        String module = moduleConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + moduleConfig.getModuleName();
        }
        new File(pkgDir).mkdirs();
        String filepath = pkgDir + File.separator + model.getClassName() + ".java";
        return filepath;
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }
}
