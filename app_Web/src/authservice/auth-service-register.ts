/**
 * 实体权限服务注册中心
 *
 * @export
 * @class AuthServiceRegister
 */
export class AuthServiceRegister {

    /**
     * 所有实体权限服务Map
     *
     * @protected
     * @type {*}
     * @memberof AuthServiceRegister
     */
    protected allAuthService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载实体权限服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof AuthServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of AuthServiceRegister.
     * @memberof AuthServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AuthServiceRegister
     */
    protected init(): void {
                this.allAuthService.set('jobslog', () => import('@/authservice/jobs-log/jobs-log-auth-service'));
        this.allAuthService.set('sysrolepermission', () => import('@/authservice/sys-role-permission/sys-role-permission-auth-service'));
        this.allAuthService.set('sysuser', () => import('@/authservice/sys-user/sys-user-auth-service'));
        this.allAuthService.set('sysauthlog', () => import('@/authservice/sys-auth-log/sys-auth-log-auth-service'));
        this.allAuthService.set('wfmember', () => import('@/authservice/wfmember/wfmember-auth-service'));
        this.allAuthService.set('syspost', () => import('@/authservice/sys-post/sys-post-auth-service'));
        this.allAuthService.set('sysdepartment', () => import('@/authservice/sys-department/sys-department-auth-service'));
        this.allAuthService.set('sysemployee', () => import('@/authservice/sys-employee/sys-employee-auth-service'));
        this.allAuthService.set('systeam', () => import('@/authservice/sys-team/sys-team-auth-service'));
        this.allAuthService.set('wfuser', () => import('@/authservice/wfuser/wfuser-auth-service'));
        this.allAuthService.set('sysorganization', () => import('@/authservice/sys-organization/sys-organization-auth-service'));
        this.allAuthService.set('jobsregistry', () => import('@/authservice/jobs-registry/jobs-registry-auth-service'));
        this.allAuthService.set('dictcatalog', () => import('@/authservice/dict-catalog/dict-catalog-auth-service'));
        this.allAuthService.set('wfgroup', () => import('@/authservice/wfgroup/wfgroup-auth-service'));
        this.allAuthService.set('jobsinfo', () => import('@/authservice/jobs-info/jobs-info-auth-service'));
        this.allAuthService.set('wfremodel', () => import('@/authservice/wfremodel/wfremodel-auth-service'));
        this.allAuthService.set('sysuserrole', () => import('@/authservice/sys-user-role/sys-user-role-auth-service'));
        this.allAuthService.set('wfprocessdefinition', () => import('@/authservice/wfprocess-definition/wfprocess-definition-auth-service'));
        this.allAuthService.set('sysrole', () => import('@/authservice/sys-role/sys-role-auth-service'));
        this.allAuthService.set('syspermission', () => import('@/authservice/sys-permission/sys-permission-auth-service'));
        this.allAuthService.set('systeammember', () => import('@/authservice/sys-team-member/sys-team-member-auth-service'));
        this.allAuthService.set('sysdeptmember', () => import('@/authservice/sys-dept-member/sys-dept-member-auth-service'));
        this.allAuthService.set('dictoption', () => import('@/authservice/dict-option/dict-option-auth-service'));
        this.allAuthService.set('sysapp', () => import('@/authservice/sys-app/sys-app-auth-service'));
    }

    /**
     * 加载实体权限服务
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof AuthServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allAuthService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体权限服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof AuthServiceRegister
     */
    public async getService(name: string): Promise<any> {
        if (this.serviceCache.has(name)) {
            return this.serviceCache.get(name);
        }
        const authService: any = await this.loadService(name);
        if (authService && authService.default) {
            const instance: any = new authService.default();
            this.serviceCache.set(name, instance);
            return instance;
        }
    }

}
export const authServiceRegister: AuthServiceRegister = new AuthServiceRegister();