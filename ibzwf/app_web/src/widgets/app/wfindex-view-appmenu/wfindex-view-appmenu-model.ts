/**
 * WFIndexView 部件模型
 *
 * @export
 * @class WFIndexViewModel
 */
export default class WFIndexViewModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof WFIndexViewModel
     */
    public items: any[] = [
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
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof WFIndexViewModel
	 */
	public funcs: any[] = [
        {
            appfunctag: 'Auto3',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'wfremodeleditview',
            deResParameters: [],
            routepath: '/wfindexview/:wfindexview?/wfremodels/:wfremodel?/editview/:editview?',
            parameters: [
                { pathName: 'wfremodels', parameterName: 'wfremodel' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
        },
        {
            appfunctag: 'Auto1',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'wfprocessdefinitiongridview',
            deResParameters: [],
            routepath: '/wfindexview/:wfindexview?/wfprocessdefinitions/:wfprocessdefinition?/gridview/:gridview?',
            parameters: [
                { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto2',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'wfgroupgridview',
            deResParameters: [],
            routepath: '/wfindexview/:wfindexview?/wfgroups/:wfgroup?/gridview/:gridview?',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof WFIndexViewModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof WFIndexViewModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}