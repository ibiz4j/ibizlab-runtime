<template>
<div class='view-container depickupgridview wfgroup-pickup-grid-view'>
    <app-studioaction :viewTitle="$t(model.srfCaption)" viewName="wfgrouppickupgridview"></app-studioaction>
    <card class='view-card view-no-caption  view-no-toolbar' :dis-hover="true" :bordered="false">
        <div class='view-top-messages'>
        </div>
        <div class='content-container pickup-grid-view'>
            <view_searchform 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :showBusyIndicator="true"
                v-show="isExpandSearchForm"
                loaddraftAction="FilterGetDraft"
                loadAction="FilterGet"
            
                name="searchform"  
                ref='searchform' 
                @search="searchform_search($event)"  
                @load="searchform_load($event)"  
                @save="searchform_save($event)"  
                @closeview="closeView($event)">
            </view_searchform>
                    <div class='view-body-messages'>                    </div>            <view_grid 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :isSingleSelect="isSingleSelect"
                :selectedData="selectedData"
                :showBusyIndicator="true"
                updateAction=""
                removeAction="Remove"
                loaddraftAction=""
                loadAction=""
                createAction=""
                fetchAction="FetchDefault"
                name="grid"  
                ref='grid' 
                @rowdblclick="grid_rowdblclick($event)"  
                @selectionchange="grid_selectionchange($event)"  
                @load="grid_load($event)"  
                @beforeload="grid_beforeload($event)"  
                @closeview="closeView($event)">
            </view_grid>
        </div>
        <div class='view-bottom-messages'>
        </div>
    </card>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch,Inject } from 'vue-property-decorator';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import { Subject,Subscription } from 'rxjs';
import WFGroupService from '@/service/wfgroup/wfgroup-service';
import WFGroupAuthService from '@/authservice/wfgroup/wfgroup-auth-service';

import PickupGridViewEngine from '@engine/view/pickup-grid-view-engine';


import WFGroupUIService from '@/uiservice/wfgroup/wfgroup-ui-service';

