<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='sysemployee_main' style="" @on-validate="formItemValidate">
    <input style="display:none;" />
    <row >
            <i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group :uiService="appUIService" :data="transformData(data)" :manageContainerStatus="detailsModel.group1.manageContainerStatus"  :isManageContainer="detailsModel.group1.isManageContainer" @managecontainerclick="manageContainerClick('group1')" layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.sysemployee.main_form.details.group1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.usercode.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='usercode' :itemRules="this.rules().usercode" class='' :caption="$t('entities.sysemployee.main_form.details.usercode')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.usercode.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.usercode"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.usercode.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.personname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='personname' :itemRules="this.rules().personname" class='' :caption="$t('entities.sysemployee.main_form.details.personname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.personname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.personname"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.personname.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.loginname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='loginname' :itemRules="this.rules().loginname" class='' :caption="$t('entities.sysemployee.main_form.details.loginname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.loginname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.loginname"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.loginname.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 24, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-group :uiService="appUIService" :data="transformData(data)" :manageContainerStatus="detailsModel.grouppanel1.manageContainerStatus"  :isManageContainer="detailsModel.grouppanel1.isManageContainer" @managecontainerclick="manageContainerClick('grouppanel1')" layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.sysemployee.main_form.details.grouppanel1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.orgname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='orgname' :itemRules="this.rules().orgname" class='' :caption="$t('entities.sysemployee.main_form.details.orgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgname.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-org-select :data="data" :disabled="detailsModel.orgname.disabled" :context="JSON.parse(JSON.stringify(context))" :fillMap="{id:'orgid','label':'orgname','code':'orgcode'}" url="/sysorganizations/alls/suborg/picker" filter="srforgid" :multiple="false" style="" @select-change="onFormItemValueChange" ></app-org-select>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.mdeptname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='mdeptname' :itemRules="this.rules().mdeptname" class='' :caption="$t('entities.sysemployee.main_form.details.mdeptname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.mdeptname.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-department-select :data="data" :disabled="detailsModel.mdeptname.disabled" :context="JSON.parse(JSON.stringify(context))" url="/sysorganizations/${orgid}/sysdepartments/picker" filter="orgid"  :fillMap="{id:'mdeptid','label':'mdeptname','code':'mdeptcode','bcode':'bcode'}" :multiple="false" style="" @select-change="onFormItemValueChange" ></app-department-select>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.bcode.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='bcode' :itemRules="this.rules().bcode" class='' :caption="$t('entities.sysemployee.main_form.details.bcode')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bcode.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.bcode"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.bcode.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.nickname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='nickname' :itemRules="this.rules().nickname" class='' :caption="$t('entities.sysemployee.main_form.details.nickname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nickname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.nickname"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.nickname.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.sex.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='sex' :itemRules="this.rules().sex" class='' :caption="$t('entities.sysemployee.main_form.details.sex')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sex.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.sex" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :formState="formState" 
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.sex.disabled" 
    valueType="string"
    tag='CLSYS_Sex' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.birthday.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='birthday' :itemRules="this.rules().birthday" class='' :caption="$t('entities.sysemployee.main_form.details.birthday')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.birthday.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.birthday" :disabled="detailsModel.birthday.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.birthday = val1 }"></date-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.certcode.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='certcode' :itemRules="this.rules().certcode" class='' :caption="$t('entities.sysemployee.main_form.details.certcode')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.certcode.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.certcode"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.certcode.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.phone.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='phone' :itemRules="this.rules().phone" class='' :caption="$t('entities.sysemployee.main_form.details.phone')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.phone.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.phone"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.phone.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.avatar.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='avatar' :itemRules="this.rules().avatar" class='' :caption="$t('entities.sysemployee.main_form.details.avatar')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.avatar.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.avatar"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.avatar.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.email.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='email' :itemRules="this.rules().email" class='' :caption="$t('entities.sysemployee.main_form.details.email')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.email.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.email"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.email.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.ipaddr.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='ipaddr' :itemRules="this.rules().ipaddr" class='' :caption="$t('entities.sysemployee.main_form.details.ipaddr')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ipaddr.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.ipaddr"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.ipaddr.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.showorder.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='showorder' :itemRules="this.rules().showorder" class='' :caption="$t('entities.sysemployee.main_form.details.showorder')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.showorder.error" :isEmptyCaption="false" labelPos="LEFT">
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
<i-col v-show="detailsModel.addr.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='addr' :itemRules="this.rules().addr" class='' :caption="$t('entities.sysemployee.main_form.details.addr')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.addr.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.addr"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.addr.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.memo.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='memo' :itemRules="this.rules().memo" class='' :caption="$t('entities.sysemployee.main_form.details.memo')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.memo.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.memo"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.memo.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.theme.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='theme' :itemRules="this.rules().theme" class='' :caption="$t('entities.sysemployee.main_form.details.theme')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.theme.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.theme"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.theme.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.lang.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='lang' :itemRules="this.rules().lang" class='' :caption="$t('entities.sysemployee.main_form.details.lang')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lang.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.lang"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.lang.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.fontsize.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='fontsize' :itemRules="this.rules().fontsize" class='' :caption="$t('entities.sysemployee.main_form.details.fontsize')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fontsize.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.fontsize"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.fontsize.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.reserver.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='reserver' :itemRules="this.rules().reserver" class='' :caption="$t('entities.sysemployee.main_form.details.reserver')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.reserver.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box 
    v-model="data.reserver"  
    @enter="onEnter($event)"  
     unit=""  
    :disabled="detailsModel.reserver.disabled" 
    type='text' 
    style="">
</input-box>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.grouppanel2.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 24, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-group :uiService="appUIService" :data="transformData(data)" :manageContainerStatus="detailsModel.grouppanel2.manageContainerStatus"  :isManageContainer="detailsModel.grouppanel2.isManageContainer" @managecontainerclick="manageContainerClick('grouppanel2')" layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.sysemployee.main_form.details.grouppanel2')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
            
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.usericon.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='usericon' :itemRules="this.rules().usericon" class='' :caption="$t('entities.sysemployee.main_form.details.usericon')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.usericon.error" :isEmptyCaption="false" labelPos="LEFT">
     <app-image-upload :multiple="false" :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='usericon' :value="data.usericon" :disabled="detailsModel.usericon.disabled" :uploadparams='{}' :exportparams='{}' ></app-image-upload>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.druipart1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-druipart
    
    :formState="formState"
    :isForbidLoad="this.data.srfuf === '0'"
    paramItem='sysemployee' 
    :parentdata='{"srfparentdefname":"USERID","srfparentdename":"SYS_EMP","SRFPARENTTYPE":"DER1N","srfparentmode":"DER1N_SYS_DEPTMEMBER_SYS_EMP_USERID","SRFDER1NID":"DER1N_SYS_DEPTMEMBER_SYS_EMP_USERID"}'
    :parameters="[
        { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
    ]"
    :context="context"
    :viewparams="viewparams"
    :localContext ='{}'
    :localParam ='{}'
    parameterName='sysemployee'
    parentName="SysEmployee"  
    refviewtype='DEGRIDVIEW' 
    refreshitems='' 
    :ignorefieldvaluechange="ignorefieldvaluechange"
    viewname='sys-dept-member-grid-view'
    tempMode='0'
    :data="JSON.stringify(this.data)" 
    @drdatasaved="drdatasaved($event)"
    style=";overflow: auto;">
</app-form-druipart>

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
import SysEmployeeService from '@/service/sys-employee/sys-employee-service';
import MainService from './main-form-service';
import SysEmployeeUIService from '@/uiservice/sys-employee/sys-employee-ui-service';
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
     * @type {SysEmployeeService}
     * @memberof MainBase
     */
    public appEntityService: SysEmployeeService = new SysEmployeeService({ $store: this.$store });
    


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
     * 主键表单项名称
     *
     * @protected
     * @type {string}
     * @memberof MainBase
     */
    public formKeyItemName: string = '';

    /**
     * 界面UI服务对象
     *
     * @type {SysEmployeeUIService}
     * @memberof MainBase
     */  
    public appUIService:SysEmployeeUIService = new SysEmployeeUIService(this.$store);

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
     * 表单项校验错误提示信息
     * 
     *  @memberof  MainBase
     */
    public errorMessages: Array<any> = [];   

    /**
     * 设置表单项错误提示信息
     * 
     * @param {*} prop 表单项字段名
     * @param {*} status 校验状态
     * @param {*} error 错误信息
     * @memberof MainBase
     */
    public formItemValidate(prop: string,status: boolean, error: string){
        error = error ? error : '';
        if(this.errorMessages && this.errorMessages.length > 0){
            const index = this.errorMessages.findIndex((errorMessage:any) => Object.is(errorMessage.prop,prop));
            if(index != -1){
                this.errorMessages[index].error = error;
            }else{
                this.errorMessages.push({prop: prop,error: error});
            }
        }else{
            this.errorMessages.push({prop: prop,error: error});
        }
    }

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
        usercode: null,
        personname: null,
        loginname: null,
        orgid: null,
        orgname: null,
        mdeptid: null,
        pdeptcheck: null,
        mdeptname: null,
        mdeptcode: null,
        orgcode: null,
        bcode: null,
        nickname: null,
        sex: null,
        birthday: null,
        certcode: null,
        phone: null,
        avatar: null,
        email: null,
        ipaddr: null,
        showorder: null,
        addr: null,
        memo: null,
        theme: null,
        lang: null,
        fontsize: null,
        reserver: null,
        usericon: null,
        userid: null,
        sysemployee:null,
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
     * 主信息属性映射表单项名称
     *
     * @type {string}
     * @memberof MainBase
     */
    public majorMessageField: string = "personname";

    /**
     * 值规则
     *
     * @type {*}
     * @memberof MainBase
     */
    public rules() :any {
    return {
        usercode: [
            { required: this.detailsModel.usercode.required, type: 'string', message: '用户工号 值不能为空', trigger: 'change' },
            { required: this.detailsModel.usercode.required, type: 'string', message: '用户工号 值不能为空', trigger: 'blur' },
        ],
        personname: [
            { required: this.detailsModel.personname.required, type: 'string', message: '姓名 值不能为空', trigger: 'change' },
            { required: this.detailsModel.personname.required, type: 'string', message: '姓名 值不能为空', trigger: 'blur' },
        ],
        loginname: [
            { required: this.detailsModel.loginname.required, type: 'string', message: '登录名 值不能为空', trigger: 'change' },
            { required: this.detailsModel.loginname.required, type: 'string', message: '登录名 值不能为空', trigger: 'blur' },
        ],
        orgname: [
            { required: this.detailsModel.orgname.required, type: 'string', message: '单位 值不能为空', trigger: 'change' },
            { required: this.detailsModel.orgname.required, type: 'string', message: '单位 值不能为空', trigger: 'blur' },
        ],
        mdeptname: [
            { required: this.detailsModel.mdeptname.required, type: 'string', message: '部门 值不能为空', trigger: 'change' },
            { required: this.detailsModel.mdeptname.required, type: 'string', message: '部门 值不能为空', trigger: 'blur' },
        ],
        bcode: [
            { required: this.detailsModel.bcode.required, type: 'string', message: '业务编码 值不能为空', trigger: 'change' },
            { required: this.detailsModel.bcode.required, type: 'string', message: '业务编码 值不能为空', trigger: 'blur' },
        ],
        nickname: [
            { required: this.detailsModel.nickname.required, type: 'string', message: '昵称别名 值不能为空', trigger: 'change' },
            { required: this.detailsModel.nickname.required, type: 'string', message: '昵称别名 值不能为空', trigger: 'blur' },
        ],
        sex: [
            { required: this.detailsModel.sex.required, type: 'string', message: '性别 值不能为空', trigger: 'change' },
            { required: this.detailsModel.sex.required, type: 'string', message: '性别 值不能为空', trigger: 'blur' },
        ],
        birthday: [
            { required: this.detailsModel.birthday.required, type: 'string', message: '出生日期 值不能为空', trigger: 'change' },
            { required: this.detailsModel.birthday.required, type: 'string', message: '出生日期 值不能为空', trigger: 'blur' },
        ],
        certcode: [
            { required: this.detailsModel.certcode.required, type: 'string', message: '证件号码 值不能为空', trigger: 'change' },
            { required: this.detailsModel.certcode.required, type: 'string', message: '证件号码 值不能为空', trigger: 'blur' },
        ],
        phone: [
            { required: this.detailsModel.phone.required, type: 'string', message: '联系方式 值不能为空', trigger: 'change' },
            { required: this.detailsModel.phone.required, type: 'string', message: '联系方式 值不能为空', trigger: 'blur' },
        ],
        avatar: [
            { required: this.detailsModel.avatar.required, type: 'string', message: '社交账号 值不能为空', trigger: 'change' },
            { required: this.detailsModel.avatar.required, type: 'string', message: '社交账号 值不能为空', trigger: 'blur' },
        ],
        email: [
            { required: this.detailsModel.email.required, type: 'string', message: '邮件 值不能为空', trigger: 'change' },
            { required: this.detailsModel.email.required, type: 'string', message: '邮件 值不能为空', trigger: 'blur' },
        ],
        ipaddr: [
            { required: this.detailsModel.ipaddr.required, type: 'string', message: 'ip地址 值不能为空', trigger: 'change' },
            { required: this.detailsModel.ipaddr.required, type: 'string', message: 'ip地址 值不能为空', trigger: 'blur' },
        ],
        showorder: [
            { required: this.detailsModel.showorder.required, type: 'number', message: '排序 值不能为空', trigger: 'change' },
            { required: this.detailsModel.showorder.required, type: 'number', message: '排序 值不能为空', trigger: 'blur' },
        ],
        addr: [
            { required: this.detailsModel.addr.required, type: 'string', message: '地址 值不能为空', trigger: 'change' },
            { required: this.detailsModel.addr.required, type: 'string', message: '地址 值不能为空', trigger: 'blur' },
        ],
        memo: [
            { required: this.detailsModel.memo.required, type: 'string', message: '备注 值不能为空', trigger: 'change' },
            { required: this.detailsModel.memo.required, type: 'string', message: '备注 值不能为空', trigger: 'blur' },
        ],
        theme: [
            { required: this.detailsModel.theme.required, type: 'string', message: '样式 值不能为空', trigger: 'change' },
            { required: this.detailsModel.theme.required, type: 'string', message: '样式 值不能为空', trigger: 'blur' },
        ],
        lang: [
            { required: this.detailsModel.lang.required, type: 'string', message: '语言 值不能为空', trigger: 'change' },
            { required: this.detailsModel.lang.required, type: 'string', message: '语言 值不能为空', trigger: 'blur' },
        ],
        fontsize: [
            { required: this.detailsModel.fontsize.required, type: 'string', message: '字号 值不能为空', trigger: 'change' },
            { required: this.detailsModel.fontsize.required, type: 'string', message: '字号 值不能为空', trigger: 'blur' },
        ],
        reserver: [
            { required: this.detailsModel.reserver.required, type: 'string', message: '保留 值不能为空', trigger: 'change' },
            { required: this.detailsModel.reserver.required, type: 'string', message: '保留 值不能为空', trigger: 'blur' },
        ],
        usericon: [
            { required: this.detailsModel.usericon.required, type: 'string', message: '照片 值不能为空', trigger: 'change' },
            { required: this.detailsModel.usericon.required, type: 'string', message: '照片 值不能为空', trigger: 'blur' },
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
                    falg.isPast = falg.isPast && val;
                }else{
                    falg.isPast = falg.isPast || val;
                }
            }else{
                falg.isPast = val;
            }
        }
        for(let i=0;i<rule[name].length;i++){
            let item:any = rule[name][i];
            let dataValue = item.deName?this.data[this.service.getItemNameByDeName(item.deName)]:"";
            item.ruleInfo = item.ruleInfo ? item.ruleInfo : this.$t('app.formpage.valuecheckex');
            if((dataValue === null || dataValue === undefined || dataValue === "") && (item.type != 'GROUP')){
                startOp(true);
                return falg;
            }
            // 常规规则
            if(item.type == 'SIMPLE'){
                startOp(!this.$verify.checkFieldSimpleRule(dataValue,item.condOP,item.paramValue,item.ruleInfo,item.paramType,this.data,item.isKeyCond));
                falg.infoMessage = item.ruleInfo;
                if(!falg.isPast) return falg;
            }
            // 数值范围
            if(item.type == 'VALUERANGE2'){
                startOp( !this.$verify.checkFieldValueRangeRule(dataValue,item.minValue,item.isIncludeMinValue,item.maxValue,item.isIncludeMaxValue,item.ruleInfo,item.isKeyCond));
                falg.infoMessage = item.ruleInfo;
                if(!falg.isPast) return falg;
            }
            // 正则式
            if (item.type == "REGEX") {
                startOp(!this.$verify.checkFieldRegExRule(dataValue,item.regExCode,item.ruleInfo,item.isKeyCond));
                falg.infoMessage = item.ruleInfo;
                if(!falg.isPast) return falg;
            }
            // 长度
            if (item.type == "STRINGLENGTH") {
                startOp(!this.$verify.checkFieldStringLengthRule(dataValue,item.minValue,item.isIncludeMinValue,item.maxValue,item.isIncludeMaxValue,item.ruleInfo,item.isKeyCond)); 
                falg.infoMessage = item.ruleInfo;
                if(!falg.isPast) return falg;
            }
            // 系统值规则
            if(item.type == "SYSVALUERULE") {
                startOp(!this.$verify.checkFieldSysValueRule(dataValue,item.sysRule.regExCode,item.ruleInfo,item.isKeyCond));
                falg.infoMessage = item.ruleInfo;
                if(!falg.isPast) return falg;
            }
            // 分组
            if(item.type == 'GROUP'){
                falg = this.verifyDeRules('group',item,item.condOP?item.condOP:"AND");
                if(item.isNotMode){
                   falg.isPast = !falg.isPast;
                }
                if(!falg.isPast) return falg;
            }   
        }
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
        grouppanel1: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: false, form: this, isControlledContent: false , uiActionGroup: { caption: '', langbase: 'entities.sysemployee.main_form', extractMode: 'ITEM', details: [] }, isManageContainer: false, showMoreModeItems: []  })
