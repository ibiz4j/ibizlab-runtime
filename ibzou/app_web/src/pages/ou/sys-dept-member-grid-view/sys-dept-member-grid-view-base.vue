<template>
<div class='view-container degridview sys-dept-member-grid-view'>
    <app-studioaction :viewTitle="$t(model.srfCaption)" viewName="sysdeptmembergridview"></app-studioaction>
    <card class='view-card  view-no-caption'  :dis-hover="true" :bordered="false">
            <div class='view-top-messages'>
            </div>
        <div class='content-container'>
            <div style='margin-bottom: 6px;'>
                <div class='pull-right'>
                    <div class='toolbar-container'>
                        <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem24.visabled" :disabled="toolBarModels.tbitem24.disabled" class='' v-loading:i-button @click="toolbar_click({ tag: 'tbitem24' }, $event)">
                                    <i class='fa fa-table'></i>
                                    <span class='caption'>{{$t('entities.sysdeptmember.gridviewtoolbar_toolbar.tbitem24.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.sysdeptmember.gridviewtoolbar_toolbar.tbitem24.tip')}}</div>
                        </tooltip>
                        <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem25.visabled" :disabled="toolBarModels.tbitem25.disabled" class='' v-loading:i-button @click="toolbar_click({ tag: 'tbitem25' }, $event)">
                                    <i class='fa fa-plus'></i>
                                    
                                </i-button>
                            <div slot='content'>{{$t('entities.sysdeptmember.gridviewtoolbar_toolbar.tbitem25.tip')}}</div>
                        </tooltip>
                        <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.deuiaction1.visabled" :disabled="toolBarModels.deuiaction1.disabled" class='' v-loading:i-button @click="toolbar_click({ tag: 'deuiaction1' }, $event)">
                                    <i class='fa fa-save'></i>
                                    <span class='caption'>{{$t('entities.sysdeptmember.gridviewtoolbar_toolbar.deuiaction1.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.sysdeptmember.gridviewtoolbar_toolbar.deuiaction1.tip')}}</div>
                        </tooltip>
                        <span class='seperator'>|</span>
                        <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem8.visabled" :disabled="toolBarModels.tbitem8.disabled" class='' v-loading:i-button @click="toolbar_click({ tag: 'tbitem8' }, $event)">
                                    <i class='fa fa-remove'></i>
                                    <span class='caption'>{{$t('entities.sysdeptmember.gridviewtoolbar_toolbar.tbitem8.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.sysdeptmember.gridviewtoolbar_toolbar.tbitem8.tip')}}</div>
                        </tooltip>
                    </div>
                </div>
            </div>
                    <div class='view-body-messages'>
                    </div>
            <view_grid 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :isSingleSelect="isSingleSelect"
                :showBusyIndicator="true"
                :isOpenEdit="true"
                :gridRowActiveMode="gridRowActiveMode"
                :isformDruipart="isformDruipart"
                @save="onSave"
                updateAction="Update"
                removeAction="Remove"
                loaddraftAction="GetDraft"
                loadAction="Get"
                createAction="Create"
                fetchAction="FetchDefault"
                :newdata="newdata"
                :opendata="opendata"
                name="grid"  
                ref='grid' 
                @selectionchange="grid_selectionchange($event)"  
                @beforeload="grid_beforeload($event)"  
                @rowdblclick="grid_rowdblclick($event)"  
                @remove="grid_remove($event)"  
                @load="grid_load($event)"  
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
import SysDeptMemberService from '@/service/sys-dept-member/sys-dept-member-service';
import SysDeptMemberAuthService from '@/authservice/sys-dept-member/sys-dept-member-auth-service';

import GridViewEngine from '@engine/view/grid-view-engine';


import SysDeptMemberUIService from '@/uiservice/sys-dept-member/sys-dept-member-ui-service';
import CodeListService from "@/codelist/codelist-service";


