package com.github.superproxy.code.generator.plugins.dao;

import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.plugins.service.ServiceExtendHandler;

import java.io.File;

public class DaoImplTplGenerator extends DbModelTplGenerator {

    public DaoImplTplGenerator(GeneratorContext generatorContext) {
        super(generatorContext);

        // 依赖
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler(mConfig);
        registerHandler(modelExtendHandler);
    }

    @Override
    protected String getTemplatePath() {
        return "DaoImpl.ftl";
    }

    @Override
    protected String getOutPath() {
        //  model
        String pkgDir = mConfig.getOutPath();

        pkgDir += File.separator + mConfig.getPackageName().replace(".", File.separator);
        String module = mConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + mConfig.getModuleName();
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
