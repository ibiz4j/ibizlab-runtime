/**
 * NotifyIndexView 部件模型
 *
 * @export
 * @class NotifyIndexViewModel
 */
export default class NotifyIndexViewModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof NotifyIndexViewModel
     */
    public items: any[] = [
        {
	id: '46e30d9996c90c9d617fdc7d75936058',
	name: 'menuitem1',
	text: '接入第三方平台',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '接入第三方平台',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-ioxhost',
	icon: '',
	textcls: '',
	appfunctag: 'Auto2',
	resourcetag: '',
	authtag:'web-NotifyIndexView-menuitem1',
},
        {
	id: 'bb418fcd75aff6e293b7b8b416bb01ce',
	name: 'menuitem2',
	text: '消息模板',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '消息模板',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-list-alt',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
	authtag:'web-NotifyIndexView-menuitem2',
},
        {
	id: '6199646ee62aeb492996a780d1c3365f',
	name: 'menuitem3',
	text: '消息账户',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '消息账户',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-user',
	icon: '',
	textcls: '',
	appfunctag: 'Auto3',
	resourcetag: '',
	authtag:'web-NotifyIndexView-menuitem3',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof NotifyIndexViewModel
	 */
	public funcs: any[] = [
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof NotifyIndexViewModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof NotifyIndexViewModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}