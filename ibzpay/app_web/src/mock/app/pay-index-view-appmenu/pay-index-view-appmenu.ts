import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/pay-index-viewappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '62d37d214c3103bf6ed1e946106ec677',
	name: 'menuitem1',
	text: '支付平台',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '支付平台',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-ioxhost',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
},
            {
	id: '1e7394867e71eec256933bda6257bcc2',
	name: 'menuitem2',
	text: '交易记录',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '交易记录',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-list-alt',
	icon: '',
	textcls: '',
	appfunctag: 'Auto2',
	resourcetag: '',
},
        ],
    }];
});

