<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<table>
    <#list uiBean.elementList as field>
        <#if field.show>
            <tr>
                <td>${field.displayName}:</td>
                <td>
                    ${shortClassName}.${field.name}
                </td>
            </tr>
        </#if>
    </#list>
</table>