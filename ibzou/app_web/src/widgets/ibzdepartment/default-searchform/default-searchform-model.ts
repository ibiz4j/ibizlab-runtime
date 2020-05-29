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
        name: 'n_deptcode_like',
        prop: 'deptcode',
        dataType: 'TEXT',
      },
      {
        name: 'n_deptname_like',
        prop: 'deptname',
        dataType: 'TEXT',
      },
      {
        name: 'n_orgid_eq',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'n_pdeptid_eq',
        prop: 'parentdeptid',
        dataType: 'PICKUP',
      },
      {
        name: 'n_bcode_like',
        prop: 'bcode',
        dataType: 'TEXT',
      },
    ]
  }

}