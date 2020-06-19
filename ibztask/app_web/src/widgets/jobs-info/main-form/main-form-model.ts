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
        name: 'param',
        prop: 'param',
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
        name: 'timeout',
        prop: 'timeout',
        dataType: 'INT',
      },
      {
        name: 'fail_retry_count',
        prop: 'fail_retry_count',
        dataType: 'INT',
      },
      {
        name: 'author',
        prop: 'author',
        dataType: 'TEXT',
      },
      {
        name: 'remark',
        prop: 'remark',
        dataType: 'TEXT',
      },
      {
        name: 'status',
        prop: 'status',
        dataType: 'NSCODELIST',
      },
      {
        name: 'tenant_id',
        prop: 'tenant_id',
        dataType: 'TEXT',
      },
      {
        name: 'create_time',
        prop: 'create_time',
        dataType: 'DATETIME',
      },
      {
        name: 'update_time',
        prop: 'update_time',
        dataType: 'DATETIME',
      },
      {
        name: 'id',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'jobsinfo',
        prop: 'id',
        dataType: 'FONTKEY',
      },
    ]
  }

}