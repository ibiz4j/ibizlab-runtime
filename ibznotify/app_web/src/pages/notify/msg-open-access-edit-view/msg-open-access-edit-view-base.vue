<template>
<div class="view-container deeditview msg-open-access-edit-view">
    <app-studioaction :viewTitle="$t(model.srfCaption)" viewName="msgopenaccesseditview"></app-studioaction>
    <card class='view-card ' :disHover="true" :bordered="false">

<div slot='title' class="header-container">
    <span class='caption-info'>{{$t(model.srfCaption)}}</span>
    <div class='toolbar-container'>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem3.visabled" :disabled="toolBarModels.tbitem3.disabled" class='' @click="toolbar_click({ tag: 'tbitem3' }, $event)">
                    <i class='fa fa-save'></i>
                    <span class='caption'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem3.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem3.tip')}}</div>
        </tooltip>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem4.visabled" :disabled="toolBarModels.tbitem4.disabled" class='' @click="toolbar_click({ tag: 'tbitem4' }, $event)">
                    <i class='sx-tb-saveandnew'></i>
                    <span class='caption'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem4.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem4.tip')}}</div>
        </tooltip>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem5.visabled" :disabled="toolBarModels.tbitem5.disabled" class='' @click="toolbar_click({ tag: 'tbitem5' }, $event)">
                    <i class='sx-tb-saveandclose'></i>
                    <span class='caption'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem5.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem5.tip')}}</div>
        </tooltip>
        <span class='seperator'>|</span>    <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem7.visabled" :disabled="toolBarModels.tbitem7.disabled" class='' @click="toolbar_click({ tag: 'tbitem7' }, $event)">
                    <i class='fa fa-remove'></i>
                    <span class='caption'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem7.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem7.tip')}}</div>
        </tooltip>
        <span class='seperator'>|</span>    <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem12.visabled" :disabled="toolBarModels.tbitem12.disabled" class='' @click="toolbar_click({ tag: 'tbitem12' }, $event)">
                    <i class='fa fa-file-text-o'></i>
                    <span class='caption'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem12.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem12.tip')}}</div>
        </tooltip>
        <span class='seperator'>|</span>    <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem14.visabled" :disabled="toolBarModels.tbitem14.disabled" class='' @click="toolbar_click({ tag: 'tbitem14' }, $event)">
                    <i class='fa fa-copy'></i>
                    <span class='caption'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem14.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem14.tip')}}</div>
        </tooltip>
        <span class='seperator'>|</span>    <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem23.visabled" :disabled="toolBarModels.tbitem23.disabled" class='' @click="toolbar_click({ tag: 'tbitem23' }, $event)">
                    <i class='fa fa-fast-backward'></i>
                    
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem23.tip')}}</div>
        </tooltip>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem24.visabled" :disabled="toolBarModels.tbitem24.disabled" class='' @click="toolbar_click({ tag: 'tbitem24' }, $event)">
                    <i class='fa fa-step-backward'></i>
                    
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem24.tip')}}</div>
        </tooltip>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem25.visabled" :disabled="toolBarModels.tbitem25.disabled" class='' @click="toolbar_click({ tag: 'tbitem25' }, $event)">
                    <i class='fa fa-step-forward'></i>
                    
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem25.tip')}}</div>
        </tooltip>
        <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem26.visabled" :disabled="toolBarModels.tbitem26.disabled" class='' @click="toolbar_click({ tag: 'tbitem26' }, $event)">
                    <i class='fa fa-fast-forward'></i>
                    
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem26.tip')}}</div>
        </tooltip>
        <span class='seperator'>|</span>    <tooltip :transfer="true" :max-width="600">
                <i-button v-show="toolBarModels.tbitem22.visabled" :disabled="toolBarModels.tbitem22.disabled" class='' @click="toolbar_click({ tag: 'tbitem22' }, $event)">
                    <i class='fa fa-question'></i>
                    <span class='caption'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem22.caption')}}</span>
                </i-button>
            <div slot='content'>{{$t('entities.msgopenaccess.editviewtoolbar_toolbar.tbitem22.tip')}}</div>
        </tooltip>
    </div>
