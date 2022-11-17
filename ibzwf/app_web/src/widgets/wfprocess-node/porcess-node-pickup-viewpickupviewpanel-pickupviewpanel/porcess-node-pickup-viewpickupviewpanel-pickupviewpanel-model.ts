/**
 * PorcessNodePickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class PorcessNodePickupViewpickupviewpanelModel
 */
export default class PorcessNodePickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof PorcessNodePickupViewpickupviewpanelModel
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