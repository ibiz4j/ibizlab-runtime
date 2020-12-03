<template>
    <vue-pivottable-ui
        class="app-vue-pivottable"
        :data="datas"
        :aggregatorName="aggregatorName"
        :rendererName="rendererName"
        :columns="columns"
        :rows="rows"
        :cols="cols"
        :vals="vals"
        :locales="locales"
        :rowTotal="rowTotal"
        :colTotal="colTotal"
        :onChange="onChange"
        :hiddenFromDragDrop="hiddenFromDragDrop"
    >           
    </vue-pivottable-ui>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop } from 'vue-property-decorator';
import { VuePivottableUi } from 'ibiz-vue-pivottable';
import 'ibiz-vue-pivottable/dist/vue-pivottable.css';

@Component({
    components: {
        VuePivottableUi
    }
})
export default class AppVuePivotTable extends Vue {

    /**
     * 数据集
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    @Prop() datas: any;

    /**
     * 列集合
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    @Prop() allColumns: any;

    /**
     * 聚合模式
     *
     * @type {string}
     * @memberof AppVuePivotTable
     */
    protected aggregatorName: string = 'Sum';

    /**
     * 渲染模式
     *
     * @type {string}
     * @memberof AppVuePivotTable
     */
    protected rendererName: string = 'Table Heatmap';

    /**
     * 行统计
     *
     * @type {boolean}
     * @memberof AppVuePivotTable
     */
    protected rowTotal: boolean = true;

    /**
     * 列统计
     *
     * @type {boolean}
     * @memberof AppVuePivotTable
     */
    protected colTotal: boolean = true;

    /**
     * 列属性列集合
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    protected cols: any[] = [];

    /**
     * 行属性列集合
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    protected rows: any[] = [];

    /**
     * 值属性集合
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    protected vals: any[] =  [];

    /**
     * 隐藏列集合
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    protected hiddenFromDragDrop: any[] = [];

    /**
     * 展现列集合
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    protected columns: any[] = [];

    /**
     * 语言资源
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    protected locales: any = {
        aggregators: {
            'Count': 'Count',
            'Count Unique Values': 'Count Unique Values',
            'List Unique Values': 'List Unique Values',
            'Sum': 'Sum',
            'Integer Sum': 'Integer Sum',
            'Average': 'Average',
            'Median': 'Median',
            'Sample Variance': 'Sample Variance',
            'Sample Standard Deviation': 'Sample Standard Deviation',
            'Minimum': 'Minimum',
            'Maximum': 'Maximum',
            'First': 'First',
            'Last': 'Last',
            'Sum over Sum': 'Sum over Sum',
            'Sum as Fraction of Total': 'Sum as Fraction of Total',
            'Sum as Fraction of Rows': 'Sum as Fraction of Rows',
            'Sum as Fraction of Columns': 'Sum as Fraction of Columns',
            'Count as Fraction of Total': 'Count as Fraction of Total',
            'Count as Fraction of Rows': 'Count as Fraction of Rows',
            'Count as Fraction of Columns': 'Count as Fraction of Columns'
        },
        renderer: {
            'Table': 'Table',
            'Table Heatmap': 'Table Heatmap',
            'Table Col Heatmap': 'Table Col Heatmap',
            'Table Row Heatmap': 'Table Row Heatmap',
            'Expor Table TSV': 'Expor Table TSV',
            'Grouped Column Chart': 'Grouped Column Chart',
            'Stacked Column Chart': 'Stacked Column Chart',
            'Grouped Bar Chart': 'Grouped Bar Chart',
            'Stacked Bar Chart': 'Stacked Bar Chart',
            'Line Chart': 'Line Chart',
            'Dot Chart': 'Dot Chart',
            'Area Chart': 'Area Chart',
            'Scatter Chart': 'Scatter Chart',
            'Multiple Pie Chart': 'Multiple Pie Chart'
        },
        'Filter Values': 'Filter Values',
        'Select All': 'Select All',
        'Deselect All': 'Deselect All',
        'Totals': 'Totals'
    };

    /**
     * 生命周期
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    public created() {
        if(this.allColumns) {
            this.allColumns.forEach((item: any) => {
                if(!item.show) {
                    this.hiddenFromDragDrop.push(item.name);
                }
                let col: any = { ...item };
                col.prop = col.name;
                this.columns.push(col);
            });
        }
    }

    /**
     * 事件
     *
     * @type {*}
     * @memberof AppVuePivotTable
     */
    public onChange(evt: any) {
        console.log(evt);
    }
}
</script>

<style lang="less">
.app-vue-pivottable {
    height: calc(100% - 1px);
    .pvtTable {
        min-width: 100%;
    }
}
</style>