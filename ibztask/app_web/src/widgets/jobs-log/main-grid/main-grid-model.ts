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
          isEditable:true
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
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_handler_like',
        prop: 'n_handler_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_trigger_code_eq',
        prop: 'n_trigger_code_eq',
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
      ]
    }
  }

}