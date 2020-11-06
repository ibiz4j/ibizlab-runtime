export default {
  fields: {
    permissionid: "资源标识",
    permissionname: "资源名称",
    permissiontype: "资源类别",
    pssystemid: "系统",
    enable: "逻辑有效",
    createdate: "建立时间",
    updatedate: "更新时间",
  },
	views: {
		pickupview: {
			caption: "权限/资源",
      		title: "权限表数据选择视图",
		},
		mpickupview: {
			caption: "权限/资源",
      		title: "权限表数据多项选择视图",
		},
		pickupgridview: {
			caption: "权限/资源",
      		title: "权限表选择表格视图",
		},
	},
	main_grid: {
		columns: {
			sys_permissionid: "资源标识",
			sys_permissionname: "资源名称",
		},
		nodata:"",
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
};