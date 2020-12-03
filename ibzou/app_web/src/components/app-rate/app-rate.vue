<template>
    <div>
        <el-rate :value="currentVal" :disabled="disabled" :max="maxItem" @change="change"> </el-rate>
    </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Model, Watch } from 'vue-property-decorator';
import CodeListService from '@codelist/codelist-service';

@Component({})
export default class AppRate extends Vue {
    /**
     * 传入值
     * @type {any}
     * @memberof AppRate
     */
    @Prop() public value?: any;

    /**
     * 是否禁用
     * @type {boolean}
     * @memberof AppRate
     */
    @Prop() public disabled?: boolean;

    /**
     * 下发数据
     * @type {number}
     * @memberof AppRate
     */
    @Prop() public data?: any;

    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof AppRate
     */
    public codeListService: CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 传递最大值
     * @type {*}
     * @memberof AppRate
     */
    @Prop({ default: 5 }) public max!: number;

    /**
     * 应用上下文
     * @type {*}
     * @memberof AppRate
     */
    @Prop() context: any;

    /**
     * 视图参数
     * @type {*}
     * @memberof AppRate
     */
    @Prop() viewparams: any;

    /**
     * 临时上下文
     * @type {*}
     * @memberof AppRate
     */
    @Prop() localContext: any;

    /**
     * 临时参数
     * @type {*}
     * @memberof AppRate
     */
    @Prop() localParam: any;

    /**
     * 代码表标识
     * @type {string}
     * @memberof AppRate
     */
    @Prop() tag?: string;

    /**
     * 代码表类型
     * @type {string}
     * @memberof AppRate
     */
    @Prop() codelistType?: string;

    /**
     * 代码表值分隔符
     * @type {string}
     * @memberof AppRate
     */
    @Prop({default: ','}) valueSeparator?: string;

    /**
     * 数据名称
     * @type {*}
     * @memberof AppRate
     */
    @Prop() name: any;

    /**
     * 最大值
     * @type {number}
     * @memberof AppRate
     */
    public maxItem: number = 5;

    /**
     * 监听数据变化
     * 
     * @memberof AppRate
     */
    @Watch('data',{immediate:true,deep:true})
    onDataChange(newVal: any, oldVal: any) {
      if(newVal){
          if(this.tag && this.codelistType == 'DYNAMIC'){
              // 公共参数处理
            let data: any = {};
            this.handlePublicParams(data);
            // 参数处理
            let _context = data.context;
            let _param = data.param;
            this.codeListService.getItems(this.tag, _context, _param).then((res: any) => {
                const items = res;
                //  获取最大值
                const maxItem = Math.max.apply(Math,items.map((item: any) => { return item.value; }));
                this.maxItem = maxItem>5 ? 5 : maxItem;
            }).catch((error: any) => {
                console.log(`----${this.tag}----$t('components.appCheckBox.notExist')`);
            });
          }
      }
    }

    /**
     * 当前值
     *
     * @memberof AppRate
     */
    get currentVal() {
        return Number(this.value);
    }

    /**
     * change
     */
    public change(val: any) {
        this.$emit('change', val);
    }

    /**
     * Vue生命周期
     * @memberof AppRate
     */
    public created() {
        if (this.max) {
            this.maxItem = this.max;
        }
        this.handleCodelist();
    }

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof AppRate
     */
    public handlePublicParams(arg: any) {
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.data,arg.context,arg.param,this.localContext);
            Object.assign(arg.context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.data,arg.param,arg.param,this.localParam);
            Object.assign(arg.param,_param);
        }
    }

    /**
     * 根据代码表获取最大值
     * @memberof AppRate
     */
    public handleCodelist() {
        if (this.tag && Object.is(this.codelistType, 'STATIC')) {
            const codelist = this.$store.getters.getCodeList(this.tag);
            if (codelist) {
                const items = [...JSON.parse(JSON.stringify(codelist.items))];
                //  获取最大值
                const maxItem = Math.max.apply(Math,items.map((item: any) => { return item.value; }));
                this.maxItem = maxItem>5 ? 5 : maxItem;
            } else {
                console.log(`----${this.tag}----$t('components.appCheckBox.notExist')`);
            }
        } else if (this.tag && Object.is(this.codelistType, 'DYNAMIC')) {
            // 公共参数处理
            let data: any = {};
            this.handlePublicParams(data);
            // 参数处理
            let _context = data.context;
            let _param = data.param;
            this.codeListService.getItems(this.tag, _context, _param).then((res: any) => {
                const items = res;
                //  获取最大值
                let maxItem = Math.max.apply(Math,items.map((item: any) => { return item.value; }));
                this.maxItem = maxItem>5 ? 5 : maxItem;
            }).catch((error: any) => {
                console.log(`----${this.tag}----$t('components.appCheckBox.notExist')`);
            });
        }
    }
}
</script>

<style lang="less">
@import './app-rate.less';
</style>
