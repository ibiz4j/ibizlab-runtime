<template>
    <div class="app-panel-item">
        <div v-if="Object.is(itemType,'BUTTON')" >
        <Button type="primary" long @click="onClick">
            <i v-if="icon" :class="icon"></i>
            <span v-if="showCaption" :class="lableStyle">{{caption ? caption : ''}}</span>
        </Button>
        </div>
        <div v-if="Object.is(itemType,'RAWITEM')">
            <i v-if="icon" :class="icon"></i>
            <span v-if="caption" class="app-panel-item-rawitem">{{caption}}</span>
            <div :class="contentStyle">
            <slot></slot>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from "vue-property-decorator";

@Component({})
export default class AppPanelItem extends Vue {

    /**
     * 面板成员类型
     *  
     * @type {string}
     * @memberof AppPanelItem
     */
    @Prop() public itemType!: string;

    /**
     * 图标
     *  
     * @type {string}
     * @memberof AppPanelItem
     */
    @Prop() public icon?: string;

    /**
     * 标题
     *  
     * @type {string}
     * @memberof AppPanelItem
     */
    @Prop() public caption?: string;

    /**
     * 显示标题
     *  
     * @type {boolean}
     * @memberof AppPanelItem
     */
    @Prop() public showCaption?: boolean;

    /**
     * 标题样式
     *  
     * @type {boolean}
     * @memberof AppPanelItem
     */
    @Prop() public lableStyle?: string;

    /**
     * 内容样式
     *  
     * @type {boolean}
     * @memberof AppPanelItem
     */
    @Prop() public contentStyle?: string;

    /**
     * 部件样式
     *  
     * @type {boolean}
     * @memberof AppPanelItem
     */
    @Prop() public partsStyle?: string;

    /**
     * 点击按钮
     *
     * @param {*} $event
     * @memberof AppPanelItem
     */
    public onClick($event: any){
        this.$emit('onClick',$event);
    }

}
</script>
<style lang='less'>
@import "./app-panel-item.less";
</style>