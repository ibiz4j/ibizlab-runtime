<template>
<div class="view-container depickupview ibzorganization-pickup-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ibzorganizationpickupview"></app-studioaction>
    <card class='view-card view-no-caption  view-no-toolbar' :dis-hover="true" :padding="0" :bordered="false">
        <div class="content-container pickup-view">
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
                @activated="pickupviewpanel_activated($event)"  
                @load="pickupviewpanel_load($event)"  
                @closeview="closeView($event)">
            </view_pickupviewpanel>
            <card v-if="isShowButton" :dis-hover="true" :bordered="false" class="footer">
                <row :style="{ textAlign: 'right' }">
                    <i-button type="primary" :disabled="this.viewSelections.length > 0 ? false : true" @click="onClickOk">{{this.containerModel.view_okbtn.text}}</i-button>
                        &nbsp;&nbsp;
                    <i-button @click="onClickCancel">{{this.containerModel.view_cancelbtn.text}}</i-button>
                </row>
            </card>
        </div>
    </card>
</div>
</template>


<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch,Inject } from 'vue-property-decorator';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import { Subject,Subscription } from 'rxjs';
import IBZOrganizationService from '@/service/ibzorganization/ibzorganization-service';
import IBZOrganizationAuthService from '@/authservice/ibzorganization/ibzorganization-auth-service';

import PickupViewEngine from '@engine/view/pickup-view-engine';


import IBZOrganizationUIService from '@/uiservice/ibzorganization/ibzorganization-ui-service';

@Component({
    components: {
    },
})
export default class IBZOrganizationPickupViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {IBZOrganizationService}
     * @memberof IBZOrganizationPickupViewBase
     */
    public appEntityService: IBZOrganizationService = new IBZOrganizationService;

    /**
     * 实体权限服务对象
     *
     * @type IBZOrganizationUIService
     * @memberof IBZOrganizationPickupViewBase
     */
    public appUIService: IBZOrganizationUIService = new IBZOrganizationUIService(this.$store);


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof IBZOrganizationPickupViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof IBZOrganizationPickupViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof IBZOrganizationPickupViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof IBZOrganizationPickupViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof IBZOrganizationPickupViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

    /**
     * 视图默认使用
     *
     * @type {string}
     * @memberof IBZOrganizationPickupViewBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof IBZOrganizationPickupViewBase
	 */
	public viewtag: string = 'ccff36439eacae953f85ff636c9dac74';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof IBZOrganizationPickupViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof IBZOrganizationPickupViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof IBZOrganizationPickupViewBase
     */
    public model: any = {
        srfCaption: 'entities.ibzorganization.views.pickupview.caption',
        srfTitle: 'entities.ibzorganization.views.pickupview.title',
        srfSubTitle: 'entities.ibzorganization.views.pickupview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IBZOrganizationPickupViewBase
     */
    @Watch('viewparam',{immediate: true, deep: true})
    onParamData(newVal: any, oldVal: any) {
        if(newVal){
            for(let key in this.viewparams){
                delete this.viewparams[key];
            }
            Object.assign(this.viewparams, JSON.parse(this.viewparam));
            if(this.viewparams.selectedData){
                this.selectedData = JSON.stringify(this.viewparams.selectedData);
            }

        } 
    }

    /**
     * 处理应用上下文变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IBZOrganizationPickupViewBase
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
     * @memberof IBZOrganizationPickupViewBase
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
     * @memberof IBZOrganizationPickupViewBase
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
     * @memberof IBZOrganizationPickupViewBase
     */
    public viewState: Subject<ViewState> = new Subject();



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof IBZOrganizationPickupViewBase
     */
    public engine: PickupViewEngine = new PickupViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof IBZOrganizationPickupViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            pickupviewpanel: this.$refs.pickupviewpanel,
            keyPSDEField: 'ibzorganization',
            majorPSDEField: 'orgname',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof IBZOrganizationPickupViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof IBZOrganizationPickupViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof IBZOrganizationPickupViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof IBZOrganizationPickupViewBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof IBZOrganizationPickupViewBase
     */
    public viewCacheData:any;

    /**
     * 解析视图参数
     *
     * @public
     * @memberof IBZOrganizationPickupViewBase
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
        if(inputvalue){
            Object.assign(this.context,{'ibzorganization':inputvalue});
        }
        if(this.$store.getters.getAppData() && this.$store.getters.getAppData().context){
            Object.assign(this.context,this.$store.getters.getAppData().context);
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
     * @memberof IBZOrganizationPickupViewBase
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
     * @memberof IBZOrganizationPickupViewBase
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
     * @memberof IBZOrganizationPickupViewBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'ibzorganization-pickup-view',tag:this.viewtag,srfkey:isNew ? null : this.context.ibzorganization,title:this.$t(this.model.srfTitle),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof IBZOrganizationPickupViewBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'ibzorganization-pickup-view',tag:this.viewtag,srfkey:this.context.ibzorganization,title:this.$t(this.model.srfTitle),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof IBZOrganizationPickupViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof IBZOrganizationPickupViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'ibzorganization-pickup-view')){
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
     * @memberof IBZOrganizationPickupViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof IBZOrganizationPickupViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof IBZOrganizationPickupViewBase
     */
    public afterMounted(){
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
        if(this.viewparams.selectedData){
            this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', this.viewparams.selectedData);
        }

    }


    /**
     * pickupviewpanel 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationPickupViewBase
     */
    public pickupviewpanel_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'selectionchange', $event);
    }


    /**
     * pickupviewpanel 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationPickupViewBase
     */
    public pickupviewpanel_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'activated', $event);
    }


    /**
     * pickupviewpanel 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationPickupViewBase
     */
    public pickupviewpanel_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('pickupviewpanel', 'load', $event);
    }




    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof IBZOrganizationPickupViewBase
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
     * 销毁视图回调
     *
     * @memberof IBZOrganizationPickupViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof IBZOrganizationPickupViewBase
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
    }
    /**
     * 选中数据的字符串
     *
     * @type {string}
     * @memberof IBZOrganizationPickupViewBase
     */
    public selectedData: string = "";

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof IBZOrganizationPickupViewBase
     */
    public viewSelections:any[] = [];

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof IBZOrganizationPickupViewBase
     */
    @Prop({default: true}) public isShowButton!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof IBZOrganizationPickupViewBase
     */
    public isSingleSelect: boolean = true;

    /**
     * 确定
     *
     * @memberof IBZOrganizationPickupViewBase
     */
    public onClickOk(): void {
        this.$emit('viewdataschange', this.viewSelections);
        this.$emit('close', null);
    }

    /**
     * 取消
     *
     * @memberof IBZOrganizationPickupViewBase
     */
    public onClickCancel(): void {
        this.$emit('viewdataschange', null);
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './ibzorganization-pickup-view.less';
</style>