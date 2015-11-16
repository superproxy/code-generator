package com.github.superproxy.codegenerator.support.domain.source.db.support;

import com.github.superproxy.codegenerator.support.domain.source.db.AbstractDbSchemaFactory;

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
