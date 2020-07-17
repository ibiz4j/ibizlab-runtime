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
          name: 'memo',
          prop: 'memo',
          dataType: 'TEXT',
        },
        {
          name: 'sys_rolename',
          prop: 'rolename',
          dataType: 'TEXT',
        },
        {
          name: 'sys_roleid',
          prop: 'roleid',
          dataType: 'GUID',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'rolename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'roleid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'roleid',
          dataType: 'GUID',
          isEditable:true
        },
        {
          name: 'sysrole',
          prop: 'roleid',
        },
      {
        name: 'n_sys_rolename_like',
        prop: 'n_sys_rolename_like',
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