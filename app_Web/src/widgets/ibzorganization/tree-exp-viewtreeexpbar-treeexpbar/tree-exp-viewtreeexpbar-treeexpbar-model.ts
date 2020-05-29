/**
 * TreeExpViewtreeexpbar 部件模型
 *
 * @export
 * @class TreeExpViewtreeexpbarModel
 */
export default class TreeExpViewtreeexpbarModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof TreeExpViewtreeexpbarModel
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