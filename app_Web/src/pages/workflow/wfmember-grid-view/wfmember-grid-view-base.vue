<template>
<div class='view-container degridview wfmember-grid-view'>
    <app-studioaction :viewTitle="$t(model.srfTitle)" viewName="wfmembergridview"></app-studioaction>
    <card class='view-card '  :dis-hover="true" :bordered="false">
        <p slot='title'>
        <span class='caption-info'>{{$t(model.srfTitle)}}</span>
        </p>
        <div class='content-container'>
            <div class='view-top-messages'>
            </div>
            <div style='margin-bottom: 6px;'>
                <i-input v-show="!isExpandSearchForm" v-model="query" search enter-button @on-search="onSearch($event)" class='quick-search-input' style='max-width: 400px;' placeholder="组成员名称" />
                <div class='pull-right'>
                    <div class='toolbar-container'>
                        <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem3.visabled" :disabled="toolBarModels.tbitem3.disabled" class='' @click="toolbar_click({ tag: 'tbitem3' }, $event)">
                                    <i class='fa fa-file-text-o'></i>
                                    <span class='caption'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem3.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem3.tip')}}</div>
                        </tooltip>
                        <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem4.visabled" :disabled="toolBarModels.tbitem4.disabled" class='' @click="toolbar_click({ tag: 'tbitem4' }, $event)">
                                    <i class='fa fa-edit'></i>
                                    <span class='caption'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem4.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem4.tip')}}</div>
                        </tooltip>
                        <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem6.visabled" :disabled="toolBarModels.tbitem6.disabled" class='' @click="toolbar_click({ tag: 'tbitem6' }, $event)">
                                    <i class='fa fa-copy'></i>
                                    <span class='caption'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem6.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem6.tip')}}</div>
                        </tooltip>
                        <span class='seperator'>|</span>    <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem8.visabled" :disabled="toolBarModels.tbitem8.disabled" class='' @click="toolbar_click({ tag: 'tbitem8' }, $event)">
                                    <i class='fa fa-remove'></i>
                                    <span class='caption'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem8.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem8.tip')}}</div>
                        </tooltip>
                        <span class='seperator'>|</span>    <tooltip :transfer="true" :max-width="600">
                            <app-export-excel :item="toolBarModels.tbitem13" :caption="$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem13.caption')" @exportexcel="toolbar_click({ tag: 'tbitem13' }, $event)"></app-export-excel>
                            <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem13.tip')}}</div>
                        </tooltip>
                        <span class='seperator'>|</span>    <dropdown v-show="toolBarModels.tbitem16.visabled" trigger='click'>
                            <tooltip :transfer="true" :max-width="600">
                                    <i-button class=''>
                                        <i class=''></i>
                                        <span class='caption'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem16.caption')}}</span>
                                        <icon type="ios-arrow-down"></icon>
                                    </i-button>
                                <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem16.tip')}}</div>
                            </tooltip>
                            <dropdown-menu slot='list'>
                                <dropdown-item>
                                    <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem21.visabled" :disabled="toolBarModels.tbitem21.disabled" class='' @click="toolbar_click({ tag: 'tbitem21' }, $event)">
                                    <i class='fa fa-download'></i>
                                    <span class='caption'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem21.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem21.tip')}}</div>
                        </tooltip>
                        
                        
                                </dropdown-item>
                                <dropdown-item>
                                    <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem23.visabled" :disabled="toolBarModels.tbitem23.disabled" class='' @click="toolbar_click({ tag: 'tbitem23' }, $event)">
                                    <i class='fa fa-upload'></i>
                                    <span class='caption'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem23.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem23.tip')}}</div>
                        </tooltip>
                        
                        
                                </dropdown-item>
                            </dropdown-menu>
                        </dropdown>
                        <span class='seperator'>|</span>    <tooltip :transfer="true" :max-width="600">
                                <i-button v-show="toolBarModels.tbitem19.visabled" :disabled="toolBarModels.tbitem19.disabled" class='' @click="toolbar_click({ tag: 'tbitem19' }, $event)">
                                    <i class='fa fa-filter'></i>
                                    <span class='caption'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem19.caption')}}</span>
                                </i-button>
                            <div slot='content'>{{$t('entities.wfmember.gridviewtoolbar_toolbar.tbitem19.tip')}}</div>
                        </tooltip>
                    </div>
                </div>
            </div>
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
                @save="searchform_save($event)"  
                @search="searchform_search($event)"  
                @load="searchform_load($event)"  
                @closeview="closeView($event)">
            </view_searchform>
            <view_grid 
                :viewState="viewState"  
                :viewparams="viewparams" 
                :context="context" 
                :isSingleSelect="isSingleSelect"
                :showBusyIndicator="true"
                :isOpenEdit="false"
                :gridRowActiveMode="gridRowActiveMode"
                @save="onSave"
                updateAction=""
                removeAction="Remove"
                loaddraftAction=""
                loadAction=""
                createAction=""
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
            <div class='view-bottom-messages'>
            </div>
        </div>
    </card>
