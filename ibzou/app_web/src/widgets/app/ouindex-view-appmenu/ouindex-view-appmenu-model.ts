/**
 * OUIndexView 部件模型
 *
 * @export
 * @class OUIndexViewModel
 */
export default class OUIndexViewModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof OUIndexViewModel
     */
    public items: any[] = [
        {
	id: 'da40118e7372d3073b986ea6fb93df59',
	name: 'menuitem1',
	text: '单位管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '单位管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-university',
	icon: '',
	textcls: '',
	appfunctag: 'Auto3',
	resourcetag: '',
	authtag:'web-OUIndexView-menuitem1',
},
        {
	id: '6570af5ada0a428b98d5ba1ca5073298',
	name: 'menuitem2',
	text: '部门管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '部门管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-sitemap',
	icon: '',
	textcls: '',
	appfunctag: 'Auto5',
	resourcetag: '',
	authtag:'web-OUIndexView-menuitem2',
},
        {
	id: '6cfdcaea521dd35aaa969ce9331fc24e',
	name: 'menuitem3',
	text: '人员管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人员管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-user',
	icon: '',
	textcls: '',
	appfunctag: 'Auto4',
	resourcetag: '',
	authtag:'web-OUIndexView-menuitem3',
},
        {
	id: 'd2a12485fdd3bf8ad7f18f689422b006',
	name: 'menuitem4',
	text: '岗位管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '岗位管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-simplybuilt',
	icon: '',
	textcls: '',
	appfunctag: 'Auto6',
	resourcetag: '',
	authtag:'web-OUIndexView-menuitem4',
},
        {
	id: '4a64b39273ba2fb82beadff8315e4d02',
	name: 'menuitem5',
	text: '组管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '组管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-group',
	icon: '',
	textcls: '',
	appfunctag: 'Auto7',
	resourcetag: '',
	authtag:'web-OUIndexView-menuitem5',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof OUIndexViewModel
	 */
	public funcs: any[] = [
        {
            appfunctag: 'Auto3',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ibzorganizationgridview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/ibzorganizations/:ibzorganization?/gridview/:gridview?',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto5',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ibzorganizationtreeexpview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/ibzorganizations/:ibzorganization?/treeexpview/:treeexpview?',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
        },
        {
            appfunctag: 'Auto6',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ibzpostgridview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/ibzposts/:ibzpost?/gridview/:gridview?',
            parameters: [
                { pathName: 'ibzposts', parameterName: 'ibzpost' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto7',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ibzteamgridview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/ibzteams/:ibzteam?/gridview/:gridview?',
            parameters: [
                { pathName: 'ibzteams', parameterName: 'ibzteam' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto4',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ibzdepartmenttreeexpview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/ibzdepartments/:ibzdepartment?/treeexpview/:treeexpview?',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
        },
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof OUIndexViewModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof OUIndexViewModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}