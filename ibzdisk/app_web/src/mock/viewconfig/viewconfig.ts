import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "sdfileeditview": {
            "title": "文件编辑视图",
            "caption": "文件",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "disk",
            "viewname": "SDFileEditView",
            "viewtag": "646581c57dbd5cf6c2570e4013f3adb8"
        },
        "sdfilegridview": {
            "title": "文件表格视图",
            "caption": "文件",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "disk",
            "viewname": "SDFileGridView",
            "viewtag": "795a12a2bfb63a98ce5bb80310509360"
        },
        "metadynamicmodeldynainsteditview": {
            "title": "动态模型编辑视图",
            "caption": "动态模型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "lite",
            "viewname": "MetaDynamicModelDynaInstEditView",
            "viewtag": "92d51d41db51a671793ee8dc8876f9e9"
        },
        "metadynamicmodelgridview": {
            "title": "动态模型",
            "caption": "动态模型",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "lite",
            "viewname": "MetaDynamicModelGridView",
            "viewtag": "af9cfc34d957186380a012e322abff0c"
        },
        "sdindexview": {
            "title": "ibizlab-disk",
            "caption": "ibizlab-disk",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "disk",
            "viewname": "SDIndexView",
            "viewtag": "c0a8e8c1058d9a5cdb5a6edbf9855886"
        },
        "metadynamicmodeldynainstgridview": {
            "title": "动态模型表格视图",
            "caption": "动态模型表格视图",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "lite",
            "viewname": "MetaDynamicModelDynaInstGridView",
            "viewtag": "cec3236f5a1f742f9b91f313506ccc6c"
        },
        "metadynamicmodeleditview": {
            "title": "动态模型编辑视图",
            "caption": "动态模型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "lite",
            "viewname": "MetaDynamicModelEditView",
            "viewtag": "e8892afaebe9a899e5d528d5b55d3cc5"
        }
    }];
});

// 获取视图消息分组信息
mock.onGet('./assets/json/view-message-group.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
    }];
});