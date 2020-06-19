<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='jobsinfo_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.jobsinfo.main_form.details.group1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.app.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='app' :itemRules="this.rules.app" class='' :caption="$t('entities.jobsinfo.main_form.details.app')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.app.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.app"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.app.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.handler.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='handler' :itemRules="this.rules.handler" class='' :caption="$t('entities.jobsinfo.main_form.details.handler')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.handler.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.handler"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.handler.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.cron.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='cron' :itemRules="this.rules.cron" class='' :caption="$t('entities.jobsinfo.main_form.details.cron')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.cron.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.cron"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.cron.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.param.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='param' :itemRules="this.rules.param" class='' :caption="$t('entities.jobsinfo.main_form.details.param')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.param.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.param" :autoSize="{minRows: 10}"  :disabled="detailsModel.param.disabled" type='textarea' style="height:200px;" ></input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.last_time.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='last_time' :itemRules="this.rules.last_time" class='' :caption="$t('entities.jobsinfo.main_form.details.last_time')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.last_time.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.last_time"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.last_time.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.next_time.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='next_time' :itemRules="this.rules.next_time" class='' :caption="$t('entities.jobsinfo.main_form.details.next_time')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.next_time.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.next_time"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.next_time.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.timeout.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='timeout' :itemRules="this.rules.timeout" class='' :caption="$t('entities.jobsinfo.main_form.details.timeout')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.timeout.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.timeout"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.timeout.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fail_retry_count.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='fail_retry_count' :itemRules="this.rules.fail_retry_count" class='' :caption="$t('entities.jobsinfo.main_form.details.fail_retry_count')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fail_retry_count.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.fail_retry_count"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.fail_retry_count.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.author.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='author' :itemRules="this.rules.author" class='' :caption="$t('entities.jobsinfo.main_form.details.author')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.author.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.author"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.author.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.remark.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='remark' :itemRules="this.rules.remark" class='' :caption="$t('entities.jobsinfo.main_form.details.remark')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.remark.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.remark"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.remark.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.status.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='status' :itemRules="this.rules.status" class='' :caption="$t('entities.jobsinfo.main_form.details.status')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.status.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.status" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.status.disabled"  
    tag='CodeListJobStatus' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.tenant_id.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='tenant_id' :itemRules="this.rules.tenant_id" class='' :caption="$t('entities.jobsinfo.main_form.details.tenant_id')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.tenant_id.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.tenant_id"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.tenant_id.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.create_time.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='create_time' :itemRules="this.rules.create_time" class='' :caption="$t('entities.jobsinfo.main_form.details.create_time')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.create_time.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='create_time' :value="data.create_time" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.update_time.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='update_time' :itemRules="this.rules.update_time" class='' :caption="$t('entities.jobsinfo.main_form.details.update_time')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.update_time.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-span name='update_time' :value="data.update_time" :data="data" :context="context" :viewparams="viewparams" :localContext ='{ }'  :localParam ='{ }'  style=""></app-span>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>


    </row>
