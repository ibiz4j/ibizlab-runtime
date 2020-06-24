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
        name: 'n_ccode_like',
        prop: 'code',
        dataType: 'TEXT',
      },
      {
        name: 'n_cname_like',
        prop: 'name',
        dataType: 'TEXT',
      },
      {
        name: 'n_cgroup_like',
        prop: 'group',
        dataType: 'TEXT',
      },
    ]
  }

}