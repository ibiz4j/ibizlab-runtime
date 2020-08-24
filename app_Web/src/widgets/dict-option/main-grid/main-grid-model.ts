/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
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
          isEditable:true
        },
        {
          name: 'pval',
          prop: 'parent',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'cls',
          prop: 'cls',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'expired',
          prop: 'expired',
          dataType: 'YESNO',
          isEditable:true
        },
        {
          name: 'label',
          prop: 'label',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'cid',
          prop: 'catalog_id',
          dataType: 'PICKUP',
          isEditable:true
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
          isEditable:true
        },
        {
          name: 'iconcls',
          prop: 'icon_class',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'extension',
          prop: 'extension',
          dataType: 'LONGTEXT_1000',
          isEditable:true
        },
        {
          name: 'vfilter',
          prop: 'filter',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'showorder',
          prop: 'showorder',
          dataType: 'INT',
          isEditable:true
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'cname',
          prop: 'catalog_name',
          dataType: 'PICKUPTEXT',
          isEditable:true
        },
        {
          name: 'disabled',
          prop: 'disabled',
          dataType: 'YESNO',
          isEditable:true
        },
        {
          name: 'dictoption',
          prop: 'value_key',
        },
      {
        name: 'n_cname_like',
        prop: 'n_cname_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_val_like',
        prop: 'n_val_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_label_like',
        prop: 'n_label_like',
        dataType: 'QUERYPARAM'
      },

        {
          name:'size',
          prop:'size',
          dataType: 'QUERYPARAM'
        },
        {
          name:'query',
          prop:'query',
          dataType: 'QUERYPARAM'
        },
        {
          name:'filter',
          prop:'filter',
          dataType: 'QUERYPARAM'
        },
        {
          name:'page',
          prop:'page',
          dataType: 'QUERYPARAM'
        },
        {
          name:'sort',
          prop:'sort',
          dataType: 'QUERYPARAM'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata',
          dataType: 'QUERYPARAM'
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