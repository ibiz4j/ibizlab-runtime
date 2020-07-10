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
          name: 'address',
          prop: 'address',
          dataType: 'TEXT',
        },
        {
          name: 'trigger_code',
          prop: 'trigger_code',
          dataType: 'INT',
        },
        {
          name: 'create_time',
          prop: 'create_time',
          dataType: 'DATETIME',
        },
        {
          name: 'trigger_type',
          prop: 'trigger_type',
          dataType: 'TEXT',
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
        },
        {
          name: 'fail_retry_count',
          prop: 'fail_retry_count',
          dataType: 'INT',
        },
        {
          name: 'handler',
          prop: 'handler',
          dataType: 'TEXT',
        },
        {
          name: 'job_id',
          prop: 'job_id',
          dataType: 'TEXT',
        },
        {
          name: 'jobslog',
          prop: 'id',
        },
      {
        name: 'n_job_id_eq',
        prop: 'n_job_id_eq',
        dataType: 'TEXT',
      },
      {
        name: 'n_handler_like',
        prop: 'n_handler_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_trigger_code_eq',
        prop: 'n_trigger_code_eq',
        dataType: 'INT',
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