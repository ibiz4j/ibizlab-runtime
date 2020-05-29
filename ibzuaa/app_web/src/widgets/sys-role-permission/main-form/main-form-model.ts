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
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'rolepermissionid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'permissionid',
        dataType: 'PICKUP',
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
        name: 'sys_rolename',
        prop: 'rolename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sys_permissionname',
        prop: 'permissionname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sys_permissionid',
        prop: 'permissionid',
        dataType: 'PICKUP',
      },
      {
        name: 'sys_roleid',
        prop: 'roleid',
        dataType: 'PICKUP',
      },
      {
        name: 'sys_role_permissionid',
        prop: 'rolepermissionid',
        dataType: 'GUID',
      },
      {
        name: 'sysrolepermission',
        prop: 'rolepermissionid',
        dataType: 'FONTKEY',
      },
    ]
  }

}