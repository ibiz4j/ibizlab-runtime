<template>
    <div class='login'>
        <img src="/assets/img/background.png" draggable="false"/>

        <div class='login-con'>
            <card :bordered="false">

                <div class='form-con'>
                    <i-form ref='loginForm' :rules="rules" :model="form">
                        <form-item>
                            <a @click="goLogin" class="goLogin" draggable="false">返回登录</a>
                        </form-item>
                        <form-item prop='loginname'>
                            <i-input
                                    size='large'
                                    prefix='ios-contact'
                                    v-model.trim="form.loginname"
                                    placeholder="用户名"
                                    @keyup.enter.native="handleRegister">
                            </i-input>
                        </form-item>
                        <form-item prop='personname'>
                            <i-input
                                    size='large'
                                    prefix='ios-person'
                                    v-model.trim="form.personname"
                                    placeholder="用户姓名"
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
                        <form-item prop='confrimpassword'>
                            <i-input
                                    size='large'
                                    prefix='ios-checkbox'
                                    v-model.trim="form.confrimpassword"
                                    type='password'
                                    placeholder="确认密码"
                                    @keyup.enter.native="handleRegister">
                            </i-input>
                        </form-item>
                        <form-item>
                            <i-button
                                    @click="handleRegister"
                                    type='success'
                                    class="confirm_register"
                                    :class="{disabled: !this.canClick}"
                                    long>{{this.confirmRegBtnContent}}
                            </i-button>
                        </form-item>
                    </i-form>

                </div>
            </card>
            <div class="log_footer">
                <div class="copyright">
                    <a href="https://www.ibizlab.cn/" target="_blank" draggable="false">{{appTitle}} is based on ibizlab .</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component, Watch} from 'vue-property-decorator';
    import {Environment} from '@/environments/environment';

    @Component({})
    export default class Register extends Vue {

        /**
         * 表单对象
         *
         * @type {*}
         * @memberof Register
         */
        public form: any = {loginname: '', personname: '', password: '', confrimpassword: ''};

        /**
         *　按钮可点击
         */
        public canClick: any = true;

        /**
         * 确定注册按钮内容
         */
        public confirmRegBtnContent: any = "确定注册";


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
                personname: [
                    {required: true, message: '用户姓名不能为空', trigger: 'change'},
                ],
                password: [
                    {required: true, message: this.$t('components.login.password.message'), trigger: 'change'},
                ],
                confrimpassword: [
                    {
                        validator: (rule: any, value: any, callback: any) => {
                            if (value === '') {
                                callback(new Error('确认密码不能为空'));
                            } else if (value !== this.form.password) {
                                callback(new Error('两次输入密码不一致'));
                            } else {
                                callback();
                            }
                        },
                        trigger: 'change'
                    }
                ],
            }
        };

        // 注册方式
        public registerType: any = "commom";

        /**
         * 生命周期Create
         *
         * @memberof Register
         */
        public created() {
            this.setRules();
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
            param.registerType = this.registerType;
            const post: Promise<any> = this.$http.post('/uaa/register', param, true);
            post.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data.ibzuser) {
                        this.$Message.success({
                            content: "注册成功,正在登录"
                        });
                    }
                    // 自动登录
                    this.countDown();
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
         * 自动登录
         */
        public countDown(): void {
            // 注册时不允许再点击‘确定注册按钮’
            if (!this.canClick) return;
            this.canClick = false;
            this.confirmRegBtnContent = '登录中...';
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
                this.canClick = true;
                this.confirmRegBtnContent = '确定注册';
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
    @import './register.less';
</style>