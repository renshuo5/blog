<html>
<head>
<meta charset=utf-8 />
<title>rs后台管理</title>
<script src="${rc.contextPath}/s/easyui/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="${rc.contextPath}/s/easyui/css/easyui.css">
<link rel="stylesheet" type="text/css" href="${rc.contextPath}/s/easyui/css/icon.css">
<script type="text/javascript" src="${rc.contextPath}/s/easyui/js/jquery.easyui.min.js"></script>
<!--[if IE]>
  <script src="${rc.contextPath}/s/easyui/js/html5shiv.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${rc.contextPath}/s/css/page.css">

<script type="text/javascript" src="${rc.contextPath}/s/js/menu/menuLoad.js"></script>
</head>
<body class="easyui-layout">
  <div region="north" class="north" title="test">
    <h1>rs</h1>
  </div>
  <div region="center" title="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
      <div title="首页" id="index"></div>
    </div>
  </div>
  <div region="west" class="west" title="menu">
    <ul id="tree"></ul>
  </div>
  
  <div id="tabsMenu" class="easyui-menu" style="width:120px;">  
    <div name="close">关闭</div>  
    <div name="Other">关闭其他</div>  
    <div name="All">关闭所有</div>
  </div>
</body>
</html>