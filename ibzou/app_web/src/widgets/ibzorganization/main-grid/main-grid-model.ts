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
          name: 'orglevel',
          prop: 'orglevel',
          dataType: 'INT',
        },
        {
          name: 'porgname',
          prop: 'parentorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'porgid',
          prop: 'parentorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'orgname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'orgid',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'srfdataaccaction',
          prop: 'orgid',
          dataType: 'TEXT',
        },
        {
          name: 'orgcode',
          prop: 'orgcode',
          dataType: 'TEXT',
        },
        {
          name: 'orgid',
          prop: 'orgid',
          dataType: 'TEXT',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'TEXT',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'TEXT',
        },
        {
          name: 'showorder',
          prop: 'showorder',
          dataType: 'INT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'ibzorganization',
          prop: 'orgid',
        },
      {
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'TEXT',
      },
      {
        name: 'n_orgname_like',
        prop: 'n_orgname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_porgid_eq',
        prop: 'n_porgid_eq',
        dataType: 'PICKUP',
      },
      {
        name: 'porgname',
        prop: 'porgname',
        dataType: 'PICKUPTEXT',
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