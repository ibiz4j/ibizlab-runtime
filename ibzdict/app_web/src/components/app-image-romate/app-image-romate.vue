<template>
  <div class='app-image-preview'>
      <el-image :src="data[name]" :previewSrcList="previewList" :disabled="disabled">
      </el-image>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Watch, Provide } from 'vue-property-decorator';
import { Subject, Unsubscribable } from 'rxjs';

@Component({})
export default class AppImageRomate extends Vue {

    /**
     * 表单状态
     *
     * @type {any}
     * @memberof AppImageRomate
     */
    @Prop() public formState: any;

    /**
     * 图片数据
     *
     * @type {any}
     * @memberof AppImageRomate
     */
    @Prop() public data!: any;

    /**
     * 字段名
     *
     * @type {any}
     * @memberof AppImageRomate
     */
    @Prop() public name: any;

    /**
     * 禁用状态
     *
     * @type {boolean}
     * @memberof AppImageRomate
     */
    @Prop() public disabled: boolean = false;

    /**
     * 预览图片数组
     *
     * @type {boolean}
     * @memberof AppImageRomate
     */
    public previewList:Array<any> = [];

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Unsubscribable | undefined)}
     * @memberof AppImageUpload
     */
    private formStateEvent: Unsubscribable | undefined;

    /**
     * Vue生命周期
     *
     * @type {boolean}
     * @memberof AppImageRomate
     */
    public created() {
        if (this.formState) {
            this.formStateEvent = this.formState.subscribe(($event: any) => {
                // 表单加载完成
                if(this.data && this.name) {
                    this.handleData();
                }
            });
        }
    }

    /**
     * 数据处理
     *
     * @type {boolean}
     * @memberof AppImageRomate
     */
    public handleData() {
        this.previewList.push(this.data[this.name]);
    }  
    
    /**
     * 组件销毁
     *
     * @memberof AppImageRomate
     */
    public destroyed(): void {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }
}

</script>