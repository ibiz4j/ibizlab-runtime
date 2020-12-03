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
        <template v-if="Object.is(mode,'horizontal')">
            <template v-for="item0 in menus">
                <template v-if="item0.items && Array.isArray(item0.items) && item0.items.length > 0">
                    <el-submenu v-show="!item0.hidden" :index="item0.name" :popper-class="popperClass" :key="item0.id" :class="item0.textcls">
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
                            <span class='text' :title="$t('app.menus.main.' + item0.name)">{{$t('app.menus.main.' + item0.name)}}</span>
                        </template>
                        <template v-for="item1 in item0.items">
                            <template v-if="item1.items && Array.isArray(item1.items) && item1.items.length > 0">
                                <el-submenu v-show="!item1.hidden" :index="item1.name" :popper-class="popperClass" :key="item1.id" :class="item1.textcls">
                                    <template slot='title'>
                                        <template v-if="item1.icon && item1.icon != ''">
                                            <img :src="item1.icon" class='app-menu-icon' />
                                        </template>
                                        <template v-else-if="item1.iconcls && item1.iconcls != ''">
                                            <i :class="[item1.iconcls, 'app-menu-icon']"></i>
                                        </template>
                                        <span class='text' :title="$t('app.menus.main.' + item1.name)">{{$t('app.menus.main.' + item1.name)}}</span>
                                    </template>
                                    <template v-for="item2 in item1.items">
                                        <template v-if="item2.type =='MENUITEM'">
                                            <el-menu-item v-show="!item2.hidden" :index="item2.name" :key="item2.id" :class="item2.textcls">
                                                <template v-if="item2.icon && item2.icon != ''">
                                                    <img :src="item2.icon" class='app-menu-icon' />
                                                </template>
                                                <template v-else-if="item2.iconcls && item2.iconcls != ''">
                                                    <i :class="[item2.iconcls, 'app-menu-icon']"></i>
                                                </template>
                                                <template slot="title">
                                                    <span class="text" :title="$t('app.menus.main.' + item2.name)">{{$t('app.menus.main.' + item2.name)}}</span>
                                                    <template v-if="counterdata && counterdata[item2.counterid] && counterdata[item2.counterid] > 0">
                                                        <span class="pull-right">
                                                            <badge :count="counterdata[item2.counterid]" :overflow-count="9999"></badge>
                                                        </span>
                                                    </template>
                                                </template>
                                            </el-menu-item>
                                        </template>
                                    </template>
                                </el-submenu>
                            </template>
                            <template v-else>
                                <template v-if="item1.type =='MENUITEM'">
                                    <el-menu-item v-show="!item1.hidden" :index="item1.name" :key="item1.id" :class="item1.textcls">
                                        <template v-if="item1.icon && item1.icon != ''">
                                            <img :src="item1.icon" class='app-menu-icon' />
                                        </template>
                                        <template v-else-if="item1.iconcls && item1.iconcls != ''">
                                            <i :class="[item1.iconcls, 'app-menu-icon']"></i>
                                        </template>
                                        <template slot="title">
                                            <span class="text" :title="$t('app.menus.main.' + item1.name)">{{$t('app.menus.main.' + item1.name)}} </span>
                                            <template v-if="counterdata && counterdata[item1.counterid] && counterdata[item1.counterid] > 0">
                                                <span class="pull-right">
                                                    <badge :count="counterdata[item1.counterid]" :overflow-count="9999"></badge>
                                                </span>
                                            </template>
                                        </template>
                                    </el-menu-item>
                                </template>
                            </template>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <template v-if="item0.type =='MENUITEM'">
                        <el-menu-item v-show="!item0.hidden" :index="item0.name" :key="item0.id" :class="item0.textcls">
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
                                <span class="text" :title="$t('app.menus.main.' + item0.name)">{{$t('app.menus.main.' + item0.name)}}</span>
                                <template v-if="counterdata && counterdata[item0.counterid] && counterdata[item0.counterid] > 0">
                                    <span class="pull-right">
                                        <badge :count="counterdata[item0.counterid]" :overflow-count="9999"></badge>
                                    </span>
                                </template>
                            </template>
                        </el-menu-item>
                    </template>
                </template>
            </template>   
        </template> 
        <app-menu-item v-else :isCollapse="isCollapse" :menus="menus" :ctrlName="'main'" :isFirst="true" :counterdata="counterdata" :popper-class="popperClass"></app-menu-item>
    </el-menu>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util,ViewTool } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import AppCenterService from "@service/app/app-center-service";
import MainService from './main-appmenu-service';
import MainModel from './main-appmenu-model';
import { Environment } from '@/environments/environment';
import AuthService from '@/authservice/auth-service';


