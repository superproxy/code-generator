package com.github.superproxy.code.generator.core.model.db;

import javax.sql.DataSource;

public class MysqlDbSchemaFactory extends AbstractDbSchemaFactory {
    public MysqlDbSchemaFactory(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getSchemaName() {
        return "root";
    }
}
