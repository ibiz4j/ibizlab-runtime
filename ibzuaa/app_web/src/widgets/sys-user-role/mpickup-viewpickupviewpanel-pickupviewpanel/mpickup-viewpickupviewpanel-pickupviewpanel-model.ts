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
        name: 'sysuserrole',
        prop: 'userroleid',
      },
      {
        name: 'roleid',
      },
      {
        name: 'rolename',
      },
      {
        name: 'userid',
      },
      {
        name: 'personname',
      },
      {
        name: 'loginname',
      },
      {
        name: 'orgname',
      },
      {
        name: 'mdeptname',
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