/**
 * 视图消息服务注册中心
 *
 * @export
 * @class MessageServiceRegister
 */
export class MessageServiceRegister {

    /**
     * 所有视图消息服务Map
     *
     * @protected
     * @type {*}
     * @memberof MessageServiceRegister
     */
    protected allMessageService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载视图消息服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof MessageServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of MessageServiceRegister.
     * @memberof MessageServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof MessageServiceRegister
     */
    protected init(): void {
            }

    /**
     * 加载视图消息服务
     *
     * @protected
     * @param {string} codeName
     * @returns {Promise<any>}
     * @memberof MessageServiceRegister
     */
    protected async loadService(codeName: string): Promise<any> {
        const service = this.allMessageService.get(codeName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取视图消息服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof MessageServiceRegister
     */
    public async getService(name: string): Promise<any> {
        if (this.serviceCache.has(name)) {
            return this.serviceCache.get(name);
        }
        const messageService: any = await this.loadService(name);
        if (messageService && messageService.default) {
            const instance: any = new messageService.default();
            this.serviceCache.set(name, instance);
            return instance;
        }
    }

}
export const messageServiceRegister: MessageServiceRegister = new MessageServiceRegister();