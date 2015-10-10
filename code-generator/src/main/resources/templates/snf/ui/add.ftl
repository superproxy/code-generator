<div>

    <form method="post">
        <tr >
            for  list
            end
<#list ui.fields as field>
    /**
    * ${field.columnComment}
    */
    private ${field.shortJavaType} ${field.javaName};



</#list>

            <td colspan="2">
                <input type="submit" value="添加">
            </td>
        </tr>
    </form>
</div>