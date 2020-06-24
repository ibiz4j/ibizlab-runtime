/**
 * Default 部件模型
 *
 * @export
 * @class DefaultModel
 */
export default class DefaultModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DefaultModel
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
        name: 'n_username_like',
        prop: 'username',
        dataType: 'TEXT',
      },
      {
        name: 'n_personname_like',
        prop: 'personname',
        dataType: 'TEXT',
      },
      {
        name: 'n_authcode_eq',
        prop: 'authcode',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_authtime_gtandeq',
        prop: 'authtime',
        dataType: 'DATETIME',
      },
      {
        name: 'n_authtime_ltandeq',
        prop: 'authtime',
        dataType: 'DATETIME',
      },
      {
        name: 'n_domain_like',
        prop: 'domain',
        dataType: 'TEXT',
      },
    ]
  }

}