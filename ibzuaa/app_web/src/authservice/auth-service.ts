import store from '@/store';
/**
 * 实体权限服务
 *
 * @export
 * @class AuthService
 */
export default class AuthService {

    /**
     * Vue 状态管理器
     *
     * @public
     * @type {(any | null)}
     * @memberof AuthService
     */
    public $store: any;

    /**
     * 系统操作标识映射统一资源Map
     *
     * @public
     * @type {Map<string,any>}
     * @memberof AuthService
     */
    public sysOPPrivsMap:Map<string,any> = new  Map();

    /**
     * 默认操作标识
     *
     * @public
     * @type {(any)}
     * @memberof AuthService
     */
    public defaultOPPrivs: any = {CREATE: 1,DELETE: 1,DENY: 1,NONE: 1,READ: 1,TEST1: 1,UPDATE: 1,WFSTART: 1}; 

    /**
     * Creates an instance of AuthService.
     * 
     * @param {*} [opts={}]
     * @memberof AuthService
     */
    constructor(opts: any = {}) {
        this.$store = store;
        this.registerSysOPPrivs();
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof AuthService
     */
    public getStore(): any {
        return this.$store;
    }

    /**
     * 获取计算统一资源之后的系统操作标识
     *
     * @returns {}
     * @memberof AuthService
     */
    public getSysOPPrivs(){
        let copySysOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(Object.keys(copySysOPPrivs).length === 0) return {};
        Object.keys(copySysOPPrivs).forEach((name:any) =>{
            if(this.sysOPPrivsMap.get(name)){
                copySysOPPrivs[name] = this.getResourcePermission(this.sysOPPrivsMap.get(name))?1:0;
            }
        })
        return copySysOPPrivs;
    }

    /**
     * 获取实体权限服务
     *
     * @param {string} name 实体名称
     * @returns {Promise<any>}
     * @memberof AuthService
     */
    public getService(name: string): Promise<any> {
        return (window as any)['authServiceRegister'].getService(name);
    }

    /**
     * 注册系统操作标识统一资源
     *
     * @param {string} name 实体名称
     * @returns {Promise<any>}
     * @memberof AuthService
     */ 
    public registerSysOPPrivs(){
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {string} name 实体名称
     * @returns {any}
     * @memberof AuthService
     */
    public getOPPrivs(data: any): any {
        return null;
    }

    /**
     * 根据菜单项获取菜单权限
     *
     * @param {*} item 菜单标识
     * @returns {boolean}
     * @memberof AuthService
     */
    public getMenusPermission(item: any): boolean {
        if(!this.$store.getters['authresource/getEnablePermissionValid']) {
            return true;
        }
        return this.$store.getters['authresource/getAuthMenu'](item);
    }

    /**
     * 根据统一资源标识获取统一资源权限
     *
     * @param {*} tag 统一资源标识
     * @returns {boolean}
     * @memberof AuthService
     */
    public getResourcePermission(tag: any): boolean {
        if(!this.$store.getters['authresource/getEnablePermissionValid']) {
            return true;
        }
        return this.$store.getters['authresource/getResourceData'](tag);
    }

}