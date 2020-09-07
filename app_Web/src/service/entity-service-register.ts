/**
 * 实体数据服务注册中心
 *
 * @export
 * @class EntityServiceRegister
 */
export class EntityServiceRegister {

    /**
     * 所有实体数据服务Map
     *
     * @protected
     * @type {*}
     * @memberof EntityServiceRegister
     */
    protected allEntityService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载实体数据服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof EntityServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of EntityServiceRegister.
     * @memberof EntityServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof EntityServiceRegister
     */
    protected init(): void {
                this.allEntityService.set('jobslog', () => import('@/service/jobs-log/jobs-log-service'));
        this.allEntityService.set('sysrolepermission', () => import('@/service/sys-role-permission/sys-role-permission-service'));
        this.allEntityService.set('sysuser', () => import('@/service/sys-user/sys-user-service'));
        this.allEntityService.set('sysauthlog', () => import('@/service/sys-auth-log/sys-auth-log-service'));
        this.allEntityService.set('wfmember', () => import('@/service/wfmember/wfmember-service'));
        this.allEntityService.set('syspost', () => import('@/service/sys-post/sys-post-service'));
        this.allEntityService.set('sysdepartment', () => import('@/service/sys-department/sys-department-service'));
        this.allEntityService.set('sysemployee', () => import('@/service/sys-employee/sys-employee-service'));
        this.allEntityService.set('systeam', () => import('@/service/sys-team/sys-team-service'));
        this.allEntityService.set('wfuser', () => import('@/service/wfuser/wfuser-service'));
        this.allEntityService.set('sysorganization', () => import('@/service/sys-organization/sys-organization-service'));
        this.allEntityService.set('jobsregistry', () => import('@/service/jobs-registry/jobs-registry-service'));
        this.allEntityService.set('dictcatalog', () => import('@/service/dict-catalog/dict-catalog-service'));
        this.allEntityService.set('wfgroup', () => import('@/service/wfgroup/wfgroup-service'));
        this.allEntityService.set('jobsinfo', () => import('@/service/jobs-info/jobs-info-service'));
        this.allEntityService.set('wfremodel', () => import('@/service/wfremodel/wfremodel-service'));
        this.allEntityService.set('sysuserrole', () => import('@/service/sys-user-role/sys-user-role-service'));
        this.allEntityService.set('wfprocessdefinition', () => import('@/service/wfprocess-definition/wfprocess-definition-service'));
        this.allEntityService.set('sysrole', () => import('@/service/sys-role/sys-role-service'));
        this.allEntityService.set('syspermission', () => import('@/service/sys-permission/sys-permission-service'));
        this.allEntityService.set('systeammember', () => import('@/service/sys-team-member/sys-team-member-service'));
        this.allEntityService.set('sysdeptmember', () => import('@/service/sys-dept-member/sys-dept-member-service'));
        this.allEntityService.set('dictoption', () => import('@/service/dict-option/dict-option-service'));
        this.allEntityService.set('sysapp', () => import('@/service/sys-app/sys-app-service'));
    }

    /**
     * 加载实体数据服务
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof EntityServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allEntityService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体数据服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof EntityServiceRegister
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
export const entityServiceRegister: EntityServiceRegister = new EntityServiceRegister();