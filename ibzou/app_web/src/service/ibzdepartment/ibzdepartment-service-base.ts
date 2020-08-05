import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门服务对象基类
 *
 * @export
 * @class IBZDepartmentServiceBase
 * @extends {EntityServie}
 */
export default class IBZDepartmentServiceBase extends EntityService {

    /**
     * Creates an instance of  IBZDepartmentServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZDepartmentServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof IBZDepartmentServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ibzdepartment';
        this.APPDEKEY = 'deptid';
        this.APPDENAME = 'ibzdepartments';
        this.APPDETEXT = 'deptname';
        this.APPNAME = 'web';
        this.SYSTEMNAME = 'ibzou';
    }

// 实体接口

    /**
     * Select接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment){
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/select`,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/select`,isloading);
            
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments`,data,isloading);
            this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers?res.data.ibzdeptmembers:[]));
            this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees?res.data.ibzemployees:[]));
            
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
        let res:any = await Http.getInstance().post(`/ibzdepartments`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers?res.data.ibzdeptmembers:[]));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees?res.data.ibzemployees:[]));
        
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ibzdepartments/${context.ibzdepartment}`,data,isloading);
            
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment){
            let res:any = Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}`,isloading);
            return res;
        }
            let res:any = Http.getInstance().delete(`/ibzdepartments/${context.ibzdepartment}`,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}`,isloading);
            
            return res;
        }
            let res:any = await Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}`,isloading);
            
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && true){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/getdraft`,isloading);
            res.data.ibzdepartment = data.ibzdepartment;
            
            return res;
        }
        let res:any = await  Http.getInstance().get(`/ibzdepartments/getdraft`,isloading);
        res.data.ibzdepartment = data.ibzdepartment;
        
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/checkkey`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/checkkey`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/save`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/save`,data,isloading);
            
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/fetchdefault`,tempData,isloading);
            return res;
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = Http.getInstance().get(`/ibzdepartments/fetchdefault`,tempData,isloading);
        return res;
    }
}