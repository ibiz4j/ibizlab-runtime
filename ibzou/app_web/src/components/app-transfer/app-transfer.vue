<template>
  <Select
    @on-open-change="transferRefresh"
    @on-change="dataChange"
    v-model="dataRight"
    :style="{width:width}"
    multiple
  >
    <Option class="hidden" :value="item" v-for="(item,i) in dataRight" :key="i">{{findLabel(item)}}</Option>
    <el-transfer v-model="dataRight" :data="dataLeft" @change="dataChange" :titles="['未选择', '已选择']"></el-transfer>
  </Select>
</template>
<script lang="ts">
import { Vue, Component, Watch, Prop, Model } from "vue-property-decorator";
import CodeListService from "@service/app/codelist-service";
import { ElSelect } from "element-ui/types/select";

@Component({})
export default class AppTransfer extends Vue {
  
  /**
   * 左侧框数据
   */
  public dataLeft: any[] = [];

  /**
   * 右侧框数据
   */
  public dataRight: any[] = [];

  /**
   * 穿梭框宽度
   */
  @Prop() public width:any;

  /**
   * 代码表服务对象
   *
   * @type {CodeListService}
   * @memberof AppTransfer
   */

  public codeListService: CodeListService = new CodeListService({
    $store: this.$store
  });

  /**
   * 查询参数
   * @type {*}
   * @memberof AppTransfer
   */
  public queryParam: any;

  /**
   * 表单传入字符串值分隔符
   */
  @Prop() public valueSeparator?: string;
  /**
   * 当前选中值
   * @type {any}
   * @memberof AppTransfer
   */
  @Model("change") public itemValue!: any;

  /**
   * 代码表标识
   *
   * @type {string}
   * @memberof AppTransfer
   */
  @Prop() public tag?: string;

  /**
   * 代码表类型
   *
   * @type {string}
   * @memberof AppTransfer
   */
  @Prop() public codelistType?: string;

  /**
   * 组件change事件,右侧框数据变化时
   * @memberof AppTransfer
   */
  dataChange(e: any) {
    let newVal: any;
    newVal = e.join(`${this.valueSeparator}`);
    if (newVal) {
      this.$emit("change", newVal);
    } else {
      this.$emit("change", null);
    }
  }

  /**
   * 传入额外参数
   *
   * @type {*}
   * @memberof AppTransfer
   */
  @Prop() public itemParam?: any;

  /**
   * 视图上下文
   *
   * @type {*}
   * @memberof AppAutocomplete
   */
  @Prop() public context!: any;

  /**
   * 视图参数
   *
   * @type {*}
   * @memberof AppFormDRUIPart
   */
  @Prop() public viewparams!: any;

  /**
   * 是否禁用
   * @type {any}
   * @memberof AppTransfer
   *
   */
  @Prop() public disabled?: any;

  /**
   * 是否支持过滤
   * @type {boolean}
   * @memberof AppTransfer
   */
  @Prop() public filterable?: boolean;

  /**
   * 下拉选提示内容
   * @type {string}
   * @memberof AppTransfer
   */
  @Prop() public placeholder?: string;

  /**
   * vue  生命周期
   *
   * @memberof AppTransfer
   */
  public created() {
    this.dataHandle();
  }

  /**
   * 数据处理
   */
  public dataHandle() {
    if (this.tag && Object.is(this.codelistType, "STATIC")) {
      const codelist = this.$store.getters.getCodeList(this.tag);
      if (codelist) {
        this.dataLeft = [...JSON.parse(JSON.stringify(codelist.items))];
        this.initLeft();
        this.initRight();
      } else {
        console.log(`----${this.tag}----代码表不存在`);
      }
    } else if (this.tag && Object.is(this.codelistType, "DYNAMIC")) {
      // 处理公共参数
      let data: any = {};
      this.handlePublicParams(data);
      // 参数处理
      let _context = data.context;
      let _param = data.param;
      this.codeListService
        .getItems(this.tag, _context, _param)
        .then((res: any) => {
          this.dataLeft = res;
          this.initLeft();
          this.initRight();
        })
        .catch((error: any) => {
          console.log(`----${this.tag}----代码表不存在`);
        });
    }
  }

  /**
   * 公共参数处理
   *
   * @param {*} arg
   * @returns
   * @memberof AppTransfer
   */
  public handlePublicParams(arg: any) {
    // 合并表单参数
    arg.param = this.viewparams
      ? JSON.parse(JSON.stringify(this.viewparams))
      : {};
    arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
    // 附加参数处理
    if (this.itemParam && this.itemParam.context) {
      let _context = this.$util.formatData(
        this.itemValue,
        arg.context,
        this.itemParam.context
      );
      Object.assign(arg.context, _context);
    }
    if (this.itemParam && this.itemParam.param) {
      let _param = this.$util.formatData(
        this.itemValue,
        arg.param,
        this.itemParam.param
      );
      Object.assign(arg.param, _param);
    }
  }
  /**
   * 初始化左侧框数据
   */
  public initLeft() {
    let left: any[] = [];
    Object.assign(left, this.dataLeft);
    this.dataLeft = [];
    left.forEach((elem: any, i: any) => {
      this.dataLeft.push({
        key: elem.id,
        value: elem.value,
        label: elem.label,
        disabled: elem.disabled
      });
    });
  }
  /**
   * 初始化右侧框数据
   */
  public initRight() {
    let _data: any = this.itemValue;
    if (_data) {
      let newData: any[] = _data.split(`${this.valueSeparator}`);
      this.dataLeft.forEach((elem: any) => {
        newData.forEach((item: any) => {
          if (item === elem.value) {
            this.dataRight.push(elem.key);
          }
        });
      });
    }
  }
  /**
   * 穿梭框打开时刷新数据
   */
  public transferRefresh(e: any) {
    if (e && this.codelistType === "DYNAMIC") {
      this.dataLeft = [];
      this.dataRight = [];
      this.dataHandle();
    }
  }

  /**
   * 找到dataLeft中key与dataRight中item相等的元素，返回label
   */
  public findLabel(item: any) {
    for (const elem of this.dataLeft) {
      if (elem.key === item) return elem.label;
    }
  }
}
</script>

<style lang='less'>
@import "./app-transfer.less";
</style>