<#assign columns = table.columnInfoList?sort/>
<#assign pks = table.pkColumnList?sort/>
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
    <sql id="delete_by_id">
        <![CDATA[
    ${sqlMap.deleteById}
        ]]>
    </sql>

    <sql id="query_by_id">
        <![CDATA[
    ${sqlMap.queryById}
        ]]>
    </sql>

    <sql id="query_by_page">
        <![CDATA[
    ${sqlMap.queryByPage}
        ]]>
    </sql>

    <sql id="query_count">
        <![CDATA[
    ${sqlMap.queryCount}
        ]]>
    </sql>
</sqlMap>