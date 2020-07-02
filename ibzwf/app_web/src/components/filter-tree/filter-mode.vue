<template>
    <el-select size="small" class="filter-mode" placeholder="条件逻辑" v-model="curVal" @change="onChange">
        <el-option
            v-for="mode in filterMode"
            :key="mode.value"
            :label="getLabel(mode)"
            :value="mode.value"
            >
        </el-option>
    </el-select>
</template>

<script lang="ts">
import { Vue, Component, Model } from "vue-property-decorator";

@Component({})
export default class FilterMode extends Vue {

    /**
     * 值属性
     *
     * @type {*}
     * @memberof FilterMode
     */    
    @Model('change') readonly value: any;

    get curVal() {
        return this.value;
    }

    set curVal(val: any) {
        const type: string = this.$util.typeOf(val);
        val = Object.is(type, 'null') || Object.is(type, 'undefined') ? undefined : val;
        this.$emit('change', val);
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
        { 'zh-CN': '不等于(<>)', 'en-US': 'NE', value: '$ne' },
        { 'zh-CN': '大于(>)', 'en-US': 'GT', value: '$gt' },
        { 'zh-CN': '大于等于(>=)', 'en-US': 'GE', value: '$gte' },
        { 'zh-CN': '小于(<)', 'en-US': 'LT', value: '$lt' },
        { 'zh-CN': '小于(<=)', 'en-US': 'LE', value: '$lte' },
        { 'zh-CN': '值为空(Nil)', 'en-US': 'IS_NULL', value: '$null' },
        { 'zh-CN': '值不为空(NotNil)', 'en-US': 'IS_NOT_NULL', value: '$notNull' },
        { 'zh-CN': '值在范围中(In)', 'en-US': 'IN', value: '$in' },
        { 'zh-CN': '值不在范围中(NotIn)', 'en-US': 'NOTIN', value: '$notIn' },
        { 'zh-CN': '文本包含(%)', 'en-US': 'LIKE', value: '$like' },
        { 'zh-CN': '文本左包含(%#)', 'en-US': 'LIFTLIKE', value: '$startsWith' },
        { 'zh-CN': '文本右包含(#%)', 'en-US': 'RIGHTLIKE', value: '$endsWith' },
        // { 'zh-CN': '', en: 'EXISTS', value: '$exists' },
        // { 'zh-CN': '', en: 'NOTEXISTS', value: '$notExists' }
    ];

    /**
     * 获取语言文本
     *
     * @return {string}
     * @memberof FilterMode
     */
    getLabel(mode: any): string {
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
        this.$emit('mode-change', this.value);
    }

}
</script>