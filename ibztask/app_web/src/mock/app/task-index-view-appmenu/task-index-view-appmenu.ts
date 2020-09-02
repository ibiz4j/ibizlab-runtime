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
	id: '1533f672a72310f0374987cf5e6a2be1',
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
	id: '2ed1ec3a057e182249e73c42e44b4bef',
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
	id: '0190c56b092d15c61accee1d70ae1d67',
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

