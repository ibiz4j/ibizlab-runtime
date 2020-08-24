
<template>
    <div class="cron" :val="_value">
    <el-tabs v-model="activeName">
      <el-tab-pane :label="$t('components.cronEditor.label.second')" name="s">
        <second-and-minute v-model="sVal" :label="$t('components.cronEditor.second')"></second-and-minute >
      </el-tab-pane>
      <el-tab-pane :label="$t('components.cronEditor.label.minute')" name="m">
        <second-and-minute v-model="mVal" :label="$t('components.cronEditor.minute')"></second-and-minute >
      </el-tab-pane>
      <el-tab-pane :label="$t('components.cronEditor.label.hour')" name="h">
        <hour v-model="hVal" :lable="$t('components.cronEditor.hour.title')"></hour>
      </el-tab-pane>
      <el-tab-pane :label="$t('components.cronEditor.label.day')" name="d">
        <day v-model="dVal" :lable="$t('components.cronEditor.day.title')"></day>
      </el-tab-pane>
      <el-tab-pane :label="$t('components.cronEditor.label.month')" name="month">
        <month v-model="monthVal" :lable="$t('components.cronEditor.month.title')"></month>
      </el-tab-pane>
      <el-tab-pane :label="$t('components.cronEditor.label.week')" name="week">
        <week v-model="weekVal" :lable="$t('components.cronEditor.week.title')"></week>
      </el-tab-pane>
      <el-tab-pane :label="$t('components.cronEditor.label.year')" name="year">
        <year v-model="yearVal" :lable="$t('components.cronEditor.year.title')"></year>
      </el-tab-pane>
    </el-tabs>
    <!-- table -->
    <el-table
       :data="tableData"
       size="mini"
       border
       style="width: 100%;">
       <el-table-column
         prop="sVal"
         :label="$t('components.cronEditor.second')"
         width="70">
       </el-table-column>
       <el-table-column
         prop="mVal"
         :label="$t('components.cronEditor.minute')"
         width="70">
       </el-table-column>
       <el-table-column
         prop="hVal"
         :label="$t('components.cronEditor.hour.title')"
         width="70">
       </el-table-column>
       <el-table-column
         prop="dVal"
         :label="$t('components.cronEditor.day.title')"
         width="70">
       </el-table-column>
       <el-table-column
         prop="monthVal"
         :label="$t('components.cronEditor.month.title')"
         width="70">
       </el-table-column>
       <el-table-column
         prop="weekVal"
         :label="$t('components.cronEditor.week.title')"
         width="70">
       </el-table-column>
       <el-table-column
         prop="yearVal"
         :label="this.$t('components.cronEditor.year.title')">
       </el-table-column>
     </el-table>
  </div>

</template>

<script lang='ts'>
import SecondAndMinute from './secondAndMinute.vue';
import hour from './hour.vue';
import day from './day.vue';
import month from './month.vue';
import week from './week.vue';
import year from './year.vue';
import { Vue, Component, Prop, Watch, Model } from 'vue-property-decorator';

@Component({
  components: {
    'second-and-minute': SecondAndMinute,
    hour,
    day,
    month,
    week,
    year
  }
})
export default class VueCron extends Vue {

    /**
     * 传递数据
     *
     * @type {any}
     * @memberof VueCron
     */ 
    @Prop() data: any;

    /**
     * Cron表达式
     *
     * @type {any}
     * @memberof VueCron
     */ 
    public value: any = '';

    /**
     * 标签名
     *
     * @type {any}
     * @memberof VueCron
     */ 
    public activeName: string = 's';

    /**
     * 标签-秒 数据
     *
     * @type {any}
     * @memberof VueCron
     */ 
    public sVal: any = '';

    /**
     * 标签-分 数据
     *
     * @type {any}
     * @memberof VueCron
     */ 
  public mVal: any = '';

    /**
     * 标签-天 数据
     *
     * @type {any}
     * @memberof VueCron
     */ 
    public dVal: any = '';

    /**
     * 标签-时 数据
     *
     * @type {any}
     * @memberof VueCron
     */ 
    public hVal: any = '';

    /**
     * 标签月 数据
     *
     * @type {any}
     * @memberof VueCron
     */ 
    public monthVal:any = '';

    /**
     * 标签-周 数据
     *
     * @type {any}
     * @memberof VueCron
     */ 
    public weekVal: any = '';

    /**
     * 标签年 数据
     *
     * @type {any}
     * @memberof VueCron
     */ 
    public yearVal: any = '';

    /**
     * 数据值变化
     * @returns
     * @memberof VueCron
     */
    @Watch('value')
    public updateVal() {
      if (!this.value) {
          return
        }
        let arrays: Array<any> = this.value.split(' ');
        this.sVal = arrays[0];
        this.mVal = arrays[1];
        this.hVal = arrays[2];
        this.dVal = arrays[3];
        this.monthVal = arrays[4];
        this.weekVal = arrays[5];
        this.yearVal = arrays[6];
    }

    /**
     * 获取表格内容
     * @returns
     * @memberof VueCron
     */
    get tableData() {
      return [{
        sVal: this.sVal,
        mVal: this.mVal,
        hVal: this.hVal,
        dVal: this.dVal,
        monthVal: this.monthVal,
        weekVal: this.weekVal,
        yearVal: this.yearVal
      }]
    }

    /**
     * 获取Cron表达式
     * @returns
     * @memberof VueCron
     */
    get _value() {
      if (!this.dVal && !this.weekVal) {
        return '';
      }
      if (this.dVal === '?' && this.weekVal === '?') {
        this.$message.error(this.$t('components.cronEditor.message.error1') as string);
      }
      if (this.dVal !== '?' && this.weekVal !== '?') {
        this.$message.error(this.$t('components.cronEditor.message.error1') as string);
      }
      let v: any = `${this.sVal} ${this.mVal} ${this.hVal} ${this.dVal} ${this.monthVal} ${this.weekVal} ${this.yearVal}`;
      if (v !== this.value) {
        this.$emit('cronValue', v);
      }
      this.value = v;
      return v;
    }

    /**
     * Vue生命周期
     * @returns
     * @memberof VueCron
     */
    public created() {
      if(!this.value) {
        this.value = '';
      }
      this.updateVal();
    }

}

</script>


<style lang="less">
.cron {
  text-align: left;
  padding: 10px;
  background: #fff;
  border: 1px solid #dcdfe6;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,.12), 0 0 6px 0 rgba(0,0,0,.04);
}
</style>
