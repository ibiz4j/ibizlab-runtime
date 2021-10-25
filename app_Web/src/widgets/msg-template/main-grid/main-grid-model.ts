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
          name: 'accessname',
          prop: 'access_name',
          dataType: 'PICKUPTEXT',
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
          name: 'accessid',
          prop: 'access_id',
          dataType: 'PICKUP',
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
          name: 'srfmajortext',
          prop: 'template_name',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'tid',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'tid',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'msgtemplate',
          prop: 'tid',
        },
      {
        name: 'n_accessname_like',
        prop: 'n_accessname_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_template_name_like',
        prop: 'n_template_name_like',
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
        // 预置工作流数据字段
        {
          name: 'srfprocessdefinitionkey',
          prop: 'srfprocessdefinitionkey',
          dataType: 'TEXT'
        },
        {
          name: 'srftaskdefinitionkey',
          prop: 'srftaskdefinitionkey',
          dataType: 'TEXT'
        },
        {
          name: 'srftaskid',
          prop: 'srftaskid',
          dataType: 'TEXT'
        }
      ]
    }
  }

}