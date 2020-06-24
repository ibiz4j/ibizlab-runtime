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
          name: 'ccode',
          prop: 'code',
          dataType: 'TEXT',
        },
        {
          name: 'cgroup',
          prop: 'group',
          dataType: 'TEXT',
        },
        {
          name: 'memo',
          prop: 'memo',
          dataType: 'TEXT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'cname',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'dictcatalog',
          prop: 'id',
        },
      {
        name: 'n_ccode_like',
        prop: 'n_ccode_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_cname_like',
        prop: 'n_cname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_cgroup_like',
        prop: 'n_cgroup_like',
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