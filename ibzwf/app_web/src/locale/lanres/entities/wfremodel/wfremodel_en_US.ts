
export default {
  fields: {
    id: 'ID',
    name: '名称',
    bpmnfile: 'BPMN',
  },
	views: {
		editview: {
			caption: "流程模型",
      title: '流程模型编辑视图',
		},
	},
	main_form: {
		details: {
			group1: "流程模型", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "ID", 
			srfmajortext: "名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			bpmnfile: "BPMN", 
			modelid: "ID", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem1: {
			caption: "Save",
			tip: "Save",
		},
	},
};