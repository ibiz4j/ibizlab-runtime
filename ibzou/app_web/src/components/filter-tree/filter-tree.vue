<template>
    <el-tree class="filter-tree" :data="treeItems" :expand-on-click-node="false" default-expand-all>
        <template slot-scope="{ node, data }">
            <template v-if="Object.is(data.label, '$and') || Object.is(data.label, '$or')">
                <div class="filter-tree-item">
                    <el-select size="small" v-model="data.label" :disabled="data.isroot">
                        <el-option v-for="mode in relationModes" :key="mode.value" :label="getLabel(mode)" :value="mode.value"></el-option>
                    </el-select>
                    <div class="filter-tree-action">
                        <i-button title="添加条件" @click="onAddItem(data)"><i class="fa fa-plus" aria-hidden="true"></i> 添加条件</i-button>
                        <i-button title="添加组" @click="onAddGroup(data)"><i class="fa fa-plus" aria-hidden="true"></i> 添加组</i-button>
                        <icon v-if="!data.isroot" type="md-close"  @click="onRemoveItem(node, data)"/>
                    </div>
                </div>
            </template>
            <template v-else>
                <div class="filter-tree-item">
                    <el-select size="small" class="filter-item-field" v-model="data.field" clearable placeholder="属性" @change="onFieldChange(data)">
                        <el-option
                            v-for="item in fields"
                            :key="item.prop"
                            :label="item.label"
                            :value="item.name">
                        </el-option>
                    </el-select>
                    <filter-mode class="filter-item-mode" v-model="data.mode"></filter-mode>
                    <div class="filter-item-value">
                        <i-input v-if="!data.field"></i-input>
                        <slot v-else :data="data"></slot>
                    </div>
                    <div class="filter-tree-action">
                        <icon type="md-close"  @click="onRemoveItem(node, data)"/>
                    </div>
                </div>
            </template>
        </template>
    </el-tree>
</template>

<script lang="ts"> 
import {Vue, Component, Prop} from 'vue-property-decorator';
import FilterMode from './filter-mode.vue';

@Component({
    components: {
        FilterMode
    }
})
export default class FilterTree extends Vue {

    /**
     * 数据集
     *
     * @type {*}
     * @memberof FilterTree
     */
    @Prop() datas: any;

    /**
     * 过滤项集合
     *
     * @type {*}
     * @memberof FilterTree
     */
    @Prop() fields: any;

    /**
     * 组条件集合
     *
     * @type {*}
     * @memberof FilterTree
     */
    protected relationModes: any[] = [
        { 'zh-CN': '并且', 'en-US': 'AND', value: '$and' },
        { 'zh-CN': '或', 'en-US': 'OR', value: '$or' }
    ];

    /**
     * 树数据集合
     *
     * @type {*}
     * @memberof FilterTree
     */
    get treeItems() {
        let root: any = {
            label: '$and',
            isroot: true,
            children: this.datas
        };
        if(this.datas.length == 0) {
            this.onAddItem(root);
        }
        return [root];
    }

    /**
     * 获取语言文本
     *
     * @return {string}
     * @memberof FilterTree
     */
    getLabel(mode: any): string {
        if(this.$i18n.locale) {
            return mode[this.$i18n.locale];
        }
        return mode['zh-CN'];
    }

    /**
     * 属性变化
     *
     * @return {*}
     * @memberof FilterTree
     */
    public onFieldChange(data: any) {
        if(!data.mode) {
            data.mode = '$eq';
        }
    }

    /**
     * 添加条件
     *
     * @return {*}
     * @memberof FilterTree
     */
    public onAddItem(data: any) {
        if(data && data.children) {
            data.children.push({
                field: null,
                mode: null
            });
        }
    }

    /**
     * 添加组
     *
     * @return {*}
     * @memberof FilterTree
     */
    public onAddGroup(data: any) {
        if(data && data.children) {
            data.children.push({
                label: '$and',
                children: []
            })
        }
    }

    /**
     * 删除条件/组
     *
     * @return {*}
     * @memberof FilterTree
     */
    public onRemoveItem(node: any, data: any) {
        if(node && node.parent) {
            let pData: any = node.parent.data;
            if(pData.children.indexOf(data) >= 0) {
                pData.children.splice(pData.children.indexOf(data), 1)
            }
        }
    }
}
</script>

<style lang="less">
@import './filter-tree.less';
</style>