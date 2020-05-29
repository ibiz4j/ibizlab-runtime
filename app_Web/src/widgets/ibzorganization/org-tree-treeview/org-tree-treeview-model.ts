/**
 * OrgTree 部件模型
 *
 * @export
 * @class OrgTreeModel
 */
export default class OrgTreeModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof OrgTreeModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'ibzorganization',
        prop: 'orgid',
      },
      {
        name: 'orgcode',
      },
      {
        name: 'orgname',
      },
      {
        name: 'parentorgid',
      },
      {
        name: 'shortname',
      },
      {
        name: 'orglevel',
      },
      {
        name: 'showorder',
      },
      {
        name: 'parentorgname',
      },
      {
        name: 'enable',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
    ]
  }


}