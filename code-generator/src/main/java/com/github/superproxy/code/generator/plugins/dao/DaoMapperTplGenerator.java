package com.github.superproxy.code.generator.plugins.dao;

import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.plugins.service.ServiceExtendHandler;

import java.io.File;

public class DaoMapperTplGenerator extends DbModelTplGenerator {

    public DaoMapperTplGenerator(GeneratorContext generatorContext) {
        super(generatorContext);
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler(moduleConfig);
        registerHandler(modelExtendHandler);
    }

    @Override
    protected String getTemplatePath() {
        return "DaoMapper.ftl";
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