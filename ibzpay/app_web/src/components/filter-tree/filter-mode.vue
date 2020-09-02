<template>
    <el-select size="small" class="filter-mode" :placeholder="$t('components.filterMode.placeholder')" v-model="curVal" @change="onChange">
        <el-option
            v-for="mode in fieldFilterMode"
            :key="mode.value"
            :label="getLabel(mode)"
            :value="mode.value"
            >
        </el-option>
    </el-select>
</template>

<script lang="ts">
import { Vue, Component, Model, Prop, Watch } from "vue-property-decorator";

@Component({})
export default class FilterMode extends Vue {

    /**
     * 值属性
     *
     * @type {*}
     * @memberof FilterMode
     */    
    @Model('change') readonly value: any;

    /**
     * 自定义逻辑集合
     *
     * @type {*}
     * @memberof FilterMode
     */    
    @Prop() modes!: any[];
 
    @Watch('modes')
    onModesChange(newVal: any) {
        this.setDefValue();
    }

    get curVal() {
        return this.value;
    }

    set curVal(val: any) {
        const type: string = this.$util.typeOf(val);
        val = Object.is(type, 'null') || Object.is(type, 'undefined') ? undefined : val;
        this.$emit('change', val);
    }

    get fieldFilterMode() {
        if(this.modes && this.modes.length > 0) {
            let index: number = this.modes.findIndex((mode: any) => Object.is(mode.mode, 'all'));
            if(index < 0) {
                let items: any[] = [];
                this.modes.forEach((mode: any) => {
                    let item: any = this.filterMode.find((filter: any) => Object.is(filter['en-US'], mode.mode));
                    items.push(item);
                })
                return items;
            }
        }
        return this.filterMode;
    }

    /**
     * 过滤模式
     *
     * @type {*}
     * @memberof FilterMode
     */
    public filterMode: any[] = [
        // { name: 'AND', value: '$and' },
        // { name: 'OR', value: '$or' },
        { 'zh-CN': '等于(=)', 'en-US': 'EQ', value: '$eq' },
        { 'zh-CN': '不等于(<>)', 'en-US': 'NOTEQ', value: '$ne' },
        { 'zh-CN': '大于(>)', 'en-US': 'GT', value: '$gt' },
        { 'zh-CN': '大于等于(>=)', 'en-US': 'GTANDEQ', value: '$gte' },
        { 'zh-CN': '小于(<)', 'en-US': 'LT', value: '$lt' },
        { 'zh-CN': '小于等于(<=)', 'en-US': 'LTANDEQ', value: '$lte' },
        { 'zh-CN': '值为空(Nil)', 'en-US': 'ISNULL', value: '$null' },
        { 'zh-CN': '值不为空(NotNil)', 'en-US': 'ISNOTNULL', value: '$notNull' },
        { 'zh-CN': '值在范围中(In)', 'en-US': 'IN', value: '$in' },
        { 'zh-CN': '值不在范围中(NotIn)', 'en-US': 'NOTIN', value: '$notIn' },
        { 'zh-CN': '文本包含(%)', 'en-US': 'LIKE', value: '$like' },
        { 'zh-CN': '文本左包含(%#)', 'en-US': 'LIFTLIKE', value: '$startsWith' },
        { 'zh-CN': '文本右包含(#%)', 'en-US': 'RIGHTLIKE', value: '$endsWith' },
        // { 'zh-CN': '', en: 'EXISTS', value: '$exists' },
        // { 'zh-CN': '', en: 'NOTEXISTS', value: '$notExists' }
    ];

    /**
     * 生命周期
     *
     * @return {void}
     * @memberof FilterMode
     */
    public mounted() {
        this.setDefValue()
    }

    /**
     * 设置默认值
     *
     * @return {void}
     * @memberof FilterMode
     */
    public setDefValue() {
        if(this.fieldFilterMode.length > 0) {
            this.curVal = this.fieldFilterMode[0].value;
            this.onChange();

        }
    }

    /**
     * 获取语言文本
     *
     * @return {string}
     * @memberof FilterMode
     */
    public getLabel(mode: any): string {
        if(this.$i18n.locale) {
            return mode[this.$i18n.locale];
        }
        return mode['zh-CN'];
    }

    /**
     * 值改变
     *
     * @memberof FilterMode
     */
    public onChange() {
        this.$nextTick(() => {
            let item: any = this.filterMode.find((filter: any) => Object.is(filter.value, this.curVal));
            if(this.modes && this.modes.length > 0) {
                let mode: any = this.modes.find((mode: any) => Object.is(mode.mode, item['en-US']));
                if(!mode) {
                    mode = this.modes.find((mode: any) => Object.is(mode.mode, 'all'));
                }
                this.$emit('on-change', mode);
            }
        })
    }

}
</script>