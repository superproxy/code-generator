package com.github.superproxy.code.generator.core.model.db;

import javax.sql.DataSource;

public class H2DbSchemaFactory extends AbstractDbSchemaFactory {
    public H2DbSchemaFactory(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getSchemaName() {
        return "PUBLIC";
    }
}
