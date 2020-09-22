<template>
 <div class='app-form-part' v-if="loadState">
    <avue-form :option="formOption" v-model="formVal"></avue-form>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import { Subject, Subscription } from "rxjs";
@Component({
})
export default class AppFormPart extends Vue {

  /**
   * 系统名称
   *
   * @type {string}
   * @memberof AppFormPart
   */
  @Prop() public systemCodeName!: string;

  /**
   * 应用名称
   *
   * @type {string}
   * @memberof AppFormPart
   */
  @Prop() public appCodeName!: string;

  /**
   * 实体名称
   *
   * @type {string}
   * @memberof AppFormPart
   */
  @Prop() public deCodeName!: string;

  /**
   * 表单代码标识
   *
   * @type {string}
   * @memberof AppFormPart
   */
  @Prop() public formCodeName!: string;

  /**
   * 表单成员标识
   *
   * @type {string}
   * @memberof AppFormPart
   */
  @Prop() public formDetailCodeName!: string;

  /**
   * 当前表单项名称
   *
   * @type {string}
   * @memberof AppFormPart
   */
  @Prop() public name!: string;

  /**
   * 导航上下文
   *
   * @type {string}
   * @memberof AppFormPart
   */
  @Prop() public context!: any;

  /**
   * 导航参数
   *
   * @type {string}
   * @memberof AppFormPart
   */
  @Prop() public viewparams!: any;

  /**
   * 表单数据
   *
   * @type {any}
   * @memberof AppFormPart
   */
  @Prop() public data: any;

  /**
   * 表单状态对象
   *
   * @type {Subject<any>}
   * @memberof AppFormPart
   */
  @Prop() public formState!: Subject<any>;

  /**
   * 订阅对象
   *
   * @protected
   * @type {(Subscription | undefined)}
   * @memberof AppFormPart
   */
  public formStateEvent: Subscription | undefined;

  /**
   * 远程地址
   *
   * @protected
   * @type {(Subscription | undefined)}
   * @memberof AppFormPart
   */
  public remoteUrl:string =`/lite/${this.systemCodeName.toLowerCase()}-${this.appCodeName.toLowerCase()}/components/${this.formDetailCodeName.toLowerCase()}`;

  /**
   * 动态表单配置对象
   *
   * @type {*}
   * @memberof AppFormPart
   */
  public formOption:any;

  /**
   * 当前动态表单绑定值
   *
   * @type {*}
   * @memberof AppFormPart
   */
  public curFormValue:any = {};

  /**
   * 获取动态表单值对象
   *
   * @type {*}
   * @memberof AppFormPart
   */
  get formVal(){
      return this.curFormValue;
  }

  /**
   * 设置动态表单值对象
   *
   * @type {*}
   * @memberof AppFormPart
   */
  set formVal(data:any){
      this.$emit("change",{name:this.name,value:data});
  }

  /**
   * 加载数据状态
   *
   * @type {*}
   * @memberof AppFormPart
   */
  public loadState:boolean = false;

  /**
   * 初始化组件（vue生命周期）
   *
   * @type {Subject<any>}
   * @memberof AppFormPart
   */
  public created(){
    if (this.formState) {
      this.formStateEvent = this.formState.subscribe(({ type, data }) => {
        if (Object.is("load", type)){
            this.loadRemoteFormModel().then((result:any) =>{
                this.initStateData(result);
            })
        }
      });
    }
  }

  /**
   * 初始化状态数据
   *
   * @type {Subject<any>}
   * @memberof AppFormPart
   */
  public initStateData(modelData:any){
    this.computedFormVal(modelData);
    this.formOption = modelData;
    this.loadState = true;
  }

  /**
   * 计算动态表单绑定数据
   *
   * @type {Subject<any>}
   * @memberof AppFormPart
   */
  public  computedFormVal(modelData:any){
    this.curFormValue = {};
    if(modelData && modelData.column && modelData.column.length > 0){
        modelData.column.forEach((element:any) => {
            Object.assign(this.curFormValue,{[element.prop]:null});
        });
    }
    if(Object.keys(this.curFormValue).length > 0){
        Object.keys(this.curFormValue).forEach((item:any) =>{
            if(this.data && this.data[item]){
                this.curFormValue[item] = this.data[item];
            }
        })
    }
  }

  /**
   * 加载动态表单数据模型
   *
   * @type {Subject<any>}
   * @memberof AppFormPart
   */
  public loadRemoteFormModel(){
    return new Promise((resolve:any,reject:any) =>{
        this.$http.get(this.remoteUrl).then((res:any) =>{
            if(res.status && res.status == 200){
                let result:any = res.data;
                resolve(result);
            }else{
                console.warn("加载动态表单模型数据异常");
            }
        }).catch((error:any) =>{
            console.warn("加载动态表单模型数据异常");
        })
    })
  }

  /**
   * 销毁组件（vue生命周期）
   *
   * @type {Subject<any>}
   * @memberof AppFormPart
   */
  public destroy(){
      if(this.formStateEvent){
        this.formStateEvent.unsubscribe();
      }
  }

}
</script>
<style lang = "less">
@import './app-form-part.less';
</style>