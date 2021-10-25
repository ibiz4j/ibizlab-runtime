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
          isEditable:true
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
          name: 'sysdepartment',
          prop: 'deptid',
        },
      {
        name: 'n_deptcode_like',
        prop: 'n_deptcode_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_deptname_like',
        prop: 'n_deptname_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_orgid_eq',
        prop: 'n_orgid_eq',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_pdeptid_eq',
        prop: 'n_pdeptid_eq',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_bcode_like',
        prop: 'n_bcode_like',
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