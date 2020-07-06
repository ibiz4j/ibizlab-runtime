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
          name: 'loginname',
          prop: 'loginname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'sys_rolename',
          prop: 'rolename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'sys_username',
          prop: 'personname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'sys_roleid',
          prop: 'roleid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'mdeptname',
          prop: 'mdeptname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'userid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfdataaccaction',
          prop: 'userroleid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'userroleid',
          dataType: 'GUID',
        },
        {
          name: 'sys_userid',
          prop: 'userid',
          dataType: 'PICKUP',
        },
        {
          name: 'sysuserrole',
          prop: 'userroleid',
        },
      {
        name: 'n_sys_username_like',
        prop: 'n_sys_username_like',
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