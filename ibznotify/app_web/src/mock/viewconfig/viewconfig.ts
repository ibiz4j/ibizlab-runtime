import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "msgopenaccesspickupgridview": {
            "title": "接入开放平台选择表格视图",
            "caption": "接入开放平台",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "notify",
            "viewname": "MsgOpenAccessPickupGridView",
            "viewtag": "05c6db43c9d5946f3f6da2d2b122fcdb"
        },
        "msgopenaccessgridview": {
            "title": "接入开放平台表格视图",
            "caption": "接入开放平台",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "notify",
            "viewname": "MsgOpenAccessGridView",
            "viewtag": "13944c37e6cb87c6aca28dec7b31892e"
        },
        "msgtemplategridview": {
            "title": "消息模板表格视图",
            "caption": "消息模板",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "notify",
            "viewname": "MsgTemplateGridView",
            "viewtag": "2ac24526f9a5f79abb2b9d474e57be0a"
        },
        "msgtemplateeditview": {
            "title": "消息模板编辑视图",
            "caption": "消息模板",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "notify",
            "viewname": "MsgTemplateEditView",
            "viewtag": "30868cf27f47d5ec65261c8b6d5c18a1"
        },
        "msguseraccounteditview": {
            "title": "绑定消息账号编辑视图",
            "caption": "绑定消息账号",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "notify",
            "viewname": "MsgUserAccountEditView",
            "viewtag": "4c01113024cb96ba2f6deaa33773f0aa"
        },
        "msgopenaccesspickupview": {
            "title": "接入开放平台数据选择视图",
            "caption": "接入开放平台",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "notify",
            "viewname": "MsgOpenAccessPickupView",
            "viewtag": "5fd5a34016a13395007d949d732cb30d"
        },
        "msgopenaccesseditview": {
            "title": "接入开放平台编辑视图",
            "caption": "接入开放平台",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "notify",
            "viewname": "MsgOpenAccessEditView",
            "viewtag": "6a6e3d13c769ee31fe6ec9cc5508324f"
        },
        "msguseraccountgridview": {
            "title": "绑定消息账号表格视图",
            "caption": "绑定消息账号",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "notify",
            "viewname": "MsgUserAccountGridView",
            "viewtag": "a186d7dee3d83d5f95c27142bece5df6"
        },
        "notifyindexview": {
            "title": "notify",
            "caption": "ibizlab",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "notify",
            "viewname": "NotifyIndexView",
            "viewtag": "b7253a520eec9b5ffa50e7bf6468ccb1"
        }
    }];
});

// 获取视图消息分组信息
mock.onGet('./assets/json/view-message-group.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
    }];
});