@Component({
    components: {
    },
})
export default class SysDeptMemberGridViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {SysDeptMemberService}
     * @memberof SysDeptMemberGridViewBase
     */
    public appEntityService: SysDeptMemberService = new SysDeptMemberService;

    /**
     * 实体UI服务对象
     *
     * @type SysDeptMemberUIService
     * @memberof SysDeptMemberGridViewBase
     */
    public appUIService: SysDeptMemberUIService = new SysDeptMemberUIService(this.$store);
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof SysDeptMemberGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof SysDeptMemberGridViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof SysDeptMemberGridViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof SysDeptMemberGridViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

    /**
     * 视图默认使用
     *
     * @type {string}
     * @memberof SysDeptMemberGridViewBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof SysDeptMemberGridViewBase
	 */
	public viewtag: string = '523b25cb9c95d2ef731c39ca24cfe98a';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof SysDeptMemberGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof SysDeptMemberGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof SysDeptMemberGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.sysdeptmember.views.gridview.caption',
        srfTitle: 'entities.sysdeptmember.views.gridview.title',
        srfSubTitle: 'entities.sysdeptmember.views.gridview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof SysDeptMemberGridViewBase
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
     * @memberof SysDeptMemberGridViewBase
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
     * @memberof SysDeptMemberGridViewBase
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_grid: { name: 'grid', type: 'GRID' },
    };

    /**
     * 视图刷新
     *
     * @param {*} args
     * @memberof SysDeptMemberGridViewBase
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
     * @memberof SysDeptMemberGridViewBase
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
     * @memberof SysDeptMemberGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof SysDeptMemberGridView
     */
    public toolBarModels: any = {
        tbitem24: { name: 'tbitem24', actiontarget: 'NONE', caption: '行编辑', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'ToggleRowEdit', target: '' } },

        tbitem25: { name: 'tbitem25', actiontarget: 'NONE', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'NewRow', target: '' } },

        deuiaction1: { name: 'deuiaction1', actiontarget: 'NONE', caption: '保存行', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'SaveRow', target: '' } },

        tbitem26: {  name: 'tbitem26', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem8: { name: 'tbitem8', actiontarget: 'NONE', caption: '删除', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'Remove', target: 'MULTIKEY' } },

    };





    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof SysDeptMemberGridViewBase
     */
    public engine: GridViewEngine = new GridViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof SysDeptMemberGridViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            opendata: (args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) => {
                this.opendata(args,fullargs, params, $event, xData);
            },
            newdata: (args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) => {
                this.newdata(args,fullargs, params, $event, xData);
            },
            grid: this.$refs.grid,
            keyPSDEField: 'sysdeptmember',
            majorPSDEField: 'personname',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof SysDeptMemberGridViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof SysDeptMemberGridViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 门户部件状态对象
     *
     * @type {*}
     * @memberof SysDeptMemberGridViewBase
     */
    @Prop() public portletState?: any;

   /**
   * 门户部件状态事件
   *
   * @public
   * @type {(Subscription | undefined)}
   * @memberof SysDeptMemberGridViewBase
   */
    public portletStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof SysDeptMemberGridViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof SysDeptMemberGridViewBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof SysDeptMemberGridViewBase
     */
    public viewCacheData:any;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof SysDeptMemberGridViewBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 解析视图参数
     *
     * @public
     * @memberof SysDeptMemberGridViewBase
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
            Object.assign(this.context,{'sysdeptmember':inputvalue});
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
     * @memberof SysDeptMemberGridViewBase
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
     * @memberof SysDeptMemberGridViewBase
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
     * @memberof SysDeptMemberGridViewBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'sys-dept-member-grid-view',tag:this.viewtag,srfkey:isNew ? null : this.context.sysdeptmember,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof SysDeptMemberGridViewBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'sys-dept-member-grid-view',tag:this.viewtag,srfkey:this.context.sysdeptmember,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof SysDeptMemberGridViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof SysDeptMemberGridViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'sys-dept-member-grid-view')){
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
                if(!Object.is(res.name,'SysDeptMemberGridView')){
                    return;
                }
                if(Object.is(res.action,'refresh') && _this.refresh && _this.refresh instanceof Function){
                    _this.refresh();
                }
            })
        }
        if(this.formDruipart){
            this.formDruipart.subscribe((res:any) =>{
                if(Object.is(res.action,'save')){
                    this.viewState.next({ tag:'grid', action: 'save', data: this.viewparams });
                }
                if(Object.is(res.action,'load')){
                    const _this: any = this;
                    _this.engine.load(res.data,true);
                }
            });
        }

    }

    /**
     * 销毁之前
     *
     * @memberof SysDeptMemberGridViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof SysDeptMemberGridViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof SysDeptMemberGridViewBase
     */
    public afterMounted(){
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
        

    }


    /**
     * toolbar 部件 click 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysDeptMemberGridViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem24')) {
            this.toolbar_tbitem24_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem25')) {
            this.toolbar_tbitem25_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction1')) {
            this.toolbar_deuiaction1_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem8')) {
            this.toolbar_tbitem8_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem19')) {
            this.toolbar_tbitem19_click(null, '', $event2);
        }
    }


    /**
     * grid 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysDeptMemberGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysDeptMemberGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysDeptMemberGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysDeptMemberGridViewBase
     */
    public grid_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'remove', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysDeptMemberGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }



    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem24_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.ToggleRowEdit(datas, contextJO,paramJO,  $event, xData,this,"SysDeptMember");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem25_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.NewRow(datas, contextJO,paramJO,  $event, xData,this,"SysDeptMember");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_deuiaction1_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.SaveRow(datas, contextJO,paramJO,  $event, xData,this,"SysDeptMember");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem8_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.Remove(datas, contextJO,paramJO,  $event, xData,this,"SysDeptMember");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem19_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.ToggleFilter(datas, contextJO,paramJO,  $event, xData,this,"SysDeptMember");
    }

    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof SysDeptMemberGridView
     */
    public newdata(args: any[],fullargs?:any[], params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
        let tempContext:any = this.$util.deepCopy(this.context);
        let data:any = this.$util.deepCopy(args[0]);
        let batchAddPSAppViews:Array<any>=[];
        batchAddPSAppViews=[
            {view:{viewname:'sys-employee-mpickup-view',height: 0,width: 0,title: '人员数据多项选择视图'},
            res:['SysEmployee'],
            'resAppKey':'userid'},
            {view:{viewname:'sys-department-mpickup-view',height: 0,width: 0,title: '部门数据多项选择视图'},
            res:['SysDepartment'],
            'resAppKey':'deptid'}
        ];
        if(batchAddPSAppViews.length == 0 || !this.context.srfparentdename){
            this.$Notice.warning({ title: '错误', desc: '批量添加需添加N:N关系' });
            return;
        }
        let openViewModel:any = batchAddPSAppViews.find((item:any) =>{
            return (item.res && (item.res[0] !== this.context.srfparentdename));
        })
        let otherViewModel:any = batchAddPSAppViews.find((item:any) =>{
            return (item.res && (item.res[0] == this.context.srfparentdename));
        })
        let container: Subject<any> = this.$appmodal.openModal(openViewModel.view, tempContext, data);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            if(result.datas && result.datas.length == 0){
                return;
            }
            let requestParam:Array<any> = [];
            result.datas.forEach((record:any) => {
                let tempParam:any = {};
                tempParam[otherViewModel.resAppKey] = this.context['srfparentkey'];
                tempParam[openViewModel.resAppKey] = record.srfkey;
                requestParam.push(tempParam);
            });
            this.appEntityService.createBatch(JSON.parse(JSON.stringify(this.context)),requestParam,true).then((response:any) =>{
                if (!response || response.status !== 200) {
                    this.$Notice.error({ title: '错误', desc: '批处理操作失败' });
                    return;
                }
                if (!xData || !(xData.refresh instanceof Function)) {
                    return;
                }
                xData.refresh(result.datas);
            });
        });
    }


    /**
     * 打开编辑数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof SysDeptMemberGridView
     */
    public opendata(args: any[],fullargs?:any,params?: any, $event?: any, xData?: any) {
        if(!this.viewDefaultUsage){
            if(Object.is(this.navModel,"route")){
                this.initNavDataWithRoute(this.viewCacheData, false, true);
            }else{
                this.initNavDataWithTab(this.viewCacheData, false, true);
            }
        }
        let localContext:any = null;
        let localViewParam:any =null;
        const data: any = {};
        let tempContext = JSON.parse(JSON.stringify(this.context));
        if(args.length >0){
            Object.assign(tempContext,args[0]);
        }
        let deResParameters: any[] = [];
        if(tempContext.sysdepartment && true){
            deResParameters = [
            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
            ]
        }
        const parameters: any[] = [
            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
        ];
        const _this: any = this;
        if(fullargs && fullargs.copymode){
            Object.assign(data,{copymode:true});
        }
        const openPopupModal = (view: any, data: any) => {
            let container: Subject<any> = this.$appmodal.openModal(view, tempContext, data);
            container.subscribe((result: any) => {
                if (!result || !Object.is(result.ret, 'OK')) {
                    return;
                }
                if (!xData || !(xData.refresh instanceof Function)) {
                    return;
                }
                xData.refresh(result.datas);
            });
        }
        const view: any = {
            viewname: 'sys-dept-member-edit-view', 
            height: 0, 
            width: 0,  
            title: this.$t('entities.sysdeptmember.views.editview.title'),
        };
        openPopupModal(view, data);
    }


    /**
     * 行编辑
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof SysDeptMemberGridViewBase
     */
    public ToggleRowEdit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        xData.actualIsOpenEdit = !xData.actualIsOpenEdit;
    }
    /**
     * 新建行
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof SysDeptMemberGridViewBase
     */
    public NewRow(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        const data: any = {};
        if (_this.hasOwnProperty('newRow') && _this.newRow instanceof Function) {
            _this.newRow([{ ...data }], params, $event, xData);
        } else if(xData.newRow && xData.newRow instanceof Function) {
            xData.newRow([{ ...data }], params, $event, xData);
        }else{
            _this.$Notice.error({ title: '错误', desc: 'newRow 视图处理逻辑不存在，请添加!' });
        }
    }
    /**
     * 保存行
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof SysDeptMemberGridViewBase
     */
    public SaveRow(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        // 界面行为容器对象 _this
        const _this: any = this;
        if (xData && xData.save instanceof Function) {
            xData.save();
        } else if (_this.save && _this.save instanceof Function) {
            _this.save();
        }
    }
    /**
     * 删除
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof SysDeptMemberGridViewBase
     */
    public Remove(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.remove instanceof Function)) {
            return ;
        }
        xData.remove(args);
    }

    /**
     * 过滤
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof SysDeptMemberGridViewBase
     */
    public ToggleFilter(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (_this.hasOwnProperty('isExpandSearchForm')) {
            _this.isExpandSearchForm = !_this.isExpandSearchForm;
        }
    }

    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof SysDeptMemberGridViewBase
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
     * @memberof SysDeptMemberGridViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof SysDeptMemberGridViewBase
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
    }

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof SysDeptMemberGridViewBase
     */
    public isSingleSelect: boolean = false;


    /**
    * 是否嵌入关系界面
    *
    * @type {boolean}
    * @memberof SysDeptMemberGridViewBase
    */
    @Prop({default:false}) public isformDruipart?: boolean;

    /**
    * 界面关系通讯对象
    *
    * @type {Subject<ViewState>}
    * @memberof SysDeptMemberGridViewBase
    */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof SysDeptMemberGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof SysDeptMemberGridViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof SysDeptMemberGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 2;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof SysDeptMemberGridViewBase
     */
    public onSearch($event: any): void {
        const grid: any = this.$refs.grid;
        if (grid) {
            grid.load(this.context, true);
        }
    }

    /**
     * grid 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof ENTITYTEST1Usr2GridViewBase
     */
    public onSave($event: any) {
        this.$emit('drdatasaved', $event);
    }

    /**
     * 刷新数据
     *
     * @readonly
     * @type {(number | null)}
     * @memberof SysDeptMemberGridViewBase
     */
    get refreshdata(): number | null {
        return this.$store.getters['viewaction/getRefreshData'](this.viewtag);
    }

    /**
     * 监控数据变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @returns
     * @memberof SysDeptMemberGridViewBase
     */
    @Watch('refreshdata')
    onRefreshData(newVal: any, oldVal: any) {
        if (newVal === null || newVal === undefined) {
            return;
        }
        if (newVal === 0) {
            return;
        }
        const grid: any = this.$refs.grid;
        if (grid) {
            grid.load({});
        }
    }

}
</script>

<style lang='less'>
@import './sys-dept-member-grid-view.less';
</style>