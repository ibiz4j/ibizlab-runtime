<template>
    <div class="app-color-span">
        <span v-if="color" :style="{ color:textColor }">{{ text ? text : '---' }}</span>
        <template v-else>
            <template v-if="dataValue && dataValue.length > 0">
                <span v-for="(textItem,index) of dataValue" :key="index" class="text-color" :style="{ backgroundColor:textItem.color }">
                {{ textItem.srfmajortext ? textItem.srfmajortext : '---'}}
                </span>
            </template>
            <span v-else>---</span>
        </template>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Watch, Prop, Model } from 'vue-property-decorator';
import CodeListService from '@codelist/codelist-service';
import { Subject, Subscription } from 'rxjs';
@Component({
})
export default class AppColorSpan extends Vue {

    /**
     * 当前值
     *
     * @type {*}
     * @memberof AppColorSpan
     */
    @Prop() public value: any;

    /**
     * 当前表单项名称
     *
     * @type {*}
     * @memberof AppColorSpan
     */
    @Prop() public name?: any;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof AppColorSpan
     */
    @Prop() public codelistType?: string;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof AppColorSpan
     */
    @Prop() public data?: any;

    /**
     * 局部上下文导航参数
     *
     * @type {any}
     * @memberof AppColorSpan
     */
    @Prop() public localContext!: any;

    /**
     * 局部导航参数
     *
     * @type {any}
     * @memberof AppColorSpan
     */
    @Prop() public localParam!: any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppColorSpan
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppColorSpan
     */
    @Prop() public viewparams!: any;


    /**
     * 颜色标识
     * 
     * @type {*}
     * @memberof AppColorSpan
     */
    @Prop() color:any;


    /**
     * 颜色
     * 
     * @type {*}
     * @memberof AppColorSpan
     */
     public textColor:any;

    /**
     * 显示值
     * @type {*}
     * @memberof AppColorSpan
     */
    public text: any = '';

    /**
     * 数据数组
     * 
     * @type {*}
     * @memberof AppColorSpan
     */
    public dataValue:Array<any> = [];

    /**
     * 监听value
     * 
     * @memberof AppColorSpan
     */
    @Watch('value')
    public valueChange(newVal:any,oldVal:any){
        if(newVal !== oldVal){
            this.load();
        }
    }

    /**
     * 加载数据
     * 
     * @memberof AppColorSpan
     */
    public load(){
        if(this.color){
            this.text = this.value;
            this.textColor = this.data[this.color];
        }else{
            this.dataValue = JSON.parse(this.value);
        }
    }

    /**
     * vue  生命周期
     *
     * @memberof AppColorSpan
     */
    public created() {
        this.load();
    }
}
</script>

<style lang="less">
    .text-color{
        padding: 2px;
        margin: 6px;
        border-radius: 4px;
    }
</style>