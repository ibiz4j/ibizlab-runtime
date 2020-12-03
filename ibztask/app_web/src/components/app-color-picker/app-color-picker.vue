<template>
    <div class="app-color-picker">
        <el-input
            v-model="curVal"
            size="small"
            ref="colorPicker"
            :disabled="disabled"
            :placeholder="placeholder"
            >
            <template slot="suffix">
                <el-color-picker ref="picker" v-model="colorValue" @change="colorChange" size="small">
                </el-color-picker>
                <Icon type="md-color-palette" @click="iconClick" />
            </template>
        </el-input>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Watch, Prop, Model } from 'vue-property-decorator';
import CodeListService from '@codelist/codelist-service';
import { Subject, Subscription } from 'rxjs';

@Component({})
export default class AppColorPicker extends Vue {

    /**
     * 双向绑定表单项数据
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    @Model('change') public value: any;

    /**
     * 表单数据
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    @Prop() public data: any;

    /**
     * 表单通讯对象
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    @Prop() public formState?: Subject<any>;

    /**
     * 禁用状态
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    @Prop({default: false}) public disabled?: boolean;

    /**
     * 占位提示
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    @Prop() public placeholder?: string;

    /**
     * 上下文
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    @Prop() public context: any;

    /**
     * 视图参数
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    @Prop() public viewparam: any;

    /**
     * 颜色对应字段值
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    @Prop() public color: any;

    /**
     * 双向绑定颜色
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    public colorValue: any = null;

    /**
     * 获取输入框值
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    get curVal() {
        return this.value;
    }

    /**
     * 设置值
     * 
     * @type {*}
     * @memberof AppColorPicker
     */
    set curVal(val: any) {
        this.$emit('change', val);
    }

    /**
     * Vue生命周期
     * 
     * @memberof AppColorPicker
     */
    public created() {
        this.handleData();
    }

    /**
     * 数据处理
     * 
     * @memberof AppColorPicker
     */
    @Watch('value')
    public handleData() {
        if(!this.value && !this.color) {
            return;
        }
        this.colorValue = this.data[this.color];
        this.curVal = this.value;
        this.handleInputColor(this.colorValue);
    }

    /**
     * 数据处理
     * 
     * @memberof AppColorPicker
     */
    public colorChange(color: any) {
        this.handleInputColor(color);
        this.$emit('colorChange', { name: this.color, value: color });
    }

    /**
     * 设置输入框字体颜色
     * 
     * @memberof AppColorPicker
     */
    public handleInputColor(color: any) {
        let picker: any = this.$refs.colorPicker;
        if(picker) {
            let child: any = picker.$el.children[0];
            child.style.color = color;
        }
    }

    /**
     * 模拟点击事件
     * 
     * @memberof AppColorPicker
     */
    public iconClick() {
        let picker: any = this.$refs.picker;
        let e: any = document.createEvent('MouseEvent');
        e.initEvent('click', true, true);
        if(picker) {
            picker.$el.children[0].dispatchEvent(e);
        }
    }
}
</script>

<style lang="less">
@import './app-color-picker.less';
</style>
