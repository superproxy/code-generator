package com.github.superproxy.code.generator.support.domain.source.db;

import com.github.superproxy.code.generator.support.domain.bean.ColumnInfo;
import com.github.superproxy.code.generator.support.domain.bean.DbSchema;
import com.github.superproxy.code.generator.support.domain.bean.TableInfo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract  class AbstractDbSchemaFactory implements DbSchemaFactory {
    public AbstractDbSchemaFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private String schema;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    DataSource dataSource;


    /**
     * 获取数据库中的表名称与视图名称
     *
     * @return
     */
    private List<TableInfo> getTablesAndViews(String schema, String[] tables) throws Exception {
        Connection conn = dataSource.getConnection();
        ResultSet rs = null;
        List<TableInfo> list = new ArrayList<TableInfo>();
        try {
            DatabaseMetaData metaData = conn.getMetaData();
//            rs = metaData.getTables(null, schema, null, new String[]{"TABLE", "VIEW"});
            rs = metaData.getTables(null, schema, null, new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
//                String comment = rs.getString("TABLE_REMARK");

                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(tableName);
//                tableInfo.setComment(comment);

                if (tables != null) { // 空表认为是所有的表
                    for (String t : tables) {
                        if (t.toLowerCase().equals(tableName.toLowerCase())) {
                            list.add(tableInfo);
                        }
                    }
                } else {
                    list.add(tableInfo);
                }
//
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, null, conn);
        }
        return list;
    }

    private void close(ResultSet rs, Object o, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public DbSchema genDbSchema(String[] tables) throws Exception {
        DbSchema dbSchema = new DbSchema();




        List<TableInfo> tableInfoList = getTablesAndViews(getSchemaName(), tables);
        String s = Arrays.toString(tableInfoList.toArray());

        // 获取table列表
        for (TableInfo tableInfo : tableInfoList) {
            List<ColumnInfo> columnInfoList = this.generateBean(schema, tableInfo.getTableName());
            List<ColumnInfo> pkColumnInfoList = new ArrayList<ColumnInfo>();
            List<ColumnInfo> normalColumnInfoList = new ArrayList<ColumnInfo>();
            for (ColumnInfo columnInfo : columnInfoList) {
                if (columnInfo.isPk()) {
                    pkColumnInfoList.add(columnInfo);
                } else {
                    normalColumnInfoList.add(columnInfo);
                }
                System.out.println(columnInfo);
            }

            tableInfo.setPkColumnList(pkColumnInfoList);
            tableInfo.setColumnInfoList(normalColumnInfoList);
            tableInfo.setAllColumnInfoList(columnInfoList);
        }

        dbSchema.setTableInfoList(tableInfoList);
        System.out.println(s);
        return dbSchema;

    }

    protected abstract String getSchemaName();


    /**
     * 利用表名和数据库用户名查询出该表对应的字段类型
     *
     * @param tableName 表名
     * @return
     * @throws Exception
     */
    private List<ColumnInfo> generateBean(String schema, String tableName) throws Exception {
        Connection conn = dataSource.getConnection();
        ResultSet rs = null;
        List<ColumnInfo> columnInfoList = new ArrayList<ColumnInfo>();
        try {
            DatabaseMetaData metaData = conn.getMetaData();

            rs = metaData.getColumns(null, schema, tableName, null);
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");//列名
                String dataType = rs.getString("DATA_TYPE");//字段数据类型(对应java.sql.Types中的常量)
                String typeName = rs.getString("TYPE_NAME");//字段类型名称(例如：VACHAR2)
                String comment = rs.getString("REMARKS");
                int nullAble = rs.getInt("NULLABLE");
                String isNullAble = rs.getString("IS_NULLABLE");
                boolean isAutoincrement = rs.getString("IS_AUTOINCREMENT").toLowerCase().equals("yes"); // YES
                ColumnInfo columnInfo = new ColumnInfo();
                columnInfo.setColumnJdbcType(dataType);
                columnInfo.setColumnName(columnName);
                columnInfo.setColumnType(typeName);
                columnInfo.setColumnComment(comment);
                columnInfoList.add(columnInfo);

            }

            rs.close();

            rs = metaData.getPrimaryKeys(null, schema, tableName);
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");//列名
                for (ColumnInfo columnInfo : columnInfoList) {
                    if (columnName.equals(columnInfo.getColumnName())) {
                        columnInfo.setPk(true);
                    }
                }
            }

            // 其它生成javaBean的相关操作

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, null, conn);
        }
        return columnInfoList;
    }
}
