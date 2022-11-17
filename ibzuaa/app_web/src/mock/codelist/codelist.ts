import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: "AppType",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "INNER",
                label: "内置应用",
                text: "内置应用",
                "class":"",
                "data":"",
                "codename":"Inner",
                value: "INNER",
                
                disabled: false,
            },
            {
                id: "THIRD-PARTY",
                label: "第三方应用",
                text: "第三方应用",
                "class":"",
                "data":"",
                "codename":"Third_SUB_party",
                value: "THIRD-PARTY",
                
                disabled: false,
            },
        ]
    },
    {
        srfkey: "CLAuthCode",
        emptytext: "未定义",
        "codelisttype":"static",
        items: [
            {
                id: "200",
                label: "成功",
                text: "成功",
                "class":"",
                "data":"",
                "codename":"Item_200",
                "color": "rgba(0, 255, 0, 0)",
                value: "200",
                
                disabled: false,
            },
            {
                id: "400",
                label: "用户不存在",
                text: "用户不存在",
                "class":"",
                "data":"",
                "codename":"Item_400",
                value: "400",
                
                disabled: false,
            },
            {
                id: "401.1",
                label: "密码错误",
                text: "密码错误",
                "class":"",
                "data":"",
                "codename":"Item_3",
                value: "401.1",
                
                disabled: false,
            },
            {
                id: "401.2",
                label: "配置错误",
                text: "配置错误",
                "class":"",
                "data":"",
                "codename":"Item_4",
                "color": "rgba(22, 9, 170, 1)",
                value: "401.2",
                
                disabled: false,
            },
            {
                id: "403.6",
                label: "地址被拒绝",
                text: "地址被拒绝",
                "class":"",
                "data":"",
                "codename":"Item_5",
                "color": "rgba(0, 72, 255, 1)",
                value: "403.6",
                
                disabled: false,
            },
        ]
    },
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
            {
                id: "ldap",
                label: "LDAP",
                text: "LDAP",
                "class":"",
                "data":"",
                "codename":"Ldap",
                value: "ldap",
                
                disabled: false,
            },
            {
                id: "ad",
                label: "AD",
                text: "AD",
                "class":"",
                "data":"",
                "codename":"Ad",
                value: "ad",
                
                disabled: false,
            },
            {
                id: "cas",
                label: "CAS",
                text: "CAS",
                "class":"",
                "data":"",
                "codename":"Cas",
                value: "cas",
                
                disabled: false,
            },
            {
                id: "custom",
                label: "自定义",
                text: "自定义",
                "class":"",
                "data":"",
                "codename":"Custom",
                value: "custom",
                
                disabled: false,
            },
        ]
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

