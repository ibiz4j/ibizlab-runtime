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
        prop: 'definitionkey',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'definitionname',
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
        name: 'definitionkey',
        prop: 'definitionkey',
        dataType: 'TEXT',
      },
      {
        name: 'deploykey',
        prop: 'deploykey',
        dataType: 'TEXT',
      },
      {
        name: 'definitionname',
        prop: 'definitionname',
        dataType: 'TEXT',
      },
      {
        name: 'pssystemid',
        prop: 'pssystemid',
        dataType: 'TEXT',
      },
      {
        name: 'modelversion',
        prop: 'modelversion',
        dataType: 'INT',
      },
      {
        name: 'modelenable',
        prop: 'modelenable',
        dataType: 'YESNO',
      },
      {
        name: 'bpmnfile',
        prop: 'bpmnfile',
        dataType: 'TEXT',
      },
      {
        name: 'md5check',
        prop: 'md5check',
        dataType: 'TEXT',
      },
      {
        name: 'wfprocessdefinition',
        prop: 'definitionkey',
        dataType: 'FONTKEY',
      },
    ]
  }

}