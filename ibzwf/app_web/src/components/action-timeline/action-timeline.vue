<template>
    <div class="action-timeline">
        <div class='action-timeline-group-wrapper'>
            <template v-for="(usertask, usertaskIndex) in data.usertasks">
                <div :key='usertaskIndex' class='action-timeline-group expand'>
                    <div class='date'>
                        {{ usertask.userTaskName }}
                        <div class='arrow' @click="changeExpand(usertask)">
                            <i :class="usertask.isShow ? 'el-icon-arrow-down' : 'el-icon-arrow-up' " />
                        </div>
                    </div>
                    <div class='timeline'>
                        <template v-if="usertask.identitylinks && usertask.identitylinks.length > 0">
                            {{$t('components.appWFApproval.wait')}}
                            <strong>
                                <template v-for="(identitylink, len) in usertask.identitylinks">
                                    <template v-if="identitylink.displayname">
                                    {{ identitylink.displayname }}
                                    <template v-if="len != usertask.identitylinks.length - 1">
                                     、
                                    </template>
                                    </template>
                                </template>  
                            </strong>  
                            {{$t('components.appWFApproval.handle')}}
                        </template>
                        <template v-else>
                            <ul class="action-timeline-wrapper">
                                <template v-if="!usertask.isShow">
                                    <li v-if="usertask.comments && usertask.comments.length > 0" class="action-timeline-item">
                                        <div class='timeline-time'>
                                            {{ formatDate(usertask.comments[0].time, 'MM月DD日 HH:mm') }}&nbsp;{{ usertask.comments[0].authorName }}
                                        </div>
                                        <div class='timeline-content'>
                                            {{ usertask.comments[0].type }}&nbsp;{{ usertask.comments[0].fullMessage }}
                                        </div>
                                    </li>
                                </template>
                                <template v-else>
                                    <template v-for="(comment, commentIndex) in usertask.comments">
                                        <li :key="commentIndex" class="action-timeline-item">
                                            <div class='timeline-time'>
                                                {{ formatDate(comment.time, 'MM月DD日 HH:mm')}} &nbsp;{{ comment.authorName }}
                                            </div>
                                            <div class='timeline-content'>
                                                {{ comment.type }}&nbsp;{{ comment.fullMessage }}
                                            </div>
                                        </li>
                                    </template>
                                </template>
                            </ul>
                        </template>
                    </div>
                </div>
            </template>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import moment from 'moment';

@Component({
})
export default class ActionTimeline extends Vue {

    /**
     * 数据
     * 
     *  @memberof ActionTimeline
     */
    public data:any = {};

        /**
     *  初始化memo
     * 
     *  @memberof ActionTimeline
     */
    public initmemo:string = "";

    /**
     * 传入数据服务
     * 
     *  @memberof ActionTimeline
     */
    @Prop() public service:any;

    /**
     *  上下文
     * 
     *  @memberof ActionTimeline
     */
    @Prop() public context:any;

    /**
     *  视图参数
     * 
     *  @memberof ActionTimeline
     */
    @Prop() public viewparams:any;

    /**
     * 初始化数据
     * 
     *  @memberof ActionTimeline
     */
    public created(){
        if(this.service){
            this.service.GetWFHistory(this.context).then((res:any) =>{
                if(res && (res.status === 200)){
                    this.data = res.data;
                    this.initUIStateData();  
                }
            })
        }
    }

    /**
     * 初始化数据添加标记
     * 
     *  @memberof ActionTimeline
     */
    public initUIStateData() {
        if(this.data && this.data.usertasks) {
            this.data.usertasks.forEach((item: any) => {
                item.isShow = true;
            })
        } 
    }

    /**
     * 时间转换
     * 
     *  @memberof ActionTimeline
     */
    public formatDate(date: string, format: string) {
        return moment(date).format(format);
    }

    /**
     * 点击事件
     * 
     *  @memberof ActionTimeline
     */
    public changeExpand(usertask:any) {
        usertask.isShow = !usertask.isShow;
        this.$forceUpdate();    
    }

}
</script>

<style lang='less'>
@import './action-timeline.less';
</style>