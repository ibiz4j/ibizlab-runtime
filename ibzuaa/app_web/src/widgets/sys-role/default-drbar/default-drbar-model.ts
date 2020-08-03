/**
 * Default 部件模型
 *
 * @export
 * @class DefaultModel
 */
export default class DefaultModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof DefaultModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'sysrole',
        prop: 'roleid',
      },
      {
        name: 'rolename',
      },
      {
        name: 'memo',
      },
      {
        name: 'proleid',
      },
      {
        name: 'prolename',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'updateman',
      },
    ]
  }


}