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
        prop: 'postid',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'postname',
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
        name: 'postcode',
        prop: 'postcode',
        dataType: 'TEXT',
      },
      {
        name: 'postname',
        prop: 'postname',
        dataType: 'TEXT',
      },
      {
        name: 'domains',
        prop: 'domains',
        dataType: 'TEXT',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'postid',
        prop: 'postid',
        dataType: 'TEXT',
      },
      {
        name: 'syspost',
        prop: 'postid',
        dataType: 'FONTKEY',
      },
    ]
  }

}