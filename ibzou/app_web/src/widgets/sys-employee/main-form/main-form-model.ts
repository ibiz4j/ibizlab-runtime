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
        prop: 'userid',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'personname',
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
        name: 'usercode',
        prop: 'usercode',
        dataType: 'TEXT',
      },
      {
        name: 'personname',
        prop: 'personname',
        dataType: 'TEXT',
      },
      {
        name: 'loginname',
        prop: 'loginname',
        dataType: 'TEXT',
      },
      {
        name: 'password',
        prop: 'password',
        dataType: 'TEXT',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'orgname',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'mdeptid',
        prop: 'mdeptid',
        dataType: 'PICKUP',
      },
      {
        name: 'pdeptcheck',
      },
      {
        name: 'mdeptname',
        prop: 'mdeptname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'mdeptcode',
        prop: 'mdeptcode',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'bcode',
        prop: 'bcode',
        dataType: 'TEXT',
      },
      {
        name: 'nickname',
        prop: 'nickname',
        dataType: 'TEXT',
      },
      {
        name: 'sex',
        prop: 'sex',
        dataType: 'SSCODELIST',
      },
      {
        name: 'birthday',
        prop: 'birthday',
        dataType: 'DATE',
      },
      {
        name: 'certcode',
        prop: 'certcode',
        dataType: 'TEXT',
      },
      {
        name: 'phone',
        prop: 'phone',
        dataType: 'TEXT',
      },
      {
        name: 'avatar',
        prop: 'avatar',
        dataType: 'TEXT',
      },
      {
        name: 'email',
        prop: 'email',
        dataType: 'TEXT',
      },
      {
        name: 'ipaddr',
        prop: 'ipaddr',
        dataType: 'TEXT',
      },
      {
        name: 'showorder',
        prop: 'showorder',
        dataType: 'INT',
      },
      {
        name: 'addr',
        prop: 'addr',
        dataType: 'TEXT',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'TEXT',
      },
      {
        name: 'theme',
        prop: 'theme',
        dataType: 'TEXT',
      },
      {
        name: 'lang',
        prop: 'lang',
        dataType: 'TEXT',
      },
      {
        name: 'fontsize',
        prop: 'fontsize',
        dataType: 'TEXT',
      },
      {
        name: 'reserver',
        prop: 'reserver',
        dataType: 'TEXT',
      },
      {
        name: 'usericon',
        prop: 'usericon',
        dataType: 'TEXT',
      },
      {
        name: 'userid',
        prop: 'userid',
        dataType: 'TEXT',
      },
      {
        name: 'sysemployee',
        prop: 'userid',
        dataType: 'FONTKEY',
      },
    ]
  }

}