</div>

        <div class="content-container">
        <div class='view-top-messages'>
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
            @save="form_save($event)"  
            @remove="form_remove($event)"  
            @load="form_load($event)"  
            @closeview="closeView($event)">
        </view_form>
        <div class='view-bottom-messages'>
        </div>
        </div>
    </card>
</div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch,Inject } from 'vue-property-decorator';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import { Subject,Subscription } from 'rxjs';
import MsgOpenAccessService from '@/service/msg-open-access/msg-open-access-service';
import MsgOpenAccessAuthService from '@/authservice/msg-open-access/msg-open-access-auth-service';

import EditViewEngine from '@engine/view/edit-view-engine';


import MsgOpenAccessUIService from '@/uiservice/msg-open-access/msg-open-access-ui-service';

@Component({
    components: {
    },
})
export default class MsgOpenAccessEditViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {MsgOpenAccessService}
     * @memberof MsgOpenAccessEditViewBase
     */
    public appEntityService: MsgOpenAccessService = new MsgOpenAccessService;

    /**
     * 实体UI服务对象
     *
     * @type MsgOpenAccessUIService
     * @memberof MsgOpenAccessEditViewBase
     */
    public appUIService: MsgOpenAccessUIService = new MsgOpenAccessUIService(this.$store);
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof MsgOpenAccessEditViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof MsgOpenAccessEditViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof MsgOpenAccessEditViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof MsgOpenAccessEditViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

    /**
     * 视图默认使用
     *
     * @type {string}
     * @memberof MsgOpenAccessEditViewBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof MsgOpenAccessEditViewBase
	 */
	public viewtag: string = '6a6e3d13c769ee31fe6ec9cc5508324f';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof MsgOpenAccessEditViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof MsgOpenAccessEditViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof MsgOpenAccessEditViewBase
     */
    public model: any = {
        srfCaption: 'entities.msgopenaccess.views.editview.caption',
        srfTitle: 'entities.msgopenaccess.views.editview.title',
        srfSubTitle: 'entities.msgopenaccess.views.editview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MsgOpenAccessEditViewBase
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
     * @memberof MsgOpenAccessEditViewBase
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
     * @memberof MsgOpenAccessEditViewBase
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_form: { name: 'form', type: 'FORM' },
    };

    /**
     *  计数器刷新
     *
     * @memberof MsgOpenAccessEditViewBase
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
     * @memberof MsgOpenAccessEditViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof MsgOpenAccessEditView
     */
    public toolBarModels: any = {
        tbitem3: { name: 'tbitem3', caption: '保存', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'Save', target: '' } },

        tbitem4: { name: 'tbitem4', caption: '保存并新建', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'SaveAndNew', target: '' } },

        tbitem5: { name: 'tbitem5', caption: '保存并关闭', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'SaveAndExit', target: '' } },

        tbitem6: {  name: 'tbitem6', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem7: { name: 'tbitem7', caption: '删除并关闭', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'RemoveAndExit', target: 'SINGLEKEY' } },

        tbitem8: {  name: 'tbitem8', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem12: { name: 'tbitem12', caption: '新建', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'New', target: '' } },

        tbitem13: {  name: 'tbitem13', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem14: { name: 'tbitem14', caption: '拷贝', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'Copy', target: 'SINGLEKEY' } },

        tbitem16: {  name: 'tbitem16', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem23: { name: 'tbitem23', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'FirstRecord', target: 'SINGLEKEY' } },

        tbitem24: { name: 'tbitem24', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'PrevRecord', target: 'SINGLEKEY' } },

        tbitem25: { name: 'tbitem25', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'NextRecord', target: 'SINGLEKEY' } },

        tbitem26: { name: 'tbitem26', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'LastRecord', target: 'SINGLEKEY' } },

        tbitem21: {  name: 'tbitem21', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem22: { name: 'tbitem22', caption: '帮助', disabled: false, type: 'DEUIACTION', visabled: true,noprivdisplaymode:2,dataaccaction: '', uiaction: { tag: 'Help', target: '' } },

    };




    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof MsgOpenAccessEditViewBase
     */
    public engine: EditViewEngine = new EditViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MsgOpenAccessEditViewBase
     */
    public engineInit(): void {
        this.engine.init({
            view: this,
            form: this.$refs.form,
            p2k: '0',
            keyPSDEField: 'msgopenaccess',
            majorPSDEField: 'name',
            isLoadDefault: true,
        });
    }

    /**
     * 应用导航服务
     *
     * @type {*}
     * @memberof MsgOpenAccessEditViewBase
     */
    public  navDataService = NavDataService.getInstance(this.$store);

    /**
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof MsgOpenAccessEditViewBase
    */
    public serviceStateEvent: Subscription | undefined;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof MsgOpenAccessEditViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof MsgOpenAccessEditViewBase
     */
    public viewparams:any = {};

    /**
     * 视图缓存数据
     *
     * @type {*}
     * @memberof MsgOpenAccessEditViewBase
     */
    public viewCacheData:any;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof MsgOpenAccessEditViewBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 解析视图参数
     *
     * @public
     * @memberof MsgOpenAccessEditViewBase
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
            Object.assign(this.context,{'msgopenaccess':inputvalue});
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
     * @memberof MsgOpenAccessEditViewBase
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
     * @memberof MsgOpenAccessEditViewBase
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
     * @memberof MsgOpenAccessEditViewBase
     */
    public initNavDataWithRoute(data:any = null, isNew:boolean = false,  isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && Object.is(this.navModel,"route")) ){
            this.navDataService.addNavData({id:'msg-open-access-edit-view',tag:this.viewtag,srfkey:isNew ? null : this.context.msgopenaccess,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath});
        }
    }

    /**
     * 初始化导航数据(分页模式)
     *
     * @memberof MsgOpenAccessEditViewBase
     */
    public initNavDataWithTab(data:any = null,isOnlyAdd:boolean = true, isAlways:boolean = false){
        if( isAlways || (this.viewDefaultUsage && !Object.is(this.navModel,"route")) ){
            this.navDataService.addNavDataByOnly({id:'msg-open-access-edit-view',tag:this.viewtag,srfkey:this.context.msgopenaccess,title:this.$t(this.model.srfCaption),data:data,context:this.context,viewparams:this.viewparams,path:this.$route.fullPath},isOnlyAdd);
        }
    }
	

    /**
     * Vue声明周期
     *
     * @memberof MsgOpenAccessEditViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof MsgOpenAccessEditViewBase
     */    
    public afterCreated(){
        let _this:any = this;
        const secondtag = _this.$util.createUUID();
        _this.$store.commit('viewaction/createdView', { viewtag: _this.viewtag, secondtag: secondtag });
        _this.viewtag = secondtag;
        _this.parseViewParam();
        _this.serviceStateEvent = _this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
            if(!Object.is(name,'msg-open-access-edit-view')){
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
     * @memberof MsgOpenAccessEditViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof MsgOpenAccessEditViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof MsgOpenAccessEditViewBase
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
     * @memberof MsgOpenAccessEditViewBase
     */
    public toolbar_click($event: any, $event2?: any) {
        if (Object.is($event.tag, 'tbitem3')) {
            this.toolbar_tbitem3_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem4')) {
            this.toolbar_tbitem4_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem5')) {
            this.toolbar_tbitem5_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem7')) {
            this.toolbar_tbitem7_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem9')) {
            this.toolbar_tbitem9_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem10')) {
            this.toolbar_tbitem10_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem12')) {
            this.toolbar_tbitem12_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem14')) {
            this.toolbar_tbitem14_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem15')) {
            this.toolbar_tbitem15_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem23')) {
            this.toolbar_tbitem23_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem24')) {
            this.toolbar_tbitem24_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem25')) {
            this.toolbar_tbitem25_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem26')) {
            this.toolbar_tbitem26_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem22')) {
            this.toolbar_tbitem22_click(null, '', $event2);
        }
    }


    /**
     * form 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof MsgOpenAccessEditViewBase
     */
    public form_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'save', $event);
    }


    /**
     * form 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof MsgOpenAccessEditViewBase
     */
    public form_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'remove', $event);
    }


    /**
     * form 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof MsgOpenAccessEditViewBase
     */
    public form_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('form', 'load', $event);
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
        this.Save(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem4_click(params: any = {}, tag?: any, $event?: any) {
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
        this.SaveAndNew(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem5_click(params: any = {}, tag?: any, $event?: any) {
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
        this.SaveAndExit(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem7_click(params: any = {}, tag?: any, $event?: any) {
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
        this.RemoveAndExit(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem9_click(params: any = {}, tag?: any, $event?: any) {
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
        this.SaveAndStart(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem10_click(params: any = {}, tag?: any, $event?: any) {
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
        this.ViewWFStep(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem12_click(params: any = {}, tag?: any, $event?: any) {
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
        this.New(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
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
        this.Copy(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem15_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Print(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem23_click(params: any = {}, tag?: any, $event?: any) {
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
        this.FirstRecord(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
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
        xData = this.$refs.form;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.PrevRecord(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
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
        xData = this.$refs.form;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.NextRecord(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem26_click(params: any = {}, tag?: any, $event?: any) {
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
        this.LastRecord(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem22_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Help(datas, contextJO,paramJO,  $event, xData,this,"MsgOpenAccess");
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
     * @memberof MsgOpenAccessEditViewBase
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
     * 保存并新建
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public SaveAndNew(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.saveAndNew instanceof Function)) {
            return;
        }
        xData.saveAndNew().then((response: any) => {
            if (!response || response.status !== 200) {
                _this.$emit('viewdataschange', JSON.stringify({status:'error',action:'saveAndNew'}));
                return;
            }
            _this.$emit('viewdataschange', JSON.stringify({status:'success',action:'saveAndNew',data:response.data}));
            if (xData.autoLoad instanceof Function) {
                xData.autoLoad();
            }
        });
    }
    /**
     * 保存并关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public SaveAndExit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (xData && xData.saveAndExit instanceof Function) {
            xData.saveAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if(window.parent){
                    window.parent.postMessage([{ ...response.data }],'*');
                }
            });
        } else if (_this.saveAndExit && _this.saveAndExit instanceof Function) {
            _this.saveAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if(window.parent){
                    window.parent.postMessage([{ ...response.data }],'*');
                }
            });
        }
    }
    /**
     * 删除并关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public RemoveAndExit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (xData && xData.removeAndExit instanceof Function) {
            xData.removeAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if(window.parent){
                    window.parent.postMessage([{ ...response.data }],'*');
                }
            });
        } else if (_this.removeAndExit && _this.removeAndExit instanceof Function) {
            _this.removeAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if(window.parent){
                    window.parent.postMessage([{ ...response.data }],'*');
                }
            });
        }
    }
    /**
     * 开始流程
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public SaveAndStart(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.wfstart instanceof Function)) {
            return;
        }
        xData.wfstart(args).then((response: any) => {
            if (!response || response.status !== 200) {
                return;
            }
            const { data: _data } = response;
            if(window.parent){
                window.parent.postMessage({ ..._data },'*');
            }
            if (_this.viewdata) {
                _this.$emit('viewdataschange', [{ ..._data }]);
                _this.$emit('close');
            }else if (this.$tabPageExp) {
                this.$tabPageExp.onClose(this.$route.fullPath);
            }
        });
    }
    /**
     * 当前流程步骤
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public ViewWFStep(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        let _this:any = this;
        if (!xData || !(xData.wfsubmit instanceof Function)) {
            return;
        }
        xData.wfsubmit(args).then((response: any) => {
            if (!response || response.status !== 200) {
                return;
            }
            const { data: _data } = response;

            if (_this.viewdata) {
                _this.$emit('viewdataschange', [{ ..._data }]);
                _this.$emit('close');
            } else if (_this.$tabPageExp) {
                _this.$tabPageExp.onClose(_this.$route.fullPath);
            }
        });
    }
    /**
     * 新建
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public New(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
         const _this: any = this;
        if (_this.newdata && _this.newdata instanceof Function) {
            const data: any = {};
            _this.newdata([{ ...data }],[{ ...data }], params, $event, xData);
        } else {
            _this.$Notice.error({ title: '错误', desc: 'newdata 视图处理逻辑不存在，请添加!' });
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
     * @memberof MsgOpenAccessEditViewBase
     */
    public Copy(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        if (args.length === 0) {
            return;
        }
        const _this: any = this;
        if (_this.opendata && _this.opendata instanceof Function) {
            const data: any = { };
            if (args.length > 0) {
                Object.assign(data, { msgopenaccess: args[0].msgopenaccess });
            }
            if(!params) params = {};
            Object.assign(params,{copymode:true});
            _this.opendata([{ ...data }], params, $event, xData);
        } else {
            Object.assign(this.viewparams,{copymode:true});
        }
    }
    /**
     * 打印
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public Print(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        let _this:any = this;
        if (!xData || !(xData.print instanceof Function) || !$event) {
            return ;
        }
        xData.print();
    }
    /**
     * 第一个记录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public FirstRecord(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        let _this:any = this;
        let navDataService:any = new NavDataService(this.$store);
        let allNavData:any = Object.is(this.navModel,"route")?navDataService.getPreNavDataById('msg-open-access-edit-view'):navDataService.getPreNavDataByTag(_this.viewtag);
        if(allNavData && allNavData.data && allNavData.data.length >0){
            if(_this.parseViewParam && _this.engine){
                _this.parseViewParam(allNavData.data[0].srfkey);
                _this.engine.load();
            }  
        }else{
            this.$Notice.warning({ title: '警告', desc: '请确认操作路径是否正确' });
        }
    }
    /**
     * 上一个记录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public PrevRecord(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        if(args.length === 0 || !args[0].srfkey){
            return;
        }
        let _this:any = this;
        let navDataService:any = new NavDataService(this.$store);
        let allNavData:any = Object.is(this.navModel,"route")?navDataService.getPreNavDataById('msg-open-access-edit-view'):navDataService.getPreNavDataByTag(_this.viewtag);
        if(allNavData && allNavData.data && allNavData.data.length >0){
            let computedIndex:any;
            for(let i=0;i<allNavData.data.length;i++){
                if(allNavData.data[i].srfkey === args[0].srfkey){
                    computedIndex = i-1;
                    break;
                }
            }
            if(computedIndex >= 0){
                if(_this.parseViewParam && _this.engine){
                    _this.parseViewParam(allNavData.data[computedIndex].srfkey);
                    _this.engine.load();
                } 
            }else{
                this.$Notice.warning({ title: '警告', desc: '当前数据已经是第一条数据' });
            }
        }else{
            this.$Notice.warning({ title: '警告', desc: '请确认操作路径是否正确' });
        }
    }

    /**
     * 下一个记录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public NextRecord(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        if(args.length === 0 || !args[0].srfkey){
            return;
        }
        let _this:any = this;
        let navDataService:any = new NavDataService(this.$store);
        let allNavData:any = Object.is(this.navModel,"route")?navDataService.getPreNavDataById('msg-open-access-edit-view'):navDataService.getPreNavDataByTag(_this.viewtag);
        if(allNavData && allNavData.data && allNavData.data.length >0){
            let computedIndex:any;
            for(let i=0;i<allNavData.data.length;i++){
                if(allNavData.data[i].srfkey === args[0].srfkey){
                    computedIndex = i+1;
                    break;
                }
            }
            if(computedIndex < allNavData.data.length){
                if(_this.parseViewParam && _this.engine){
                    _this.parseViewParam(allNavData.data[computedIndex].srfkey);
                    _this.engine.load();
                } 
            }else{
                this.$Notice.warning({ title: '警告', desc: '当前数据已经是最后一条数据' });
            }
        }else{
            this.$Notice.warning({ title: '警告', desc: '请确认操作路径是否正确' });
        }
    }

    /**
     * 最后一个记录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public LastRecord(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        let _this:any = this;
        let navDataService:any = new NavDataService(this.$store);
        let allNavData:any = Object.is(this.navModel,"route")?navDataService.getPreNavDataById('msg-open-access-edit-view'):navDataService.getPreNavDataByTag(_this.viewtag);
        if(allNavData && allNavData.data && allNavData.data.length >0){
            if(_this.parseViewParam && _this.engine){
                _this.parseViewParam(allNavData.data[allNavData.data.length - 1].srfkey);
                _this.engine.load();
            }   
        }else{
            this.$Notice.warning({ title: '警告', desc: '请确认操作路径是否正确' });
        }
    }
    /**
     * 帮助
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof MsgOpenAccessEditViewBase
     */
    public Help(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        this.$Notice.error({ title: '错误', desc: '帮助未支持' });
    }

    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof MsgOpenAccessEditViewBase
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
     * @memberof MsgOpenAccessEditViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof MsgOpenAccessEditViewBase
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
    }


}
</script>

<style lang='less'>
@import './msg-open-access-edit-view.less';
</style>