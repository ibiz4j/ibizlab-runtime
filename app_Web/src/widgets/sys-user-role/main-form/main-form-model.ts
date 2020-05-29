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
        prop: 'userroleid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'userid',
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
        name: 'sys_roleid',
        prop: 'roleid',
        dataType: 'PICKUP',
      },
      {
        name: 'sys_user_roleid',
        prop: 'userroleid',
        dataType: 'GUID',
      },
      {
        name: 'sys_rolename',
        prop: 'rolename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sys_username',
        prop: 'personname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sys_userid',
        prop: 'userid',
        dataType: 'PICKUP',
      },
      {
        name: 'sysuserrole',
        prop: 'userroleid',
        dataType: 'FONTKEY',
      },
    ]
  }

}