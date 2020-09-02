import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "paytradeeditview": {
            "title": "支付交易编辑视图",
            "caption": "支付交易",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "pay",
            "viewname": "PayTradeEditView",
            "viewtag": "089cc88e549cef536c3380ccb1ce465f"
        },
        "paytradegridview": {
            "title": "支付交易表格视图",
            "caption": "支付交易",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "pay",
            "viewname": "PayTradeGridView",
            "viewtag": "1f1889a2c3e7f49d9221021499a0f78a"
        },
        "payopenaccessgridview": {
            "title": "支付平台表格视图",
            "caption": "支付平台",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "pay",
            "viewname": "PayOpenAccessGridView",
            "viewtag": "60fe0b9b8535b02baf1a02d5f56c5a9c"
        },
        "payindexview": {
            "title": "pay",
            "caption": "ibizlab",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "pay",
            "viewname": "PayIndexView",
            "viewtag": "9bc4c8beaa1b07a28cb977318653a0bd"
        },
        "payopenaccesspickupgridview": {
            "title": "支付平台选择表格视图",
            "caption": "支付平台",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "pay",
            "viewname": "PayOpenAccessPickupGridView",
            "viewtag": "b1fe00a9dfb2160b1589b4e1e2b1d2fc"
        },
        "payopenaccesspickupview": {
            "title": "支付平台数据选择视图",
            "caption": "支付平台",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "pay",
            "viewname": "PayOpenAccessPickupView",
            "viewtag": "f3bb55ce97b7b94c99782d0cea879eaa"
        },
        "payopenaccesseditview": {
            "title": "支付平台编辑视图",
            "caption": "支付平台",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "pay",
            "viewname": "PayOpenAccessEditView",
            "viewtag": "f5f50734bb86ba01097a7cb19b63d36c"
        }
    }];
});