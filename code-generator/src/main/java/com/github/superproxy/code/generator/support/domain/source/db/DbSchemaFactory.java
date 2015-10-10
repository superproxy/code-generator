package com.github.superproxy.code.generator.support.domain.source.db;

import com.github.superproxy.code.generator.support.domain.bean.DbSchema;

public interface DbSchemaFactory {


    /**
     * @param tables
     * @return
     * @throws Exception
     */
    DbSchema genDbSchema(String[] tables) throws Exception;

}