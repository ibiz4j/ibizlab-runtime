<template>
  <div class="app-icon-menus">
    <template v-for="(item,index) in menus">
      <div :bordered="false" v-if="item.items && Array.isArray(item.items)" :key="index" :class="item.textcls">
        <p @click="$emit('menuClick',item.name, [item.name])">
          <span>{{$t('app.menus.' + ctrlName + '.' + item.name)}}</span>
          <span class="line"></span>
        </p>
        <p style=" display: 'flex' ">
          <app-icon-menus :menus="item.items" :ctrlName = "ctrlName" @menuClick="menuClick"></app-icon-menus>
        </p>
      </div>
      <el-card
        :key="index"
        shadow="never"
        :class="item.textcls"
        v-else
      >
        <div @click="menuClick(item.name,[item.name])" class="menuIcon" >
          <span v-if="isIcon(item.icon,item.iconcls)">

            <i :class="item.icon" v-if="!Object.is(item.icon, '')" />
            <i :class="item.iconcls" v-else-if="!Object.is(item.iconcls, '')" />
            <i class="fa fa-cogs" v-else></i>
          </span>
          <span v-else>
            <img :src="item.icon" v-if="!Object.is(item.icon, '')" />
            <img :src="item.iconcls" v-else-if="!Object.is(item.iconcls, '')" />
            <i class="fa fa-cogs" v-else></i>
          </span>
          <h4>{{$t('app.menus.' + ctrlName + '.' + item.name)}}</h4>
        </div>
      </el-card>
    </template>
  </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";

@Component({})
export default class AppQuickMenus extends Vue {

  public isIcon( icon: string,iconcls: string) {
    if (icon.indexOf("fa") == 0 || iconcls.indexOf("fa") == 0) {
      return true;
    }else {
      return false;
    }
    
  }

  public menuClick(index: any,indexs: any[]) {
    this.$emit("menuClick",index,indexs);
  }

  /**
   * 菜单数据
   *
   * @type {*}
   * @memberof AppQuickMenus
   */
  @Prop({ default: [] }) public menus!: any;

  /**
   *  部件名称
   * 
   * @type {String}
   * @memberof AppQuickMenus
   */
  @Prop() public ctrlName!:String;
}
</script>

<style lang='less'>
@import "./app-icon-menus.less";
</style>