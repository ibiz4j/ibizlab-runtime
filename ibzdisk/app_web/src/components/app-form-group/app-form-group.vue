<template>
    <div :class="classes">
        <template v-if="uiStyle=='STYLE2'">
            <app-form-group2
                :caption="caption"
                :uiStyle="uiStyle"
                :layoutType="layoutType"
                :isShowCaption="isShowCaption"
                :uiActionGroup="uiActionGroup"
                :titleBarCloseMode="titleBarCloseMode">
                   <slot></slot>
                </app-form-group2>
        </template>
        <template v-else>
            <card v-if="isShowCaption === true" :bordered="false" :dis-hover="true" :class="classes">
                <p class='' slot='title'>
                     <icon v-if="titleBarCloseMode !== 0" :type="collapseContant ? 'ios-arrow-dropright-circle' : 'ios-arrow-dropdown-circle'"
                    @click="clickCollapse"></icon>
                    <span :class="titleClass">{{caption}}</span>
                </p>
                <template v-if="uiActionGroup">
                    <a slot='extra'>
                        <template v-if="uiActionGroup.extractMode && Object.is(uiActionGroup.extractMode, 'ITEMS')">
                            <dropdown :transfer="true" trigger='click'>
                            <a href='javascript:void(0)'>
                                {{uiActionGroup.caption}}
                            </a>
                            <dropdown-menu slot='list' v-if="uiActionGroup.details && Array.isArray(uiActionGroup.details)">
                                <dropdown-item v-for="(detail,index) in (uiActionGroup.details)" :key="index" :name="detail.name">
                                    <span class='item' v-show="detail.visabled" :style="{'pointer-events':detail.disabled?'none':'auto','color':detail.disabled?'#7b7979':'#2d8cf0'}" @click="doUIAction($event, detail)">
                                        <template v-if="detail.isShowIcon">
                                            <template v-if="detail.icon && !Object.is(detail.icon, '')">
                                                <i :class="detail.icon" ></i>
                                            </template>
                                            <template v-if="!(detail.icon && !Object.is(detail.icon, ''))">
                                                <div v-if="detail.img && !Object.is(detail.img, '')">
                                                    <img :src="detail.img" />
                                                </div>
                                            </template>
                                        </template>
                                        &nbsp;
                                        <span>
                                            <template v-if="detail.isShowCaption">
                                                <template v-if="uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, '')">
                                                    {{$t(`${uiActionGroup.langbase}.uiactions.${detail.uiactiontag}`)}}
                                                </template>
                                                <template v-if="!(uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, ''))">
                                                    {{detail.caption}}
                                                </template>
                                            </template>
                                        </span>
                                    </span>
                                </dropdown-item>
                            </dropdown-menu>
                        </dropdown>
                        </template>
                        <template v-if="!(uiActionGroup.extractMode && Object.is(uiActionGroup.extractMode, 'ITEMS'))">
                             <span class='item-extract-mode'>
                                <template v-if="uiActionGroup.details && Array.isArray(uiActionGroup.details)">
                                    <div v-for="(detail,index) in uiActionGroup.details" :key="index">
                                        <span v-show="detail.visabled" :style="{'pointer-events':detail.disabled?'none':'auto','color':detail.disabled?'#7b7979':'#2d8cf0'}" class='item' @click="doUIAction($event, detail)">
                                            <template v-if="detail.isShowIcon">
                                                <template v-if="detail.icon && !Object.is(detail.icon, '')">
                                                    <i :class="detail.icon" ></i>
                                                </template>
                                                <template v-if="!(detail.icon && !Object.is(detail.icon, ''))">
                                                    <div v-if="detail.img && !Object.is(detail.img, '')">
                                                        <img :src="detail.img" />
                                                    </div>
                                                </template>
                                            </template>
                                        &nbsp;
                                        <span>
                                            <template v-if="detail.isShowCaption">
                                                <template v-if="uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, '')">
                                                    {{$t(`${uiActionGroup.langbase}.uiactions.${detail.uiactiontag}`)}}
                                                </template>
                                                <template v-if="!(uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, ''))">
                                                    {{detail.caption}}
                                                </template>
                                            </template>
                                        </span>
                                    </span>
                                    </div>
                                </template>
                            </span>
                        </template>
                    </a >
                </template>
                <template v-if="Object.is(layoutType, 'FLEX')">
                    <slot></slot>
                </template>
                <template v-if="!Object.is(layoutType, 'FLEX')">
                    <row :gutter="10"><slot></slot></row>
                </template>
                <template v-if="isManageContainer">
                    <i-button type="primary" :icon="manageContainerStatus?'ios-repeat':'ios-more'" @click="doManageContainer">
                        {{manageContainerStatus?$t('components.appFormGroup.hide'):$t('components.appFormGroup.showMore')}}
                    </i-button>
                </template>
            </card>
            <template v-if="isShowCaption === false">
                <slot></slot>
            </template>
        </template>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import { Environment } from '@/environments/environment';

@Component({})
export default class AppFormGroup extends Vue {

