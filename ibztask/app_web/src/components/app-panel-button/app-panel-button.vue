<template>
    <div class="app-panel-button">
        <Button type="primary" long @click="onClick">
            <i v-if="icon" :class="icon"></i>
            <span v-if="showCaption" :class="lableStyle">{{caption ? caption : ''}}</span>
        </Button>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from "vue-property-decorator";

@Component({})
export default class AppPanelButton extends Vue {

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

</style>