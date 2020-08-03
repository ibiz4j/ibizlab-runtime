<template>
    <div class='login'>
        <img src="/assets/img/background.png" draggable="false"/>

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
    export default class weixinLoginRedirect extends Vue {

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
        public BtnContent: any = "注册并绑定微信";

        /**
         * 微信授权成功返回的code和state
         */
        public code: any;
        public state: any;

        /**
         * 微信用户身份的唯一标识
         */
        public openid: any;

        /**
         * 微信用户名称
         */
        public nickname: any;

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

            // 从url获取授权code和state
            this.code = this.$route.query.code;
            if (!this.code) {
                this.code = this.getUrlParam('code');
            }
            this.state = this.$route.query.state;
            if (!this.state) {
                this.state = this.getUrlParam('state');
            }
            // 获取失败，回到登录页
            if (!this.code || !this.state) {
                this.$message.error("微信授权，获取code失败");
                this.goLogin();
            }
            else {
                // 从local中获取该用户的openid和nickname
                if (localStorage.getItem("openid")) {
                    this.openid = localStorage.getItem("openid");
                }
                if (localStorage.getItem("nickname")) {
                    this.nickname = localStorage.getItem("nickname");
                }
            }

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
         * 获取url参数
         */
        public getUrlParam(name: any) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg); //匹配目标参数
            if (r != null) return unescape(r[2]);
            return null; //返回参数值
        }


        /**
         * 注册处理
         */
        public handleRegister(): void {
            if (this.canClick != true) {
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

            // 请求传参
            var param: any = this.form;
            if (this.code && this.state) {
                param.code = this.code;
                param.state = this.state;
                param.openid = this.openid;
                param.nickname = this.nickname;
            } else {
                this.$message.error("微信授权，获取code失败");
                return;
            }

            const post: Promise<any> = this.$http.post('/uaa/bindWechatToRegister', param, true);
            post.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data) {
                        this.$Message.success({
                            content: "注册成功,正在登录"
                        });
                        if (data.token) {
                            localStorage.setItem('token', data.token);
                        }
                        if (data.user) {
                            localStorage.setItem('user', JSON.stringify(data.user));
                        }
                        if (data.ibzuser) {
                            let ibzuser: any = JSON.stringify(data.ibzuser);
                            // 设置cookie,保存账号密码7天
                            this.setCookie(ibzuser.loginname, ibzuser.password, 7);
                            // 跳转首页
                            const url: any = '*';
                            this.$router.push({path: url});
                        }
                    }
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
                // 返回登录页
                this.goLogin();
            });
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
    @import './weixinLoginRedirect.less';
</style>