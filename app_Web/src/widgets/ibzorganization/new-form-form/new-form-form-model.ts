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
        name: 'porgid',
        prop: 'parentorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'enable',
        prop: 'enable',
        dataType: 'YESNO',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'TEXT',
      },
      {
        name: 'ibzorganization',
        prop: 'orgid',
        dataType: 'FONTKEY',
      },
    ]
  }

}