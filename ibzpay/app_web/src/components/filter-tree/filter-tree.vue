<template>
    <el-tree class="filter-tree" :data="treeItems" :expand-on-click-node="false" default-expand-all>
        <template slot-scope="{ node, data }">
            <template v-if="Object.is(data.label, '$and') || Object.is(data.label, '$or')">
                <div class="filter-tree-item">
                    <el-select size="small" v-model="data.label" :disabled="data.isroot">
                        <el-option v-for="mode in relationModes" :key="mode.value" :label="getLabel(mode)" :value="mode.value"></el-option>
                    </el-select>
                    <div class="filter-tree-action">
                        <i-button :title="$t('components.filterTree.title1')" @click="onAddItem(data)"><i class="fa fa-plus" aria-hidden="true"></i> {{$t('components.filterTree.title1')}}</i-button>
                        <i-button :title="$t('components.filterTree.title2')" @click="onAddGroup(data)"><i class="fa fa-plus" aria-hidden="true"></i> {{$t('components.filterTree.title2')}}</i-button>
                        <icon v-if="!data.isroot" type="md-close"  @click="onRemoveItem(node, data)"/>
                    </div>
                </div>
            </template>
            <template v-else>
                <div class="filter-tree-item">
                    <el-select size="small" class="filter-item-field" v-model="data.field" clearable :placeholder="$t('components.filterTree.placeholder')">
                        <el-option
                            v-for="item in fieldItems"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                        </el-option>
                    </el-select>
                    <filter-mode class="filter-item-mode" v-model="data.mode" :modes="getModes(data.field)" @on-change="onModeChange($event, data)"></filter-mode>
                    <div class="filter-item-value">
                        <i-input v-if="!data.editor"></i-input>
                        <div v-else :key="data.editor">
                            <slot :data="data"></slot>
                        </div>
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
     * 属性项集合
     *
     * @type {*}
     * @memberof FilterTree
     */
    protected fieldItems: any[] = [];

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
     * 生命周期
     *
     * @return {void}
     * @memberof FilterTree
     */
    public created() {
        if(!this.fields) {
            return;
        }
        this.fields.forEach((field: any) => {
            let index: number = this.fieldItems.findIndex((item: any) => Object.is(item.value, field.prop));
            if(index < 0) {
                this.fieldItems.push({
                    label: field.label,
                    value: field.prop,
                    modes: this.getFieldModes(field.prop)
                })
            } 
        });
    }

    /**
     * 获取逻辑模式集合
     *
     * @return {void}
     * @memberof FilterTree
     */
    public getModes(field: string) {
        if(this.fieldItems.length > 0) {
            let item: any = this.fieldItems.find((item: any) => Object.is(item.value, field));
            if(item) {
                return item.modes;
            }
        }
        return [];
    }

    /**
     * 获取属性逻辑模式集合
     *
     * @return {void}
     * @memberof FilterTree
     */
    public getFieldModes(name: string) {
        let modes: any[] = [];
        for(let i = 0; i < this.fields.length; i++) {
            let field: any = this.fields[i];
            if(!Object.is(field.prop, name)) {
                continue;
            }
            modes.push({
                name: field.name,
                mode: field.mode ? field.mode : 'all'
            })
        }
        return modes;
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
     * 添加条件
     *
     * @return {*}
     * @memberof FilterTree
     */
    public onAddItem(data: any) {
        if(data && data.children) {
            data.children.push({
                field: null,
                mode: null,
                editor: null
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

    /**
     * 条件逻辑变化
     *
     * @return {*}
     * @memberof FilterTree
     */
    public onModeChange(mode: any, data: any) {
        if(mode && data) {
            data.editor = mode.name;
        } 
    }
}
</script>

<style lang="less">
@import './filter-tree.less';
</style>