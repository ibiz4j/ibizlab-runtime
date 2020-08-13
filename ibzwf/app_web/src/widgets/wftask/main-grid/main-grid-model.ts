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
          name: 'definitionid',
          prop: 'processdefinitionid',
          dataType: 'TEXT',
        },
        {
          name: 'taskid',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'id',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'srfdataaccaction',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'createtime',
          prop: 'createtime',
          dataType: 'DATETIME',
        },
        {
          name: 'businesskey',
          prop: 'processinstancebusinesskey',
          dataType: 'TEXT',
        },
        {
          name: 'definitionname',
          prop: 'processdefinitionname',
          dataType: 'TEXT',
        },
        {
          name: 'description',
          prop: 'description',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'taskdefinitionkey',
          prop: 'taskdefinitionkey',
          dataType: 'TEXT',
        },
        {
          name: 'definitionkey',
          prop: 'processdefinitionkey',
          dataType: 'TEXT',
        },
        {
          name: 'taskname',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'instanceid',
          prop: 'processinstanceid',
          dataType: 'TEXT',
        },
        {
          name: 'wftask',
          prop: 'id',
        },
      {
        name: 'n_description_like',
        prop: 'n_description_like',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'n_definitionkey_leftlike',
        prop: 'n_definitionkey_leftlike',
        dataType: 'TEXT',
      },
      {
        name: 'n_definitionname_like',
        prop: 'n_definitionname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_taskname_like',
        prop: 'n_taskname_like',
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