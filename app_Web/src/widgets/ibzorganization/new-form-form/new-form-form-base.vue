<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='ibzorganization_newform' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group :uiService="appUIService" :data="transformData(data)" :manageContainerStatus="detailsModel.group1.manageContainerStatus"  :isManageContainer="detailsModel.group1.isManageContainer" @managecontainerclick="manageContainerClick('group1')" layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.ibzorganization.newform_form.details.group1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.orgcode.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='orgcode' :itemRules="this.rules.orgcode" class='' :caption="$t('entities.ibzorganization.newform_form.details.orgcode')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgcode.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.orgcode"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.orgcode.disabled" type='text'  style=""></input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.orgname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='orgname' :itemRules="this.rules.orgname" class='' :caption="$t('entities.ibzorganization.newform_form.details.orgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.orgname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.orgname.disabled" type='text'  style=""></input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.porgname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='porgname' :itemRules="this.rules.porgname" class='' :caption="$t('entities.ibzorganization.newform_form.details.porgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.porgname.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-org-select :data="data" :disabled="detailsModel.porgname.disabled" :context="JSON.parse(JSON.stringify(context))" :fillMap="{'id':'porgid','label':'porgname'}" url="/ibzorganizations/alls/suborg/picker" filter="srforgid" :multiple="false" style="" @select-change="onFormItemValueChange"></app-org-select>
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
import IBZOrganizationService from '@/service/ibzorganization/ibzorganization-service';
import NewFormService from './new-form-form-service';
import IBZOrganizationUIService from '@/uiservice/ibzorganization/ibzorganization-ui-service';
import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import schema from 'async-validator';


@Component({
    components: {
      
    }
})
export default class NewFormBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof NewFormBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof NewFormBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof NewFormBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof NewFormBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof NewFormBase
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof NewFormBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {NewFormService}
     * @memberof NewFormBase
     */
    public service: NewFormService = new NewFormService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {IBZOrganizationService}
     * @memberof NewFormBase
     */
    public appEntityService: IBZOrganizationService = new IBZOrganizationService({ $store: this.$store });
    


    /**
     * 转化数据
     *
     * @param {any} args
     * @memberof  NewFormBase
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
     * @memberof NewFormBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    @Inject({from:'navModel',default: 'tab'})
    public navModel!:string;

    /**
     * 界面UI服务对象
     *
     * @type {IBZOrganizationUIService}
     * @memberof NewFormBase
     */  
    public appUIService:IBZOrganizationUIService = new IBZOrganizationUIService(this.$store);

    /**
     * 工作流审批意见控件绑定值
     *
     * @memberof NewFormBase
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof NewFormBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof NewFormBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof NewFormBase
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof NewFormBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof NewFormBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof NewFormBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof NewFormBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof NewFormBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof NewFormBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof NewFormBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof NewFormBase
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
        orgcode: null,
        orgname: null,
        porgname: null,
        porgid: null,
        enable: null,
        orgid: null,
        ibzorganization:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof NewFormBase
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof NewFormBase
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof NewFormBase
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof NewFormBase
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof NewFormBase
     */
    public rules: any = {
        srfupdatedate: [
            { type: 'string', message: '最后修改时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '最后修改时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '最后修改时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '最后修改时间 值不能为空', trigger: 'blur' },
        ],
        srforikey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
            { type: 'string', message: '单位标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '单位标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '单位标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '单位标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '名称 值不能为空', trigger: 'blur' },
        ],
        srftempmode: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfuf: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfdeid: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfsourcekey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        orgcode: [
            { type: 'string', message: '单位代码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '单位代码 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '单位代码 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '单位代码 值不能为空', trigger: 'blur' },
        ],
        orgname: [
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '名称 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '名称 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '名称 值不能为空', trigger: 'blur' },
        ],
        porgname: [
            { type: 'string', message: '上级单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '上级单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '上级单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '上级单位 值不能为空', trigger: 'blur' },
        ],
        porgid: [
            { type: 'string', message: '上级单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '上级单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '上级单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '上级单位 值不能为空', trigger: 'blur' },
        ],
        enable: [
            { type: 'number', message: '逻辑有效 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '逻辑有效 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '逻辑有效 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '逻辑有效 值不能为空', trigger: 'blur' },
        ],
        orgid: [
            { type: 'string', message: '单位标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '单位标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '单位标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '单位标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof NewFormBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '单位机构基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: false, form: this, isControlledContent: false , uiActionGroup: { caption: '', langbase: 'entities.ibzorganization.newform_form', extractMode: 'ITEM', details: [] }, isManageContainer: false, showMoreModeItems: []  })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this, isControlledContent: false  })
, 
        srfupdatedate: new FormItemModel({ caption: '最后修改时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '单位标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 1 })
, 
        srfmajortext: new FormItemModel({ caption: '名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        orgcode: new FormItemModel({ caption: '单位代码', detailType: 'FORMITEM', name: 'orgcode', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 1 })
, 
        orgname: new FormItemModel({ caption: '名称', detailType: 'FORMITEM', name: 'orgname', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        porgname: new FormItemModel({ caption: '上级单位', detailType: 'FORMITEM', name: 'porgname', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        porgid: new FormItemModel({ caption: '上级单位', detailType: 'FORMITEM', name: 'porgid', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        enable: new FormItemModel({ caption: '逻辑有效', detailType: 'FORMITEM', name: 'enable', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 3 })
, 
        orgid: new FormItemModel({ caption: '单位标识', detailType: 'FORMITEM', name: 'orgid', visible: true, isShowCaption: true, form: this, isControlledContent: false , disabled: false, enableCond: 1 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgcode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NewFormBase
     */
    @Watch('data.orgcode')
    onOrgcodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgcode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NewFormBase
     */
    @Watch('data.orgname')
    onOrgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 porgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NewFormBase
     */
    @Watch('data.porgname')
    onPorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'porgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 porgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NewFormBase
     */
    @Watch('data.porgid')
    onPorgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'porgid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 enable 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NewFormBase
     */
    @Watch('data.enable')
    onEnableChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'enable', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof NewFormBase
     */
    @Watch('data.orgid')
    onOrgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 显示更多模式切换操作
     *
     * @type {string}
     * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    public async formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }){
                
















    }

    /**
     * 表单项检查逻辑
     *
     * @public
     * @param name 属性名
     * @memberof NewFormBase
     */
    public checkItem(name:string):Promise<any> {
        return new Promise((resolve, reject) => {
                var validator = new schema({[name]:this.rules[name]});
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.ibzorganization){
            Object.assign(this.context,{ibzorganization:data.ibzorganization})
        }
        this.setFormEnableCond(data);
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
     * @memberof NewFormBase
     */
    public fillForm(_datas: any = {},action:string): void {
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof NewFormBase
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
     * 设置数据项值
     *
     * @param {string} name
     * @param {*} value
     * @returns {void}
     * @memberof NewFormBase
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
     * 分组界面行为事件
     *
     * @param {*} $event
     * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof NewFormBase
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
                    if(this.context.srfsourcekey){
                        this.copy(this.context.srfsourcekey);
                    }else{
                        this.loadDraft(data);
                    }
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
     * @memberof NewFormBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof NewFormBase
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
     * 拷贝内容
     *
     * @param {*} [arg={}]
     * @memberof @memberof NewFormBase
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.ibzorganization = copyData.srfkey;
        copyData.orgid = copyData.srfkey;
        Object.assign(this.context,{ibzorganization:copyData.ibzorganization})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof NewFormBase
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'ibzorganization_newform',popTitle:'新建表单'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'IBZOrganizationOptionView' + (this.$t('app.formpage.notconfig.loadaction') as string) });
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
     * @memberof NewFormBase
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'IBZOrganizationOptionView' + (this.$t('app.formpage.notconfig.loaddraftaction') as string) });
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
     * @memberof NewFormBase
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
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'IBZOrganizationOptionView' + (this.$t('app.formpage.notconfig.actionname') as string) });
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
            AppCenterService.notifyMessage({name:"IBZOrganization",action:'appRefresh',data:data});
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
     * @memberof NewFormBase
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
            Object.assign(arg, data);
            Object.assign(arg, this.context);
            if (ifStateNext) {
                this.drcounter = 0;
                if(this.drcounter !== 0){
                    this.drsaveopt = opt;
                    this.formState.next({ type: 'beforesave', data: arg });//先通知关系界面保存
                    this.saveState = resolve;
                    return;
                }
            }
            const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
            if(!action){
                let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'IBZOrganizationOptionView' + (this.$t('app.formpage.notconfig.actionname') as string) });
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

                const data = response.data;
                this.onFormLoad(data,'save');
                this.$emit('save', data);
                AppCenterService.notifyMessage({name:"IBZOrganization",action:'appRefresh',data:data});
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
    * @memberof NewFormBase
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'IBZOrganizationOptionView' + (this.$t('app.formpage.notconfig.removeaction') as string) });
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
                    AppCenterService.notifyMessage({name:"IBZOrganization",action:'appRefresh',data:data});
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
     * @memberof NewFormBase
     */
    public async wfstart(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            const _this: any = this;
            const post: Promise<any> = _this.save({},false);
            post.then((response:any) =>{
                const arg:any = response.data;
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
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
     * @memberof NewFormBase
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.ibzorganization || Object.is(arg.ibzorganization, '')) {
            return;
        }
        const post: Promise<any> = Object.is(arg.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response:any) =>{
                const arg:any = response.data;
                // 保存完成UI处理
                this.onFormLoad(arg,'save');
                this.$emit('save', arg);
                AppCenterService.notifyMessage({name:"IBZOrganization",action:'appRefresh',data:data});
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: arg });
                });
                // 准备提交参数
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
                }
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
     * 表单项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof NewFormBase
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
            AppCenterService.notifyMessage({name:"IBZOrganization",action:'appRefresh',data:data});
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
     * @memberof NewFormBase
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
     * @memberof NewFormBase
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
    * @memberof NewFormBase
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
     * @memberof NewFormBase
     */
    public createDefault(){                    
        if (this.data.hasOwnProperty('enable')) {
            this.data['enable'] = 1;
        }
    }

    /**
     * 更新默认值
     * @memberof NewFormBase
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './new-form-form.less';
</style>