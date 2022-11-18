/**
 * Jump 部件模型
 *
 * @export
 * @class JumpModel
 */
export default class JumpModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JumpModel
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
        name: 'taskdefinitionname',
        dataType:'FORMITEM',
      },
      {
        name: 'wfusers',
        prop: 'wfusers',
        dataType: 'TEXT',
      },
      {
        name: 'taskdefinitionkey',
        prop: 'taskdefinitionkey',
        dataType: 'TEXT',
      },
      {
        name: 'definitionkey',
        prop: 'processdefinitionkey',
        dataType: 'TEXT',
      },
      {
        name: 'definitionid',
        prop: 'processdefinitionid',
        dataType: 'TEXT',
      },
      {
        name: 'businesskey',
        prop: 'businesskey',
        dataType: 'TEXT',
      },
      {
        name: 'instanceid',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'wfprocessinstance',
        prop: 'id',
        dataType: 'FONTKEY',
      },
    ]
  }

}