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
          name: 'icon',
          prop: 'icon',
          dataType: 'TEXT',
        },
        {
          name: 'pssystemid',
          prop: 'systemid',
          dataType: 'PICKUP',
        },
        {
          name: 'appid',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'addr',
          prop: 'addr',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'label',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'appname',
          prop: 'label',
          dataType: 'TEXT',
        },
        {
          name: 'visabled',
          prop: 'visabled',
          dataType: 'YESNO',
        },
        {
          name: 'pssystemid_text',
          prop: 'systemid',
          dataType: 'PICKUP',
        },
        {
          name: 'apptype',
          prop: 'type',
          dataType: 'SSCODELIST',
        },
        {
          name: 'appgroup',
          prop: 'group',
          dataType: 'TEXT',
        },
        {
          name: 'fullname',
          prop: 'fullname',
          dataType: 'TEXT',
        },
        {
          name: 'sysapp',
          prop: 'id',
        },
      {
        name: 'n_pssystemid_eq',
        prop: 'n_pssystemid_eq',
        dataType: 'PICKUP',
      },
      {
        name: 'n_appname_like',
        prop: 'n_appname_like',
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