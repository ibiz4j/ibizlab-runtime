<script lang='tsx'>
import { Component } from "vue-property-decorator";
import SysRoleEditViewBase from "./sys-role-edit-view-base.vue";

import view_form from "@widgets/sys-role/main-form/main-form.vue";
@Component({
  components: {
    view_form,
  },
  beforeRouteEnter: (to: any, from: any, next: any) => {
    next((vm: any) => {
      if (!Object.is(vm.navModel, "route")) {
        vm.initNavDataWithTab(vm.viewCacheData);
      }
      vm.$store.commit("addCurPageViewtag", {
        fullPath: to.fullPath,
        viewtag: vm.viewtag,
      });
    });
  },
})
export default class SysRoleEditView extends SysRoleEditViewBase {
  /**
   * 保存
   *
   * @param {any[]} args 当前数据
   * @param {any} contextJO 行为附加上下文
   * @param {*} [params] 附加参数
   * @param {*} [$event] 事件源
   * @param {*} [xData]  执行行为所需当前部件
   * @param {*} [actionContext]  执行行为上下文
   * @memberof SysRoleEditViewBase
   */
  public Save(
    args: any[],
    contextJO?: any,
    params?: any,
    $event?: any,
    xData?: any,
    actionContext?: any,
    srfParentDeName?: string
  ) {
    // 界面行为容器对象 _this
    const _this: any = this;
    if (xData && xData.save instanceof Function) {
      // 禁用保存按钮
      _this.toolBarModels.tbitem3.disabled = true;
      xData.save().then((response: any) => {
        // 启用保存按钮
        _this.toolBarModels.tbitem3.disabled = false;
        if (!response || response.status !== 200) {
          return;
        }
        _this.$emit("viewdataschange", [{ ...response.data }]);
      });
    } else if (_this.save && _this.save instanceof Function) {
      _this.save();
    }
  }
}
</script>