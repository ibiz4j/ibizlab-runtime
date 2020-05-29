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
        name: 'sysuser',
        prop: 'userid',
      },
      {
        name: 'username',
      },
      {
        name: 'personname',
      },
      {
        name: 'password',
      },
    ]
  }


}