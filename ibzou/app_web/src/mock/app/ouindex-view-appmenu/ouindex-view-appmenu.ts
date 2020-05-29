import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/ouindex-viewappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: 'CC24ABE9-84D6-4F04-8770-E9739A62AC34',
	name: 'menuitem1',
	text: '单位管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '单位管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-university',
	icon: '',
	textcls: '',
	appfunctag: 'Auto3',
	resourcetag: '',
},
            {
	id: '26353959-9246-4DDF-8ADA-E8A229572BC7',
	name: 'menuitem2',
	text: '部门管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '部门管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-sitemap',
	icon: '',
	textcls: '',
	appfunctag: 'Auto5',
	resourcetag: '',
},
            {
	id: '18F0AA9B-5281-46B7-AC6E-1A40E088AEE8',
	name: 'menuitem3',
	text: '人员管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人员管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-user',
	icon: '',
	textcls: '',
	appfunctag: 'Auto4',
	resourcetag: '',
},
        ],
    }];
});

