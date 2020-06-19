<template>
<div class='view-container detreeexpview ibzorganization-tree-exp-view'>
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="ibzorganizationtreeexpview"></app-studioaction>
    <card class='view-card   view-no-toolbar'  :dis-hover="true" :bordered="false">
        <div slot='title' class="header-container">
        <span class='caption-info'>{{$t(model.srfTitle)}}</span>
        </div>

        <div class='content-container'>
            <div class='view-top-messages'>
            </div>
            <view_treeexpbar 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :viewUID="viewUID"
                name="treeexpbar"  
                ref='treeexpbar' 
                @selectionchange="treeexpbar_selectionchange($event)"  
                @activated="treeexpbar_activated($event)"  
                @load="treeexpbar_load($event)"  
                @closeview="closeView($event)">
            </view_treeexpbar>
            <div class='view-bottom-messages'>
            </div>
        </div>
    </card>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import { Subject,Subscription } from 'rxjs';
import IBZOrganizationService from '@/service/ibzorganization/ibzorganization-service';

import TreeExpViewEngine from '@engine/view/tree-exp-view-engine';



@Component({
    components: {
    },
})
export default class IBZOrganizationTreeExpViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {IBZOrganizationService}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public appEntityService: IBZOrganizationService = new IBZOrganizationService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof IBZOrganizationTreeExpViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof IBZOrganizationTreeExpViewBase
	 */
	public viewtag: string = '6435e95f9bd03acceda6b7fd610873db';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof IBZOrganizationTreeExpViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof IBZOrganizationTreeExpViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public model: any = {
        srfCaption: 'entities.ibzorganization.views.treeexpview.caption',
        srfTitle: 'entities.ibzorganization.views.treeexpview.title',
        srfSubTitle: 'entities.ibzorganization.views.treeexpview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IBZOrganizationTreeExpViewBase
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
     * @memberof IBZOrganizationTreeExpViewBase
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
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public containerModel: any = {
        view_treeexpbar: { name: 'treeexpbar', type: 'TREEEXPBAR' },
    };

    /**
     *  计数器刷新
     *
     * @memberof IBZOrganizationTreeExpViewBase
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
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public viewState: Subject<ViewState> = new Subject();


    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public engine: TreeExpViewEngine = new TreeExpViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            treeexpbar: this.$refs.treeexpbar,
            keyPSDEField: 'ibzorganization',
            majorPSDEField: 'orgname',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof IBZOrganizationTreeExpViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public viewparams:any = {};

    /**
     * 解析视图参数
     *
     * @public
     * @memberof IBZOrganizationTreeExpViewBase
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
        this.initNavData();
    }

    /**
     * 处理自定义视图数据
     *
     * @memberof IBZOrganizationTreeExpViewBase
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
     * @memberof IBZOrganizationTreeExpViewBase
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
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public initNavData(data:any = null){
        if(this.viewDefaultUsage){
            this.navDataService.addNavData({id:'ibzorganization-tree-exp-view',srfkey:this.context.ibzorganization,title:this.$t(this.model.srfTitle),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof IBZOrganizationTreeExpViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'ibzorganization-tree-exp-view')){
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
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public afterMounted(){
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
        
    }


    /**
     * treeexpbar 部件 selectionchange 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public treeexpbar_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('treeexpbar', 'selectionchange', $event);
    }


    /**
     * treeexpbar 部件 activated 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public treeexpbar_activated($event: any, $event2?: any) {
        this.engine.onCtrlEvent('treeexpbar', 'activated', $event);
    }


    /**
     * treeexpbar 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public treeexpbar_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('treeexpbar', 'load', $event);
    }



    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof IBZOrganizationTreeExpView
     */
    public newdata(args: any[],fullargs?:any[], params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
    this.$Notice.warning({ title: '错误', desc: '未指定关系视图' });
    }


    /**
     * 打开编辑数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof IBZOrganizationTreeExpView
     */
    public opendata(args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
    this.$Notice.warning({ title: '错误', desc: '未指定关系视图' });
    }



    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof IBZOrganizationTreeExpViewBase
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
     * @memberof IBZOrganizationTreeExpViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof IBZOrganizationTreeExpViewBase
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
     * 视图唯一标识
     *
     * @type {string}
     * @memberof IBZOrganizationTreeExpView
     */
    public viewUID: string = 'ou-ibzorganization-tree-exp-view';
    
}
</script>

<style lang='less'>
@import './ibzorganization-tree-exp-view.less';
</style>