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
                this.allEntityService.set('wftask', () => import('@/service/wftask/wftask-service'));
        this.allEntityService.set('wfmember', () => import('@/service/wfmember/wfmember-service'));
        this.allEntityService.set('wfuser', () => import('@/service/wfuser/wfuser-service'));
        this.allEntityService.set('wfprocessinstance', () => import('@/service/wfprocess-instance/wfprocess-instance-service'));
        this.allEntityService.set('wfprocessnode', () => import('@/service/wfprocess-node/wfprocess-node-service'));
        this.allEntityService.set('wfgroup', () => import('@/service/wfgroup/wfgroup-service'));
        this.allEntityService.set('wfremodel', () => import('@/service/wfremodel/wfremodel-service'));
        this.allEntityService.set('wfsystem', () => import('@/service/wfsystem/wfsystem-service'));
        this.allEntityService.set('wfprocessdefinition', () => import('@/service/wfprocess-definition/wfprocess-definition-service'));
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