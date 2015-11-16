package com.github.superproxy.codegenerator.support.domain.extend.java.sqlmap;

import com.github.superproxy.codegenerator.core.generator.modelgen.Model;
import com.github.superproxy.codegenerator.core.generator.modelgen.ModelMapExtendHandler;
import com.github.superproxy.codegenerator.support.domain.bean.ComposeModel;
import com.github.superproxy.codegenerator.support.domain.bean.DomainConfig;

import java.util.HashMap;
import java.util.Map;

public class SqlMapMethodExtendHandler implements ModelMapExtendHandler {

    SqlMapMethod sqlMapMethod = new SqlMapMethodImpl();

    public SqlMapMethodExtendHandler() {
    }


    @Override
    public void extendModelMap(Model model, Map extend) {
        ComposeModel domain = (ComposeModel) model;
        Map map = new HashMap();
        map.put(SqlMapExtendModel.NAME, getSqlMapName(domain, domain.getDomainConfig()));
        map.put(SqlMapExtendModel.INSERT, sqlMapMethod.getInsertGenerator(domain));
        map.put(SqlMapExtendModel.INSERT2, sqlMapMethod.getInsert2Generator(domain));
        map.put(SqlMapExtendModel.UPDATE, sqlMapMethod.updateGenerator(domain));
        map.put(SqlMapExtendModel.QUERY_BY_ID, sqlMapMethod.queryByIdGenerator(domain));
        map.put(SqlMapExtendModel.QUERY_BY_PAGE, sqlMapMethod.queryByPageGenerator(domain));
        map.put(SqlMapExtendModel.QUERY_COUNT, sqlMapMethod.queryCountGenerator(domain));
        map.put(SqlMapExtendModel.DELETE_BY_ID, sqlMapMethod.deleteByIdGenerator(domain));

        extend.put("sqlMap", map);// sqlMap.xxx引用方式

//        extend.put("name", getSqlMapName((Domain) model));
    }

    private String getSqlMapName(ComposeModel domain) {
        return domain.getTableInfo().getTableName().replace(domain.getDomainConfig().getTablePrefix() + "_", "");
    }

    private String getSqlMapName(ComposeModel domain, DomainConfig domainConfig) {
        return domain.getTableInfo().getTableName().replace(domainConfig.getTablePrefix() + "_", "");
    }

    public String handlerId() {
        return SqlMapExtendModel.ID;
    }

}
