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
          prop: 'processdefinitionname',
          dataType: 'TEXT',
        },
        {
          name: 'taskname',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'description',
          prop: 'description',
          dataType: 'LONGTEXT_1000',
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
          name: 'definitionid',
          prop: 'processdefinitionid',
          dataType: 'TEXT',
        },
        {
          name: 'definitionkey',
          prop: 'processdefinitionkey',
          dataType: 'TEXT',
        },
        {
          name: 'instanceid',
          prop: 'processinstanceid',
          dataType: 'TEXT',
        },
        {
          name: 'taskdefinitionkey',
          prop: 'taskdefinitionkey',
          dataType: 'TEXT',
        },
        {
          name: 'taskid',
          prop: 'id',
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
          name: 'srfmajortext',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'wftask',
          prop: 'id',
        },
      {
        name: 'n_description_like',
        prop: 'n_description_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_definitionkey_leftlike',
        prop: 'n_definitionkey_leftlike',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_definitionname_like',
        prop: 'n_definitionname_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_taskname_like',
        prop: 'n_taskname_like',
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