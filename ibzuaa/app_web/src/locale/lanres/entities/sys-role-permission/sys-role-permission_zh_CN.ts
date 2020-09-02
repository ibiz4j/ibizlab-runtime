export default {
  fields: {
    rolepermissionid: "角色权限关系表标识",
    roleid: "角色表标识",
    rolename: "角色名称",
    permissionid: "权限表标识",
    permissionname: "权限名称",
    permissiontype: "权限类型",
    permissionenable: "权限类型",
    createdate: "建立时间",
    updatedate: "更新时间",
  },
	views: {
		gridview: {
			caption: "角色权限关系",
      		title: "角色权限关系表表格视图",
		},
		mpickupview: {
			caption: "角色权限关系",
      		title: "角色权限关系表数据多项选择视图",
		},
		pickupgridview: {
			caption: "角色权限关系",
      		title: "角色权限关系表选择表格视图",
		},
		editview2: {
			caption: "角色权限关系",
      		title: "角色权限关系表编辑视图",
		},
		redirectview: {
			caption: "角色权限关系",
      		title: "角色权限关系表数据重定向视图",
		},
		customview: {
			caption: "角色权限关系",
      		title: "角色权限关系自定义视图",
		},
		editview: {
			caption: "角色权限关系",
      		title: "角色权限关系表编辑视图",
		},
		pickupview: {
			caption: "角色权限关系",
      		title: "角色权限关系表数据选择视图",
		},
	},
	main_form: {
		details: {
			group1: "角色权限关系表基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "角色权限关系表标识", 
			srfmajortext: "权限表标识", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			sys_rolename: "角色名称", 
			sys_permissionname: "权限名称", 
			sys_permissionid: "权限表标识", 
			sys_roleid: "角色表标识", 
			sys_role_permissionid: "角色权限关系表标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			sys_rolename: "角色名称",
			sys_permissionname: "权限名称",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem4: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem6: {
			caption: "拷贝",
			tip: "拷贝",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem9: {
			caption: "-",
			tip: "",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem10: {
			caption: "-",
			tip: "",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem12: {
			caption: "新建",
			tip: "新建",
		},
		tbitem13: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "拷贝",
			tip: "拷贝",
		},
	},
	editview2toolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem12: {
			caption: "新建",
			tip: "新建",
		},
		tbitem13: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "拷贝",
			tip: "拷贝",
		},
	},
};