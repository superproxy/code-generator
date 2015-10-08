package com.github.superproxy.code.generator.support.model;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.superproxy.code.generator.config.DbConfig;
import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.core.bean.convert.DbModelConvert;
import com.github.superproxy.code.generator.support.model.java.lang.JavaBeanConvertStrategyImpl;
import com.github.superproxy.code.generator.support.model.java.lang.JavaFieldStrategyImpl;
import com.github.superproxy.code.generator.config.ModelConfig;
import com.github.superproxy.code.generator.source.db.DbSchema;
import com.github.superproxy.code.generator.source.db.DbSchemaFactory;
import com.github.superproxy.code.generator.source.db.TableInfo;
import com.github.superproxy.code.generator.source.db.support.H2DbSchemaFactory;
import com.github.superproxy.code.generator.source.db.support.MysqlDbSchemaFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DbJavaModelFromDbReader implements DbJavaModelReader {
    private DbSchemaFactory buildDbSchemaFactory(DataSource dataSource, DbConfig dbConfig) throws Exception {
        DbSchemaFactory dbSchemaFactory;
        if (dbConfig.getDriverClass().contains("h2")) {
            dbSchemaFactory = new H2DbSchemaFactory(dataSource);
        } else if (dbConfig.getDriverClass().contains("mysql")) {
            dbSchemaFactory = new MysqlDbSchemaFactory(dataSource);
        } else {
            throw new UnsupportedOperationException("unsupported db" + dbConfig.toString());
        }
        return dbSchemaFactory;
    }

    private DbJavaModel coverModelFromDb(ModelConfig modelConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig) throws Exception {
        DataSource dataSource = getDataSource2(projectConfig.getDbConfig());
        DbSchemaFactory dbSchemaFactory = buildDbSchemaFactory(dataSource, projectConfig.getDbConfig());
        DbSchema dbSchema = dbSchemaFactory.genDbSchema(new String[]{moduleConfig.getTableName()});
        TableInfo tableInfo = dbSchema.getTableInfoList().get(0);
        DbJavaModel dbJavaModel = DbModelConvert.convert(tableInfo, modelConfig, new JavaFieldStrategyImpl(), new JavaBeanConvertStrategyImpl());
        return dbJavaModel;
    }

    private DataSource getDataSource2(DbConfig dbConfig) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("driverClassName", dbConfig.getDriverClass());
        map.put("url", dbConfig.getUrl());
        map.put("username", dbConfig.getUserName());
        map.put("password", dbConfig.getPassword());
        return DruidDataSourceFactory.createDataSource(map);
    }

    @Override
    public DbJavaModel reader(ProjectConfig projectConfig) {
//        return coverModelFromDb(projectConfig);
        return null;
    }
}
