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
        prop: 'value_key',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'label',
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
        name: 'cname',
        prop: 'catalog_name',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'val',
        prop: 'value',
        dataType: 'TEXT',
      },
      {
        name: 'label',
        prop: 'label',
        dataType: 'TEXT',
      },
      {
        name: 'pval',
        prop: 'parent',
        dataType: 'TEXT',
      },
      {
        name: 'showorder',
        prop: 'showorder',
        dataType: 'INT',
      },
      {
        name: 'disabled',
        prop: 'disabled',
        dataType: 'YESNO',
      },
      {
        name: 'expired',
        prop: 'expired',
        dataType: 'YESNO',
      },
      {
        name: 'vfilter',
        prop: 'filter',
        dataType: 'TEXT',
      },
      {
        name: 'iconcls',
        prop: 'icon_class',
        dataType: 'TEXT',
      },
      {
        name: 'cls',
        prop: 'cls',
        dataType: 'TEXT',
      },
      {
        name: 'extension',
        prop: 'extension',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'cid',
        prop: 'catalog_id',
        dataType: 'PICKUP',
      },
      {
        name: 'vkey',
        prop: 'value_key',
        dataType: 'TEXT',
      },
      {
        name: 'dictoption',
        prop: 'value_key',
        dataType: 'FONTKEY',
      },
    ]
  }

}