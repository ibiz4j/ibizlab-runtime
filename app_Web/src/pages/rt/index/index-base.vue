<template>
<div class="index_view index">
    <app-studioaction :viewTitle="$t(model.srfCaption)" viewName="index"></app-studioaction>
    <layout :class="themeClasses" :style="themeStyle">
        <layout id="movebox">
            <sider class="index_sider" :width="collapseChange ? 64 : 200" hide-trigger v-model="collapseChange" id= "left_move">
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
    viewtag="index"
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
            <div v-show="!collapseChange"  id="move_axis"></div>
            <layout id="right_move">
                <header class="index_header">
                    <div class="header-left" >
                        <div class="page-logo">
                            <i v-show="!collapseChange" class="ivu-icon el-icon-s-fold" @click="handleClick"></i>
                            <i v-show="collapseChange" class="ivu-icon el-icon-s-unfold" @click="handleClick"></i>
                            <app-breadcrumb  :navModel="navModel" indexViewTag="index"></app-breadcrumb>
                        </div>
                    </div>
                    <div class="header-right" style="display: flex;align-items: center;justify-content: space-between;">
                        <app-header-menus />
                        <app-lang style='font-size: 15px;padding: 0 10px;'></app-lang>
                        <app-orgsector></app-orgsector>
                        <app-user></app-user>
                        <app-message-popover></app-message-popover>
                        <app-lock-scren />
                        <app-full-scren />
                        <app-theme style="width:45px;display: flex;justify-content: center;"></app-theme>
                    </div>
                </header>
                <content :class="{'index_content':true,'index_tab_content':Object.is(navModel,'tab')?true:false,'index_route_content':Object.is(navModel,'route')?true:false}"   @click="contextMenuDragVisiable=false">
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



import { appConfig } from '@/config/appConfig';


