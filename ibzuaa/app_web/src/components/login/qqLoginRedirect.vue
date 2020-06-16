<template>
    <div class='login'>
        <img src="/assets/img/background.png"/>

        <div class='login-con'>
            <card :bordered="false">
                <p slot='title' style="text-align: center">
                    账号绑定
                    <!--<a @click="goLogin" class="goLogin">返回登录</a>-->
                </p>
                <div class='form-con'>
                    <i-form ref='loginForm' :rules="rules" :model="form">
                        <form-item prop='loginname'>
                            <i-input
                                    size='large'
                                    prefix='ios-contact'
                                    v-model.trim="form.loginname"
                                    placeholder="用户名"
                                    @keyup.enter.native="handleRegister">
                            </i-input>
                        </form-item>

                        <form-item prop='password'>
                            <i-input
                                    size='large'
                                    prefix='ios-key'
                                    v-model.trim="form.password"
                                    type='password'
                                    placeholder="密码"
                                    @keyup.enter.native="handleRegister">
                            </i-input>
                        </form-item>

                        <form-item>
                            <i-button
                                    @click="handleRegister"
                                    type='success'
                                    class="confirm_register"
                                    :class="{disabled: !this.canClick}"
                                    long>{{this.BtnContent}}
                            </i-button>
                        </form-item>
                    </i-form>

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

    @Component({
        components: {}
    })
    export default class qqLoginRedirect extends Vue {

        /**
         * 表单对象
         *
         * @type {*}
         * @memberof Register
         */
        public form: any = {loginname: '', password: ''};

        /**
         *　按钮可点击
         */
        public canClick: any = true;

        /**
         * 按钮内容
         */
        public BtnContent: any = "注册并绑定QQ";


        /**
         * 应用名称
         *
         * @type {string}
         * @memberof Register
         */
        public appTitle: string = Environment.AppTitle;

        /**
         * 值规则
         *
         * @type {*}
         * @memberof Register
         */
        public rules = {};

        /**
         * 设置值规则
         *
         * @memberof Register
         */
        public setRules() {
            this.rules = {
                loginname: [
                    {required: true, message: this.$t('components.login.loginname.message'), trigger: 'change'},
                ],
                password: [
                    {required: true, message: this.$t('components.login.password.message'), trigger: 'change'},
                ]
            }
        };

        // 注册方式
        public registerType: any = "commom";
        // 用户身份的唯一标识。建议保存在本地，以便用户下次登录时可对应到其之前的身份信息，不需要重新授权。
        public openId: any;
        // 表示当前用户在此网站/应用的登录状态与授权信息，建议保存在本地。
        public accessToken: any;

        /**
         * 生命周期Create
         *
         * @memberof Register
         */
        public created() {
            this.setRules();
        }

        /**
         * 挂载
         */
        public mounted() {
            let _this = this;
            // 获取qq授权登录的信息，用于后台请求
            if (window.QC.Login.check()) {
                console.log("qq已经登录");
                window.QC.Login.getMe(function(openId:string, accessToken:string){
                    _this.openId = openId;
                    _this.accessToken = accessToken;
                    _this.registerType = "qq";
                    localStorage.setItem("openId",openId);
                    localStorage.setItem("accessToken",accessToken);
                });
                // 根据openId查用户
                this.queryUserByOpenId(this.openId);
            }
        }

        /**
         * 根据openId查用户
         * 1.没系统账号的，进行注册并绑定QQ
         * 2.有系统账号的，直接登录
         * @param openId
         */
        private queryUserByOpenId(openId: any) {
            var param: any = {};
            param.openId = openId;
            const post: Promise<any> = this.$http.post('uaa/queryUserByOpenId', param, true);
            post.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data.ibzuser) {
                        this.form.loginname = data.ibzuser.loginname;
                        this.form.password = data.ibzuser.password;
                        // 直接登录
                        this.countDown(0);
                    }
                }
            }).catch((e: any) => {
                const data = e.data;
                if (data && data.message) {
                    this.$Message.error({
                        content: data.message,
                        duration: 3,
                        closable: true
                    });
                } else {
                    this.$Message.error({
                        content: "错误",
                        duration: 3,
                        closable: true
                    });
                }
            });

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
         * 跳转登录页面
         *
         * @memberof Register
         */
        public goLogin(): void {
            const _this = this;
            _this.$router.push('/login');
        }


        /**
         * 注册处理
         */
        public handleRegister(): void {
            if (this.canClick!=true) {
                return;
            }

            const form: any = this.$refs.loginForm;
            let validatestate: boolean = true;
            form.validate((valid: boolean) => {
                validatestate = valid ? true : false;
            });
            if (!validatestate) {
                return;
            }

            var param: any = this.form;
            if (this.registerType === "qq") {
                param.registerType = "qq";
                param.openId = this.openId;
                param.accessToken = this.accessToken;
            }
            else {
                this.$Message.error({
                    content: "注册并绑定QQ失败",
                    duration: 3,
                    closable: true
                });
                return;
            }
            const post: Promise<any> = this.$http.post('/uaa/register', param, true);
            post.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data.ibzuser) {
                        this.$Message.success({
                            content: "注册成功，用户名:" + data.ibzuser.loginname + "，密码:" + data.ibzuser.password,
                            duration: 3,
                            closable: true
                        });
                    } else {
                        this.$Message.success({
                            content: "注册成功",
                            duration: 3,
                            closable: true
                        });
                    }
                    // 3s后自动登录
                    this.countDown(3);
                }
            }).catch((e: any) => {
                const data = e.data;
                if (data && data.message) {
                    this.$Message.error({
                        content: "注册失败，" + data.message,
                        duration: 3,
                        closable: true
                    });
                } else {
                    this.$Message.error({
                        content: "注册失败",
                        duration: 3,
                        closable: true
                    });
                }
            });
        }

        /**
         * 自动登录倒计时
         */
        public countDown(totalTime: any): void {
            if (!this.canClick) return;
            this.canClick = false;
            this.BtnContent = totalTime + 's后自动登录';
            // 设置定时器
            let clock = window.setInterval(() => {
                // 秒数-1
                totalTime--;
                this.BtnContent = totalTime + 's后自动登录';
                if (totalTime < 0) {
                    // 清除定时器
                    window.clearInterval(clock);
                    // 登录请求
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
                            this.setCookie(loginname, password, 7);
                            // 跳转首页
                            const url: any = this.$route.query.redirect ? this.$route.query.redirect : '*';
                            this.$router.push({path: url});
                        }
                    }).catch((error: any) => {
                        const data = error.data;
                        if (data && data.detail) {
                            this.$Message.error({
                                content: "登录失败，" + data.detail,
                                duration: 3,
                                closable: true
                            });
                        } else {
                            this.$Message.error({
                                content: "登录失败",
                                duration: 3,
                                closable: true
                            });
                        }
                    });

                }
            }, 1000)
        }


        /**
         * 设置cookie,保存账号密码
         * @param loginname
         * @param password
         */
        public setCookie(loginname: any, password: any, exdays: any) {
            // 获取时间
            let exdate = new Date();
            // 保存的天数
            exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays);
            // 字符串拼接cookie
            window.document.cookie = "loginname" + "=" + loginname + ";path=/;expires=" + exdate.toUTCString();
            window.document.cookie = "password" + "=" + password + ";path=/;expires=" + exdate.toUTCString();
        }


    }
</script>

<style lang='less'>
    @import './qqLoginRedirect.less';
</style>