import { Http } from '@/utils/http/http';

/**
 * 视图消息组
 *
 * @export
 * @class ViewMessageGroupService
 */
export default class ViewMessageGroupService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {ViewMessageGroupService}
     * @memberof ViewMessageGroupService
     */
    private static ViewMessageGroup: ViewMessageGroupService;

    /**
     * 所有视图消息组对象
     *
     * @private
     * @static
     * @type {ViewMessageGroupService}
     * @memberof ViewMessageGroupService
     */
    private static allViewMessageGroup:any;

    /**
     * 初始化实例
     * 
     * @memberof ViewMessageGroupService
     */
    constructor(opts:any = {}){}

    /**
     * 获取 ViewMessageGroupService 单例对象
     *
     * @static
     * @returns {ViewMessageGroupService}
     * @memberof ViewMessageGroupService
     */
    public static getInstance(): ViewMessageGroupService {
        if (!ViewMessageGroupService.ViewMessageGroup) {
            ViewMessageGroupService.ViewMessageGroup = new ViewMessageGroupService();
        }
        return this.ViewMessageGroup;
    }

    /**
     * 获取视图消息组成员集合
     *
     * @returns {Promise<any></any>}
     * @memberof ViewMessageGroupService
     */
    public async getViewMessageDetailsByTag(tag:string):Promise<any>{
        if(ViewMessageGroupService.allViewMessageGroup){
            return ViewMessageGroupService.allViewMessageGroup[tag]?ViewMessageGroupService.allViewMessageGroup[tag]:[];
        }else{
            let result:any = await this.loadAllViewMessageGroup();
            return result[tag]?result[tag]:[];
        }
        
    }

    /**
     * 加载应用所有视图消息组集合
     *
     * @returns {Promise<any></any>}
     * @memberof ViewMessageGroupService
     */
    public loadAllViewMessageGroup():Promise<any>{
        return new Promise((resolve:any,reject:any) =>{
            Http.getInstance().get('./assets/json/view-message-group.json').then((response: any) => {
                if (response && response.status === 200 && response.data) {
                    ViewMessageGroupService.allViewMessageGroup = response.data;
                    resolve(response.data);
                }
            }).catch((error: any) => {
                console.log(error);
            });
        })
    }

}