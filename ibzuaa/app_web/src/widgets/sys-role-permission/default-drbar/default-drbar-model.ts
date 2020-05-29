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
        name: 'sysrolepermission',
        prop: 'rolepermissionid',
      },
      {
        name: 'roleid',
      },
      {
        name: 'rolename',
      },
      {
        name: 'permissionid',
      },
      {
        name: 'permissionname',
      },
      {
        name: 'permissiontype',
      },
      {
        name: 'permissionenable',
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