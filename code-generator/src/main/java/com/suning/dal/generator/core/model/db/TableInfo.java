package com.suning.dal.generator.core.model.db;

import java.util.ArrayList;
import java.util.List;

public class TableInfo {

    private String tableName;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    List<ColumnInfo> columnInfoList= new ArrayList<ColumnInfo>();

    List<ColumnInfo>  pkColumnList= new ArrayList<ColumnInfo>();
    List<ColumnInfo>  allColumnInfoList= new ArrayList<ColumnInfo>();

    public List<ColumnInfo> getAllColumnInfoList() {
        return allColumnInfoList;
    }

    public void setAllColumnInfoList(List<ColumnInfo> allColumnInfoList) {
        this.allColumnInfoList = allColumnInfoList;
    }

    public List<ColumnInfo> getPkColumnList() {
        return pkColumnList;
    }

    public void setPkColumnList(List<ColumnInfo> pkColumnList) {
        this.pkColumnList = pkColumnList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnInfo> getColumnInfoList() {
        return columnInfoList;
    }

    public void setColumnInfoList(List<ColumnInfo> columnInfoList) {
        this.columnInfoList = columnInfoList;
    }
}
