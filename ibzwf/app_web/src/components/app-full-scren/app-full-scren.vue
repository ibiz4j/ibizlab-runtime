<template>
    <div class="fullscren">
        <Icon :type="fullScren == true ? 'ios-contract' : 'ios-expand'" color="#aaa" size="22" @click="handleScreen"/>
    </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Model, Watch } from 'vue-property-decorator';

@Component({})
export default class AppFullScren extends Vue{

    public fullScren: boolean = false;

    public handleScreen(){
        if(this.fullscreenEnable()){
            this.exitFullScreen();
        }else{
            this.reqFullScreen();
        }
    }

    /**
     * 监控全屏状态和键盘
     */
    public created(){
        let _this = this;
        window.onresize = function(){
            if(_this.fullscreenEnable()){
                _this.fullScren = true;
            }else{
                _this.fullScren = false;
            }
        };
        window.addEventListener("keydown", this.keyDown, true);
    }

    /**
     * 监控F11
     */
    public keyDown($event: any){
        if ($event.keyCode == 122) {
            $event.returnValue = false;
            this.fullScren = !this.fullScren;
            this.handleScreen();
        }
    }

    /**
     * 浏览器判断是否全屏
     */
    public fullscreenEnable(){
        const isFullscreen = (document as any).isFullScreen || (document as any).mozIsFullScreen || (document as any).webkitIsFullScreen;
        return isFullscreen;
    }

    /**
     * 浏览器全屏
     */
    public reqFullScreen(){
        if ((document as any).documentElement.requestFullScreen) {
            (document as any).documentElement.requestFullScreen();
        } else if ((document as any).documentElement.webkitRequestFullScreen) {
            (document as any).documentElement.webkitRequestFullScreen();
        } else if ((document as any).documentElement.mozRequestFullScreen) {
            (document as any).documentElement.mozRequestFullScreen();
        }
    };

    /**
     * 浏览器退出全屏
     */
    public exitFullScreen(){
        if ((document as any).documentElement.requestFullScreen) {
            (document as any).exitFullScreen();
        } else if ((document as any).documentElement.webkitRequestFullScreen) {
            (document as any).webkitCancelFullScreen();
        } else if ((document as any).documentElement.mozRequestFullScreen) {
            (document as any).mozCancelFullScreen();
        }
    }

}

</script>
<style lang='less'>
.fullscren{
    cursor:pointer;
    padding: 0 5px;
}
.ivu-icon-ios-expand{
    font-weight: bolder;
}
.ivu-icon-ios-contract{
    font-weight: bolder;
}
</style>