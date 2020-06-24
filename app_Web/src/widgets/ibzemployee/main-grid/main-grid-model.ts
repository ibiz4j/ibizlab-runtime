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
          name: 'mdeptname',
          prop: 'mdeptname',
          dataType: 'PICKUPTEXT',
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
          name: 'ibzemployee',
          prop: 'userid',
        },
      {
        name: 'n_usercode_like',
        prop: 'n_usercode_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_personname_like',
        prop: 'n_personname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_mdeptname_like',
        prop: 'n_mdeptname_like',
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