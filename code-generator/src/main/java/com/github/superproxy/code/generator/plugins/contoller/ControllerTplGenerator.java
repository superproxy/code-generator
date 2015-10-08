package com.github.superproxy.code.generator.plugins.contoller;

import com.github.superproxy.code.generator.core.generator.ModelTplGenerator;

import java.io.File;

/**
 * 线程安全
 */
public class ControllerTplGenerator extends ModelTplGenerator {

    public ControllerTplGenerator() {
        // 依赖
    }

    @Override
    protected String getTplPath(DbModel dbModel) {
        return "Controller.ftl";
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


}
