<template>
    <div :style="sizeStyle">
        <span>{{caption}}</span>
        <div v-if="Object.is(contentType,'RAW')" :class="contentStyle">
            <slot></slot>
        </div>
        <div v-else-if="Object.is(contentType,'HTML')" :class="contentStyle" v-html="htmlContent" />
        <div v-else-if="Object.is(contentType,'IMAGE')" :class="contentStyle">
             <i :class="imageClass ? imageClass : ''"></i>
        </div>
    </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";

@Component({})
export default class AppRawItem extends Vue {

    /**
    * 应用上下文
    * 
    * @type {string}
    * @memberof AppRawItem
    */
    @Prop() public context!: any;

    /**
    * 视图参数
    * 
    * @type {string}
    * @memberof AppRawItem
    */
    @Prop() public viewparams!: any;

    /**
    * 内容类型
    * 
    * @type {string}
    * @memberof AppRawItem
    */
    @Prop() public contentType!: string;

    /**
     * html内容
     * 
     * @type {strin}
     * @memberof AppRawItem
     */
    @Prop() public htmlContent?: string;

    /**
     * 图片
     * 
     * @type {strin}
     * @memberof AppRawItem
     */
    @Prop() public imageClass?: string;

    /**
     * 标题
     *  
     * @type {string}
     * @memberof AppRawItem
     */
    @Prop() public caption?: string;

    /**
     * 内容样式
     * 
     * @type {strin}
     * @memberof AppRawItem
     */
    @Prop() public contentStyle!: string;

    /**
     * 内容宽高
     * 
     * @type {strin}
     * @memberof AppRawItem
     */
    @Prop() public sizeStyle!: string;

}

</script>

<style lang='less'>

</style>