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
	id: 'A47FFDFF-3B2F-429E-9D21-02E0630F6164',
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

