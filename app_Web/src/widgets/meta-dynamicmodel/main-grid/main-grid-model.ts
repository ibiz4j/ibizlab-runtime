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
          name: 'dynainstid',
          prop: 'dynainstid',
          dataType: 'TEXT',
        },
        {
          name: 'systemid',
          prop: 'system_id',
          dataType: 'TEXT',
        },
        {
          name: 'status',
          prop: 'status',
          dataType: 'SSCODELIST',
        },
        {
          name: 'configname',
          prop: 'configname',
          dataType: 'TEXT',
        },
        {
          name: 'pdynainstid',
          prop: 'pdynainstid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'configname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'configid',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'configid',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'meta_dynamicmodel',
          prop: 'configid',
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