<template>
<div class="index_view ouindex-view">
    <app-studioaction :viewTitle="$t(model.srfCaption)" viewName="ouindexview"></app-studioaction>
    <layout :class="themeClasses" :style="themeStyle">
        <layout>
            <sider :width="collapseChange ? 64 : 200" hide-trigger v-model="collapseChange">
                <div class="sider-top">
                    <div class="page-logo">
                        <span class="menuicon" v-if="isEnableAppSwitch" @click="contextMenuDragVisiable=!contextMenuDragVisiable"><Icon type="md-menu" /></span>
                        <span v-show="!collapseChange" style="overflow-x: hidden;text-overflow: ellipsis;white-space: nowrap;display: block;text-align: center;font-weight: 300;font-size: 20px;">{{$t(model.srfCaption)}}</span>
                    </div>
                </div>
                <view_appmenu 
    :viewState="viewState"  
    :viewparams="viewparams" 
    :context="context" 
    :showBusyIndicator="true"  
    v-model="collapseChange"  
    :mode="mode"
    :navModel="navModel"
    viewtag="ouindex-view"
    :selectTheme="selectTheme"  
    :isDefaultPage="isDefaultPage"  
    :isBlankMode="isBlankMode"
    :defPSAppView="defPSAppView" 
    name="appmenu"  
    ref='appmenu' 
    @closeview="closeView($event)">
</view_appmenu>
                <context-menu-drag v-if="isEnableAppSwitch" :contextMenuDragVisiable="contextMenuDragVisiable"></context-menu-drag>
            </sider>
            <layout>
                <header class="index_header">
                    <div class="header-left" >
                        <div class="page-logo">
                            <i v-show="!collapseChange" class="ivu-icon el-icon-s-fold" @click="handleClick"></i>
                            <i v-show="collapseChange" class="ivu-icon el-icon-s-unfold" @click="handleClick"></i>
                            <app-breadcrumb  :navModel="navModel" indexViewTag="ouindex-view"></app-breadcrumb>
                        </div>
                    </div>
                    <div class="header-right" style="display: flex;align-items: center;justify-content: space-between;">
                        <app-header-menus />
                        <app-lang style='font-size: 15px;padding: 0 10px;'></app-lang>
                        <app-orgsector></app-orgsector>
                        <app-user></app-user>
                        <app-theme style="width:45px;display: flex;justify-content: center;"></app-theme>
                    </div>
                </header>
                <content :class="{'index_content':true,'index_tab_content':Object.is(navModel,'tab')?true:false,'index_route_content':Object.is(navModel,'route')?true:false}" :style="{'width':this.collapseChange ? 'calc(100vw - 64px)' : 'calc(100vw - 200px)' }"  @click="contextMenuDragVisiable=false">
                    <tab-page-exp v-if="Object.is(navModel,'tab')"></tab-page-exp>
                    <app-keep-alive :routerList="getRouterList">
                        <router-view :key="getRouterViewKey"></router-view>
                    </app-keep-alive>
                </content>
            </layout>
        </layout>
    </layout>
</div>

</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch,Inject } from 'vue-property-decorator';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import { Subject,Subscription } from 'rxjs';