</div>
</template>


<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { UIActionTool,Util } from '@/utils';
import { Subject } from 'rxjs';
import WFMemberService from '@/service/wfmember/wfmember-service';

import GridViewEngine from '@engine/view/grid-view-engine';


import CodeListService from "@service/app/codelist-service";


@Component({
    components: {
    },
})
export default class WFMemberGridViewBase extends Vue {

    /**
     * 实体服务对象
     *
     * @type {WFMemberService}
     * @memberof WFMemberGridViewBase
     */
    public appEntityService: WFMemberService = new WFMemberService;


    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof WFMemberGridViewBase
     */    
    public counterServiceArray:Array<any> = [];
    
    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof WFMemberGridViewBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof WFMemberGridViewBase
     */
    @Prop() public viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof WFMemberGridViewBase
     */
    @Prop() public viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof WFMemberGridViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof WFMemberGridViewBase
	 */
	public viewtag: string = '135872676ba63d430b2f20bd20364286';

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof WFMemberGridViewBase
	 */
    public customViewNavContexts:any ={
    };

	/**
	 * 自定义视图导航参数集合
	 *
	 * @type {*}
	 * @memberof WFMemberGridViewBase
	 */
    public customViewParams:any ={
    };

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof WFMemberGridViewBase
     */
    public model: any = {
        srfCaption: 'entities.wfmember.views.gridview.caption',
        srfTitle: 'entities.wfmember.views.gridview.title',
        srfSubTitle: 'entities.wfmember.views.gridview.subtitle',
        dataInfo: ''
    }

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
     */
    public containerModel: any = {
        view_toolbar: { name: 'toolbar', type: 'TOOLBAR' },
        view_grid: { name: 'grid', type: 'GRID' },
        view_searchform: { name: 'searchform', type: 'SEARCHFORM' },
    };

    /**
     *  计数器刷新
     *
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
     */
    public viewState: Subject<ViewState> = new Subject();
    /**
     * 工具栏模型
     *
     * @type {*}
     * @memberof WFMemberGridView
     */
    public toolBarModels: any = {
        tbitem3: { name: 'tbitem3', caption: '新建', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'New', target: '' } },

        tbitem4: { name: 'tbitem4', caption: '编辑', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Edit', target: 'SINGLEKEY' } },

        tbitem6: { name: 'tbitem6', caption: '拷贝', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Copy', target: 'SINGLEKEY' } },

        tbitem7: {  name: 'tbitem7', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem8: { name: 'tbitem8', caption: '删除', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Remove', target: 'MULTIKEY' } },

        tbitem9: {  name: 'tbitem9', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem13: { name: 'tbitem13', caption: '导出', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'ExportExcel', target: '' }, MaxRowCount: 1000  },

        tbitem10: {  name: 'tbitem10', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem16: { name: 'tbitem16', caption: '其它', disabled: false, type: 'ITEMS', visabled: true, dataaccaction: '', uiaction: { } }, 
 tbitem21: { name: 'tbitem21', caption: '导出数据模型', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'ExportModel', target: '' } },

 tbitem23: { name: 'tbitem23', caption: '数据导入', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'Import', target: '' } },


        tbitem17: {  name: 'tbitem17', type: 'SEPERATOR', visabled: true, dataaccaction: '', uiaction: { } },
        tbitem19: { name: 'tbitem19', caption: '过滤', disabled: false, type: 'DEUIACTION', visabled: true, dataaccaction: '', uiaction: { tag: 'ToggleFilter', target: '' } },

    };





    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof WFMemberGridViewBase
     */
    public engine: GridViewEngine = new GridViewEngine();

    /**
     * 引擎初始化
     *
     * @public
     * @memberof WFMemberGridViewBase
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
            searchform: this.$refs.searchform,
            keyPSDEField: 'wfmember',
            majorPSDEField: 'membername',
            isLoadDefault: true,
        });
    }

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof WFMemberGridViewBase
     */
    public context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof WFMemberGridViewBase
     */
    public viewparams:any = {};

    /**
     * 解析视图参数
     *
     * @public
     * @memberof WFMemberGridViewBase
     */
    public parseViewParam(): void {
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
        if(this.$store.getters.getAppData() && this.$store.getters.getAppData().context){
            Object.assign(this.context,this.$store.getters.getAppData().context);
        }
        //初始化视图唯一标识
        Object.assign(this.context,{srfsessionid:this.$util.createUUID()});
        this.handleCustomViewData();
    }

    /**
     * 处理自定义视图数据
     *
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
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
     * Vue声明周期
     *
     * @memberof WFMemberGridViewBase
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof WFMemberGridViewBase
     */    
    public afterCreated(){
        const secondtag = this.$util.createUUID();
        this.$store.commit('viewaction/createdView', { viewtag: this.viewtag, secondtag: secondtag });
        this.viewtag = secondtag;
        this.parseViewParam();
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
     * @memberof WFMemberGridViewBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof WFMemberGridViewBase
     */
    public mounted() {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     * 
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
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
        if (Object.is($event.tag, 'tbitem6')) {
            this.toolbar_tbitem6_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem24')) {
            this.toolbar_tbitem24_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem25')) {
            this.toolbar_tbitem25_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem8')) {
            this.toolbar_tbitem8_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem13')) {
            this.toolbar_tbitem13_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem11')) {
            this.toolbar_tbitem11_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem21')) {
            this.toolbar_tbitem21_click(null, '', $event2);
        }
        if (Object.is($event.tag, 'tbitem23')) {
            this.toolbar_tbitem23_click(null, '', $event2);
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
     * @memberof WFMemberGridViewBase
     */
    public grid_selectionchange($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'selectionchange', $event);
    }


    /**
     * grid 部件 beforeload 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFMemberGridViewBase
     */
    public grid_beforeload($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'beforeload', $event);
    }


    /**
     * grid 部件 rowdblclick 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFMemberGridViewBase
     */
    public grid_rowdblclick($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'rowdblclick', $event);
    }


    /**
     * grid 部件 remove 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFMemberGridViewBase
     */
    public grid_remove($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'remove', $event);
    }


    /**
     * grid 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFMemberGridViewBase
     */
    public grid_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('grid', 'load', $event);
    }


