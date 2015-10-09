<#assign columns = fieldList?sort/>
<#assign pks = pkFieldList?sort/>
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