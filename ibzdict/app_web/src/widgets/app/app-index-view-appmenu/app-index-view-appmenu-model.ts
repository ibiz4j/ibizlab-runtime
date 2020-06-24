/**
 * AppIndexView 部件模型
 *
 * @export
 * @class AppIndexViewModel
 */
export default class AppIndexViewModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof AppIndexViewModel
     */
    public items: any[] = [
        {
	id: '3F92DBA9-3532-49CD-A482-E9048A132684',
	name: 'menuitem1',
	text: '目录',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '目录',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-folder-open-o',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
	authtag:'web-AppIndexView-menuitem1',
},
        {
	id: '73B8AFA0-9EDB-4224-93B8-F8B7C4D01AE3',
	name: 'menuitem2',
	text: '栏目',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '栏目',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-stack-exchange',
	icon: '',
	textcls: '',
	appfunctag: 'Auto2',
	resourcetag: '',
	authtag:'web-AppIndexView-menuitem2',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof AppIndexViewModel
	 */
	public funcs: any[] = [
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof AppIndexViewModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof AppIndexViewModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}