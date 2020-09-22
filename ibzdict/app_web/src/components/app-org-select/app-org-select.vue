<template>
  <div class="app-org-select">
    <ibiz-select-tree :NodesData="NodesData" v-model="selectTreeValue" :disabled="disabled" :multiple="multiple" @select="treeSelectChange"></ibiz-select-tree>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Watch } from "vue-property-decorator";
import { Http } from '@/utils';
import CodeListService from "@/codelist/codelist-service";
import { observable } from 'rxjs';
@Component({})
export default class AppOrgSelect extends Vue {

  /**
   * 表单数据
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public data!:any;

  /**
   * 上下文
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public context!:any;

  /**
   * 填充对象
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public fillMap:any;

  /**
   * 过滤项
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public filter?:string;

  /**
   * 代码表标识
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public tag?:string;

  /**
   * 代码表类型
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public codelistType?:string;

  /**
   * 是否多选
   * 
   * @memberof AppOrgSelect
   */
  @Prop({default:false}) public multiple?:boolean;

  /**
   * 是否禁用
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop({default:false}) public disabled?: boolean;

  /**
   * 查询单位路径
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public url!:string;

  /**
   * 监听表单数据变化
   * 
   * @memberof AppOrgSelect
   */
  @Watch('data',{immediate:true,deep:true})
  onDataChange(newVal: any, oldVal: any) {
    if(newVal){
      this.computedSelectedData();
      if(this.filter){
        let tempFilterValue:any = this.initBasicData();
        // filter值变化才去请求数据
        if(tempFilterValue && (this.copyFilterValue !== tempFilterValue)){
          this.loadTreeData(this.url.replace('${orgid}',tempFilterValue));
          this.copyFilterValue = tempFilterValue;
        }
      }
    }
  }

  /**
   * 选择值
   * 
   * @memberof AppOrgSelect
   */
  public selectTreeValue:any = "";

  /**
   * 树节点数据
   * 
   * @memberof AppOrgSelect
   */
  public NodesData:any = [];

  /**
   * 备份过滤值
   * 
   * @memberof AppOrgSelect
   */
  public copyFilterValue:any;

  /**
   * vue生命周期
   * 
   * @memberof AppOrgSelect
   */
  public created(){
    if(!this.filter){
      this.loadTreeData(this.url);
    }
  }

  /**
   * 加载树数据
   * 
   * @memberof AppOrgSelect
   */
  public initBasicData(){
    // 计算出过滤值
    if(this.filter){
      if(this.data && this.data[this.filter]){
        return this.data[this.filter];
      }else if(this.context && this.context[this.filter]){
        return this.context[this.filter];
      }else{
        return null;
      }
    }
  }

  /**
   * 计算选中值
   * 
   * @memberof AppOrgSelect
   */
  public computedSelectedData(){
    // 单选
    if(!this.multiple){
      if(this.fillMap && Object.keys(this.fillMap).length >0){
        let templateValue:any = {};
        Object.keys(this.fillMap).forEach((item:any) =>{
          if(this.data && this.data[this.fillMap[item]]){
            Object.assign(templateValue,{[item]:this.data[this.fillMap[item]]});
          }
        })
        if(!templateValue.label && templateValue.id && this.tag && this.codelistType && Object.is(this.codelistType,"DYNAMIC")){
          this.fillLabel(templateValue,templateValue.id,(templateValue:any) =>{
            this.selectTreeValue = JSON.stringify([templateValue]);
          });
        }else{
          this.selectTreeValue = JSON.stringify([templateValue]);
        }
      }
    }else{
    // 多选
      if(this.fillMap && Object.keys(this.fillMap).length >0){
        let tempArray:Array<any> = [];
        Object.keys(this.fillMap).forEach((item:any) =>{
          if(this.data && this.data[this.fillMap[item]]){
            let tempDataArray:Array<any> = (this.data[this.fillMap[item]]).split(",");
            tempDataArray.forEach((tempData:any,index:number) =>{
              if(tempArray.length < tempDataArray.length){
                let singleData:any ={[item]:tempData};
                tempArray.push(singleData);
              }else{
                Object.assign(tempArray[index],{[item]:tempData});
              }
            })
          }
        })
        let tempflag:boolean = false;
        if(tempArray.length >0 && tempArray.length >0){
          tempArray.forEach((item:any) =>{
            if(!item.label) tempflag = true;
          })
        }
        if(tempflag && this.tag && this.codelistType && Object.is(this.codelistType,"DYNAMIC")){
          let tempStatus:number = 0;
          tempArray.forEach((item:any) =>{
            if(!item.label){
              tempStatus += 1;
              this.fillLabel(item,item.id,(result:any) =>{
                item = result;
                tempStatus -= 1;
                if(tempStatus === 0){
                  this.selectTreeValue = JSON.stringify(tempArray);
                }
              })
            }
          })
        }else{
          this.selectTreeValue = JSON.stringify(tempArray);
        }
      }
    }
  }

  /**
   * 加载树数据
   * 
   * @memberof AppOrgSelect
   */
  public loadTreeData(requestUrl:string){
    if(this.filter){
      const result:any = this.$store.getters.getOrgData(this.filter);
      if(result){
        this.NodesData = result;
        return;
      }
    }
    Http.getInstance().get(requestUrl).then((res:any) =>{
      if(!res.status && res.status !== 200){
        console.error((this.$t('components.appOrgSelect.loadFail') as string));
        return;
      }
      this.NodesData = res.data;
      if(this.filter){
        this.$store.commit('addOrgData', { srfkey: this.filter, orgData: res.data });
      }
    })
  }

  /**
   * 树选择触发事件
   * 
   * @memberof AppOrgSelect
   */
  public treeSelectChange($event:any){
    // 多选
    if(this.multiple){
      if(!Object.is($event,'[]')){
        const tempValue:any = JSON.parse($event);
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          Object.keys(this.fillMap).forEach((item:any) =>{
            let tempResult:any ="";
            tempValue.forEach((value:any,index:number) =>{
              tempResult += index>0?`,${value[item]}`:`${value[item]}`;
            })
            setTimeout(() => {
              this.emitValue(this.fillMap[item],tempResult);
            }, 0);
          })
        }
      }else{
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          Object.keys(this.fillMap).forEach((item:any) =>{
            this.emitValue(this.fillMap[item],null);
          })
        }
      }
    }else{
      // 单选
      if(!Object.is($event,'[]')){
        const tempValue:any = JSON.parse($event)[0];
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          Object.keys(this.fillMap).forEach((item:any) =>{
            setTimeout(() => {
              this.emitValue(this.fillMap[item],tempValue[item]);
            }, 0);
          })
        }
      }else{
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          Object.keys(this.fillMap).forEach((item:any) =>{
            this.emitValue(this.fillMap[item],null);
          })
        }
      }
    }
  }

  /**
   * 抛值
   * 
   * @memberof AppOrgSelect
   */
  public emitValue(name:string,value:any){
    this.$emit('select-change',{name:name,value:value});
  }

  /**
   * 填充label
   * 
   * @memberof AppOrgSelect
   */
  public fillLabel(tempObject:any,valueItem:any,callback:any){
    if(!tempObject.label && tempObject.id && this.tag && this.codelistType && Object.is(this.codelistType,"DYNAMIC")){
      let codeListService:CodeListService = new CodeListService();
      codeListService.getItems(this.tag).then((items:any) =>{
        if(items && items.length >0){
          let result:any = items.find((item:any) =>{
            return item.id === valueItem;
          })
          Object.assign(tempObject,{label:result.label});
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
@import "./app-org-select.less";
</style>