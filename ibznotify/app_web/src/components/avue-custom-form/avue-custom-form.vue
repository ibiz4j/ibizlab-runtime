<template>
  <div v-if="formOption!=null" class="app-custom-form">
    <avue-form :option="formOption" v-model="formVal"></avue-form>
  </div>
</template>

<script lang="ts">
import {
  Vue,
  Component,
  Prop,
  Model,
  Emit,
  Watch,
} from "vue-property-decorator";

import { Subject, Subscription } from "rxjs";
@Component({})
export default class AvueCustomForm extends Vue {
  /**
   * 编辑器参数传入组件配置
   *
   * @type {*}
   * @memberof AvueCustomForm
   */
  public options: any;

  /**
   * 是否需要转换为string类型
   *
   * @type {boolean}
   * @memberof AvueCustomForm
   */
  @Prop() public isParseString?: boolean;

  /**
   * 远端地址
   *
   * @type {string}
   * @memberof AvueCustomForm
   */
  @Prop() public url?: string;

  /**
   * 表单项值
   *
   * @type {any}
   * @memberof AvueCustomForm
   */
  @Model("change") public value: any;

  /**
   * 是否将表单数据通过组件配置带入组件中
   *
   * @type {boolean}
   * @memberof AvueCustomForm
   */
  @Prop() public isFormData?: boolean;

  /**
   * 是否为子表单
   *
   * @type {boolean}
   * @memberof AvueCustomForm
   */
  @Prop() public isSubForm?: boolean;

  /**
   * 表单数据
   *
   * @type {*}
   * @memberof AvueCustomForm
   */
  @Prop()
  public formData?: any;

  /**
   * 表单状态
   *
   * @type {Subject<any>}
   * @memberof AvueCustomForm
   */
  @Prop() public formState!: Subject<any>;

  /**
   * 获取组件值
   *
   * @return {any}
   * @memberof AvueCustomForm
   */
  get formVal() {
    let obj: any = {};
    if (this.value) {
      if (this.isParseString) obj = JSON.parse(this.value);
      else obj = this.value;
      if (this.isSubForm && obj instanceof Array)
        obj = this.loadSubFormData(obj);
    }
    return obj;
  }

  /**
   * 设置组件值
   *
   * @param value
   * @memberof AvueCustomForm
   */
  set formVal(value: any) {
    this.setValue(value);
  }

  /**
   * 订阅对象
   *
   * @protected
   * @type {(Subscription | undefined)}
   * @memberof AvueCustomForm
   */
  protected formStateEvent: Subscription | undefined;

  /**
   * 当前组件配置设置属性
   *
   * @type {*}
   * @memberof AvueCustomForm
   */
  public formOption: any = null;

  /**
   * avue-form默认配置
   *
   * @type {*}
   * @memberof AvueCustomForm
   */
  public defaultOptions: any = {
    column: [
      {
        type: "dynamic",
        label: "子表单",
        span: 24,
        display: true,
        children: {
          align: "center",
          headerAlign: "center",
          index: false,
          addBtn: true,
          delBtn: true,
          column: [
            {
              type: "input",
              label: "属性",
              span: 24,
              display: true,
              prop: "property",
            },
            {
              type: "input",
              label: "值",
              span: 24,
              display: true,
              prop: "value",
            },
          ],
        },
        prop: "1599476281048_17916",
      },
    ],
    labelPosition: "left",
    labelSuffix: "：",
    labelWidth: 120,
    gutter: 0,
    menuBtn: false,
    submitBtn: false,
    submitText: "提交",
    emptyBtn: false,
    emptyText: "清空",
    menuPosition: "center",
  };

  /**
   * vue生命周期
   *
   * @memberof AvueCustomForm
   */
  public mounted() {
    let that: any = this;
    if (this.formState) {
      this.formStateEvent = this.formState.subscribe(({ type, data }) => {
        if (Object.is("load", type)) that.load();
      });
    }
  }

  /**
   * 加载表单配置,配置优先级,依次按优先级加载(表单项值  >   远端请求  >   默认值)
   *
   * @memberof AvueCustomForm
   */
  public async load() {
    let that: any = this;
    if (!this.options && this.options == null) {
      if (this.url && this.options == null) {
        const get: Promise<any> = this.$http.get(this.url);
        await get.then((response: any) => {
          if (response && response.data) {
            let options: any = response.data;
            this.transitionDicUrlCondition(options);
            that.formOption = options;
            if (that.isFormData) that.getFormData();
          }
        });
      } else {
        this.transitionDicUrlCondition(this.defaultOptions);
        this.formOption = this.defaultOptions;
        if (this.isFormData) that.getFormData();
      }
    } else {
      this.transitionDicUrlCondition(this.options);
      this.formOption = this.options;
      if (this.isFormData) that.getFormData();
    }
  }

  /**
   * 当组件配置中的属性与表单属性重复时,表单值塞入组件中
   *
   * @memberof AvueCustomForm
   */
  public getFormData() {
    let that: any = this;
    let obj: any;
    if (this.formVal) obj = JSON.parse(JSON.stringify(this.formVal));
    else obj = {};
    let recursionOption: any = function (group: any) {
      group.column.forEach((gItem: any) => {
        if (group.column && group.column.length > 0) {
          if (that.formData[gItem.prop])
            obj[gItem.prop] = that.formData[gItem.prop];
        }
      });
      if (group.group && group.group.length > 0)
        group.group.forEach((gItem: any) => {
          recursionOption(gItem);
        });
    };
    recursionOption(this.formOption);
    this.setValue(obj);
  }

  /**
   * 设置表单值
   *
   * @param {*} value
   * @memberof AvueCustomForm
   */
  public setValue(value: any) {
    if (this.isSubForm) value = this.getSubFormData(value);
    if (this.isParseString) this.$emit("change", JSON.stringify(value));
    else this.$emit("change", value);
  }

  /**
   * 提取第一个属性值
   *
   * @memberof AvueCustomForm
   * @return {Array<any>}
   */
  public getSubFormData(value: any): Array<any> {
    let arr: Array<any> = [];
    for (let val in value) {
      arr = value[val];
      break;
    }
    return arr;
  }

  /**
   * 加载子表单值
   *
   * @memberof AvueCustomForm
   * @return {*}
   */
  public loadSubFormData(arr: Array<any>): any {
    let value: any = {};
    value[this.formOption.column[0].prop] = arr;
    return value;
  }

  /**
   * 配置的下拉列表转换符号支持动态配置
   *
   * @memberof AvueCustomForm
   * @param {*}
   */
  public transitionDicUrlCondition(options: any) {
    let that: any = this;
    let recursive: any = function (obj: any) {
      if (obj.column && obj.column.length > 0) {
        obj.column.forEach((col: any) => {
          if (col.dicUrl && col.dicUrl.indexOf("$") > 0) {
            let g = /\${[^+]+}/;
            let dicGroup = col.dicUrl.match(g);
            dicGroup.forEach((dic: any) => {
              col.dicUrl = col.dicUrl.replace(
                dic,
                that.formData[dic.substring(2, dic.length - 1)]
              );
            });
          }
          if (col.children) recursive(col.children);
          if (col.group) recursive(col.group);
        });
      }
      if (obj.children) recursive(obj.children);
      if (obj.group) recursive(obj.group);
    };
    recursive(options);
  }

  /**
   * 销毁组件(vue生命周期)
   *
   * @type {Subject<any>}
   * @memberof AvueCustomForm
   */
  public destroy() {
    if (this.formStateEvent) {
      this.formStateEvent.unsubscribe();
    }
  }
}
</script>