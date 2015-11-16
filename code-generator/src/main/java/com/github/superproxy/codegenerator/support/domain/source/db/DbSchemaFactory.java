package com.github.superproxy.codegenerator.support.domain.source.db;

import com.github.superproxy.codegenerator.support.domain.bean.DbSchema;

public interface DbSchemaFactory {


    /**
     * @param tables
     * @return
     * @throws Exception
     */
    DbSchema genDbSchema(String[] tables) throws Exception;

}