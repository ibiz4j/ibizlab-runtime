<template>
  <div class="design-tree-container">
    <context-menu-container>
      <el-input
        size="small"
        placeholder="搜索..."
        v-model="filerText"
        @input="filterChange"
      >
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-input>
      <el-tree
        :filter-node-method="filterNode"
        class="tre"
        :data="this.TreeData"
        ref="OrgTree"
        :show-checkbox="false"
        node-key="id"
        :default-expand-all="false"
        highlight-current
        :default-expanded-keys="this.defaultExpandedKeys"
        :props="this.defaultProps"
        @node-click="handleNodeClick"
      >
        <span class="custom-tree-node" slot-scope="{ node, data }">
          <i
            v-if="node.isLeaf"
            class="fa fa-building-o"
            style="margin-right: 2px"
          ></i>
          <i
            v-if="!node.isLeaf"
            class="fa fa-building"
            style="margin-right: 2px"
          ></i>
          <span>{{ node.label }}</span>
        </span>
      </el-tree>
    </context-menu-container>
  </div>
</template>

<script lang='tsx'>
import { Component, Vue } from "vue-property-decorator";

@Component({
  components: {},
})
export default class OrgTree extends Vue {
  /**
   * 过滤文本
   *
   * @type {string}
   * @memberof OrgTree
   */
  public filerText: string = "";

  /**
   * 过滤节点
   *
   * @param {string} value 过滤文本
   * @param {*} data 树数据
   * @memberof OrgTree
   */
  public filterNode(value: string, data: any) {
    if (!value) return true;
    return data.label.indexOf(value) !== -1;
  }

  /**
   * 树搜索触发
   *
   * @memberof OrgTree
   */
  public filterChange() {
    const OrgTree: any = this.$refs.OrgTree;
    OrgTree.filter(this.filerText);
  }

  /**
   * 树数据
   *
   * @type {Array<*>}
   * @memberof OrgTree
   */
  public TreeData: Array<any> = [];

  /**
   * 树显示说明：子树为节点对象的children,节点标签为节点对象的label
   *
   * @type {*}
   * @memberof OrgTree
   */
  public defaultProps: any = {
    children: "children",
    label: "label",
  };

  /**
   * 默认展开节点
   *
   * @type {Array<*>}
   * @memberof OrgTree
   */
  public defaultExpandedKeys: Array<any> = [];

  /**
   * 当前登录人信息
   *
   * @type {*}
   * @memberof OrgTree
   */
  public curUserContext: any = {};

  /**
   * vue 创建
   *
   * @memberof OrgTree
   */
  public created() {
    var _this: any = this;
    // 获取当前登录人信息
    if (_this && _this.$attrs && _this.$attrs.context) {
      _this.curUserContext = _this.$attrs.context;
    }
  }

  /**
   * vue 挂载
   *
   * @memberof OrgTree
   */
  public mounted() {
    this.initTree();
  }

  /**
   * 初始化树
   *
   * @memberof OrgTree
   */
  private initTree() {
    const _this = this;
    // 获取当前登录人的身份
    const userStr = localStorage.getItem("user");
    let user: any = {};
    if (userStr) {
      user = JSON.parse(userStr);
    }
    // 获取当前登录人所处组织及其下级组织
    let url: string = "";
    if (user.superuser == 1) {
      // 获取所有组织
      url = "sysorganizations/alls/suborg/picker";
    } else {
      if (_this.curUserContext && _this.curUserContext.srforgid) {
        url =
          "sysorganizations/" +
          _this.curUserContext.srforgid +
          "/suborg/picker";
      } else {
        this.$Notice.error({ title: "错误", desc: "当前登录人组织为空" });
      }
    }

    this.$http
      .get(url)
      .then((response: any) => {
        if (!response || response.status !== 200) {
          this.$Notice.error({ title: "错误", desc: response.message });
          return;
        } else {
          // 给树赋值，数据结构在后台已经按照eltree格式化
          _this.TreeData = response.data;
          if (response.data && response.data.length > 0) {
            // 设置默认选中第一个节点，即高亮显示
            this.$nextTick(function () {
              let orgTree: any = this.$refs.OrgTree;
              orgTree.setCurrentKey(response.data[0].id);
            });
            // 默认加载第一个节点的右侧视图，调用选中数据变更事件
            _this.selectionChange(response.data[0]);
          }
        }
      })
      .catch((e: any) => {
        console.log(e);
      });
  }

  /**
   * 处理点击节点
   *
   * @memberof OrgTree
   */
  protected handleNodeClick() {
    // 获取当前树
    const OrgTree: any = this.$refs.OrgTree;
    // 获取点击状态的节点
    let node = OrgTree.getCurrentNode();
    // console.log("选中的node:" + JSON.stringify(node));

    // 选中数据变更事件
    this.selectionChange(node);
  }

  /**
   * 选中数据变更事件
   *
   * @param {*} node 节点对应node对象
   * @memberof OrgTree
   */
  public selectionChange(node: any) {
    // 获取右侧视图渲染数据需要的参数
    let temp = JSON.parse(JSON.stringify(node));
    temp.id = "Org;" + node.id;
    temp.srfparentdename = "SysOrganization";
    temp.srfparentkey = node.id;
    temp.navparams = "{}";
    temp.sysorganization = node.id;
    let srfappctx: any = {};
    srfappctx.srfparentkey = temp.srfparentkey;
    srfappctx.srfparentdename = temp.srfparentdename;
    srfappctx.sysorganization = temp.sysorganization;
    temp.srfappctx = srfappctx;
    // 抛出参数
    let selectiondata: any = [temp];
    this.$emit("selectionchange", selectiondata);
  }
}
</script>


<style lang='less'>
@import "./org-tree-treeview.less";
</style>