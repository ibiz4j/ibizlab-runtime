import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/notify-index-viewappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '46e30d9996c90c9d617fdc7d75936058',
	name: 'menuitem1',
	text: '接入第三方平台',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '接入第三方平台',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-ioxhost',
	icon: '',
	textcls: '',
	appfunctag: 'Auto2',
	resourcetag: '',
},
            {
	id: 'bb418fcd75aff6e293b7b8b416bb01ce',
	name: 'menuitem2',
	text: '消息模板',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '消息模板',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-list-alt',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
},
            {
	id: '6199646ee62aeb492996a780d1c3365f',
	name: 'menuitem3',
	text: '消息账户',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '消息账户',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-user',
	icon: '',
	textcls: '',
	appfunctag: 'Auto3',
	resourcetag: '',
},
        ],
    }];
});

