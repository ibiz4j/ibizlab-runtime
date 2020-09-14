<template>
  <div v-if="formOption!=null" class="app-custom-form">
    <avue-form :option="formOption" v-model="formvalue"></avue-form>
  </div>
</template>

<script lang="ts">
import {Vue,Component,Prop,Model,Emit,Watch,} from "vue-property-decorator";
import { Subject, Subscription } from "rxjs";

@Component({})
export default class AvueCustomForm extends Vue {
  /**
   * 编辑器参数传入组件配置
   *
   * @type {any}
   * @memberof AvueCustomForm
   */
  @Prop()
  public options?: any;

  /**
   * 是否需要转换为string类型
   *
   * @type {boolean}
   * @memberof AvueCustomForm
   */
  @Prop()
  public isParseString?: boolean;

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
  @Prop() public value: any;

  /**
   * 是否将表单数据通过组件配置带入组件中
   *
   * @type {boolean}
   * @memberof AvueCustomForm
   */
  @Prop() public isFormData?: boolean;

  /**
   * 监听事件
   *
   * @param {*} newVal
   * @param {*} oldVal
   * @memberof AvueCustomForm
   */
  @Watch("value")
  public onValueChange(newVal: any, oldVal: any) {
    if (newVal) {
      let obj: any = {};
      if (newVal && newVal != null) {
        if (this.isParseString) obj = JSON.parse(newVal);
        else obj = newVal;
      }
      if (obj) this.formvalue = JSON.parse(JSON.stringify(obj));
    }
  }

  /**
   * 表单数据
   *
   * @type {any}
   * @memberof AvueCustomForm
   */
  @Prop()
  public formData: any;

  /**
   * 表单状态
   *
   * @type {Subject<any>}
   * @memberof AvueCustomForm
   */
  @Prop() public formState!: Subject<any>;

  /**
   * 视图状态事件
   *
   * @protected
   * @type {(Subscription | undefined)}
   * @memberof AvueCustomForm
   */
  protected formStateEvent: Subscription | undefined;

  /**
   * 当前组件配置设置属性
   *
   * @type {any}
   * @memberof AvueCustomForm
   */
  public formOption: any = null;

  /**
   * avue-form绑定值
   *
   * @type {any}
   * @memberof AvueCustomForm
   */
  public formvalue: any = {};

  /**
   * avue-form默认配置
   *
   * @type {any}
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
  public load() {
    let that: any = this;
    if (!this.options && this.options == null) {
      if (this.url && this.options == null) {
        const get: Promise<any> = this.$http.get(this.url);
        get.then((response: any) => {
          if (response && response.data && response.data.view_config) {
            that.formOption = JSON.parse(response.data.view_config)[
              "formConfig"
            ];
            if (this.isFormData) that.getFormData();
          }
        });
      } else {
        this.formOption = this.defaultOptions;
        if (this.isFormData) that.getFormData();
      }
    } else {
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
    if (this.value) obj = JSON.parse(JSON.stringify(this.value));
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
    if (this.isParseString) this.$emit("change", JSON.stringify(value));
    else this.$emit("change", value);
  }
}
</script>