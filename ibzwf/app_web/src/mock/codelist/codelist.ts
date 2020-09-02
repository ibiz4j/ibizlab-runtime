import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        "srfkey": "WFSystemList",
        "emptytext": "未定义",
        "codelisttype":"dynamic",
        "appdataentity":"WFSystem",
        "appdedataset":"FetchDefault",
        "items": []
    },
    {
        srfkey: "YesNo",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "1",
                label: "是",
                text: "是",
                "class":"",
                "data":"",
                "codename":"Item_1",
                value: "1",
                
                disabled: false,
            },
            {
                id: "0",
                label: "否",
                text: "否",
                "class":"",
                "data":"",
                "codename":"Item_0",
                value: "0",
                
                disabled: false,
            },
        ]
    }
    ]];
});

