package com.github.superproxy.code.generator.plugins.sqlmap;

import com.github.superproxy.code.generator.core.DbModel;
import com.github.superproxy.code.generator.core.generator.ModelTplGenerator;
import com.github.superproxy.code.generator.core.model.ModelConfig;

import java.io.File;

public class SqlMapTplGenerator extends ModelTplGenerator {


    public SqlMapTplGenerator() {
        SqlMapMethodGenerator sqlMapMethodGenerator = new SqlMapMethodGeneratorImpl();
        registerHandler(sqlMapMethodGenerator);
    }

    @Override
    protected String getTplPath(DbModel dbModel) {
        return "SqlMap.ftl";
    }


    @Override
    protected String getOutPath(DbModel dbModel) {
        ModelConfig modelConfig = dbModel.getModelConfig();
        String pkgDir = modelConfig.getOutPath();
        String module = modelConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + modelConfig.getModuleName();
        }

//        pkgDir += File.separator + projectConfig.getPackageName().replace(".", File.separator);

        new File(pkgDir).mkdirs();
        return pkgDir + File.separator + "sqlMap_" +
                dbModel.getModel().getShortClassName().substring(0, 1).toLowerCase() +
                dbModel.getModel().getShortClassName().substring(1) + ".xml";
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }
}
