package com.suning.dal.generator.plugins.sqlmap;

import com.suning.dal.generator.core.DbModelTplGenerator;
import com.suning.dal.generator.core.model.Model;
import com.suning.dal.generator.core.model.db.DbSchema;
import com.suning.dal.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.suning.dal.generator.core.model.db2java.JavaFieldConvertStrategy;
import com.suning.dal.generator.core.model.ModuleConfig;

import java.io.File;

public class SqlMapTplGenerator extends DbModelTplGenerator {


    public SqlMapTplGenerator(ModuleConfig moduleConfig, DbSchema dbSchema,
                              JavaBeanConvertStrategy javaBeanConvertStrategy, JavaFieldConvertStrategy javaFieldConvertStrategy) {
        super(moduleConfig, dbSchema, javaBeanConvertStrategy, javaFieldConvertStrategy);


        SqlMapMethodGenerator sqlMapMethodGenerator = new SqlMapMethodGeneratorImpl(moduleConfig);
        registerHandler(sqlMapMethodGenerator);

    }

    @Override
    protected String getTemplatePath() {
        return "SqlMap.ftl";
    }


    @Override
    protected String getOutPath(Model model) {
        String pkgDir = moduleConfig.getOutPath();
        String module = moduleConfig.getModuleName();
        if (module != null) {
            pkgDir += File.separator + moduleConfig.getModuleName();
        }

//        pkgDir += File.separator + projectConfig.getPackageName().replace(".", File.separator);

        new File(pkgDir).mkdirs();
        String filepath = pkgDir + File.separator + "sqlMap_" + model.getShortClassName().substring(0, 1).toLowerCase() + model.getShortClassName().substring(1) + ".xml";
        return filepath;
    }


}
