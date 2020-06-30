<template>
    <el-select size="small" class="filter-mode" placeholder="条件逻辑" clearable v-model="curVal" @change="onChange">
        <el-option
            v-for="mode in filterMode"
            :key="mode.value"
            :label="mode.en"
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
        { zh: '等于(=)', en: 'EQ', value: '$eq' },
        { zh: '', en: 'NE', value: '$ne' },
        { zh: '', en: 'GT', value: '$gt' },
        { zh: '', en: 'GE', value: '$gte' },
        { zh: '', en: 'LT', value: '$lt' },
        { zh: '', en: 'LE', value: '$lte' },
        { zh: '', en: 'IS_NULL', value: '$null' },
        { zh: '', en: 'IS_NOT_NULL', value: '$notNull' },
        { zh: '', en: 'IN', value: '$in' },
        { zh: '', en: 'NOTIN', value: '$notIn' },
        { zh: '', en: 'LIKE', value: '$like' },
        { zh: '', en: 'LIFTLIKE', value: '$startsWith' },
        { zh: '', en: 'RIGHTLIKE', value: '$endsWith' },
        { zh: '', en: 'EXISTS', value: '$exists' },
        { zh: '', en: 'NOTEXISTS', value: '$notExists' }
    ];

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