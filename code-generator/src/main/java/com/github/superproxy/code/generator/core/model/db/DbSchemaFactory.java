package com.github.superproxy.code.generator.core.model.db;

public interface DbSchemaFactory {


    /**
     * @param tables
     * @return
     * @throws Exception
     */
    DbSchema genDbSchema(String[] tables) throws Exception;

}