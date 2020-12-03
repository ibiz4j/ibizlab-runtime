<template>
<div :class="['app-sort-bar', isSort ? 'open-bar' : '',]">
    <row v-if="sortModel && sortModel.length>0" class="page-sort-bar" :gutter="10" type="flex" justify="start" style="margin:0px;">
            <template v-for="(item, index) in sortModel">
            <i-col v-show="isSort" :key="index" :class="getSortClass(item)">
                <div >
                    <div @click="sortItemClick(item)">
                <span class="sort-field-text"  >{{$t('entities.'+ entityName +'.fields.' + item)}}</span>
                <span class="caret-wrapper">
                    <Icon type="md-arrow-dropup" />
                    <Icon type="md-arrow-dropdown" />
                </span>
                </div>
                </div>
                
            </i-col>
            </template>
        <div class="issort" @click="handleSort">
            <Icon v-if="isSort" type="ios-funnel-outline" />
            <Icon v-else type="ios-funnel" />
            {{ $t('components.appSortBar.title') }}
        </div>
    </row>
</div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";

@Component({})
export default class AppSortBar extends Vue {
    
    @Prop() public sortModel!: any[];

    @Prop() public sortField!: any;

    @Prop() public sortDir!: any;

    @Prop() public entityName!: string;

    public isSort: boolean = false;

    public getSortClass(name: any) {
        if(this.sortField !== name || this.sortDir === ''){
            return '';
        }else if(this.sortDir === 'asc'){
            return 'sort-ascending'
        }else if(this.sortDir === 'desc'){
            return 'sort-descending'
        }
    }

    public sortItemClick(name: string) {
        this.$emit('clickSort', name);
    }

    public handleSort() {
        this.isSort = !this.isSort;
    }
}
</script>

<style lang="less">
@import './app-sort-bar.less';
</style>