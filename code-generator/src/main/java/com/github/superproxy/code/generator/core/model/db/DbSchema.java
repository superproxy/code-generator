package com.github.superproxy.code.generator.core.model.db;

import java.util.List;

/**
 * db信息
 */
public class DbSchema {

    String dbName;

    List<TableInfo> tableInfoList;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public List<TableInfo> getTableInfoList() {
        return tableInfoList;
    }

    public void setTableInfoList(List<TableInfo> tableInfoList) {
        this.tableInfoList = tableInfoList;
    }
}
