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
            codename: 'sysorganizationgridview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/sysorganizations/:sysorganization?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto5',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sysorganizationtreeexpview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/sysorganizations/:sysorganization?/treeexpview/:treeexpview?',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
        },
        {
            appfunctag: 'Auto6',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'syspostgridview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/sysposts/:syspost?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysposts', parameterName: 'syspost' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto7',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'systeamgridview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/systeams/:systeam?/gridview/:gridview?',
            parameters: [
                { pathName: 'systeams', parameterName: 'systeam' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto4',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sysdepartmenttreeexpview',
            deResParameters: [],
            routepath: '/ouindexview/:ouindexview?/sysdepartments/:sysdepartment?/treeexpview/:treeexpview?',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
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