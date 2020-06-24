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
	id: 'A47FFDFF-3B2F-429E-9D21-02E0630F6164',
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