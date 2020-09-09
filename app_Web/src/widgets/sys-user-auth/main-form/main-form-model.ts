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
        prop: 'username',
        dataType: 'PICKUPTEXT',
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
        name: 'username',
        prop: 'username',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'identity_type',
        prop: 'identity_type',
        dataType: 'TEXT',
      },
      {
        name: 'identifier',
        prop: 'identifier',
        dataType: 'TEXT',
      },
      {
        name: 'credential',
        prop: 'credential',
        dataType: 'TEXT',
      },
      {
        name: 'userid',
        prop: 'userid',
        dataType: 'PICKUP',
      },
      {
        name: 'authid',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'sysuserauth',
        prop: 'id',
        dataType: 'FONTKEY',
      },
    ]
  }

}