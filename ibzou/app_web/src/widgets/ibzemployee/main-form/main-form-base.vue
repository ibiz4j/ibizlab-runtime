<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='ibzemployee_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.ibzemployee.main_form.details.group1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.usercode.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='usercode' :itemRules="this.rules.usercode" class='' :caption="$t('entities.ibzemployee.main_form.details.usercode')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.usercode.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.usercode"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.usercode.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.personname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='personname' :itemRules="this.rules.personname" class='' :caption="$t('entities.ibzemployee.main_form.details.personname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.personname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.personname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.personname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.loginname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='loginname' :itemRules="this.rules.loginname" class='' :caption="$t('entities.ibzemployee.main_form.details.loginname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.loginname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.loginname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.loginname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 24, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.ibzemployee.main_form.details.grouppanel1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.orgname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='orgname' :itemRules="this.rules.orgname" class='' :caption="$t('entities.ibzemployee.main_form.details.orgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.orgname.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-org-select :data="data" :context="JSON.parse(JSON.stringify(context))" :fillMap="{id:'orgid','label':'orgname','code':'orgcode'}" url="/ibzorganizations/alls/suborg/picker" filter="srforgid" :multiple="false" style="" @select-change="onFormItemValueChange"></app-org-select>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.mdeptname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='mdeptname' :itemRules="this.rules.mdeptname" class='' :caption="$t('entities.ibzemployee.main_form.details.mdeptname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.mdeptname.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-department-select :data="data" :context="JSON.parse(JSON.stringify(context))" url="/ibzorganizations/${orgid}/ibzdepartments/picker" filter="orgid"  :fillMap="{id:'mdeptid','label':'mdeptname','code':'mdeptcode','bcode':'bcode'}" :multiple="false" style="" @select-change="onFormItemValueChange"></app-department-select>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.bcode.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='bcode' :itemRules="this.rules.bcode" class='' :caption="$t('entities.ibzemployee.main_form.details.bcode')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bcode.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bcode"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bcode.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.nickname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='nickname' :itemRules="this.rules.nickname" class='' :caption="$t('entities.ibzemployee.main_form.details.nickname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nickname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.nickname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.nickname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sex.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='sex' :itemRules="this.rules.sex" class='' :caption="$t('entities.ibzemployee.main_form.details.sex')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sex.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.sex" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.sex.disabled"  
    tag='CLIBZSex' 
    codelistType='STATIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.birthday.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='birthday' :itemRules="this.rules.birthday" class='' :caption="$t('entities.ibzemployee.main_form.details.birthday')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.birthday.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.birthday" :disabled="detailsModel.birthday.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.birthday = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.certcode.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='certcode' :itemRules="this.rules.certcode" class='' :caption="$t('entities.ibzemployee.main_form.details.certcode')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.certcode.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.certcode"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.certcode.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.phone.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='phone' :itemRules="this.rules.phone" class='' :caption="$t('entities.ibzemployee.main_form.details.phone')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.phone.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.phone"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.phone.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.avatar.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='avatar' :itemRules="this.rules.avatar" class='' :caption="$t('entities.ibzemployee.main_form.details.avatar')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.avatar.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.avatar"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.avatar.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.email.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='email' :itemRules="this.rules.email" class='' :caption="$t('entities.ibzemployee.main_form.details.email')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.email.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.email"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.email.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ipaddr.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='ipaddr' :itemRules="this.rules.ipaddr" class='' :caption="$t('entities.ibzemployee.main_form.details.ipaddr')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ipaddr.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ipaddr"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ipaddr.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.showorder.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='showorder' :itemRules="this.rules.showorder" class='' :caption="$t('entities.ibzemployee.main_form.details.showorder')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.showorder.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.showorder"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.showorder.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.addr.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='addr' :itemRules="this.rules.addr" class='' :caption="$t('entities.ibzemployee.main_form.details.addr')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.addr.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.addr"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.addr.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.memo.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='memo' :itemRules="this.rules.memo" class='' :caption="$t('entities.ibzemployee.main_form.details.memo')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.memo.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.memo"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.memo.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.theme.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='theme' :itemRules="this.rules.theme" class='' :caption="$t('entities.ibzemployee.main_form.details.theme')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.theme.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.theme"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.theme.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.lang.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='lang' :itemRules="this.rules.lang" class='' :caption="$t('entities.ibzemployee.main_form.details.lang')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lang.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.lang"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.lang.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.fontsize.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='fontsize' :itemRules="this.rules.fontsize" class='' :caption="$t('entities.ibzemployee.main_form.details.fontsize')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.fontsize.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.fontsize"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.fontsize.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.reserver.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='reserver' :itemRules="this.rules.reserver" class='' :caption="$t('entities.ibzemployee.main_form.details.reserver')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.reserver.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.reserver"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.reserver.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.grouppanel2.visible" :style="{}"  :sm="{ span: 24, offset: 0 }" :md="{ span: 24, offset: 0 }" :lg="{ span: 24, offset: 0 }" :xl="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.ibzemployee.main_form.details.grouppanel2')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
            
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.usericon.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='usericon' :itemRules="this.rules.usericon" class='' :caption="$t('entities.ibzemployee.main_form.details.usericon')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.usericon.error" :isEmptyCaption="false" labelPos="LEFT">
     <app-image-upload :multiple="false" :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='usericon' :value="data.usericon" :disabled="detailsModel.usericon.disabled" uploadparams='' exportparams='' :customparams="{}"></app-image-upload>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.druipart1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-druipart
    
    :formState="formState"
    :isForbidLoad="this.data.srfuf === '0'"
    paramItem='ibzemployee' 
    :parentdata='{"srfparentdefname":"USERID","srfparentdename":"IBZEMP","SRFPARENTTYPE":"DER1N","srfparentmode":"DER1N_IBZDEPTMEMBER_IBZEMP_USERID","SRFDER1NID":"DER1N_IBZDEPTMEMBER_IBZEMP_USERID"}'
    :parameters="[
        { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
    ]"
    :context="context"
    :viewparams="viewparams"
    parameterName='ibzemployee'
    parentName="IBZEmployee"  
    refviewtype='DEGRIDVIEW' 
    refreshitems='' 
    :ignorefieldvaluechange="ignorefieldvaluechange"
    viewname='ibzdept-member-grid-view' 
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
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import IBZEmployeeService from '@/service/ibzemployee/ibzemployee-service';
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
     * @type {IBZEmployeeService}
     * @memberof Main
     */
    public appEntityService: IBZEmployeeService = new IBZEmployeeService({ $store: this.$store });
    


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
        ibzemployee:null,
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
            { type: 'string', message: '用户标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '用户标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '用户标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '用户标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'blur' },
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
        usercode: [
            { type: 'string', message: '用户工号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '用户工号 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '用户工号 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '用户工号 值不能为空', trigger: 'blur' },
        ],
        personname: [
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '姓名 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '姓名 值不能为空', trigger: 'blur' },
        ],
        loginname: [
            { type: 'string', message: '登录名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '登录名 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '登录名 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '登录名 值不能为空', trigger: 'blur' },
        ],
        orgid: [
            { type: 'string', message: '单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '单位 值不能为空', trigger: 'blur' },
        ],
        orgname: [
            { type: 'string', message: '单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '单位 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '单位 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '单位 值不能为空', trigger: 'blur' },
        ],
        mdeptid: [
            { type: 'string', message: '主部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '主部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '主部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '主部门 值不能为空', trigger: 'blur' },
        ],
        mdeptname: [
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '部门 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '部门 值不能为空', trigger: 'blur' },
        ],
        mdeptcode: [
            { type: 'string', message: '主部门代码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '主部门代码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '主部门代码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '主部门代码 值不能为空', trigger: 'blur' },
        ],
        orgcode: [
            { type: 'string', message: '单位代码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '单位代码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '单位代码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '单位代码 值不能为空', trigger: 'blur' },
        ],
        bcode: [
            { type: 'string', message: '业务编码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '业务编码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '业务编码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '业务编码 值不能为空', trigger: 'blur' },
        ],
        nickname: [
            { type: 'string', message: '昵称别名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '昵称别名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '昵称别名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '昵称别名 值不能为空', trigger: 'blur' },
        ],
        sex: [
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'blur' },
        ],
        birthday: [
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'blur' },
        ],
        certcode: [
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'blur' },
        ],
        phone: [
            { type: 'string', message: '联系方式 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '联系方式 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '联系方式 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '联系方式 值不能为空', trigger: 'blur' },
        ],
        avatar: [
            { type: 'string', message: '社交账号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '社交账号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '社交账号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '社交账号 值不能为空', trigger: 'blur' },
        ],
        email: [
            { type: 'string', message: '邮件 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '邮件 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '邮件 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '邮件 值不能为空', trigger: 'blur' },
        ],
        ipaddr: [
            { type: 'string', message: 'ip地址 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: 'ip地址 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: 'ip地址 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: 'ip地址 值不能为空', trigger: 'blur' },
        ],
        showorder: [
            { type: 'number', message: '排序 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '排序 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '排序 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '排序 值不能为空', trigger: 'blur' },
        ],
        addr: [
            { type: 'string', message: '地址 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '地址 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '地址 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '地址 值不能为空', trigger: 'blur' },
        ],
        memo: [
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'blur' },
        ],
        theme: [
            { type: 'string', message: '样式 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '样式 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '样式 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '样式 值不能为空', trigger: 'blur' },
        ],
        lang: [
            { type: 'string', message: '语言 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '语言 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '语言 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '语言 值不能为空', trigger: 'blur' },
        ],
        fontsize: [
            { type: 'string', message: '字号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '字号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '字号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '字号 值不能为空', trigger: 'blur' },
        ],
        reserver: [
            { type: 'string', message: '保留 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '保留 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '保留 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '保留 值不能为空', trigger: 'blur' },
        ],
        usericon: [
            { type: 'string', message: '照片 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '照片 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '照片 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '照片 值不能为空', trigger: 'blur' },
        ],
        userid: [
            { type: 'string', message: '用户标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '用户标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '用户标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '用户标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof Main
     */
    public detailsModel: any = {
        grouppanel1: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.ibzemployee.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel2: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.ibzemployee.main_form', extractMode: 'ITEM', details: [] } })
, 
        druipart1: new FormDRUIPartModel({ caption: '部门', detailType: 'DRUIPART', name: 'druipart1', visible: true, isShowCaption: true, form: this })
, 
        group1: new FormGroupPanelModel({ caption: '人员基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.ibzemployee.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '最后修改时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '用户标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        usercode: new FormItemModel({ caption: '用户工号', detailType: 'FORMITEM', name: 'usercode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 1 })
, 
        personname: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'personname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        loginname: new FormItemModel({ caption: '登录名', detailType: 'FORMITEM', name: 'loginname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 1 })
, 
        orgid: new FormItemModel({ caption: '单位', detailType: 'FORMITEM', name: 'orgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 1 })
, 
        orgname: new FormItemModel({ caption: '单位', detailType: 'FORMITEM', name: 'orgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 1 })
, 
        mdeptid: new FormItemModel({ caption: '主部门', detailType: 'FORMITEM', name: 'mdeptid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        mdeptname: new FormItemModel({ caption: '部门', detailType: 'FORMITEM', name: 'mdeptname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        mdeptcode: new FormItemModel({ caption: '主部门代码', detailType: 'FORMITEM', name: 'mdeptcode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgcode: new FormItemModel({ caption: '单位代码', detailType: 'FORMITEM', name: 'orgcode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 1 })
, 
        bcode: new FormItemModel({ caption: '业务编码', detailType: 'FORMITEM', name: 'bcode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nickname: new FormItemModel({ caption: '昵称别名', detailType: 'FORMITEM', name: 'nickname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sex: new FormItemModel({ caption: '性别', detailType: 'FORMITEM', name: 'sex', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        birthday: new FormItemModel({ caption: '出生日期', detailType: 'FORMITEM', name: 'birthday', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        certcode: new FormItemModel({ caption: '证件号码', detailType: 'FORMITEM', name: 'certcode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        phone: new FormItemModel({ caption: '联系方式', detailType: 'FORMITEM', name: 'phone', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        avatar: new FormItemModel({ caption: '社交账号', detailType: 'FORMITEM', name: 'avatar', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        email: new FormItemModel({ caption: '邮件', detailType: 'FORMITEM', name: 'email', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ipaddr: new FormItemModel({ caption: 'ip地址', detailType: 'FORMITEM', name: 'ipaddr', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        showorder: new FormItemModel({ caption: '排序', detailType: 'FORMITEM', name: 'showorder', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        addr: new FormItemModel({ caption: '地址', detailType: 'FORMITEM', name: 'addr', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        memo: new FormItemModel({ caption: '备注', detailType: 'FORMITEM', name: 'memo', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        theme: new FormItemModel({ caption: '样式', detailType: 'FORMITEM', name: 'theme', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lang: new FormItemModel({ caption: '语言', detailType: 'FORMITEM', name: 'lang', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        fontsize: new FormItemModel({ caption: '字号', detailType: 'FORMITEM', name: 'fontsize', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        reserver: new FormItemModel({ caption: '保留', detailType: 'FORMITEM', name: 'reserver', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        usericon: new FormItemModel({ caption: '照片', detailType: 'FORMITEM', name: 'usericon', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        userid: new FormItemModel({ caption: '用户标识', detailType: 'FORMITEM', name: 'userid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
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
     * 监控表单属性 usercode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    @Watch('data.mdeptid')
    onMdeptidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mdeptid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 mdeptname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    @Watch('data.userid')
    onUseridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'userid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof Main
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
        if(data.ibzemployee){
            Object.assign(this.context,{ibzemployee:data.ibzemployee})
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
        copyData.ibzemployee = copyData.srfkey;
        copyData.userid = copyData.srfkey;
        Object.assign(this.context,{ibzemployee:copyData.ibzemployee})
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
        _this.$print({id:'ibzemployee_main',popTitle:'主编辑表单'});
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
            this.$Notice.error({ title: '错误', desc: 'IBZEmployeeEditView视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'IBZEmployeeEditView视图表单loaddraftAction参数未配置' });
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
            if(data.ibzemployee){
                Object.assign(this.context,{ibzemployee:data.ibzemployee})
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
            this.$Notice.error({ title: '错误', desc: 'IBZEmployeeEditView视图表单'+actionName+'参数未配置' });
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
                this.drcounter = 1;
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
                this.$Notice.error({ title: '错误', desc: 'IBZEmployeeEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'IBZEmployeeEditView视图表单removeAction参数未配置' });
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
        if (!arg.ibzemployee || Object.is(arg.ibzemployee, '')) {
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
        if(this.drcounter > 0){
            return;
        }
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

    /**
     * 新建默认值
     * @memberof Main
     */
    public createDefault(){                    
        if (this.data.hasOwnProperty('showorder')) {
            this.data['showorder'] = 1;
        }
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