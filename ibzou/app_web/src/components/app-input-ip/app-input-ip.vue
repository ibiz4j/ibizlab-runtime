<template>
    <div class="app-inpu-ip">
        <el-input  
            type="text" 
            size="small"
            v-model="firstIp"
            maxlength="3" />.
        <el-input          
            type="text" 
            size="small"
            v-model="secIp"
            maxlength="3" />.
        <el-input 
            type="text"
            size="small"
            maxlength="3" 
            v-model="thirdIp" />.
        <el-input 
            type="text" 
            size="small"
            maxlength="3"
            v-model="forIp" />
    </div>     
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from 'vue-property-decorator';
import { Subject,Subscription } from 'rxjs';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';

@Component({
})
export default class AppInputIp extends Vue {  

    /**
     * 应用上下文
     * 
     * @type {any}
     * @memberof AppInputIp
     */
    @Prop() context: any;

    /**
     * 视图参数
     * 
     * @type {any}
     * @memberof AppInputIp
     */
    @Prop() viewparam: any;

    /**
     * 表单状态对象
     *
     * @type {Subject<any>}
     * @memberof AppInputIp
     */
    @Prop() public formState!: Subject<any>;

    /**表单数据绑定
     * 
     * @type {string}
     * @memberof AppInputIp
     */
    @Model('change') public ipdata!: string;

    /**
     * 获取当前值
     *
     * @type {string}
     * @memberof AppInputIp
     */
    public CurValue: any[] = [];

    /**
     * 第一段ip
     * 
     * @type {any}
     * @memberof AppInputIp
     */
    public firstIp: any = '';

    /**
     * 第二段ip
     * 
     * @type {any}
     * @memberof AppInputIp
     */
    public secIp: any = '';

    /**
     * 第三段ip
     * 
     * @type {any}
     */
    public thirdIp: any = '';

    /**
     * 第四段ip
     * 
     * @type {any}
     * @memberof AppInputIp
     */
    public forIp: any = '';
   
    /**
     * Vue声明周期(处理组件的输入属性)
     *
     * @memberof AppInputIp
     */
    public created(){
        if(this.formState){
             this.formState.subscribe(({type,data})=>{  
                if(Object.is('load',type)){
                    this.loadData();
                }
            })
        }
        this.loadData();
    } 

    /**
     * 加载数据
     *
     * @memberof AppInputIp
     */
    public loadData(){
        if(this.ipdata){
            let iparr:Array<any> = this.ipdata.split('.');
            this.CurValue = iparr;
            this.firstIp = this.CurValue[0];
            this.secIp = this.CurValue[1];
            this.thirdIp = this.CurValue[2];
            this.forIp = this.CurValue[3];
        }
    }

    /**
     * 监听每段ip变化
     * 
     * @memberof AppInputIp
     */
    @Watch('firstIp')
    public FirstIpChange(newVal:any,oldVal:any){
        this.checkIpVal(newVal,oldVal,'firstIp',0);
    }

    @Watch('secIp')
    public SecIpChange(newVal:any,oldVal:any){
        this.checkIpVal(newVal,oldVal,'secIp',1);
    }

    @Watch('thirdIp')
    public ThirdIpChange(newVal:any,oldVal:any){
        this.checkIpVal(newVal,oldVal,'thirdIp',2);
    }

    @Watch('forIp')
    public ForIpChange(newVal:any,oldVal:any){
        this.checkIpVal(newVal,oldVal,'forIp',3);
    }

    /**
     * 验证格式
     * 
     * @memberof AppInputIp
     */
    public checkIpVal(newVal:any,oldVal:any,flag:any,index:number){
        if(newVal === '') return
        let val = newVal;
        let reg = /^(([0-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5]))))$/g;
        if(reg.test(val)){
            this.CurValue[index] = val; 
        }else{
            if(flag){
                let that:any = this;
                that[flag] = oldVal;
                this.CurValue[index] = oldVal;
            }
        }
        if(this.firstIp && this.secIp && this.thirdIp && this.forIp){
            this.$emit('change',this.firstIp+'.'+this.secIp+'.'+this.thirdIp+'.'+this.forIp);
        }
    }
}
</script>

<style lang='less'>
@import './app-input-ip.less';
</style>
