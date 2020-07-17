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
        <app-menu-item :menus="menus" :ctrlName="'taskindexview'" :isFirst="true" :counterdata="counterdata" :popperclass="popperClass"></app-menu-item>
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
import TaskIndexViewService from './task-index-view-appmenu-service';
import TaskIndexViewModel from './task-index-view-appmenu-model';
import { Environment } from '@/environments/environment';


@Component({
    components: {
      
    }
})
export default class TaskIndexViewBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof TaskIndexViewBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof TaskIndexViewBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof TaskIndexViewBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof TaskIndexViewBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof TaskIndexViewBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof TaskIndexViewBase
     */
    public getControlType(): string {
        return 'APPMENU'
    }



    /**
     * 建构部件服务对象
     *
     * @type {TaskIndexViewService}
     * @memberof TaskIndexViewBase
     */
    public service: TaskIndexViewService = new TaskIndexViewService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof TaskIndexViewBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof TaskIndexViewBase
     */
    public getData(): any {
        return null;
    }

    /**
     * 导航模式(route:面包屑模式、tab:分页导航模式)
     *
     * @type {string}
     * @memberof TaskIndexViewBase
     */
    @Prop({default:'tab'}) public navModel?:string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof TaskIndexViewBase
     */
    @Prop() public viewtag!:string;

    /**
     * 菜单模型
     *
     * @public
     * @type {TaskIndexViewModel}
     * @memberof TaskIndexViewBase
     */
    public menuMode: TaskIndexViewModel = new TaskIndexViewModel();

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof TaskIndexViewBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 菜单数据
     *
     * @public
     * @type {any[]}
     * @memberof TaskIndexViewBase
     */
    @Provide()
    public menus: any[] = [];

    /**
     * 菜单收缩改变
     *
     * @type {boolean}
     * @memberof TaskIndexViewBase
     */
    @Model() public collapsechange?: boolean;

    /**
     * 监听菜单收缩
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
     */
    @Prop() mode: any;

    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof TaskIndexViewBase
     */
    @Prop({ default: false }) isDefaultPage?: boolean;

    /**
     * 空白视图模式
     *
     * @type {boolean}
     * @memberof TaskIndexViewBase
     */
    @Prop({ default: false }) isBlankMode?:boolean;

    /**
     * 默认打开视图
     *
     * @type {*}
     * @memberof TaskIndexViewBase
     */
    @Prop() defPSAppView: any;

    /**
     * 默认激活的index
     *
     * @type {*}
     * @memberof TaskIndexViewBase
     */
    @Provide() defaultActive: any = null;

    /**
     * 当前选中主题
     *
     * @type {*}
     * @memberof TaskIndexViewBase
     */
    @Prop() selectTheme: any;

    /**
     * 默认打开的index数组
     *
     * @type {any[]}
     * @memberof TaskIndexViewBase
     */
    @Provide() public defaultOpeneds: any[] = [];

    /**
     * 是否展开
     *
     * @type {boolean}
     * @memberof TaskIndexViewBase
     */
    @Provide() public isCollapse: boolean = false;

    /**
     * 触发方式，默认click
     *
     * @type {string}
     * @memberof TaskIndexViewBase
     */
    @Provide() trigger: string = 'click';

    /**
     * 计数器数据
     *
     * @type {*}
     * @memberof TaskIndexViewBase
     */
    public counterdata: any = {};
    /**
     * vue  生命周期
     *
     * @memberof TaskIndexViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
     */
    public click(item: any) {
        if (item) {
            let navDataService = NavDataService.getInstance(this.$store);
            if(Object.is(this.navModel,"route")){
                navDataService.removeNavData(this.viewtag);
            }
            switch (item.appfunctag) {
                case 'Auto3': 
                    this.clickAuto3(item);
                    return;
                case 'Auto2': 
                    this.clickAuto2(item);
                    return;
                case 'Auto1': 
                    this.clickAuto1(item);
                    return;
                default:
                    console.warn('未指定应用功能');
            }
        }
    }

    
    /**
     * 任务
     *
     * @param {*} [item={}]
     * @memberof TaskIndexView
     */
    public clickAuto3(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
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
     * 任务调度日志
     *
     * @param {*} [item={}]
     * @memberof TaskIndexView
     */
    public clickAuto2(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'jobslogs', parameterName: 'jobslog' },
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
     * 任务注册
     *
     * @param {*} [item={}]
     * @memberof TaskIndexView
     */
    public clickAuto1(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
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
     * @memberof TaskIndexViewBase
     */
    public load(data: any) {
        this.handleMenusResource(this.menuMode.getAppMenuItems());
    }

    /**
     * 通过统一资源标识计算菜单
     *
     * @param {*} data
     * @memberof TaskIndexViewBase
     */
    public handleMenusResource(inputMenus:Array<any>){
        if(Environment.enablePermissionValid){
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
     * @memberof TaskIndexViewBase
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
     * 计算父项菜单项是否隐藏
     *
     * @param {*} inputMenus
     * @memberof TaskIndexViewBase
     */
    public computeParentMenus(inputMenus:Array<any>){
        if(inputMenus && inputMenus.length >0){
            inputMenus.forEach((item:any) =>{
                if(item.hidden && item.items && item.items.length >0){
                    item.items.map((singleItem:any) =>{
                        if(!singleItem.hidden){
                            item.hidden = false;
                        }
                        if(singleItem.items && singleItem.items.length >0){
                            this.computeParentMenus(singleItem.items);
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
     * @memberof TaskIndexViewBase
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
     * @memberof TaskIndexViewBase
     */
    get popperClass(): string {
        return 'app-popper-menu ' + this.selectTheme;
    }
    
}
</script>

<style lang='less'>
@import './task-index-view-appmenu.less';
</style>