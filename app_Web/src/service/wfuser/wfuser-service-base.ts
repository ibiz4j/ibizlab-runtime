import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户服务对象基类
 *
 * @export
 * @class WFUserServiceBase
 * @extends {EntityServie}
 */
export default class WFUserServiceBase extends EntityService {

    /**
     * Creates an instance of  WFUserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFUserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfuser';
        this.APPDEKEY = 'id';
        this.APPDENAME = 'wfusers';
        this.APPDETEXT = 'displayname';
        this.APPNAME = 'web';
        this.SYSTEMNAME = 'ibzrt';
    }

// 实体接口

    /**
     * Select接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfusers/${context.wfuser}/select`,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let wfmembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_wfmembers'),'undefined')){
            wfmembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_wfmembers') as any);
            if(wfmembersData && wfmembersData.length && wfmembersData.length > 0){
                wfmembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.memberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.wfmembers = wfmembersData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/wfusers/${context.wfuser}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_wfmembers',JSON.stringify(res.data.wfmembers));
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/wfusers/getdraft`,isloading);
        res.data.wfuser = data.wfuser;
            this.tempStorage.setItem(context.srfsessionkey+'_wfmembers',JSON.stringify(res.data.wfmembers));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/wfusers/${context.wfuser}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_wfmembers',JSON.stringify(res.data.wfmembers));
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let wfmembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_wfmembers'),'undefined')){
            wfmembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_wfmembers') as any);
            if(wfmembersData && wfmembersData.length && wfmembersData.length > 0){
                wfmembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.memberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.wfmembers = wfmembersData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/wfusers`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_wfmembers',JSON.stringify(res.data.wfmembers));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/wfusers/${context.wfuser}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let wfmembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_wfmembers'),'undefined')){
            wfmembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_wfmembers') as any);
            if(wfmembersData && wfmembersData.length && wfmembersData.length > 0){
                wfmembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.memberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.wfmembers = wfmembersData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/wfusers/${context.wfuser}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_wfmembers',JSON.stringify(res.data.wfmembers));
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/wfusers/${context.wfuser}`,isloading);

    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFUserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfusers/fetchdefault`,tempData,isloading);
    }
}