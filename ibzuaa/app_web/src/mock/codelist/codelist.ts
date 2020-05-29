import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取全部数组
mock.onGet('./assets/json/data-dictionary.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, [
        {
        srfkey: 'CLAuthCode',
        emptytext: '未定义',
        "codelisttype":"static",
        items: [
            {
                id: '200',
                label: '成功',
                text: '成功',
                "data":"",
                "codename":"Item_200",
                "color": "rgba(0, 255, 0, 0)",
                value: '200',
                
                disabled: false,
            },
            {
                id: '400',
                label: '用户不存在',
                text: '用户不存在',
                "data":"",
                "codename":"Item_400",
                value: '400',
                
                disabled: false,
            },
            {
                id: '401.1',
                label: '密码错误',
                text: '密码错误',
                "data":"",
                "codename":"Item_3",
                value: '401.1',
                
                disabled: false,
            },
            {
                id: '401.2',
                label: '配置错误',
                text: '配置错误',
                "data":"",
                "codename":"Item_4",
                "color": "rgba(22, 9, 170, 1)",
                value: '401.2',
                
                disabled: false,
            },
            {
                id: '403.6',
                label: '地址被拒绝',
                text: '地址被拒绝',
                "data":"",
                "codename":"Item_5",
                "color": "rgba(0, 72, 255, 1)",
                value: '403.6',
                
                disabled: false,
            },
        ]
    }
    ]];
});

