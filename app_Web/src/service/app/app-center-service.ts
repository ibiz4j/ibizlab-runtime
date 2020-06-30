import { Subject } from 'rxjs';

export interface Message {

    /**
     * 名称(通常是应用实体名称)
     *
     * @memberof Message
     */
    name: string;

    /**
     * 行为（操作数据行为）
     *
     * @memberof Message
     */
    action: string;

    /**
     * 数据（操作数据）
     *
     * @memberof Message
     */
    data: any;

}

/**
 * 应用中心服务类
 *
 * @export
 * @class AppCenterService
 */
export default class AppCenterService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {*}
     * @memberof AppCenterService
     */
    private static store: any;

    /**
     * 应用数据状态管理对象
     *
     * @private
     * @type {Subject<any>}
     * @memberof AppCenterService
     */
    private static subject:Subject<any> = new Subject<any>();

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AppCenterService}
     * @memberof AppCenterService
     */
    private static appCenterService: AppCenterService;

    /**
     * 初始化实例
     *
     * @memberof AppCenterService
     */
    constructor() {}

    /**
     * 获取 AppCenterService 单例对象
     *
     * @static
     * @returns {AppCenterService}
     * @memberof AppCenterService
     */
    public static getInstance(store: any): AppCenterService {
        if (!AppCenterService.appCenterService) {
            AppCenterService.appCenterService = new AppCenterService();
        }
        this.store = store;
        return this.appCenterService;
    }

    /**
     * 通知消息
     *
     * @static
     * @memberof AppCenterService
     */
    public static notifyMessage(message:Message){
        this.subject.next(message);
    }

    /**
     * 获取消息中心
     *
     * @static
     * @memberof AppCenterService
     */
    public static getMessageCenter():Subject<any>{
        return this.subject;
    }
}