/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'id',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'name',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'filename',
        prop: 'name',
        dataType: 'TEXT',
      },
      {
        name: 'filepath',
        prop: 'file_path',
        dataType: 'TEXT',
      },
      {
        name: 'filesize',
        prop: 'file_size',
        dataType: 'INT',
      },
      {
        name: 'fileext',
        prop: 'extension',
        dataType: 'TEXT',
      },
      {
        name: 'folder',
        prop: 'folder',
        dataType: 'TEXT',
      },
      {
        name: 'digestcode',
        prop: 'digest_code',
        dataType: 'TEXT',
      },
      {
        name: 'ownerid',
        prop: 'owner_id',
        dataType: 'TEXT',
      },
      {
        name: 'ownertype',
        prop: 'owner_type',
        dataType: 'TEXT',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'TEXT',
      },
      {
        name: 'createman',
        prop: 'createman',
        dataType: 'TEXT',
      },
      {
        name: 'createdate',
        prop: 'createdate',
        dataType: 'DATETIME',
      },
      {
        name: 'updateman',
        prop: 'updateman',
        dataType: 'TEXT',
      },
      {
        name: 'updatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'fileid',
        prop: 'id',
        dataType: 'TEXT',
      },
    ]
  }

}