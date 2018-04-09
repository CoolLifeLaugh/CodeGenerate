<#list headers as key>
<th field="${key.columnName}">${key.columnComment}</th>
</#list>

<#list headers as key>
    <div style="margin-bottom:10px">
        <input name="${key.columnName}" class="easyui-textbox" required="true" label="${key.columnComment}:" style="width:100%">
    </div>
</#list>
