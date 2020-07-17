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
          name: 'definitionname',
          prop: 'definitionname',
          dataType: 'TEXT',
        },
        {
          name: 'modelenable',
          prop: 'modelenable',
          dataType: 'YESNO',
        },
        {
          name: 'definitionkey',
          prop: 'definitionkey',
          dataType: 'TEXT',
        },
        {
          name: 'pssystemid',
          prop: 'pssystemid',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'definitionname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'definitionkey',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'definitionkey',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'modelversion',
          prop: 'modelversion',
          dataType: 'INT',
        },
        {
          name: 'wfprocessdefinition',
          prop: 'definitionkey',
        },
      {
        name: 'n_deploykey_like',
        prop: 'n_deploykey_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_definitionname_like',
        prop: 'n_definitionname_like',
        dataType: 'TEXT',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'filter',
          prop:'filter'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}