import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 系统用户服务对象基类
 *
 * @export
 * @class SysUserServiceBase
 * @extends {EntityServie}
 */
export default class SysUserServiceBase extends EntityService {

    /**
     * Creates an instance of  SysUserServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysUserServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysUserServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='sysuser';
        this.APPDEKEY = 'userid';
        this.APPDENAME = 'sysusers';
        this.APPDETEXT = 'personname';
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
     * @memberof SysUserServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().get(`/sysusers/${context.sysuser}/select`,isloading);
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let sysuserrolesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_sysuserroles'),'undefined')){
            sysuserrolesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_sysuserroles') as any);
            if(sysuserrolesData && sysuserrolesData.length && sysuserrolesData.length > 0){
                sysuserrolesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.userroleid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.sysuserroles = sysuserrolesData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/sysusers`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_sysuserroles',JSON.stringify(res.data.sysuserroles));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let sysuserrolesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_sysuserroles'),'undefined')){
            sysuserrolesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_sysuserroles') as any);
            if(sysuserrolesData && sysuserrolesData.length && sysuserrolesData.length > 0){
                sysuserrolesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.userroleid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.sysuserroles = sysuserrolesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/sysusers/${context.sysuser}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysuserroles',JSON.stringify(res.data.sysuserroles));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().delete(`/sysusers/${context.sysuser}`,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().get(`/sysusers/${context.sysuser}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysuserroles',JSON.stringify(res.data.sysuserroles));
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/sysusers/getdraft`,isloading);
        res.data.sysuser = data.sysuser;
            this.tempStorage.setItem(context.srfsessionkey+'_sysuserroles',JSON.stringify(res.data.sysuserroles));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().post(`/sysusers/${context.sysuser}/checkkey`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let sysuserrolesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_sysuserroles'),'undefined')){
            sysuserrolesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_sysuserroles') as any);
            if(sysuserrolesData && sysuserrolesData.length && sysuserrolesData.length > 0){
                sysuserrolesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.userroleid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.sysuserroles = sysuserrolesData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/sysusers/${context.sysuser}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysuserroles',JSON.stringify(res.data.sysuserroles));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = await Http.getInstance().get(`/sysusers/fetchdefault`,tempData,isloading);
        return res;
    }
}