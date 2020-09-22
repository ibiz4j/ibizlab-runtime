/**
 * 视图消息
 *
 * @interface ViewMessage
 */
export interface ViewMessage {

    /**
     * 视图消息标识
     *
     * @type {string}
     * @memberof ViewMessage
     */
    id:string;

    /**
     * 视图消息名称
     *
     * @type {string}
     * @memberof ViewMessage
     */
    name:string;

    /**
     * 视图消息代码名称
     *
     * @type {string}
     * @memberof ViewMessage
     */
    codename:string;

    /**
     * 视图消息标题
     *
     * @type {string}
     * @memberof ViewMessage
     */
    title:string;

    /**
     * 视图消息内容
     *
     * @type {string}
     * @memberof ViewMessage
     */
    content:string;

    /**
     * 视图消息关闭模式
     *
     * @type {number}
     * @memberof ViewMessage
     */
    closeMode:number;

    /**
     * 视图消息位置
     *
     * @type {string}
     * @memberof ViewMessage
     */
    position:string;

    /**
     * 视图消息类型
     *
     * @type {string}
     * @memberof ViewMessage
     */
    type:string;
    
    /**
     * 视图消息是否支持删除
     *
     * @type {boolean}
     * @memberof ViewMessage
     */
    isEnableRemove:boolean;

    /**
     * 排序值
     *
     * @type {number}
     * @memberof ViewMessage
     */    
    order:number;

    /**
     * 动态模式
     *
     * @type {string}
     * @memberof ViewMessage
     */
    dynamicMode:string;

    /**
     * 消息类型
     *
     * @type {string}
     * @memberof ViewMessage
     */
    messageType:string;
}