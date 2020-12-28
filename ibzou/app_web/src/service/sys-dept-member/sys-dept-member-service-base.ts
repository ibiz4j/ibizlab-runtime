import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 部门成员服务对象基类
 *
 * @export
 * @class SysDeptMemberServiceBase
 * @extends {EntityServie}
 */
export default class SysDeptMemberServiceBase extends EntityService {

    /**
     * Creates an instance of  SysDeptMemberServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysDeptMemberServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysDeptMemberServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='sysdeptmember';
        this.APPDEKEY = 'memberid';
        this.APPDENAME = 'sysdeptmembers';
        this.APPDETEXT = 'personname';
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
     * @memberof SysDeptMemberServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.sysdeptmember){
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysdepartment && context.sysdeptmember){
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.sysemployee && context.sysdeptmember){
            let res:any = Http.getInstance().get(`/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/select`,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysdeptmember){
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}/select`,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().get(`/sysdeptmembers/${context.sysdeptmember}/select`,isloading);
            
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers`,data,isloading);
            
            return res;
        }
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
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers`,data,isloading);
            
            return res;
        }
        if(context.sysemployee && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/sysemployees/${context.sysemployee}/sysdeptmembers`,data,isloading);
            
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
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysdeptmembers`,data,isloading);
            
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
        let res:any = await Http.getInstance().post(`/sysdeptmembers`,data,isloading);
        
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysdepartment && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/sysdeptmembers/${context.sysdeptmember}`,data,isloading);
            
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let res:any = Http.getInstance().delete(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.sysdeptmember){
            let res:any = Http.getInstance().delete(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            return res;
        }
        if(context.sysorganization && context.sysdepartment && context.sysdeptmember){
            let res:any = Http.getInstance().delete(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let res:any = Http.getInstance().delete(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            return res;
        }
        if(context.sysemployee && context.sysdeptmember){
            let res:any = Http.getInstance().delete(`/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            return res;
        }
        if(context.sysdepartment && context.sysdeptmember){
            let res:any = Http.getInstance().delete(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            return res;
        }
            let res:any = Http.getInstance().delete(`/sysdeptmembers/${context.sysdeptmember}`,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.sysdeptmember){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysdepartment && context.sysdeptmember){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            
            return res;
        }
        if(context.sysemployee && context.sysdeptmember){
            let res:any = await Http.getInstance().get(`/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysdeptmember){
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}`,isloading);
            
            return res;
        }
            let res:any = await Http.getInstance().get(`/sysdeptmembers/${context.sysdeptmember}`,isloading);
            
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && true){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/getdraft`,isloading);
            res.data.sysdeptmember = data.sysdeptmember;
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && true){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/getdraft`,isloading);
            res.data.sysdeptmember = data.sysdeptmember;
            
            return res;
        }
        if(context.sysorganization && context.sysdepartment && true){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/getdraft`,isloading);
            res.data.sysdeptmember = data.sysdeptmember;
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && true){
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/getdraft`,isloading);
            res.data.sysdeptmember = data.sysdeptmember;
            
            return res;
        }
        if(context.sysemployee && true){
            let res:any = await Http.getInstance().get(`/sysemployees/${context.sysemployee}/sysdeptmembers/getdraft`,isloading);
            res.data.sysdeptmember = data.sysdeptmember;
            
            return res;
        }
        if(context.sysdepartment && true){
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/getdraft`,isloading);
            res.data.sysdeptmember = data.sysdeptmember;
            
            return res;
        }
        let res:any = await  Http.getInstance().get(`/sysdeptmembers/getdraft`,isloading);
        res.data.sysdeptmember = data.sysdeptmember;
        
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysdepartment && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}/checkkey`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/sysdeptmembers/${context.sysdeptmember}/checkkey`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysdepartment && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/save`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}/save`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/sysdeptmembers/${context.sysdeptmember}/save`,data,isloading);
            
            return res;
    }

    /**
     * SaveDeptMember接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async SaveDeptMember(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/savedeptmember`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/savedeptmember`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysdepartment && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}/savedeptmember`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/savedeptmember`,data,isloading);
            
            return res;
        }
        if(context.sysemployee && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysemployees/${context.sysemployee}/sysdeptmembers/${context.sysdeptmember}/savedeptmember`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysdeptmember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/${context.sysdeptmember}/savedeptmember`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/sysdeptmembers/${context.sysdeptmember}/savedeptmember`,data,isloading);
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysorganization && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysorganization && context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysdepartment && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysemployees/${context.sysemployee}/sysdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/fetchdefault`,tempData,isloading);
            return res;
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = Http.getInstance().get(`/sysdeptmembers/fetchdefault`,tempData,isloading);
        return res;
    }

    /**
     * searchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysDeptMemberServiceBase
     */
    public async searchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/searchdefault`,tempData,isloading);
        }
        if(context.sysorganization && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/sysdeptmembers/searchdefault`,tempData,isloading);
        }
        if(context.sysorganization && context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysdeptmembers/searchdefault`,tempData,isloading);
        }
        if(context.sysdepartment && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/sysdeptmembers/searchdefault`,tempData,isloading);
        }
        if(context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysemployees/${context.sysemployee}/sysdeptmembers/searchdefault`,tempData,isloading);
        }
        if(context.sysdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysdeptmembers/searchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return await Http.getInstance().post(`/sysdeptmembers/searchdefault`,tempData,isloading);
    }
}