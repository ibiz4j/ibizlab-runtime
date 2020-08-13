<template>
  <div class="lock-container">
    <div class="lock-form animated bounceInDown">
      <div class="animated">
        <h3 class="title">{{username}}</h3>
        <el-input :placeholder="this.$t('components.lockScren.placeholder1')"
                  type="password"
                  class="input-with-select animated"
                  v-model="passwd">
          <el-button slot="append"
                     icon="el-icon-unlock"
                     size="25px"
                     @click="handleLogin"></el-button>
          <el-button slot="append"
                     icon="el-icon-switch-button"
                     size="25px"
                     @click="handleLogout"></el-button>
        </el-input>
      </div>
    </div>
  </div>
</template>

<script lang = 'ts'>
import { Vue, Component, Prop, Model, Watch } from 'vue-property-decorator';

@Component({})
export default class AppLockIndex extends Vue{

    /**
     * 输入密码
     */
    public passwd: string = '';

    /**
     * 保存的密码
     */
    public lockpasswd: string = '';

    /**
     * 用户名
     */
    public username: string = '';

    /**
     * 锁屏前的页面路由
     */
    public path: string = '';

    /**
     * 获取锁屏相关信息
     *
     * @memberof AppLockIndex
     */
    public mounted() {
      this.username = (sessionStorage.getItem('userName') as string);
      this.lockpasswd = window.atob(sessionStorage.getItem('lockPassword') as string);
      this.path = window.atob(sessionStorage.getItem('routerPath') as string);
    }

    /**
     * 解除锁屏
     * 
     * @memberof AppLockIndex
     */
    public handleLogin(){
        if(this.lockpasswd != this.passwd){
            this.passwd = '';
            this.$message({
                message: (this.$t('components.lockScren.message1') as string),
                type: "error"
            });
            return;
        }
        this.clearSession();
        this.$router.push({ path: this.path});
    }

    /**
     * 登出
     * 
     * @memberof AppLockIndex
     */
    public handleLogout(){
        this.$confirm((this.$t('components.lockScren.promptInformation') as string), (this.$t('components.lockScren.prompt') as string), {
            confirmButtonText: (this.$t('components.lockScren.confirmButtonText') as string),
            cancelButtonText: (this.$t('components.lockScren.cancelButtonText') as string),
            type: "warning"
        }).then(() => {
            this.clearSession();
            const get: Promise<any> = this.$http.get('/v7/logout');
            get.then((response:any) =>{
                if (response && response.status === 200) {
                    localStorage.removeItem('user');
                    localStorage.removeItem('token');
                    let leftTime = new Date();
                    leftTime.setTime(leftTime.getSeconds() - 1);
                    document.cookie = "ibzuaa-token=;expires=" + leftTime.toUTCString();
                    this.$router.push({ name: 'login' });
                }
            }).catch((error: any) =>{
                console.error(error);
            })
        });  
    }

    /**
     * 清除锁屏时生成的session
     */
    public clearSession(){
      sessionStorage.removeItem('lockPassword');
      sessionStorage.removeItem('lockState');
      sessionStorage.removeItem('userName');
      sessionStorage.removeItem('routerPath');
    }
}

</script>
<style lang='less'>
@import './app-lock.less';
</style>