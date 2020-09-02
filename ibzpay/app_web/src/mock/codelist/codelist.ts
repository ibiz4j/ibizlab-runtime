import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "OpenAccessType",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "aliyun",
                label: "阿里云",
                text: "阿里云",
                "class":"",
                "data":"",
                "codename":"Aliyun",
                value: "aliyun",
                
                disabled: false,
            },
            {
                id: "wechat",
                label: "微信开放平台",
                text: "微信开放平台",
                "class":"",
                "data":"",
                "codename":"Wechat",
                value: "wechat",
                
                disabled: false,
            },
            {
                id: "qq",
                label: "QQ互联",
                text: "QQ互联",
                "class":"",
                "data":"",
                "codename":"Qq",
                value: "qq",
                
                disabled: false,
            },
            {
                id: "dingtalk",
                label: "钉钉开放平台",
                text: "钉钉开放平台",
                "class":"",
                "data":"",
                "codename":"Dingtalk",
                value: "dingtalk",
                
                disabled: false,
            },
        ]
    }
    ]];
});

