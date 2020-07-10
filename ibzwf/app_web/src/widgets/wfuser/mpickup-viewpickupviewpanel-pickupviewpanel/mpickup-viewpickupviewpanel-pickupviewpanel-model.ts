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
        name: 'wfuser',
        prop: 'id',
      },
      {
        name: 'firstname',
      },
      {
        name: 'displayname',
      },
      {
        name: 'mdeptid',
      },
      {
        name: 'mdeptcode',
      },
      {
        name: 'mdeptname',
      },
      {
        name: 'bcode',
      },
      {
        name: 'orgid',
      },
      {
        name: 'orgcode',
      },
      {
        name: 'orgname',
      },
    ]
  }


}