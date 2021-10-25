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
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'redirect_uri',
          prop: 'redirect_uri',
          dataType: 'TEXT',
        },
        {
          name: 'region_id',
          prop: 'region_id',
          dataType: 'TEXT',
        },
        {
          name: 'access_key',
          prop: 'access_key',
          dataType: 'TEXT',
        },
        {
          name: 'accessid',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'open_type',
          prop: 'open_type',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'id',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'disabled',
          prop: 'disabled',
          dataType: 'YESNO',
        },
        {
          name: 'sysopenaccess',
          prop: 'id',
        },
      {
        name: 'n_accessname_like',
        prop: 'n_accessname_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_open_type_eq',
        prop: 'n_open_type_eq',
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