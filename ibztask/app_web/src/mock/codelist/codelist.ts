import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "CodeListJobStatus",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "0",
                label: "ENABLED",
                text: "ENABLED",
                "class":"",
                "data":"",
                "codename":"Item_0",
                "color": "rgba(58, 116, 7, 1)",
                value: 0,
                
                disabled: false,
            },
            {
                id: "1",
                label: "DISABLED",
                text: "DISABLED",
                "class":"",
                "data":"",
                "codename":"Item_1",
                "color": "rgba(67, 65, 65, 1)",
                value: 1,
                
                disabled: false,
            },
        ]
    }
    ]];
});

