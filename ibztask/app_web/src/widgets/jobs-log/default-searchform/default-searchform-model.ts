/**
 * Default 部件模型
 *
 * @export
 * @class DefaultModel
 */
export default class DefaultModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DefaultModel
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
        name: 'n_job_id_eq',
        prop: 'job_id',
        dataType: 'TEXT',
      },
      {
        name: 'n_handler_like',
        prop: 'handler',
        dataType: 'TEXT',
      },
      {
        name: 'n_trigger_code_eq',
        prop: 'trigger_code',
        dataType: 'INT',
      },
    ]
  }

}