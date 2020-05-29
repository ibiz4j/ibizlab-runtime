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
        prop: 'memberid',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'membername',
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
        name: 'groupid',
        prop: 'groupid',
        dataType: 'PICKUP',
      },
      {
        name: 'userid',
        prop: 'userid',
        dataType: 'PICKUP',
      },
      {
        name: 'personname',
        prop: 'personname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'memberid',
        prop: 'memberid',
        dataType: 'TEXT',
      },
      {
        name: 'wfmember',
        prop: 'memberid',
        dataType: 'FONTKEY',
      },
    ]
  }

}