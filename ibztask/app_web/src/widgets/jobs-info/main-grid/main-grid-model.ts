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
          name: 'id',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'remark',
          prop: 'remark',
          dataType: 'TEXT',
        },
        {
          name: 'app',
          prop: 'app',
          dataType: 'TEXT',
        },
        {
          name: 'handler',
          prop: 'handler',
          dataType: 'TEXT',
        },
        {
          name: 'cron',
          prop: 'cron',
          dataType: 'TEXT',
        },
        {
          name: 'last_time',
          prop: 'last_time',
          dataType: 'BIGINT',
        },
        {
          name: 'next_time',
          prop: 'next_time',
          dataType: 'BIGINT',
        },
        {
          name: 'status',
          prop: 'status',
          dataType: 'NSCODELIST',
        },
        {
          name: 'timeout',
          prop: 'timeout',
          dataType: 'INT',
        },
        {
          name: 'update_time',
          prop: 'update_time',
          dataType: 'DATETIME',
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
          prop: 'handler',
          dataType: 'TEXT',
        },
        {
          name: 'jobsinfo',
          prop: 'id',
        },
      {
        name: 'n_app_like',
        prop: 'n_app_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_handler_like',
        prop: 'n_handler_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_status_eq',
        prop: 'n_status_eq',
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