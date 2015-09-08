package com.github.superproxy.code.generator.app;

import com.github.superproxy.code.generator.core.Generator;
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
                DbSchema dbSchema = getDbSchema(moduleConfig.getTableName());

                GeneratorContext generatorContext = getGeneratorContext(moduleConfig, dbSchema);
//                GeneratorFactory.registerGenerator(new ModelTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new SqlMapTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new DaoTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new DaoImplTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new DaoMapperTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new ServiceTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new ServiceImplTplGenerator(generatorContext));
                Constructor<?> constructor = Class.forName(partConfig.getGenerator()).getConstructor(GeneratorContext.class);
                Generator generator = (Generator) constructor.newInstance(generatorContext);
                generator.generator();
            }
        }
    }

    private static MConfig covert2ModuleConfig(ProjectConfig projectConfig, ModuleConfig mConfig, ModulePartConfig partConfig) {
        MConfig moduleConfig = new MConfig();
        moduleConfig.setAuthor(projectConfig.getAuthor());
        moduleConfig.setDate(projectConfig.getDate());
        moduleConfig.setOutPath(projectConfig.getOutPath());
        moduleConfig.setTplsPath(projectConfig.getTplRoot());
        moduleConfig.setTableName(mConfig.getTableName());
        moduleConfig.setModuleName(mConfig.getModuleName());
        moduleConfig.setClassPostfix(partConfig.getClassPostfix());
        moduleConfig.setPackageName(partConfig.getPackageName());
        return moduleConfig;
    }


    private static DbSchema getDbSchema(String tableName) throws Exception {
        DataSource dataSource = getDataSource();
        DbSchemaFactory dbSchemaFactory = new DbSchemaFactoryImpl(dataSource);
        // 所有表
//        DbSchema dbSchema = dbSchemaFactory.genDbSchema(null);
        return dbSchemaFactory.genDbSchema(new String[]{tableName});
    }

    private static GeneratorContext getGeneratorContext(MConfig mConfig, DbSchema dbSchema) {
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

}
