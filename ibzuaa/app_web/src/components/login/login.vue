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
                                    @click="goRegister"
                                    type='success'
                                    class="login_register">注册
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
            this.getCookie("loginname");
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
         * 跳转注册页面
         */
        public goRegister(): void {
            const _this = this;
            _this.$router.push('/register');
        }


        public setCookie(name: any, value: any, day: any) {
            if (day !== 0) { //当设置的时间等于0时，不设置expires属性，cookie在浏览器关闭后删除
                var curDate = new Date();
                var curTamp = curDate.getTime();
                var curWeeHours = new Date(curDate.toLocaleDateString()).getTime() - 1;
                var passedTamp = curTamp - curWeeHours;
                var leftTamp = 24 * 60 * 60 * 1000 - passedTamp;
                var leftTime = new Date();
                leftTime.setTime(leftTamp + curTamp);
                document.cookie = name + "=" + escape(value) + ";expires=" + leftTime.toUTCString();
            } else {
                document.cookie = name + "=" + escape(value);
            }
        }

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
        public tencentHandleClick(thirdpart: any) {
            // window.QC.Login.showPopup({
            //     appId:"101884990",
            //     redirectURI:"http%3a%2f%2f127.0.0.1%3a8080%2f%23%2flogin"  //登录成功后会自动跳往该地址
            // });
            var _this = this;
            // //　网站应用appid
            const client_id = '101885024';
            //　回调地址,即授权登录成功后跳转的地址(需要UrlEncode转码)
            const redirect_uri = 'http%3a%2f%2f127.0.0.1%3a8080%2f%23%2flogin';
            // 随机生成一段字符串，防止CSRF攻击的
            const state =  Math.random().toString(36).substr(2);
            // this.$store.dispatch(state);
            // // qq授权登录地址
            const url = 'https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=' + client_id + '&redirect_uri=' + redirect_uri + "&scope=get_user_info" + "&state=" + state;
            // // 打开qq授权登录窗口，授权登录成功后会重定向到回调地址
            this.openWindow(url, thirdpart, 540, 540);
        }

        /**
         * 微信授权登录
         * @param thirddpart
         */
        public wechatHandleClick(thirddpart: any) {
            this.$Message.warning("微信授权登录暂未支持");
        }

        /**
         * 打开一个新窗口
         * @param url　链接地址
         * @param title　窗口标题
         * @param w　窗口宽度
         * @param h　窗口高度
         */
        public openWindow(url: any, title: any, w: any, h: any): void {
            const dualScreenLeft = window.screenLeft;
            const dualScreenTop = window.screenTop;
            const width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
            const height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;
            const left = ((width / 2) - (w / 2)) + dualScreenLeft;
            const top = ((height / 2) - (h / 2)) + dualScreenTop;
            const newWindow = window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, copyhistory=no, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);
            if (window.focus && newWindow) {
                newWindow.focus();
            }
        }


    }
</script>

<style lang='less'>
    @import './login.less';
</style>