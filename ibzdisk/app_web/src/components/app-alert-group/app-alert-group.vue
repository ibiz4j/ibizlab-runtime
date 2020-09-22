<template>
    <div class="app-alert-group">
        <template  v-for="(item, index) in items">
            <app-alert
                :key="index"
                :tag="item.tag"
                :position="item.position"/>   
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
     * 视图消息组显示位置
     * 
     * @type {any}
     * @memberof AppAlertGroup
     */
    @Prop() position: any;

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