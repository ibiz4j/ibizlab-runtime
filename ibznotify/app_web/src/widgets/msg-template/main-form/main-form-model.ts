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
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'tid',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'template_name',
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
        name: 'accessid',
        prop: 'access_id',
        dataType: 'PICKUP',
      },
      {
        name: 'accessname',
        prop: 'access_name',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'open_type',
        prop: 'open_type',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'template_type',
        prop: 'template_type',
        dataType: 'SSCODELIST',
      },
      {
        name: 'template_name',
        prop: 'template_name',
        dataType: 'TEXT',
      },
      {
        name: 'template_id',
        prop: 'template_id',
        dataType: 'TEXT',
      },
      {
        name: 'content',
        prop: 'content',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'template_url',
        prop: 'template_url',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'tid',
        prop: 'tid',
        dataType: 'TEXT',
      },
      {
        name: 'msgtemplate',
        prop: 'tid',
        dataType: 'FONTKEY',
      },
    ]
  }

}