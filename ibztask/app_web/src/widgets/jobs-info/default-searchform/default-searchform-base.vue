<template>
    <i-form :model="this.data" class='app-search-form' ref='searchform' style="">
  <input style="display:none;"/>
  <row>
    <i-col span="20" class="form-content">
      <row>
                    <i-col v-show="detailsModel.n_app_like.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
              <app-form-item name='n_app_like' :itemRules="this.rules.n_app_like" class='' :caption="$t('entities.jobsinfo.default_searchform.details.n_app_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_app_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box 
              v-model="data.n_app_like"  
              @enter="onEnter($event)"  
                
              :disabled="detailsModel.n_app_like.disabled" 
              type='text' 
              style="">
          </input-box>
          
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_handler_like.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
              <app-form-item name='n_handler_like' :itemRules="this.rules.n_handler_like" class='' :caption="$t('entities.jobsinfo.default_searchform.details.n_handler_like')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_handler_like.error" :isEmptyCaption="false" labelPos="LEFT"> 
              <input-box 
              v-model="data.n_handler_like"  
              @enter="onEnter($event)"  
                
              :disabled="detailsModel.n_handler_like.disabled" 
              type='text' 
              style="">
          </input-box>
          
          </app-form-item>
          
          </i-col>
          <i-col v-show="detailsModel.n_status_eq.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
              <app-form-item name='n_status_eq' :itemRules="this.rules.n_status_eq" class='' :caption="$t('entities.jobsinfo.default_searchform.details.n_status_eq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.n_status_eq.error" :isEmptyCaption="false" labelPos="LEFT"> 
              
           <dropdown-list 
              v-model="data.n_status_eq" 
              :data="data" 
              :context="context"
              :viewparams="viewparams"
              :formState="formState" 
              :localContext ='{ }' 
              :localParam ='{ }' 
              :disabled="detailsModel.n_status_eq.disabled" 
              valueType="number"
              tag='CodeListJobStatus' 
              codelistType='STATIC'
              placeholder='请选择...' style="">
           </dropdown-list>
          
          </app-form-item>
          
          </i-col>
      </row>
    </i-col>
    <i-col span="4" class="search-button">
      <row v-show="Object.keys(data).length>0">
        <i-button class='search_reset'  size="default" type="primary"  @click="onSearch">{{$t('app.searchButton.search')}}</i-button>
        <i-button class='search_reset'  size="default"  @click="onReset">{{this.$t('app.searchButton.reset')}}</i-button>
      </row>
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
import JobsInfoEntityService from '@/service/jobs-info/jobs-info-service';
import DefaultService from './default-searchform-service';
import JobsInfoUIService from '@/uiservice/jobs-info/jobs-info-ui-service';
import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class DefaultBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof DefaultBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof DefaultBase
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof DefaultBase
     */
    @Prop() public viewparams!: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof DefaultBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof DefaultBase
     */
    public getControlType(): string {
        return 'SEARCHFORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof DefaultBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {DefaultService}
     * @memberof DefaultBase
     */
    public service: DefaultService = new DefaultService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {JobsInfoService}
     * @memberof DefaultBase
     */
    public appEntityService: JobsInfoEntityService = new JobsInfoEntityService({ $store: this.$store });
    


    /**
     * 转化数据
     *
     * @param {any} args
     * @memberof  DefaultBase
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
     * @memberof DefaultBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof DefaultBase
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
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof DefaultBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof DefaultBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof DefaultBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public loadAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof DefaultBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof DefaultBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof DefaultBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof DefaultBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof DefaultBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof DefaultBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public data: any = {
        n_app_like: null,
        n_handler_like: null,
        n_status_eq: null,
    };

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public detailsModel: any = {
        formpage1: new FormPageModel({ caption: '常规条件', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        n_app_like: new FormItemModel({ caption: '服务名(文本包含(%))', detailType: 'FORMITEM', name: 'n_app_like', visible: true, isShowCaption: true, form: this,required:false, disabled: false, enableCond: 3 })
, 
        n_handler_like: new FormItemModel({ caption: '执行器任务HANDLER(文本包含(%))', detailType: 'FORMITEM', name: 'n_handler_like', visible: true, isShowCaption: true, form: this,required:false, disabled: false, enableCond: 3 })
, 
        n_status_eq: new FormItemModel({ caption: '状态(等于(=))', detailType: 'FORMITEM', name: 'n_status_eq', visible: true, isShowCaption: true, form: this,required:false, disabled: false, enableCond: 3 })
, 
    };
    
    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof DefaultBase
     */
    public rules: any = {
        n_app_like: [
            { type: 'string', message: '服务名(文本包含(%)) 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '服务名(文本包含(%)) 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.n_app_like.required, type: 'string', message: '服务名(文本包含(%)) 值不能为空', trigger: 'change' },
            { required: this.detailsModel.n_app_like.required, type: 'string', message: '服务名(文本包含(%)) 值不能为空', trigger: 'blur' },
        ],
        n_handler_like: [
            { type: 'string', message: '执行器任务HANDLER(文本包含(%)) 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执行器任务HANDLER(文本包含(%)) 值必须为字符串类型', trigger: 'blur' },
            { required: this.detailsModel.n_handler_like.required, type: 'string', message: '执行器任务HANDLER(文本包含(%)) 值不能为空', trigger: 'change' },
            { required: this.detailsModel.n_handler_like.required, type: 'string', message: '执行器任务HANDLER(文本包含(%)) 值不能为空', trigger: 'blur' },
        ],
        n_status_eq: [
            { type: 'number', message: '状态(等于(=)) 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '状态(等于(=)) 值必须为数值类型', trigger: 'blur' },
            { required: this.detailsModel.n_status_eq.required, type: 'number', message: '状态(等于(=)) 值不能为空', trigger: 'change' },
            { required: this.detailsModel.n_status_eq.required, type: 'number', message: '状态(等于(=)) 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 监控表单属性 n_app_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_app_like')
    onN_app_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_app_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_handler_like 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_handler_like')
    onN_handler_likeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_handler_like', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 n_status_eq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof DefaultBase
     */
    @Watch('data.n_status_eq')
    onN_status_eqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'n_status_eq', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof DefaultBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof DefaultBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                




    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof DefaultBase
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
     * @memberof DefaultBase
     */
    public onFormLoad(data: any = {},action:string): void {
        this.setFormEnableCond(data);
        this.fillForm(data,action);
        this.formLogic({ name: '', newVal: null, oldVal: null });
    }

    /**
     * 值填充
     *
     * @param {*} [_datas={}]
     * @param {string} [action]
     * @memberof DefaultBase
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
        this.$nextTick(function () {
            this.ignorefieldvaluechange = false;
        })
    }

    /**
     * 设置表单项是否启用
     *
     * @public
     * @param {*} data
     * @memberof DefaultBase
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
     * 新建默认值
     * @memberof DefaultBase
     */
    public createDefault(){                    
    }

    /**
     * 重置草稿表单状态
     *
     * @public
     * @memberof DefaultBase
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
     * @memberof DefaultBase
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
     * @memberof DefaultBase
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
     * @memberof DefaultBase
     */
    public formValidateStatus(): boolean {
        const form: any = this.$refs.searchform;
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
     * @memberof DefaultBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof DefaultBase
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
     * @memberof DefaultBase
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
     * @memberof DefaultBase
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
     * @memberof DefaultBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof DefaultBase
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
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof DefaultBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof DefaultBase
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
     * 自动加载
     *
     * @param {*} [arg={}]
     * @returns {void}
     * @memberof DefaultBase
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
     * @memberof DefaultBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'JobsInfoGridView' + (this.$t('app.searchForm.notConfig.loadAction') as string) });
            return;
        }
        const arg: any = { ...opt };
        Object.assign(arg,{viewparams:this.viewparams});
        const get: Promise<any> = this.service.get(this.loadAction,JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        get.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                this.$emit('load', data);
                this.$nextTick(() => {
                    this.formState.next({ type: 'load', data: data });
                });
            }
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }

            const { data: _data } = response;
            this.$Notice.error({ title: _data.title, desc: _data.message });
        });
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof DefaultBase
     */
    public loadDraft(opt: any = {},mode?:string): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'JobsInfoGridView' + (this.$t('app.searchForm.notConfig.loaddraftAction') as string) });
            return;
        }
        const arg: any = { ...opt } ;
        Object.assign(arg,{viewparams:this.viewparams});
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction,JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data && response.data.message) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            this.resetDraftFormStates();
            this.onFormLoad(data,'loadDraft');
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
            if(Object.is(mode,'RESET')){
                if (!this.formValidateStatus()) {
                    return;
                }
            }
            this.$emit('load', data);
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }

            const { data: _data } = response;
            this.$Notice.error({ title: _data.title, desc: _data.message });
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
     * @memberof DefaultBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof DefaultBase
     */
    public onEnter($event: any): void {
        if (!this.formValidateStatus()) {
            return;
        }
        this.$emit('search', this.data);
    }

    /**
     * 搜索
     *
     * @memberof DefaultBase
     */
    public onSearch() {
        if (!this.formValidateStatus()) {
            return;
        }
        this.$emit('search', this.data);
    }

    /**
     * 重置
     *
     * @memberof DefaultBase
     */
    public onReset() {
        this.loadDraft({},'RESET');
    }
}
</script>

<style lang='less'>
@import './default-searchform.less';
</style>