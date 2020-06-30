import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 权限/资源服务对象基类
 *
 * @export
 * @class SysPermissionServiceBase
 * @extends {EntityServie}
 */
export default class SysPermissionServiceBase extends EntityService {

    /**
     * Creates an instance of  SysPermissionServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysPermissionServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysPermissionServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='syspermission';
        this.APPDEKEY = 'permissionid';
        this.APPDENAME = 'syspermissions';
        this.APPDETEXT = 'permissionname';
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
     * @memberof SysPermissionServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().get(`/syspermissions/${context.syspermission}/select`,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysPermissionServiceBase
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/syspermissions/${context.syspermission}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysPermissionServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/syspermissions/getdraft`,isloading);
        res.data.syspermission = data.syspermission;
            this.tempStorage.setItem(context.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysPermissionServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().delete(`/syspermissions/${context.syspermission}`,isloading);
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysPermissionServiceBase
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/syspermissions/${context.syspermission}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysPermissionServiceBase
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
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/syspermissions`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysPermissionServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().post(`/syspermissions/${context.syspermission}/checkkey`,data,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysPermissionServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().get(`/syspermissions/${context.syspermission}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_sysrolepermissions',JSON.stringify(res.data.sysrolepermissions));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysPermissionServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = await Http.getInstance().get(`/syspermissions/fetchdefault`,tempData,isloading);
        return res;
    }
}