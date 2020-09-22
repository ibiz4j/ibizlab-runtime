<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='dictoption_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group :uiService="appUIService" :data="transformData(data)" :manageContainerStatus="detailsModel.group1.manageContainerStatus"  :isManageContainer="detailsModel.group1.isManageContainer" @managecontainerclick="manageContainerClick('group1')" layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.dictoption.main_form.details.group1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.cname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='cname' :itemRules="this.rules().cname" class='' :caption="$t('entities.dictoption.main_form.details.cname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.cname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.cname.disabled"
  name='cname'
  deMajorField='name'
  deKeyField='dictcatalog'
  :service="service"
  :acParams="{ serviceName: 'DictCatalogService', interfaceName: 'FetchDefault'}"
  valueitem='cid' 
  :value="data.cname" 
  editortype="" 
  :pickupView="{ viewname: 'dict-catalog-pickup-view', title: $t('entities.dictcatalog.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'dictcatalogs', parameterName: 'dictcatalog' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.val.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='val' :itemRules="this.rules().val" class='' :caption="$t('entities.dictoption.main_form.details.val')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.val.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.val"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.val.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.label.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='label' :itemRules="this.rules().label" class='' :caption="$t('entities.dictoption.main_form.details.label')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.label.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.label"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.label.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.pval.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='pval' :itemRules="this.rules().pval" class='' :caption="$t('entities.dictoption.main_form.details.pval')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pval.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.pval"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.pval.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.showorder.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='showorder' :itemRules="this.rules().showorder" class='' :caption="$t('entities.dictoption.main_form.details.showorder')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.showorder.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.showorder"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.showorder.disabled" 
    type='number' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.disabled.visible" :style="{}"  :sm="{ span: 12, offset: 0 }" :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='disabled' :itemRules="this.rules().disabled" class='' :caption="$t('entities.dictoption.main_form.details.disabled')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.disabled.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.disabled" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.disabled.disabled" 
  valueType="number"
  style="width:100px;width: 100px;" 
  tag='YesNo' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.expired.visible" :style="{}"  :sm="{ span: 12, offset: 0 }" :md="{ span: 12, offset: 0 }" :lg="{ span: 12, offset: 0 }" :xl="{ span: 12, offset: 0 }">
    <app-form-item name='expired' :itemRules="this.rules().expired" class='' :caption="$t('entities.dictoption.main_form.details.expired')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.expired.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.expired" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.expired.disabled" 
  valueType="number"
  style="width:100px;width: 100px;" 
  tag='YesNo' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.vfilter.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 24, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-item name='vfilter' :itemRules="this.rules().vfilter" class='' :caption="$t('entities.dictoption.main_form.details.vfilter')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.vfilter.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.vfilter"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.vfilter.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.iconcls.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='iconcls' :itemRules="this.rules().iconcls" class='' :caption="$t('entities.dictoption.main_form.details.iconcls')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.iconcls.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.iconcls"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.iconcls.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.cls.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='cls' :itemRules="this.rules().cls" class='' :caption="$t('entities.dictoption.main_form.details.cls')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.cls.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.cls"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.cls.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.extension.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 24, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-item name='extension' :itemRules="this.rules().extension" class='' :caption="$t('entities.dictoption.main_form.details.extension')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.extension.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.extension" :textareaId="this.$util.createUUID()"  :disabled="detailsModel.extension.disabled" type='textarea' textareaStyle="height:200px;" ></input-box>

</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>


    </row>
</i-form>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util,ViewTool } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import AppCenterService from "@service/app/app-center-service";
import DictOptionService from '@/service/dict-option/dict-option-service';
import MainService from './main-form-service';
import DictOptionUIService from '@/uiservice/dict-option/dict-option-ui-service';
import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import schema from 'async-validator';
import { Environment } from '@/environments/environment';


