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
	authtag:'web-Main-menuitem3',
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
	authtag:'web-Main-menuitem6',
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
	authtag:'web-Main-menuitem1',
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
	appfunctag: 'Auto12',
	resourcetag: '',
	authtag:'web-Main-menuitem2',
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
            appfunctag: 'Auto10',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sys_rolegridview',
            deResParameters: [],
            routepath: '/index/:index?/sysroles/:sysrole?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto5',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'sys_usergridview',
            deResParameters: [],
            routepath: '/index/:index?/sysusers/:sysuser?/gridview/:gridview?',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
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