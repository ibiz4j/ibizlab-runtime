import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 人员服务对象基类
 *
 * @export
 * @class SysEmployeeServiceBase
 * @extends {EntityServie}
 */
export default class SysEmployeeServiceBase extends EntityService {

    /**
     * Creates an instance of  SysEmployeeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysEmployeeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysEmployeeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='sysemployee';
        this.APPDEKEY = 'userid';
        this.APPDENAME = 'sysemployees';
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
     * @memberof SysEmployeeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee){
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/select`,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee){
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/select`,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee){
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/select`,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().get(`/sysemployees/${context.sysemployee}/select`,isloading);
            
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees`,data,isloading);
            this.tempStorage.setItem(tempContext.srfsessionkey+'_sysdeptmembers',JSON.stringify(res.data.sysdeptmembers?res.data.sysdeptmembers:[]));
            this.tempStorage.setItem(tempContext.srfsessionkey+'_systeammembers',JSON.stringify(res.data.systeammembers?res.data.systeammembers:[]));
            
            return res;
        }
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
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees`,data,isloading);
            this.tempStorage.setItem(tempContext.srfsessionkey+'_sysdeptmembers',JSON.stringify(res.data.sysdeptmembers?res.data.sysdeptmembers:[]));
            this.tempStorage.setItem(tempContext.srfsessionkey+'_systeammembers',JSON.stringify(res.data.systeammembers?res.data.systeammembers:[]));
            
            return res;
        }
        if(context.sysdepartment && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees`,data,isloading);
            this.tempStorage.setItem(tempContext.srfsessionkey+'_sysdeptmembers',JSON.stringify(res.data.sysdeptmembers?res.data.sysdeptmembers:[]));
            this.tempStorage.setItem(tempContext.srfsessionkey+'_systeammembers',JSON.stringify(res.data.systeammembers?res.data.systeammembers:[]));
            
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
        let res:any = await Http.getInstance().post(`/sysemployees`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_sysdeptmembers',JSON.stringify(res.data.sysdeptmembers?res.data.sysdeptmembers:[]));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_systeammembers',JSON.stringify(res.data.systeammembers?res.data.systeammembers:[]));
        
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/sysemployees/${context.sysemployee}`,data,isloading);
            
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee){
            let res:any = Http.getInstance().delete(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}`,isloading);
            return res;
        }
        if(context.sysorganization && context.sysemployee){
            let res:any = Http.getInstance().delete(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}`,isloading);
            return res;
        }
        if(context.sysdepartment && context.sysemployee){
            let res:any = Http.getInstance().delete(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}`,isloading);
            return res;
        }
            let res:any = Http.getInstance().delete(`/sysemployees/${context.sysemployee}`,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}`,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}`,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee){
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}`,isloading);
            
            return res;
        }
            let res:any = await Http.getInstance().get(`/sysemployees/${context.sysemployee}`,isloading);
            
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && true){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/getdraft`,isloading);
            res.data.sysemployee = data.sysemployee;
            
            return res;
        }
        if(context.sysorganization && true){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/getdraft`,isloading);
            res.data.sysemployee = data.sysemployee;
            
            return res;
        }
        if(context.sysdepartment && true){
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/getdraft`,isloading);
            res.data.sysemployee = data.sysemployee;
            
            return res;
        }
        let res:any = await  Http.getInstance().get(`/sysemployees/getdraft`,isloading);
        res.data.sysemployee = data.sysemployee;
        
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/checkkey`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/sysemployees/${context.sysemployee}/checkkey`,data,isloading);
            return res;
    }

    /**
     * InitPwd接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async InitPwd(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/initpwd`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/initpwd`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/initpwd`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/sysemployees/${context.sysemployee}/initpwd`,data,isloading);
            return res;
    }

    /**
     * InitPwdBatch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async InitPwdBatch(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/initpwdbatch`,tempData,isloading);
        }
        if(context.sysorganization && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/initpwdbatch`,tempData,isloading);
        }
        if(context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/initpwdbatch`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return await Http.getInstance().post(`/sysemployees/initpwdbatch`,tempData,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/save`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/save`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/save`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/sysemployees/${context.sysemployee}/save`,data,isloading);
            
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysorganization && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/fetchdefault`,tempData,isloading);
            return res;
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = Http.getInstance().get(`/sysemployees/fetchdefault`,tempData,isloading);
        return res;
    }

    /**
     * searchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysEmployeeServiceBase
     */
    public async searchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/searchdefault`,tempData,isloading);
        }
        if(context.sysorganization && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/searchdefault`,tempData,isloading);
        }
        if(context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/searchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return await Http.getInstance().post(`/sysemployees/searchdefault`,tempData,isloading);
    }
}