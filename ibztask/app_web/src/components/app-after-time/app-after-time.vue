<template>
    <div class="app-after-time">
        <span v-if="diffTime =='minutes'">{{curvalue}}{{$t('components.appAfterTime.minutesAgo')}}</span>
        <span v-if="diffTime =='hours'">{{curvalue}}{{$t('components.appAfterTime.hoursAgo')}}</span>
        <span v-if="diffTime =='days'">{{curvalue}}{{$t('components.appAfterTime.dayAgo')}}</span>
        <span v-if="diffTime =='mouth'">{{curvalue}}{{$t('components.appAfterTime.monthsAgo')}}</span>
        <span v-if="diffTime =='years'">{{curvalue}}{{$t('components.appAfterTime.yearsAgo')}}</span>
        <span v-if="!diffTime">&nbsp;</span>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop,  Emit, Watch, Model } from 'vue-property-decorator';
import { Subject, Subscription } from 'rxjs';
import  moment  from 'moment';

@Component({})
export default class AppAfterTime extends Vue  {
    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppAfterTime
     */
    @Prop() public name!: string;

    /**
     * 应用上下文
     * 
     * @type {any}
     * @memberof AppAfterTime
     */
    @Prop() context: any;

    /**
     * 视图参数
     * 
     * @type {any}
     * @memberof AppAfterTime
     */
    @Prop() viewparam: any;

    /**
     * 表单状态对象
     *
     * @type {Subject<any>}
     * @memberof AppAfterTime
     */
    @Prop() public formState?:Subject<any>;

    /**
     * 表单绑定数据
     * 
     * @type {any}
     * @memberof AppAfterTime
     */
    @Model('change') public value:any;

    /**
     * 当前值
     * 
     * @type {any}
     * @memberof AppAfterTime
     */
    public curvalue: string = '';

    /**
     * 毫秒差
     * 
     * @type {any}
     * @memberof AppAfterTime
     */
    public diffTime:any='';

    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppAfterTime
     */
    @Watch('value')
    public onValueChange(newVal: any, oldVal: any) {
        this.transTime();
    }

    /**
     * Vue声明周期(处理组件的输入属性)
     *
     * @memberof AppAfterTime
     */
    public created(){
        if(this.formState){
             this.formState.subscribe(({type,data})=>{ 
                if(Object.is('load',type)){
                    this.transTime();
                }
            })
        }
        this.transTime();
    }
    /**
     * 处理时间
     * 
     * @memberof AppAfterTime
     */
    public transTime(){
        if(this.value){
            let dateString:any = 'YYYY年MM月DD日' || 'YYYY年MM月DD日 HH时mm分ss秒' || 'YYYY-MM-DD HH:mm:ss' || 'YYYY-MM-DD' || 'YYYY/MM/DD HH:mm:ss' || 'YYYY/MM/DD';
            let oldTime = moment(this.value,dateString).valueOf();
            let nowTime = moment().valueOf();
            let diffTime = nowTime - oldTime;
            if(diffTime < 3600000){
                this.curvalue = Math.ceil(diffTime/60000)+'';
                this.diffTime = 'minutes';
            }else if(diffTime < 86400000){
                this.curvalue = Math.ceil(diffTime/3600000)+'';
                this.diffTime = 'hours';
            }else if(diffTime < 2592000000){
                this.curvalue = Math.floor(diffTime/86400000)+'';
                this.diffTime = 'days';
            }else if(diffTime < 31104000000){
                this.curvalue = Math.floor(diffTime/2592000000)+'';
                this.diffTime = 'mouth';
            }else{
                this.curvalue = Math.floor(diffTime/31104000000)+'';
                this.diffTime = 'years';
            }
        }
    }
}
</script>

<style>
    .app-after-time{
        margin-left: 6px;
    }
</style>