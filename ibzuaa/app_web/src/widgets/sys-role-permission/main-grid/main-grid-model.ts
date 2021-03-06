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
          name: 'sys_rolename',
          prop: 'rolename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'sys_permissionid',
          prop: 'permissionid',
          dataType: 'PICKUP',
        },
        {
          name: 'sys_roleid',
          prop: 'roleid',
          dataType: 'PICKUP',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'permissionid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfdataaccaction',
          prop: 'rolepermissionid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'rolepermissionid',
          dataType: 'GUID',
          isEditable:true
        },
        {
          name: 'sys_permissionname',
          prop: 'permissionname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'sysrolepermission',
          prop: 'rolepermissionid',
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