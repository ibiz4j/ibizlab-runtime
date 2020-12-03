import { Http } from '@/utils';
import { Subscription } from 'rxjs';

/**
 * 按钮loadding状态服务
 *
 * @export
 * @class LoaddingService
 */
export class LoaddingService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {LoaddingService}
     * @memberof LoaddingService
     */
    private static loaddingService: LoaddingService;

    /**
     * loadding状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof LoaddingService
     */
    public loaddingStateEvent: Subscription | undefined;

    /**
     * 获取 LoaddingService 单例对象
     *
     * @static
     * @returns {LoaddingService}
     * @memberof LoaddingService
     */
    public static getInstance(): LoaddingService {
        if (!LoaddingService.loaddingService) {
            LoaddingService.loaddingService = new LoaddingService();
        }
        return this.loaddingService;
    }

    /**
     * 初始化指令所绑定的元素状态
     *
     * @param {any} el 指令所绑定的元素
     * @param {any} binding 指令附加参数
     * @memberof  LoaddingService
     */
    public initElement(el:any, binding:any){
        if(binding && binding.arg){
            // 工具栏按钮
            if(Object.is(binding.arg,'i-button')){
                if(el.getElementsByTagName('i') && el.getElementsByTagName('i').length >0){
                    let iconElement:any = el.getElementsByTagName('i')[0];
                    iconElement.setAttribute('ownclassname',iconElement.className);
                } 
            }
        }
    }

    /**
     * 设置loadding状态
     *
     * @param {any} el 指令所绑定的元素
     * @param {any} binding 指令附加参数
     * @memberof  LoaddingService
     */
    public setLoadState(el:any, binding:any){
        this.loaddingStateEvent = Http.getInstance().getNotifyObject().subscribe((result:any) =>{
            if(result && result.action && Object.is(result.action,'setloadstate')){
                if(result && result.state){
                    this.addLoadState(el,binding);
                }else{
                    this.removeLoadState(el,binding);
                }
            }
        })
        
    }

    /**
     * 添加loadding状态
     *
     * @param {any} el 指令所绑定的元素
     * @param {any} binding 指令附加参数
     * @memberof  LoaddingService
     */
    public addLoadState(el:any, binding:any){
        if(binding && binding.arg){
            el.style.pointerEvents = 'none';
            // 工具栏按钮
            if(Object.is(binding.arg,'i-button')){
                if(el.getElementsByTagName('i') && el.getElementsByTagName('i').length >0){
                    let iconElement:any = el.getElementsByTagName('i')[0];
                    iconElement.className = "el-icon-loading";
                }
            }
        }
    }

    /**
     * 移除loadding状态
     *
     * @param {any} el 指令所绑定的元素
     * @param {any} binding 指令附加参数
     * @memberof  LoaddingService
     */
    public removeLoadState(el:any, binding:any){
        if(binding && binding.arg){
            el.style.pointerEvents = '';
            // 工具栏按钮
            if(Object.is(binding.arg,'i-button')){
                if(el.getElementsByTagName('i') && el.getElementsByTagName('i').length >0){
                    let iconElement:any = el.getElementsByTagName('i')[0];
                    iconElement.className = iconElement.getAttribute('ownclassname');
                }
            }
        }
    }

    /**
     * 清除资源（取消订阅）
     *
     * @param {any} el 指令所绑定的元素
     * @param {any} binding 指令附加参数
     * @memberof  LoaddingService
     */
    public clearResource(el:any, binding:any){
        if(this.loaddingStateEvent){
            this.loaddingStateEvent.unsubscribe();
        }
    }
   

}
export  default {
    bind(el:any, binding:any) {
        LoaddingService.getInstance().initElement(el, binding);
    },
    inserted(el:any, binding:any) {
        LoaddingService.getInstance().setLoadState(el, binding);
    },
    unbind(el:any, binding:any) {
        LoaddingService.getInstance().clearResource(el,binding);
    }
}