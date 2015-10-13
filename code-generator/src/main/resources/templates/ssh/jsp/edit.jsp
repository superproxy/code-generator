<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<%--'command' 默认的 modelAttribute--%>
<%--<form:form method="POST" action="/template/edit" modelAttribute="orderEntity">--%>
<div class="pageContent">
    <%--<form name="form" action="/template/update" method="post"  >--%>

    <form method="post" action="${pageContext.request.contextPath}/peijian/update" class="pageForm required-validate"
          onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent" layoutH="56">
            <div class="divider"></div>
            <%--<h3 class="contentTitle">明细</h3>--%>

            <div class="tabs">

                <div class="tabsHeader">
                    <div class="tabsHeaderContent">
                        <ul>
                            <li class="selected"><a href="javascript:void(0)"><span>配件明细</span></a></li>
                            <%--<li><a href="javascript:void(0)"><span>从表2【PHP 示例 - 结尾带下标[#index#]】</span></a></li>--%>
                            <%--<li><a href="javascript:void(0)"><span>从表2【PHP 示例 - 结尾带下标[]】</span></a></li>--%>
                        </ul>
                    </div>
                </div>

                <div class="tabsContent" style="height: 400px;">
                    <div>
                        <table class="list nowrap itemDetail" addButton="添加" width="100%">
                            <thead>
                            <tr>
                                <th type="text" name="items[#index#].barCode" size="12" fieldClass="required"
                                    fieldAttrs="{remote:'validate_remote.html', maxlength:10}">条形码
                                </th>
                                <th type="text" name="items[#index#].peiJianNum" defaultVal="#index#" size="12"
                                    fieldClass="digits">配件数量
                                </th>
                                <th type="text" name="items[#index#].peiJianPrice" defaultVal="0.8" size="12"
                                    fieldClass="number">配件单价
                                </th>
                                <th type="del" width="60">操作</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div>
                <div class="tabsFooter">
                    <div class="tabsFooterContent"></div>
                </div>
            </div>


            <div>
                <p>
                    <label>单号:</label>
                    <input type="text" name="buyId" value="${orderEntity.buyId}" readonly="readonly"/>
                </p>

                <p>
                    <label>购买时间：</label>
                    <%--<input type="text" id="buyDate" name="buyDate"--%>
                    <%--onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>--%>
                    <input type="text" name="buyDate" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                           value="${orderEntity.buyDate}" class="required" readonly="true"/>
                    <a class="inputDateButton" href="javascript:;">选择</a>
                    <%--<span class="info">yyyy-MM-dd HH:mm:ss</span>--%>
                </p>

                <p>
                    <label>录入时间：</label>
                    <%--<input type="text" id="inputDate" name="inputDate"--%>
                    <%--onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:'false',readOnly:'true'})"/>--%>
                    <input type="text" name="inputDate" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                           value="${orderEntity.inputDate}" readonly="true" class="required"/>
                    <a class="inputDateButton" href="javascript:;">选择</a>
                    <%--<span class="info">yyyy-MM-dd HH:mm:ss</span>--%>
                </p>

                <p>
                    <label>总价：</label>
                    <input type="text" id="totalPrice" name="totalPrice" value="${orderEntity.totalPrice}"/>
                </p>

                <p>
                    <label>折扣：</label>
                    <input type="text" id="discount" name="discount" value="${orderEntity.discount}"/>
                </p>
            </div>

        </div>


        <div class="formBar">
            <ul>
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>

    </form>

</div>