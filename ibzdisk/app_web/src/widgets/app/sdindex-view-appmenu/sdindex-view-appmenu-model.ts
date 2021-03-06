/**
 * SDIndexView 部件模型
 *
 * @export
 * @class SDIndexViewModel
 */
export default class SDIndexViewModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof SDIndexViewModel
     */
    public items: any[] = [
        {
	id: '541951a398d53d906d35436fcb39a9f3',
	name: 'menuitem1',
	text: '文件',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '文件',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
	authtag:'web-SDIndexView-menuitem1',
},
        {
	id: '1d2cb876f234f9a7ecef37a9b70dd824',
	name: 'menuitem2',
	text: '动态模型',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '动态模型',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: 'AppFunc2',
	resourcetag: '',
	authtag:'web-SDIndexView-menuitem2',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof SDIndexViewModel
	 */
	public funcs: any[] = [
        {
            appfunctag: 'AppFunc2',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'metadynamicmodeldynainstgridview',
            deResParameters: [],
            routepath: '/sdindexview/:sdindexview?/metadynamicmodels/:metadynamicmodel?/dynainstgridview/:dynainstgridview?',
            parameters: [
                { pathName: 'metadynamicmodels', parameterName: 'metadynamicmodel' },
                { pathName: 'dynainstgridview', parameterName: 'dynainstgridview' },
            ],
        },
        {
            appfunctag: 'Auto1',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sdfilegridview',
            deResParameters: [],
            routepath: '/sdindexview/:sdindexview?/sdfiles/:sdfile?/gridview/:gridview?',
            parameters: [
                { pathName: 'sdfiles', parameterName: 'sdfile' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof SDIndexViewModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof SDIndexViewModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}