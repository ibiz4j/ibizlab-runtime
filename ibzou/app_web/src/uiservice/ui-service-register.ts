/**
 * UI服务注册中心
 *
 * @export
 * @class UIServiceRegister
 */
export class UIServiceRegister {

    /**
     * 所有UI实体服务Map
     *
     * @protected
     * @type {*}
     * @memberof UIServiceRegister
     */
    protected allUIService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载UI实体服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof UIServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of UIServiceRegister.
     * @memberof UIServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UIServiceRegister
     */
    protected init(): void {
                this.allUIService.set('syspost', () => import('@/uiservice/sys-post/sys-post-ui-service'));
        this.allUIService.set('sysdepartment', () => import('@/uiservice/sys-department/sys-department-ui-service'));
        this.allUIService.set('sysemployee', () => import('@/uiservice/sys-employee/sys-employee-ui-service'));
        this.allUIService.set('systeam', () => import('@/uiservice/sys-team/sys-team-ui-service'));
        this.allUIService.set('sysorganization', () => import('@/uiservice/sys-organization/sys-organization-ui-service'));
        this.allUIService.set('systeammember', () => import('@/uiservice/sys-team-member/sys-team-member-ui-service'));
        this.allUIService.set('sysdeptmember', () => import('@/uiservice/sys-dept-member/sys-dept-member-ui-service'));
    }

    /**
     * 加载服务实体
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof UIServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allUIService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof UIServiceRegister
     */
    public async getService(name: string): Promise<any> {
        if (this.serviceCache.has(name)) {
            return this.serviceCache.get(name);
        }
        const entityService: any = await this.loadService(name);
        if (entityService && entityService.default) {
            const instance: any = new entityService.default();
            this.serviceCache.set(name, instance);
            return instance;
        }
    }

}
export const uiServiceRegister: UIServiceRegister = new UIServiceRegister();