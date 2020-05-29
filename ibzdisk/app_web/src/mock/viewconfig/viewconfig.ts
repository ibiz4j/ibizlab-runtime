import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "sdfilegridview": {
            "title": "文件表格视图",
            "caption": "文件",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "disk",
            "viewname": "SDFileGridView",
            "viewtag": "254cf228e42d864c1cefd0f5526492ad"
        },
        "sdindexview": {
            "title": "ibizlab-disk",
            "caption": "ibizlab-disk",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "disk",
            "viewname": "SDIndexView",
            "viewtag": "84B85718-5EB1-45E3-97F4-A1AC21B4DBE6"
        },
        "sdfileeditview": {
            "title": "文件编辑视图",
            "caption": "文件",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "disk",
            "viewname": "SDFileEditView",
            "viewtag": "d655c8b630fcdc664b330967c012950e"
        }
    }];
});