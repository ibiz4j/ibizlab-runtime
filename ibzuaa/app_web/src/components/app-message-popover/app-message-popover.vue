<template>
    <!-- 消息弹出框绘制开始 -->
    <el-badge :is-dot="showIsDot" class="item">
        <el-popover
                placement="bottom"
                trigger="click"
                width="400">
            <el-tabs :value="default_tab_pane" :stretch="true">
                <!-- 待办　-->
                <el-tab-pane :label="myTasks.length==0?myTasksLabel:(myTasksLabel+'('+myTasks.length+')')" name="first" style="height: 300px; overflow: auto" :draggable="false">
                    <el-row v-for="(myTask,index) in myTasks" class="Row" :draggable="false">
                        <el-col :span="6" class="column1" :draggable="false">
                            <el-avatar icon="el-icon-s-check" size="small" :draggable="false" style="color: white;background-color: #409eff;"></el-avatar>
                        </el-col>
                        <el-col :span="18" class="column2" :draggable="false">
                            <el-row :draggable="false">
                                <el-col :span="12" :draggable="false">
                                    <div :draggable="false">{{myTask.processDefinitionName}}</div>
                                    <div :draggable="false">{{myTask.description}}</div>
                                    <div :draggable="false">{{myTask.createTime}}</div>
                                </el-col>
                                <el-col :span="6" :draggable="false">
                                    <el-tag :type="myTask.name.indexOf('驳回')!=-1?'danger':(myTask.name.indexOf('成功')!=-1?'success':(myTask.name.indexOf('取消')!=-1?'info':'-'))"
                                            size="small" @click="handleTag(myTask)"
                                            style="cursor: pointer;" :draggable="false">
                                        {{myTask.name}}
                                    </el-tag>
                                </el-col>
                            </el-row>
                        </el-col>
                    </el-row>
                </el-tab-pane>
                <!-- 消息 -->
                <el-tab-pane :label="myMsgs.length==0?myMsgsLabel:(myMsgsLabel+'('+myMsgs.length+')')" name="second"　style="height: 300px; overflow: auto" :draggable="false">
                    <el-row v-for="(myMsg,index) in myMsgs" class="Row" :draggable="false">
                        <el-col :span="6" class="column1" :draggable="false">
                            <el-avatar icon="el-icon-chat-dot-square" size="small" :draggable="false" style="color: white;background-color: orange;"></el-avatar>
                        </el-col>
                        <el-col :span="18" class="column2" :draggable="false">
                            <el-row :draggable="false">
                                <el-col :span="12" :draggable="false">
                                    <div :draggable="false">{{myMsg.processDefinitionName}}</div>
                                    <div :draggable="false">{{myMsg.description}}</div>
                                    <div :draggable="false">{{myMsg.createTime}}</div>
                                </el-col>
                                <el-col :span="6" :draggable="false">
                                    <el-tag :type="myMsg.name.indexOf('驳回')!=-1?'danger':(myMsg.name.indexOf('成功')!=-1?'success':(myMsg.name.indexOf('取消')!=-1?'info':'-'))"
                                            size="small" @click="handleTag(myMsg)"
                                            style="cursor: pointer;" :draggable="false">
                                        {{myMsg.name}}
                                    </el-tag>
                                </el-col>
                            </el-row>
                        </el-col>
                    </el-row>
                </el-tab-pane>
            </el-tabs>
            <el-button id="bellBtn" icon="el-icon-bell" size="mini" slot="reference"></el-button>
        </el-popover>
    </el-badge>
    <!-- 消息弹出框绘制结束 -->
</template>

<script lang="ts">
    import {Vue, Component, Prop, Model, Emit} from "vue-property-decorator";
    import {Subject} from "rxjs";
    import {Environment} from '@/environments/environment';

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
        // 消息列表
        public myMsgs: any = [];
        // 消息列表标签
        public myMsgsLabel: any = "消息";

        /**
         * vue创建
         */
        created(): void {

        }

        /**
         * vue挂载
         */
        mounted(): void {
            // 第一次获取待办列表
            this.getMyTasks();
            let count = 1;
            // 每隔１分钟重新获取待办列表
            setInterval(()=>{
                this.getMyTasks();
                count++;
            },1000*60);
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
                this.$Notice.error({title: '错误', desc: error});
            })
        }

        /**
         * 获取消息列表
         */
        public getMyMsgs(){
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
            alert(JSON.stringify(data));
        }

        /**
         * 销毁之前
         */
        beforeDestroy(): void {
            this.showIsDot = false;
            this.myTasks = [];
            this.myMsgs = [];
        }

    }
</script>

<style lang='less'>
    @import "app-message-popover.less";
</style>