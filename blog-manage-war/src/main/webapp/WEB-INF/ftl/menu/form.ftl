<form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
    <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">User Information</div>
    <div style="margin-bottom:10px">
        <input name="firstname" class="easyui-textbox" required="true" label="First Name:" style="width:100%">
    </div>
    <div style="margin-bottom:10px">
        <input name="lastname" class="easyui-textbox" required="true" label="Last Name:" style="width:100%">
    </div>
    <div style="margin-bottom:10px">
        <input name="phone" class="easyui-textbox" required="true" label="Phone:" style="width:100%">
    </div>
    <div style="margin-bottom:10px">
        <input name="email" class="easyui-textbox" required="true" validType="email" label="Email:" style="width:100%">
    </div>
</form>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>