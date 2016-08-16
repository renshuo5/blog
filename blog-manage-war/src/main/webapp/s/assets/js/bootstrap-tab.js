var addTabs = function (options) {
  //var rand = Math.random().toString();
  //var id = rand.substring(rand.indexOf('.') + 1);
  var url = window.location.protocol + '//' + window.location.host;
  options.url = url + options.url;
  
  var menuliId = 'menu_li_'+options.id;
  
  id = "tab_" + options.id;
  $(".active").removeClass("active");
  //如果TAB不存在，创建一个新的TAB
  if (!$("#" + id)[0]) {
    //固定TAB中IFRAME高度
    mainHeight = $(document.body).height() - 90;
    //创建新TAB的title
    title = '<li role="presentation" url="'+options.url+'" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab">' + options.title;
    //是否允许关闭
    if (options.close) {
      title += ' <i class="icon-remove" tabclose="' + id + '"></i>';
    }
    title += '</a></li>';
    //是否指定TAB内容
    if (options.content) {
      content = '<div role="tabpanel" class="tab-pane" id="' + id + '">' + options.content + '</div>';
    } else {//没有内容，使用IFRAME打开链接
      content = '<div role="tabpanel" class="tab-pane" id="' + id + '"><iframe src="' + options.url + '" width="100%" height="' + mainHeight +
          '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe></div>';
    }
    //加入TABS
    $("#open_nav_tabs").append(title);
    $("#open_tab_content").append(content);
  }
  //激活TAB
  $("#tab_" + id).addClass('active');
  $("#" + id).addClass("active");
  
  //设置导航菜单选中的颜色
  $("#"+menuliId).addClass("active");
  
//监听右键事件，创建右键菜单
//  $("#tab_" + id).bind("contextmenu",function(event){
//      var pageX = event.pageX;//鼠标单击的x坐标
//      var pageY = event.pageY;//鼠标单击的y坐标
//      //获取菜单
//      var contextMenu = $("#tab_" + id);
//      var cssObj = {
//        top:pageY+"px",//设置菜单离页面上边距离，top等效于y坐标
//        left:pageX+"px"//设置菜单离页面左边距离，left等效于x坐标
//      };
//      //判断横向位置（pageX）+自定义菜单宽度之和，如果超过页面宽度及为溢出，需要特殊处理；
////      var menuWidth = contextMenu.width();
////      var pageWidth = $(document).width();
////      console.log("pageX"+pageX+"menuWidth"+menuWidth+":pageWidth"+pageWidth);
////      if(pageX+contextMenu.width()>pageWidth){
////        cssObj.left = pageWidth-menuWidth-5+"px"; //-5是预留右边一点空隙，距离右边太紧不太美观；
////      }
//      //设置菜单的位置
//      $("#context_menu").css(cssObj).show();//显示使用淡入效果,比如不需要动画可以使用show()替换;
//      
//      event.preventDefault();//阻止浏览器与事件相关的默认行为；此处就是弹出右键菜单
//    });
  
};
var closeTab = function (id) {
  //如果关闭的是当前激活的TAB，激活他的前一个TAB
  if ($("#open_nav_tabs li.active").attr('id') == "tab_" + id) {
    $("#tab_" + id).prev().addClass('active');
    $("#" + id).prev().addClass('active');
  }
  if($("li.active").attr('id')=="menu_li_"+ id.split("_")[1]){
	  $("#menu_li_"+id.split("_")[1]).removeClass("active");
  }
  
  //关闭TAB
  $("#tab_" + id).remove();
  $("#" + id).remove();
};

    
$(function () {
  mainHeight = $(document.body).height() - 45;
  $('.main-left,.main-right').height(mainHeight);
  $("[addtabs]").click(function () {
    addTabs({ id: $(this).attr("id"), title: $(this).attr('title'), close: true });
  });
 
  $(".nav-tabs").on("click", "[tabclose]", function (e) {
    id = $(this).attr("tabclose");
    closeTab(id);
  });
  
});