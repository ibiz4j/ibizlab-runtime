<template>
    <div :class="classes">
        <div v-if="Object.is(labelPos,'NONE') || !labelPos" class="editor">
            <div :class="valueCheck == true ?'':'editorstyle'">
              <slot ></slot>
              <span :class="error ? 'errorstyle':''">{{error}}</span>
            </div>
        </div>
        <div v-if="!Object.is(labelPos,'NONE')" class="app-panel-field-label">
            <span v-if="required" style="color:red;">* </span>
            {{isEmptyCaption ? '' : caption}}
        </div>
        <div v-if="Object.is(labelPos,'BOTTOM') || Object.is(labelPos,'TOP') || Object.is(labelPos,'LEFT') || Object.is(labelPos,'RIGHT')" class="editor">
          <div :class="valueCheck == true ?'':'editorstyle'">
            <slot ></slot>
            <span :class="error ? 'errorstyle':''">{{error}}</span>
          </div>
        </div>
    </div>
</template>
<script lang="ts">
import { Vue, Component, Prop, Watch } from "vue-property-decorator";

@Component({})
export default class AppPanelField extends Vue {
  /**
   * 名称
   *
   * @type {string}
   * @memberof AppPanelField
   */
  @Prop() public caption!: string;

  /**
   * 错误信息
   *
   * @type {string}
   * @memberof AppPanelField
   */
  @Prop() public error?: string;

  /**
   * 标签位置
   *
   * @type {(string | 'BOTTOM' | 'LEFT' | 'NONE' | 'RIGHT' | 'TOP')}
   * @memberof AppPanelField
   */
  @Prop() public labelPos?:
    | string
    | "BOTTOM"
    | "LEFT"
    | "NONE"
    | "RIGHT"
    | "TOP";

  /**
   * 标签是否空白
   *
   * @type {boolean}
   * @memberof AppPanelField
   */
  @Prop() public isEmptyCaption?: boolean;

  /**
   * 列表项名称
   *
   * @type {string}
   * @memberof AppPanelField
   */
  @Prop() public name!: string;

  /**
   * 面板数据
   *
   * @type {any}
   * @memberof AppPanelField
   */
  @Prop() public data!: any;

  /**
   * 编辑器值
   *
   * @type {any}
   * @memberof AppPanelField
   */
  @Prop() public value !: any;

  /**
   * 值规则
   *
   * @type {string}
   * @memberof AppPanelField
   */
  @Prop() public itemRules!: any;
  
  /**
   * 是否必填
   *
   * @type {boolean}
   * @memberof AppPanelField
   */
  public required: boolean = false;

  /**
   * 值规则数组
   *
   * @type {any[]}
   * @memberof AppPanelField
   */
  public rules: any[] = [];

  /**
   * 值规则监控
   *
   * @param {*} newVal
   * @param {*} oldVal
   * @memberof AppPanelField
   */
  @Watch("itemRules", { deep: true })
  onItemRulesChange(newVal: any, oldVal: any) {
    if (newVal) {
      try {
        this.rules = [];
        const _rules: any[] = newVal;
        this.rules = [..._rules];
        this.rules.some((rule: any) => {
          if (rule.hasOwnProperty("required")) {
            this.required = rule.required;
            return true;
          }
          return false;
        });
      } catch (error) {}
    }
  }

  /**
   * 编辑器样式
   *
   * @type {boolean}
   * @memberof AppPanelField
   */
  public valueCheck: boolean = true;

  /**
   * 编辑器值监控
   *
   * @param {*} newVal
   * @param {*} oldVal
   * @memberof AppPanelField
   */
  @Watch("value")
  ItemValueRules(newVal: any, oldVal: any) {
    if(this.required && !newVal) {
        this.valueCheck = false;
    }else{
        this.valueCheck = true;
    }
  }

  /**
   * 计算样式
   *
   * @readonly
   * @type {string []}
   * @memberof AppPanelField
   */
  get classes(): string[] {
    let posClass = "";
    switch (this.labelPos) {
      case "TOP":
        posClass = "label-top";
        break;
      case "LEFT":
        posClass = "label-left";
        break;
      case "BOTTOM":
        posClass = "label-bottom";
        break;
      case "RIGHT":
        posClass = "label-right";
        break;
      case "NONE":
        posClass = "label-none";
        break;
    }
    return [ "app-panel-field", posClass ];
  }

  /**
   * vue 生命周期
   *
   * @memberof AppPanelField
   */
  public mounted() {
    if (this.itemRules) {
      try {
        const _rules: any[] = this.itemRules;
        this.rules = [..._rules];
        this.rules.some((rule: any) => {
          if (rule.hasOwnProperty("required")) {
            this.required = rule.required;
            return true;
          }
          return false;
        });
      } catch (error) {}
    }
  }
}
</script>
<style lang='less'>
@import "./app-panel-field.less";
</style>