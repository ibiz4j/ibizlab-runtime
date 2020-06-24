
export default {
  fields: {
    userroleid: "The major data entity cannot be found",
    roleid: "角色标识",
    rolename: "角色名称",
    userid: "用户标识",
    personname: "用户名称",
    createdate: ">",
    updatedate: "Upload",
  },
	views: {
		gridview: {
			caption: "The workflow instance [{0}] is closed and cannot be submitted for processing",
      		title: "datetime",
		},
		editview: {
			caption: "The workflow instance [{0}] is closed and cannot be submitted for processing",
      		title: "No interaction was found",
		},
	},
	main_form: {
		details: {
			group1: "page", 
			formpage1: "PortalView", 
			srfupdatedate: "Upload", 
			srforikey: "", 
			srfkey: "The major data entity cannot be found", 
			srfmajortext: "用户标识", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			sys_roleid: "角色标识", 
			sys_user_roleid: "The major data entity cannot be found", 
			sys_rolename: "角色名称", 
			sys_username: "用户名称", 
			sys_userid: "用户标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			sys_username: "用户名称",
			sys_rolename: "角色名称",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "In", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem4: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem6: {
			caption: "Copy",
			tip: "Copy {0}",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem9: {
			caption: "-",
			tip: "",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem10: {
			caption: "-",
			tip: "",
		},
		tbitem16: {
			caption: "其它",
			tip: "其它",
		},
		tbitem21: {
			caption: "Export Data Model",
			tip: "导出数据模型",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
		tbitem17: {
			caption: "-",
			tip: "",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "Copy",
			tip: "Copy {0}",
		},
	},
};