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
          dataType: 'TEXT',
        },
        {
          name: 'username',
          prop: 'username',
          dataType: 'TEXT',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'TEXT',
        },
        {
          name: 'userid',
          prop: 'userid',
          dataType: 'TEXT',
        },
        {
          name: 'mdeptname',
          prop: 'mdeptname',
          dataType: 'TEXT',
        },
        {
          name: 'personname',
          prop: 'personname',
          dataType: 'TEXT',
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
          name: 'sysuser',
          prop: 'userid',
        },
      {
        name: 'n_loginname_like',
        prop: 'n_loginname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_personname_like',
        prop: 'n_personname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_orgname_like',
        prop: 'n_orgname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_mdeptname_like',
        prop: 'n_mdeptname_like',
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