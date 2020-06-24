import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/app-index-viewappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '3F92DBA9-3532-49CD-A482-E9048A132684',
	name: 'menuitem1',
	text: '目录',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '目录',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-folder-open-o',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
},
            {
	id: '73B8AFA0-9EDB-4224-93B8-F8B7C4D01AE3',
	name: 'menuitem2',
	text: '栏目',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '栏目',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-stack-exchange',
	icon: '',
	textcls: '',
	appfunctag: 'Auto2',
	resourcetag: '',
},
        ],
    }];
});

