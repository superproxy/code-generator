package com.github.superproxy.code.generator.source.db.support;

import com.github.superproxy.code.generator.source.db.AbstractDbSchemaFactory;

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
