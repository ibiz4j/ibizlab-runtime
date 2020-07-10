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
          name: 'deptid',
          prop: 'deptid',
          dataType: 'PICKUP',
        },
        {
          name: 'postname',
          prop: 'postname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'userid',
          prop: 'userid',
          dataType: 'PICKUP',
        },
        {
          name: 'personname',
          prop: 'personname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'deptname',
          prop: 'deptname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'personname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'memberid',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'memberid',
          dataType: 'TEXT',
        },
        {
          name: 'ibzdeptmember',
          prop: 'memberid',
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