</i-form>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import JobsInfoService from '@/service/jobs-info/jobs-info-service';
import MainService from './main-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class MainBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof Main
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof Main
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof Main
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof Main
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof Main
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {MainService}
     * @memberof Main
     */
    public service: MainService = new MainService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {JobsInfoService}
     * @memberof Main
     */
    public appEntityService: JobsInfoService = new JobsInfoService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof Main
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof Main
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
     * 工作流审批意见控件绑定值
     *
     * @memberof Main
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof Main
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof Main
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof Main
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof Main
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof Main
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof Main
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof Main
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof Main
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof Main
     */
    public data: any = {
        srforikey: null,
        srfkey: null,
        srfmajortext: null,
        srftempmode: null,
        srfuf: null,
        srfdeid: null,
        srfsourcekey: null,
        app: null,
        handler: null,
        cron: null,
        param: null,
        last_time: null,
        next_time: null,
        timeout: null,
        fail_retry_count: null,
        author: null,
        remark: null,
        status: null,
        tenant_id: null,
        create_time: null,
        update_time: null,
        id: null,
        jobsinfo:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof Main
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof Main
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof Main
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof Main
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof Main
     */
    public rules: any = {
        srforikey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
            { type: 'string', message: '主键ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '主键ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '主键ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '主键ID 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '执行器任务HANDLER 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执行器任务HANDLER 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执行器任务HANDLER 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执行器任务HANDLER 值不能为空', trigger: 'blur' },
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
        app: [
            { type: 'string', message: '服务名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '服务名 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '服务名 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '服务名 值不能为空', trigger: 'blur' },
        ],
        handler: [
            { type: 'string', message: '执行器任务HANDLER 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执行器任务HANDLER 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执行器任务HANDLER 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执行器任务HANDLER 值不能为空', trigger: 'blur' },
        ],
        cron: [
            { type: 'string', message: '任务执行CRON 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '任务执行CRON 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '任务执行CRON 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '任务执行CRON 值不能为空', trigger: 'blur' },
        ],
        param: [
            { type: 'string', message: '执行器任务参数 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执行器任务参数 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执行器任务参数 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执行器任务参数 值不能为空', trigger: 'blur' },
        ],
        last_time: [
            { type: 'number', message: '上次调度时间 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '上次调度时间 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '上次调度时间 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '上次调度时间 值不能为空', trigger: 'blur' },
        ],
        next_time: [
            { type: 'number', message: '下次调度时间 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '下次调度时间 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '下次调度时间 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '下次调度时间 值不能为空', trigger: 'blur' },
        ],
        timeout: [
            { type: 'number', message: '任务执行超时时间（秒） 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '任务执行超时时间（秒） 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '任务执行超时时间（秒） 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '任务执行超时时间（秒） 值不能为空', trigger: 'blur' },
        ],
        fail_retry_count: [
            { type: 'number', message: '失败重试次数 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '失败重试次数 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '失败重试次数 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '失败重试次数 值不能为空', trigger: 'blur' },
        ],
        author: [
            { type: 'string', message: '所有者 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所有者 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所有者 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所有者 值不能为空', trigger: 'blur' },
        ],
        remark: [
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'blur' },
        ],
        status: [
            { type: 'number', message: '状态 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '状态 值必须为数值类型', trigger: 'blur' },
            { required: true, type: 'number', message: '状态 值不能为空', trigger: 'change' },
            { required: true, type: 'number', message: '状态 值不能为空', trigger: 'blur' },
        ],
        tenant_id: [
            { type: 'string', message: '租户ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '租户ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '租户ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '租户ID 值不能为空', trigger: 'blur' },
        ],
        create_time: [
            { type: 'string', message: '创建时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '创建时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '创建时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '创建时间 值不能为空', trigger: 'blur' },
        ],
        update_time: [
            { type: 'string', message: '更新时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '更新时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '更新时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '更新时间 值不能为空', trigger: 'blur' },
        ],
        id: [
            { type: 'string', message: '主键ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '主键ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '主键ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '主键ID 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof Main
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '任务信息基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.jobsinfo.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '主键ID', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '执行器任务HANDLER', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        app: new FormItemModel({ caption: '服务名', detailType: 'FORMITEM', name: 'app', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        handler: new FormItemModel({ caption: '执行器任务HANDLER', detailType: 'FORMITEM', name: 'handler', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        cron: new FormItemModel({ caption: '任务执行CRON', detailType: 'FORMITEM', name: 'cron', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        param: new FormItemModel({ caption: '执行器任务参数', detailType: 'FORMITEM', name: 'param', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        last_time: new FormItemModel({ caption: '上次调度时间', detailType: 'FORMITEM', name: 'last_time', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        next_time: new FormItemModel({ caption: '下次调度时间', detailType: 'FORMITEM', name: 'next_time', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        timeout: new FormItemModel({ caption: '任务执行超时时间（秒）', detailType: 'FORMITEM', name: 'timeout', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fail_retry_count: new FormItemModel({ caption: '失败重试次数', detailType: 'FORMITEM', name: 'fail_retry_count', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        author: new FormItemModel({ caption: '所有者', detailType: 'FORMITEM', name: 'author', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        remark: new FormItemModel({ caption: '备注', detailType: 'FORMITEM', name: 'remark', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        status: new FormItemModel({ caption: '状态', detailType: 'FORMITEM', name: 'status', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        tenant_id: new FormItemModel({ caption: '租户ID', detailType: 'FORMITEM', name: 'tenant_id', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        create_time: new FormItemModel({ caption: '创建时间', detailType: 'FORMITEM', name: 'create_time', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        update_time: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'update_time', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        id: new FormItemModel({ caption: '主键ID', detailType: 'FORMITEM', name: 'id', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srforikey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 app 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.app')
    onAppChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'app', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 handler 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.handler')
    onHandlerChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'handler', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cron 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.cron')
    onCronChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'cron', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 param 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.param')
    onParamChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'param', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 last_time 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.last_time')
    onLast_timeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'last_time', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 next_time 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.next_time')
    onNext_timeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'next_time', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 timeout 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.timeout')
    onTimeoutChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'timeout', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fail_retry_count 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.fail_retry_count')
    onFail_retry_countChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fail_retry_count', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 author 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.author')
    onAuthorChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'author', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 remark 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.remark')
    onRemarkChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'remark', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 status 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.status')
    onStatusChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'status', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 tenant_id 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.tenant_id')
    onTenant_idChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'tenant_id', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 create_time 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.create_time')
    onCreate_timeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'create_time', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 update_time 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.update_time')
    onUpdate_timeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'update_time', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 id 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
     */
    @Watch('data.id')
    onIdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'id', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof Main
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
      * @memberof EditForm
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
     * @memberof Main
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                
























    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof Main
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
     * @memberof Main
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.jobsinfo){
            Object.assign(this.context,{jobsinfo:data.jobsinfo})
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof Main
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
     * @memberof Main
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof Main
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
     * @memberof @memberof Main
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.jobsinfo = copyData.srfkey;
        copyData.id = copyData.srfkey;
        Object.assign(this.context,{jobsinfo:copyData.jobsinfo})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof Main
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'jobsinfo_main',popTitle:'主编辑表单'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'JobsInfoEditView视图表单loadAction参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof Main
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'JobsInfoEditView视图表单loaddraftAction参数未配置' });
            return;
        }
        const arg: any = { ...opt } ;
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            if(data.jobsinfo){
                Object.assign(this.context,{jobsinfo:data.jobsinfo})
            }
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
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 自动保存
     *
     * @param {*} [opt={}]
     * @memberof Main
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
            this.$Notice.error({ title: '错误', desc: 'JobsInfoEditView视图表单'+actionName+'参数未配置' });
            return;
        }
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.add(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            this.onFormLoad(data,'autoSave');
            this.$emit('save', data);
            this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
            this.$nextTick(() => {
                this.formState.next({ type: 'save', data: data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
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
     * @memberof Main
     */
    public async save(opt: any = {}, showResultInfo?: boolean, ifStateNext: boolean = true): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            showResultInfo = showResultInfo === undefined ? true : false;
            if (!this.formValidateStatus()) {
                this.$Notice.error({ title: '错误', desc: '值规则校验异常' });
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
                this.$Notice.error({ title: '错误', desc: 'JobsInfoEditView视图表单'+actionName+'参数未配置' });
                return;
            }
            Object.assign(arg,{viewparams:this.viewparams});
            const post: Promise<any> = Object.is(data.srfuf, '1')?this.service.update(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(action,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
            post.then((response: any) => {
                if (!response.status || response.status !== 200) {
                    if (response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                    }
                    return;
                }

                const data = response.data;
                this.onFormLoad(data,'save');
                this.$emit('save', data);
                this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: data });
                });
                if (showResultInfo) {
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;保存成功！' });
                }
                resolve(response);
            }).catch((response: any) => {
                if (response && response.status  && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
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
    * @memberof EditForm
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'JobsInfoEditView视图表单removeAction参数未配置' });
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
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;删除成功！' });
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
     * @memberof Main
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
                            this.$Notice.error({ title: '', desc: '工作流启动失败, ' + response.data.message });
                        }
                        return;
                    }
                    this.$Notice.info({ title: '', desc: '工作流启动成功' });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
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
     * @memberof Main
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.jobsinfo || Object.is(arg.jobsinfo, '')) {
            return;
        }
        const post: Promise<any> = Object.is(arg.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response:any) =>{
                const arg:any = response.data;
                // 保存完成UI处理
                this.onFormLoad(arg,'save');
                this.$emit('save', arg);
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
                            this.$Notice.error({ title: '', desc: '工作流提交失败, ' + response.data.message });
                        }
                        return;
                    }
                    this.onFormLoad(arg,'submit');
                    this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                    this.$Notice.info({ title: '', desc: '工作流提交成功' });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
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
     * @memberof Main
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
                this.$Notice.error({ title: '错误', desc: '表单项更新失败' });
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
            this.$nextTick(() => {
                this.formState.next({ type: 'updateformitem', ufimode: arg.srfufimode, data: _data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof Main
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
    * @memberof Main
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
     * @memberof Main
     */
    public createDefault(){                    
    }

    /**
     * 更新默认值
     * @memberof Main
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './main-form.less';
</style>