<template>
    <!-- 消息弹出框绘制开始 -->
    <el-badge :is-dot="showIsDot" class="item">
        <el-popover
                placement="bottom"
                trigger="click"
                width="400"
                @show="initTabCnt"
                @hide="initTabCnt">
            <el-tabs :value="default_tab_pane" :stretch="true">
                <!-- 待办　-->
                <el-tab-pane :label="myTasks.length==0?myTasksLabel:(myTasksLabel+'('+myTasks.length+')')" name="first" style="height: 300px; overflow: auto" :draggable="false">
                    <template v-for="(myTask,index) in myTasks">
                        <template v-if="index < taskShowCnt">
                            <el-row  class="Row" :key="index" :draggable="false">
                                <el-col :span="3" class="column1" :draggable="false">
                                    <el-avatar icon="el-icon-s-check" size="small" :draggable="false" style="color: white;background-color: #409eff;"></el-avatar>
                                </el-col>
                                <el-col :span="21" class="column2" :draggable="false">
                                    <el-row :draggable="false">
                                        <el-col :span="16" :draggable="false">
                                            <div class="process-definition-name" :draggable="false"><strong>{{myTask.processDefinitionName}}</strong></div>
                                            <div class="description" :draggable="false">{{myTask.description}}</div>
                                            <div class="createtime" :draggable="false">{{ formatDate(myTask.createTime, 'MM-DD hh:mm') }}</div>
                                        </el-col>
                                        <el-col :span="5" :draggable="false" style='display: flex; align-items: center'>
                                            <el-tag :type="myTask.name.indexOf('驳回')!=-1?'danger':(myTask.name.indexOf('成功')!=-1?'success':(myTask.name.indexOf('取消')!=-1?'info':'-'))"
                                                size="small" @click="handleTag(myTask)"
                                                style="cursor: pointer;" :draggable="false">
                                                {{myTask.name}}
                                            </el-tag>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>
                        </template>
                    </template>
                    <template>
                        <div class='show-more' @click="showMore('taskShowCnt')">
                            <label v-if="taskShowCnt < myTasks.length ">{{ this.$t('components.appMessagePopover.loadMore') }}</label>
                            <label v-else>{{ this.$t('components.appMessagePopover.noMore') }}</label>
                        </div>
                    </template>
                </el-tab-pane>
                <!-- 消息 -->
                <el-tab-pane :label="myMsgs.length==0?myMsgsLabel:(myMsgsLabel+'('+myMsgs.length+')')" name="second" :style="{height: '300px',overflow: 'auto'}" :draggable="false">
                    <template v-for="(myMsg,index) in myMsgs">
                        <template v-if="index < msgShowCnt">
                            <el-row  class="Row" :key="index" :draggable="false">
                                <el-col :span="3" class="column1" :draggable="false">
                                    <el-avatar icon="el-icon-chat-dot-square" size="small" :draggable="false" style="color: white;background-color: orange;"></el-avatar>
                                </el-col>
                                <el-col :span="21" class="column2" :draggable="false">
                                    <el-row :draggable="false">
                                        <el-col :span="16" :draggable="false">
                                            <div class="process-definition-name" :draggable="false"><strong>{{myMsg.processDefinitionName}}</strong></div>
                                            <div class="description" :draggable="false">{{myMsg.description}}</div>
                                            <div class="createtime" :draggable="false">{{ formatDate(myMsg.createTime, 'MM-DD hh:mm') }}</div>
                                        </el-col>
                                        <el-col :span="5" :draggable="false" style='display: flex; align-items: center'>
                                            <el-tag :type="myMsg.name.indexOf('驳回')!=-1?'danger':(myMsg.name.indexOf('成功')!=-1?'success':(myMsg.name.indexOf('取消')!=-1?'info':'-'))"
                                                size="small" @click="handleTag(myMsg)"
                                                style="cursor: pointer;" :draggable="false">
                                                {{myMsg.name}}
                                            </el-tag>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>
                        </template>
                    </template>
                    <template>
                        <div class='show-more' @click="showMore('msgShowCnt')">
                            <label v-if="msgShowCnt < myTasks.length ">{{ this.$t('components.appMessagePopover.loadMore') }}</label>
                            <label v-else>{{ this.$t('components.appMessagePopover.noMore') }}</label>
                        </div>
                    </template>
                </el-tab-pane>
            </el-tabs>
            <i id="bellBtn" size="20" slot="reference" class='el-icon-bell'></i>
        </el-popover>
    </el-badge>
    <!-- 消息弹出框绘制结束 -->
