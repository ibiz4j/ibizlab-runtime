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
        name: 'wfprocessnode',
        prop: 'usertaskid',
      },
      {
        name: 'usertaskname',
      },
      {
        name: 'processdefinitionkey',
      },
      {
        name: 'processdefinitionname',
      },
      {
        name: 'version',
      },
      {
        name: 'cnt',
      },
      {
        name: 'processdefinitionid',
      },
    ]
  }


}