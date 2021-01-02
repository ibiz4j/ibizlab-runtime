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
        prop: 'orgid',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'orgname',
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
        name: 'orgid',
        prop: 'orgid',
        dataType: 'TEXT',
      },
      {
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'TEXT',
      },
      {
        name: 'orgname',
        prop: 'orgname',
        dataType: 'TEXT',
      },
      {
        name: 'porgname',
        prop: 'parentorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'orglevel',
        prop: 'orglevel',
        dataType: 'INT',
      },
      {
        name: 'shortname',
        prop: 'shortname',
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
        name: 'porgid',
        prop: 'parentorgid',
        dataType: 'PICKUP',
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
        name: 'sysorganization',
        prop: 'orgid',
        dataType: 'FONTKEY',
      },
    ]
  }

}