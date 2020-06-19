/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'handler',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'job_id',
        prop: 'job_id',
        dataType: 'TEXT',
      },
      {
        name: 'handler',
        prop: 'handler',
        dataType: 'TEXT',
      },
      {
        name: 'param',
        prop: 'param',
        dataType: 'TEXT',
      },
      {
        name: 'fail_retry_count',
        prop: 'fail_retry_count',
        dataType: 'INT',
      },
      {
        name: 'trigger_code',
        prop: 'trigger_code',
        dataType: 'INT',
      },
      {
        name: 'trigger_type',
        prop: 'trigger_type',
        dataType: 'TEXT',
      },
      {
        name: 'trigger_msg',
        prop: 'trigger_msg',
        dataType: 'LONGTEXT',
      },
      {
        name: 'address',
        prop: 'address',
        dataType: 'TEXT',
      },
      {
        name: 'create_time',
        prop: 'create_time',
        dataType: 'DATETIME',
      },
      {
        name: 'id',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'jobslog',
        prop: 'id',
        dataType: 'FONTKEY',
      },
    ]
  }

}