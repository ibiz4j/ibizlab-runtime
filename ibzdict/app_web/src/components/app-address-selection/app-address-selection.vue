<template>
    <div class="appAddressSelection">
        <el-cascader
            style="width:100%"
            :disabled="disabled"
            size ="medium"
            v-model="CurrentVal"
            :options="city">
        </el-cascader>
    </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import axios from 'axios';
import { cityCode } from './city_code'
@Component({})
export default class AppAddressSelection extends Vue {

 /**
   * 传入值
   * @type {any}
   * @memberof AppAddressSelection
   */
  @Prop() public value?:any;

  /**
   * 是否禁用
   * @type {boolean}
   * @memberof AppAddressSelection
   */
  @Prop() public disabled?: boolean;


  /**
   * 当前值
   *
   * @memberof AppAddressSelection
   */
  get CurrentVal() {
        return this.value;
  }

 /**
   * 值变化
   *
   * @memberof AppAddressSelection
   */
  set CurrentVal(val: any) {
      this.$emit("change", val); 
  }

 /**
   * 城市数据
   *
   * @memberof AppAddressSelection
   */
    public city :any = [];

 /**
   * 获取城市数据
   *
   * @memberof AppAddressSelection
   */
    public  getcity() {
        this.format(cityCode);

    }
    /**
   * 生命周期
   *
   * @memberof AppAddressSelection
   */
    public created() {
        this.getcity();
    }

 /**
   * 数据格式化
   *
   * @memberof AppAddressSelection
   */
    public format(data :any) {
        let town  = JSON.parse(JSON.stringify(data).replace(/city/g, 'children')) 
        let county = JSON.parse(JSON.stringify(town).replace(/name/g, 'label')) 
        let city = JSON.parse(JSON.stringify(county).replace(/area/g, 'children')) 
        let province = JSON.parse(JSON.stringify(city).replace(/code/g, 'value')) 
        this.city = province;
    }
    
}
</script>

<style lang='less'>
@import './app-address-selection.less';
</style>