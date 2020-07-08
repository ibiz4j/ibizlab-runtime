<template>
  <div class="input-unit">
    <InputNumber v-if="type === 'number'"
      :id="numberId"
      :placeholder="placeholder"
      :size="size"
      :precision="precision"
      v-model="CurrentVal"
      :disabled="disabled ? true : false"
      :formatter="formatter"
      :parser="parser"
    ></InputNumber>
    <i-input v-else
      :placeholder="placeholder"
      :size="size"
      :type="type"
      v-model="CurrentVal"
      :disabled="disabled ? true : false"
      :element-id="textareaId"
      @on-enter="enter"
    ></i-input>
    <div class="unit-text">{{unit}}</div>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit } from "vue-property-decorator";
import { Subject } from "rxjs";
import { debounceTime, distinctUntilChanged } from "rxjs/operators";

@Component({})
export default class InputBox extends Vue {
  
  /**
   * 双向绑定值
   * @type {any}
   * @memberof InputBox
   */
  @Model("change") readonly itemValue?: any;

  /**
   * 生命周期 （多行文本十行高度问题）
   * @type {any}
   * @memberof InputBox
   */
  public mounted(){
    this.addEvent();
    if(this.textareaId){
      let textarea :any= document.getElementById(this.textareaId);
      if(textarea){
        textarea.style=this.textareaStyle;
      }
    }
  }

  /**
   * 单位
   * @type {String}
   * @memberof InputBoxUnit
   */
  @Prop() public unit?: string;


  /**
   * 多行文本十行 特殊参数样式（模型高度自带）
   * @type {String}
   * @memberof InputBoxUnit
   */
  @Prop() public textareaStyle?: string;

  /**
   * 多行文本十行 特殊参数id（模型高度自带）
   * @type {String}
   * @memberof InputBoxUnit
   */
  @Prop() public textareaId?: string;
  /**
   * 大小
   * @type {String}
   * @memberof InputBoxUnit
   */
  @Prop() public size?: string;

  /**
   * placeholder值
   * @type {String}
   * @memberof InputBox
   */
  @Prop() public placeholder?: string;

  /**
   * 是否禁用
   * @type {boolean}
   * @memberof InputBox
   */
  @Prop() public disabled?: boolean;

  /**
   * 属性类型
   *
   * @type {string}
   * @memberof InputBox
   */
  @Prop() public type?: string;

  /**
   * 精度
   *
   * @type {number}
   * @memberof InputBox
   */
  @Prop({default: 0}) public precision?: number;

  /**
   * 多行文本行数
   *
   * @type {string}
   * @memberof InputBox
   */
  @Prop() public autoSize?: any;

  /**
   * 数值框numberId
   */
  public numberId :string= this.$util.createUUID();

  /**
   * 当前值
   *
   * @memberof InputBox
   */
  get CurrentVal() {
    if(Object.is(this.type, 'number') && this.itemValue && !isNaN(this.itemValue)){
      return Number(Number(this.itemValue).toFixed(this.precision));
    }else{
      return this.itemValue;
    }
  }

  /**
   * 值变化
   *
   * @memberof InputBox
   */
  set CurrentVal(val: any) {
    let _data: any = val;
    if (Object.is(this.type, "number") && val && !isNaN(val)) {
      try {
        _data = isNaN(Number(val)) ? null : Number(val);
      } catch (error) {}
    }
    if (Object.is(_data, "")) {
      _data = null;
    }
    this.$emit("change", _data);
  }

  /**
   * 回车事件
   *
   * @param {*} $event
   * @memberof InputBox
   */
  @Emit()
  public enter($event: any) {
    if (!$event || $event.keyCode !== 13) {
      return;
    }
    return $event;
  }

  /**
   * 给数值框中的箭头按钮添加事件
   * 
   * @memberof InputBox
   */
  public addEvent(){
    if(Object.is(this.type, "number")){
      let inputNumber :any = document.getElementById(this.numberId);
      let handlerWrap :any = inputNumber.firstElementChild;
      handlerWrap.onmouseover=()=>{
        inputNumber.style.paddingRight="15px";
        inputNumber.style.transition="all 0.2s linear";
      }
      handlerWrap.onmouseout=()=>{
        inputNumber.style.paddingRight="0px";
      }
    }
  }

  /**
   * 指定输入框展示值的格式
   */
  public formatter(value:any){
    if(this.precision===0) return this.CurrentVal;
    if(value.indexOf('.')!==-1){
      let arr:Array<any> = value.split('.');
      if(arr[1]==='00'){
        return arr[0];
      }
      if(parseInt(arr[1])%10===0){
        return arr[0]+'.'+parseInt(arr[1])/10;
      }
    }
    return value;
  }

  /**
   * 指定从 formatter 里转换回数字的方式
   */
  public parser(value:any){
    return value;
  }
}
</script>

<style lang='less'>
@import "./input-box.less";
</style>