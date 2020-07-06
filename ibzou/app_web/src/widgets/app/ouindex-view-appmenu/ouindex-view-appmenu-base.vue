<template>
<div class="app-app-menu">
    <el-menu
      class="app-menu"
      :default-openeds="defaultOpeneds"
      :mode="mode"
      :menu-trigger="trigger"
      :collapse="isCollapse"
      @select="select"
      :default-active="defaultActive">
        <template v-for="item0 in menus">
            <template v-if="item0.items && Array.isArray(item0.items) && item0.items.length > 0">
                <el-submenu v-show="!item0.hidden" :index="item0.name" :popper-class="popperClass" :key="item0.id">
                    <template slot='title'>
                        <template v-if="item0.icon && item0.icon != ''">
                            <img :src="item0.icon" class='app-menu-icon' />
                        </template>
                        <template v-else-if="item0.iconcls && item0.iconcls != ''">
                            <i :class="[item0.iconcls, 'app-menu-icon']"></i>
                        </template>
                        <template v-else>
                            <i class='fa fa-cogs app-menu-icon'></i>
                        </template>
                        <span class='text' :title="$t('app.menus.ouindexview.' + item0.name)">{{$t('app.menus.ouindexview.' + item0.name)}}</span>
                    </template>
                    <template v-for="item1 in item0.items">
                        <template v-if="item1.items && Array.isArray(item1.items) && item1.items.length > 0">
                            <el-submenu v-show="!item1.hidden" :index="item1.name" :popper-class="popperClass" :key="item1.id">
                                <template slot='title'>
                                    <template v-if="item1.icon && item1.icon != ''">
                                        <img :src="item1.icon" class='app-menu-icon' />
                                    </template>
                                    <template v-else-if="item1.iconcls && item1.iconcls != ''">
                                        <i :class="[item1.iconcls, 'app-menu-icon']"></i>
                                    </template>
                                    <span class='text' :title="$t('app.menus.ouindexview.' + item1.name)">{{$t('app.menus.ouindexview.' + item1.name)}}</span>
                                </template>
                                <template v-for="item2 in item1.items">
                                    <template v-if="item2.type =='MENUITEM'">
                                        <el-menu-item v-show="!item2.hidden" :index="item2.name" :key="item2.id">
                                            <template v-if="item2.icon && item2.icon != ''">
                                                <img :src="item2.icon" class='app-menu-icon' />
                                            </template>
                                            <template v-else-if="item2.iconcls && item2.iconcls != ''">
                                                <i :class="[item2.iconcls, 'app-menu-icon']"></i>
                                            </template>
                                            <template slot="title">
                                                <span class="text" :title="$t('app.menus.ouindexview.' + item2.name)">{{$t('app.menus.ouindexview.' + item2.name)}}</span>
                                                <template v-if="counterdata && counterdata[item2.counterid] && counterdata[item2.counterid] > 0">
                                                    <span class="pull-right">
                                                        <badge :count="counterdata[item2.counterid]" :overflow-count="9999"></badge>
                                                    </span>
                                                </template>
                                            </template>
                                        </el-menu-item>
                                    </template>
                                    <template v-if="item2.type =='SEPERATOR'">
                                            <divider :key="item2.id" />
                                    </template>
                                </template>
                            </el-submenu>
                        </template>
                        <template v-else>
                            <template v-if="item1.type =='MENUITEM'">
                                <el-menu-item v-show="!item1.hidden" :index="item1.name" :key="item1.id">
                                    <template v-if="item1.icon && item1.icon != ''">
                                        <img :src="item1.icon" class='app-menu-icon' />
                                    </template>
                                    <template v-else-if="item1.iconcls && item1.iconcls != ''">
                                        <i :class="[item1.iconcls, 'app-menu-icon']"></i>
                                    </template>
                                    <template slot="title">
                                        <span class="text" :title="$t('app.menus.ouindexview.' + item1.name)">{{$t('app.menus.ouindexview.' + item1.name)}} </span>
                                        <template v-if="counterdata && counterdata[item1.counterid] && counterdata[item1.counterid] > 0">
                                            <span class="pull-right">
                                                <badge :count="counterdata[item1.counterid]" :overflow-count="9999"></badge>
                                            </span>
                                        </template>
                                    </template>
                                </el-menu-item>
                            </template>
                            <template v-if="item1.type =='SEPERATOR'">
                                    <divider :key="item1.id" />
                            </template>
                        </template>
                    </template>
                </el-submenu>
            </template>
            <template v-else>
                <template v-if="item0.type =='MENUITEM'">
                    <el-menu-item v-show="!item0.hidden" :index="item0.name" :key="item0.id">
                        <template v-if="item0.icon && item0.icon != ''">
                            <img :src="item0.icon" class='app-menu-icon' />
                        </template>
                        <template v-else-if="item0.iconcls && item0.iconcls != ''">
                            <i :class="[item0.iconcls, 'app-menu-icon']"></i>
                        </template>
                        <template v-else>
                            <i class='fa fa-cogs app-menu-icon'></i>
                        </template>
                        <template slot="title">
                            <span class="text" :title="$t('app.menus.ouindexview.' + item0.name)">{{$t('app.menus.ouindexview.' + item0.name)}}</span>
                            <template v-if="counterdata && counterdata[item0.counterid] && counterdata[item0.counterid] > 0">
                                <span class="pull-right">
                                    <badge :count="counterdata[item0.counterid]" :overflow-count="9999"></badge>
                                </span>
                            </template>
                        </template>
                    </el-menu-item>
                </template>
                <template v-if="item0.type =='SEPERATOR'">
                        <divider :key="item0.id" />
                </template>
            </template>
        </template>
    </el-menu>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import AppCenterService from "@service/app/app-center-service";
