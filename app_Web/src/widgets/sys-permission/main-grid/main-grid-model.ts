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
          name: 'sys_permissionid',
          prop: 'permissionid',
          dataType: 'GUID',
        },
        {
          name: 'srfmajortext',
          prop: 'permissionname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'permissionid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'permissionid',
          dataType: 'GUID',
          isEditable:true
        },
        {
          name: 'sys_permissionname',
          prop: 'permissionname',
          dataType: 'TEXT',
        },
        {
          name: 'syspermission',
          prop: 'permissionid',
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