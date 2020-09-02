/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof MainModel
     */
    public items: any[] = [
        {
	id: '4e5ae0f4c2068ebb778c0a4d375b1b57',
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
	authtag:'web-Main-menuitem3',
},
        {
	id: 'ca41663c49618c9183db99a85fcc0d5a',
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
	authtag:'web-Main-menuitem6',
},
        {
	id: 'bfecb2c9bbc493c5308dac05afdd3f91',
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
	authtag:'web-Main-menuitem1',
},
        {
	id: '570ca07ed70320c1495e0649cc11523d',
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
	appfunctag: 'Auto12',
	resourcetag: '',
	authtag:'web-Main-menuitem2',
},
        {
	id: '6ef06cc33bf45a48cc0234cd7e6c2dbd',
	name: 'menuitem4',
	text: '第三方认证',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '第三方认证',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-slack',
	icon: '',
	textcls: '',
	appfunctag: 'Auto13',
	resourcetag: '',
	authtag:'web-Main-menuitem4',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof MainModel
	 */
	public funcs: any[] = [
        {
            appfunctag: 'Auto12',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sysappgridview',
            deResParameters: [],
            routepath: '/index/:index?/sysapps/:sysapp?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysapps', parameterName: 'sysapp' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto5',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sysusergridview',
            deResParameters: [],
            routepath: '/index/:index?/sysusers/:sysuser?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto6',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sysauthloggridview',
            deResParameters: [],
            routepath: '/index/:index?/sysauthlogs/:sysauthlog?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysauthlogs', parameterName: 'sysauthlog' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto10',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sysrolegridview',
            deResParameters: [],
            routepath: '/index/:index?/sysroles/:sysrole?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto13',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sysopenaccessgridview',
            deResParameters: [],
            routepath: '/index/:index?/sysopenaccesses/:sysopenaccess?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof MainModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof MainModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}