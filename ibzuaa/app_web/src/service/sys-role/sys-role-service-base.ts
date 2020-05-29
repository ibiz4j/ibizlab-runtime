import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 系统角色服务对象基类
 *
 * @export
 * @class SysRoleServiceBase
 * @extends {EntityServie}
 */
export default class SysRoleServiceBase extends EntityService {

    /**
     * Creates an instance of  SysRoleServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysRoleServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysRoleServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='sysrole';
        this.APPDEKEY = 'roleid';
        this.APPDENAME = 'sysroles';
        this.APPDETEXT = 'rolename';
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
     * @memberof SysRoleServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/sysroles/${context.sysrole}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRoleServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let sysrolepermissionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_sysrolepermissions'),'undefined')){
            sysrolepermissionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_sysrolepermissions') as any);
            if(sysrolepermissionsData && sysrolepermissionsData.length && sysrolepermissionsData.length > 0){
                sysrolepermissionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.rolepermissionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.sysrolepermissions = sysrolepermissionsData;
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
            let res:any = await  Http.getInstance().post(`/sysroles/${context.sysrole}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
            this.tempStorage.setItem(context.srfsessionkey+'_sysuserroles',JSON.stringify(res.data.sysuserroles));
            return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRoleServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let sysrolepermissionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_sysrolepermissions'),'undefined')){
            sysrolepermissionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_sysrolepermissions') as any);
            if(sysrolepermissionsData && sysrolepermissionsData.length && sysrolepermissionsData.length > 0){
                sysrolepermissionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.rolepermissionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.sysrolepermissions = sysrolepermissionsData;
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
            let res:any = await  Http.getInstance().put(`/sysroles/${context.sysrole}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
            this.tempStorage.setItem(context.srfsessionkey+'_sysuserroles',JSON.stringify(res.data.sysuserroles));
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRoleServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let sysrolepermissionsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_sysrolepermissions'),'undefined')){
            sysrolepermissionsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_sysrolepermissions') as any);
            if(sysrolepermissionsData && sysrolepermissionsData.length && sysrolepermissionsData.length > 0){
                sysrolepermissionsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.rolepermissionid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.sysrolepermissions = sysrolepermissionsData;
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
        let res:any = await Http.getInstance().post(`/sysroles`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_sysuserroles',JSON.stringify(res.data.sysuserroles));
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRoleServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/sysroles/${context.sysrole}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
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
     * @memberof SysRoleServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/sysroles/${context.sysrole}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRoleServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/sysroles/getdraft`,isloading);
        res.data.sysrole = data.sysrole;
            this.tempStorage.setItem(context.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
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
     * @memberof SysRoleServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/sysroles/${context.sysrole}/checkkey`,data,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysRoleServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/sysroles/fetchdefault`,tempData,isloading);
    }
}