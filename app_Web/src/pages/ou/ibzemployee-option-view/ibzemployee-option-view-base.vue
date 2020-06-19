<template>
<div class="view-container deoptview ibzemployee-option-view">
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ibzemployeeoptionview"></app-studioaction>
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
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import { Subject,Subscription } from 'rxjs';
import IBZEmployeeService from '@/service/ibzemployee/ibzemployee-service';

import OptionViewEngine from '@engine/view/option-view-engine';



@Component({
    components: {
    },
})
export default class IBZEmployeeOptionViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {IBZEmployeeService}
     * @memberof IBZEmployeeOptionViewBase
     */
    public appEntityService: IBZEmployeeService = new IBZEmployeeService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof IBZEmployeeOptionViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof IBZEmployeeOptionViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof IBZEmployeeOptionViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof IBZEmployeeOptionViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof IBZEmployeeOptionViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof IBZEmployeeOptionViewBase
	 */
	public viewtag: string = '9cf7a70099bff83a10f6ae65c4d54692';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof IBZEmployeeOptionViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof IBZEmployeeOptionViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof IBZEmployeeOptionViewBase
     */
    public model: any = {
        srfCaption: 'entities.ibzemployee.views.optionview.caption',
        srfTitle: 'entities.ibzemployee.views.optionview.title',
        srfSubTitle: 'entities.ibzemployee.views.optionview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IBZEmployeeOptionViewBase
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
     * @memberof IBZEmployeeOptionViewBase
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
     * @memberof IBZEmployeeOptionViewBase
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
     * @memberof IBZEmployeeOptionViewBase
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
     * @memberof IBZEmployeeOptionViewBase
     */
    public viewState: Subject<ViewState> = new Subject();



    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof IBZEmployeeOptionViewBase
     */
    public engine: OptionViewEngine = new OptionViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof IBZEmployeeOptionViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'ibzemployee',
            majorPSDEField: 'personname',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof IBZEmployeeOptionViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof IBZEmployeeOptionViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof IBZEmployeeOptionViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof IBZEmployeeOptionViewBase
     */
    public viewparams:any = {};

    /**
     * 解析视图参数
     *
     * @public
     * @memberof IBZEmployeeOptionViewBase
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
            Object.assign(this.context,{'ibzemployee':inputvalue});
        }
        if(this.$store.getters.getAppData() && this.$store.getters.getAppData().context){
            Object.assign(this.context,this.$store.getters.getAppData().context);
        }
        //初始化视图唯一标识
        Object.assign(this.context,{srfsessionid:this.$util.createUUID()});
        this.handleCustomViewData();
        //初始化导航数据
        this.initNavData();
    }

    /**
     * 处理自定义视图数据
     *
     * @memberof IBZEmployeeOptionViewBase
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
     * @memberof IBZEmployeeOptionViewBase
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
     * 初始化导航数据
     *
     * @memberof IBZEmployeeOptionViewBase
     */
    public initNavData(data:any = null){
        if(this.viewDefaultUsage){
            this.navDataService.addNavData({id:'ibzemployee-option-view',srfkey:this.context.ibzemployee,title:this.$t(this.model.srfTitle),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof IBZEmployeeOptionViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof IBZEmployeeOptionViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'ibzemployee-option-view')){
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
     * @memberof IBZEmployeeOptionViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof IBZEmployeeOptionViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof IBZEmployeeOptionViewBase
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
     * @memberof IBZEmployeeOptionViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZEmployeeOptionViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZEmployeeOptionViewBase
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
    }




    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof IBZEmployeeOptionViewBase
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
     * @memberof IBZEmployeeOptionViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof IBZEmployeeOptionViewBase
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
            if (this.serviceStateEvent) {
                this.serviceStateEvent.unsubscribe();
            }
        }
    }

    /**
     * 确定
     *
     * @memberof IBZEmployeeOptionViewBase
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
     * @memberof IBZEmployeeOptionViewBase
     */
    public onClickCancel(): void {
        this.$emit('close', null);
    }

}
</script>

<style lang='less'>
@import './ibzemployee-option-view.less';
</style>