@Component({
    components: {
      
    }
})
export default class MainBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof MainBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof MainBase
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof MainBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {MainService}
     * @memberof MainBase
     */
    public service: MainService = new MainService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {DictOptionService}
     * @memberof MainBase
     */
    public appEntityService: DictOptionService = new DictOptionService({ $store: this.$store });
    


    /**
     * 转化数据
     *
     * @param {any} args
     * @memberof  MainBase
     */
    public transformData(args: any) {
        let _this: any = this;
        if(_this.service && _this.service.handleRequestData instanceof Function && _this.service.handleRequestData('transform',_this.context,args)){
            return _this.service.handleRequestData('transform',_this.context,args)['data'];
        }
    }

    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof MainBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof MainBase
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
     * 视图默认使用
     *
     * @type {string}
     * @memberof MainBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

    /**
     * 界面UI服务对象
     *
     * @type {DictOptionUIService}
     * @memberof MainBase
     */  
    public appUIService:DictOptionUIService = new DictOptionUIService(this.$store);

    /**
     * 工作流审批意见控件绑定值
     *
     * @memberof MainBase
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof MainBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof MainBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof MainBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof MainBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof MainBase
     */
    public oldData: any = {};

    /**
     * 混入表单数据对象
     *
     * @type {*}
     * @memberof MainBase
     */
    public mixinData:any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof MainBase
     */
    public data: any = {
        srfupdatedate: null,
        srforikey: null,
        srfkey: null,
        srfmajortext: null,
        srftempmode: null,
        srfuf: null,
        srfdeid: null,
        srfsourcekey: null,
        cname: null,
        val: null,
        label: null,
        pval: null,
        showorder: null,
        disabled: null,
        expired: null,
        vfilter: null,
        iconcls: null,
        cls: null,
        extension: null,
        cid: null,
        vkey: null,
        dictoption:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof MainBase
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof MainBase
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof MainBase
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof MainBase
      */
    public saveState:any ;

    /**
     * 值规则
     *
     * @type {*}
     * @memberof MainBase
     */
    public rules() :any {
    return {
        srfupdatedate: [
            { type: 'string', message: '最后修改时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '最后修改时间 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.srfupdatedate.required, type: 'string', message: '最后修改时间 值不能为空', trigger: 'change' },
            { required: this.detailsModel.srfupdatedate.required, type: 'string', message: '最后修改时间 值不能为空', trigger: 'blur' },
        ],
        srforikey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.srforikey.required, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: this.detailsModel.srforikey.required, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
            { type: 'string', message: '标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '标识 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.srfkey.required, type: 'string', message: '标识 值不能为空', trigger: 'change' },
            { required: this.detailsModel.srfkey.required, type: 'string', message: '标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.srfmajortext.required, type: 'string', message: '名称 值不能为空', trigger: 'change' },
            { required: this.detailsModel.srfmajortext.required, type: 'string', message: '名称 值不能为空', trigger: 'blur' },
        ],
        srftempmode: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.srftempmode.required, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: this.detailsModel.srftempmode.required, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfuf: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.srfuf.required, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: this.detailsModel.srfuf.required, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfdeid: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.srfdeid.required, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: this.detailsModel.srfdeid.required, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfsourcekey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.srfsourcekey.required, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: this.detailsModel.srfsourcekey.required, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        cname: [
            { type: 'string', message: '目录 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '目录 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.cname.required, type: 'string', message: '目录 值不能为空', trigger: 'change' },
            { required: this.detailsModel.cname.required, type: 'string', message: '目录 值不能为空', trigger: 'blur' },
        ],
        val: [
            { type: 'string', message: '代码值 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '代码值 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.val.required, type: 'string', message: '代码值 值不能为空', trigger: 'change' },
            { required: this.detailsModel.val.required, type: 'string', message: '代码值 值不能为空', trigger: 'blur' },
        ],
        label: [
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.label.required, type: 'string', message: '名称 值不能为空', trigger: 'change' },
            { required: this.detailsModel.label.required, type: 'string', message: '名称 值不能为空', trigger: 'blur' },
        ],
        pval: [
            { type: 'string', message: '父代码值 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '父代码值 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.pval.required, type: 'string', message: '父代码值 值不能为空', trigger: 'change' },
            { required: this.detailsModel.pval.required, type: 'string', message: '父代码值 值不能为空', trigger: 'blur' },
        ],
        showorder: [
            { type: 'number', message: '排序 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '排序 值必须为数值类型', trigger: 'blur' },
            { required: this.detailsModel.showorder.required, type: 'number', message: '排序 值不能为空', trigger: 'change' },
            { required: this.detailsModel.showorder.required, type: 'number', message: '排序 值不能为空', trigger: 'blur' },
        ],
        disabled: [
            { type: 'number', message: '是否禁用 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否禁用 值必须为数值类型', trigger: 'blur' },
            { required: this.detailsModel.disabled.required, type: 'number', message: '是否禁用 值不能为空', trigger: 'change' },
            { required: this.detailsModel.disabled.required, type: 'number', message: '是否禁用 值不能为空', trigger: 'blur' },
        ],
        expired: [
            { type: 'number', message: '过期/失效 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '过期/失效 值必须为数值类型', trigger: 'blur' },
            { required: this.detailsModel.expired.required, type: 'number', message: '过期/失效 值不能为空', trigger: 'change' },
            { required: this.detailsModel.expired.required, type: 'number', message: '过期/失效 值不能为空', trigger: 'blur' },
        ],
        vfilter: [
            { type: 'string', message: '过滤项 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '过滤项 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.vfilter.required, type: 'string', message: '过滤项 值不能为空', trigger: 'change' },
            { required: this.detailsModel.vfilter.required, type: 'string', message: '过滤项 值不能为空', trigger: 'blur' },
        ],
        iconcls: [
            { type: 'string', message: '图标 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '图标 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.iconcls.required, type: 'string', message: '图标 值不能为空', trigger: 'change' },
            { required: this.detailsModel.iconcls.required, type: 'string', message: '图标 值不能为空', trigger: 'blur' },
        ],
        cls: [
            { type: 'string', message: '栏目样式 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '栏目样式 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.cls.required, type: 'string', message: '栏目样式 值不能为空', trigger: 'change' },
            { required: this.detailsModel.cls.required, type: 'string', message: '栏目样式 值不能为空', trigger: 'blur' },
        ],
        extension: [
            { type: 'string', message: '扩展 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '扩展 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.extension.required, type: 'string', message: '扩展 值不能为空', trigger: 'change' },
            { required: this.detailsModel.extension.required, type: 'string', message: '扩展 值不能为空', trigger: 'blur' },
        ],
        cid: [
            { type: 'string', message: '目录代码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '目录代码 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.cid.required, type: 'string', message: '目录代码 值不能为空', trigger: 'change' },
            { required: this.detailsModel.cid.required, type: 'string', message: '目录代码 值不能为空', trigger: 'blur' },
        ],
        vkey: [
            { type: 'string', message: '标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '标识 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.vkey.required, type: 'string', message: '标识 值不能为空', trigger: 'change' },
            { required: this.detailsModel.vkey.required, type: 'string', message: '标识 值不能为空', trigger: 'blur' },
        ],
        }
    }

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof MainBase
     */
    public deRules:any = {
    };

    /**
     * 校验属性值规则
     *
     * @public
     * @param {{ name: string }} { name }
     * @memberof MainBase
     */
    public verifyDeRules(name:string,rule:any = this.deRules,op:string = "AND") :{isPast:boolean,infoMessage:string}{
        let falg:any = {infoMessage:""};
        if(!rule[name]){
            return falg;
        }
        let opValue = op == 'AND'? true :false;
        let startOp = (val:boolean)=>{
            if(falg.isPast){
                if(opValue){
                    falg.isPast = falg && val;
                }else{
                    falg.isPast = falg || val;
                }
            }else{
                falg.isPast = val;
            }
        }
        rule[name].forEach((item:any) => {
            let dataValue = item.deName?this.data[this.service.getItemNameByDeName(item.deName)]:"";
            // 常规规则
            if(item.type == 'SIMPLE'){
                startOp(!this.$verify.checkFieldSimpleRule(dataValue,item.condOP,item.paramValue,item.ruleInfo,item.paramType,this.data,item.isKeyCond));
                falg.infoMessage = item.ruleInfo;
            }
            // 数值范围
            if(item.type == 'VALUERANGE2'){
                startOp( !this.$verify.checkFieldValueRangeRule(dataValue,item.minValue,item.isIncludeMinValue,item.maxValue,item.isIncludeMaxValue,item.ruleInfo,item.isKeyCond));
                falg.infoMessage = item.ruleInfo;
            }
            // 正则式
            if (item.type == "REGEX") {
                startOp(!this.$verify.checkFieldRegExRule(dataValue,item.regExCode,item.ruleInfo,item.isKeyCond));
                falg.infoMessage = item.ruleInfo;
            }
            // 长度
            if (item.type == "STRINGLENGTH") {
                startOp(!this.$verify.checkFieldStringLengthRule(dataValue,item.minValue,item.isIncludeMinValue,item.maxValue,item.isIncludeMaxValue,item.ruleInfo,item.isKeyCond)); 
                falg.infoMessage = item.ruleInfo;
            }
            // 系统值规则
            if(item.type == "SYSVALUERULE") {
                startOp(!this.$verify.checkFieldSysValueRule(dataValue,item.sysRule.regExCode,item.ruleInfo,item.isKeyCond));
                falg.infoMessage = item.ruleInfo;
            }
            // 分组
            if(item.type == 'GROUP'){
                falg = this.verifyDeRules('group',item)
                if(item.isNotMode){
                   falg.isPast = !falg.isPast;
                }
            }
            
        });
        if(!falg.hasOwnProperty("isPast")){
            falg.isPast = true;
        }
        if(!this.data[name]){
           falg.isPast = true;
        }
        return falg;
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '字典项基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: false, form: this, isControlledContent: false , uiActionGroup: { caption: '', langbase: 'entities.dictoption.main_form', extractMode: 'ITEM', details: [] }, isManageContainer: false, showMoreModeItems: []  })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this, isControlledContent: false  })
, 
        srfupdatedate: new FormItemModel({ caption: '最后修改时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        cname: new FormItemModel({ caption: '目录', detailType: 'FORMITEM', name: 'cname', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:true, disabled: false, enableCond: 3 })
, 
        val: new FormItemModel({ caption: '代码值', detailType: 'FORMITEM', name: 'val', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:true, disabled: false, enableCond: 3 })
, 
        label: new FormItemModel({ caption: '名称', detailType: 'FORMITEM', name: 'label', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:true, disabled: false, enableCond: 3 })
, 
        pval: new FormItemModel({ caption: '父代码值', detailType: 'FORMITEM', name: 'pval', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        showorder: new FormItemModel({ caption: '排序', detailType: 'FORMITEM', name: 'showorder', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        disabled: new FormItemModel({ caption: '是否禁用', detailType: 'FORMITEM', name: 'disabled', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        expired: new FormItemModel({ caption: '过期/失效', detailType: 'FORMITEM', name: 'expired', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        vfilter: new FormItemModel({ caption: '过滤项', detailType: 'FORMITEM', name: 'vfilter', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        iconcls: new FormItemModel({ caption: '图标', detailType: 'FORMITEM', name: 'iconcls', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        cls: new FormItemModel({ caption: '栏目样式', detailType: 'FORMITEM', name: 'cls', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        extension: new FormItemModel({ caption: '扩展', detailType: 'FORMITEM', name: 'extension', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        cid: new FormItemModel({ caption: '目录代码', detailType: 'FORMITEM', name: 'cid', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        vkey: new FormItemModel({ caption: '标识', detailType: 'FORMITEM', name: 'vkey', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfupdatedate')
    onSrfupdatedateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfupdatedate', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srforikey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srforikey')
    onSrforikeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srforikey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfkey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfkey')
    onSrfkeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfkey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfmajortext 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfmajortext')
    onSrfmajortextChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfmajortext', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srftempmode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srftempmode')
    onSrftempmodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srftempmode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfuf 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfuf')
    onSrfufChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfuf', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfdeid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfdeid')
    onSrfdeidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfdeid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfsourcekey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.cname')
    onCnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'cname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 val 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.val')
    onValChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'val', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 label 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.label')
    onLabelChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'label', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pval 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pval')
    onPvalChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pval', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 showorder 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.showorder')
    onShoworderChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'showorder', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 disabled 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.disabled')
    onDisabledChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'disabled', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 expired 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.expired')
    onExpiredChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'expired', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 vfilter 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.vfilter')
    onVfilterChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'vfilter', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 iconcls 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.iconcls')
    onIconclsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'iconcls', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cls 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.cls')
    onClsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'cls', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 extension 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.extension')
    onExtensionChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'extension', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.cid')
    onCidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'cid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 vkey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.vkey')
    onVkeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'vkey', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 显示更多模式切换操作
     *
     * @type {string}
     * @memberof MainBase
     */
    public manageContainerClick(name: string){
        let model = this.detailsModel[name];
        if(model.isManageContainer){
            model.setManageContainerStatus(!model.manageContainerStatus);
            model.showMoreModeItems.forEach((item:any) => {
                if(this.detailsModel[item].isControlledContent){
                    this.detailsModel[item].setVisible(model.manageContainerStatus? this.detailsModel[item].oldVisible : false);
                }
            });
        }
    }

    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof MainBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof MainBase
      */
    public ResetData(_datas:any){
        if(Object.keys(_datas).length >0){
            Object.keys(_datas).forEach((name: string) => {
                if (this.data.hasOwnProperty(name)) {
                    this.data[name] = null;
                }
            });
        }
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof MainBase
     */
    public async formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }){
                























    }

    /**
     * 表单项检查逻辑
     *
     * @public
     * @param name 属性名
     * @memberof MainBase
     */
    public checkItem(name:string):Promise<any> {
        return new Promise((resolve, reject) => {
                var validator = new schema({[name]:this.rules()[name]});
                validator.validate({[name]:this.data[name]}).then(()=>{
                    resolve(true);
                })
                .catch(() => {
                    resolve(false);
                });;
        })
    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof MainBase
     */
    public formDataChange({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
        if (this.ignorefieldvaluechange) {
            return;
        }
        this.resetFormData({ name: name, newVal: newVal, oldVal: oldVal });
        this.formLogic({ name: name, newVal: newVal, oldVal: oldVal });
        this.dataChang.next(JSON.stringify(this.data));
    }

    /**
     * 表单加载完成
     *
     * @public
     * @param {*} [data={}]
     * @param {string} [action]
     * @memberof MainBase
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.dictoption){
            Object.assign(this.context,{dictoption:data.dictoption})
        }
        this.setFormEnableCond(data);
        this.computeButtonState(data);
        this.fillForm(data,action);
        this.oldData = {};
        Object.assign(this.oldData, JSON.parse(JSON.stringify(this.data)));
        this.$store.commit('viewaction/setViewDataChange', { viewtag: this.viewtag, viewdatachange: false });
        this.formLogic({ name: '', newVal: null, oldVal: null });
    }

    /**
     * 值填充
     *
     * @param {*} [_datas={}]
     * @param {string} [action]
     * @memberof MainBase
     */
    public fillForm(_datas: any = {},action:string): void {
        this.mixinData = _datas;
        this.ignorefieldvaluechange = true;
        Object.keys(_datas).forEach((name: string) => {
            if (this.data.hasOwnProperty(name)) {
                this.data[name] = _datas[name];
            }
        });
        if(Object.is(action,'loadDraft')){
            this.createDefault();
        }
        if(Object.is(action,'load')){
            this.updateDefault();
        }
        this.$nextTick(function () {
            this.ignorefieldvaluechange = false;
        })
    }

    /**
     * 设置表单项是否启用
     *
     * @public
     * @param {*} data
     * @memberof MainBase
     */
    public setFormEnableCond(data: any): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: FormItemModel = detail;
            formItem.setEnableCond(data.srfuf);
        });
    }

    /**
     * 重置草稿表单状态
     *
     * @public
     * @memberof MainBase
     */
    public resetDraftFormStates(): void {
        const form: any = this.$refs.form;
        if (form) {
            form.resetFields();
        }
    }

    /**
     * 重置校验结果
     *
     * @memberof MainBase
     */
    public resetValidates(): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: FormItemModel = detail;
            formItem.setError('');
        });
    }

    /**
     * 填充校验结果 （后台）
     *
     * @param {any[]} fieldErrors
     * @memberof MainBase
     */
    public fillValidates(fieldErrors: any[]): void {
        fieldErrors.forEach((error: any) => {
            const formItem: FormItemModel = this.detailsModel[error.field];
            if (!formItem) {
                return;
            }
            this.$nextTick(() => {
                formItem.setError(error.message);
            });
        });
    }

    /**
     * 表单校验状态
     *
     * @returns {boolean} 
     * @memberof MainBase
     */
    public formValidateStatus(): boolean {
        const form: any = this.$refs.form;
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        return validatestate
    }

    /**
     * 获取全部值
     *
     * @returns {*}
     * @memberof MainBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof MainBase
     */
    public onFormItemValueChange($event: { name: string, value: any }): void {
        if (!$event) {
            return;
        }
        if (!$event.name || Object.is($event.name, '') || !this.data.hasOwnProperty($event.name)) {
            return;
        }
        this.data[$event.name] = $event.value;
    }

    /**
     * 编辑器行为触发
     *
     * @param {*} arg
     * @returns {void}
     * @memberof MainBase
     */
    public onFormItemActionClick(arg:any){
        if(arg && (arg instanceof Function)) arg();
    }

    /**
     * 设置数据项值
     *
     * @param {string} name
     * @param {*} value
     * @returns {void}
     * @memberof MainBase
     */
    public setDataItemValue(name: string, value: any): void {
        if (!name || Object.is(name, '') || !this.data.hasOwnProperty(name)) {
            return;
        }
        if (Object.is(this.data[name], value)) {
            return;
        }
        this.data[name] = value;
    }

    /**
     * 计算表单按钮权限状态
     *
     * @param {*} [data] 传入数据
     * @memberof MainBase
     */
    public computeButtonState(data:any){
        let targetData:any = this.transformData(data);
        if(this.detailsModel && Object.keys(this.detailsModel).length >0){
            Object.keys(this.detailsModel).forEach((name:any) =>{
                if(this.detailsModel[name] && this.detailsModel[name].uiaction && this.detailsModel[name].uiaction.dataaccaction && Object.is(this.detailsModel[name].detailType,"BUTTON")){
                    this.detailsModel[name].isPower = true;
                    let tempUIAction:any = JSON.parse(JSON.stringify(this.detailsModel[name].uiaction));
                    let result: any[] = ViewTool.calcActionItemAuthState(targetData,[tempUIAction],this.appUIService);
                    this.detailsModel[name].visible = tempUIAction.visabled;
                    this.detailsModel[name].disabled = tempUIAction.disabled;
                    this.detailsModel[name].isPower = result[0] === 1 ? true : false;
                }
            })
        }
    }



    /**
     * 分组界面行为事件
     *
     * @param {*} $event
     * @memberof MainBase
     */
    public groupUIActionClick($event: any): void {
        if (!$event) {
            return;
        }
        const item:any = $event.item;
    }

    /**
     * Vue声明周期(处理组件的输入属性)
     *
     * @memberof MainBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof MainBase
     */    
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('autoload', action)) {
                    this.autoLoad(data);
                }
                if (Object.is('load', action)) {
                    this.load(data);
                }
                if (Object.is('loaddraft', action)) {
                    this.loadDraft(data);
                }
                if (Object.is('save', action)) {
                    this.save(data,data.showResultInfo);
                }
                if (Object.is('remove', action)) {
                    this.remove(data);
                }
                if (Object.is('saveandexit', action)) {
                    this.saveAndExit(data);
                }
                if (Object.is('saveandnew', action)) {
                    this.saveAndNew(data);
                }
                if (Object.is('removeandexit', action)) {
                    this.removeAndExit(data);
                }
                if (Object.is('refresh', action)) {
                    this.refresh(data);
                }
                if (Object.is('panelaction', action)) {
                    this.panelAction(data.action,data.emitAction,data.data);
                }
            });
        }
        this.dataChang
            .pipe(
                debounceTime(300),
                distinctUntilChanged()
            ).subscribe((data: any) => {
                if (this.autosave) {
                    this.autoSave();
                }
                const state = !Object.is(JSON.stringify(this.oldData), JSON.stringify(this.data)) ? true : false;
                this.$store.commit('viewaction/setViewDataChange', { viewtag: this.viewtag, viewdatachange: state });
            });
    }

    /**
     * vue 生命周期
     *
     * @memberof MainBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof MainBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
        if (this.dataChangEvent) {
            this.dataChangEvent.unsubscribe();
        }
    }

    /**
     *打印
     *@memberof @memberof MainBase
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'dictoption_main',popTitle:'主编辑表单'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public refresh(args: any[]): void {
        let arg: any = {};
        Object.assign(arg,args[0]);
        if (this.data.srfkey && !Object.is(this.data.srfkey, '')) {
            Object.assign(arg, { srfkey: this.data.srfkey });
            this.load(arg);
            return;
        }
        if (this.data.srfkeys && !Object.is(this.data.srfkeys, '')) {
            Object.assign(arg, { srfkey: this.data.srfkeys });
            this.load(arg);
            return;
        }
    }

    /**
     * 自动加载
     *
     * @param {*} [arg={}]
     * @returns {void}
     * @memberof MainBase
     */
    public autoLoad(arg: any = {}): void {
        if (arg.srfkey && !Object.is(arg.srfkey, '')) {
            Object.assign(arg, { srfkey: arg.srfkey });
            this.load(arg);
            return;
        }
        if (arg.srfkeys && !Object.is(arg.srfkeys, '')) {
            Object.assign(arg, { srfkey: arg.srfkeys });
            this.load(arg);
            return;
        }
        this.loadDraft(arg);
    }

    /**
     * 加载
     *
     * @public
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'DictOptionEditView' + (this.$t('app.formpage.notconfig.loadaction') as string) });
            return;
        }
        const arg: any = { ...opt };
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        const get: Promise<any> = this.service.get(this.loadAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        get.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                this.onFormLoad(data,'load');
                this.$emit('load', data);
                this.$nextTick(() => {
                    this.formState.next({ type: 'load', data: data });
                });
            }
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }
        });
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'DictOptionEditView' + (this.$t('app.formpage.notconfig.loaddraftaction') as string) });
            return;
        }
        const arg: any = { ...opt } ;
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            this.resetDraftFormStates();
            this.onFormLoad(data,'loadDraft');
            data.dictoption = null;
            this.$emit('load', data);
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
            setTimeout(() => {
                const form: any = this.$refs.form;
                if (form) {
                    form.fields.forEach((field: any) => {
                        field.validateMessage = "";
                        field.validateState = "";
                        field.validateStatus = false;
                    });
                }
            });
        }).catch((response: any) => {
            if (response && response.status  && response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }
        });
    }

    /**
     * 自动保存
     *
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public autoSave(opt: any = {}): void {
        if (!this.formValidateStatus()) {
            return;
        }
        const arg: any = { ...opt };
        const data = this.getValues();
        Object.assign(arg, data);
        const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
        if(!action){
            let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'DictOptionEditView' + (this.$t('app.formpage.notconfig.actionname') as string) });
            return;
        }
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.add(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            this.onFormLoad(data,'autoSave');
            this.$emit('save', data);
            AppCenterService.notifyMessage({name:"DictOption",action:'appRefresh',data:data});
            this.$nextTick(() => {
                this.formState.next({ type: 'save', data: data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                if(response.data.errorKey && Object.is(response.data.errorKey,"versionCheck")){
                    this.$Modal.confirm({
                        title: (this.$t('app.formpage.saveerror') as string),
                        content: (this.$t('app.formpage.savecontent') as string),
                        onOk: () => {
                            this.refresh([]);
                        },
                        onCancel: () => { }
                    });
                }else{
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                }
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }
        });
    }

    /**
     * 保存
     *
     * @param {*} [opt={}]
     * @param {boolean} [showResultInfo] 
     * @param {boolean} [ifStateNext] formState是否下发通知
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async save(opt: any = {}, showResultInfo?: boolean, ifStateNext: boolean = true): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            showResultInfo = showResultInfo === undefined ? true : false;
            if (!this.formValidateStatus()) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.formpage.valuecheckex') as string) });
                return;
            }
            const arg: any = { ...opt };
            const data = this.getValues();
            Object.assign(arg, this.context);
            Object.assign(arg, data);
            if (ifStateNext) {
                this.drcounter = 0;
                if(this.drcounter !== 0){
                    this.drsaveopt = opt;
                    this.formState.next({ type: 'beforesave', data: arg });//先通知关系界面保存
                    this.saveState = resolve;
                    return;
                }
            }
            if(this.viewparams && this.viewparams.copymode){
                data.srfuf = '0';
            }
            const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
            if(!action){
                let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'DictOptionEditView' + (this.$t('app.formpage.notconfig.actionname') as string) });
                return;
            }
            Object.assign(arg,{viewparams:this.viewparams});
            const post: Promise<any> = Object.is(data.srfuf, '1')?this.service.update(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(action,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
            post.then((response: any) => {
                if (!response.status || response.status !== 200) {
                    if (response.data) {
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                    }
                    return;
                }
                this.viewparams.copymode = false;
                const data = response.data;
                this.onFormLoad(data,'save');
                this.$emit('save', data);
                AppCenterService.notifyMessage({name:"DictOption",action:'appRefresh',data:data});
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: data });
                });
                if (showResultInfo) {
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;'+ (this.$t('app.formpage.savesuccess') as string) });
                }
                resolve(response);
            }).catch((response: any) => {
                if (response && response.status  && response.data) {
                    if(response.data.errorKey && Object.is(response.data.errorKey,"versionCheck")){
                        this.$Modal.confirm({
                            title: (this.$t('app.formpage.saveerror') as string),
                            content: (this.$t('app.formpage.savecontent') as string),
                            onOk: () => {
                                this.refresh([]);
                            },
                            onCancel: () => { }
                        });
                    }else{
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                        reject(response);
                    }
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                    reject(response);
                    return;
                }
                reject(response);
            });
        })
    }

    /**
    * 删除
    *
    * @public
    * @param {*} [opt={}]
    * @memberof MainBase
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'DictOptionEditView' + (this.$t('app.formpage.notconfig.removeaction') as string) });
                return;
            }
            const arg: any = opt[0];
            const _this: any = this;
            Object.assign(arg,{viewparams:this.viewparams});
            this.service.delete(_this.removeAction, JSON.parse(JSON.stringify(this.context)),arg, showResultInfo).then((response: any) => {
                if (response) {
                    const data = response.data;
                    this.$emit('remove',data);
                    this.formState.next({ type: 'remove', data: data });
                    this.data.ismodify = false;
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;' + (this.$t('app.formpage.deletesuccess') as string) });
                    AppCenterService.notifyMessage({name:"DictOption",action:'appRefresh',data:data});
                    resolve(response);
                }
            }).catch((error: any) => {
                const { data: _data } = error;
                this.$Notice.error({ title: _data.title, desc: _data.message });
                reject(error);
            });
        });
    }

    /**
     * 工作流启动
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async wfstart(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            const _this: any = this;
            const formData:any = this.getData();
            const copyData:any = Util.deepCopy(formData);
            const post: Promise<any> =  Object.is(formData.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),formData, this.showBusyIndicator,true):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),formData, this.showBusyIndicator,true);
            post.then((response:any) =>{
                const responseData:any = response.data;
                let tempResponseData:any = Util.deepCopy(response);
                this.service.handleResponse('save', tempResponseData);
                const arg:any = tempResponseData.data;
                // 保存完成UI处理
                this.onFormLoad(arg,'save');
                this.$emit('save', arg);
                AppCenterService.notifyMessage({name:"DictOption",action:'appRefresh',data:data});
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: arg });
                });
                // 准备工作流数据,填充未存库数据
                Object.assign(arg,copyData);
                // 准备提交参数
                if(this.viewparams){
                    let copyViewParams:any = Util.deepCopy(this.viewparams);
                    if(copyViewParams.w){
                        delete copyViewParams.w;
                    }
                    Object.assign(responseData,copyViewParams);
                }
                Object.assign(arg,{viewparams:responseData});
                // 强制补充srfwfmemo
                if(this.srfwfmemo){
                    Object.assign(arg,{srfwfmemo:this.srfwfmemo});
                }
                const result: Promise<any> = this.service.wfstart(_this.WFStartAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: (this.$t('app.formpage.workflow.starterror') as string) + ', ' + response.data.message });
                        }
                        return;
                    }
                    this.$Notice.info({ title: '', desc: (this.$t('app.formpage.workflow.startsuccess') as string) });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                        reject(response);
                        return;
                    }
                    reject(response);
            })
        });
    }

    /**
     * 工作流提交
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        const copyData:any = Util.deepCopy(arg);
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.dictoption || Object.is(arg.dictoption, '')) {
            return;
        }
        const post: Promise<any> = Object.is(arg.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,true):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,true);
        post.then((response:any) =>{
                const responseData:any = response.data;
                let tempResponseData:any = Util.deepCopy(response);
                this.service.handleResponse('save', tempResponseData);
                const arg:any = tempResponseData.data;
                // 保存完成UI处理
                this.onFormLoad(arg,'save');
                this.$emit('save', arg);
                AppCenterService.notifyMessage({name:"DictOption",action:'appRefresh',data:data});
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: arg });
                });
                // 准备工作流数据,填充未存库数据
                Object.assign(arg,copyData);
                // 准备提交参数
                if(this.viewparams){
                    Object.assign(responseData,this.viewparams);
                }
                Object.assign(arg,{viewparams:responseData});
                // 强制补充srfwfmemo
                if(this.srfwfmemo){
                    Object.assign(arg,{srfwfmemo:this.srfwfmemo});
                }
                const result: Promise<any> = this.service.wfsubmit(_this.WFSubmitAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: (this.$t('app.formpage.workflow.submiterror') as string) + ', ' + response.data.message });
                        }
                        return;
                    }
                    this.onFormLoad(arg,'submit');
                    this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                    this.$Notice.info({ title: '', desc: (this.$t('app.formpage.workflow.submitsuccess') as string) });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                        reject(response);
                        return;
                    }
                    reject(response);
            })
        })
    }

    /**
     * 面板行为
     *
     * @param {string} [action] 调用的实体行为
     * @param {string} [emitAction] 抛出行为
     * @param {*} [data={}] 传入数据
     * @param {boolean} [showloading] 是否显示加载状态
     * 
     * @memberof MainBase
     */
    public panelAction(action:string,emitAction:string,data:any ={},showloading?:boolean):void{
        if (!action || (action && Object.is(action, ''))) {
            return;
        }
        const arg: any = { ...data };
        const formdata = this.getValues();
        Object.assign(arg, formdata);
        Object.assign(arg,this.viewparams);
        const post: Promise<any> = this.service.frontLogic(action,JSON.parse(JSON.stringify(this.context)),arg, showloading);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                }
                return;
            }
            const data = response.data;
            this.onFormLoad(data,emitAction);
            this.$emit(emitAction, data);
            this.$nextTick(() => {
                this.formState.next({ type: emitAction, data: data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }
        });
    }

    /**
     * 表单项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof MainBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        if (!mode || (mode && Object.is(mode, ''))) {
            return;
        }
        const arg: any = { ...data };
        Object.assign(arg,this.viewparams);
        const post: Promise<any> = this.service.frontLogic(mode,JSON.parse(JSON.stringify(this.context)),arg, showloading);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.formpage.updateerror') as string) });
                return;
            }
            const data = response.data;
            const _data: any = {};
            updateDetails.forEach((name: string) => {
                if (!data.hasOwnProperty(name)) {
                    return;
                }
                Object.assign(_data, { [name]: data[name] });
            });
            this.setFormEnableCond(_data);
            this.fillForm(_data,'updateFormItem');
            this.formLogic({ name: '', newVal: null, oldVal: null });
            this.dataChang.next(JSON.stringify(this.data));
            AppCenterService.notifyMessage({name:"DictOption",action:'appRefresh',data:data});
            this.$nextTick(() => {
                this.formState.next({ type: 'updateformitem', ufimode: arg.srfufimode, data: _data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }
        });
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof MainBase
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public saveAndExit(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.currentAction = "saveAndExit";
            _this.save([arg]).then((res) =>{
                if(res){
                    _this.closeView(res.data);
                }
                resolve(res);
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
     * 保存并新建
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public saveAndNew(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.currentAction = "saveAndNew";
            _this.save([arg]).then((res) =>{
                _this.ResetData(res);
                _this.loadDraft({});
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
     * 删除并退出
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public removeAndExit(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.remove([arg]).then((res) =>{
                if(res){
                  _this.closeView(res.data);
                }
                resolve(res);
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
    * 关系界面数据保存完成
    *
    * @param {any} $event
    * @memberof MainBase
    */
    public drdatasaved($event:any){
        let _this = this;
        this.drcounter--;
        if(this.drcounter === 0){
            this.save(this.drsaveopt, undefined, false).then((res) =>{
                this.saveState(res);
                this.drsaveopt = {};
                if(Object.is(_this.currentAction, "saveAndNew")){
                    _this.ResetData(res);
                    _this.loadDraft({});
                }else if(Object.is(_this.currentAction, "saveAndExit")){
                    if(res){
                        _this.closeView(res.data);
                    }
                }
            });
        }
    }

    /**
     * 新建默认值
     * @memberof MainBase
     */
    public createDefault(){                    
    }

    /**
     * 更新默认值
     * @memberof MainBase
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './main-form.less';
</style>