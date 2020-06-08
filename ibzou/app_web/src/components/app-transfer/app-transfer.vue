<template>
  <Select v-model="dataRight" style="width:586px" multiple>
    <Option
      class="hidden"
      :value="item"
      v-for="(item,i) in dataRight"
      :key="i"
    >{{dataLeft[item-1].label}}</Option>
    <el-transfer v-model="dataRight" :data="dataLeft" @change=dataChange></el-transfer>
  </Select>
</template>
<script lang="ts">
import { Vue, Component, Watch, Prop, Model } from "vue-property-decorator";
import CodeListService from "@service/app/codelist-service";

@Component({})
export default class FromTransfer extends Vue {
  /**
   * 表单传递右侧框中的数据
   */
  @Prop() public data: any;
  /**
   * 左侧框数据
   */
  public dataLeft: any[] = [];
  /**
   * 右侧框数据
   */
  public dataRight: any[] = [];
  /**
   * 代码表服务对象
   *
   * @type {CodeListService}
   * @memberof FromTransfer
   */

  public codeListService: CodeListService = new CodeListService({
    $store: this.$store
  });

  /**
   * 额外参数
   *
   * @type {*}
   * @memberof FromTransfer
   */
  public otherParam: any;

  /**
   * 查询参数
   * @type {*}
   * @memberof FromTransfer
   */
  public queryParam: any;

  /**
   * 当前选中值
   * @type {any}
   * @memberof Drop
   */
  @Model("change") readonly itemValue!: any;

  /**
   * 代码表标识
   *
   * @type {string}
   * @memberof FromTransfer
   */
  @Prop() public tag?: string;

  /**
   * 代码表类型
   *
   * @type {string}
   * @memberof FromTransfer
   */
  @Prop() public codelistType?: string;


  /**
   * 监听表单数据
   *
   * @memberof FromTransfer
   */

  @Watch("data", { deep: true })
  onDataChange(newVal: any, val: any) {
    if (newVal) {
    }
  }
  /**
   * 组件change事件,右侧框数据变化时
   * @memberof FromTransfer
   */
  dataChange(e:any){
    console.log(e);
    let val:any[]=[];
    let newVal:any;
    this.dataLeft.forEach((elem: any) => {
      e.forEach((item: any) => {
        if (elem.key === item) val.push(elem.value);
      });
    });
    newVal=val.join(',');
    console.log(newVal);
    this.$emit("change", newVal);
  }

  /**
   * 传入额外参数
   *
   * @type {*}
   * @memberof FromTransfer
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
   * @memberof FromTransfer
   *
   */
  @Prop() public disabled?: any;

  /**
   * 是否支持过滤
   * @type {boolean}
   * @memberof FromTransfer
   */
  @Prop() public filterable?: boolean;

  /**
   * 下拉选提示内容
   * @type {string}
   * @memberof FromTransfer
   */
  @Prop() public placeholder?: string;

  /**
   * 计算属性(当前值)
   * @type {any}
   * @memberof FromTransfer
   */
  set currentVal(val: any) {
    // const type: string = this.$util.typeOf(val);
    // val =
    //   Object.is(type, "null") || Object.is(type, "undefined") ? undefined : val;
    // this.dataLeft.forEach((elem: any) => {
    //   this.dataRight.forEach((item: any) => {
    //     if (elem.key === item) val.push(elem.value);
    //   });
    // });
    // val=val.join(',');
    // this.$emit("change", val);
  }

  /**
   * 获取值对象
   *
   * @memberof FromTransfer
   */
  // get currentVal() {
  //   return this.itemValue;
  // }
  get currentVal() {
    return this.itemValue;
  }

  /**
   * 代码表
   *
   * @type {any[]}
   * @memberof FromTransfer
   */
  // public items: any[] = [];

  /**
   * 公共参数处理
   *
   * @param {*} arg
   * @returns
   * @memberof FromTransfer
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
        this.data,
        arg.context,
        this.itemParam.context
      );
      Object.assign(arg.context, _context);
    }
    if (this.itemParam && this.itemParam.param) {
      let _param = this.$util.formatData(
        this.data,
        arg.param,
        this.itemParam.param
      );
      Object.assign(arg.param, _param);
    }
  }

  /**
   * vue  生命周期
   *
   * @memberof FromTransfer
   */
  public created() {
    this.dataHandle();
    this.initRight();
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
        console.log(this.dataLeft);
      } else {
        console.log(`----${this.tag}----代码表不存在`);
      }
    } else if (this.tag && Object.is(this.codelistType, "DYNAMIC")) {
      // 公共参数处理
      let data: any = {};
      this.handlePublicParams(data);
      // 参数处理
      let _context = data.context;
      let _param = data.param;
      this.codeListService
        .getItems(this.tag, _context, _param)
        .then((res: any) => {
          this.dataLeft = res;
          console.log(this.dataLeft);

          this.initLeft();
        })
        .catch((error: any) => {
          console.log(`----${this.tag}----代码表不存在`);
        });
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
        key: i + 1,
        id: elem.id,
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
    if (this.data) {
      this.data.forEach((elem: any) => {
        this.dataRight.push(elem);
      });
    }
  }
}
</script>

<style lang='less'>
@import "./app-transfer.less";
</style>