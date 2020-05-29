import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 用户角色关系服务对象基类
 *
 * @export
 * @class SysUserRoleServiceBase
 * @extends {EntityServie}
 */
export default class SysUserRoleServiceBase extends EntityService {

    /**
     * Creates an instance of  SysUserRoleServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysUserRoleServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysUserRoleServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='sysuserrole';
        this.APPDEKEY = 'userroleid';
        this.APPDENAME = 'sysuserroles';
        this.APPDETEXT = 'userid';
        this.APPNAME = 'web';
        this.SYSTEMNAME = 'ibzuaa';
    }

// 实体接口

    /**
     * Select接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && context.sysuserrole){
            return Http.getInstance().get(`/sysusers/${context.sysuser}/sysuserroles/${context.sysuserrole}/select`,isloading);
        }
        if(context.sysrole && context.sysuserrole){
            return Http.getInstance().get(`/sysroles/${context.sysrole}/sysuserroles/${context.sysuserrole}/select`,isloading);
        }
            return Http.getInstance().get(`/sysuserroles/${context.sysuserrole}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && context.sysuserrole){
            return Http.getInstance().post(`/sysusers/${context.sysuser}/sysuserroles/${context.sysuserrole}/checkkey`,data,isloading);
        }
        if(context.sysrole && context.sysuserrole){
            return Http.getInstance().post(`/sysroles/${context.sysrole}/sysuserroles/${context.sysuserrole}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/sysuserroles/${context.sysuserrole}/checkkey`,data,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && true){
            return Http.getInstance().get(`/sysusers/${context.sysuser}/sysuserroles/getdraft`,isloading);
        }
        if(context.sysrole && true){
            return Http.getInstance().get(`/sysroles/${context.sysrole}/sysuserroles/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/sysuserroles/getdraft`,isloading);
        res.data.sysuserrole = data.sysuserrole;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && context.sysuserrole){
            return Http.getInstance().put(`/sysusers/${context.sysuser}/sysuserroles/${context.sysuserrole}`,data,isloading);
        }
        if(context.sysrole && context.sysuserrole){
            return Http.getInstance().put(`/sysroles/${context.sysrole}/sysuserroles/${context.sysuserrole}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/sysuserroles/${context.sysuserrole}`,data,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && context.sysuserrole){
            return Http.getInstance().delete(`/sysusers/${context.sysuser}/sysuserroles/${context.sysuserrole}`,isloading);
        }
        if(context.sysrole && context.sysuserrole){
            return Http.getInstance().delete(`/sysroles/${context.sysrole}/sysuserroles/${context.sysuserrole}`,isloading);
        }
            return Http.getInstance().delete(`/sysuserroles/${context.sysuserrole}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/sysusers/${context.sysuser}/sysuserroles`,data,isloading);
        }
        if(context.sysrole && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/sysroles/${context.sysrole}/sysuserroles`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/sysuserroles`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && context.sysuserrole){
            return Http.getInstance().get(`/sysusers/${context.sysuser}/sysuserroles/${context.sysuserrole}`,isloading);
        }
        if(context.sysrole && context.sysuserrole){
            return Http.getInstance().get(`/sysroles/${context.sysrole}/sysuserroles/${context.sysuserrole}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/sysuserroles/${context.sysuserrole}`,isloading);
            return res;

    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && context.sysuserrole){
            return Http.getInstance().post(`/sysusers/${context.sysuser}/sysuserroles/${context.sysuserrole}/save`,data,isloading);
        }
        if(context.sysrole && context.sysuserrole){
            return Http.getInstance().post(`/sysroles/${context.sysrole}/sysuserroles/${context.sysuserrole}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/sysuserroles/${context.sysuserrole}/save`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysUserRoleServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysuser && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/sysusers/${context.sysuser}/sysuserroles/fetchdefault`,tempData,isloading);
        }
        if(context.sysrole && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/sysroles/${context.sysrole}/sysuserroles/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/sysuserroles/fetchdefault`,tempData,isloading);
    }
}