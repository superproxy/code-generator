package com.suning.dal.generator.core.model.db;

public interface DbSchemaFactory {


    /**
     * @param tables
     * @return
     * @throws Exception
     */
    DbSchema genDbSchema(String[] tables) throws Exception;

}