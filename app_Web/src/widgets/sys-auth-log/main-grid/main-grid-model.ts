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
          name: 'macaddr',
          prop: 'macaddr',
          dataType: 'TEXT',
        },
        {
          name: 'authtime',
          prop: 'authtime',
          dataType: 'DATETIME',
        },
        {
          name: 'username',
          prop: 'username',
          dataType: 'TEXT',
        },
        {
          name: 'useragent',
          prop: 'useragent',
          dataType: 'TEXT',
        },
        {
          name: 'ipaddr',
          prop: 'ipaddr',
          dataType: 'TEXT',
        },
        {
          name: 'authcode',
          prop: 'authcode',
          dataType: 'SSCODELIST',
        },
        {
          name: 'domain',
          prop: 'domain',
          dataType: 'TEXT',
        },
        {
          name: 'personname',
          prop: 'personname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'username',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'logid',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'logid',
          dataType: 'TEXT',
        },
        {
          name: 'sysauthlog',
          prop: 'logid',
        },
      {
        name: 'n_username_like',
        prop: 'n_username_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_personname_like',
        prop: 'n_personname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_authcode_eq',
        prop: 'n_authcode_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_domain_like',
        prop: 'n_domain_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_authtime_gtandeq',
        prop: 'n_authtime_gtandeq',
        dataType: 'DATETIME',
      },
      {
        name: 'n_authtime_ltandeq',
        prop: 'n_authtime_ltandeq',
        dataType: 'DATETIME',
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