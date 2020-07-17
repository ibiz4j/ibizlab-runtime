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
          name: 'cron',
          prop: 'cron',
          dataType: 'TEXT',
        },
        {
          name: 'app',
          prop: 'app',
          dataType: 'TEXT',
        },
        {
          name: 'next_time',
          prop: 'next_time',
          dataType: 'BIGINT',
        },
        {
          name: 'update_time',
          prop: 'update_time',
          dataType: 'DATETIME',
        },
        {
          name: 'status',
          prop: 'status',
          dataType: 'NSCODELIST',
        },
        {
          name: 'last_time',
          prop: 'last_time',
          dataType: 'BIGINT',
        },
        {
          name: 'srfmajortext',
          prop: 'handler',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
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
          name: 'timeout',
          prop: 'timeout',
          dataType: 'INT',
        },
        {
          name: 'handler',
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
        dataType: 'TEXT',
      },
      {
        name: 'n_handler_like',
        prop: 'n_handler_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_status_eq',
        prop: 'n_status_eq',
        dataType: 'NSCODELIST',
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