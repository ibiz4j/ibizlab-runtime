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
        prop: 'deptid',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'deptname',
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
        name: 'deptid',
        prop: 'deptid',
        dataType: 'TEXT',
      },
      {
        name: 'deptcode',
        prop: 'deptcode',
        dataType: 'TEXT',
      },
      {
        name: 'deptname',
        prop: 'deptname',
        dataType: 'TEXT',
      },
      {
        name: 'orgname',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pdeptname',
        prop: 'parentdeptname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'pdeptid',
        prop: 'parentdeptid',
        dataType: 'PICKUP',
      },
      {
        name: 'shortname',
        prop: 'shortname',
        dataType: 'TEXT',
      },
      {
        name: 'bcode',
        prop: 'bcode',
        dataType: 'TEXT',
      },
      {
        name: 'deptlevel',
        prop: 'deptlevel',
        dataType: 'INT',
      },
      {
        name: 'leaderid',
        prop: 'leaderid',
        dataType: 'TEXT',
      },
      {
        name: 'leadername',
        prop: 'leadername',
        dataType: 'TEXT',
      },
      {
        name: 'showorder',
        prop: 'showorder',
        dataType: 'INT',
      },
      {
        name: 'isvalid',
        prop: 'isvalid',
        dataType: 'YESNO',
      },
      {
        name: 'createdate',
        prop: 'createdate',
        dataType: 'DATETIME',
      },
      {
        name: 'updatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'sysdepartment',
        prop: 'deptid',
        dataType: 'FONTKEY',
      },
    ]
  }

}