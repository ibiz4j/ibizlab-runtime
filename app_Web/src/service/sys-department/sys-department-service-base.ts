import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门服务对象基类
 *
 * @export
 * @class SysDepartmentServiceBase
 * @extends {EntityServie}
 */
export default class SysDepartmentServiceBase extends EntityService {

    /**
     * Creates an instance of  SysDepartmentServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysDepartmentServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysDepartmentServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='sysdepartment';
        this.APPDEKEY = 'deptid';
        this.APPDENAME = 'sysdepartments';
        this.APPDETEXT = 'deptname';
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
     * @memberof SysDepartmentServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment){
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/select`,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/select`,isloading);
            
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments`,data,isloading);
            this.tempStorage.setItem(tempContext.srfsessionkey+'_sysdeptmembers',JSON.stringify(res.data.sysdeptmembers?res.data.sysdeptmembers:[]));
            this.tempStorage.setItem(tempContext.srfsessionkey+'_sysemployees',JSON.stringify(res.data.sysemployees?res.data.sysemployees:[]));
            
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
        let res:any = await Http.getInstance().post(`/sysdepartments`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_sysdeptmembers',JSON.stringify(res.data.sysdeptmembers?res.data.sysdeptmembers:[]));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_sysemployees',JSON.stringify(res.data.sysemployees?res.data.sysemployees:[]));
        
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/sysdepartments/${context.sysdepartment}`,data,isloading);
            
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment){
            let res:any = Http.getInstance().delete(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}`,isloading);
            return res;
        }
            let res:any = Http.getInstance().delete(`/sysdepartments/${context.sysdepartment}`,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}`,isloading);
            
            return res;
        }
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}`,isloading);
            
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && true){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/getdraft`,isloading);
            res.data.sysdepartment = data.sysdepartment;
            
            return res;
        }
        let res:any = await  Http.getInstance().get(`/sysdepartments/getdraft`,isloading);
        res.data.sysdepartment = data.sysdepartment;
        
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/checkkey`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/checkkey`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/save`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/save`,data,isloading);
            
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/fetchdefault`,tempData,isloading);
            return res;
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = Http.getInstance().get(`/sysdepartments/fetchdefault`,tempData,isloading);
        return res;
    }

    /**
     * searchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDepartmentServiceBase
     */
    public async searchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/searchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return await Http.getInstance().post(`/sysdepartments/searchdefault`,tempData,isloading);
    }
}