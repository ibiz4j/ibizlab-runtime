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
	id: '801bacb689744f3de00c39b84618cbf5',
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
	id: 'edcf745c76c1c398b5e5511586f4e4c8',
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

