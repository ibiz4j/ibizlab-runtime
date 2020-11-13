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
        name: 'payopenaccess',
        prop: 'id',
      },
      {
        name: 'name',
      },
      {
        name: 'open_type',
      },
      {
        name: 'access_key',
      },
      {
        name: 'secret_key',
      },
      {
        name: 'region_id',
      },
      {
        name: 'access_token',
      },
      {
        name: 'expires_time',
      },
      {
        name: 'disabled',
      },
      {
        name: 'redirect_uri',
      },
      {
        name: 'notify_url',
      },
      {
        name: 'agent_id',
      },
    ]
  }


}