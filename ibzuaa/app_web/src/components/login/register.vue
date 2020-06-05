<template>
    <div class='login'>
        <img src="/assets/img/background.png"/>

        <div class='login-con'>
            <card :bordered="false">
                <p slot='title'>
                    <a @click="goLogin" class="goLogin">返回登录</a>
                </p>
                <div class='form-con'>
                    <i-form ref='loginForm' :rules="rules" :model="form">
                        <form-item prop='loginname'>
                            <i-input
                                    prefix='ios-contact'
                                    v-model.trim="form.loginname"
                                    @keyup="toTrim"
                                    placeholder="用户名">
                            </i-input>
                        </form-item>
                        <form-item prop='personname'>
                            <i-input
                                    prefix='ios-person'
                                    v-model.trim="form.personname"
                                    placeholder="用户姓名">
                            </i-input>
                        </form-item>
                        <form-item prop='password'>
                            <i-input
                                    prefix='ios-key'
                                    v-model.trim="form.password"
                                    type='password'
                                    placeholder="密码">
                            </i-input>
                        </form-item>
                        <form-item prop='confrimpassword'>
                            <i-input
                                    prefix='ios-checkbox'
                                    v-model.trim="form.confrimpassword"
                                    type='password'
                                    placeholder="确认密码">
                            </i-input>
                        </form-item>
                        <form-item>
                            <i-button
                                    @click="handleRegister"
                                    type='success'
                                    :class="{disabled: !this.canClick}"
                                    long>{{this.confirmRegBtnContent}}
                            </i-button>
                        </form-item>
                    </i-form>

                </div>
            </card>
            <div class="log_footer">
                <div class="copyright">Copyright © 2018
                    <a href="http://www.ibizsys.net/ibizsys/channelview?channelId=ibizsys.about" target="_blank">埃毕致（上海）云计算科技</a>
                    版权所有
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
                            if (value === '' && this.form.password !== '') {
                                callback(new Error('确认密码不能为空'))
                            } else if (value !== this.form.password) {
                                callback(new Error('两次输入密码不一致'))
                            } else {
                                callback()
                            }
                        },
                        trigger: 'change'
                    }
                ],
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
         * 去掉输入框中的空格
         *
         * @memberof Login
         */
        public toTrim(): void {
            let _this = this;
            _this.form.loginname = _this.form.loginname.replace(/\s+/g, " ");
        }


        /**
         * 注册处理
         */
        public handleRegister(): void {
            const form: any = this.$refs.loginForm;
            let validatestate: boolean = true;
            form.validate((valid: boolean) => {
                validatestate = valid ? true : false;
            });
            if (!validatestate) {
                return;
            }
            this.form.registerType = "commom";
            const post: Promise<any> = this.$http.post('/uaa/register', this.form, true);
            post.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data.ibzuser) {
                        this.$Message.success({
                            content: "注册成功，用户名:" + data.ibzuser.loginname + "，密码:" + data.ibzuser.password,
                            duration: 5,
                            closable: true
                        });
                    } else {
                        this.$Message.success({
                            content: "注册成功",
                            duration: 5,
                            closable: true
                        });
                    }
                    // 5s后跳转到登录页
                    this.countDown(5);
                }
            }).catch((e: any) => {
                const data = e.data;
                if (data && data.message) {
                    this.$Message.error({
                        content: "注册失败，" + data.message,
                        duration: 5,
                        closable: true
                    });
                } else {
                    this.$Message.error({
                        content: "注册失败",
                        duration: 5,
                        closable: true
                    });
                }
            });
        }

        /**
         * 跳转登录页倒计时
         */
        public countDown(totalTime: any): void {
            if (!this.canClick) return;
            this.canClick = false;
            this.confirmRegBtnContent = totalTime + 's后跳转到登录页';
            // 设置定时器
            let clock = window.setInterval(() => {
                // 秒数-1
                totalTime--;
                this.confirmRegBtnContent = totalTime + 's后跳转到登录页';
                if (totalTime < 0) {
                    // 清除定时器
                    window.clearInterval(clock);
                    // 跳转到登录页
                    this.$router.push("/login");
                }
            }, 1000)
        }


    }
</script>

<style lang='less'>
    @import './register.less';
</style>