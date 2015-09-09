package com.github.superproxy.code.generator.plugins.contoller;

import com.github.superproxy.code.generator.core.DbModel;
import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.plugins.service.ServiceExtendHandler;

import java.io.File;

/**
 * 线程安全
 */
public class ControllerTplGenerator extends DbModelTplGenerator {

    public ControllerTplGenerator() {
        // 依赖
        ModelExtendHandler modelExtendHandler = new ServiceExtendHandler();
        registerHandler(modelExtendHandler);
    }

    @Override
    protected String getTplPath(DbModel dbModel) {
        return "Controller.ftl";
    }

    @Override
    protected String getOutPath(DbModel dbModel) {
        //  model
        MConfig mConfig = dbModel.getmConfig();
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
