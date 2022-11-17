/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'definitionkey',
          prop: 'definitionkey',
          dataType: 'TEXT',
        },
        {
          name: 'definitionname',
          prop: 'definitionname',
          dataType: 'TEXT',
        },
        {
          name: 'pssystemid',
          prop: 'pssystemid',
          dataType: 'TEXT',
        },
        {
          name: 'modelversion',
          prop: 'modelversion',
          dataType: 'INT',
        },
        {
          name: 'modelenable',
          prop: 'modelenable',
          dataType: 'YESNO',
        },
        {
          name: 'srfkey',
          prop: 'definitionkey',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'srfdataaccaction',
          prop: 'definitionkey',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'definitionname',
          dataType: 'TEXT',
        },
        {
          name: 'wfprocessdefinition',
          prop: 'definitionkey',
        },
      {
        name: 'n_deploykey_like',
        prop: 'n_deploykey_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_definitionname_like',
        prop: 'n_definitionname_like',
        dataType: 'QUERYPARAM'
      },

        {
          name:'size',
          prop:'size',
          dataType: 'QUERYPARAM'
        },
        {
          name:'query',
          prop:'query',
          dataType: 'QUERYPARAM'
        },
        {
          name:'filter',
          prop:'filter',
          dataType: 'QUERYPARAM'
        },
        {
          name:'page',
          prop:'page',
          dataType: 'QUERYPARAM'
        },
        {
          name:'sort',
          prop:'sort',
          dataType: 'QUERYPARAM'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata',
          dataType: 'QUERYPARAM'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
        // 预置工作流数据字段
        {
          name: 'srfprocessdefinitionkey',
          prop: 'srfprocessdefinitionkey',
          dataType: 'TEXT'
        },
        {
          name: 'srftaskdefinitionkey',
          prop: 'srftaskdefinitionkey',
          dataType: 'TEXT'
        },
        {
          name: 'srftaskid',
          prop: 'srftaskid',
          dataType: 'TEXT'
        }
      ]
    }
  }

}