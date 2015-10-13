<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<div class="pageContent">
    <form method="post" action="${pageContext.request.contextPath}/${moduleName}/create"
          class="pageForm required-validate"
          onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent" layoutH="56">
            <div class="divider"></div>
            <div class="tabs">
                <div class="tabsHeader">
                    <div class="tabsHeaderContent">
                        <ul>
                            <li class="selected"><a href="javascript:void(0)"><span>配件明细</span></a></li>
                        </ul>
                    </div>
                </div>

                <div class="tabsContent" style="height: 400px;">
                    <div>
                        <table class="list nowrap itemDetail" addButton="添加" width="100%">
                            <thead>
                            <tr>

                                <# fieldList  >
                                    <#if display>
                                        <th type="text" name="items[#index#].barCode" size="12" fieldClass="required"
                                            fieldAttrs="{remote:'validate_remote.html', maxlength:10}">条形码
                                        </th>
                                    </#if>
                                </#>
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
                <#list uiBean.elementList as field>
                    <#if field.show>
                        ${shortClassName}.${field.name}
                        <p>
                            <label>${field.displayName}：</label>
                            <input class="required" type="text" id="${field.name}" name="${field.name}" value=""
                                   readonly="${field.readonly}">
                        </p>
                    </#if>

                    <p>
                        <label>购买时间：</label>
                        <input type="text" name="buyDate" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                               class="required" readonly="true"/>
                        <a class="inputDateButton" href="javascript:;">选择</a>
                    </p>

                    <p>
                        <label>录入时间：</label>
                        <input type="text" name="inputDate" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                               readonly="true" class="required"/>
                        <a class="inputDateButton" href="javascript:;">选择</a>
                    </p>

                    <p>
                        <label>总价：</label>
                        <input type="text" id="totalPrice" name="totalPrice"/>
                    </p>

                    <p>
                        <label>折扣：</label>
                        <input type="text" id="discount" name="discount"/>
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