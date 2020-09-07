import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "CLSYS_Sex",
        emptytext: "",
        "codelisttype":"static",
        items: [
            {
                id: "男",
                label: "男性",
                text: "男性",
                "class":"",
                "data":"",
                "codename":"Item_1",
                value: "男",
                
                disabled: false,
            },
            {
                id: "女",
                label: "女性",
                text: "女性",
                "class":"",
                "data":"",
                "codename":"Item_2",
                value: "女",
                
                disabled: false,
            },
            {
                id: "性别不详",
                label: "性别不详",
                text: "性别不详",
                "class":"",
                "data":"",
                "codename":"Item_3",
                value: "性别不详",
                
                disabled: false,
            },
        ]
    }
    ]];
});

