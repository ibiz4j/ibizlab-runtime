<template>
<div class="view-container deeditview sys-role-edit-view">
    <app-studioaction :viewTitle="$t(model.srfCaption)" viewName="sysroleeditview"></app-studioaction>
    <card class='view-card ' :disHover="true" :bordered="false">

<div slot='title' class="header-container">
    <span class='caption-info'>{{$t(model.srfCaption)}}</span>
    <div class='toolbar-container'>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem3.visabled" :disabled="toolBarModels.tbitem3.disabled" class='' v-loading:i-button @click="toolbar_click({ tag: 'tbitem3' }, $event)">
                    <i class='fa fa-save'></i>
                    <span class='caption'>{{$t('entities.sysrole.editviewtoolbar_toolbar.tbitem3.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.sysrole.editviewtoolbar_toolbar.tbitem3.tip')}}</div>
        </tooltip>
        <span class='seperator'>|</span>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.deuiaction1.visabled" :disabled="toolBarModels.deuiaction1.disabled" class='' v-loading:i-button @click="toolbar_click({ tag: 'deuiaction1' }, $event)">
                    <i class='fa fa-sign-out'></i>
                    <span class='caption'>{{$t('entities.sysrole.editviewtoolbar_toolbar.deuiaction1.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.sysrole.editviewtoolbar_toolbar.deuiaction1.tip')}}</div>
        </tooltip>
        <span class='seperator'>|</span>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem14.visabled" :disabled="toolBarModels.tbitem14.disabled" class='' v-loading:i-button @click="toolbar_click({ tag: 'tbitem14' }, $event)">
                    <i class='fa fa-copy'></i>
                    <span class='caption'>{{$t('entities.sysrole.editviewtoolbar_toolbar.tbitem14.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.sysrole.editviewtoolbar_toolbar.tbitem14.tip')}}</div>
        </tooltip>
    </div>
</div>

        <div class='view-top-messages'>
        </div>
        <div class="content-container">
        <div class='view-body-messages'>
        </div>
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
            @load="form_load($event)"  
            @save="form_save($event)"  
            @remove="form_remove($event)"  
            @closeview="closeView($event)">
        </view_form>
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
import SysRoleService from '@/service/sys-role/sys-role-service';
import SysRoleAuthService from '@/authservice/sys-role/sys-role-auth-service';

import EditViewEngine from '@engine/view/edit-view-engine';


import SysRoleUIService from '@/uiservice/sys-role/sys-role-ui-service';

