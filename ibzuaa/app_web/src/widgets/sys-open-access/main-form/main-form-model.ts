/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'name',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'accessname',
        prop: 'name',
        dataType: 'TEXT',
      },
      {
        name: 'open_type',
        prop: 'open_type',
        dataType: 'SSCODELIST',
      },
      {
        name: 'access_key',
        prop: 'access_key',
        dataType: 'TEXT',
      },
      {
        name: 'secret_key',
        prop: 'secret_key',
        dataType: 'TEXT',
      },
      {
        name: 'redirect_uri',
        prop: 'redirect_uri',
        dataType: 'TEXT',
      },
      {
        name: 'region_id',
        prop: 'region_id',
        dataType: 'TEXT',
      },
      {
        name: 'disabled',
        prop: 'disabled',
        dataType: 'YESNO',
      },
      {
        name: 'lic',
        dataType:'FORMITEM',
      },
      {
        name: 'accessid',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'sysopenaccess',
        prop: 'id',
        dataType: 'FONTKEY',
      },
    ]
  }

}