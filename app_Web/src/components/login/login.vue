<template>
    <div class='login'>
        <img src="/assets/img/background.png" draggable="false"/>

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
                            <a @click="goRegister" class="goRegister" draggable="false">没有账号,现在注册一个</a>
                        </form-item>

                        <form-item>
                            <div style="text-align: center">
                                <span class="form_tipinfo">其他登录方式</span>
                            </div>
                            <div style="text-align: center">
                                <div class="sign-btn" @click="qqHandleClick('qq')">
                                    <img src="/assets/img/QQ.svg" class="qq-svg-container" draggable="false">
                                </div>
                                <div class="sign-btn" @click="wechatHandleClick('wechat')">
                                    <img src="/assets/img/weixin.svg" class="wx-svg-container" draggable="false">
                                </div>
                                <div class="sign-btn" @click="dingtalkHandleClick('dingtalk')">
                                    <img src="/assets/img/dingding.svg" class="dd-svg-container" draggable="false">
                                </div>
                            </div>
                        </form-item>

                    </i-form>
                </div>
            </card>
            <div class="log_footer">
                <div class="copyright">
                    <a href="https://www.ibizlab.cn/" target="_blank" draggable="false">{{appTitle}} is based on ibizlab
                        .</a>
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
    export default class Login extends Vue {

        /**
         * 表单对象
         *
         * @type {*}
         * @memberof Login
         */
        public form: any = {loginname: 'ibzadmin', password: '123456'};


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
            if (this.getCookie("loginname") && this.getCookie("loginname") !== 'undefined') {
                this.form.loginname = this.getCookie("loginname");
            }else {
                if (localStorage.getItem("user")) {
                    const user:any = localStorage.getItem("user");
                    if (user) {
                        const userObj:any = JSON.parse(user);
                        this.form.loginname = userObj.loginname;
                    }
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
                        this.setCookie('ibzuaa-token', data.token, 0);
                    }
                    if (data && data.user) {
                        localStorage.setItem('user', JSON.stringify(data.user));
                    }
                    // 设置cookie,保存账号密码7天
                    this.setCookie("loginname", loginname, 7);
                    // 跳转首页
                    const url: any = this.$route.query.redirect ? this.$route.query.redirect : '*';
                    this.$router.push({path: url});
                }
            }).catch((error: any) => {
                // 登录提示
                const data = error.data;
                if (data && data.detail) {
                    this.$Message.error({
                        content: "登录失败，" + data.detail,
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
         *
         * @memberof Login
         */
        public goReset(): void {
            const _this = this;
            _this.form={loginname: 'ibzadmin', password: '123456'}
        }

        /**
         * 跳转注册页面
         */
        public goRegister(): void {
            const _this = this;
            _this.$router.push('/register');
        }

        /**
         * 设置cookie
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

        /**
         * 获取cookie
         */
        public getCookie(name: any): any {
            var arr;
            var reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
            if (arr = document.cookie.match(reg))
                return unescape(arr[2]);
            else
                return null;
        }

        /**
         * qq授权登录
         * @param thirdpart
         */
        public qqHandleClick(thirdpart: any) {
            // 截取地址，拼接需要部分组成新地址
            const baseUrl = this.getNeedLocation();

            // 从后台获取qq互联创建的网站应用appid
            const get: Promise<any> = this.$http.get('/uaa/open/qq/appid');
            get.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data.appid) {
                        // 1.qq互联创建的网站应用appid
                        const client_id = data.appid;
                        // 2.回调地址,即授权登录成功后跳转的地址,需要UrlEncode转码
                        const redirect_uri = baseUrl + 'assets/qqRedirect.html';
                        const redirect_uri_encode = decodeURIComponent(redirect_uri);
                        // 3.随机生成一段字符串，防止CSRF攻击的
                        const state = Math.random().toString(36).substr(2);
                        // 4.qq授权登录地址
                        const url = 'https://graph.qq.com/oauth2.0/authorize?response_type=code'
                            + '&client_id=' + client_id
                            + '&redirect_uri=' + redirect_uri_encode
                            + "&scope=get_user_info"
                            + "&state=" + state;
                        // 5.跳转qq授权
                        window.location.href = url;
                    }else {
                        this.$Message.error({
                            content: "获取网站应用appid失败，" + data.detail,
                            duration: 5,
                            closable: true
                        });
                    }
                }
            }).catch((error: any) => {
                const data = error.data;
                if (data && data.detail) {
                    this.$Message.error({
                        content: "获取网站应用appid失败，" + data.detail,
                        duration: 5,
                        closable: true
                    });
                } else {
                    this.$Message.error({
                        content: "获取网站应用appid失败",
                        duration: 5,
                        closable: true
                    });
                }
            });
        }



        /**
         * 微信授权登录
         * @param thirdpart
         */
        public wechatHandleClick(thirdpart: any) {
            // 从后台获取微信开放平台提供的appid
            const get: Promise<any> = this.$http.get('/uaa/open/wechat/appid');
            get.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data.appid) {
                        // 截取地址，拼接需要部分组成新地址
                        const baseUrl = this.getNeedLocation();

                        // 1.微信开放平台提供的appId
                        const appId = data.appid;
                        // 2.微信扫码后回调地址,需要UrlEncode转码
                        const redirect_uri = baseUrl + 'assets/weixinRedirect.html';
                        const redirect_uri_encode = encodeURIComponent(redirect_uri);
                        // 3.微信扫码url
                        const url = 'https://open.weixin.qq.com/connect/qrconnect?response_type=code'
                            + '&appid=' + appId
                            + '&redirect_uri=' + redirect_uri_encode
                            + '&scope=snsapi_login'
                            + '&state=STATE';
                        // 4.跳转微信扫码
                        window.location.href = url;
                    }else {
                        this.$Message.error({
                            content: "获取网站应用appid失败，" + data.detail,
                            duration: 5,
                            closable: true
                        });
                    }
                }
            }).catch((error: any) => {
                const data = error.data;
                if (data && data.detail) {
                    this.$Message.error({
                        content: "获取网站应用appid失败，" + data.detail,
                        duration: 5,
                        closable: true
                    });
                } else {
                    this.$Message.error({
                        content: "获取网站应用appid失败",
                        duration: 5,
                        closable: true
                    });
                }
            });

        }


        /**
         * 钉钉授权登录
         * @param thirdpart
         */
        public dingtalkHandleClick(thirdpart: any) {
            // 从后台获取钉钉开放平台提供的appid
            const get: Promise<any> = this.$http.get('/uaa/open/dingtalk/appid');
            get.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data.appid) {
                        // 截取地址，拼接需要部分组成新地址
                        const baseUrl = this.getNeedLocation();

                        // 1.钉钉开放平台提供的appId
                        const appId = data.appid;
                        // 2.钉钉扫码后回调地址,需要UrlEncode转码
                        const redirect_uri = baseUrl + 'assets/dingdingRedirect.html';
                        const redirect_uri_encode = encodeURIComponent(redirect_uri);
                        // 3.钉钉扫码url
                        const url = 'https://oapi.dingtalk.com/connect/qrconnect?response_type=code'
                            + '&appid=' + appId
                            + '&redirect_uri=' + redirect_uri_encode
                            + '&scope=snsapi_login'
                            + '&state=STATE';

                        // 4.跳转钉钉扫码
                        window.location.href = url;
                    }else {
                        this.$Message.error({
                            content: "获取网站应用appid失败，" + data.detail,
                            duration: 5,
                            closable: true
                        });
                    }
                }
            }).catch((error: any) => {
                const data = error.data;
                if (data && data.detail) {
                    this.$Message.error({
                        content: "获取网站应用appid失败，" + data.detail,
                        duration: 5,
                        closable: true
                    });
                } else {
                    this.$Message.error({
                        content: "获取网站应用appid失败",
                        duration: 5,
                        closable: true
                    });
                }
            });

        }


        /**
         * 获取需要的location部分
         */
        public getNeedLocation() {
            // 截取地址，拼接需要部分组成新地址
            const scheme = window.location.protocol;
            const host = window.location.host;
            let baseUrl: any;
            baseUrl = scheme + "//" + host;
            const port = window.location.port;
            if (port) {
                if (port == '80' || port == '443') {
                    baseUrl += "/";
                } else {
                    baseUrl += ":" + port + "/";
                }
            } else {
                baseUrl += "/";
            }
            // console.log(baseUrl);

            return baseUrl;
        }


    }
</script>

<style lang='less'>
    @import './login.less';
</style>