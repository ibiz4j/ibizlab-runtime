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
        "sdindexview": {
            "title": "ibizlab-disk",
            "caption": "ibizlab-disk",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "disk",
            "viewname": "SDIndexView",
            "viewtag": "c0a8e8c1058d9a5cdb5a6edbf9855886"
        }
    }];
});

// 获取视图消息分组信息
mock.onGet('./assets/json/view-message-group.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
    }];
});