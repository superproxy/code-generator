package com.github.superproxy.code.generator.plugins.model;

import com.github.superproxy.code.generator.core.DbModel;
import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.model.MConfig;

import java.io.File;

public class ModelTplGenerator extends DbModelTplGenerator {

    public ModelTplGenerator() {
    }

    @Override
    protected String getTplPath(DbModel dbModel) {
        return "Model.ftl";
    }

    @Override
    protected String getOutPath(DbModel dbModel) {
        MConfig mConfig = dbModel.getmConfig();
        String pkgDir = mConfig.getOutPath();
        pkgDir += File.separator + mConfig.getPackageName().replace(".", File.separator);
        String module = mConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + mConfig.getModuleName();
        }

        new File(pkgDir).mkdirs();
        return pkgDir + File.separator +  dbModel.getModel().getClassName() + ".java";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
