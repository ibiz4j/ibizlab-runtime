<template>
    <div class="ibiz-group-select">
        <div class="ibiz-group-content">
            <span class="group-item-text" v-if="!multiple">
                {{ selectName }}
            </span>
            <template v-else v-for="(select, index) of selects">
                <div :key="index" class="ibiz-group-item">
                    <span class="group-item-multiple">{{ select.label }}</span>
                    <i v-if="!disabled" class="el-icon-close" @click="remove(select)"></i>
                </div>
            </template>
        </div>
        <div v-if="!disabled" class="ibiz-group-open">
            <i v-if="!disabled && !multiple && selects.length > 0" class="el-icon-close" @click="remove(selects[0])"></i>
            <i class="el-icon-search" @click="openView" style="color: #c0c4cc;"></i>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import CodeListService from "@/codelist/codelist-service";

@Component({})
export default class AppGroupSelect extends Vue {
    /**
     * 名称标识
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() name!: string;

    /**
     * 树加载地址
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() treeurl?:boolean;

    /**
     * 数据接口地址
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() url!: string;

    /**
     * 多选
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop({default: false}) multiple?: boolean;

    /**
     * 数据对象
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() data: any;

    /**
     * 代码表标识
     * 
     * @memberof AppGroupSelect
     */
    @Prop() public tag?:string;

    /**
     * 代码表类型
     * 
     * @memberof AppGroupSelect
     */
    @Prop() public codelistType?:string;

    /**
     * 过滤属性标识
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() filter?: string;

    /**
     * 是否启用
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() disabled?: boolean;

    /**
     * 值
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() value: any;

    /**
     * 上下文参数
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() context: any;

    /**
     * 关联属性
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() valueitem: any;

    /**
     * 填充属性
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Prop() fillmap: any;

    /**
     * 选中项集合
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    protected selects: any[] = [];

    /**
     * 值变化
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    @Watch('data',{immediate:true,deep:true})
    onValueChange(newVal: any, oldVal: any) {
        this.selects = [];
        if (newVal) {
            let item: any = {};
            item.label = this.data[this.name]?this.data[this.name].split(','):[];
            item.id = this.data[this.valueitem] ? this.data[this.valueitem].split(',') : [];
            if(this.fillmap) {
                for(let key in this.fillmap) {
                    item[this.fillmap[key]] = this.data[key] ? this.data[key].split(',') : [];
                }
            }
            const callback:any = (item:any) =>{
                item.label.forEach((val: string, index: number) => {
                    let _item: any = {};
                    for(let key in item) {
                        _item[key] = item[key][index] ? item[key][index] : null;
                    }
                    this.selects.push(_item)
                })
            }
            if(item.label.length == 0 && item.id.length > 0){
                this.fillLabel(item,item.id,(result:any) =>{
                    item.label = result.label;
                    callback(item);
                });
            }else{
                callback(item);
            }
            
        }
    }

    /**
     * 单选时选中名称
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    get selectName() {
        if(this.selects.length > 0) {
            return this.selects[0].label;
        }
    }

    /**
     * 打开选择视图
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    public openView() {
        const view: any = {
            viewname: 'app-group-picker',
            title: (this.$t('components.appGroupSelect.groupSelect') as string)
        };
        const context: any = JSON.parse(JSON.stringify(this.context));
        let filtervalue:string = "";
        if(this.filter){
            if(this.data[this.filter]){
                filtervalue = this.data[this.filter];
            }else if(context[this.filter]){
                filtervalue = context[this.filter];
            }else{
                filtervalue = context.srforgid;
            }
        }else{
            filtervalue = context.srforgid;
        }
        const param: any = {};
        Object.assign(param, {
            showtree: this.treeurl?true:false,
            url:this.url,
            treeurl:this.treeurl,
            filtervalue: filtervalue,
            multiple: this.multiple,
            selects: this.selects,
        });
        let container: Subject<any> = this.$appmodal.openModal(view, context, param);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            this.openViewClose(result);
        });
    }

    /**
     * 选择视图关闭
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    public openViewClose(result: any) {
        this.selects = [];
        if (result.datas && result.datas.length > 0) {
            this.selects = result.datas
        }
        this.setValue()
    }

    /**
     * 数据删除
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    public remove(item: any) {
        this.selects.splice(this.selects.indexOf(item), 1);
        this.setValue()
    }

    /**
     * 设置值
     *
     * @type {*}
     * @memberof AppGroupSelect
     */  
    public setValue() {
        let item: any = {};
        item[this.name] = null;
        if(this.valueitem) {
            item[this.valueitem] = null;
        }
        if(this.fillmap) {
            for(let key in this.fillmap) {
                item[key] = null;
            }
        }
        if(this.multiple) {
            this.selects.forEach((select: any) => {
                item[this.name] = item[this.name] ? `${item[this.name]},${select.label}` : select.label;
                if(this.valueitem) {
                    item[this.valueitem] = item[this.valueitem] ? `${item[this.valueitem]},${select.id}` : select.id;
                }
                if(this.fillmap) {
                    for(let key in this.fillmap) {
                        item[key] = item[key] ? `${item[key]},${select[this.fillmap[key]]}` : select[this.fillmap[key]];
                    }
                }
            });
        } else {
            item[this.name] = this.selects.length > 0 ? this.selects[0].label : null;
            if(this.valueitem) {
                item[this.valueitem] = this.selects.length > 0 ? this.selects[0].id : null;
            }
            if(this.fillmap) {
                for(let key in this.fillmap) {
                    item[key] = this.selects.length > 0 ? this.selects[0][this.fillmap[key]] : null;
                }
            }
        }
        for(let key in item) {
            this.$emit('formitemvaluechange', { name: key, value: item[key] });
        }
    }

    /**
     * 填充label
     * 
     * @memberof AppGroupSelect
     */
    public fillLabel(tempObject:any,valueItem:Array<any>,callback:any){
        if(tempObject.label.length === 0 && tempObject.id.length >0 && this.tag && this.codelistType && Object.is(this.codelistType,"DYNAMIC")){
        let codeListService:CodeListService = new CodeListService();
        codeListService.getItems(this.tag).then((items:any) =>{
            if(items && items.length >0 && valueItem.length >0){
            let tempLabel:Array<any> = [];
            valueItem.forEach((value:any) =>{
                let result:any = items.find((item:any) =>{
                    return item.id === value;
                })
                tempLabel.push(result.label);
            })
            Object.assign(tempObject,{label:tempLabel});
            }
            callback(tempObject);
        }).catch((error:any) =>{
            console.log(error);
        })
        }
    }
  
}
</script>

<style lang="less">
@import './app-group-select.less';
</style>