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
          isEditable:true
        },
        {
          name: 'visabled',
          prop: 'visabled',
          dataType: 'YESNO',
          isEditable:true
        },
        {
          name: 'appname',
          prop: 'label',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'appid',
          prop: 'id',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'pssystemid',
          prop: 'systemid',
          dataType: 'PICKUP',
          isEditable:true
        },
        {
          name: 'addr',
          prop: 'addr',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'apptype',
          prop: 'type',
          dataType: 'SSCODELIST',
          isEditable:true
        },
        {
          name: 'srfmajortext',
          prop: 'label',
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
          name: 'fullname',
          prop: 'fullname',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'appgroup',
          prop: 'group',
          dataType: 'TEXT',
          isEditable:true
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
          name:'filter',
          prop:'filter'
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