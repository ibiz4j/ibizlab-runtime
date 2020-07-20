import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门成员服务对象基类
 *
 * @export
 * @class IBZDeptMemberServiceBase
 * @extends {EntityServie}
 */
export default class IBZDeptMemberServiceBase extends EntityService {

    /**
     * Creates an instance of  IBZDeptMemberServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZDeptMemberServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof IBZDeptMemberServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ibzdeptmember';
        this.APPDEKEY = 'memberid';
        this.APPDENAME = 'ibzdeptmembers';
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
     * @memberof IBZDeptMemberServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let res:any = Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.ibzemployee && context.ibzdeptmember){
            let res:any = Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            let res:any = Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().get(`/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
            
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDeptMemberServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers`,data,isloading);
            
            return res;
        }
        if(context.ibzemployee && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers`,data,isloading);
            
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
        let res:any = await Http.getInstance().post(`/ibzdeptmembers`,data,isloading);
        
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDeptMemberServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
            
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDeptMemberServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let res:any = Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            let res:any = Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            let res:any = Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let res:any = Http.getInstance().delete(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            return res;
        }
        if(context.ibzemployee && context.ibzdeptmember){
            let res:any = Http.getInstance().delete(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            return res;
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            let res:any = Http.getInstance().delete(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            return res;
        }
            let res:any = Http.getInstance().delete(`/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDeptMemberServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let res:any = await Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            
            return res;
        }
        if(context.ibzemployee && context.ibzdeptmember){
            let res:any = await Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            let res:any = await Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            
            return res;
        }
            let res:any = await Http.getInstance().get(`/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
            
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDeptMemberServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && true){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/getdraft`,isloading);
            res.data.ibzdeptmember = data.ibzdeptmember;
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && true){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/getdraft`,isloading);
            res.data.ibzdeptmember = data.ibzdeptmember;
            
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && true){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/getdraft`,isloading);
            res.data.ibzdeptmember = data.ibzdeptmember;
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            let res:any = await Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/getdraft`,isloading);
            res.data.ibzdeptmember = data.ibzdeptmember;
            
            return res;
        }
        if(context.ibzemployee && true){
            let res:any = await Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/getdraft`,isloading);
            res.data.ibzdeptmember = data.ibzdeptmember;
            
            return res;
        }
        if(context.ibzdepartment && true){
            let res:any = await Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/getdraft`,isloading);
            res.data.ibzdeptmember = data.ibzdeptmember;
            
            return res;
        }
        let res:any = await  Http.getInstance().get(`/ibzdeptmembers/getdraft`,isloading);
        res.data.ibzdeptmember = data.ibzdeptmember;
        
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDeptMemberServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDeptMemberServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.ibzemployee && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
            
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDeptMemberServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.ibzorganization && context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.ibzorganization && context.ibzdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.ibzdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = Http.getInstance().get(`/ibzdeptmembers/fetchdefault`,tempData,isloading);
        return res;
    }
}