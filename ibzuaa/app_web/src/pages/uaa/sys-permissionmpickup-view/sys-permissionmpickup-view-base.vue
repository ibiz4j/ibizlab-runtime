<template>
<div class="view-container dempickupview sys-permissionmpickup-view">
    <app-studioaction :viewTitle="$t(model.srfCaption)" viewName="sys_permissionmpickupview"></app-studioaction>
    <card class='view-card view-no-caption  view-no-toolbar' :dis-hover="true" :padding="0" :bordered="false">
        <div class='view-top-messages'>
        </div>
        <div class="content-container pickup-view">
        <div class='view-body-messages'>
        </div>
            <div class="translate-contant">
                <div class="center" :style="{width : !isShowButton ? '100%' : ''}">
    <view_pickupviewpanel 
        :viewState="viewState"  
        :viewparams="JSON.parse(JSON.stringify(viewparams))" 
        :context="JSON.parse(JSON.stringify(context))" 
        :isSingleSelect="isSingleSelect"
        :selectedData="selectedData"
        :isShowButton="isShowButton"
        name="pickupviewpanel"  
        ref='pickupviewpanel' 
        @selectionchange="pickupviewpanel_selectionchange($event)"  
        @load="pickupviewpanel_load($event)"  
        @activated="pickupviewpanel_activated($event)"  
        @closeview="closeView($event)">
    </view_pickupviewpanel>
                </div>
                <div v-if="isShowButton" class="translate-buttons">
                    <div class="buttons">
                        <i-button type="primary" :title="this.containerModel.view_rightbtn.text"
                            :disabled="this.containerModel.view_rightbtn.disabled"
                            @click="onCLickRight">
                            <i class="el-icon-arrow-right"></i>
                        </i-button>
                        <i-button type="primary" :title="this.containerModel.view_leftbtn.text"
                            :disabled="this.containerModel.view_leftbtn.disabled"
                            @click="onCLickLeft">
                            <i class="el-icon-arrow-left"></i>
                        </i-button>
                        <i-button type="primary" :title="this.containerModel.view_allrightbtn.text"
                            @click="onCLickAllRight">
                            <i class="el-icon-d-arrow-right"></i>
                        </i-button>
                        <i-button type="primary" :title="this.containerModel.view_allleftbtn.text"
                            @click="onCLickAllLeft">
                            <i class="el-icon-d-arrow-left"></i>
                        </i-button>
                    </div>
                    </div>
                    <div v-if="isShowButton" class="right">
                        <div class="mpicker-select">
                            <div v-for="(item, index) in viewSelections" :key="index" :class="item._select ? 'select' : ''" @click="selectionsClick(item)" @dblclick="selectionsDBLClick(item)">
                                <span>{{item.srfmajortext}}</span>
                            </div>
                        </div>
                    </div>
                </div>
                <card v-if="isShowButton" :dis-hover="true" :bordered="false" class="footer">
                    <row :style="{ textAlign: 'right' }">
                        <i-button type="primary"  :disabled="this.viewSelections.length > 0 ? false : true" @click="onClickOk">{{this.containerModel.view_okbtn.text}}</i-button>
                            &nbsp;&nbsp;
                        <i-button @click="onClickCancel">{{this.containerModel.view_cancelbtn.text}}</i-button>
                    </row>
                </card>   
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
import SysPermissionService from '@/service/sys-permission/sys-permission-service';
import SysPermissionAuthService from '@/authservice/sys-permission/sys-permission-auth-service';

import MPickupViewEngine from '@engine/view/mpickup-view-engine';


import SysPermissionUIService from '@/uiservice/sys-permission/sys-permission-ui-service';

