import { Store } from 'vuex';

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
    public $store: Store<any> | null = null;

    /**
     * 默认操作符
     *
     * @public
     * @type {(any)}
     * @memberof AuthService
     */
    public defaultOPPrivs: any = { UPDATE: 1, CREATE: 1, READ: 1, DELETE: 1 };

    /**
     * Creates an instance of AuthService.
     * 
     * @param {*} [opts={}]
     * @memberof AuthService
     */
    constructor(opts: any = {}) {
        this.$store = opts.$store;
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof AuthService
     */
    public getStore(): Store<any> | null {
        return this.$store;
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
        return true;
    }

    /**
     * 根据统一资源标识获取统一资源权限
     *
     * @param {*} tag 统一资源标识
     * @returns {boolean}
     * @memberof AuthService
     */
    public getResourcePermission(tag: any): boolean {
        return true;
    }

}