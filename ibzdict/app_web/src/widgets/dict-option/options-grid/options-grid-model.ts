/**
 * Options 部件模型
 *
 * @export
 * @class OptionsModel
 */
export default class OptionsModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof OptionsGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof OptionsGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'val',
          prop: 'value',
          dataType: 'TEXT',
        },
        {
          name: 'pval',
          prop: 'parent',
          dataType: 'TEXT',
        },
        {
          name: 'cls',
          prop: 'cls',
          dataType: 'TEXT',
        },
        {
          name: 'expired',
          prop: 'expired',
          dataType: 'YESNO',
        },
        {
          name: 'label',
          prop: 'label',
          dataType: 'TEXT',
        },
        {
          name: 'cid',
          prop: 'catalog_id',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'label',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'value_key',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'value_key',
          dataType: 'TEXT',
        },
        {
          name: 'iconcls',
          prop: 'icon_class',
          dataType: 'TEXT',
        },
        {
          name: 'extension',
          prop: 'extension',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'vfilter',
          prop: 'filter',
          dataType: 'TEXT',
        },
        {
          name: 'showorder',
          prop: 'showorder',
          dataType: 'INT',
        },
        {
          name: 'cname',
          prop: 'catalog_name',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'disabled',
          prop: 'disabled',
          dataType: 'YESNO',
        },
        {
          name: 'dictoption',
          prop: 'value_key',
        },
      {
        name: 'n_cname_like',
        prop: 'n_cname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_val_like',
        prop: 'n_val_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_label_like',
        prop: 'n_label_like',
        dataType: 'TEXT',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}