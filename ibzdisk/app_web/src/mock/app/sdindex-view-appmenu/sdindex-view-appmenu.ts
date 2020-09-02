import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/sdindex-viewappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '541951a398d53d906d35436fcb39a9f3',
	name: 'menuitem1',
	text: '文件',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '文件',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
},
        ],
    }];
});

