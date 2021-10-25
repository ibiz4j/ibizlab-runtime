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
          name: 'postid',
          prop: 'postid',
          dataType: 'PICKUP',
        },
        {
          name: 'sex',
          prop: 'sex',
          dataType: 'SSCODELIST',
        },
        {
          name: 'phone',
          prop: 'phone',
          dataType: 'TEXT',
        },
        {
          name: 'usercode',
          prop: 'usercode',
          dataType: 'TEXT',
        },
        {
          name: 'mdeptcode',
          prop: 'mdeptcode',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'postname',
          prop: 'postname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'mdeptname',
          prop: 'mdeptname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'postcode',
          prop: 'postcode',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'personname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'userid',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'userid',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'loginname',
          prop: 'loginname',
          dataType: 'TEXT',
        },
        {
          name: 'orgcode',
          prop: 'orgcode',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ipaddr',
          prop: 'ipaddr',
          dataType: 'TEXT',
        },
        {
          name: 'orgid',
          prop: 'orgid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'mdeptid',
          prop: 'mdeptid',
          dataType: 'PICKUP',
        },
        {
          name: 'showorder',
          prop: 'showorder',
          dataType: 'INT',
        },
        {
          name: 'personname',
          prop: 'personname',
          dataType: 'TEXT',
        },
        {
          name: 'sysemployee',
          prop: 'userid',
        },
      {
        name: 'n_usercode_like',
        prop: 'n_usercode_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_personname_like',
        prop: 'n_personname_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_mdeptname_like',
        prop: 'n_mdeptname_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_postname_like',
        prop: 'n_postname_like',
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