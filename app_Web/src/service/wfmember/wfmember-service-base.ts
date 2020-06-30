import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 成员服务对象基类
 *
 * @export
 * @class WFMemberServiceBase
 * @extends {EntityServie}
 */
export default class WFMemberServiceBase extends EntityService {

    /**
     * Creates an instance of  WFMemberServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFMemberServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof WFMemberServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='wfmember';
        this.APPDEKEY = 'memberid';
        this.APPDENAME = 'wfmembers';
        this.APPDETEXT = 'membername';
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
     * @memberof WFMemberServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && context.wfmember){
            let res:any = await Http.getInstance().get(`/wfusers/${context.wfuser}/wfmembers/${context.wfmember}/select`,isloading);
        }
        if(context.wfgroup && context.wfmember){
            let res:any = await Http.getInstance().get(`/wfgroups/${context.wfgroup}/wfmembers/${context.wfmember}/select`,isloading);
        }
        let res:any = await Http.getInstance().get(`/wfmembers/${context.wfmember}/select`,isloading);
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFMemberServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && context.wfmember){
            let res:any = await Http.getInstance().delete(`/wfusers/${context.wfuser}/wfmembers/${context.wfmember}`,isloading);
        }
        if(context.wfgroup && context.wfmember){
            let res:any = await Http.getInstance().delete(`/wfgroups/${context.wfgroup}/wfmembers/${context.wfmember}`,isloading);
        }
        let res:any = await Http.getInstance().delete(`/wfmembers/${context.wfmember}`,isloading);
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFMemberServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && true){
            let res:any = await Http.getInstance().get(`/wfusers/${context.wfuser}/wfmembers/getdraft`,isloading);
            res.data.wfmember = data.wfmember;
        }
        if(context.wfgroup && true){
            let res:any = await Http.getInstance().get(`/wfgroups/${context.wfgroup}/wfmembers/getdraft`,isloading);
            res.data.wfmember = data.wfmember;
        }
        let res:any = await  Http.getInstance().get(`/wfmembers/getdraft`,isloading);
        res.data.wfmember = data.wfmember;
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFMemberServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && context.wfmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/wfusers/${context.wfuser}/wfmembers/${context.wfmember}/save`,data,isloading);
        }
        if(context.wfgroup && context.wfmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/wfgroups/${context.wfgroup}/wfmembers/${context.wfmember}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/wfmembers/${context.wfmember}/save`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFMemberServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && context.wfmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/wfusers/${context.wfuser}/wfmembers/${context.wfmember}/checkkey`,data,isloading);
        }
        if(context.wfgroup && context.wfmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/wfgroups/${context.wfgroup}/wfmembers/${context.wfmember}/checkkey`,data,isloading);
        }
        let res:any = await Http.getInstance().post(`/wfmembers/${context.wfmember}/checkkey`,data,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFMemberServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && context.wfmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/wfusers/${context.wfuser}/wfmembers/${context.wfmember}`,data,isloading);
        }
        if(context.wfgroup && context.wfmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/wfgroups/${context.wfgroup}/wfmembers/${context.wfmember}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/wfmembers/${context.wfmember}`,data,isloading);
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFMemberServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/wfusers/${context.wfuser}/wfmembers`,data,isloading);
        }
        if(context.wfgroup && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/wfgroups/${context.wfgroup}/wfmembers`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/wfmembers`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFMemberServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && context.wfmember){
            let res:any = await Http.getInstance().get(`/wfusers/${context.wfuser}/wfmembers/${context.wfmember}`,isloading);
        }
        if(context.wfgroup && context.wfmember){
            let res:any = await Http.getInstance().get(`/wfgroups/${context.wfgroup}/wfmembers/${context.wfmember}`,isloading);
        }
        let res:any = await Http.getInstance().get(`/wfmembers/${context.wfmember}`,isloading);
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof WFMemberServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.wfuser && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = await Http.getInstance().get(`/wfusers/${context.wfuser}/wfmembers/fetchdefault`,tempData,isloading);
        }
        if(context.wfgroup && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = await Http.getInstance().get(`/wfgroups/${context.wfgroup}/wfmembers/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = await Http.getInstance().get(`/wfmembers/fetchdefault`,tempData,isloading);
        return res;
    }
}