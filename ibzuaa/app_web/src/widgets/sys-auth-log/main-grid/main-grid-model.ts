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
          name: 'username',
          prop: 'username',
          dataType: 'TEXT',
        },
        {
          name: 'personname',
          prop: 'personname',
          dataType: 'TEXT',
        },
        {
          name: 'authtime',
          prop: 'authtime',
          dataType: 'DATETIME',
        },
        {
          name: 'authcode',
          prop: 'authcode',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ipaddr',
          prop: 'ipaddr',
          dataType: 'TEXT',
        },
        {
          name: 'macaddr',
          prop: 'macaddr',
          dataType: 'TEXT',
        },
        {
          name: 'useragent',
          prop: 'useragent',
          dataType: 'TEXT',
        },
        {
          name: 'domains',
          prop: 'domain',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'logid',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'srfdataaccaction',
          prop: 'logid',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'username',
          dataType: 'TEXT',
        },
        {
          name: 'sysauthlog',
          prop: 'logid',
        },
      {
        name: 'n_username_like',
        prop: 'n_username_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_personname_like',
        prop: 'n_personname_like',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_authcode_eq',
        prop: 'n_authcode_eq',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_authtime_gtandeq',
        prop: 'n_authtime_gtandeq',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_authtime_ltandeq',
        prop: 'n_authtime_ltandeq',
        dataType: 'QUERYPARAM'
      },
      {
        name: 'n_domains_like',
        prop: 'n_domains_like',
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