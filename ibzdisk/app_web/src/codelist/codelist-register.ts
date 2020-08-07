/**
 * 代码表服务注册中心
 *
 * @export
 * @class CodeListRegister
 */
export class CodeListRegister {

    /**
     * 所有实体数据服务Map
     *
     * @protected
     * @type {*}
     * @memberof CodeListRegister
     */
    protected allCodeList: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载实体数据服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof CodeListRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of CodeListRegister.
     * @memberof CodeListRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof CodeListRegister
     */
    protected init(): void {
            this.allCodeList.set('SysOperator', () => import('@/codelist/sys-operator'));
    }

    /**
     * 加载实体数据服务
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof CodeListRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allCodeList.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体数据服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof CodeListRegister
     */
    public async getService(name: string): Promise<any> {
        if (this.serviceCache.has(name)) {
            return this.serviceCache.get(name);
        }
        const CodeList: any = await this.loadService(name);
        if (CodeList && CodeList.default) {
            const instance: any = new CodeList.default();
            this.serviceCache.set(name, instance);
            return instance;
        }
    }

}
export const codeListRegister: CodeListRegister = new CodeListRegister();