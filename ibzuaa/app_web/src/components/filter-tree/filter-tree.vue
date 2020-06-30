<template>
    <el-tree class="filter-tree" :data="treeItems" :props="defaultProps" :expand-on-click-node="false" default-expand-all>
        <template slot-scope="{ node, data }">
            <template v-if="Object.is(data.name, '$and') || Object.is(data.name, '$or')">
                <div class="filter-tree-item">
                    <el-select size="small" v-model="data.name">
                        <el-option v-for="mode in relationModes" :key="mode.value" :label="mode.zh" :value="mode.value"></el-option>
                    </el-select>
                    <div class="filter-tree-action">
                        <i-button title="添加条件" @click="onAddItem(data)"><i class="fa fa-plus" aria-hidden="true"></i> 添加条件</i-button>
                        <i-button title="添加组" @click="onAddGroup(data)"><i class="fa fa-plus" aria-hidden="true"></i> 添加组</i-button>
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
                        <i-button @click="onRemoveItem(node, data)" title="删除"><i class="fa fa-trash-o" aria-hidden="true"></i></i-button>
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

    @Prop() datas: any;

    @Prop() fields: any;

    protected defaultProps: any = {
        children: 'items',
        label: 'name'
    };

    protected relationModes: any[] = [
        { zh: '并且', en: 'AND', value: '$and' },
        { zh: '或', en: 'OR', value: '$or' }
    ];

    get treeItems() {
        let root: any = {
            name: '$and',
            items: this.datas
        };
        if(this.datas.length == 0) {
            this.onAddItem(root);
            this.onAddItem(root);
        }
        return [root];
    }

    public onFieldChange(data: any) {
        if(!data.mode) {
            data.mode = '$eq';
        }
    }

    public onAddItem(data: any) {
        if(data && data.items) {
            data.items.push({
                field: null,
                mode: null
            });
        }
    }

    public onAddGroup(data: any) {
        if(data && data.items) {
            data.items.push({
                name: '$and',
                items: []
            })
        }
    }

    public onRemoveItem(node: any, data: any) {
        if(node && node.parent) {
            let pData: any = node.parent.data;
            if(pData.items.indexOf(data) >= 0) {
                pData.items.splice(pData.items.indexOf(data), 1)
            }
        }
    }
}
</script>

<style lang="less">
@import './filter-tree.less';
</style>