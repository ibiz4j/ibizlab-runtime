<template>
  <div class="update-password">
    <div class="password-item">
      <label for>
        原密码：
        <Input type="password" v-model="oldPwd" @on-blur="oldPwdVaild"/>
      </label>
    </div>
    <div class="password-item">
      <label for>
        新密码：
        <Input type="password" v-model="newPwd"  @on-blur="newPwdVaild"/>
      </label>
    </div>
    <div class="password-item">
      <label for>
        确认密码：
        <Input type="password" v-model="confirmPwd" :disabled="!this.newPwd" @on-blur="confirmVaild" />
      </label>
    </div>
    <div class="password-item password-btn">
        <Button type="primary" long :disabled="!oldPwd || !newPwd || !confirmPwd || disUpdate" @click="updatePwd">确认修改</Button>
    </div>
  </div>
</template>

<script lang = 'ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";
import { Subject } from "rxjs";
import { AppModal } from "@/utils";
import EntityService from '@/service/entity-service';
@Component({})
export default class AppUpdatePassword extends Vue {

 /**
     * 原密码
     * 
     * @public
     * @memberof AppUpdatePassword
     */
    public oldPwd: string = "";

    /**
     * 新密码
     * 
     * @public
     * @memberof AppUpdatePassword
     */
    public newPwd: string = "";

    /**
     * 确认密码
     * 
     * @public
     * @memberof AppUpdatePassword
     */
    public confirmPwd: string = "";

    /**
     * 是否能禁用确认修改
     * 
     * @public
     * @memberof AppUpdatePassword
     */
    public disUpdate:boolean = true;

    /**
     * 校验输入的原密码是否为空
     * 
     * @public
     * @memberof AppUpdatePassword
     */
    public oldPwdVaild(){
        if(!this.oldPwd){
            this.$Notice.error({
                title:'原密码不能为空！',
                duration: 3
            });
        }
    }

    /**
     * 校验输入的新密码是否为空
     * 
     * @public
     * @memberof AppUpdatePassword
     */
    public newPwdVaild(){
        if(!this.newPwd){
            this.$Notice.error({
                title:'新密码不能为空！',
                duration: 3
            });
        }
    }

    /**
     * 校验确认密码与新密码是否一致
     * 
     * @public
     * @memberof AppUpdatePassword
     */
    public confirmVaild() {
        if (this.newPwd && this.confirmPwd) {
            if (this.confirmPwd !== this.newPwd) {
                this.$Notice.error({
                    title:'两次输入密码不一致！',
                    duration: 3
                });
            }else{
                this.disUpdate=false;
            }
        }
    }

    /**
     * 实体服务对象
     *
     * @protected
     * @type {EntityService}
     * @memberof AppUpdatePassword
     */
    protected entityService: EntityService = new EntityService();

    /**
     * 修改密码
     *
     * @public
     * @memberof AppUpdatePassword
     */
    public updatePwd(){
      const post: Promise<any> = this.entityService.changPassword(null,{oldPwd:this.oldPwd,newPwd:this.newPwd});
      post.then((response:any) =>{
            if (response && response.status === 200) {
                this.$emit("close");
            }
        }).catch((error: any) =>{
            this.$Notice.error({
                title:'系统异常',
                duration: 3
            });
            console.error(error);
        })
    }
}
</script>

<style lang="less">
@import './app-update-password.less';
</style>