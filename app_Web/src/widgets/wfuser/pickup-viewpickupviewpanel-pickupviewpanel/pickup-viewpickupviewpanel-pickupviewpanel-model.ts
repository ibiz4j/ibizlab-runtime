/**
 * PickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class PickupViewpickupviewpanelModel
 */
export default class PickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof PickupViewpickupviewpanelModel
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