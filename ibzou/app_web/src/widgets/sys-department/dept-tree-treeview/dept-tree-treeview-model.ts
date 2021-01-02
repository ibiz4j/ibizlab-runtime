/**
 * DeptTree 部件模型
 *
 * @export
 * @class DeptTreeModel
 */
export default class DeptTreeModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof DeptTreeModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'sysdepartment',
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
      {
        name: 'isvalid',
      },
    ]
  }


}