<template>
    <Select
        v-model="value[0]"
        class="transfer-select"
        @on-change='handleCronChange'
        :disabled="disabled"
        :placeholder="placeholder">
        <Option class="hidden" v-for="(item,i) in value" :value="item" :label="item" :key="i">
        </Option>
        <vue-cron class='vue-cron'  @cronValue='handleCronChange'></vue-cron>
    </Select>
    
</template>


<script lang="ts">
import { Vue, Component, Prop, Watch, Model } from 'vue-property-decorator';
import VueCron from './vue-cron/vue-cron.vue';

@Component({
    components: {
        'vue-cron': VueCron,
    }
})
export default class CronEditor extends Vue {
    
    /**
     * 启用状态
     *
     * @type {any}
     * @memberof CronEditor
     */ 
    @Prop() disabled: any;

    /**
     * 下拉框显示值
     *
     * @type {any}
     * @memberof CronEditor
     */ 
    @Prop() placeholder:any;

    /**
     * 绑定Cron表达式
     * 
     * @type {any[]}
     * @memberof CronEditor
     */
    public value: any[] = [];

    /**
     * 处理返回Cron表达式
     *
     * @type {any}
     * @memberof CronEditor
     */ 
    public handleCronChange(val: any) {
        this.value[0] = val;
        this.value.push(val);
    }

    /**
     * Vue生命周期
     * 
     */
    public created() {
        this.value[0] = '';
    }
}

</script>

<style lang="less">
.transfer-select{
  .ivu-select-dropdown {
      padding: 0px;
      overflow: inherit;
      .hidden {
          display: none;
      }
      .vue-cron{
          min-width: 100% !important;
      }
  }
}

</style>