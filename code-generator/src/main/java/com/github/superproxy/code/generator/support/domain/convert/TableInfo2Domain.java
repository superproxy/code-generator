package com.github.superproxy.code.generator.support.domain.convert;

import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.bean.DomainConfig;
import com.github.superproxy.code.generator.support.domain.bean.DomainField;
import com.github.superproxy.code.generator.support.domain.bean.ColumnInfo;
import com.github.superproxy.code.generator.support.domain.bean.TableInfo;

import java.util.ArrayList;
import java.util.List;

public class TableInfo2Domain {

    public static Domain convert(TableInfo tableInfo, DomainConfig domainConfig) {
        Domain domain = new Domain();
        domain.setName(tableInfo.getTableName());
        domain.setComment(tableInfo.getComment());
        List<DomainField> fieldList = new ArrayList<DomainField>();
        for (ColumnInfo c : tableInfo.getColumnInfoList()) {

            DomainField field = new DomainField();
            field.setName(c.getColumnName());
            field.setColumnType(c.getColumnType());

            fieldList.add(field);
        }
        domain.setFieldList(fieldList);
        return domain;
    }

}