    /**
     * searchform 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFMemberGridViewBase
     */
    public searchform_save($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'save', $event);
    }


    /**
     * searchform 部件 search 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFMemberGridViewBase
     */
    public searchform_search($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'search', $event);
    }


    /**
     * searchform 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof WFMemberGridViewBase
     */
    public searchform_load($event: any, $event2?: any) {
        this.engine.onCtrlEvent('searchform', 'load', $event);
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
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.New(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
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
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.Edit(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
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
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.View(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem6_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Copy(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
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
        this.ToggleRowEdit(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
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
        this.NewRow(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
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
        this.Remove(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem13_click(params: any = {}, tag?: any, $event?: any) {
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
        this.ExportExcel(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem11_click(params: any = {}, tag?: any, $event?: any) {
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
        this.Print(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
    }

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public toolbar_tbitem21_click(params: any = {}, tag?: any, $event?: any) {
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
        this.ExportModel(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
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
        xData = this.$refs.grid;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        this.Import(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
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
        this.ToggleFilter(datas, contextJO,paramJO,  $event, xData,this,"WFMember");
    }

    /**
     * 打开新建数据视图
     *
     * @param {any[]} args
     * @param {*} [params]
     * @param {*} [fullargs]
     * @param {*} [$event]
     * @param {*} [xData]
     * @memberof WFMemberGridView
     */
    public newdata(args: any[],fullargs?:any[], params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
        const batchAddPSAppViews=[
            {view:{viewname:'wfgroup-mpickup-view',height: 0,width: 0,title: '角色/用户组数据多项选择视图'},
            res:['WFGroup'],
            'resAppKey':'groupid'},
            {view:{viewname:'wfuser-mpickup-view',height: 0,width: 0,title: '用户数据多项选择视图'},
            res:['WFUser'],
            'resAppKey':'userid'}
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
        let container: Subject<any> = this.$appmodal.openModal(openViewModel.view, JSON.parse(JSON.stringify(this.context)), args[0]);
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
     * @memberof WFMemberGridView
     */
    public opendata(args: any[],fullargs?:any[],params?: any, $event?: any, xData?: any) {
        let localContext:any = null;
        let localViewParam:any =null;
        const data: any = {};
        let tempContext = JSON.parse(JSON.stringify(this.context));
        if(args.length >0){
            Object.assign(tempContext,args[0]);
        }
        let deResParameters: any[] = [];
        if(tempContext.wfgroup && true){
            deResParameters = [
            { pathName: 'wfgroups', parameterName: 'wfgroup' },
            ]
        }
        const parameters: any[] = [
            { pathName: 'wfmembers', parameterName: 'wfmember' },
            { pathName: 'editview', parameterName: 'editview' },
        ];
        const _this: any = this;
        const openIndexViewTab = (data: any) => {
            const routePath = this.$viewTool.buildUpRoutePath(this.$route, tempContext, deResParameters, parameters, args, data);
            this.$router.push(routePath);
        }
        openIndexViewTab(data);
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
     * @memberof WFMemberGridViewBase
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
     * 编辑
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof WFMemberGridViewBase
     */
    public Edit(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        if (args.length === 0) {
            return;
        }
        const _this: any = this;
        if (_this.opendata && _this.opendata instanceof Function) {
            const data: any = { };
            if (args.length > 0) {
                Object.assign(data, { wfmember: args[0].wfmember })
            }
            _this.opendata([{ ...data }], params, $event, xData);
        } else {
            _this.$Notice.error({ title: '错误', desc: 'opendata 视图处理逻辑不存在，请添加!' });
        }
    }
    /**
     * 查看
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof WFMemberGridViewBase
     */
    public View(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        if (args.length === 0) {
            return;
        }
        const _this: any = this;
        if (_this.opendata && _this.opendata instanceof Function) {
            const data: any = { };
            if (args.length > 0) {
                Object.assign(data, { wfmember: args[0].wfmember })
            }
            _this.opendata([{ ...data }], params, $event, xData);
        } else {
            _this.$Notice.error({ title: '错误', desc: 'opendata 视图处理逻辑不存在，请添加!' });
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
     * @memberof WFMemberGridViewBase
     */
    public Copy(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        if (args.length === 0) {
            return;
        }
        const _this: any = this;
        if (_this.newdata && _this.newdata instanceof Function) {
            const data: any = {};
            if (args.length > 0) {
                Object.assign(data, { srfsourcekey: args[0].srfkey })
                actionContext.$store.commit('addCopyData', { srfkey: args[0].srfkey, copyData: args[0] });
            }
            _this.newdata([{ ...data }],[{ ...data }],params, $event, xData);
        } else if (xData && xData.copy instanceof Function) {
            if (args.length > 0) {
                actionContext.$store.commit('addCopyData', { srfkey: args[0].srfkey, copyData: args[0] });
            }
            xData.copy(args[0].srfkey);
        } else {
            _this.$Notice.error({ title: '错误', desc: 'opendata 视图处理逻辑不存在，请添加!' });
        }
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
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
     */
    public NewRow(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        const data: any = {};
        if (_this.newRow && _this.newRow instanceof Function) {
            _this.newRow([{ ...data }], params, $event, xData);
        } else if(xData.newRow && xData.newRow instanceof Function) {
            xData.newRow([{ ...data }], params, $event, xData);
        }else{
            _this.$Notice.error({ title: '错误', desc: 'newRow 视图处理逻辑不存在，请添加!' });
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
     * @memberof WFMemberGridViewBase
     */
    public Remove(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.remove instanceof Function)) {
            return ;
        }
        xData.remove(args);
    }

    /**
     * 导出
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof WFMemberGridViewBase
     */
    public ExportExcel(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.exportExcel instanceof Function) || !$event) {
            return ;
        }
        xData.exportExcel($event.exportparms);
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
     * @memberof WFMemberGridViewBase
     */
    public Print(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        let _this:any = this;
        if (!xData || !(xData.print instanceof Function) || !$event) {
            return ;
        }
        xData.print();
    }
    /**
     * 导出数据模型
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof WFMemberGridViewBase
     */
    public ExportModel(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        this.$Notice.error({ title: '错误', desc: '导出数据模型未支持' });
    }
    /**
     * 数据导入
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof WFMemberGridViewBase
     */
    public Import(args: any[],contextJO?:any, params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        const _this: any = this;
        if (!xData || !(xData.importExcel instanceof Function) || !$event) {
            return ;
        }
        xData.importExcel(params);
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
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
     */
    public destroyed(){
        this.afterDestroyed();
    }

    /**
     * 执行destroyed后的逻辑
     * 
     * @memberof WFMemberGridViewBase
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
        }
    }

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof WFMemberGridViewBase
     */
    public isSingleSelect: boolean = false;


    /**
    * 是否嵌入关系界面
    *
    * @type {boolean}
    * @memberof WFMemberGridViewBase
    */
    @Prop({default:false}) public isformDruipart?: boolean;

    /**
    * 界面关系通讯对象
    *
    * @type {Subject<ViewState>}
    * @memberof WFMemberGridViewBase
    */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 搜索值
     *
     * @type {string}
     * @memberof WFMemberGridViewBase
     */
    public query: string = '';

    /**
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof WFMemberGridViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof WFMemberGridViewBase
     */
    public gridRowActiveMode: number | 0 | 1 | 2 = 2;

    /**
     * 快速搜索
     *
     * @param {*} $event
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
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
     * @memberof WFMemberGridViewBase
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
@import './wfmember-grid-view.less';
</style>