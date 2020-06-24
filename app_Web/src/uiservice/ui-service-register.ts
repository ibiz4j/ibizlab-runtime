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
                this.allUIService.set('jobslog', () => import('@/uiservice/jobs-log/jobs-log-ui-service'));
        this.allUIService.set('sysrolepermission', () => import('@/uiservice/sys-role-permission/sys-role-permission-ui-service'));
        this.allUIService.set('ibzpost', () => import('@/uiservice/ibzpost/ibzpost-ui-service'));
        this.allUIService.set('sysuser', () => import('@/uiservice/sys-user/sys-user-ui-service'));
        this.allUIService.set('sysauthlog', () => import('@/uiservice/sys-auth-log/sys-auth-log-ui-service'));
        this.allUIService.set('wfmember', () => import('@/uiservice/wfmember/wfmember-ui-service'));
        this.allUIService.set('wfuser', () => import('@/uiservice/wfuser/wfuser-ui-service'));
        this.allUIService.set('ibzorganization', () => import('@/uiservice/ibzorganization/ibzorganization-ui-service'));
        this.allUIService.set('jobsregistry', () => import('@/uiservice/jobs-registry/jobs-registry-ui-service'));
        this.allUIService.set('dictcatalog', () => import('@/uiservice/dict-catalog/dict-catalog-ui-service'));
        this.allUIService.set('wfgroup', () => import('@/uiservice/wfgroup/wfgroup-ui-service'));
        this.allUIService.set('ibzteam', () => import('@/uiservice/ibzteam/ibzteam-ui-service'));
        this.allUIService.set('jobsinfo', () => import('@/uiservice/jobs-info/jobs-info-ui-service'));
        this.allUIService.set('wfremodel', () => import('@/uiservice/wfremodel/wfremodel-ui-service'));
        this.allUIService.set('sysuserrole', () => import('@/uiservice/sys-user-role/sys-user-role-ui-service'));
        this.allUIService.set('wfprocessdefinition', () => import('@/uiservice/wfprocess-definition/wfprocess-definition-ui-service'));
        this.allUIService.set('sysrole', () => import('@/uiservice/sys-role/sys-role-ui-service'));
        this.allUIService.set('ibzdeptmember', () => import('@/uiservice/ibzdept-member/ibzdept-member-ui-service'));
        this.allUIService.set('ibzdepartment', () => import('@/uiservice/ibzdepartment/ibzdepartment-ui-service'));
        this.allUIService.set('ibzteammember', () => import('@/uiservice/ibzteam-member/ibzteam-member-ui-service'));
        this.allUIService.set('syspermission', () => import('@/uiservice/sys-permission/sys-permission-ui-service'));
        this.allUIService.set('dictoption', () => import('@/uiservice/dict-option/dict-option-ui-service'));
        this.allUIService.set('ibzemployee', () => import('@/uiservice/ibzemployee/ibzemployee-ui-service'));
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