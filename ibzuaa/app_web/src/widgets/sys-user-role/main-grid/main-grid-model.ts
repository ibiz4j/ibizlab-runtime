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
          isEditable:true
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