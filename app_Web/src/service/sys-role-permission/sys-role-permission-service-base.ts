import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 角色权限关系服务对象基类
 *
 * @export
 * @class SysRolePermissionServiceBase
 * @extends {EntityServie}
 */
export default class SysRolePermissionServiceBase extends EntityService {

    /**
     * Creates an instance of  SysRolePermissionServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysRolePermissionServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysRolePermissionServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='sysrolepermission';
        this.APPDEKEY = 'rolepermissionid';
        this.APPDENAME = 'sysrolepermissions';
        this.APPDETEXT = 'permissionid';
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
     * @memberof SysRolePermissionServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && context.sysrolepermission){
            return Http.getInstance().get(`/sysroles/${context.sysrole}/sysrolepermissions/${context.sysrolepermission}/select`,isloading);
        }
        if(context.syspermission && context.sysrolepermission){
            return Http.getInstance().get(`/syspermissions/${context.syspermission}/sysrolepermissions/${context.sysrolepermission}/select`,isloading);
        }
            return Http.getInstance().get(`/sysrolepermissions/${context.sysrolepermission}/select`,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRolePermissionServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && context.sysrolepermission){
            let res:any = await Http.getInstance().get(`/sysroles/${context.sysrole}/sysrolepermissions/${context.sysrolepermission}`,isloading);
            return res;
        }
        if(context.syspermission && context.sysrolepermission){
            let res:any = await Http.getInstance().get(`/syspermissions/${context.syspermission}/sysrolepermissions/${context.sysrolepermission}`,isloading);
            return res;
        }
            let res:any = await Http.getInstance().get(`/sysrolepermissions/${context.sysrolepermission}`,isloading);
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRolePermissionServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && context.sysrolepermission){
            return Http.getInstance().delete(`/sysroles/${context.sysrole}/sysrolepermissions/${context.sysrolepermission}`,isloading);
        }
        if(context.syspermission && context.sysrolepermission){
            return Http.getInstance().delete(`/syspermissions/${context.syspermission}/sysrolepermissions/${context.sysrolepermission}`,isloading);
        }
            return Http.getInstance().delete(`/sysrolepermissions/${context.sysrolepermission}`,isloading);
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRolePermissionServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && true){
            let res:any = await Http.getInstance().get(`/sysroles/${context.sysrole}/sysrolepermissions/getdraft`,isloading);
            res.data.sysrolepermission = data.sysrolepermission;
            return res;
        }
        if(context.syspermission && true){
            let res:any = await Http.getInstance().get(`/syspermissions/${context.syspermission}/sysrolepermissions/getdraft`,isloading);
            res.data.sysrolepermission = data.sysrolepermission;
            return res;
        }
        let res:any = await  Http.getInstance().get(`/sysrolepermissions/getdraft`,isloading);
        res.data.sysrolepermission = data.sysrolepermission;
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRolePermissionServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/sysroles/${context.sysrole}/sysrolepermissions`,data,isloading);
            return res;
        }
        if(context.syspermission && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/syspermissions/${context.syspermission}/sysrolepermissions`,data,isloading);
            return res;
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
        let res:any = await Http.getInstance().post(`/sysrolepermissions`,data,isloading);
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRolePermissionServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && context.sysrolepermission){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysroles/${context.sysrole}/sysrolepermissions/${context.sysrolepermission}/checkkey`,data,isloading);
            return res;
        }
        if(context.syspermission && context.sysrolepermission){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/syspermissions/${context.syspermission}/sysrolepermissions/${context.sysrolepermission}/checkkey`,data,isloading);
            return res;
        }
            return Http.getInstance().post(`/sysrolepermissions/${context.sysrolepermission}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRolePermissionServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && context.sysrolepermission){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysroles/${context.sysrole}/sysrolepermissions/${context.sysrolepermission}/save`,data,isloading);
            return res;
        }
        if(context.syspermission && context.sysrolepermission){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/syspermissions/${context.syspermission}/sysrolepermissions/${context.sysrolepermission}/save`,data,isloading);
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/sysrolepermissions/${context.sysrolepermission}/save`,data,isloading);
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRolePermissionServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && context.sysrolepermission){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysroles/${context.sysrole}/sysrolepermissions/${context.sysrolepermission}`,data,isloading);
            return res;
        }
        if(context.syspermission && context.sysrolepermission){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/syspermissions/${context.syspermission}/sysrolepermissions/${context.sysrolepermission}`,data,isloading);
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/sysrolepermissions/${context.sysrolepermission}`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRolePermissionServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysrole && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/sysroles/${context.sysrole}/sysrolepermissions/fetchdefault`,tempData,isloading);
        }
        if(context.syspermission && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/syspermissions/${context.syspermission}/sysrolepermissions/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/sysrolepermissions/fetchdefault`,tempData,isloading);
    }
}