@Component({
    components: {
    },
})
export default class SYS_PERMISSIONMPickupViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {SysPermissionService}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public appEntityService: SysPermissionService = new SysPermissionService;

    /**
     * 实体UI服务对象
     *
     * @type SysPermissionUIService
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public appUIService: SysPermissionUIService = new SysPermissionUIService(this.$store);
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

    /**
     * 视图默认使用
     *
     * @type {string}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof SYS_PERMISSIONMPickupViewBase
	 */
	public viewtag: string = '86bd4f6d4f771870e10b9717046a1b14';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof SYS_PERMISSIONMPickupViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof SYS_PERMISSIONMPickupViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public model: any = {
        srfCaption: 'entities.syspermission.views.mpickupview.caption',
        srfTitle: 'entities.syspermission.views.mpickupview.title',
        srfSubTitle: 'entities.syspermission.views.mpickupview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof SYS_PERMISSIONMPickupViewBase
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
            if(this.viewparams.selectedData){
                this.selectedData = JSON.stringify(this.viewparams.selectedData);
                this.viewSelections = this.viewparams.selectedData;
            }

        } 
    }

    /**
     * 处理应用上下文变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof SYS_PERMISSIONMPickupViewBase
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
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public containerModel: any = {
        view_pickupviewpanel: { name: 'pickupviewpanel', type: 'PICKUPVIEWPANEL' },
        view_okbtn: { name: 'okbtn', type: 'button', text: '确定', disabled: true },
        view_cancelbtn: { name: 'cancelbtn', type: 'button', text: '取消', disabled: false },
        view_leftbtn: { name: 'leftbtn', type: 'button', text: '左移', disabled: true },
        view_rightbtn: { name: 'rightbtn', type: 'button', text: '右移', disabled: true },
        view_allleftbtn: { name: 'allleftbtn', type: 'button', text: '全部左移', disabled: true },
        view_allrightbtn: { name: 'allrightbtn', type: 'button', text: '全部右移', disabled: true },
    };

    /**
     *  计数器刷新
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
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
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public viewState: Subject<ViewState> = new Subject();



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public engine: MPickupViewEngine = new MPickupViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            pickupviewpanel: this.$refs.pickupviewpanel,
            keyPSDEField: 'syspermission',
            majorPSDEField: 'permissionname',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof SYS_PERMISSIONMPickupViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 门户部件状态对象
     *
     * @type {*}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    @Prop() public portletState?: any;

   /**
   * 门户部件状态事件
   *
   * @public
   * @type {(Subscription | undefined)}
   * @memberof SYS_PERMISSIONMPickupViewBase
   */
    public portletStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public viewCacheData:any;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 解析视图参数
     *
     * @public
     * @memberof SYS_PERMISSIONMPickupViewBase
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
            Object.assign(this.context,{'syspermission':inputvalue});
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
     * @memberof SYS_PERMISSIONMPickupViewBase
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
     * @memberof SYS_PERMISSIONMPickupViewBase
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
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'sys-permissionmpickup-view',tag:this.viewtag,srfkey:isNew ? null : this.context.syspermission,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'sys-permissionmpickup-view',tag:this.viewtag,srfkey:this.context.syspermission,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'sys-permissionmpickup-view')){
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
                if(!Object.is(res.name,'SYS_PERMISSIONMPickupView')){
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
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public afterMounted(){
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
        if(this.viewparams.selectedData){
            this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', this.viewparams.selectedData);
            this.onCLickRight();
        }

    }


    /**
     * pickupviewpanel 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public pickupviewpanel_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', $event);
    }


    /**
     * pickupviewpanel 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public pickupviewpanel_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'load', $event);
    }


    /**
     * pickupviewpanel 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public pickupviewpanel_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'activated', $event);
    }




    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof SYS_PERMISSIONMPickupViewBase
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
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof SYS_PERMISSIONMPickupViewBase
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
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    @Prop({default: true}) public isShowButton!: boolean;
    
    /**
     * 选中数据的字符串
     *
     * @type {string}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public selectedData: string = "";

    /**
     * 是否初始化已选中项
     *
     * @type {any[]}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public isInitSelected:boolean = false;
    
    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public viewSelections:any[] = [];
    
    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public isSingleSelect: boolean = false;

    /**
     * 选中数据单击
     *
     * @param {*} item
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public selectionsClick(item:any):void {
        item._select = !item._select;
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.containerModel.view_leftbtn.disabled = !removeSelect;
    }

    /**
     * 选中树双击
     *
     * @param {*} item
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public selectionsDBLClick(item:any):void {
        const index: number = this.viewSelections.findIndex((selection: any) => Object.is(selection.srfkey, item.srfkey));
        if (index !== -1) {
            this.viewSelections.splice(index, 1);
        }
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.containerModel.view_leftbtn.disabled = !removeSelect;
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 删除右侧全部选中数据
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public onCLickLeft():void {
        const _selectiions = [...JSON.parse(JSON.stringify(this.viewSelections))];
        _selectiions.forEach((item: any) => {
            if (!item._select) {
                return;
            }
            const index = this.viewSelections.findIndex((selection: any) => Object.is(item.srfkey, selection.srfkey));
            if (index !== -1) {
                this.viewSelections.splice(index, 1);
            }
        });
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.containerModel.view_leftbtn.disabled = !removeSelect;
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 添加左侧选中数据
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public onCLickRight():void {
        Object.values(this.containerModel).forEach((model: any) => {
            if (!Object.is(model.type, 'PICKUPVIEWPANEL')) {
                return;
            }
            let newSelections:any[] = [];
            model.selections.forEach((item: any) => {
                const index: number = this.viewSelections.findIndex((selection: any) => Object.is(item.srfkey, selection.srfkey));
                if (index === -1) {
                    let _item: any = { ...JSON.parse(JSON.stringify(item)) };
                    Object.assign(_item, { _select: false })
                    newSelections.push(_item);
                }else{
                    newSelections.push(this.viewSelections[index]);
                }
            });
            this.viewSelections = this.removeDuplicates([...newSelections,...this.viewSelections]);
        });
    }

    /**
     * 去重
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public removeDuplicates(data:any):Array<any> {
        const uniqueSet = new Set(data);
        return [...uniqueSet];
    }

    /**
     * 选中数据全部删除
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public onCLickAllLeft():void {
        this.viewSelections = [];
        this.containerModel.view_leftbtn.disabled = true;
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', []);
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 添加左侧面板所有数据到右侧
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public onCLickAllRight():void {
        Object.values(this.containerModel).forEach((model: any) => {
            if (!Object.is(model.type, 'PICKUPVIEWPANEL')) {
                return;
            }
            if(model.datas.length>0){
                model.datas.forEach((data:any,index:any)=>{
                    Object.assign(data,{srfmajortext: data.hasOwnProperty('srfmajortext') ? data['srfmajortext'] : data['permissionname']});
                })
            }
            model.datas.forEach((item: any) => {
                const index: number = this.viewSelections.findIndex((selection: any) => Object.is(item.srfkey, selection.srfkey));
                if (index === -1) {
                    let _item: any = { ...JSON.parse(JSON.stringify(item)) };
                    Object.assign(_item, { _select: false })
                    this.viewSelections.push(_item);
                }
            });
        });
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 确定
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public onClickOk(): void {
        this.$emit('viewdataschange', this.viewSelections);
        this.$emit('close', null);
    }

    /**
     * 取消
     *
     * @memberof SYS_PERMISSIONMPickupViewBase
     */
    public onClickCancel(): void {
        this.$emit('viewdataschange', null);
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './sys-permissionmpickup-view.less';
</style>