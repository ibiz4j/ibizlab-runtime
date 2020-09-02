<template>
<div class="view-container deoptview ibzorganization-option-view">
    <app-studioaction :viewTitle="$t(model.srfCaption)" viewName="ibzorganizationoptionview"></app-studioaction>
    <card class='view-card  view-no-caption  view-no-toolbar' dis-hover :padding="0" :bordered="false">
        <div class="content-container">
            <view_form 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :autosave="false" 
                :viewtag="viewtag"
                :showBusyIndicator="true"
                updateAction="Update"
                removeAction="Remove"
                loaddraftAction="GetDraft"
                loadAction="Get"
                createAction="Create"
                WFSubmitAction=""
                WFStartAction=""
                style='' 
                name="form"  
                ref='form' 
                @save="form_save($event)"  
                @remove="form_remove($event)"  
                @load="form_load($event)"  
                @closeview="closeView($event)">
            </view_form>
        </div>
        <card dis-hover :bordered="false" class='footer'>
          <row style=" text-align: right ">
            <i-button type='primary' @click="onClickOk">{{ containerModel.view_okbtn.text }}</i-button>
              &nbsp;&nbsp;
            <i-button @click="onClickCancel">{{ containerModel.view_cancelbtn.text }}</i-button>
          </row>
        </card>
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

import OptionViewEngine from '@engine/view/option-view-engine';


import IBZOrganizationUIService from '@/uiservice/ibzorganization/ibzorganization-ui-service';

@Component({
    components: {
    },
})
export default class IBZOrganizationOptionViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {IBZOrganizationService}
     * @memberof IBZOrganizationOptionViewBase
     */
    public appEntityService: IBZOrganizationService = new IBZOrganizationService;

    /**
     * 实体UI服务对象
     *
     * @type IBZOrganizationUIService
     * @memberof IBZOrganizationOptionViewBase
     */
    public appUIService: IBZOrganizationUIService = new IBZOrganizationUIService(this.$store);
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof IBZOrganizationOptionViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof IBZOrganizationOptionViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof IBZOrganizationOptionViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof IBZOrganizationOptionViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

    /**
     * 视图默认使用
     *
     * @type {string}
     * @memberof IBZOrganizationOptionViewBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof IBZOrganizationOptionViewBase
	 */
	public viewtag: string = '2ed85bebb69b8d23388420b95163228a';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof IBZOrganizationOptionViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof IBZOrganizationOptionViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof IBZOrganizationOptionViewBase
     */
    public model: any = {
        srfCaption: 'entities.ibzorganization.views.optionview.caption',
        srfTitle: 'entities.ibzorganization.views.optionview.title',
        srfSubTitle: 'entities.ibzorganization.views.optionview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IBZOrganizationOptionViewBase
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
     * @memberof IBZOrganizationOptionViewBase
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
     * @memberof IBZOrganizationOptionViewBase
     */
    public containerModel: any = {
        view_form: { name: 'form', type: 'FORM' },
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
     * @memberof IBZOrganizationOptionViewBase
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
     * @memberof IBZOrganizationOptionViewBase
     */
    public viewState: Subject<ViewState> = new Subject();



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof IBZOrganizationOptionViewBase
     */
    public engine: OptionViewEngine = new OptionViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof IBZOrganizationOptionViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'ibzorganization',
            majorPSDEField: 'orgname',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof IBZOrganizationOptionViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof IBZOrganizationOptionViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof IBZOrganizationOptionViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof IBZOrganizationOptionViewBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof IBZOrganizationOptionViewBase
     */
    public viewCacheData:any;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof IBZOrganizationOptionViewBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 解析视图参数
     *
     * @public
     * @memberof IBZOrganizationOptionViewBase
     */
    public parseViewParam(inputvalue:any = null): void {
        for(let key in this.context){
            delete this.context[key];
        }
        if(this.$store.getters.getAppData() && this.$store.getters.getAppData().context){
            Object.assign(this.context,this.$store.getters.getAppData().context);
        }
        if (!this.viewDefaultUsage && this.viewdata && !Object.is(this.viewdata, '')) {
            Object.assign(this.context, JSON.parse(this.viewdata));
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
            Object.assign(this.context,{'ibzorganization':inputvalue});
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
     * @memberof IBZOrganizationOptionViewBase
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
     * @memberof IBZOrganizationOptionViewBase
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
     * @memberof IBZOrganizationOptionViewBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'ibzorganization-option-view',tag:this.viewtag,srfkey:isNew ? null : this.context.ibzorganization,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof IBZOrganizationOptionViewBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'ibzorganization-option-view',tag:this.viewtag,srfkey:this.context.ibzorganization,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof IBZOrganizationOptionViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof IBZOrganizationOptionViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'ibzorganization-option-view')){
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
     * @memberof IBZOrganizationOptionViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof IBZOrganizationOptionViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof IBZOrganizationOptionViewBase
     */
    public afterMounted(){
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
        
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationOptionViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationOptionViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationOptionViewBase
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
    }




    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof IBZOrganizationOptionViewBase
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
     * @memberof IBZOrganizationOptionViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof IBZOrganizationOptionViewBase
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
     * 确定
     *
     * @memberof IBZOrganizationOptionViewBase
     */
    public onClickOk(): void {
        const form: any = this.$refs.form;
        if (!form) return;
        form.save().then((res:any) =>{
            if(res.status == 200){
                this.$emit('close',[res.data]);
            }
        });
    }

    /**
     * 取消
     *
     * @memberof IBZOrganizationOptionViewBase
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './ibzorganization-option-view.less';
</style>