<template>
    <div class="app-alert">
    <template v-if="items && items.length > 0">
        <template v-for="(item, index) in items">
            <template v-if="item.hasContent && !Object.is('POPUP', item.position)">
            <el-alert
                :key="index"
                v-show="item.showState"
                :title="item.title"
                :type="item.type"
                :closable="item.closable"
                @close="alertClose(item)">
                <template slot>
                    <span v-html="item.content"></span>
                </template>
            </el-alert>
            </template>
        </template>
    </template>
    </div>

</template>

<script lang="ts">
import {Vue, Component, Prop} from 'vue-property-decorator';
import ViewMessageService from '@/message/view-message-service';

@Component({})
export default class AppAlert extends Vue {

    /**
     * 视图消息标识
     * 
     * @type {any}
     * @memberof AppAlert
     */
    @Prop() tag: any;

    /**
     * 显示位置
     * 
     * @type {any}
     * @memberof AppAlert
     */
    @Prop() position: any;

    /**
     * 应用上下文
     * 
     * @type {any}
     * @memberof AppAlert
     */
    @Prop() context: any;

    /**
     * 视图参数
     * 
     * @type {any}
     * @memberof AppAlert
     */
    @Prop() viewparam: any;


    /**
     * 视图消息组tag
     * 
     * @type {any}
     * @memberof AppAlert
     */
    @Prop() infoGroup!: any;

    /**
     * 视图名称
     * 
     * @type {any}
     * @memberof AppAlert
     */
    @Prop() viewname!: any;
    
    /**
     * 视图消息对象
     * 
     * @type {any}
     * @memberof AppAlert
     */
    public items: any[]= [];
    
    /**
     * 视图消息服务
     * 
     * @type {ViewMessageService}
     * @memberof AppAlert
     */
    public viewMessageService = ViewMessageService.getInstance();

    /**
     * Vue生命周期
     * 
     * @memberof AppAlert
     */
    public created() {
        this.getData().then((result:any) =>{
            if(!this.items) {
                return;
            }
        })
    }

    /**
     * 获取视图消息对象
     * 
     * @memberof AppAlert
     */
    public async getData() {
        let response: any = await this.viewMessageService.getViewMessageByTag(this.tag, this.context, this.viewparam);
        if(response && response.length > 0) {
            response.forEach((item: any) => {
                let tempData: any = JSON.parse(JSON.stringify(item));
                if(!tempData.type) {
                    tempData.type = "info";
                }
                //  判断是否存在内容
                this.handleItemHasContent(tempData);
                tempData.closable = tempData.isEnableRemove;
                let flag = this.handleItemCloseMode(tempData);
                this.handleItemPosition(tempData, flag);
                this.items.push(tempData);
            });
        } 
    }

    /**
     * 处理数据项是否存在内容
     * 
     * @memberof AppAlert
     */
    public handleItemHasContent(data: any) {
        data.hasContent = true;
        if(!data.title && !data.content) {
            data.hasContent = false;
        }
    }

    /**
     * 处理数据关闭模式
     * 
     * @memberof AppAlert
     */
    public handleItemCloseMode(data: any) {
        let flag = true;
        data.showState = true; 
        if(data.closeMode || data.closeMode == 0) {
            if(data.closeMode == 1) {
                const tag = this.viewname + '_' + this.infoGroup + '_' + data.codename;
                const id = localStorage.getItem(tag);
                if(id) {
                    data.showState = false;
                    flag = false;
                }
            }
            if(data.closeMode == 0) {
                data.closable = false;
            }
        }
        return flag;
    }

    /**
     * 处理数据显示位置
     * 
     * @memberof AppAlert
     */
    public handleItemPosition(data: any, flag: boolean) {
        if(data.position) {
            if(flag && Object.is('POPUP', data.position)) {
                const h = this.$createElement;
                data.showState = false;
                if(Object.is('HTML',data.messageType) && data.hasMessageTemp) {
                    setTimeout(() => {
                        this.$message({
                            customClass: data.codename+","+data.closeMode,
                            message: h('div',{}, [
                                h('p',data.title),
                                h('p',{domProps:{innerHTML: data.content}})
                            ]), 
                            type: data.type,
                            showClose: data.closable,
                            onClose: this.alertClose,
                        })
                    }, 0)
                } else {
                    setTimeout(() => {
                        this.$message({
                            customClass: data.codename+","+data.closeMode,
                            message: h('div',{}, [
                                h('p',data.title),
                                h('p',data.content)
                            ]), 
                            type: data.type,
                            showClose: data.closable,
                            onClose: this.alertClose,
                        })
                    }, 0)
                }
            }
        }
    }

    /**
     * 视图消息关闭
     * 
     * @memberof AppAlert
     */
    public alertClose(data: any) {
        if(data.customClass) {
            let tempArr: any[] = data.customClass.toString().split(',');
            if(tempArr && tempArr.length > 0) {
                if(Object.is("1", tempArr[1])) {
                    const tag = this.viewname + '_' + this.infoGroup + '_' + tempArr[0];
                    localStorage.setItem(tag, data.customClass);
                }
            } 
        }
        if(data.closeMode && data.closeMode == 1) {
            const tag = this.viewname + '_' + this.infoGroup + '_' + data.codename;
            localStorage.setItem(tag,data.id);
        }
    }

}
</script>

<style lang="less">
@import './app-alert.less';
</style>