@Component({
    components: {
    },
})
export default class WFGroupPickupGridViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {WFGroupService}
     * @memberof WFGroupPickupGridViewBase
     */
    public appEntityService: WFGroupService = new WFGroupService;

    /**
     * 实体UI服务对象
     *
     * @type WFGroupUIService
     * @memberof WFGroupPickupGridViewBase
     */
    public appUIService: WFGroupUIService = new WFGroupUIService(this.$store);
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof WFGroupPickupGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof WFGroupPickupGridViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof WFGroupPickupGridViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof WFGroupPickupGridViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

    /**
     * 视图默认使用
     *
     * @type {string}
     * @memberof WFGroupPickupGridViewBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof WFGroupPickupGridViewBase
	 */
	public viewtag: string = '17ccd6d8d2bb7cf30158253da129ec1b';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof WFGroupPickupGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof WFGroupPickupGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof WFGroupPickupGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.wfgroup.views.pickupgridview.caption',
        srfTitle: 'entities.wfgroup.views.pickupgridview.title',
        srfSubTitle: 'entities.wfgroup.views.pickupgridview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof WFGroupPickupGridViewBase
     */
    @Watch('viewparam',{immediate: true, deep: true})
    onParamData(newVal: any, oldVal: any) {
        if(newVal){
            this.viewparams = {};
            if(typeof newVal == 'string') {
                Object.assign(this.viewparams, JSON.parse(this.viewparam));
            }else{
                this.viewparams = Util.deepCopy(this.viewparam);
            }
            
        } 
    }

    /**
     * 处理应用上下文变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof WFGroupPickupGridViewBase
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
     * @memberof WFGroupPickupGridViewBase
     */
    public containerModel: any = {
        view_grid: { name: 'grid', type: 'GRID' },
        view_searchform: { name: 'searchform', type: 'SEARCHFORM' },
    };

    /**
     * 视图刷新
     *
     * @param {*} args
     * @memberof WFGroupPickupGridViewBase
     */
    public refresh(args?: any): void {
        const refs: any = this.$refs;
        if (refs && refs.grid) {
            refs.grid.refresh();
        }
    }
    /**
     *  计数器刷新
     *
     * @memberof WFGroupPickupGridViewBase
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
     * @memberof WFGroupPickupGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof WFGroupPickupGridViewBase
     */
    public engine: PickupGridViewEngine = new PickupGridViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof WFGroupPickupGridViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            grid: this.$refs.grid,
            searchform: this.$refs.searchform,
            keyPSDEField: 'wfgroup',
            majorPSDEField: 'name',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof WFGroupPickupGridViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof WFGroupPickupGridViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 门户部件状态对象
     *
     * @type {*}
     * @memberof WFGroupPickupGridViewBase
     */
    @Prop() public portletState?: any;

   /**
   * 门户部件状态事件
   *
   * @public
   * @type {(Subscription | undefined)}
   * @memberof WFGroupPickupGridViewBase
   */
    public portletStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof WFGroupPickupGridViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof WFGroupPickupGridViewBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof WFGroupPickupGridViewBase
     */
    public viewCacheData:any;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof WFGroupPickupGridViewBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 解析视图参数
     *
     * @public
     * @memberof WFGroupPickupGridViewBase
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
        if(inputvalue){
            Object.assign(this.context,{'wfgroup':inputvalue});
        }
        //初始化视图唯一标识
        Object.assign(this.context,{srfsessionid:this.$util.createUUID()});
        this.handleCustomViewData();
        //初始化导航数据
        this.initNavDataWithRoute();
    }

    /**
     * 处理自定义视图数据
     *
     * @memberof WFGroupPickupGridViewBase
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
     * @memberof WFGroupPickupGridViewBase
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
     * @memberof WFGroupPickupGridViewBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'wfgroup-pickup-grid-view',tag:this.viewtag,srfkey:isNew ? null : this.context.wfgroup,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof WFGroupPickupGridViewBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'wfgroup-pickup-grid-view',tag:this.viewtag,srfkey:this.context.wfgroup,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof WFGroupPickupGridViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof WFGroupPickupGridViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'wfgroup-pickup-grid-view')){
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
        if(_this.portletState){
            _this.portletStateEvent = _this.portletState.subscribe((res:any) =>{
                if(!Object.is(res.name,'WFGroupPickupGridView')){
                    return;
                }
                if(Object.is(res.action,'refresh') && _this.refresh && _this.refresh instanceof Function){
                    _this.refresh();
                }
            })
        }
        
    }

    /**
     * 销毁之前
     *
     * @memberof WFGroupPickupGridViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof WFGroupPickupGridViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof WFGroupPickupGridViewBase
     */
    public afterMounted(){
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
        
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFGroupPickupGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFGroupPickupGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFGroupPickupGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFGroupPickupGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * searchform 部件 search 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFGroupPickupGridViewBase
     */
    public searchform_search($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'search', $event);
    }


    /**
     * searchform 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFGroupPickupGridViewBase
     */
    public searchform_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'load', $event);
    }


    /**
     * searchform 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFGroupPickupGridViewBase
     */
    public searchform_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'save', $event);
    }




    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof WFGroupPickupGridViewBase
     */
    public closeView(args: any[]): void {
        let _view: any = this;
        if (_view.viewdata) {
            _view.$emit('viewdataschange', Array.isArray(args)?args:[args]);
            _view.$emit('close', Array.isArray(args)?args:[args]);
        } else if (_view.$tabPageExp) {
            _view.$tabPageExp.onClose(_view.$route.fullPath);
        }
    }

    /**
     * 销毁视图回调
     *
     * @memberof WFGroupPickupGridViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof WFGroupPickupGridViewBase
     */
    public afterDestroyed(){
        if(this.viewDefaultUsage){
            let localStoreLength = Object.keys(localStorage);
            if(localStoreLength.length > 0){
                localStoreLength.forEach((item:string) =>{
                if(item.startsWith(this.context.srfsessionid)){
                    localStorage.removeItem(item);
                }
                })
            }
            if(Object.is(this.navModel,"tab")){
                this.navDataService.removeNavDataByTag(this.viewtag);
            }
            if (this.serviceStateEvent) {
                this.serviceStateEvent.unsubscribe();
            }
        }
        // 销毁计数器定时器
        if(this.counterServiceArray && this.counterServiceArray.length >0){
            this.counterServiceArray.forEach((item:any) =>{
                if(item.destroyCounter && item.destroyCounter instanceof Function){
                    item.destroyCounter();
                }
            })
        }
        if(this.portletStateEvent){
            this.portletStateEvent.unsubscribe();
        }
        this.viewState.complete();        
    }
    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof WFGroupPickupGridViewBase
     */
    @Prop() public selectedData?: string;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof WFGroupPickupGridViewBase
     */
    @Prop() public isSingleSelect?: boolean;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof WFGroupPickupGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof WFGroupPickupGridViewBase
     */
    public isExpandSearchForm: boolean = true;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof WFGroupPickupGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 2;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof WFGroupPickupGridViewBase
     */
    public onSearch($event: any): void {
        const refs: any = this.$refs;
        if (refs.grid) {
            refs.grid.load({});
        }
    }

}
</script>

<style lang='less'>
@import './wfgroup-pickup-grid-view.less';
</style>