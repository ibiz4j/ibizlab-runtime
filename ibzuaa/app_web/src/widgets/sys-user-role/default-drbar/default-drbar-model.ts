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
        name: 'sysuserrole',
        prop: 'userroleid',
      },
      {
        name: 'roleid',
      },
      {
        name: 'rolename',
      },
      {
        name: 'userid',
      },
      {
        name: 'personname',
      },
      {
        name: 'loginname',
      },
      {
        name: 'orgname',
      },
      {
        name: 'mdeptname',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
    ]
  }


}