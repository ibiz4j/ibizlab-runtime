<template>
    <div class="app-menu-item">
        <template v-for="item in menus">
             <template v-if="item.items && Array.isArray(item.items) && item.items.length > 0">
                <el-submenu v-show="!item.hidden" :index="item.name" :popper-class="popperClass" :key="item.id">
                    <template slot='title'>
                        <template v-if="item.icon && item.icon != ''">
                            <img :src="item.icon" class='app-menu-icon' />
                        </template>
                        <template v-else-if="item.iconcls && item.iconcls != ''">
                            <i :class="[item.iconcls, 'app-menu-icon']"></i>
                        </template>
                        <template v-else>
                            <i v-if="isFirst" class='fa fa-cogs app-menu-icon'></i>
                        </template>
                        <span class='text' :title="$t(`app.menus.${ctrlName}.${item.name}`)">{{$t(`app.menus.${ctrlName}.${item.name}`)}}</span>
                    </template>
                    <app-menu-item :menus="item.items" :ctrlName="ctrlName" :isFirst="false" :counterdata="counterdata" :popperclass="popperClass"></app-menu-item>
                </el-submenu>
             </template>
             <template v-else>
                <template v-if="item.type =='MENUITEM'">
                    <el-menu-item v-show="!item.hidden" :index="item.name" :key="item.id">
                        <template v-if="item.icon && item.icon != ''">
                            <img :src="item.icon" class='app-menu-icon' />
                        </template>
                        <template v-else-if="item.iconcls && item.iconcls != ''">
                            <i :class="[item.iconcls, 'app-menu-icon']"></i>
                        </template>
                        <template v-else>
                            <i v-if="isFirst" class='fa fa-cogs app-menu-icon'></i>
                        </template>
                        <template slot="title">
                            <span class="text" :title="$t(`app.menus.${ctrlName}.${item.name}`)">{{$t(`app.menus.${ctrlName}.${item.name}`)}}</span>
                            <template v-if="counterdata && counterdata[item.counterid] && counterdata[item.counterid] > 0">
                                <span class="pull-right">
                                    <badge :count="counterdata[item.counterid]" :overflow-count="9999"></badge>
                                </span>
                            </template>
                        </template>
                    </el-menu-item>
                </template>
                <template v-if="item.type =='SEPERATOR'">
                        <divider :key="item.id" />
                </template>
            </template>
        </template>
   </div>     
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator';

@Component({})
export default class AppMenuItem extends Vue {
    
    /**
     * 菜单数据
     * 
     * @type {*}
     * @memberof AppMenuItem
     */
    @Prop( {default: []} ) public menus!: any;

    /**
     * 部件名称
     * 
     * @type {*}
     * @memberof AppMenuItem
     */
    @Prop() public ctrlName!: string;

    /**
     * 计数器数据
     * 
     * @type {*}
     * @memberof AppMenuItem
     */
    @Prop() public counterdata!: any;

    /**
     * 提示框主题样式
     * 
     * @type {*}
     * @memberof AppMenuItem
     */
    @Prop() public popperClass!: any;

    /**
     * 是否是一级菜单
     * 
     * @type {*}
     * @memberof AppMenuItem
     */
    @Prop() public isFirst!: boolean;

}
</script>