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
        name: 'ibzdepartment',
        prop: 'deptid',
      },
      {
        name: 'deptcode',
      },
      {
        name: 'deptname',
      },
      {
        name: 'orgid',
      },
      {
        name: 'parentdeptid',
      },
      {
        name: 'shortname',
      },
      {
        name: 'deptlevel',
      },
      {
        name: 'domains',
      },
      {
        name: 'showorder',
      },
      {
        name: 'bcode',
      },
      {
        name: 'leaderid',
      },
      {
        name: 'leadername',
      },
      {
        name: 'enable',
      },
      {
        name: 'orgname',
      },
      {
        name: 'parentdeptname',
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