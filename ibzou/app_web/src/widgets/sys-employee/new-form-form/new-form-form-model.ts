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
        name: 'orgname',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'PICKUPDATA',
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
        name: 'mdeptid',
        prop: 'mdeptid',
        dataType: 'PICKUP',
      },
      {
        name: 'enable',
        prop: 'enable',
        dataType: 'YESNO',
      },
      {
        name: 'bcode',
        prop: 'bcode',
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