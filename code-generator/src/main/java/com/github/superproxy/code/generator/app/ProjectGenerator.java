package com.github.superproxy.code.generator.app;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.superproxy.code.generator.core.Generator;
import com.github.superproxy.code.generator.core.GeneratorFactory;
import com.github.superproxy.code.generator.core.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.core.model.db.DbSchema;
import com.github.superproxy.code.generator.core.model.db.DbSchemaFactory;
import com.github.superproxy.code.generator.core.model.db.DbSchemaFactoryImpl;
import com.github.superproxy.code.generator.core.model.db2java.impl.JavaBeanConvertStrategyImpl;
import com.github.superproxy.code.generator.core.model.db2java.impl.JavaFieldStrategyImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ProjectGenerator {

    public void main(String[] args) throws Exception {
        gen(args[0]);
    }

    private void gen(String path) throws Exception {
        ProjectConfig projectConfig = ProjectUtil.read(path);
        process(projectConfig);
    }

    public static void process(ProjectConfig projectConfig) throws Exception {
        for (ModuleConfig mConfig : projectConfig.getModules()) {
            for (ModulePartConfig partConfig : mConfig.getModulePartConfigList()) {
                MConfig moduleConfig = covert2ModuleConfig(projectConfig, mConfig, partConfig);
                DbSchema dbSchema = getDbSchema(projectConfig.getDbConfig(), moduleConfig.getTableName());
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


    private static DbSchema getDbSchema(DbConfig dbConfig, String tableName) throws Exception {
        DataSource dataSource = getDataSource2(dbConfig);
        DbSchemaFactory dbSchemaFactory = new DbSchemaFactoryImpl(dataSource);
        // 所有表
//        DbSchema dbSchema = dbSchemaFactory.genDbSchema(null);
        return dbSchemaFactory.genDbSchema(new String[]{tableName});
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

    private static DataSource getDataSource() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        return (DataSource) context.getBean("dataSource");
    }

    private static DataSource dataSource = null;

    private static DataSource getDataSource2(DbConfig dbConfig) throws Exception {
        if (dataSource == null) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("driverClassName", dbConfig.getDriverClass());
            map.put("url", dbConfig.getUrl());
            map.put("username", dbConfig.getUserName());
            map.put("password", dbConfig.getPassword());
            dataSource = DruidDataSourceFactory.createDataSource(map);
        }
        return dataSource;
    }

}
