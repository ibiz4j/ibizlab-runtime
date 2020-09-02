/**
 * PayIndexView 部件模型
 *
 * @export
 * @class PayIndexViewModel
 */
export default class PayIndexViewModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof PayIndexViewModel
     */
    public items: any[] = [
        {
	id: '62d37d214c3103bf6ed1e946106ec677',
	name: 'menuitem1',
	text: '支付平台',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '支付平台',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-ioxhost',
	icon: '',
	textcls: '',
	appfunctag: 'Auto1',
	resourcetag: '',
	authtag:'web-PayIndexView-menuitem1',
},
        {
	id: '1e7394867e71eec256933bda6257bcc2',
	name: 'menuitem2',
	text: '交易记录',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '交易记录',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: 'fa fa-list-alt',
	icon: '',
	textcls: '',
	appfunctag: 'Auto2',
	resourcetag: '',
	authtag:'web-PayIndexView-menuitem2',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof PayIndexViewModel
	 */
	public funcs: any[] = [
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof PayIndexViewModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof PayIndexViewModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}