package com.github.superproxy.code.generator.app;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.superproxy.code.generator.core.Generator;
import com.github.superproxy.code.generator.core.GeneratorFactory;
import com.github.superproxy.code.generator.core.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.core.model.db.DbSchema;
import com.github.superproxy.code.generator.core.model.db.DbSchemaFactory;
import com.github.superproxy.code.generator.core.model.db.H2DbSchemaFactory;
import com.github.superproxy.code.generator.core.model.db.MysqlDbSchemaFactory;
import com.github.superproxy.code.generator.core.model.db2java.impl.JavaBeanConvertStrategyImpl;
import com.github.superproxy.code.generator.core.model.db2java.impl.JavaFieldStrategyImpl;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ProjectGenerator {

    public void main(String[] args) throws Exception {
        new ProjectGenerator().gen(args[0]);
    }

    private DataSource dataSource = null;
    private DbSchemaFactory dbSchemaFactory;

    private void gen(String path) throws Exception {
        ProjectConfig projectConfig = ProjectUtil.read(path);

        process(projectConfig);
    }

    public void process(ProjectConfig projectConfig) throws Exception {
        init(projectConfig);
        for (ModuleConfig mConfig : projectConfig.getModules()) {
            for (ModulePartConfig partConfig : mConfig.getModulePartConfigList()) {
                MConfig moduleConfig = covert2ModuleConfig(projectConfig, mConfig, partConfig);
                DbSchema dbSchema = dbSchemaFactory.genDbSchema(new String[]{moduleConfig.getTableName()});
                GeneratorContext generatorContext = buildGeneratorContext(moduleConfig, dbSchema);
                Generator generator = GeneratorFactory.getGenerator(partConfig.getGenerator());
                if (generator == null) {
                    Constructor<?> constructor = Class.forName(partConfig.getGenerator()).getConstructor();
                    generator = (Generator) constructor.newInstance();
                    GeneratorFactory.registerGenerator(generator);
                }
                generator.generator(generatorContext);
            }
        }
    }

    private void init(ProjectConfig projectConfig) throws Exception {
        dataSource = getDataSource2(projectConfig.getDbConfig());
        if (projectConfig.getDbConfig().getDriverClass().contains("h2")) {
            dbSchemaFactory = new H2DbSchemaFactory(dataSource);
        } else if (projectConfig.getDbConfig().getDriverClass().contains("mysql")) {
            dbSchemaFactory = new MysqlDbSchemaFactory(dataSource);
        } else {
            throw new UnsupportedOperationException("unsupported db" + projectConfig.getDbConfig().toString());
        }
    }

    private static MConfig covert2ModuleConfig(ProjectConfig projectConfig, ModuleConfig mConfig, ModulePartConfig partConfig) {
        MConfig moduleConfig = new MConfig();
        moduleConfig.setAuthor(projectConfig.getAuthor());
        moduleConfig.setDate(projectConfig.getDate());
        moduleConfig.setOutPath(projectConfig.getOutPath());
        moduleConfig.setTplsRoot(projectConfig.getTplRoot());
        moduleConfig.setTableName(mConfig.getTableName());
        moduleConfig.setModuleName(mConfig.getModuleName());
        moduleConfig.setClassPostfix(partConfig.getClassPostfix());
        moduleConfig.setPackageName(partConfig.getPackageName());
        return moduleConfig;
    }


    private static GeneratorContext buildGeneratorContext(MConfig mConfig, DbSchema dbSchema) {
        GeneratorContext generatorContext = new GeneratorContext();
        generatorContext.setmConfig(mConfig);
        generatorContext.setDbSchema(dbSchema);
        generatorContext.setJavaBeanConvertStrategy(new JavaBeanConvertStrategyImpl());
        generatorContext.setJavaFieldConvertStrategy(new JavaFieldStrategyImpl());
        generatorContext.setTemplateEngine(new FreeMarkerTplEngine());
        return generatorContext;
    }


    private DataSource getDataSource2(DbConfig dbConfig) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("driverClassName", dbConfig.getDriverClass());
        map.put("url", dbConfig.getUrl());
        map.put("username", dbConfig.getUserName());
        map.put("password", dbConfig.getPassword());
        return DruidDataSourceFactory.createDataSource(map);
    }

}
