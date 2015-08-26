package com.suning.dal.generator.plugins.dao;

import com.suning.dal.generator.core.DbModelTplGenerator;
import com.suning.dal.generator.core.handler.ExtendHandler;
import com.suning.dal.generator.plugins.service.ServiceExtendHandler;
import com.suning.dal.generator.core.model.Model;
import com.suning.dal.generator.core.model.ModuleConfig;
import com.suning.dal.generator.core.model.db.DbSchema;
import com.suning.dal.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.suning.dal.generator.core.model.db2java.JavaFieldConvertStrategy;

import java.io.File;

public class DaoMapperTplGenerator extends DbModelTplGenerator {

    public DaoMapperTplGenerator(ModuleConfig moduleConfig, DbSchema dbSchema,
                                 JavaBeanConvertStrategy javaBeanConvertStrategy, JavaFieldConvertStrategy javaFieldConvertStrategy) {
        super(moduleConfig, dbSchema, javaBeanConvertStrategy, javaFieldConvertStrategy);
        ExtendHandler extendHandler = new ServiceExtendHandler(moduleConfig);
        registerHandler(extendHandler);
    }

    @Override
    protected String getTemplatePath() {
        return "DaoMapper.ftl";
    }

    @Override
    protected String getOutPath(Model model) {
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


}
