/**
 * PickupView_norepeatpickupviewpanel 部件模型
 *
 * @export
 * @class PickupView_norepeatpickupviewpanelModel
 */
export default class PickupView_norepeatpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof PickupView_norepeatpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'sysrole',
        prop: 'roleid',
      },
      {
        name: 'rolename',
      },
      {
        name: 'memo',
      },
      {
        name: 'proleid',
      },
      {
        name: 'prolename',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'updateman',
      },
    ]
  }


}