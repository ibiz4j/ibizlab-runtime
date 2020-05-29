/**
 * Index 部件模型
 *
 * @export
 * @class IndexModel
 */
export default class IndexModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof IndexModel
     */
    public items: any[] = [
        {
	id: 'DCCA086F-7A59-4199-9C11-FEC68DDF7E0B',
	name: 'menuitem7',
	text: '单位人事',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '单位人事',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-th-large',
	icon: '',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '4ea6829eb5066555b9f0a91145dc7502',
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
},
		{
	id: 'f73183a5dfe125c3461116b4d82c2468',
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
	appfunctag: 'Auto2',
	resourcetag: '',
},
		{
	id: '341bd3aa939665d5c039462456dfce93',
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
},
	],
},
        {
	id: 'F4C605A6-B7AE-4388-8525-3680E19053E9',
	name: 'menuitem8',
	text: '系统权限',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '系统权限',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-cubes',
	icon: '',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '1e02015a09f1d812fe4640fac320158e',
	name: 'menuitem4',
	text: '用户角色',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '用户角色',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-unlock-alt',
	icon: '',
	textcls: '',
	appfunctag: 'Auto5',
	resourcetag: '',
},
		{
	id: '4999F409-9C7B-4C41-BD3A-B29611EA7E6E',
	name: 'menuitem9',
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
},
	],
},
        {
	id: 'B3429E51-565E-49F8-BCDB-CE313AFB338E',
	name: 'menuitem10',
	text: '流程管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '流程管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-empire',
	icon: '',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '6DFB635D-1B8E-47E7-9869-1B7BC2B844C0',
	name: 'menuitem6',
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
	appfunctag: 'Auto8',
	resourcetag: '',
},
		{
	id: '69b794a51f56bc20947749c2d7629117',
	name: 'menuitem5',
	text: '流程角色',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '流程角色',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-users',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
},
		{
	id: '8E6D5AC1-9AA9-4F29-83A2-0A9E7EFACE09',
	name: 'menuitem11',
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
	appfunctag: 'Auto7',
	resourcetag: '',
},
	],
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof IndexModel
	 */
	public funcs: any[] = [
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof IndexModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof IndexModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}