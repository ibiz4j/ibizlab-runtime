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
        name: 'sysrolepermission',
        prop: 'rolepermissionid',
      },
      {
        name: 'roleid',
      },
      {
        name: 'rolename',
      },
      {
        name: 'permissionid',
      },
      {
        name: 'permissionname',
      },
      {
        name: 'permissiontype',
      },
      {
        name: 'permissionenable',
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