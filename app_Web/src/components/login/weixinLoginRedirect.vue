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

        // 表单
        public form: any = {loginname: '', password: ''};
        // 表单可点击
        public canClick: any = true;
        // 按钮内容
        public BtnContent: any = "注册并绑定微信";

        // 微信授权成功返回的code和state
        public code: any;
        public state: any;

        // 微信用户信息
        public wechatUserInfo:any = {
            openid:'',//微信用户身份的唯一标识
            nickname:'',//微信用户名称
            access_token: '',// 临时授权token
            refresh_token:'',// 刷新授权token
            unionid:'',//微信用户唯一标识
        }

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
                // 从local中获取微信用户的openid,可用于后续请求及绑定操作
                if (localStorage.getItem("openid")) {
                    this.wechatUserInfo.openid = localStorage.getItem("openid");
                }
                if (localStorage.getItem("access_token")) {
                    this.wechatUserInfo.access_token = localStorage.getItem("access_token");
                }
                if (localStorage.getItem("refresh_token")) {
                    this.wechatUserInfo.refresh_token = localStorage.getItem("refresh_token");
                }
                if (localStorage.getItem("unionid")) {
                    this.wechatUserInfo.unionid = localStorage.getItem("unionid");
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
         * @param name
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
                param.openid = this.wechatUserInfo.openid;
                param.nickname = this.wechatUserInfo.nickname;
            } else {
                this.$message.error("微信授权，获取code失败");
                return;
            }
            // post请求绑定微信
            const post: Promise<any> = this.$http.post('/uaa/open/wechat/bind', param, true);
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
                            let user: any = data.user;
                            localStorage.setItem('user',JSON.stringify(user));
                            // 设置cookie,保存账号7天
                            this.setCookie("loginname", user.loginname, 7);
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
         * 设置Cookie
         * @param name
         * @param value
         * @param day
         */
        public setCookie(name: any, value: any, day: any) {
            if (day !== 0) { //当设置的时间等于0时，不设置expires属性，cookie在浏览器关闭后删除
                var curDate = new Date();
                var curTamp = curDate.getTime();
                var curWeeHours = new Date(curDate.toLocaleDateString()).getTime() - 1;
                var passedTamp = curTamp - curWeeHours;
                var leftTamp = 24 * 60 * 60 * 1000 - passedTamp;
                var leftTime = new Date();
                leftTime.setTime(leftTamp + curTamp);
                document.cookie = name + "=" + escape(value) + ";expires=" + leftTime.toUTCString() + ";path=/";
            } else {
                document.cookie = name + "=" + escape(value);
            }
        }


    }
</script>

<style lang='less'>
    @import './weixinLoginRedirect.less';
</style>