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
                                    placeholder="用户名"
                                    @keyup.enter.native="handleSubmit">
                            </i-input>
                        </form-item>
                        <form-item prop='password'>
                            <i-input
                                    size='large'
                                    prefix='ios-key'
                                    v-model.trim="form.password"
                                    type='password'
                                    placeholder="密码"
                                    @keyup.enter.native="handleSubmit">
                            </i-input>
                        </form-item>
                        <form-item>
                            <i-button
                                    @click="handleSubmit"
                                    type='primary'
                                    class="login_btn">登录
                            </i-button>
                            <i-button
                                    @click="goReset"
                                    type='success'
                                    class="login_reset">重置
                            </i-button>
                        </form-item>

                        <form-item>
                            <div style="text-align: center">
                                <span class="form_tipinfo">其他登录方式</span>
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
    //import Divider from "ibiz-vue-lib/lib/ibiz-vue-lib.common";

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
            this.getCookie();
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
            const post: Promise<any> = this.$http.post('v7/login', this.form, true);
            post.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data.token) {
                        localStorage.setItem('token', data.token);
                    }
                    if (data && data.user) {
                        localStorage.setItem('user', JSON.stringify(data.user));
                    }
                    // 设置cookie,保存账号密码7天
                    this.setCookie(loginname, 7);
                    // 跳转首页
                    const url: any = this.$route.query.redirect ? this.$route.query.redirect : '*';
                    this.$router.push({path: url});
                }
            }).catch((error: any) => {
                // const loginfailed: any = this.$t('components.login.loginfailed');
                // this.$Notice.error({ title: (this.$t('components.login.error') as any), desc: loginfailed });
                // 登录提示

                const data = error.data;
                if (data && data.message) {
                    this.loginTip = data.message;
                    this.$Message.error({
                        content: "登录失败，" + data.message,
                        duration: 5,
                        closable: true
                    });
                } else {
                    this.$Message.error({
                        content: "登录失败",
                        duration: 5,
                        closable: true
                    });
                }
            });

        }

        /**
         * 重置页面
         */
        public goReset(): void {
            const _this = this;
            _this.form={loginname: 'ibzadmin', password: '123456'}
        }


        /**
         * 设置cookie,保存账号密码
         * @param loginname
         * @param password
         */
        public setCookie(loginname: any, exdays: any) {
            // 获取时间
            let exdate = new Date();
            // 保存的天数
            exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays);
            // 字符串拼接cookie
            window.document.cookie = "loginname" + "=" + loginname + ";path=/;expires=" + exdate.toUTCString();
        }

        /**
         * 获取cookie
         */
        public getCookie() {
            if (document.cookie.length > 0) {
                var arr = document.cookie.split('; ');
                for (var i = 0; i < arr.length; i++) {
                    var arr2 = arr[i].split('=');
                    //判断查找相对应的值
                    if (arr2[0] == 'loginname') {
                        this.form.loginname = arr2[1];
                    }
                }
            }
        }

        /**
         * qq授权登录
         * @param thirdpart
         */
        public tencentHandleClick(thirdpart: any) {
            this.$Message.warning("qq授权登录暂未支持")
        }

        /**
         * 微信授权登录
         * @param thirddpart
         */
        public wechatHandleClick(thirddpart: any) {
            this.$Message.warning("微信授权登录暂未支持")
        }

    }
</script>

<style lang='less'>
    @import './login.less';
</style>