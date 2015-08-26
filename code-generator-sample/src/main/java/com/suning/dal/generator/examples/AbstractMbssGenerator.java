package com.suning.dal.generator.examples;

import com.suning.dal.generator.core.Generator;
import com.suning.dal.generator.core.model.ModuleConfig;
import com.suning.dal.generator.core.model.db.DbSchema;
import com.suning.dal.generator.core.model.db.DbSchemaFactory;
import com.suning.dal.generator.core.model.db.DbSchemaFactoryImpl;
import com.suning.dal.generator.core.model.db2java.impl.JavaBeanConvertStrategyImpl;
import com.suning.dal.generator.core.model.db2java.impl.JavaFieldStrategyImpl;
import com.suning.dal.generator.plugins.dao.DaoTplGenerator;
import com.suning.dal.generator.plugins.dao.DaoImplTplGenerator;
import com.suning.dal.generator.plugins.dao.DaoMapperTplGenerator;
import com.suning.dal.generator.plugins.model.ModelTplGenerator;
import com.suning.dal.generator.plugins.service.ServiceTplGenerator;
import com.suning.dal.generator.plugins.service.ServiceImplTplGenerator;
import com.suning.dal.generator.plugins.sqlmap.SqlMapTplGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.File;

public abstract class AbstractMbssGenerator {

    public abstract ModuleConfig buildProjectCofig();

    public void gen(String[] tableNames) throws Exception {
        ModuleConfig moduleConfig = buildProjectCofig();
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());

        moduleConfig.setTplsPath(new File("src\\main\\resources\\templates").getAbsolutePath());
        moduleConfig.setTplsPath(new File("src\\main\\resources\\templates").getAbsolutePath());


        DataSource dataSource = getDataSource();
        DbSchemaFactory dbSchemaFactory = new DbSchemaFactoryImpl(dataSource);
        // 所有表
//        DbSchema dbSchema = dbSchemaFactory.genDbSchema(null);
        DbSchema dbSchema = dbSchemaFactory.genDbSchema(tableNames);


        genModel(moduleConfig, dbSchema);

        genSql(moduleConfig, dbSchema);

        genService(moduleConfig, dbSchema);

        genServiceImpl(moduleConfig, dbSchema);


        genDao(moduleConfig, dbSchema);


        genDaoImpl(moduleConfig, dbSchema);

        genDaoMapper(moduleConfig, dbSchema);
    }

    private void genDaoImpl(ModuleConfig moduleConfig, DbSchema dbSchema) {
        Generator generator;
        moduleConfig.setClassPostfix("DaoImpl");
        moduleConfig.setPackageName("com.sunning.dal.dao.impl");
        generator = new DaoImplTplGenerator(moduleConfig, dbSchema,
                new JavaBeanConvertStrategyImpl(moduleConfig), new JavaFieldStrategyImpl()
        );
        generator.generator();
    }

    private void genDaoMapper(ModuleConfig moduleConfig, DbSchema dbSchema) {
        Generator generator;
        moduleConfig.setClassPostfix("Mapper");
        moduleConfig.setPackageName("com.sunning.dal.dao");
        generator = new DaoMapperTplGenerator(moduleConfig, dbSchema,
                new JavaBeanConvertStrategyImpl(moduleConfig), new JavaFieldStrategyImpl()
        );
        generator.generator();
    }

    private void genDao(ModuleConfig moduleConfig, DbSchema dbSchema) {
        Generator generator;
        moduleConfig.setClassPostfix("Dao");
        moduleConfig.setPackageName("com.sunning.dal.dao");
        generator = new DaoTplGenerator(moduleConfig, dbSchema,
                new JavaBeanConvertStrategyImpl(moduleConfig), new JavaFieldStrategyImpl()
        );
        generator.generator();
    }

    private void genServiceImpl(ModuleConfig moduleConfig, DbSchema dbSchema) {
        Generator generator;
        moduleConfig.setClassPostfix("ServiceImpl");
        moduleConfig.setPackageName("com.sunning.dal.impl");
        generator = new ServiceImplTplGenerator(moduleConfig, dbSchema,
                new JavaBeanConvertStrategyImpl(moduleConfig), new JavaFieldStrategyImpl()
        );

        generator.generator();
    }

    private void genService(ModuleConfig moduleConfig, DbSchema dbSchema) {
        Generator generator;
        moduleConfig.setClassPostfix("Service");
        moduleConfig.setPackageName("com.sunning.dal.inf");
        generator = new ServiceTplGenerator(moduleConfig, dbSchema,
                new JavaBeanConvertStrategyImpl(moduleConfig), new JavaFieldStrategyImpl()
        );
        generator.generator();
    }

    private void genModel(ModuleConfig moduleConfig, DbSchema dbSchema) {
        moduleConfig.setPackageName("com.sunning.dal.model");
        moduleConfig.setClassPostfix("");
        Generator generator =
                new ModelTplGenerator(moduleConfig, dbSchema, new JavaBeanConvertStrategyImpl(moduleConfig), new JavaFieldStrategyImpl());
        generator.generator();
    }

    private void genSql(ModuleConfig moduleConfig, DbSchema dbSchema) {
        Generator generator;
        moduleConfig.setClassPostfix("");
        generator = new SqlMapTplGenerator(moduleConfig, dbSchema,
                new JavaBeanConvertStrategyImpl(moduleConfig),
                new JavaFieldStrategyImpl()

        );
        generator.generator();
    }

    private DataSource getDataSource() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-res.xml");
        return (DataSource) context.getBean("dataSource");
    }
}
