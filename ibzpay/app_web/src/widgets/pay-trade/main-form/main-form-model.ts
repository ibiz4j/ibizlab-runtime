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
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'trade_id',
        dataType: 'TEXT',
      },
      {
        name: 'srfmajortext',
        prop: 'trade_name',
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
        name: 'tradename',
        prop: 'trade_name',
        dataType: 'TEXT',
      },
      {
        name: 'outtradeno',
        prop: 'out_trade_no',
        dataType: 'TEXT',
      },
      {
        name: 'subject',
        prop: 'subject',
        dataType: 'TEXT',
      },
      {
        name: 'totalamount',
        prop: 'total_amount',
        dataType: 'TEXT',
      },
      {
        name: 'accessname',
        prop: 'access_name',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'tradeid',
        prop: 'trade_id',
        dataType: 'TEXT',
      },
      {
        name: 'accessid',
        prop: 'access_id',
        dataType: 'PICKUP',
      },
      {
        name: 'paytrade',
        prop: 'trade_id',
        dataType: 'FONTKEY',
      },
    ]
  }

}