    /**
     * 标题
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public caption?: string;

    /**
     * 注入的UI服务
     *
     * @type {*}
     * @memberof AppFormGroup
     */
    @Prop() public uiService!: any;

    /**
     * 注入数据
     *
     * @type {*}
     * @memberof AppFormGroup
     */
    @Prop() public data!: any;

    /**
     * 监听值变化
     *
     * @memberof AppFormGroup
     */
    @Watch('data')
    onSrfupdatedateChange(newVal: any, oldVal: any) {
        if((newVal !== oldVal) && this.uiActionGroup.details.length >0){
            this.calcActionItemAuthState(newVal,this.uiActionGroup.details,this.uiService);
        }
    }

    /**
     * 计算界面行为项权限状态
     *
     * @param {*} [data] 传入数据
     * @param {*} [ActionModel] 界面行为模型
     * @param {*} [UIService] 界面行为服务
     * @memberof AppFormGroup
     */
    public calcActionItemAuthState(data:any,ActionModel:any,UIService:any){
        if(!UIService.isEnableDEMainState)
            return;
        for (const key in ActionModel) {
            if (!ActionModel.hasOwnProperty(key)) {
                return;
            }
            const _item = ActionModel[key];
            if(_item && _item['dataaccaction'] && UIService){
                let dataActionResult:any;
                if(Object.is(_item['actiontarget'],"NONE") || Object.is(_item['actiontarget'],"")){
                    dataActionResult = UIService.getResourceOPPrivs(_item['dataaccaction']);
                }else{
                    if(data && Object.keys(data).length >0){
                        dataActionResult = UIService.getAllOPPrivs(data)[_item['dataaccaction']];
                    }
                }
                // 无权限:0;有权限:1
                if(dataActionResult === 0){
                    // 禁用:1;隐藏:2;隐藏且默认隐藏:6
                    if(_item.noprivdisplaymode === 1){
                        _item.disabled = true;
                    }
                    if((_item.noprivdisplaymode === 2) || (_item.noprivdisplaymode === 6)){
                        _item.visabled = false;
                    }else{
                        _item.visabled = true;
                    }
                }
                if(dataActionResult === 1){
                    _item.visabled = true;
                    _item.disabled = false;
                }
            }
        }
    } 

    /**
     * 是否为管理容器
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop({ default: false }) public isManageContainer?: boolean;
    
    /**
     * 管理容器状态
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop({ default: false }) public manageContainerStatus?: boolean;

    /**
     * 内置界面样式
     * 
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public uiStyle?: string;

    /**
     * 布局模式
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public layoutType?: string;

    /**
     * 标题样式
     *
     * @type {string}
     * @memberof AppFormGroup
     */    
    @Prop() public titleStyle?:string;

    /**
     * 分组图标
     *
     * @type {string}
     * @memberof AppFormGroup
     */ 
    @Prop() public iconInfo?:any;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    @Prop({ default: true }) public isShowCaption!: boolean;

    /**
     * 信息面板模式
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    @Prop({ default: false }) public isInfoGroupMode!: boolean;

    /**
     * 界面行为组
     *
     * @type {*}
     * @memberof AppFormGroup
     */
    @Prop() public uiActionGroup?: any;

    /**
     * 标题栏关闭模式
     * 0: 不支持关闭
     * 1: 默认打开
     * 2： 默认关闭
     *
     * @type {(number | 0 | 1 | 2)} 
     * @memberof AppFormGroup
     */
    @Prop({ default: 0 }) public titleBarCloseMode!: number | 0 | 1 | 2;

    /**
     * 收缩内容
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    public collapseContant: boolean = false;

    /**
     * 计算样式
     *
     * @readonly
     * @type {string[]}
     * @memberof AppFormGroup
     */
    get classes(): string[] {
        return [
            'app-form-group',
            this.isShowCaption && this.collapseContant ? 'app-group-collapse-contant' : '',
            this.isInfoGroupMode ? 'app-info-group-mode' : '',
            Object.is(this.layoutType, 'FLEX') ? 'app-group-flex': ''
        ];
    }

    /**
     * 标题样式
     *
     * @readonly
     * @type {string}
     * @memberof AppFormGroup
     */
    get titleClass():string{
        return this.titleStyle?this.titleStyle:'';
    }

    /**
     * vue 生命周期
     *
     * @memberof AppFormGroup
     */
    public created() {
        this.collapseContant = this.titleBarCloseMode === 2 ? true : false;
    }

    /**
     * 触发收缩
     *
     * @memberof AppFormGroup
     */
    public clickCollapse(): void {
        this.collapseContant = !this.collapseContant;
    }

    /**
     * 执行界面行
     *
     * @param {*} $event
     * @memberof AppFormGroup
     */
    public doUIAction($event: any, item: any): void {
        this.$emit('groupuiactionclick', { event: $event, item: item });
    }

    /**
     * 操作管理容器
     *
     * @param {*} $event
     * @memberof AppFormGroup
     */
    public doManageContainer(){
        this.$emit('managecontainerclick');
    }
}
</script>
<style lang='less'>
@import './app-form-group.less';
</style>