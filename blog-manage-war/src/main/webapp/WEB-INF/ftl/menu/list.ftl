<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>
<table class="easyui-datagrid" rownumbers="true" toolbar="#toolbar" pagination="true" >
	<thead>
		<tr>
			<th data-options="field:'itemid',width:80">编号</th>
			<th data-options="field:'productid',width:100">名称</th>
			<th data-options="field:'listprice',width:80,align:'right'">url</th>
			<th data-options="field:'unitcost',width:80,align:'right'">级别</th>
		</tr>
	</thead>
	<tbody>
		<#list list as em>
		<tr>
			<td>${em.id}</td>
			<td>${em.name}</td>
			<td>${em.url}</td>
			<td>${em.seqNum}</td>
		</tr>
		</#list>
	</tbody>
</table>
<div id="dlg">
        Content
    </div>
<script>
function newUser(){

$('#dlg').dialog({
    title: '菜单表单',
    width: 400,
    height: 200,
    closed: false,
    cache: false,
    href: 'manage/menu/form',
    modal: true
});
}


</script>
    
    