<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>


<%--<!--  换页的时候改变-->--%>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/peijian2/list">
    <%--<input type="hidden" name="status" value="${param.status}">--%>
    <%--<input type="hidden" name="keywords" value="${param.keywords}"/>--%>
    <%--<input type="hidden" name="pageNum" value="${page.currentPageNum}"/>--%>
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="numPerPage" value="${page.rowsPerPage}"/>
    <%--<input type="hidden" name="orderField" value="${param.orderField}"/>--%>
</form>


<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);"
          action="${pageContext.request.contextPath}/peijian2/list"
          method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        订单号：<input type="text" name="buyId" value="${buyId}"/>
                    </td>
                    <td>
                        购买日期：<input type="text" class="date" readonly="true" name="buyDate" value="${buyDate}"/>
                    </td>
                </tr>
            </table>
            <div class="subBar">
                <ul>
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">检索</button>
                            </div>
                        </div>
                    </li>
                    <li><a class="button" href="${pageContext.request.contextPath}/peijian2/advancedSearch"
                           target="dialog" mask="true"
                           title="查询框"><span>高级检索</span></a></li>
                </ul>
            </div>
        </div>
    </form>
</div>


<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${pageContext.request.contextPath}/peijian2/add"
                   target="navTab" ref="new"><span>添加</span></a>
            </li>
            <%--<li><a class="add" href="/peijian/add" target="navTab"><span>添加</span></a></li>--%>
            <li><a class="detail" href="${pageContext.request.contextPath}/peijian2/{buyId}/show" target="dialog"><span>详情</span></a>
            </li>
            <li><a class="edit" href="${pageContext.request.contextPath}/peijian2/{buyId}/edit"
                   target="dialog"><span>修改</span></a></li>
            <li><a class="delete" href="${pageContext.request.contextPath}/peijian2/{buyId}/delete" target="ajaxTodo"
                   title="确定要删除吗?"><span>删除</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab"
                   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>


    <table class="table">
        <thead>
        <tr>
            <th width="100">单号</th>
            <th width="100">购买人</th>
            <th width="100">购买时间</th>
            <th width="100">录入时间</th>
            <th width="100">总金额</th>
            <th width="100">折扣</th>
            <th width="100">操作</th>
            <th width="100">操作</th>
            <th width="100">操作</th>
        </tr>
        <thead>

        <tbody>

        <c:forEach items="${orderEntityList}" var="maintiance">
            <%--跟踪订单ID--%>
            <tr target="buyId" rel="<c:out value="${maintiance.buyId}"/>">
            <td><c:out value="${maintiance.buyId}"/>
            </td>
            <td><c:out value="${maintiance.buyPerson}"/>
            </td>
            <td>
                <c:out value="${maintiance.buyDate}"/>
            </td>
            <td>
                <c:out value="${maintiance.inputDate}"/>
            </td>
            <td>
                <c:out value="${maintiance.totalPrice}"/>
            </td>
            <td>
                <c:out value="${maintiance.discount}"/>
            </td>
            <td>
                <a href="<c:out value="${pageContext.request.contextPath}/peijian2/${maintiance.buyId}/show"/>"
                target="dialog"> 详情</a>
            </td>
            <td>
                <a href="<c:out value="${pageContext.request.contextPath}/peijian2/${maintiance.buyId}/edit"/>"
                target="dialog"> 编辑</a>
            </td>
            <td>
                <a href="<c:out value="${pageContext.request.contextPath}/peijian2/${maintiance.buyId}/delete"/>"
                target="ajaxTodo"
                title="确定要删除吗?">
                删除</a>
                <%--<a href="<c:out value="${orderEntity.buyId}/delete"/>">删除</a>--%>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%@ include file="/WEB-INF/jsp/common/pagination.jsp" %>
</div>