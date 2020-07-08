<template>
  <div class="update-password">
    <div class="password-item">
      <label for>
        {{$t('components.appUpdatePassword.oldPwd')}}
        <Input type="password" v-model="oldPwd" @on-blur="oldPwdVaild"/>
      </label>
    </div>
    <div class="password-item">
      <label for>
        {{$t('components.appUpdatePassword.newPwd')}}
        <Input type="password" v-model="newPwd"  @on-blur="newPwdVaild"/>
      </label>
    </div>
    <div class="password-item">
      <label for>
        {{$t('components.appUpdatePassword.confirmPwd')}}
        <Input type="password" v-model="confirmPwd" :disabled="!this.newPwd" @on-blur="confirmVaild" />
      </label>
    </div>
    <div class="password-item password-btn">
        <Button type="primary" long :disabled="!oldPwd || !newPwd || !confirmPwd || disUpdate" @click="updatePwd">{{$t('components.appUpdatePassword.sure')}}</Button>
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
                title: (this.$t('components.appUpdatePassword.oldPwdErr') as string),
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
                title: (this.$t('components.appUpdatePassword.newPwdErr') as string),
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
                    title: (this.$t('components.appUpdatePassword.confirmPwdErr') as string),
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
                title: (this.$t('app.codeNotExist.sysException') as string),
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