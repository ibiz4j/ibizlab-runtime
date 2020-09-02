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
	id: 'f7995aae13c2a12ed1bca0f098371b7f',
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
	authtag:'web-WFIndexView-menuitem1',
},
        {
	id: '2738fed9d24a10a28095fb04fd468883',
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
	authtag:'web-WFIndexView-menuitem3',
},
        {
	id: '27b0edb66e9777d3d6271163680881e8',
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
	authtag:'web-WFIndexView-menuitem2',
},
        {
	id: '4e8e7629980b4670ef786b281bf0feae',
	name: 'menuitem4',
	text: '我的待办',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '我的待办',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-list-alt',
	icon: '',
	textcls: '',
	appfunctag: 'Auto4',
	resourcetag: '',
	authtag:'web-WFIndexView-menuitem4',
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
            appfunctag: 'Auto4',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'wftaskgridview',
            deResParameters: [],
            routepath: '/wfindexview/:wfindexview?/wftasks/:wftask?/gridview/:gridview?',
            parameters: [
                { pathName: 'wftasks', parameterName: 'wftask' },
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