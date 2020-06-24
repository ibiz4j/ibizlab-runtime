import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/task-index-viewappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '535929B8-1901-4DD5-8402-6C4156AFBBC8',
	name: 'menuitem3',
	text: '注册',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '注册',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-gear',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
},
            {
	id: 'B1156652-77DE-48DA-8E60-86D3D70685BE',
	name: 'menuitem1',
	text: '任务',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '任务',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-tasks',
	icon: '',
	textcls: '',
	appfunctag: 'Auto3',
	resourcetag: '',
},
            {
	id: '0A22F1FE-2628-45EE-B1BD-EA50A4E87157',
	name: 'menuitem2',
	text: '日志',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '日志',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-align-justify',
	icon: '',
	textcls: '',
	appfunctag: 'Auto2',
	resourcetag: '',
},
        ],
    }];
});

