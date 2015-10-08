package com.github.superproxy.code.generator.source.db;

public interface DbSchemaFactory {


    /**
     * @param tables
     * @return
     * @throws Exception
     */
    DbSchema genDbSchema(String[] tables) throws Exception;

}