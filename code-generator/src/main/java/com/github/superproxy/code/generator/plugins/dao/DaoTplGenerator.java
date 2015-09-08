package com.github.superproxy.code.generator.plugins.dao;

import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.plugins.service.ServiceExtendHandler;

import java.io.File;

public class DaoTplGenerator extends DbModelTplGenerator {

    public DaoTplGenerator(GeneratorContext context) {
        super((context));
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler(context.getModuleConfig());
        registerHandler(modelExtendHandler);
    }


    @Override
    protected String getTemplatePath() {
        return "Dao.ftl";
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
        String filepath = pkgDir + File.separator + getModel().getClassName() + ".java";
        return filepath;
    }


    @Override
    public String getType() {
        return this.getClass().getName();
    }
}
