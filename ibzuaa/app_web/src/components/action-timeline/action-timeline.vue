<template>
    <div class="action-timeline">
        <template v-for="(item, index) in items">
            <div :key='index' class='action-timeline-group-wrapper'>
                <template v-for="(usertask, usertaskIndex) in item.usertasks">
                    <div :key='usertaskIndex' class='action-timeline-group expand'>
                        <div class='date'>
                            {{ usertask.userTaskName }}
                            <div class='arrow'>
                                <i @click="changeExpand($event)" class="el-icon-arrow-down" />
                            </div>
                        </div>
                        <div class='timeline'>
                            <template v-if="usertask.identitylinks && usertask.identitylinks.length > 0">
                                    等待
                                    <strong>
                                    <template v-for="(identitylink, len) in usertask.identitylinks">
                                        {{ identitylink.displayname }}
                                        <template v-if="len != usertask.identitylinks.length - 1">
                                            、
                                        </template>
                                    </template>  
                                    </strong>  
                                    处理
                            </template>
                            <template v-else>
                                <ul class="action-timeline-wrapper">
                                    <template v-if="!usertask.isShow">
                                        <template>
                                            <li class="action-timeline-item">
                                                <div class='timeline-time'>
                                                    {{ formatDate(usertask.comments[0].time, 'MM月DD日')}} &nbsp;{{ usertask.comments[0].authorName }}
                                                </div>
                                                <div class='timeline-content'>
                                                    {{ usertask.comments[0].type }}&nbsp;{{ usertask.comments[0].fullMessage }}
                                                </div>
                                            </li>
                                        </template>
                                    </template>
                                    <template v-else>
                                    <template v-for="(comment, commentIndex) in usertask.comments">
                                        <li :key="commentIndex" class="action-timeline-item">
                                            <div class='timeline-time'>
                                                 {{ formatDate(comment.time, 'MM月DD日')}} &nbsp;{{ comment.authorName }}
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
        </template>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { ActionTimelineItem } from './action-timeline-interface';
import moment from 'moment';

@Component({
})
export default class ActionTimeline extends Vue {

    @Prop() public data!: any;

    public items: any[] = [{
    "id": "40833204-9be4-11ea-9c94-0242130d84ce",
    "name": null,
    "processDefinitionKey": null,
    "processDefinitionName": null,
    "businessKey": "DC20200522022",
    "startTime": "2020-05-22 12:25:22",
    "endTime": null,
    "startUserId": "001-004_0001",
    "startUserName": "隆俊杰",
    "usertasks": [{
        "userTaskId": "tid-1-1f3eda90105907e25e6f2e8c0f82b903",
        "userTaskName": "管理员审批",
        "processDefinitionKey": null,
        "processDefinitionName": null,
        "identitylinks": [],
        "comments": [{
            "id": "44eddf40-9be4-11ea-9c94-0242130d84ce",
            "author": "001-004_0001",
            "authorName": "隆俊杰",
            "fullMessage": "",
            "time": "2020-05-22 12:25:29",
            "type": "审批不通过",
            "taskId": "40844383-9be4-11ea-9c94-0242130d84ce",
            "processInstanceId": "40833204-9be4-11ea-9c94-0242130d84ce",
            "processInstanceBusinessKey": "DC20200522022"
        }, {
            "id": "b39cfc68-9be4-11ea-9c94-0242130d84ce",
            "author": "450000-000",
            "authorName": "ibzadmin",
            "fullMessage": "",
            "time": "2020-05-22 12:28:35",
            "type": "审批不通过",
            "taskId": "a6c57ad1-9be4-11ea-9c94-0242130d84ce",
            "processInstanceId": "40833204-9be4-11ea-9c94-0242130d84ce",
            "processInstanceBusinessKey": "DC20200522022"
        }]
    }, {
        "userTaskId": "tid-2-c60d498abacb47b510e0aa9d64a55e57",
        "userTaskName": "被驳回",
        "processDefinitionKey": null,
        "processDefinitionName": null,
        "identitylinks": [{
            "id": "001-004_0001",
            "firstname": null,
            "displayname": "隆俊杰"
        }],
        "comments": [{
            "id": "a6c21f6e-9be4-11ea-9c94-0242130d84ce",
            "author": "001-004_0001",
            "authorName": "隆俊杰",
            "fullMessage": "",
            "time": "2020-05-22 12:28:14",
            "type": "提交",
            "taskId": "44f09e63-9be4-11ea-9c94-0242130d84ce",
            "processInstanceId": "40833204-9be4-11ea-9c94-0242130d84ce",
            "processInstanceBusinessKey": "DC20200522022"
        }]
    }]
}];

    public created() {
        this.handleData();
    }

    public handleData() {
        if(this.data) {
            this.items = this.data;
        }
    }

    public formatDate(date: string, format: string) {
        return moment(date).format(format);
    }

    public updown: boolean = false;
    public changeExpand($event:any) {
        this.items.forEach((item: any) => {
            item.usertasks.forEach((usertask: any) => {
                if(usertask.comments.length > 0) {
                    usertask.isShow = false;
                }
            })
        })
    }

    public expands: any;
    public handleIdentData() {
        if(this.data) {
            this.items = this.data;
            this.items.forEach((item: any) => {
                item.usertasks.forEach((usertask: any) => {
                    usertask.isShow = true;
                })
            })
        }
    }

}
</script>

<style lang='less'>
@import './action-timeline.less';
</style>