@Component({
    components: {
    },
})
export default class IndexBase extends Vue {
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof IndexBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof IndexBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof IndexBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;


	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof IndexBase
	 */
	public viewtag: string = 'b50d665e5fb8a9da01406754e0ab5f15';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof IndexBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof IndexBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof IndexBase
     */
    public model: any = {
        srfCaption: 'app.views.index.caption',
        srfTitle: 'app.views.index.title',
        srfSubTitle: 'app.views.index.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IndexBase
     */
    @Watch('viewparam',{immediate: true, deep: true})
    onParamData(newVal: any, oldVal: any) {
        if(newVal){
            for(let key in this.viewparams){
                delete this.viewparams[key];
            }
            if(typeof this.viewparams == 'string') {
                Object.assign(this.viewparams, JSON.parse(this.viewparam));
            }
            
        } 
    }

    /**
     * 处理应用上下文变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IndexBase
     */
    @Watch('viewdata')
    onViewData(newVal: any, oldVal: any) {
        const _this: any = this;
        if (!Object.is(newVal, oldVal) && _this.engine) {
            this.$nextTick(()=>{
              _this.parseViewParam();
              _this.engine.load();
              
            });
        } else if(!Object.is(newVal, oldVal) && _this.refresh && _this.refresh instanceof Function) {
            _this.refresh();
        }
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof IndexBase
     */
    public containerModel: any = {
        view_appmenu: { name: 'appmenu', type: 'APPMENU' },
    };

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
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof IndexBase
     */
    public viewState: Subject<ViewState> = new Subject();




    /**
     * 引擎初始化
     *
     * @public
     * @memberof IndexBase
     */
    public engineInit(): void {
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof IndexBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof IndexBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof IndexBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof IndexBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof IndexBase
     */
    public viewCacheData:any;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof IndexBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 解析视图参数
     *
     * @public
     * @memberof IndexBase
     */
    public parseViewParam(inputvalue:any = null): void {
        for(let key in this.context){
            delete this.context[key];
        }
        if(this.$store.getters.getAppData() && this.$store.getters.getAppData().context){
            Object.assign(this.context,this.$store.getters.getAppData().context);
        }
        if (!this.viewDefaultUsage && this.viewdata && !Object.is(this.viewdata, '')) {
            if(typeof this.viewdata == 'string') {
                Object.assign(this.context, JSON.parse(this.viewdata));
            }
            if(this.context && this.context.srfparentdename){
                Object.assign(this.viewparams,{srfparentdename:this.context.srfparentdename});
            }
            if(this.context && this.context.srfparentkey){
                Object.assign(this.viewparams,{srfparentkey:this.context.srfparentkey});
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
        this.handleCustomViewData();
        //初始化导航数据
        this.initNavDataWithRoute();
    }

    /**
     * 处理自定义视图数据
     *
     * @memberof IndexBase
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
     * @memberof IndexBase
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
			if(this.context[(curNavData.value).toLowerCase()] != null){
				Object.defineProperty(tempData, item.toLowerCase(), {
					value: this.context[(curNavData.value).toLowerCase()],
					writable : true,
					enumerable : true,
					configurable : true
				});
			}else{
				if(this.viewparams[(curNavData.value).toLowerCase()] != null){
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
     * @memberof IndexBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'index',tag:this.viewtag,srfkey:isNew ? null : null,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof IndexBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'index',tag:this.viewtag,srfkey:null,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof IndexBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof IndexBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'index')){
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
     * @memberof IndexBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof IndexBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof IndexBase
     */
    public afterMounted(){
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
                this.viewState.next({ tag: 'appmenu', action: 'load', data: {} });
        this.$viewTool.setIndexParameters([{ pathName: 'index', parameterName: 'index' }]);
        this.$viewTool.setIndexViewParam(this.context);
        this.mouse_move();

    }




    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof IndexBase
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
     * @memberof IndexBase
     */
    public mode: string ='vertical';

    /**
     * 导航模式(route:面包屑模式、tab:分页导航模式)
     *
     * @type {string}
     * @memberof IndexBase
     */
    @Provide()
    public navModel:string = "tab";

    /**
     * 抽屉状态
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    public contextMenuDragVisiable: boolean = false;

    /**
     * 是否支持应用切换
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    public isEnableAppSwitch: boolean = true;

    /**
     * 初始化之前
     *
     * @memberof IndexBase
     */
    public beforeCreate(){
        let navDataService = NavDataService.getInstance(this.$store)
        navDataService.removeAllNavData();
    }

    /**
     * 当前主题
     *
     * @readonly
     * @memberof IndexBase
     */
    get selectTheme() {
        if (this.$router.app.$store.state.selectTheme) {
            return this.$router.app.$store.state.selectTheme;
        } else if (localStorage.getItem('theme-class')) {
            return localStorage.getItem('theme-class');
        } else {
            return appConfig.defaultTheme;
        }
    }

    /**
     * 当前字体
     *
     * @readonly
     * @memberof IndexBase
     */
    get selectFont() {
        if (this.$router.app.$store.state.selectFont) {
            return this.$router.app.$store.state.selectFont;
        } else if (localStorage.getItem('font-family')) {
            return localStorage.getItem('font-family');
        } else {
            return appConfig.defaultFont;
        }
    }

    /**
     * 菜单收缩变化
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    public collapseChange: boolean = false;

    /**
     * 菜单收缩点击
     *
     * @memberof IndexBase
     */
    public handleClick(): void {
        this.collapseChange = !this.collapseChange;
    }

    /**
     * 默认打开的视图
     *
     * @type {*}
     * @memberof IndexBase
     */
    public defPSAppView: any = {
        codename: 'sysorganizationgridview',
        viewtitle: '单位管理',
        openmode: '',
        width: 0,
        height: 0,
        deResParameters: [],
        routepath: '/index/:index?/sysorganizations/:sysorganization?/gridview/:gridview?',
        parameters: [
            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ],
    };

    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    public isDefaultPage: boolean = false;

    /**
     * 空白视图模式
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    public isBlankMode:boolean = false;

    /**
     * 获取样式
     *
     * @readonly
     * @type {string[]}
     * @memberof IndexBase
     */
    get themeClasses(): string {
        return this.selectTheme;
    }

    /**
     * 主题字体
     *
     * @readonly
     * @type {*}
     * @memberof IndexBase
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
     * @memberof IndexBase
     */
    get getRouterList(): any[] {
        return this.$store.state.historyPathList;
    }

    /**
     * 获取路由键值
     *
     * @readonly
     * @type {string}
     * @memberof IndexBase
     */
    get getRouterViewKey(): string {
        return this.$route.fullPath;
    }

    /**
     * 鼠标拖动事件
     *
     * @param {*} val
     * @returns {*}
     * @memberof IndexBase
     */
    public mouse_move(){
        let move_axis:any = document.getElementById("move_axis");
        let left_move :any= document.getElementById("left_move");
        let right_move :any= document.getElementById("right_move");
        let movebox :any= document.getElementById("movebox");
        let leftWidth :number = parseInt(left_move.style.width);
        move_axis.onmousedown = (e:any) =>{
            let startX = e.clientX;
            move_axis.left = move_axis.offsetLeft;
            document.onmousemove =  (e:any) =>{
                let endX = e.clientX; 
                let moveLen = move_axis.left + (endX - startX);
                let maxT = movebox.clientWidth - move_axis.offsetWidth;
                if (moveLen < 150) moveLen = 150;
                if (moveLen > maxT - 150) moveLen = maxT - 150; 
                move_axis.style.left = moveLen;
                left_move.style.width = moveLen + "px";
                right_move.style.width = (movebox.clientWidth - moveLen - 5) + "px";
                if (moveLen>500) {
                    left_move.style.width = 500 + 'px';
                }

                let left_width : number = parseInt(left_move.style.width);
                move_axis.style.left = left_width - 5 + 'px';
                if (left_width < leftWidth){
                    move_axis.style.left = leftWidth - 5 + 'px';
                }
            }
            document.onmouseup = (evt) =>{
                document.onmousemove = null;
                document.onmouseup = null;
                move_axis.releaseCapture && move_axis.releaseCapture();
            }
            move_axis.setCapture && move_axis.setCapture();
            return false;
        }
        
    }

}
</script>

<style lang='less'>
@import './index.less';
</style>