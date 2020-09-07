/**
 * NewForm 部件模型
 *
 * @export
 * @class NewFormModel
 */
export default class NewFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof NewFormModel
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
        name: 'pdeptid',
        prop: 'parentdeptid',
        dataType: 'PICKUP',
      },
      {
        name: 'pdeptname',
        prop: 'parentdeptname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'enable',
        prop: 'enable',
        dataType: 'YESNO',
      },
      {
        name: 'deptid',
        prop: 'deptid',
        dataType: 'TEXT',
      },
      {
        name: 'sysdepartment',
        prop: 'deptid',
        dataType: 'FONTKEY',
      },
    ]
  }

}