, 
        grouppanel2: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: false, form: this, isControlledContent: false , uiActionGroup: { caption: '', langbase: 'entities.sysemployee.main_form', extractMode: 'ITEM', details: [] }, isManageContainer: false, showMoreModeItems: []  })
, 
        druipart1: new FormDRUIPartModel({ caption: '部门', detailType: 'DRUIPART', name: 'druipart1', visible: true, isShowCaption: true, form: this, isControlledContent: false  })
, 
        group1: new FormGroupPanelModel({ caption: '人员基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: false, form: this, isControlledContent: false , uiActionGroup: { caption: '', langbase: 'entities.sysemployee.main_form', extractMode: 'ITEM', details: [] }, isManageContainer: false, showMoreModeItems: []  })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this, isControlledContent: false  })
, 
        srfupdatedate: new FormItemModel({ caption: '最后修改时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '用户标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        usercode: new FormItemModel({ caption: '用户工号', detailType: 'FORMITEM', name: 'usercode', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:true, disabled: false, enableCond: 1 })
, 
        personname: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'personname', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:true, disabled: false, enableCond: 3 })
, 
        loginname: new FormItemModel({ caption: '登录名', detailType: 'FORMITEM', name: 'loginname', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:true, disabled: false, enableCond: 1 })
, 
        orgid: new FormItemModel({ caption: '单位', detailType: 'FORMITEM', name: 'orgid', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 1 })
, 
        orgname: new FormItemModel({ caption: '单位', detailType: 'FORMITEM', name: 'orgname', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:true, disabled: false, enableCond: 1 })
, 
        mdeptid: new FormItemModel({ caption: '主部门', detailType: 'FORMITEM', name: 'mdeptid', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        pdeptcheck: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'pdeptcheck', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        mdeptname: new FormItemModel({ caption: '部门', detailType: 'FORMITEM', name: 'mdeptname', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:true, disabled: false, enableCond: 3 })
, 
        mdeptcode: new FormItemModel({ caption: '主部门代码', detailType: 'FORMITEM', name: 'mdeptcode', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        orgcode: new FormItemModel({ caption: '单位代码', detailType: 'FORMITEM', name: 'orgcode', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 1 })
, 
        bcode: new FormItemModel({ caption: '业务编码', detailType: 'FORMITEM', name: 'bcode', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        nickname: new FormItemModel({ caption: '昵称别名', detailType: 'FORMITEM', name: 'nickname', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        sex: new FormItemModel({ caption: '性别', detailType: 'FORMITEM', name: 'sex', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        birthday: new FormItemModel({ caption: '出生日期', detailType: 'FORMITEM', name: 'birthday', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        certcode: new FormItemModel({ caption: '证件号码', detailType: 'FORMITEM', name: 'certcode', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        phone: new FormItemModel({ caption: '联系方式', detailType: 'FORMITEM', name: 'phone', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        avatar: new FormItemModel({ caption: '社交账号', detailType: 'FORMITEM', name: 'avatar', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        email: new FormItemModel({ caption: '邮件', detailType: 'FORMITEM', name: 'email', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        ipaddr: new FormItemModel({ caption: 'ip地址', detailType: 'FORMITEM', name: 'ipaddr', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        showorder: new FormItemModel({ caption: '排序', detailType: 'FORMITEM', name: 'showorder', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        addr: new FormItemModel({ caption: '地址', detailType: 'FORMITEM', name: 'addr', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        memo: new FormItemModel({ caption: '备注', detailType: 'FORMITEM', name: 'memo', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        theme: new FormItemModel({ caption: '样式', detailType: 'FORMITEM', name: 'theme', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        lang: new FormItemModel({ caption: '语言', detailType: 'FORMITEM', name: 'lang', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        fontsize: new FormItemModel({ caption: '字号', detailType: 'FORMITEM', name: 'fontsize', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        reserver: new FormItemModel({ caption: '保留', detailType: 'FORMITEM', name: 'reserver', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        usericon: new FormItemModel({ caption: '照片', detailType: 'FORMITEM', name: 'usericon', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
, 
        userid: new FormItemModel({ caption: '用户标识', detailType: 'FORMITEM', name: 'userid', visible: true, isShowCaption: true, form: this, isControlledContent: false , required:false, disabled: false, enableCond: 3 })
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
     * 监控表单属性 usercode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.usercode')
    onUsercodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'usercode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 personname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.personname')
    onPersonnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'personname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 loginname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.loginname')
    onLoginnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'loginname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.orgid')
    onOrgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.orgname')
    onOrgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 mdeptid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.mdeptid')
    onMdeptidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mdeptid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pdeptcheck 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pdeptcheck')
    onPdeptcheckChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pdeptcheck', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 mdeptname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.mdeptname')
    onMdeptnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mdeptname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 mdeptcode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.mdeptcode')
    onMdeptcodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mdeptcode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgcode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.orgcode')
    onOrgcodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgcode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bcode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bcode')
    onBcodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bcode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nickname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.nickname')
    onNicknameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nickname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sex 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sex')
    onSexChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sex', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 birthday 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.birthday')
    onBirthdayChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'birthday', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 certcode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.certcode')
    onCertcodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'certcode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 phone 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.phone')
    onPhoneChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'phone', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 avatar 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.avatar')
    onAvatarChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'avatar', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 email 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.email')
    onEmailChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'email', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ipaddr 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ipaddr')
    onIpaddrChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ipaddr', newVal: newVal, oldVal: oldVal });
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
     * 监控表单属性 addr 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.addr')
    onAddrChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'addr', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 memo 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.memo')
    onMemoChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'memo', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 theme 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.theme')
    onThemeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'theme', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lang 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.lang')
    onLangChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lang', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 fontsize 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.fontsize')
    onFontsizeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'fontsize', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 reserver 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.reserver')
    onReserverChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'reserver', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 usericon 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.usericon')
    onUsericonChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'usericon', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 userid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.userid')
    onUseridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'userid', newVal: newVal, oldVal: oldVal });
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
        if (Object.is(name, 'orgid')) {
            this.onFormItemValueChange({ name: 'mdeptname', value: null });
            this.onFormItemValueChange({ name: 'mdeptid', value: null });
        }
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
                




















        if (Object.is(name, '') || Object.is(name, 'pdeptcheck')) {
            let ret = false;
            const _pdeptcheck = this.data.pdeptcheck;
            if (this.$verify.testCond(_pdeptcheck, 'ISNULL', '')) {
                ret = true;
            }
            this.detailsModel.mdeptname.setDisabled(!ret);
        }





















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
        if(data.sysemployee){
            Object.assign(this.context,{sysemployee:data.sysemployee})
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
        _this.$print({id:'sysemployee_main',popTitle:'主编辑表单'});
    }

    /**
     * 部件刷新
     *
     * @param {any} args
     * @memberof MainBase
     */
    public refresh(args?: any): void {
        let arg: any = {};
        Object.assign(arg,args?args[0]:{});
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
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'SysEmployeeEditView' + (this.$t('app.formpage.notconfig.loadaction') as string) });
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
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'SysEmployeeEditView' + (this.$t('app.formpage.notconfig.loaddraftaction') as string) });
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
            data.sysemployee = null;
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
        Object.assign(arg,{srfmajortext:data[this.majorMessageField]});
        const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
        if(!action){
            let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'SysEmployeeEditView' + (this.$t('app.formpage.notconfig.actionname') as string) });
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
            AppCenterService.notifyMessage({name:"SysEmployee",action:'appRefresh',data:data});
            this.$nextTick(() => {
                this.formState.next({ type: 'save', data: data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                    if (response.data.errorKey) {
                        if(Object.is(response.data.errorKey, "versionCheck")) {
                            this.$Modal.confirm({
                                title: (this.$t('app.formpage.saveerror') as string),
                                content: (this.$t('app.formpage.savecontent') as string),
                                onOk: () => {
                                    this.refresh([]);
                                },
                                onCancel: () => { }
                            });
                        } else if(Object.is(response.data.errorKey, 'DupCheck')) {
                            let errorProp: string = response.data.message.match(/\[[a-zA-Z]*\]/)[0];
                            let name: string = this.service.getNameByProp(errorProp.substr(1, errorProp.length-2));
                            if(name) {
                                this.$Notice.error({
                                    title: (this.$t('app.commonWords.createFailed') as string),
                                    desc: this.detailsModel[name].caption + " : " + arg[name] + (this.$t('app.commonWords.isExist') as string) + '!',
                                });
                            } else {
                                this.$Notice.error({
                                    title: (this.$t('app.commonWords.createFailed') as string),
                                    desc: response.data.message?response.data.message:(this.$t('app.commonWords.sysException') as string),
                                })
                            }
                        }else if(Object.is(response.data.errorKey, 'DuplicateKeyException')){
                            this.$Notice.error({
                                title: (this.$t('app.commonWords.createFailed') as string),
                                desc: this.detailsModel[this.formKeyItemName].caption + " : " + arg[this.formKeyItemName] + (this.$t('app.commonWords.isExist') as string) + '!',
                            });
                        } else {
                            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message?response.data.message:(this.$t('app.commonWords.sysException') as string) });
                        }
                    } else {
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message?response.data.message:(this.$t('app.commonWords.sysException') as string) });
                    }
                    return;
                } else {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
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
                if(this.errorMessages && this.errorMessages.length > 0) {
                    let descMessage: string = '';
                    this.errorMessages.forEach((message: any) => {
                        descMessage = descMessage + '<p>' + message.error + '<p>';
                    })
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: descMessage });
                } else {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.formpage.valuecheckex') as string) });
                }
                return;
            }
            const arg: any = { ...opt };
            const data = this.getValues();
            Object.assign(arg, this.context);
            Object.assign(arg, data);
            Object.assign(arg,{srfmajortext:data[this.majorMessageField]});
            if (ifStateNext) {
                this.drcounter = 1;
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
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'SysEmployeeEditView' + (this.$t('app.formpage.notconfig.actionname') as string) });
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
                AppCenterService.notifyMessage({name:"SysEmployee",action:'appRefresh',data:data});
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: data });
                });
                if (showResultInfo) {
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;'+ (this.$t('app.formpage.savesuccess') as string) });
                }
                resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    if (response.data.errorKey) {
                        if(Object.is(response.data.errorKey, "versionCheck")) {
                            this.$Modal.confirm({
                                title: (this.$t('app.formpage.saveerror') as string),
                                content: (this.$t('app.formpage.savecontent') as string),
                                onOk: () => {
                                    this.refresh([]);
                                },
                                onCancel: () => { }
                            });
                        } else if(Object.is(response.data.errorKey, 'DupCheck')) {
                            let errorProp: string = response.data.message.match(/\[[a-zA-Z]*\]/)[0];
                            let name: string = this.service.getNameByProp(errorProp.substr(1, errorProp.length-2));
                            if(name) {
                                this.$Notice.error({
                                    title: (this.$t('app.commonWords.createFailed') as string),
                                    desc: this.detailsModel[name].caption + " : " + arg[name] + (this.$t('app.commonWords.isExist') as string) + '!',
                                });
                            } else {
                                this.$Notice.error({
                                    title: (this.$t('app.commonWords.createFailed') as string),
                                    desc: response.data.message,
                                })
                            }
                        } else {
                            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                        }
                    } else {
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                        reject(response);
                    }
                    return;
                } else {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                    reject(response);
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
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'SysEmployeeEditView' + (this.$t('app.formpage.notconfig.removeaction') as string) });
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
                    AppCenterService.notifyMessage({name:"SysEmployee",action:'appRefresh',data:data});
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
                AppCenterService.notifyMessage({name:"SysEmployee",action:'appRefresh',data:data});
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
        if (!arg.sysemployee || Object.is(arg.sysemployee, '')) {
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
                AppCenterService.notifyMessage({name:"SysEmployee",action:'appRefresh',data:data});
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
            AppCenterService.notifyMessage({name:"SysEmployee",action:'appRefresh',data:data});
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
        if (this.data.hasOwnProperty('pdeptcheck')) {
            this.data['pdeptcheck'] = this.context['SYS_department'];
        }
        if (this.data.hasOwnProperty('showorder')) {
            this.data['showorder'] = 1;
        }
    }

    /**
     * 更新默认值
     * @memberof MainBase
     */
    public updateDefault(){                    
        if (this.data.hasOwnProperty('pdeptcheck') && !this.data.pdeptcheck) {
            this.data['pdeptcheck'] = this.context['SYS_department'];
        }
        if (this.data.hasOwnProperty('showorder') && !this.data.showorder) {
            this.data['showorder'] = 1;
        }
    }

    
}
</script>

<style lang='less'>
@import './main-form.less';
</style>