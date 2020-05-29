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
	id: 'CC24ABE9-84D6-4F04-8770-E9739A62AC34',
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
	id: '26353959-9246-4DDF-8ADA-E8A229572BC7',
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
},
        {
	id: '18F0AA9B-5281-46B7-AC6E-1A40E088AEE8',
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