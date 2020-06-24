import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 角色/用户组服务对象基类
 *
 * @export
 * @class WFGroupServiceBase
 * @extends {EntityServie}
 */
export default class WFGroupServiceBase extends EntityService {

    /**
     * Creates an instance of  WFGroupServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFGroupServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFGroupServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfgroup';
        this.APPDEKEY = 'id';
        this.APPDENAME = 'wfgroups';
        this.APPDETEXT = 'name';
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
     * @memberof WFGroupServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/wfgroups/${context.wfgroup}/select`,isloading);
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFGroupServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/wfgroups/${context.wfgroup}`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFGroupServiceBase
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
            let res:any = await  Http.getInstance().post(`/wfgroups/${context.wfgroup}/save`,data,isloading);
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
     * @memberof WFGroupServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/wfgroups/${context.wfgroup}`,isloading);
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
     * @memberof WFGroupServiceBase
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
        let res:any = await Http.getInstance().post(`/wfgroups`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_wfmembers',JSON.stringify(res.data.wfmembers));
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFGroupServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/wfgroups/getdraft`,isloading);
        res.data.wfgroup = data.wfgroup;
            this.tempStorage.setItem(context.srfsessionkey+'_wfmembers',JSON.stringify(res.data.wfmembers));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFGroupServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/wfgroups/${context.wfgroup}/checkkey`,data,isloading);
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFGroupServiceBase
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
            let res:any = await  Http.getInstance().put(`/wfgroups/${context.wfgroup}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_wfmembers',JSON.stringify(res.data.wfmembers));
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFGroupServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/wfgroups/fetchdefault`,tempData,isloading);
    }
}