import OUIndexViewService from './ouindex-view-appmenu-service';

import OUIndexViewModel from './ouindex-view-appmenu-model';
import { Environment } from '@/environments/environment';


@Component({
    components: {
      
    }
})
export default class OUIndexViewBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof OUIndexViewBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof OUIndexViewBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof OUIndexViewBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof OUIndexViewBase
     */
    public getControlType(): string {
        return 'APPMENU'
    }



    /**
     * 建构部件服务对象
     *
     * @type {OUIndexViewService}
     * @memberof OUIndexViewBase
     */
    public service: OUIndexViewService = new OUIndexViewService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof OUIndexViewBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof OUIndexViewBase
     */
    public counterRefresh(){
        const _this:any =this;
        if(_this.counterServiceArray && _this.counterServiceArray.length >0){
            _this.counterServiceArray.forEach((item:any) =>{
                if(item.refreshData && item.refreshData instanceof Function){
                    item.refreshData();
                }
            })
        }
    }


    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof OUIndexViewBase
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof OUIndexViewBase
     */
    public getData(): any {
        return null;
    }

    /**
     * 导航模式(route:面包屑模式、tab:分页导航模式)
     *
     * @type {string}
     * @memberof OUIndexViewBase
     */
    @Prop({default:'tab'}) public navModel?:string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof OUIndexViewBase
     */
    @Prop() public viewtag!:string;

    /**
     * 菜单模型
     *
     * @public
     * @type {OUIndexViewModel}
     * @memberof OUIndexViewBase
     */
    public menuMode: OUIndexViewModel = new OUIndexViewModel();

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 菜单数据
     *
     * @public
     * @type {any[]}
     * @memberof OUIndexViewBase
     */
    @Provide()
    public menus: any[] = [];

    /**
     * 菜单收缩改变
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    @Model() public collapsechange?: boolean;

    /**
     * 监听菜单收缩
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof OUIndexViewBase
     */
    @Watch('collapsechange')
    onCollapsechangeChange(newVal: any, oldVal: any) {
        if (newVal !== this.isCollapse) {
            this.isCollapse = !this.isCollapse;
        }
    }

    /**
     * 当前模式，菜单在顶部还是在底部
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    @Prop() mode: any;

    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    @Prop({ default: false }) isDefaultPage?: boolean;

    /**
     * 空白视图模式
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    @Prop({ default: false }) isBlankMode?:boolean;

    /**
     * 默认打开视图
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    @Prop() defPSAppView: any;

    /**
     * 默认激活的index
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    @Provide() defaultActive: any = null;

    /**
     * 当前选中主题
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    @Prop() selectTheme: any;

    /**
     * 默认打开的index数组
     *
     * @type {any[]}
     * @memberof OUIndexViewBase
     */
    @Provide() public defaultOpeneds: any[] = [];

    /**
     * 是否展开
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    @Provide() public isCollapse: boolean = false;

    /**
     * 触发方式，默认click
     *
     * @type {string}
     * @memberof OUIndexViewBase
     */
    @Provide() trigger: string = 'click';

    /**
     * 计数器数据
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    public counterdata: any = {};
    /**
     * vue  生命周期
     *
     * @memberof OUIndexViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof OUIndexViewBase
     */    
    public afterCreated(){
        if (Object.is(this.mode, 'horizontal')) {
            this.trigger = 'hover';
        }
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                this.load(data);
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof OUIndexViewBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof OUIndexViewBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }


    /**
     * 处理菜单默认选中项
     *
     * @public
     * @memberof OUIndexViewBase
     */
    public doMenuSelect(): void {
        if (!this.isDefaultPage || this.isBlankMode) {
            return;
        }
        const appFuncs: any[] = this.menuMode.getAppFuncs();
        if (this.$route && this.$route.matched && this.$route.matched.length == 2) { // 存在二级路由
            const [{ }, matched] = this.$route.matched;
            const appfunc: any = appFuncs.find((_appfunc: any) => Object.is(_appfunc.routepath, matched.path) && Object.is(_appfunc.appfuncyype, 'APPVIEW'));
            if (appfunc) {
                this.computeMenuSelect(this.menus, appfunc.appfunctag);
            }
            return;
        } else if (this.defPSAppView && Object.keys(this.defPSAppView).length > 0) { // 存在默认视图
            const appfunc: any = appFuncs.find((_appfunc: any) => Object.is(_appfunc.routepath, this.defPSAppView.routepath) && Object.is(_appfunc.appfuncyype, 'APPVIEW'));
            if (appfunc) {
                this.computeMenuSelect(this.menus, appfunc.appfunctag);
            }
            const viewparam: any = {};
            const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, this.defPSAppView.deResParameters, this.defPSAppView.parameters, [], viewparam);
            this.$router.push(path);
            return;
        }

        this.computeMenuSelect(this.menus, '');
        let item = this.compute(this.menus, this.defaultActive);
        if (Object.keys(item).length === 0) {
            return;
        }
        if(!item.hidden){
            this.click(item);
        }
    }

    /**
     * 计算菜单选中项
     *
     * @public
     * @param {any[]} items
     * @param {string} appfunctag
     * @returns {boolean}
     * @memberof OUIndexViewBase
     */
    public computeMenuSelect(items: any[], appfunctag: string): boolean {
        const appFuncs: any[] = this.menuMode.getAppFuncs();
        return items.some((item: any) => {
            if (Object.is(appfunctag, '') && !Object.is(item.appfunctag, '') && item.opendefault) {
                const appfunc = appFuncs.find((_appfunc: any) => Object.is(_appfunc.appfunctag, item.appfunctag));
                if (appfunc.routepath) {
                    this.defaultActive = item.name;
                    this.setHideSideBar(item);
                    return true;
                }
            }
            if (Object.is(item.appfunctag, appfunctag) && item.opendefault) {
                this.setHideSideBar(item);
                this.defaultActive = item.name;
                return true;
            }
            if (item.items && item.items.length > 0) {
                const state = this.computeMenuSelect(item.items, appfunctag);
                if (state) {
                    this.defaultOpeneds.push(item.name);
                    return true;
                }
            }
            return false;
        });
    }

    /**
     * 获取菜单项数据
     *
     * @public
     * @param {any[]} items
     * @param {string} name
     * @returns
     * @memberof OUIndexViewBase
     */
    public compute(items: any[], name: string) {
        const item: any = {};
        items.some((_item: any) => {
            if (name && Object.is(_item.name, name)) {
                Object.assign(item, _item);
                this.setHideSideBar(_item);
                return true;
            }
            if (_item.items && Array.isArray(_item.items)) {
                const subItem = this.compute(_item.items, name);
                if (Object.keys(subItem).length > 0) {
                    Object.assign(item, subItem);
                    return true;
                }
            }
            return false;
        });
        return item;
    }

    /**
     * 设置是否隐藏菜单栏
     *
     * @public
     * @param {*} item
     * @memberof OUIndexViewBase
     */
    public setHideSideBar(item: any): void {
        if (item.hidesidebar) {
            this.$emit('collapsechange', true);
        }
    }

    /**
     * 菜单项选中处理
     *
     * @param {*} index
     * @param {any[]} indexs
     * @returns
     * @memberof OUIndexViewBase
     */
    public select(index: any, indexs: any[]) {
        let item = this.compute(this.menus, index);
        if (Object.keys(item).length === 0) {
            return;
        }
        this.click(item);
    }

    /**
     * 菜单点击
     *
     * @public
     * @param {*} item 菜单数据
     * @memberof OUIndexViewBase
     */
    public click(item: any) {
        if (item) {
            let navDataService = NavDataService.getInstance(this.$store);
            if(Object.is(this.navModel,"route")){
                navDataService.removeNavData(this.viewtag);
            }
            switch (item.appfunctag) {
                case 'Auto6': 
                    this.clickAuto6(item);
                    return;
                case 'Auto5': 
                    this.clickAuto5(item);
                    return;
                case 'Auto3': 
                    this.clickAuto3(item);
                    return;
                case 'Auto7': 
                    this.clickAuto7(item);
                    return;
                case 'Auto4': 
                    this.clickAuto4(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }

    
    /**
     * 岗位管理
     *
     * @param {*} [item={}]
     * @memberof OUIndexView
     */
    public clickAuto6(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ibzposts', parameterName: 'ibzpost' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 组织树
     *
     * @param {*} [item={}]
     * @memberof OUIndexView
     */
    public clickAuto5(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
            { pathName: 'treeexpview', parameterName: 'treeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 单位管理
     *
     * @param {*} [item={}]
     * @memberof OUIndexView
     */
    public clickAuto3(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 组管理
     *
     * @param {*} [item={}]
     * @memberof OUIndexView
     */
    public clickAuto7(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ibzteams', parameterName: 'ibzteam' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }
    
    /**
     * 部门树
     *
     * @param {*} [item={}]
     * @memberof OUIndexView
     */
    public clickAuto4(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
            { pathName: 'treeexpview', parameterName: 'treeexpview' },
        ];
        const path: string = this.$viewTool.buildUpRoutePath(this.$route, {}, deResParameters, parameters, [], viewparam);
        if(Object.is(this.$route.fullPath,path)){
            return;
        }
        this.$nextTick(function(){
            this.$router.push(path);
        })
    }

    /**
     * 数据加载
     *
     * @param {*} data
     * @memberof OUIndexViewBase
     */
    public load(data: any) {
        this.handleMenusResource(this.menuMode.getAppMenuItems());
    }

    /**
     * 通过统一资源标识计算菜单
     *
     * @param {*} data
     * @memberof OUIndexViewBase
     */
    public handleMenusResource(inputMenus:Array<any>){
        if(Environment.enablePermissionValid){
            this.computedEffectiveMenus(inputMenus);
        }
        this.dataProcess(inputMenus);
        this.menus = inputMenus;
        this.doMenuSelect();
    }

    /**
     * 计算有效菜单项
     *
     * @param {*} data
     * @memberof OUIndexViewBase
     */
    public computedEffectiveMenus(inputMenus:Array<any>){
        inputMenus.forEach((_item:any) =>{
            if(!this.$store.getters['authresource/getAuthMenu'](_item)){
                _item.hidden = true;
                if (_item.items && _item.items.length > 0) {
                    this.computedEffectiveMenus(_item.items);
                }
            }
        })
    }

    /**
     * 数据处理
     *
     * @public
     * @param {any[]} items
     * @memberof OUIndexViewBase
     */
    public dataProcess(items: any[]): void {
        items.forEach((_item: any) => {
            if (_item.expanded) {
                this.defaultOpeneds.push(_item.name);
            }
            if (_item.items && _item.items.length > 0) {
                this.dataProcess(_item.items)
            }
        });
    }

    /**
     * 提示框主题样式
     *
     * @readonly
     * @type {string}
     * @memberof OUIndexViewBase
     */
    get popperClass(): string {
        return 'app-popper-menu ' + this.selectTheme;
    }
    
}
</script>

<style lang='less'>
@import './ouindex-view-appmenu.less';
</style>