@Component({
    components: {
    },
})
export default class SysRoleEditViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {SysRoleService}
     * @memberof SysRoleEditViewBase
     */
    public appEntityService: SysRoleService = new SysRoleService;

    /**
     * 实体UI服务对象
     *
     * @type SysRoleUIService
     * @memberof SysRoleEditViewBase
     */
    public appUIService: SysRoleUIService = new SysRoleUIService(this.$store);
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof SysRoleEditViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof SysRoleEditViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof SysRoleEditViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof SysRoleEditViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

    /**
     * 视图默认使用
     *
     * @type {string}
     * @memberof SysRoleEditViewBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof SysRoleEditViewBase
	 */
	public viewtag: string = '6bd0981f6dd67a59f211b5cf97ac8f30';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof SysRoleEditViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof SysRoleEditViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof SysRoleEditViewBase
     */
    public model: any = {
        srfCaption: 'entities.sysrole.views.editview.caption',
        srfTitle: 'entities.sysrole.views.editview.title',
        srfSubTitle: 'entities.sysrole.views.editview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof SysRoleEditViewBase
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
     * @memberof SysRoleEditViewBase
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
     * @memberof SysRoleEditViewBase
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_form: { name: 'form', type: 'FORM' },
    };

    /**
     * 视图刷新
     *
     * @param {*} args
     * @memberof SysRoleEditViewBase
     */
    public refresh(args?: any): void {
        const refs: any = this.$refs;
        if (refs && refs.form) {
            refs.form.refresh();
        }
    }
    /**
     *  计数器刷新
     *
     * @memberof SysRoleEditViewBase
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
     * @memberof SysRoleEditViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof SysRoleEditView
     */
    public toolBarModels: any = {
        tbitem3: { name: 'tbitem3', actiontarget: 'NONE', caption: '保存', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'Save', target: '' } },

        tbitem6: {  name: 'tbitem6', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        deuiaction1: { name: 'deuiaction1', actiontarget: 'NONE', caption: '关闭', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'Exit', target: '' } },

        tbitem13: {  name: 'tbitem13', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem14: { name: 'tbitem14', actiontarget: 'NONE', caption: '拷贝', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'Copy', target: 'SINGLEKEY' } },

    };




    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof SysRoleEditViewBase
     */
    public engine: EditViewEngine = new EditViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof SysRoleEditViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'sysrole',
            majorPSDEField: 'rolename',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof SysRoleEditViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof SysRoleEditViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 门户部件状态对象
     *
     * @type {*}
     * @memberof SysRoleEditViewBase
     */
    @Prop() public portletState?: any;

   /**
   * 门户部件状态事件
   *
   * @public
   * @type {(Subscription | undefined)}
   * @memberof SysRoleEditViewBase
   */
    public portletStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof SysRoleEditViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof SysRoleEditViewBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof SysRoleEditViewBase
     */
    public viewCacheData:any;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof SysRoleEditViewBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 解析视图参数
     *
     * @public
     * @memberof SysRoleEditViewBase
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
            Object.assign(this.context,{'sysrole':inputvalue});
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
     * @memberof SysRoleEditViewBase
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
     * @memberof SysRoleEditViewBase
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
     * @memberof SysRoleEditViewBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'sys-role-edit-view',tag:this.viewtag,srfkey:isNew ? null : this.context.sysrole,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof SysRoleEditViewBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'sys-role-edit-view',tag:this.viewtag,srfkey:this.context.sysrole,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof SysRoleEditViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof SysRoleEditViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'sys-role-edit-view')){
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
                if(!Object.is(res.name,'SysRoleEditView')){
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
     * @memberof SysRoleEditViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof SysRoleEditViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof SysRoleEditViewBase
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
     * @memberof SysRoleEditViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem3')) {
            this.toolbar_tbitem3_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'deuiaction1')) {
            this.toolbar_deuiaction1_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem14')) {
            this.toolbar_tbitem14_click(null, '', $event2);
        }
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysRoleEditViewBase
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysRoleEditViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof SysRoleEditViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }



    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem3_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.form;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.Save(datas, contextJO,paramJO,  $event, xData,this,"SysRole");
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
        xData = this.$refs.form;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.Exit(datas, contextJO,paramJO,  $event, xData,this,"SysRole");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem14_click(params: any = {}, tag?: any, $event?: any) {
        // 参数
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        let contextJO:any = {};
        xData = this.$refs.form;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.Copy(datas, contextJO,paramJO,  $event, xData,this,"SysRole");
    }

    /**
     * 保存
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof SysRoleEditViewBase
     */
    public Save(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        // 界面行为容器对象 _this
        const _this: any = this;
        if (xData && xData.save instanceof Function) {
            xData.save().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                _this.$emit('viewdataschange', [{ ...response.data }]);
            });
        } else if (_this.save && _this.save instanceof Function) {
            _this.save();
        }
    }

    /**
     * 关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof SysRoleEditViewBase
     */
    public Exit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        this.closeView(args);
        if(window.parent){
            window.parent.postMessage([{ ...args }],'*');
        }
    }

    /**
     * 拷贝
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof SysRoleEditViewBase
     */
    public Copy(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        if (args.length === 0) {
            return;
        }
        const _this: any = this;
        if (_this.opendata && _this.opendata instanceof Function) {
            const data: any = { };
            if (args.length > 0) {
                Object.assign(data, { sysrole: args[0].sysrole });
            }
            if(!params) params = {};
            Object.assign(args,{copymode:true});
            _this.opendata([{ ...data }], args, params, $event, xData);
        } else {
            Object.assign(this.viewparams,{copymode:true});
        }
    }

    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof SysRoleEditViewBase
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
     * @memberof SysRoleEditViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof SysRoleEditViewBase
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


}
</script>

<style lang='less'>
@import './sys-role-edit-view.less';
</style>