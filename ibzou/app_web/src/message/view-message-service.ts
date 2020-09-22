import { ViewMessage } from '@/interface/message';
import EntityService from '@/service/entity-service';

/**
 * 视图消息
 *
 * @export
 * @class ViewMessage
 */
export default class ViewMessageService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {ViewMessageService}
     * @memberof ViewMessageService
     */
    private static ViewMessage: ViewMessageService;

    /**
     * 实体数据服务对象
     *
     * @protected
     * @type {EntityService}
     * @memberof ViewMessageService
     */
    protected entityService:EntityService = new EntityService();

    /**
     * 视图消息标识
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public id:string ="";

    /**
     * 视图消息名称
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public name:string ="";

    /**
     * 视图消息代码名称
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public codename:string ="";

    /**
     * 视图消息标题
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public title:string ="";

    /**
     * 视图消息内容
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public content:string ="";

    /**
     * 视图消息关闭模式(0:无关闭，1:默认关闭，2：本次关闭)
     *
     * @type {number}
     * @memberof ViewMessageService
     */
    public closeMode:number = 0;

    /**
     * 视图消息位置
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public position:string ="";

    /**
     * 视图消息类型
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public type:string = "info";

    /**
     * 视图消息是否支持删除
     *
     * @type {boolean}
     * @memberof ViewMessageService
     */
    public isEnableRemove:boolean = true;

    /**
     * 视图消息排序值
     *
     * @type {boolean}
     * @memberof ViewMessageService
     */
    public order:number = 1;

    /**
     * 动态模式
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public dynamicMode:string = "STATIC";

    /**
     * 消息类型(可选值：TEXT/HTML)
     *
     * @type {string}
     * @memberof ViewMessageService
     */
    public messageType:string = "TEXT";

    /**
     * 是否含有消息模板
     *
     * @type {boolean}
     * @memberof ViewMessageService
     */
    public hasMessageTemp:boolean = false;

    /**
     * 视图消息缓存(加载中)
     *
     * @type {Map<string,any>}
     * @memberof ViewMessageService
     */
    public static messageCache:Map<string,any> = new Map();

    /**
     * 视图消息缓存(已完成)
     *
     * @type {Map<string,any>}
     * @memberof ViewMessageService
     */
    public static messageCached:Map<string,any> = new Map();

    /**
     * 初始化实例
     * 
     * @memberof ViewMessageService
     */
    constructor(opts: any = {}) {
        this.initBasicParam();
    }

    /**
     * 获取 ViewMessageService 单例对象
     *
     * @static
     * @returns {ViewMessageService}
     * @memberof ViewMessageService
     */
    public static getInstance(): ViewMessageService {
        if (!ViewMessageService.ViewMessage) {
            ViewMessageService.ViewMessage = new ViewMessageService();
        }
        return this.ViewMessage;
    }

    /**
     * 初始化基础参数
     * 
     * @memberof ViewMessageService
     */
    public initBasicParam(){}

    /**
     * 获取视图消息服务
     *
     * @protected
     * @param {string} name 视图消息codename
     * @returns {Promise<any>}
     * @memberof ViewMessageService
     */
    public getService(name: string): Promise<any> {
        return (window as any)['messageServiceRegister'].getService(name);
    }

    /**
     * 通过tag获取视图消息
     * 
     * @param {tag:string} 视图消息标识
     * @param {context:any} 导航上下文
     * @param {viewparam:any} 导航参数
     * @memberof ViewMessageService
     */
    public async getViewMessageByTag(tag:string,context:any = {},viewparam:any = {}){
        let messageService:any = await this.getService(tag);
        if(messageService.dynamicMode && Object.is(messageService.dynamicMode,"STATIC")){
            return messageService.getStaticViewMessage();
        }else{
            return messageService.getDynamicViewMessage(tag,messageService,context,viewparam);
        }
    }

    /**
     * 转化消息模板标题和内容
     * 
     * @memberof ViewMessageService
     */
    public translateMessageTemp(target:any,item?:any){
        
    }

    /**
     * 获取动态模式（静态）类型视图消息
     * 
     * @memberof ViewMessageService
     */
    public getStaticViewMessage():Array<ViewMessage>{
        let returnViewMessage:ViewMessage ={
            id:this.id,
            name:this.name,
            codename:this.codename,
            title:this.title,
            content:this.content,
            closeMode:this.closeMode,
            position:this.position,
            type:this.type,
            isEnableRemove:this.isEnableRemove,
            order:this.order,
            dynamicMode:this.dynamicMode,
            messageType:this.messageType
        };
        this.translateMessageTemp(returnViewMessage);
        return [returnViewMessage];
    }

    /**
     * 获取动态模式（实体数据集合）类型视图消息
     *
     * @param {any} tag 视图消息标识
     * @param {any} messageService 消息服务
     * @param {string} context
     * @returns {Promise<any[]>}
     * @memberof ViewMessageService
     */
    public getDynamicViewMessage(tag:string,messageService: any,context:any = {}, data: any = {}, isloading?: boolean): Promise<any[]> {
        if(context && context.srfsessionid){
            delete context.srfsessionid;
        }
        return new Promise((resolve:any,reject:any) =>{
            let isEnableCache:boolean = messageService.isEnableCache;
            let cacheTimeout:any = messageService.cacheTimeout;
            // 启用缓存
            if(isEnableCache){
                const callback:Function = (context:any ={},data:any ={},tag:string,promise:Promise<any>) =>{
                    promise.then((result:any) =>{
                        if(result.length > 0){
                            ViewMessageService.messageCached.set(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`,{items:result});
                            ViewMessageService.messageCache.delete(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`);
                            return resolve(result);
                        }else{
                            return resolve([]);
                        }
                    }).catch((result:any) =>{
                        return reject(result);
                    })
                }
                // 加载完成,从本地缓存获取
                if(ViewMessageService.messageCached.get(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`)){
                    let items:any = ViewMessageService.messageCached.get(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`).items;
                    if(items.length >0){
                        if(new Date().getTime() <= messageService.getExpirationTime()){
                            return resolve(items); 
                        }
                    }
                }
                if (messageService) {
                    // 加载中，UI又需要数据，解决连续加载同一代码表问题
                    if(ViewMessageService.messageCache.get(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`)){
                        callback(context,data,tag,ViewMessageService.messageCache.get(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`));
                    }else{
                        let result:Promise<any> = messageService.getItems(context,data,isloading);
                        ViewMessageService.messageCache.set(`${JSON.stringify(context)}-${JSON.stringify(data)}-${tag}`,result);
                        messageService.setExpirationTime(new Date().getTime() + cacheTimeout);
                        callback(context,data,tag,result);
                    }
                }
            }else{
                if (messageService) {
                    messageService.getItems(context,data,isloading).then((result:any) =>{
                        resolve(result);
                    }).catch((error:any) =>{
                        Promise.reject([]);
                    })
                }else{
                    return Promise.reject([]);
                } 
            }
        })
    } 

}