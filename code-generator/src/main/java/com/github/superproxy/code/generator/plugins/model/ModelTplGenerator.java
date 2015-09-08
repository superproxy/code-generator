package com.github.superproxy.code.generator.plugins.model;

import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.model.GeneratorContext;

import java.io.File;

public class ModelTplGenerator extends DbModelTplGenerator {

    public ModelTplGenerator(GeneratorContext generatorContext) {
        super(generatorContext);
    }

    @Override
    protected String getTplPath() {
        return "Model.ftl";
    }

    @Override
    protected String getOutPath() {
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
