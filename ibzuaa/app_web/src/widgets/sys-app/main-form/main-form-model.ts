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
        prop: 'label',
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
        name: 'pssystemid',
        prop: 'systemid',
        dataType: 'PICKUP',
      },
      {
        name: 'appid',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'appname',
        prop: 'label',
        dataType: 'TEXT',
      },
      {
        name: 'apptype',
        prop: 'type',
        dataType: 'SSCODELIST',
      },
      {
        name: 'appgroup',
        prop: 'group',
        dataType: 'TEXT',
      },
      {
        name: 'fullname',
        prop: 'fullname',
        dataType: 'TEXT',
      },
      {
        name: 'icon',
        prop: 'icon',
        dataType: 'TEXT',
      },
      {
        name: 'visabled',
        prop: 'visabled',
        dataType: 'YESNO',
      },
      {
        name: 'addr',
        prop: 'addr',
        dataType: 'TEXT',
      },
      {
        name: 'sysapp',
        prop: 'id',
        dataType: 'FONTKEY',
      },
    ]
  }

}