<template>
    <div class="dropdown-list-mpicker-container">
        <i-select
            v-if="!hasChildren"
            class='dropdown-list-mpicker'
            multiple 
            :transfer="true"
            transfer-class-name="dropdown-list-mpicker-transfer"
            v-model="currentVal"
            :disabled="disabled"
            :clearable="true"
            :filterable="filterable"
            @on-open-change="onClick"
            :placeholder="placeholder?placeholder:$t('components.dropDownListMpicker.placeholder')">
            <i-option v-for="(item, index) in items" :key="index" :class="item.class" :value="item.value.toString()" :label="item.text">
            <Checkbox :value = "(currentVal.indexOf(item.value.toString()))==-1?false:true">
                {{Object.is(codelistType,'STATIC') ? $t('codelist.'+tag+'.'+item.value) : item.text}}
            </Checkbox>
            </i-option>
        </i-select>
        <ibiz-select-tree v-if="hasChildren" class="tree-dropdown-list-mpicker" :disabled="disabled" :NodesData="items" v-model="currentVal" :multiple="true"></ibiz-select-tree>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model } from 'vue-property-decorator';
import CodeListService from "@/codelist/codelist-service";
import { Util } from '@/utils';
@Component({
})
export default class DropDownListMpicker extends Vue {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof DropDownListMpicker
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 是否有子集
     * @type {boolean}
     * @memberof DropDownListMpicker
     */
    public hasChildren:boolean = false;

    /**
     * 当前选中值
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Model('change') readonly itemValue!: any;

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public tag?: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public codelistType?: string;

    /**
     * 代码表值分隔符
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop({default:','}) public valueSeparator?: string;

    /**
     * 是否禁用
     * @type {any}
     * @memberof DropDownListMpicker
     * 
     */
    @Prop() public disabled?: any;

    /**
     * 是否支持过滤
     * @type {boolean}
     * @memberof DropDownListMpicker
     */
    public filterable: boolean = true;

    /**
     * 下拉选提示内容
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public placeholder?: string;

    /**
     * 局部上下文导航参数
     * 
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Prop() public localContext!:any;

    /**
     * 局部导航参数
     * 
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Prop() public localParam!:any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public viewparams!: any;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public data?: any;

    /**
     * 计算属性(当前值)
     * @type {any}
     * @memberof DropDownListMpicker
     */
    set currentVal(val: any) {
        if(this.hasChildren && val){
            let tempVal:any = JSON.parse(val);
            if(tempVal.length >0){
                val = tempVal.map((item:any) =>{
                    return item.value;
                })
            }
        }
        const type: string = this.$util.typeOf(val);
        val = Object.is(type, 'null') || Object.is(type, 'undefined') ? [] : val;
        let value = val.length > 0 ? val.join(this.valueSeparator) : '';
        this.$emit('change', value);
    }

    /**
     * 获取值对象
     *
     * @memberof DropDownListMpicker
     */
    get currentVal() {
        if(this.hasChildren){
            if(this.itemValue){
                let list:Array<any> = [];
                let selectedvalueArray:Array<any> = [];
                let curSelectedValue:Array<any> = this.itemValue.split(this.valueSeparator);
                this.getItemList(list,this.items);
                if(curSelectedValue.length > 0){
                    curSelectedValue.forEach((selectedVal:any) =>{
                        let tempResult:any = list.find((item:any) =>{
                            return item.value == selectedVal;
                        })
                        selectedvalueArray.push(tempResult);
                    })
                }
                return selectedvalueArray.length >0?JSON.stringify(selectedvalueArray):null;
            }else{
                return null;
            }

        }
        return this.itemValue? this.itemValue.split(this.valueSeparator):[];
    }

    /**
     * 获取代码表列表
     *
     * @memberof DropDownListMpicker
     */
    public getItemList(list:Array<any>,items:Array<any>){
        if(items && items.length >0){
            items.forEach((item:any) =>{
                if(item.children){
                    this.getItemList(list,item.children);
                }
                list.push(item);
            })
        }
    }

    /**
     * 代码表
     *
     * @type {any[]}
     * @memberof DropDownListMpicker
     */
    public items: any[] = [];

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof DropDownList
     */
    public handlePublicParams(arg: any) {
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.data,arg.context,arg.param,this.localContext);
            Object.assign(arg.context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.data,arg.param,arg.param,this.localParam);
            Object.assign(arg.param,_param);
        }
    }

    /**
     * vue  生命周期
     *
     * @memberof DropDownListMpicker
     */
    public created() {
      if(this.tag && Object.is(this.codelistType,"STATIC")){
          const codelist = this.$store.getters.getCodeList(this.tag);
          if (codelist) {
            this.items = [...JSON.parse(JSON.stringify(codelist.items))];
            this.handleLevelCodeList(Util.deepCopy(this.items));
          } else {
              console.log(`----${this.tag}----${(this.$t('app.commonWords.codeNotExist') as string)}`);
          }
      }else if(this.tag && Object.is(this.codelistType,"DYNAMIC")){
          // 公共参数处理
          let data: any = {};
          this.handlePublicParams(data);
          // 参数处理
          let _context = data.context;
          let _param = data.param;
          this.codeListService.getItems(this.tag,_context,_param).then((res:any) => {
            this.items = res;
            this.handleLevelCodeList(Util.deepCopy(this.items));
          }).catch((error:any) => {
              console.log(`----${this.tag}----${(this.$t('app.commonWords.codeNotExist') as string)}`);
          });
      }
    }
    
    /**
     * 下拉点击事件
     *
     * @param {*} $event
     * @memberof DropDownListMpicker
     */
    public onClick($event:any){
        if(this.tag && Object.is(this.codelistType,"DYNAMIC")){
            // 公共参数处理
            let data: any = {};
            this.handlePublicParams(data);
            // 参数处理
            let _context = data.context;
            let _param = data.param;
            this.codeListService.getItems(this.tag,_context,_param).then((res:any) => {
                this.items = res;
                this.handleLevelCodeList(Util.deepCopy(this.items));
            }).catch((error:any) => {
                console.log(`----${this.tag}----${(this.$t('app.commonWords.codeNotExist') as string)}`);
            });
        }
    }

    /**
     * 处理层级代码表
     * 
     * @param {*} items
     * @memberof DropDownListMpicker
     */
    public handleLevelCodeList(items: Array<any>){
        if(items && items.length >0){
            this.hasChildren = items.some((item:any) =>{
                return item.pvalue;
            })
            if(this.hasChildren){
                let list:Array<any> = [];
                items.forEach((codeItem:any) =>{
                    if(!codeItem.pvalue){
                        let valueField:string = codeItem.value;
                        this.setChildCodeItems(valueField,items,codeItem);
                        list.push(codeItem);
                    }
                })
                this.items = list;
            }
        }
    }

    /**
     * 计算子类代码表
     * 
     * @param {*} items
     * @memberof DropDownListMpicker
     */
    public setChildCodeItems(pValue:string,result:Array<any>,codeItem:any){
        result.forEach((item:any) =>{
            if(item.pvalue == pValue){
                let valueField:string = item.value;
                this.setChildCodeItems(valueField,result,item);
                if(!codeItem.children){
                    codeItem.children = [];
                }
                codeItem.children.push(item);
            }
        })
    }

}
</script>

<style lang='less'>
@import './dropdown-list-mpicker.less';
</style>