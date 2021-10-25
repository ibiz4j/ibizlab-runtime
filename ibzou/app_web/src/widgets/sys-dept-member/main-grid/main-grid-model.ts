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
          isEditable:true
        },
        {
          name: 'deptid',
          prop: 'deptid',
          dataType: 'PICKUP',
          isEditable:true
        },
        {
          name: 'postname',
          prop: 'postname',
          dataType: 'PICKUPTEXT',
          isEditable:true
        },
        {
          name: 'userid',
          prop: 'userid',
          dataType: 'PICKUP',
          isEditable:true
        },
        {
          name: 'personname',
          prop: 'personname',
          dataType: 'PICKUPTEXT',
          isEditable:true
        },
        {
          name: 'deptname',
          prop: 'deptname',
          dataType: 'PICKUPTEXT',
          isEditable:true
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
          isEditable:true
        },
        {
          name: 'sysdeptmember',
          prop: 'memberid',
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