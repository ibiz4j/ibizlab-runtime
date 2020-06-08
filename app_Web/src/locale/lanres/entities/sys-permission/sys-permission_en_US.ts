
export default {
  fields: {
    permissionid: '资源标识',
    permissionname: '资源名称',
    permissiontype: '资源类别',
    pssystemid: '系统',
    enable: '逻辑有效',
    createdate: '>',
    updatedate: 'Upload',
  },
	views: {
		pickupview: {
			caption: "<>",
      title: '权限/资源',
		},
		mpickupview: {
			caption: "<>",
      title: '权限/资源',
		},
		pickupgridview: {
			caption: "<>",
      title: 'Add',
		},
	},
	main_grid: {
		columns: {
			sys_permissionid: "资源标识",
			sys_permissionname: "资源名称",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "Restart", 
		},
		uiactions: {
		},
	},
};