@Component({
    components: {
      
    }
})
export default class MainBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof MainBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public viewparams!: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof MainBase
     */
    public getControlType(): string {
        return 'APPMENU'
    }



    /**
     * 建构部件服务对象
     *
     * @type {MainService}
     * @memberof MainBase
     */
    public service: MainService = new MainService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof MainBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof MainBase
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
     * @memberof MainBase
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof MainBase
     */
    public getData(): any {
        return null;
    }

    /**
     * 导航模式(route:面包屑模式、tab:分页导航模式)
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop({default:'tab'}) public navModel?:string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public viewtag!:string;

    /**
     * 菜单模型
     *
     * @public
     * @type {MainModel}
     * @memberof MainBase
     */
    public menuMode: MainModel = new MainModel();

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 菜单数据
     *
     * @public
     * @type {any[]}
     * @memberof MainBase
     */
    @Provide()
    public menus: any[] = [];

    /**
     * 菜单收缩改变
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Model() public collapsechange?: boolean;

    /**
     * 监听菜单收缩
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
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
     * @memberof MainBase
     */
    @Prop() mode: any;

    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: false }) isDefaultPage?: boolean;

    /**
     * 空白视图模式
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: false }) isBlankMode?:boolean;

    /**
     * 默认打开视图
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() defPSAppView: any;

    /**
     * 默认激活的index
     *
     * @type {*}
     * @memberof MainBase
     */
    @Provide() defaultActive: any = null;

    /**
     * 当前选中主题
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() selectTheme: any;

    /**
     * 默认打开的index数组
     *
     * @type {any[]}
     * @memberof MainBase
     */
    @Provide() public defaultOpeneds: any[] = [];

    /**
     * 是否展开
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Provide() public isCollapse: boolean = false;

    /**
     * 触发方式，默认click
     *
     * @type {string}
     * @memberof MainBase
     */
    @Provide() trigger: string = 'click';

    /**
     * 计数器数据
     *
     * @type {*}
     * @memberof MainBase
     */
    public counterdata: any = {};

    /**
     * 建构权限服务对象
     *
     * @type {AuthService}
     * @memberof MainBase
     */
    public authService:AuthService = new AuthService({ $store: this.$store });

    /**
     * vue  生命周期
     *
     * @memberof MainBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof MainBase
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
     * @memberof MainBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof MainBase
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
     * @memberof MainBase
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
     * @memberof MainBase
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
     * @memberof MainBase
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
     * @memberof MainBase
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
     * @memberof MainBase
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
     * @memberof MainBase
     */
    public click(item: any) {
        if (item) {
            let navDataService = NavDataService.getInstance(this.$store);
            if(Object.is(this.navModel,"route")){
                navDataService.removeNavData(this.viewtag);
            }
            switch (item.appfunctag) {
                case 'Auto12': 
                    this.clickAuto12(item);
                    return;
                case 'Auto5': 
                    this.clickAuto5(item);
                    return;
                case 'Auto6': 
                    this.clickAuto6(item);
                    return;
                case 'Auto10': 
                    this.clickAuto10(item);
                    return;
                case 'Auto13': 
                    this.clickAuto13(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }

    
    /**
     * 接入应用
     *
     * @param {*} [item={}]
     * @memberof Main
     */
    public clickAuto12(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysapps', parameterName: 'sysapp' },
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
     * 用户
     *
     * @param {*} [item={}]
     * @memberof Main
     */
    public clickAuto5(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysusers', parameterName: 'sysuser' },
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
     * 认证日志
     *
     * @param {*} [item={}]
     * @memberof Main
     */
    public clickAuto6(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysauthlogs', parameterName: 'sysauthlog' },
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
     * 角色
     *
     * @param {*} [item={}]
     * @memberof Main
     */
    public clickAuto10(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysroles', parameterName: 'sysrole' },
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
     * 第三方认证平台
     *
     * @param {*} [item={}]
     * @memberof Main
     */
    public clickAuto13(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
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
     * 数据加载
     *
     * @param {*} data
     * @memberof MainBase
     */
    public load(data: any) {
        this.handleMenusResource(this.menuMode.getAppMenuItems());
    }

    /**
     * 通过统一资源标识计算菜单
     *
     * @param {*} data
     * @memberof MainBase
     */
    public handleMenusResource(inputMenus:Array<any>){
        if(this.$store.getters['authresource/getEnablePermissionValid']){
            this.computedEffectiveMenus(inputMenus);
            this.computeParentMenus(inputMenus);
        }
        this.dataProcess(inputMenus);
        this.menus = inputMenus;
        this.doMenuSelect();
    }

    /**
     * 计算有效菜单项
     *
     * @param {*} inputMenus
     * @memberof MainBase
     */
    public computedEffectiveMenus(inputMenus:Array<any>){
        inputMenus.forEach((_item:any) =>{
            if(!this.authService.getMenusPermission(_item)){
                _item.hidden = true;
                if (_item.items && _item.items.length > 0) {
                    this.computedEffectiveMenus(_item.items);
                }
            }
        })
    }

    /**
     * 计算父项菜单项是否隐藏
     *
     * @param {*} inputMenus
     * @memberof MainBase
     */
    public computeParentMenus(inputMenus:Array<any>){
        if(inputMenus && inputMenus.length >0){
            inputMenus.forEach((item:any) =>{
                if(item.hidden && item.items && item.items.length >0){
                    item.items.map((singleItem:any) =>{
                        if(!singleItem.hidden){
                            item.hidden = false;
                        }else{
                            if(singleItem.items && singleItem.items.length >0){
                                singleItem.items.map((grandsonItem:any) =>{
                                    if(!grandsonItem.hidden){
                                        item.hidden = false;
                                    }
                                })
                            }
                        }
                        if(item.items && item.items.length >0){
                            this.computeParentMenus(item.items);
                        }
                    })
                }
            })
        }
    }

    /**
     * 数据处理
     *
     * @public
     * @param {any[]} items
     * @memberof MainBase
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
     * @memberof MainBase
     */
    get popperClass(): string {
        return 'app-popper-menu ' + this.selectTheme;
    }
    
}
</script>

<style lang='less'>
@import './main-appmenu.less';
</style>