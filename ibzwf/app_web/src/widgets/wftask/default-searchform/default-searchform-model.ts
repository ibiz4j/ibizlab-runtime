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
        name: 'n_description_like',
        prop: 'description',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'n_definitionkey_leftlike',
        prop: 'processdefinitionkey',
        dataType: 'TEXT',
      },
      {
        name: 'n_definitionname_like',
        prop: 'processdefinitionname',
        dataType: 'TEXT',
      },
      {
        name: 'n_taskname_like',
        prop: 'name',
        dataType: 'TEXT',
      },
    ]
  }

}