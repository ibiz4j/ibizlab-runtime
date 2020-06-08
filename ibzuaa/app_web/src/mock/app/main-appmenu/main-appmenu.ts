import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/mainappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: 'f59655c22753740bbcf200f5cfee8a54',
	name: 'menuitem3',
	text: '用户',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '用户',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-user',
	icon: '',
	textcls: '',
	appfunctag: 'Auto5',
	resourcetag: '',
},
            {
	id: 'db3e0d48d6e76a66784adc84edd90cdc',
	name: 'menuitem6',
	text: '角色',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '角色',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-unlock-alt',
	icon: '',
	textcls: '',
	appfunctag: 'Auto10',
	resourcetag: '',
},
            {
	id: 'BCF452A9-F6C1-40C9-B107-1D3E9E8839D3',
	name: 'menuitem1',
	text: '认证日志',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '认证日志',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-sort-amount-asc',
	icon: '',
	textcls: '',
	appfunctag: 'Auto6',
	resourcetag: '',
},
            {
	id: '1CDA0214-F2CF-44CD-ACD1-2DE168FF5C0F',
	name: 'menuitem2',
	text: '接入应用',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '接入应用',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-buysellads',
	icon: '',
	textcls: '',
	appfunctag: '_2',
	resourcetag: '',
},
        ],
    }];
});

