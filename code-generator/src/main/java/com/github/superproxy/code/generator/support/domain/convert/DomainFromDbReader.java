package com.github.superproxy.code.generator.support.domain.convert;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.superproxy.code.generator.config.DbConfig;
import com.github.superproxy.code.generator.config.ModuleConfig;
import com.github.superproxy.code.generator.config.ModulePartConfig;
import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.support.domain.bean.*;
import com.github.superproxy.code.generator.support.domain.source.db.DbSchemaFactory;
import com.github.superproxy.code.generator.support.domain.source.db.support.H2DbSchemaFactory;
import com.github.superproxy.code.generator.support.domain.source.db.support.MysqlDbSchemaFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DomainFromDbReader implements DomainReader {
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

    private ComposeModel covertModelFromDb(TableInfo tableInfo, DomainConfig domainConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) throws Exception {
        ComposeModel composeModel = new ComposeModel();
        Domain domain = TableInfo2Domain.convert(tableInfo, domainConfig);
        composeModel.setDomainConfig(domainConfig);
        composeModel.setTableInfo(tableInfo);
        composeModel.setDomain(domain);
        return composeModel;
    }

    private TableInfo getTableInfo(ProjectConfig projectConfig, ModuleConfig moduleConfig) throws Exception {
        DataSource dataSource = getDataSource2(projectConfig.getDbConfig());
        DbSchemaFactory dbSchemaFactory = buildDbSchemaFactory(dataSource, projectConfig.getDbConfig());
        DbSchema dbSchema = dbSchemaFactory.genDbSchema(new String[]{moduleConfig.getTableName()});
        return dbSchema.getTableInfoList().get(0);
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
    public ComposeModel reader(DomainConfig domainConfig, ProjectConfig projectConfig, ModuleConfig moduleConfig, ModulePartConfig modulePartConfig) {
        try {
            TableInfo tableInfo = getTableInfo(projectConfig, moduleConfig);
            return covertModelFromDb(tableInfo, domainConfig, projectConfig, moduleConfig, modulePartConfig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
