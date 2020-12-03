<template>
    <div class='login'>
        <img src="/assets/img/background.png"/>

        <div class='login-con'>
            <card :bordered="false">
                <p slot='title' style="text-align: center">
                    &nbsp;&nbsp;{{appTitle}}
                </p>
                <div class='form-con'>
                    <i-form ref='loginForm' :rules="rules" :model="form">
                        <form-item prop='loginname'>
                            <i-input
                                    size='large'
                                    prefix='ios-contact'
                                    v-model.trim="form.loginname"
                                    :placeholder="$t('components.login.placeholder1')"
                                    @keyup.enter.native="handleSubmit">
                            </i-input>
                        </form-item>
                        <form-item prop='password'>
                            <i-input
                                    size='large'
                                    prefix='ios-key'
                                    v-model.trim="form.password"
                                    type='password'
                                    :placeholder="$t('components.login.placeholder2')"
                                    @keyup.enter.native="handleSubmit">
                            </i-input>
                        </form-item>
                        <form-item>
                            <i-button
                                    @click="handleSubmit"
                                    type='primary'
                                    class="login_btn">{{$t('components.login.name')}}
                            </i-button>
                            <i-button
                                    @click="goReset"
                                    type='success'
                                    class="login_reset">{{$t('components.login.reset')}}
                            </i-button>
                        </form-item>

                        <form-item>
                            <div style="text-align: center">
                                <span class="form_tipinfo">{{$t('components.login.other')}}</span>
                            </div>
                            <div style="text-align: center">
                                <div class="sign-btn" @click="tencentHandleClick('tencent')">
                                    <img src="/assets/img/QQ.svg" class="qq-svg-container" draggable="false">
                                </div>
                                <div class="sign-btn" @click="wechatHandleClick('wechat')">
                                    <img src="/assets/img/weixin.svg" class="wx-svg-container" draggable="false">
                                </div>
                            </div>
                        </form-item>

                    </i-form>
                    <p class='login-tip'>
                        {{this.loginTip}}
                        <!--{{this.$t('components.login.tip')}}-->
                    </p>
                </div>
            </card>
            <div class="log_footer">
                <div class="copyright">
                    <a href="https://www.ibizlab.cn/" target="_blank">{{appTitle}} is based on ibizlab .</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import {Vue, Component, Watch} from 'vue-property-decorator';
import {Environment} from '@/environments/environment';
import { Util } from '@/utils';

@Component({
    components: {}
})
export default class Login extends Vue {

    /**
     * 表单对象
     *
     * @type {*}
     * @memberof Login
     */
    public form: any = {loginname: 'ibzadmin', password: '123456'};

    /**
     *　登录提示语
        */
    public loginTip: any = "";

    /**
     *　按钮可点击
        */
    public canClick: any = true;

    /**
     * 应用名称
     *
     * @type {string}
     * @memberof Login
     */
    public appTitle: string = Environment.AppTitle;

    /**
     * 值规则
     *
     * @type {*}
     * @memberof Login
     */
    public rules = {};

    /**
     * 设置值规则
     *
     * @memberof Login
     */
    public setRules() {
        this.rules = {
            loginname: [
                {required: true, message: this.$t('components.login.loginname.message'), trigger: 'change'},
            ],
            password: [
                {required: true, message: this.$t('components.login.password.message'), trigger: 'change'},
            ],
        }
    };

    /**
     * 生命周期Create
     *
     * @memberof Login
     */
    public created() {
        this.setRules();
    }

    public mounted() {
        Util.getCookie("loginname");
    }

    /**
     * 监听语言变化
     *
     * @memberof Login
     */
    @Watch('$i18n.locale')
    onLocaleChange(newval: any, val: any) {
        this.setRules();
    }

    /**
     * 登陆处理
     *
     * @memberof Login
     */
    public handleSubmit(): void {
        // 清除cookie
        let leftTime = new Date();
        leftTime.setTime(leftTime.getSeconds() - 1000);
        document.cookie = "ibzuaa-token=;expires=" + leftTime.toUTCString();
        const form: any = this.$refs.loginForm;
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        if (!validatestate) {
            return;
        }

        const loginname: any = this.form.loginname;
        const password: any = this.form.password;
        const post: Promise<any> = this.$http.post('/v7/login', this.form, true);
        post.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                if (data && data.token) {
                    localStorage.setItem('token', data.token);
                    Util.setCookie('ibzuaa-token',data.token,0);
                }
                if(data && data.user){
                    localStorage.setItem('user', JSON.stringify(data.user));
                }
                // 设置cookie,保存账号密码7天
                Util.setCookie("loginname",loginname, 7);
                // 跳转首页
                const url: any = this.$route.query.redirect ? this.$route.query.redirect : '*';
                this.$router.push({path: url});
            }
        }).catch((error: any) => {
            // 登录提示
            const data = error.data;
            if (data && data.message) {
                this.loginTip = data.message;
                this.$Message.error({
                    content: (this.$t('components.login.loginfailed') as string)+' ' + data.message,
                    duration: 5,
                    closable: true
                });
            } else {
                this.$Message.error({
                    content: (this.$t('components.login.loginfailed') as string),
                    duration: 5,
                    closable: true
                });
            }
        });

    }

    /**
     * 重置页面
     * 
     * @memberof Login
     */
    public goReset(): void {
        const _this = this;
        _this.form={loginname: 'ibzadmin', password: '123456'}
    }

    /**
     * qq授权登录
     * @param thirdpart
     */
    public tencentHandleClick(thirdpart: any) {
        this.$Message.warning((this.$t('components.login.warning1') as string))
    }

    /**
     * 微信授权登录
     * @param thirddpart
     */
    public wechatHandleClick(thirddpart: any) {
        this.$Message.warning((this.$t('components.login.warning2') as string))
    }

}
</script>

<style lang='less'>
    @import './login.less';
</style>