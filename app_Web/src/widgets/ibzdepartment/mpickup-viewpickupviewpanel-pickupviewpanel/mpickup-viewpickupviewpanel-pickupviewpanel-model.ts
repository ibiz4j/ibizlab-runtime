/**
 * MPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class MPickupViewpickupviewpanelModel
 */
export default class MPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof MPickupViewpickupviewpanelModel
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