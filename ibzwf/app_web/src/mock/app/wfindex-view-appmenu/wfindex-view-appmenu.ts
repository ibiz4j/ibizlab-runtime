import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/wfindex-viewappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: 'DE6BF5A8-9640-47AF-9AE7-7C73C5FCC8BF',
	name: 'menuitem1',
	text: '流程定义',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '流程定义',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-random',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
},
            {
	id: 'F6C65EF1-F523-466D-9C63-7FA2F87BA90B',
	name: 'menuitem3',
	text: '发布新流程',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '发布新流程',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-arrow-circle-o-up',
	icon: '',
	textcls: '',
	appfunctag: 'Auto3',
	resourcetag: '',
},
            {
	id: 'A2004B9C-B0CE-4180-8C76-6FD90059F17B',
	name: 'menuitem2',
	text: '用户组',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '用户组',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-users',
	icon: '',
	textcls: '',
	appfunctag: 'Auto2',
	resourcetag: '',
},
        ],
    }];
});

