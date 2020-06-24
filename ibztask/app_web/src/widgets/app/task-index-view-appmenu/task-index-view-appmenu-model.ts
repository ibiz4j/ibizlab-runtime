/**
 * TaskIndexView 部件模型
 *
 * @export
 * @class TaskIndexViewModel
 */
export default class TaskIndexViewModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof TaskIndexViewModel
     */
    public items: any[] = [
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
	authtag:'web-TaskIndexView-menuitem3',
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
	authtag:'web-TaskIndexView-menuitem1',
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
	authtag:'web-TaskIndexView-menuitem2',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof TaskIndexViewModel
	 */
	public funcs: any[] = [
        {
            appfunctag: 'Auto3',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'jobsinfogridview',
            deResParameters: [],
            routepath: '/taskindexview/:taskindexview?/jobsinfos/:jobsinfo?/gridview/:gridview?',
            parameters: [
                { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto2',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'jobsloggridview',
            deResParameters: [],
            routepath: '/taskindexview/:taskindexview?/jobslogs/:jobslog?/gridview/:gridview?',
            parameters: [
                { pathName: 'jobslogs', parameterName: 'jobslog' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto1',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'jobsregistrygridview',
            deResParameters: [],
            routepath: '/taskindexview/:taskindexview?/jobsregistries/:jobsregistry?/gridview/:gridview?',
            parameters: [
                { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof TaskIndexViewModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof TaskIndexViewModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}