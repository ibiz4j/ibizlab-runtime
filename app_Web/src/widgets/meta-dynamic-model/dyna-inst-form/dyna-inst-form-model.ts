/**
 * DynaInst 部件模型
 *
 * @export
 * @class DynaInstModel
 */
export default class DynaInstModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DynaInstModel
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
        prop: 'configid',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'configname',
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
        name: 'configname',
        prop: 'configname',
        dataType: 'TEXT',
      },
      {
        name: 'formitem',
        prop: 'modelfile',
        dataType: 'TEXT',
      },
      {
        name: 'systemid',
        prop: 'system_id',
        dataType: 'TEXT',
      },
      {
        name: 'configid',
        prop: 'configid',
        dataType: 'TEXT',
      },
      {
        name: 'metadynamicmodel',
        prop: 'configid',
        dataType: 'FONTKEY',
      },
    ]
  }

}