@Component({
    components: {
    },
})
export default class OUIndexViewBase extends Vue {


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof OUIndexViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof OUIndexViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof OUIndexViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof OUIndexViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;


	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof OUIndexViewBase
	 */
	public viewtag: string = 'B0D69856-0C83-421E-B5A9-5021F0BB057C';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof OUIndexViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof OUIndexViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    public model: any = {
        srfCaption: 'app.views.ouindexview.caption',
        srfTitle: 'app.views.ouindexview.title',
        srfSubTitle: 'app.views.ouindexview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof OUIndexViewBase
     */
    @Watch('viewparam',{immediate: true, deep: true})
    onParamData(newVal: any, oldVal: any) {
        if(newVal){
            for(let key in this.viewparams){
                delete this.viewparams[key];
            }
            Object.assign(this.viewparams, JSON.parse(this.viewparam));
            
        } 
    }

    /**
     * 处理应用上下文变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof OUIndexViewBase
     */
    @Watch('viewdata')
    onViewData(newVal: any, oldVal: any) {
        const _this: any = this;
        if (!Object.is(newVal, oldVal) && _this.engine) {
            this.$nextTick(()=>{
              _this.parseViewParam();
              _this.engine.load();
              
            });
        }
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    public containerModel: any = {
        view_appmenu: { name: 'appmenu', type: 'APPMENU' },
    };

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
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof OUIndexViewBase
     */
    public viewState: Subject<ViewState> = new Subject();




    /**
     * 引擎初始化
     *
     * @public
     * @memberof OUIndexViewBase
     */
    public engineInit(): void {
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof OUIndexViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    public viewCacheData:any;

    /**
     * 解析视图参数
     *
     * @public
     * @memberof OUIndexViewBase
     */
    public parseViewParam(inputvalue:any = null): void {
        for(let key in this.context){
            delete this.context[key];
        }
        if (!this.viewDefaultUsage && this.viewdata && !Object.is(this.viewdata, '')) {
            Object.assign(this.context, JSON.parse(this.viewdata));
            if(this.context && this.context.srfparentdename){
                Object.assign(this.viewparams,{srfparentdename:this.context.srfparentdename});
            }
            if(this.context && this.context.srfparentkey){
                Object.assign(this.viewparams,{srfparentkey:this.context.srfparentkey});
            }
            if(this.$store.getters.getAppData() && this.$store.getters.getAppData().context){
                Object.assign(this.context,this.$store.getters.getAppData().context);
            }
            this.handleCustomViewData();
            return;
        }
        const path = (this.$route.matched[this.$route.matched.length - 1]).path;
        const keys: Array<any> = [];
        const curReg = this.$pathToRegExp.pathToRegexp(path, keys);
        const matchArray = curReg.exec(this.$route.path);
        let tempValue: Object = {};
        keys.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item.name, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
        this.$viewTool.formatRouteParams(tempValue,this.$route,this.context,this.viewparams);
        if(this.$store.getters.getAppData() && this.$store.getters.getAppData().context){
            Object.assign(this.context,this.$store.getters.getAppData().context);
        }
        this.handleCustomViewData();
        //初始化导航数据
        this.initNavDataWithRoute();
    }

    /**
     * 处理自定义视图数据
     *
     * @memberof OUIndexViewBase
     */
	public handleCustomViewData(){
		if(Object.keys(this.customViewNavContexts).length > 0){
			Object.keys(this.customViewNavContexts).forEach((item:any) =>{
				let tempContext:any = {};
				let curNavContext:any = this.customViewNavContexts[item];
				this.handleCustomDataLogic(curNavContext,tempContext,item);
				Object.assign(this.context,tempContext);
			})
		}
		if(Object.keys(this.customViewParams).length > 0){
			Object.keys(this.customViewParams).forEach((item:any) =>{
				let tempParam:any = {};
				let curNavParam:any = this.customViewParams[item];
				this.handleCustomDataLogic(curNavParam,tempParam,item);
				Object.assign(this.viewparams,tempParam);
			})
		}
	}

    /**
     * 处理自定义视图数据逻辑
     *
     * @memberof OUIndexViewBase
     */
	public handleCustomDataLogic(curNavData:any,tempData:any,item:string){
		// 直接值直接赋值
		if(curNavData.isRawValue){
			if(Object.is(curNavData.value,"null") || Object.is(curNavData.value,"")){
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: null,
                    writable : true,
                    enumerable : true,
                    configurable : true
                });
            }else{
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: curNavData.value,
                    writable : true,
                    enumerable : true,
                    configurable : true
                });
            }
		}else{
			// 先从导航上下文取数，没有再从导航参数（URL）取数，如果导航上下文和导航参数都没有则为null
			if(this.context[(curNavData.value).toLowerCase()]){
				Object.defineProperty(tempData, item.toLowerCase(), {
					value: this.context[(curNavData.value).toLowerCase()],
					writable : true,
					enumerable : true,
					configurable : true
				});
			}else{
				if(this.viewparams[(curNavData.value).toLowerCase()]){
					Object.defineProperty(tempData, item.toLowerCase(), {
						value: this.viewparams[(curNavData.value).toLowerCase()],
						writable : true,
						enumerable : true,
						configurable : true
					});
				}else{
					Object.defineProperty(tempData, item.toLowerCase(), {
						value: null,
						writable : true,
						enumerable : true,
						configurable : true
					});
				}
			}
		}
	}

    /**
     * 初始化导航数据(路由模式)
     *
     * @memberof OUIndexViewBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'ouindex-view',tag:this.viewtag,srfkey:isNew ? null : null,title:this.$t(this.model.srfTitle),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof OUIndexViewBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'ouindex-view',tag:this.viewtag,srfkey:null,title:this.$t(this.model.srfTitle),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof OUIndexViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof OUIndexViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'ouindex-view')){
                return;
            }
            if (Object.is(action, 'viewrefresh')) {
                _this.$nextTick(()=>{
                    _this.parseViewParam(data);
                    if(_this.engine){
                        _this.engine.load();
                    }
                }); 
            }
        });
        
    }

    /**
     * 销毁之前
     *
     * @memberof OUIndexViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof OUIndexViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof OUIndexViewBase
     */
    public afterMounted(){
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
                this.viewState.next({ tag: 'appmenu', action: 'load', data: {} });
        this.$viewTool.setIndexParameters([{ pathName: 'ouindexview', parameterName: 'ouindexview' }]);
        this.$viewTool.setIndexViewParam(this.context);

    }




    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof OUIndexViewBase
     */
    public closeView(args: any[]): void {
        let _view: any = this;
        if (_view.viewdata) {
            _view.$emit('viewdataschange', [args]);
            _view.$emit('close', [args]);
        } else if (_view.$tabPageExp) {
            _view.$tabPageExp.onClose(_view.$route.fullPath);
        }
    }

    /**
     * 菜单位置
     *
     * @public
     * @type {string}
     * @memberof OUIndexViewBase
     */
    public mode: string ='vertical';

    /**
     * 导航模式(route:面包屑模式、tab:分页导航模式)
     *
     * @type {string}
     * @memberof OUIndexViewBase
     */
    @Provide()
    public navModel:string = "tab";

    /**
     * 抽屉状态
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    public contextMenuDragVisiable: boolean = false;

    /**
     * 是否支持应用切换
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    public isEnableAppSwitch: boolean = false;

    /**
     * 初始化之前
     *
     * @memberof OUIndexViewBase
     */
    public beforeCreate(){
        let navDataService = NavDataService.getInstance(this.$store)
        navDataService.removeAllNavData();
    }

    /**
     * 当前主题
     *
     * @readonly
     * @memberof OUIndexViewBase
     */
    get selectTheme() {
        if (this.$router.app.$store.state.selectTheme) {
            return this.$router.app.$store.state.selectTheme;
        } else if (localStorage.getItem('theme-class')) {
            return localStorage.getItem('theme-class');
        } else {
            return 'app-default-theme';
        }
    }

    /**
     * 当前字体
     *
     * @readonly
     * @memberof OUIndexViewBase
     */
    get selectFont() {
        if (this.$router.app.$store.state.selectFont) {
            return this.$router.app.$store.state.selectFont;
        } else if (localStorage.getItem('font-family')) {
            return localStorage.getItem('font-family');
        } else {
            return 'Microsoft YaHei';
        }
    }

    /**
     * 菜单收缩变化
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    public collapseChange: boolean = false;

    /**
     * 菜单收缩点击
     *
     * @memberof OUIndexViewBase
     */
    public handleClick(): void {
        this.collapseChange = !this.collapseChange;
    }

    /**
     * 默认打开的视图
     *
     * @type {*}
     * @memberof OUIndexViewBase
     */
    public defPSAppView: any = {
    };

    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    public isDefaultPage: boolean = true;

    /**
     * 空白视图模式
     *
     * @type {boolean}
     * @memberof OUIndexViewBase
     */
    public isBlankMode:boolean = false;

    /**
     * 获取样式
     *
     * @readonly
     * @type {string[]}
     * @memberof OUIndexViewBase
     */
    get themeClasses(): string[] {
        return [
            Object.is(this.selectTheme, 'app_theme_blue') ? 'app_theme_blue' : '',
            Object.is(this.selectTheme, 'app-default-theme') ? 'app-default-theme' : '',
            Object.is(this.selectTheme, 'app_theme_darkblue') ? 'app_theme_darkblue' : '',
        ];
    }

    /**
     * 主题字体
     *
     * @readonly
     * @type {*}
     * @memberof OUIndexViewBase
     */
    get themeStyle(): any {
        return {
            'height': '100vh',
            'font-family': this.selectFont,
        }
    }

    /**
     * 获取路由列表
     *
     * @readonly
     * @type {any[]}
     * @memberof OUIndexViewBase
     */
    get getRouterList(): any[] {
        return this.$store.state.historyPathList;
    }

    /**
     * 获取路由键值
     *
     * @readonly
     * @type {string}
     * @memberof OUIndexViewBase
     */
    get getRouterViewKey(): string {
        return this.$route.fullPath;
    }

}
</script>

<style lang='less'>
@import './ouindex-view.less';
</style>