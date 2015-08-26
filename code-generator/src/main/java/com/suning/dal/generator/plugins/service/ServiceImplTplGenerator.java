package com.suning.dal.generator.plugins.service;

import com.suning.dal.generator.core.DbModelTplGenerator;
import com.suning.dal.generator.core.handler.ExtendHandler;
import com.suning.dal.generator.core.model.Model;
import com.suning.dal.generator.core.model.ModuleConfig;
import com.suning.dal.generator.core.model.db.DbSchema;
import com.suning.dal.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.suning.dal.generator.core.model.db2java.JavaFieldConvertStrategy;

import java.io.File;

/**
 * Created by 14120295 on 2014/12/29.
 */
public class ServiceImplTplGenerator extends DbModelTplGenerator {

    public ServiceImplTplGenerator(ModuleConfig moduleConfig, DbSchema dbSchema,
                                   JavaBeanConvertStrategy javaBeanConvertStrategy, JavaFieldConvertStrategy javaFieldConvertStrategy) {
        super(moduleConfig, dbSchema, javaBeanConvertStrategy, javaFieldConvertStrategy);


        ExtendHandler extendHandler = new ServiceExtendHandler(moduleConfig);
        registerHandler(extendHandler);
    }

    @Override
    protected String getTemplatePath() {
        return "ServiceImpl.ftl";
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
