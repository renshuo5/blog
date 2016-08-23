$(function () {
			$.ajax({
				 type: "GET",
	             url: "/manage/navigation",
	             dataType: "json",
	             success: function(data){
	                         
	             }
			});
			
		    $('#menu').sidebarMenu({
		        data: [{
		          id: '1',
		          text: '系统设置',
		          icon: 'icon-cog',
		          url: '',
		          menus: [{
		            id: '11',
		            text: '编码管理',
		            icon: 'icon-glass',
		            url: '/CodeType/Index'
		          }]
		        }, {
		          id: '2',
		          text: '基础数据',
		          icon: 'icon-leaf',
		          url: '',
		          menus: [{
		            id: '21',
		            text: '基础特征',
		            icon: 'icon-glass',
		            url: '/BasicData/BasicFeature/Index'
		          }, {
		            id: '22',
		            text: '特征管理',
		            icon: 'icon-glass',
		            url: '/BasicData/Features/Index'
		          }, {
		            id: '23',
		            text: '物料维护',
		            icon: 'icon-glass',
		            url: '/Model/Index'
		          }, {
		            id: '24',
		            text: '站点管理',
		            icon: 'icon-glass',
		            url: '/Station/Index'
		          }]
		        }, {
		          id: '3',
		          text: '权限管理',
		          icon: 'icon-user',
		          url: '',
		          menus: [{
		            id: '31',
		            text: '用户管理',
		            icon: 'icon-user',
		            url: '/SystemSetting/User'
		          }, {
		            id: '32',
		            text: '角色管理',
		            icon: 'icon-apple',
		            url: '/SystemSetting/Role'
		          }, {
		            id: '33',
		            text: '菜单管理',
		            icon: 'icon-list',
		            url: '/SystemSetting/Menu'
		          }, {
		            id: '34',
		            text: '部门管理',
		            icon: 'icon-glass',
		            url: '/SystemSetting/Department'
		          }]
		        }, {
		          id: '4',
		          text: '订单管理',
		          icon: 'icon-envelope',
		          url: '',
		          menus: [{
		            id: '41',
		            text: '订单查询',
		            icon: 'icon-glass',
		            url: '/Order/Query'
		          }, {
		            id: '42',
		            text: '订单排产',
		            icon: 'icon-glass',
		            url: '/Order/PLANTPRODUCT'
		          }, {
		            id: '43',
		            text: '订单撤排',
		            icon: 'icon-glass',
		            url: '/Order/cancelPRODUCT'
		          }, {
		            id: '44',
		            text: '订单HOLD',
		            icon: 'icon-glass',
		            url: '/Order/hold'
		          }, {
		            id: '45',
		            text: '订单删除',
		            icon: 'icon-glass',
		            url: '/Order/delete'
		          }, {
		            id: '47',
		            text: '订单插单',
		            icon: 'icon-glass',
		            url: '/Order/insertorder'
		          }, {
		            id: '48',
		            text: '订单导入',
		            icon: 'icon-glass',
		            url: '/Order/Import'
		          }]
		        }]
		      });
		    });