
<template>
  <div class="view-container dempickupview sys-permissionmpickup-view">
    <card class='view-card view-no-caption  view-no-toolbar' :dis-hover="true" :padding="0" :bordered="false">
      <div class="content-container pickup-view">
        <div class="translate-contant">
          <!--应用菜单-->
          <div class="center" :style="{width : '33%',border:'1px solid #dcdee2', margin: '0 10px 0 0'}">
            <context-menu-container class='design-tree-container'>
              <div>
                <!--<div class="text">应用菜单</div>-->
                <div style="margin: 20px 20px 0 20px;">
                  <el-input size="small" placeholder="搜索应用菜单..." v-model="CDtreefilterText" @input="filterChangeCDtree">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                  </el-input>
                </div>
                <div class="roll">
                  <el-tree :filter-node-method="fiterNode" class="tre" :data="this.CDdata" ref="CDtree" show-checkbox node-key="id" :default-expand-all="false" highlight-current :default-expanded-keys="this.CDdataexpandedKeys" :props="this.defaultProps" @check-change="handleCheckChange">
                  </el-tree>
                </div>
              </div>
            </context-menu-container>
          </div>
          <!--数据能力-->
          <div class="center" :style="{width : '33%',border:'1px solid #dcdee2', margin: '0 10px 0 0' }">
            <context-menu-container class='design-tree-container'>
              <div>
                <!--<div class="text">数据能力</div>-->
                <div style="margin: 20px 20px 0 20px;">
                  <el-input size="small" placeholder="搜索数据能力..." v-model="QXtreefilterText" @input="filterChangeQXtree">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                  </el-input>
                </div>
                <div class="roll">
                  <el-tree :filter-node-method="fiterNode" class="tre" :data="this.QXdata" ref="QXtree" show-checkbox node-key="id" :default-expand-all="false" highlight-current :default-expanded-keys="this.QXdataexpandedKeys" :props="this.defaultProps" @check-change="handleCheckChange">
                  </el-tree>
                </div>
              </div>
            </context-menu-container>
          </div>
          <!--自定义资源-->
          <div class="center" :style="{width : '33%',border:'1px solid #dcdee2' }">
            <context-menu-container class='design-tree-container'>
              <div>
                <!--<div class="text">自定义资源</div>-->
                <div style="margin: 20px 20px 0 20px;">
                  <el-input size="small" placeholder="搜索自定义资源..." v-model="ZYtreefilterText" @input="filterChangeZYtree">
                    <i slot="prefix" class="el-input__icon el-icon-search"></i>
                  </el-input>
                </div>
                <div class="roll">
                  <el-tree :filter-node-method="fiterNode" class="tre" :data="this.ZYdata" ref="ZYtree" show-checkbox node-key="id" :default-expand-all="false" highlight-current :default-expanded-keys="this.ZYdataexpandedKeys" :props="this.defaultProps" @check-change="handleCheckChange">
                  </el-tree>
                </div>
              </div>
            </context-menu-container>
          </div>
        </div>

      </div>
    </card>
  </div>
</template>

