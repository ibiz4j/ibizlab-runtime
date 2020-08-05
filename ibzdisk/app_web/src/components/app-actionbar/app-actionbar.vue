<template>
  <div class="app-actionbar">
    <div class="app-actionbar-item" v-for="(item,index) in items" :key="index">
      <Badge v-if="item.counterService&&item.counterService.counterData" v-show="item.visabled" :count="item.counterService.counterData[item.counterId]" type="primary">
         <i-button :style="{'pointer-events':item.disabled?'none':'auto'}" @click="handleClick(item, $event)"><i v-if="item.icon" style="margin-right: 5px;" :class="item.icon"></i>{{item.actionName}}</i-button>
    </Badge>
    <i-button v-show="item.visabled" :style="{'pointer-events':item.disabled?'none':'auto'}" v-else @click="handleClick(item, $event)">{{item.actionName}}</i-button>
    </div>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit,Inject, Watch } from "vue-property-decorator";
import { Subject,Subscription } from "rxjs";

@Component({})
export default class AppActionBar extends Vue {

  /**
   * 传入操作栏模型数据
   * 
   * @type {any}
   * @memberof AppActionBar
   */
  @Prop() public items!:any;

  /**
   * 注入的UI服务
   *
   * @type {*}
   * @memberof AppActionBar
   */
  @Prop() public uiService!: any;

  /**
   * 视图通讯对象
   *
   * @type {Subject<ViewState>}
   * @memberof AppActionBar
   */
  @Prop() public viewState!: Subject<ViewState>;

  /**
   * 视图状态事件
   *
   * @public
   * @type {(Subscription | undefined)}
   * @memberof ActionlinetestBase
   */
  public viewStateEvent: Subscription | undefined;

  /**
   * 部件数据
   *
   * @type {*}
   * @memberof AppActionBar
   */
  public data: any;

  /**
   * 组件初始化
   *
   * @memberof AppActionBar
   */
  public created(){
    if (this.viewState) {
        this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
            if (!Object.is(tag, "app-actionbar")) {
                return;
            }
            if(Object.is(action,'loadmodel')){
              this.data = data;
              this.calcActionItemAuthState(data,this.items,this.uiService);
            }
        });
    }
  }

  /**
   * 触发界面行为
   * 
   * @memberof AppActionBar
   */
  public handleClick(item: any, $event:any){
    let _data = {
      tag : item.viewlogicname,
      params : this.data,
      event : $event
    };
    this.$emit('itemClick',_data);
  }

  /**
   * 计算界面行为项权限状态
   *
   * @param {*} [data] 传入数据
   * @param {*} [ActionModel] 界面行为模型
   * @param {*} [UIService] 界面行为服务
   * @memberof AppActionBar
   */
  public calcActionItemAuthState(data:any,ActionModel:any,UIService:any){
    for (const key in ActionModel) {
        if (!ActionModel.hasOwnProperty(key)) {
            return;
        }
        const _item = ActionModel[key];
        if(_item && _item['dataaccaction'] && UIService && data && Object.keys(data).length >0){
            let dataActionResult:any = UIService.getAllOPPrivs(data)[_item['dataaccaction']];
            // 无权限:0;有权限:1
            if(dataActionResult === 0){
                // 禁用:1;隐藏:2;隐藏且默认隐藏:6
                if(_item.noprivdisplaymode === 1){
                    _item.disabled = true;
                }
                if((_item.noprivdisplaymode === 2) || (_item.noprivdisplaymode === 6)){
                    _item.visabled = false;
                }else{
                    _item.visabled = true;
                }
            }
            if(dataActionResult === 1){
                _item.visabled = true;
                _item.disabled = false;
            }
        }
    }
  } 

  /**
   * 组件销毁
   * 
   * @memberof AppActionBar
   */
  public destory(){
    if (this.viewStateEvent) {
      this.viewStateEvent.unsubscribe();
    }
  }

}
</script>

<style lang='less'>
@import "./app-actionbar.less";
</style>