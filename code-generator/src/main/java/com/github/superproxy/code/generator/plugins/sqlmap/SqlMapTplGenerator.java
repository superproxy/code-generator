package com.github.superproxy.code.generator.plugins.sqlmap;

import com.github.superproxy.code.generator.core.DbModelTplGenerator;
import com.github.superproxy.code.generator.core.model.GeneratorContext;

import java.io.File;

public class SqlMapTplGenerator extends DbModelTplGenerator {


    public SqlMapTplGenerator(GeneratorContext generatorContext) {
        super(generatorContext);

        //  增强处理模型
        SqlMapMethodGenerator sqlMapMethodGenerator = new SqlMapMethodGeneratorImpl(mConfig);
        registerHandler(sqlMapMethodGenerator);
    }

    @Override
    protected String getTemplatePath() {
        return "SqlMap.ftl";
    }


    @Override
    protected String getOutPath() {
        String pkgDir = mConfig.getOutPath();
        String module = mConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + mConfig.getModuleName();
        }

//        pkgDir += File.separator + projectConfig.getPackageName().replace(".", File.separator);

        new File(pkgDir).mkdirs();
        String filepath = pkgDir + File.separator + "sqlMap_" + model.getShortClassName().substring(0, 1).toLowerCase() + model.getShortClassName().substring(1) + ".xml";
        return filepath;
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }
}
