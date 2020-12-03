<template>
    <div class="app-alert-group">
        <template  v-for="(item, index) in items">
            <app-alert
                :key="index"
                :tag="item.tag"
                :context="context"
                :viewparam="viewparam" 
                :position="item.position"
                :infoGroup="infoGroup"
                :viewname="viewname"/>   
        </template>
    </div>

</template>

<script lang="ts">
import {Vue, Component, Prop} from 'vue-property-decorator';
import ViewMessageGroupService from '@/message/view-message-group-service';
@Component({})
export default class AppAlertGroup extends Vue {

    /**
     * 视图消息组服务
     * 
     * @type {any}
     * @memberof AppAlertGroup
     */
    public viewMessageGroupService = ViewMessageGroupService.getInstance();

    /**
     * 视图消息组tag
     * 
     * @type {any}
     * @memberof AppAlertGroup
     */
    @Prop() infoGroup: any;

    /**
     * 应用上下文
     * 
     * @type {any}
     * @memberof AppAlertGroup
     */
    @Prop() context: any;

    /**
     * 视图参数
     * 
     * @type {any}
     * @memberof AppAlertGroup
     */
    @Prop() viewparam: any;


    /**
     * 视图消息组显示位置
     * 
     * @type {any}
     * @memberof AppAlertGroup
     */
    @Prop() position: any;

    /**
     * 视图名称
     * 
     * @type {any}
     * @memberof AppAlertGroup
     */
    @Prop() viewname: any;

    /**
     * 当前位置视图消息集合
     * 
     * @type {any}
     * @memberof AppAlertGroup
     */
    public items: any[] = [];

    /**
     * Vue生命周期
     * 
     * @memberof AppAlertGroup
     */
    public created() {
        if(this.infoGroup) {
            this.getItems();
        }
    }

    /**
     * 获取当前位置视图消息集合
     * 
     * @memberof AppAlertGroup
     */
    public getItems() {
        this.viewMessageGroupService.getViewMessageDetailsByTag(this.infoGroup).then((response: any) => {
            if(response) {
                response.forEach((data: any) => {
                    if(this.position && Object.is(this.position, data.position)) {
                        this.items.push(data);
                    }
                    if(Object.is('TOP', this.position) && Object.is('POPUP', data.position)) {
                        this.items.push(data);
                    }
                })  
            } 
        }).catch(error => {
            console.log(error);
        });
    }
}
</script>

<style lang="less">
.view-body-messages {
    margin-bottom: 6px;
}
</style>