import { Store } from 'vuex';
import AuthService from '@/authservice/auth-service';

/**
 * 界面服务基类
 *
 * @export
 * @class UIService
 */
export default class UIService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {(any | null)}
     * @memberof UIService
     */
    private $store: Store<any> | null = null;

    /**
     * 所依赖权限服务
     *
     * @memberof UIService
     */
    public authService:any;

    /**
     * Creates an instance of UIService.
     * 
     * @param {*} [opts={}]
     * @memberof UIService
     */
    constructor(opts: any = {}) {
        this.$store = opts.$store;
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof UIService
     */
    public getStore(): Store<any> | null {
        return this.$store;
    }

    /**
     * 获取UI实体服务
     *
     * @protected
     * @param {string} name 实体名称
     * @returns {Promise<any>}
     * @memberof UIService
     */
    public getService(name: string): Promise<any> {
        return (window as any)['uiServiceRegister'].getService(name);
    }

    /**
    * 获取资源标识是否有权限(无数据目标)
    * 
    * @param tag 资源标识
    * @memberof  UIService
    */
   public getResourceOPPrivs(tag:any){
        if(!this.authService) {
            this.authService = new AuthService(this.getStore());
        }
        return this.authService.getResourcePermission(this.authService.sysOPPrivsMap.get(tag))?1:0;
   }


   
}