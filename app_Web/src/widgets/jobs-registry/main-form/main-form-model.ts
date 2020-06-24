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
        prop: 'app',
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
        name: 'app',
        prop: 'app',
        dataType: 'TEXT',
      },
      {
        name: 'address',
        prop: 'address',
        dataType: 'TEXT',
      },
      {
        name: 'status',
        prop: 'status',
        dataType: 'NSCODELIST',
      },
      {
        name: 'id',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'jobsregistry',
        prop: 'id',
        dataType: 'FONTKEY',
      },
    ]
  }

}