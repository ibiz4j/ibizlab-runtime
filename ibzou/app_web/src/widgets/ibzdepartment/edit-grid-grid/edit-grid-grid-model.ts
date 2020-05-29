/**
 * EditGrid 部件模型
 *
 * @export
 * @class EditGridModel
 */
export default class EditGridModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof EditGridGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof EditGridGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'leaderid',
          prop: 'leaderid',
          dataType: 'TEXT',
        },
        {
          name: 'bcode',
          prop: 'bcode',
          dataType: 'TEXT',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'deptlevel',
          prop: 'deptlevel',
          dataType: 'INT',
        },
        {
          name: 'srfmajortext',
          prop: 'deptname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'deptid',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'deptid',
          dataType: 'TEXT',
        },
        {
          name: 'leadername',
          prop: 'leadername',
          dataType: 'TEXT',
        },
        {
          name: 'pdeptid',
          prop: 'parentdeptid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgid',
          prop: 'orgid',
          dataType: 'PICKUP',
        },
        {
          name: 'deptcode',
          prop: 'deptcode',
          dataType: 'TEXT',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pdeptname',
          prop: 'parentdeptname',
          dataType: 'PICKUPTEXT',
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
          name: 'deptname',
          prop: 'deptname',
          dataType: 'TEXT',
        },
        {
          name: 'ibzdepartment',
          prop: 'deptid',
        },
      {
        name: 'n_deptcode_like',
        prop: 'n_deptcode_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_deptname_like',
        prop: 'n_deptname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_orgid_eq',
        prop: 'n_orgid_eq',
        dataType: 'PICKUP',
      },
      {
        name: 'n_pdeptid_eq',
        prop: 'n_pdeptid_eq',
        dataType: 'PICKUP',
      },
      {
        name: 'n_bcode_like',
        prop: 'n_bcode_like',
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