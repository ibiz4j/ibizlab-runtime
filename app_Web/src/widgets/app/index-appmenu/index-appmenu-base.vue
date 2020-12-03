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
                            <span class='text' :title="$t('app.menus.index.' + item0.name)">{{$t('app.menus.index.' + item0.name)}}</span>
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
                                        <span class='text' :title="$t('app.menus.index.' + item1.name)">{{$t('app.menus.index.' + item1.name)}}</span>
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
                                                    <span class="text" :title="$t('app.menus.index.' + item2.name)">{{$t('app.menus.index.' + item2.name)}}</span>
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
                                            <span class="text" :title="$t('app.menus.index.' + item1.name)">{{$t('app.menus.index.' + item1.name)}} </span>
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
                                <span class="text" :title="$t('app.menus.index.' + item0.name)">{{$t('app.menus.index.' + item0.name)}}</span>
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
        <app-menu-item v-else :isCollapse="isCollapse" :menus="menus" :ctrlName="'index'" :isFirst="true" :counterdata="counterdata" :popper-class="popperClass"></app-menu-item>
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
import IndexService from './index-appmenu-service';
import IndexModel from './index-appmenu-model';
import { Environment } from '@/environments/environment';
import AuthService from '@/authservice/auth-service';


@Component({
    components: {
      
    }
})
export default class IndexBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof IndexBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof IndexBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof IndexBase
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof IndexBase
     */
    @Prop() public viewparams!: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof IndexBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof IndexBase
     */
    public getControlType(): string {
        return 'APPMENU'
    }



    /**
     * 建构部件服务对象
     *
     * @type {IndexService}
     * @memberof IndexBase
     */
    public service: IndexService = new IndexService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof IndexBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof IndexBase
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
     * @memberof IndexBase
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof IndexBase
     */
    public getData(): any {
        return null;
    }

    /**
     * 导航模式(route:面包屑模式、tab:分页导航模式)
     *
     * @type {string}
     * @memberof IndexBase
     */
    @Prop({default:'tab'}) public navModel?:string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof IndexBase
     */
    @Prop() public viewtag!:string;

    /**
     * 菜单模型
     *
     * @public
     * @type {IndexModel}
     * @memberof IndexBase
     */
    public menuMode: IndexModel = new IndexModel();

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 菜单数据
     *
     * @public
     * @type {any[]}
     * @memberof IndexBase
     */
    @Provide()
    public menus: any[] = [];

    /**
     * 菜单收缩改变
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    @Model() public collapsechange?: boolean;

    /**
     * 监听菜单收缩
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IndexBase
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
     * @memberof IndexBase
     */
    @Prop() mode: any;

    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    @Prop({ default: false }) isDefaultPage?: boolean;

    /**
     * 空白视图模式
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    @Prop({ default: false }) isBlankMode?:boolean;

    /**
     * 默认打开视图
     *
     * @type {*}
     * @memberof IndexBase
     */
    @Prop() defPSAppView: any;

    /**
     * 默认激活的index
     *
     * @type {*}
     * @memberof IndexBase
     */
    @Provide() defaultActive: any = null;

    /**
     * 当前选中主题
     *
     * @type {*}
     * @memberof IndexBase
     */
    @Prop() selectTheme: any;

    /**
     * 默认打开的index数组
     *
     * @type {any[]}
     * @memberof IndexBase
     */
    @Provide() public defaultOpeneds: any[] = [];

    /**
     * 是否展开
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    @Provide() public isCollapse: boolean = false;

    /**
     * 触发方式，默认click
     *
     * @type {string}
     * @memberof IndexBase
     */
    @Provide() trigger: string = 'click';

    /**
     * 计数器数据
     *
     * @type {*}
     * @memberof IndexBase
     */
    public counterdata: any = {};

    /**
     * 建构权限服务对象
     *
     * @type {AuthService}
     * @memberof IndexBase
     */
    public authService:AuthService = new AuthService({ $store: this.$store });

    /**
     * vue  生命周期
     *
     * @memberof IndexBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof IndexBase
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
     * @memberof IndexBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof IndexBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }


    /**
     * 获取菜单项数据
     *
     * @public
     * @param {any[]} items
     * @param {string} name
     * @returns
     * @memberof IndexBase
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
     * @memberof IndexBase
     */
    public setHideSideBar(item: any): void {
    }

    /**
     * 菜单项选中处理
     *
     * @param {*} index
     * @param {any[]} indexs
     * @returns
     * @memberof IndexBase
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
     * @memberof IndexBase
     */
    public click(item: any) {
        if (item) {
            let navDataService = NavDataService.getInstance(this.$store);
            if(Object.is(this.navModel,"route")){
                navDataService.removeNavData(this.viewtag);
            }
            switch (item.appfunctag) {
                case 'Auto9': 
                    this.clickAuto9(item);
                    return;
                case 'Auto12': 
                    this.clickAuto12(item);
                    return;
                case 'Auto3': 
                    this.clickAuto3(item);
                    return;
                case 'AppFunc2': 
                    this.clickAppFunc2(item);
                    return;
                case 'Auto5': 
                    this.clickAuto5(item);
                    return;
                case 'Auto14': 
                    this.clickAuto14(item);
                    return;
                case 'Auto16': 
                    this.clickAuto16(item);
                    return;
                case 'Auto2': 
                    this.clickAuto2(item);
                    return;
                case 'Auto10': 
                    this.clickAuto10(item);
                    return;
                case 'AppFunc': 
                    this.clickAppFunc(item);
                    return;
                case 'Auto15': 
                    this.clickAuto15(item);
                    return;
                case 'Auto6': 
                    this.clickAuto6(item);
                    return;
                case 'Auto8': 
                    this.clickAuto8(item);
                    return;
                case 'Auto11': 
                    this.clickAuto11(item);
                    return;
                case 'Auto13': 
                    this.clickAuto13(item);
                    return;
                case 'Auto7': 
                    this.clickAuto7(item);
                    return;
                case 'Auto1': 
                    this.clickAuto1(item);
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
     * 组管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto9(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'systeams', parameterName: 'systeam' },
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
     * 任务
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto12(item: any = {}) {
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
     * 单位管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto3(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
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
     * 账户绑定
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAppFunc2(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysuserauths', parameterName: 'sysuserauth' },
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
     * 用户角色
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto5(item: any = {}) {
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
     * 任务日志
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto14(item: any = {}) {
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
     * 字典项
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto16(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'dictoptions', parameterName: 'dictoption' },
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
     * 部门管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto2(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
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
     * 字典管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto10(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
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
     * @memberof Index
     */
    public clickAppFunc(item: any = {}) {
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
     * 接入应用
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto15(item: any = {}) {
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
     * 认证日志
     *
     * @param {*} [item={}]
     * @memberof Index
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
     * 流程定义
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto8(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
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
     * @memberof Index
     */
    public clickAuto11(item: any = {}) {
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
     * 岗位管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto13(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysposts', parameterName: 'syspost' },
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
     * 发布新流程
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto7(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'wfremodels', parameterName: 'wfremodel' },
            { pathName: 'editview', parameterName: 'editview' },
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
     * 流程角色
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto1(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'wfgroups', parameterName: 'wfgroup' },
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
     * 人员管理
     *
     * @param {*} [item={}]
     * @memberof Index
     */
    public clickAuto4(item: any = {}) {
        const viewparam: any = {};
        Object.assign(viewparam, {});
        const deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
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
     * @memberof IndexBase
     */
    public load(data: any) {
        this.handleMenusResource(this.menuMode.getAppMenuItems());
    }

    /**
     * 通过统一资源标识计算菜单
     *
     * @param {*} data
     * @memberof IndexBase
     */
    public handleMenusResource(inputMenus:Array<any>){
        if(this.$store.getters['authresource/getEnablePermissionValid']){
            this.computedEffectiveMenus(inputMenus);
            this.computeParentMenus(inputMenus);
        }
        this.dataProcess(inputMenus);
        this.menus = inputMenus;
    }

    /**
     * 计算有效菜单项
     *
     * @param {*} inputMenus
     * @memberof IndexBase
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
     * @memberof IndexBase
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
     * @memberof IndexBase
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
     * @memberof IndexBase
     */
    get popperClass(): string {
        return 'app-popper-menu ' + this.selectTheme;
    }
    
}
</script>

<style lang='less'>
@import './index-appmenu.less';
</style>