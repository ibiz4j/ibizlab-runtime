import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "DynamicModelStatus",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "0",
                label: "未激活",
                text: "未激活",
                "class":"",
                "data":"",
                "codename":"Item_0",
                "color": "rgba(245, 158, 18, 1)",
                value: "0",
                
                disabled: false,
            },
            {
                id: "1",
                label: "已激活",
                text: "已激活",
                "class":"",
                "data":"",
                "codename":"Item_1",
                "color": "rgba(100, 235, 22, 1)",
                value: "1",
                
                disabled: false,
            },
        ]
    },
    {
        "srfkey": "SysOperator",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"",
        "appdedataset":"",
        "items": []
    }
    ]];
});