</template>

<script lang="ts">
    import {Vue, Component, Prop, Model, Emit} from "vue-property-decorator";
    import {Subject} from "rxjs";
    import {Environment} from '@/environments/environment';
    import moment from 'moment';

    @Component({})
    export default class AppMessagePopover extends Vue {

        // 是否显示小圆点
        public showIsDot: any = false;
        // 默认显示的tab页
        public default_tab_pane: any = "first";
        // 待办列表
        public myTasks: any = [];
        // 待办面板标签
        public myTasksLabel: any = "待办";
        //  待办面板显示条数
        public taskShowCnt:number = 0;
        // 消息列表
        public myMsgs: any = [];
        // 消息面板标签
        public myMsgsLabel: any = "消息";
        //  信息面板显示条数
        public msgShowCnt:number = 0;

        /**
         * vue创建
         */
        created(): void {}

        /**
         * vue挂载
         */
        mounted(): void {
            // 首次获取待办列表
            this.getMyTasks();
            // 定时器:每隔１分钟重新获取待办列表
            const timer = setInterval(()=>{
                this.getMyTasks();
            },60000);
            // 监听定时器,在vue销毁前清除定时器
            this.$once('hook:beforeDestroy',()=>{
                // 清除定时器
                clearInterval(timer);
            });
        }

        /**
         * 获取待办列表
         */
        public getMyTasks() {
            let url: any = '/wfcore/mytasks';
            this.$http.get(url).then((response: any) => {
                if (response && response.status == 200) {
                    const data: any = response.data;
                    if (data && data.length > 0) {
                        this.myTasks = data;
                        this.showIsDot = true;
                    } else {
                        this.myTasks = [];
                    }
                    // 获取消息列表
                    this.getMyMsgs();
                }
            }).catch((error: any) => {
                console.warn("加载数据错误");
            })
        }

        /**
         * 获取消息列表
         */
        public getMyMsgs(){
            // TODO:接口获取消息列表，这里用的待办数据
            this.myMsgs = this.myTasks;
            if (this.myMsgs.length > 0 && this.myTasks.length == 0) {
                // 显示小圆点
                this.showIsDot = true;
            }
        }

        /**
         * 点击标签事件
         */
        public handleTag(data: any) {
            if (!data)  return this.$message.error("未获取到标签内容");
            // 拼接要打开的窗口地址
            const baseUrl:any = Environment.BaseUrl;
            const openUrl:any = baseUrl + `/wfcore/mytasks/${data.processDefinitionKey}/web/${data.processInstanceBusinessKey}/usertasks/${data.taskDefinitionKey}`;
            // 打开新窗口
            window.open(openUrl,'_blank');
        }

        /**
         * 销毁之前
         */
        beforeDestroy(): void {
            // 清空数据
            this.showIsDot = false;
            this.myTasks = [];
            this.myMsgs = [];
        }

        /**
         * 时间格式转换
         */
        public formatDate(date: string, format: string) {
            if(date && format) {
                return moment(date).format(format);
            }
            return date;
        }

        /**
         * 加载更多
         */
        public showMore(cnt: string) {
            if(Object.is('taskShowCnt', cnt)) {
                this.taskShowCnt + 10 < this.myTasks.length ? this.taskShowCnt += 10 : this.taskShowCnt += this.myTasks.length-this.taskShowCnt;
            }
            if(Object.is('msgShowCnt', cnt)) {
                this.msgShowCnt + 10 < this.myMsgs.length ? this.msgShowCnt += 10 : this.msgShowCnt += this.myMsgs.length-this.msgShowCnt;
            }
        }

        /**
         * 弹出框 显示/隐藏 时显示条数初始化
         */
        public initTabCnt() {
            this.taskShowCnt = this.myTasks.length >= 10 ? 10 : this.myTasks.length;
            this.msgShowCnt = this.myMsgs.length >= 10 ? 10 : this.myMsgs.length;
        }

    }
</script>

<style lang='less'>
    @import "app-message-popover.less";
</style>