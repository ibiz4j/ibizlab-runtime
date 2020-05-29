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
        prop: 'filepath',
        dataType: 'TEXT',
      },
      {
        name: 'filesize',
        prop: 'filesize',
        dataType: 'INT',
      },
      {
        name: 'fileext',
        prop: 'fileext',
        dataType: 'TEXT',
      },
      {
        name: 'folder',
        prop: 'folder',
        dataType: 'TEXT',
      },
      {
        name: 'digestcode',
        prop: 'digestcode',
        dataType: 'TEXT',
      },
      {
        name: 'ownerid',
        prop: 'ownerid',
        dataType: 'TEXT',
      },
      {
        name: 'ownertype',
        prop: 'ownertype',
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