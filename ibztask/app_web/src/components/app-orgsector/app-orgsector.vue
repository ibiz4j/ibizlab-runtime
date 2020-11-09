<template>
  <div class="app-org-sector">
    <dropdown @on-click="orgSelect" :transfer="true">
      <div class="orgsector">
        <span>{{selectedOrgName}}</span>
        <icon size="18" type="md-arrow-dropdown" v-if="selectedOrgArray.length > 0"></icon>
      </div>
      <dropdown-menu
        class="menu"
        slot="list"
        style="font-size: 15px !important;"
        v-if="selectedOrgArray.length > 0"
      >
        <dropdown-item
          :name="item.srforgsectorid"
          style="font-size: 15px !important;"
          v-for="(item, index) in selectedOrgArray"
          :key="index"
        >{{item.srforgsectorname}}</dropdown-item>
      </dropdown-menu>
    </dropdown>
  </div>
</template>
<script lang = 'ts'>
import { Http } from '@/utils/http/http';
import { Vue, Component, Inject } from "vue-property-decorator";

@Component({})
export default class AppOrgSector extends Vue {

  /**
   * 注入加载行为
   *
   * @memberof AppOrgSector
   */
  @Inject("reload")
  reload!: any;

  /**
   * 选中组织部门id
   *
   * @type {string}
   * @memberof AppOrgSector
   */
  public selectedOrgId: string = "";

  /**
   * 选中组织部门名称
   *
   * @type {string}
   * @memberof AppOrgSector
   */
  public selectedOrgName: string = "";

  /**
   * 组织部门名称数组
   *
   * @type {Array<any>}
   * @memberof AppOrgSector
   */
  public selectedOrgArray: Array<any> = [];

  /**
   * 组件初始化数据，vue生命周期
   *
   * @memberof AppOrgSector
   */
  public mounted() {
    this.getData();
  }

  /**
   * 获取数据
   * 
   * @memberof AppOrgSector
   */
  public getData(){
    if (this.$store.getters.getAppData()) {
      let _context = this.$store.getters.getAppData().context;
      let _srforgname = this.$store.getters.getAppData().context.srforgname;
      let _srforgsectorname = this.$store.getters.getAppData().context.srforgsectorname;
      if (_context && this.$store.getters.getAppData().context.srforgsectorid ){
        this.selectedOrgId = this.$store.getters.getAppData().context.srforgsectorid;
      } else {
        return false;
      }
      
      if(_context && _srforgname && _srforgsectorname){
        this.selectedOrgName = _srforgname + '-' + _srforgsectorname;
      } else if (_context && _srforgname) {
        this.selectedOrgName = _srforgname;
      } else if (_context && _srforgsectorname) {
        this.selectedOrgName = _srforgsectorname;
      }
      if (this.$store.getters.getAppData().srforgsections) {
        this.selectedOrgArray = this.$store.getters.getAppData().srforgsections;
      }
      
    }
  }

  /**
   * 选择组织部门回调
   *
   * @memberof AppOrgSector
   */
  public orgSelect(data: string) {
    if(Object.is(data,this.selectedOrgId)){
        return;
    }
    let item: any = this.selectedOrgArray.find((_item: any) => {
      return _item.srforgsectorid === data;
    });
    this.switchDepartment(data).then((response:any) =>{
        if (response.status == 200) {
          if (item.srforgsectorid && item.srforgsectorname) {
            this.selectedOrgId = item.srforgsectorid;
            this.selectedOrgName = item.srforgsectorname;
          }
          this.updateStoreOrgData(item);
          this.reload();
        }else{
          this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data?response.data.message:(this.$t('components.appOrgSector.errorSwitch') as string) });
        }
    }).catch((error:any) =>{
        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('components.appOrgSector.errorSwitch') as string) });
    })
  }

  /**
   * 调用远端切换部门接口
   *
   * @memberof AppOrgSector
   */
  public async switchDepartment(data:any){
    return await Http.getInstance().post(`/oumaps/switch`,data,false);
  }

  /**
   * 更新仓库部门信息
   *
   * @memberof AppOrgSector
   */
  public updateStoreOrgData(data: any) {
    let _appdata: any = this.$store.getters.getAppData();
    let _context: any = _appdata.context;
    Object.assign(_context,data);
    Object.assign(_appdata, {context:_context});
    this.$store.commit("updateAppData", _appdata);
  }
}
</script>

<style lang="less">
@import "./app-orgsector.less";
</style>