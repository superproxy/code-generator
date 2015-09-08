<#assign columns = model.fieldList?sort/>
<#assign pks = model.pkFieldList?sort/>
<#assign sqlMap = model.extra.sqlMap/>
<#assign className = model.className/>
<#assign package = model.package/>
<#assign name = sqlMap.name/>
<#assign shortClassName = model.shortClassName/>
<?xml version="1.0" encoding="UTF-8" ?>
<sqlMap namespace="${shortClassName?uncap_first}">
    <sql id="insert">
        <![CDATA[
        ${sqlMap.insert}
        ]]>
    </sql>
    <sql id="insert2">
        <![CDATA[
        ${sqlMap.insert2}
        ]]>
    </sql>
    <sql id="update">
        <![CDATA[
        ${sqlMap.update}
        ]]>
    </sql>
    <sql id="deleteById">
        <![CDATA[
        ${sqlMap.deleteById}
        ]]>
    </sql>

    <sql id="queryById">
        <![CDATA[
        ${sqlMap.queryById}
        ]]>
    </sql>

    <sql id="queryByPage">
        <![CDATA[
        ${sqlMap.queryByPage}
        ]]>
    </sql>

    <sql id="queryCount">
        <![CDATA[
        ${sqlMap.queryCount}
        ]]>
    </sql>

</sqlMap>