<script lang='tsx'>
  import { Component, Prop, Vue, Watch } from "vue-property-decorator";
  import view_pickupviewpanel from "@widgets/sys-permission/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue";
  import ContextMenuContainer from "@components/context-menu-container/context-menu-container.vue";
  import { Subject } from "rxjs";

  @Component({
    components: {
      ContextMenuContainer,
      view_pickupviewpanel,
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
      next((vm: any) => {
        vm.$store.commit("addCurPageViewtag", {
          fullPath: to.fullPath,
          viewtag: vm.viewtag,
        });
      });
    },
  })
  export default class SYS_ROLE_PERMISSIONCustomView extends Vue {
    // 应用菜单树搜索文本
    public CDtreefilterText: any = "";
    // 数据能力树搜索文本
    public QXtreefilterText: any = "";
    // 自定义资源树搜索文本
    public ZYtreefilterText: any = "";

    /**
     * 过滤节点
     */
    public fiterNode(value: any, data: any) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    }
    /**
     *　应用菜单树搜索触发
     */
    public filterChangeCDtree() {
      const CDtree: any = this.$refs.CDtree;
      CDtree.filter(this.CDtreefilterText);
    }
    /**
     *　数据能力树搜索触发
     */
    public filterChangeQXtree() {
      const QXtree: any = this.$refs.QXtree;
      QXtree.filter(this.QXtreefilterText);
    }
    /**
     *　自定义资源树搜索触发
     */
    public filterChangeZYtree() {
      const ZYtree: any = this.$refs.ZYtree;
      ZYtree.filter(this.ZYtreefilterText);
    }

    /*应用菜单数据*/
    protected CDdata: any = [];
    /*数据能力数据*/
    protected QXdata: any = [];
    /*自定义资源数据*/
    protected ZYdata: any = [];
    /*默认选中节点*/
    protected defaultCheckedNodes: any = [];
    /*应用菜单数据默认展开节点*/
    protected CDdataexpandedKeys: any = [];
    /*数据能力数据默认展开节点*/
    protected QXdataexpandedKeys: any = [];
    /*自定义资源数据默认展开节点*/
    protected ZYdataexpandedKeys: any = [];

    /**
     * 树显示说明：子树为节点对象的children,节点标签为节点对象的label
     */
    protected defaultProps: any = {
      children: "children",
      label: "label",
    };
    /**
     * 选中数据
     */
    protected selectData: any = {};
    /**
     * 初始选中的数据
     */
    protected ininselectData: any = {};

    /**
     * 视图选中数据
     */
    public viewSelections: any[] = [];

    /**
     * 父数据
     */
    protected parentData: any = {};
    /**
     * 父数据主键
     */
    protected srfparentkey: any;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public viewtag: string = "e791be173ed0f4bbe9cce942b6edde63";

    /**
     * 是否嵌入关系界面
     *
     * @type {boolean}
     * @memberof SYS_USER_ROLEGridViewBase
     */
    @Prop({ default: false }) public isformDruipart?: boolean;

    /**
     * 界面关系通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof SYS_USER_ROLEGridViewBase
     */
    @Prop() public formDruipart?: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public context: any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public viewparams: any = {};

    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    @Prop() public viewdata!: string;

    @Watch("viewdata")
    public watchViewData() {
      if (!this.viewdata || Object.is(this.viewdata, "")) {
        return;
      }
      this.parseViewParam();
      const _this: any = this;
      // 获取父数据
      if (_this && _this.viewdata) {
        _this.parentData = JSON.parse(_this.viewdata);
      }
      if (_this.parentData && _this.parentData.sysrole) {
        // console.log("当前角色id：" + _this.parentData.sysrole);
        _this.srfparentkey = _this.parentData.sysrole;
      }
      this.initTree();
    }

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

    /**
     * 自定义视图导航上下文集合
     *
     * @type {*}
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public customViewNavContexts: any = {};
    /**
     * 自定义视图导航参数集合
     *
     * @type {*}
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public customViewParams: any = {};

    /**
     * 解析视图参数
     *
     * @public
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public parseViewParam(): void {
      for (let key in this.context) {
        delete this.context[key];
      }
      if (
              !this.viewDefaultUsage &&
              this.viewdata &&
              !Object.is(this.viewdata, "")
      ) {
        Object.assign(this.context, JSON.parse(this.viewdata));
        if (this.context && this.context.srfparentdename) {
          Object.assign(this.viewparams, {
            srfparentdename: this.context.srfparentdename,
          });
        }
        if (this.context && this.context.srfparentkey) {
          Object.assign(this.viewparams, {
            srfparentkey: this.context.srfparentkey,
          });
        }
        this.handleCustomViewData();
        return;
      }
      const path = this.$route.matched[this.$route.matched.length - 1].path;
      const keys: Array<any> = [];
      const curReg = this.$pathToRegExp.pathToRegexp(path, keys);
      const matchArray = curReg.exec(this.$route.path);
      let tempValue: Object = {};
      keys.forEach((item: any, index: number) => {
        Object.defineProperty(tempValue, item.name, {
          enumerable: true,
          value: matchArray[index + 1],
        });
      });
      this.$viewTool.formatRouteParams(
              tempValue,
              this.$route,
              this.context,
              this.viewparams
      );
      if (
              this.$store.getters.getAppData() &&
              this.$store.getters.getAppData().context
      ) {
        Object.assign(this.context, this.$store.getters.getAppData().context);
      }
      //初始化视图唯一标识
      Object.assign(this.context, { srfsessionid: this.$util.createUUID() });
      this.handleCustomViewData();
    }

    /**
     * 处理自定义视图数据
     *
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public handleCustomViewData() {
      if (Object.keys(this.customViewNavContexts).length > 0) {
        Object.keys(this.customViewNavContexts).forEach((item: any) => {
          let tempContext: any = {};
          let curNavContext: any = this.customViewNavContexts[item];
          this.handleCustomDataLogic(curNavContext, tempContext, item);
          Object.assign(this.context, tempContext);
        });
      }
      if (Object.keys(this.customViewParams).length > 0) {
        Object.keys(this.customViewParams).forEach((item: any) => {
          let tempParam: any = {};
          let curNavParam: any = this.customViewParams[item];
          this.handleCustomDataLogic(curNavParam, tempParam, item);
          Object.assign(this.viewparams, tempParam);
        });
      }
    }

    /**
     * 处理自定义视图数据逻辑
     *
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public handleCustomDataLogic(curNavData: any, tempData: any, item: string) {
      // 直接值直接赋值
      if (curNavData.isRawValue) {
        if (
                Object.is(curNavData.value, "null") ||
                Object.is(curNavData.value, "")
        ) {
          Object.defineProperty(tempData, item.toLowerCase(), {
            value: null,
            writable: true,
            enumerable: true,
            configurable: true,
          });
        } else {
          Object.defineProperty(tempData, item.toLowerCase(), {
            value: curNavData.value,
            writable: true,
            enumerable: true,
            configurable: true,
          });
        }
      } else {
        // 先从导航上下文取数，没有再从导航参数（URL）取数，如果导航上下文和导航参数都没有则为null
        if (this.context[curNavData.value.toLowerCase()]) {
          Object.defineProperty(tempData, item.toLowerCase(), {
            value: this.context[curNavData.value.toLowerCase()],
            writable: true,
            enumerable: true,
            configurable: true,
          });
        } else {
          if (this.viewparams[curNavData.value.toLowerCase()]) {
            Object.defineProperty(tempData, item.toLowerCase(), {
              value: this.viewparams[curNavData.value.toLowerCase()],
              writable: true,
              enumerable: true,
              configurable: true,
            });
          } else {
            Object.defineProperty(tempData, item.toLowerCase(), {
              value: null,
              writable: true,
              enumerable: true,
              configurable: true,
            });
          }
        }
      }
    }

    /**
     * vue 创建
     */
    public created() {
      this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     * @memberof SYS_USER_ROLEGridViewBase
     */
    public afterCreated() {
      const secondtag = this.$util.createUUID();
      this.$store.commit("viewaction/createdView", {
        viewtag: this.viewtag,
        secondtag: secondtag,
      });
      this.viewtag = secondtag;
      // this.parseViewParam();

      const _this: any = this;
      // 获取父数据
      // if (_this && _this.viewdata) {
      //     _this.parentData = JSON.parse(_this.viewdata);
      // }
      // if (_this.parentData && _this.parentData.sysrole) {
      //     // console.log("当前角色id：" + _this.parentData.sysrole);
      //     _this.srfparentkey = _this.parentData.sysrole;
      // }

      // 监听父页面
      if (this.formDruipart) {
        this.formDruipart.subscribe((res: any) => {
          // 如果是新建角色保存，需要从res中获取父数据主键
          if (!this.srfparentkey && res.data) {
            let parentData = res.data;
            this.srfparentkey = parentData.srfparentkey;
          }
          // 父页面的保存前,先进行树数据的更新处理
          if (Object.is(res.action, "save")) {
            if (this.selectData.length > 0) {
              // 选中了数据
              this.onClickOk();
            } else {
              // 没选中数据
              this.onClear();
            }
          }
        });
      }
    }

    /**
     * vue 挂载
     */
    public mounted() {
      // this.initTree();
    }

    /**
     * 初始化树
     */
    private initTree() {
      const _this = this;
      // get全部菜单和数据能力和自定义资源的请求路径
      const url = `sysroles/` + _this.srfparentkey + `/sysrolepermissions/tree`;
      this.$http
              .get(url)
              .then((response: any) => {
                if (!response || response.status !== 200) {
                  this.$Notice.error({ title: "错误", desc: response.message });
                  return;
                } else {
                  // 给树赋值，数据结构在后台已经按照eltree格式化
                  _this.CDdata = response.data.APPMENU;
                  _this.QXdata = response.data.OPPRIV;
                  _this.ZYdata = response.data.UNIRES;
                  _this.defaultCheckedNodes = response.data.SELECTED;

                  // 设置默认第一级展开
                  for (let i = 0; i < _this.CDdata.length; i++) {
                    _this.CDdataexpandedKeys.push(_this.CDdata[i].id);
                  }
                  for (let i = 0; i < _this.QXdata.length; i++) {
                    _this.QXdataexpandedKeys.push(_this.QXdata[i].id);
                  }
                  for (let i = 0; i < _this.ZYdata.length; i++) {
                    _this.ZYdataexpandedKeys.push(_this.ZYdata[i].id);
                  }

                  // 设置默认选中节点，即当前角色所有权限
                  this.$nextTick(() => {
                    const CDtree: any = this.$refs.CDtree;
                    const QXtree: any = this.$refs.QXtree;
                    const ZYtree: any = this.$refs.ZYtree;

                    CDtree.setCheckedNodes(_this.defaultCheckedNodes);
                    QXtree.setCheckedNodes(_this.defaultCheckedNodes);
                    ZYtree.setCheckedNodes(_this.defaultCheckedNodes);

                    // 保存初始选中的节点数据，便于后续保存时比较
                    const arr = CDtree.getCheckedNodes()
                            .concat(QXtree.getCheckedNodes())
                            .concat(ZYtree.getCheckedNodes());
                    this.ininselectData = arr;
                  });
                }
              })
              .catch((e) => {
                console.log(e);
              });
    }

    /**
     * 销毁之前
     *
     * @memberof SYS_ROLE_PERMISSIONCustomViewBase
     */
    public beforeDestroy() {
      // 清空选中数据
      this.selectData = {};
      // 清空视图选中数据
      this.viewSelections = [];
      this.$store.commit("viewaction/removeView", this.viewtag);
    }

    /**
     * 处理选中节点
     */
    protected handleCheckChange() {
      // console.log("SYS_PERMISSIONMPickupView执行了handleCheckChange")
      // 获取当前三棵树
      const CDtree: any = this.$refs.CDtree;
      const QXtree: any = this.$refs.QXtree;
      const ZYtree: any = this.$refs.ZYtree;
      // 获取选中状态的节点
      const arr = CDtree.getCheckedNodes()
              .concat(QXtree.getCheckedNodes())
              .concat(ZYtree.getCheckedNodes());
      this.selectData = arr;
      // console.log("选中的node:" + JSON.stringify(this.selectData));
    }

    /**
     * 容器模型
     */
    public containerModel: any = {
      view_okbtn: { name: "okbtn", type: "button", text: "确定", disabled: true },
    };

    /**
     * 确定
     */
    public onClickOk() {
      // 处理选中的数据
      if (this.selectData && this.selectData.length > 0) {
        // 判断选中的数据和初始数据
        if (
                JSON.stringify(this.selectData) == JSON.stringify(this.ininselectData)
        ) {
          // 抛出事件,通知父页面进行表单保存
          return this.$emit("drdatasaved", {});
        }
        this.selectData.forEach((item: any) => {
          let _itemTemp: any = JSON.parse(JSON.stringify(item));
          let _item: any = {};
          if (_itemTemp.type) {
            _item.permissionid = _itemTemp.id;
            _item.permissiontype = _itemTemp.type;
            _item.permissionname = _itemTemp.fullName;
            Object.assign(_item, { _select: false });
            this.viewSelections.push(_item);
          }
        });

        // 保存选中的权限信息
        let url =
                "/sysroles/" + this.srfparentkey + "/sysrolepermissions/refreshbatch";
        this.$http
                .post(url, this.viewSelections)
                .then((response: any) => {
                  if (!response || response.status !== 200) {
                    return this.$Notice.error({
                      title: "错误",
                      desc: response.message,
                    });
                  } else {
                    // 抛出事件,通知父页面进行表单保存
                    return this.$emit("drdatasaved", {});
                  }
                })
                .catch((e) => {
                  return this.$Notice.error({ title: "错误", desc: e });
                });
      }
      // 清空视图选中数据，避免重复添加
      this.viewSelections = [];
    }

    /**
     * 清除
     */
    private onClear() {
      // 未选中数据,即没有赋予任何权限，需要清除当前角色的所有权限
      if (this.selectData.length == 0) {
        // 保存选中的权限信息
        let url =
                "/sysroles/" + this.srfparentkey + "/sysrolepermissions/refreshbatch";
        this.$http
                .post(url, [])
                .then((response: any) => {
                  if (!response || response.status !== 200) {
                    return this.$Notice.error({
                      title: "错误",
                      desc: response.message,
                    });
                  } else {
                    // 抛出事件,通知父页面进行表单保存
                    return this.$emit("drdatasaved", {});
                  }
                })
                .catch((e) => {
                  return this.$Notice.error({ title: "错误", desc: e });
                });
      } else {
        // 抛出事件,通知父页面进行表单保存
        return this.$emit("drdatasaved", {});
      }
    }
  }
</script>


<style lang='less'>
  @import "./sys-role-permission-custom-view";
</style>