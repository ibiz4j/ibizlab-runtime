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
          name: 'fileext',
          prop: 'extension',
          dataType: 'TEXT',
        },
        {
          name: 'filepath',
          prop: 'file_path',
          dataType: 'TEXT',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'fileid',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'ownerid',
          prop: 'owner_id',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'id',
          dataType: 'TEXT',
          isEditable:true
        },
        {
          name: 'srfdataaccaction',
          prop: 'id',
          dataType: 'TEXT',
        },
        {
          name: 'folder',
          prop: 'folder',
          dataType: 'TEXT',
        },
        {
          name: 'filesize',
          prop: 'file_size',
          dataType: 'INT',
        },
        {
          name: 'filename',
          prop: 'name',
          dataType: 'TEXT',
        },
        {
          name: 'ownertype',
          prop: 'owner_type',
          dataType: 'TEXT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'sdfile',
          prop: 'id',
        },
      {
        name: 'n_filename_like',
        prop: 'n_filename_like',
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
      ]
    }
  }

}