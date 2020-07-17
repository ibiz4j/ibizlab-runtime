import { Http,Util } from '@/utils';
import EntityService from '../entity-service';
import SaveDeptMemberLogic from '@/service/ibzemployee/save-dept-member-logic';



/**
 * 人员服务对象基类
 *
 * @export
 * @class IBZEmployeeServiceBase
 * @extends {EntityServie}
 */
export default class IBZEmployeeServiceBase extends EntityService {

    /**
     * Creates an instance of  IBZEmployeeServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZEmployeeServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof IBZEmployeeServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ibzemployee';
        this.APPDEKEY = 'userid';
        this.APPDENAME = 'ibzemployees';
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
     * @memberof IBZEmployeeServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee){
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/select`,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee){
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/select`,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee){
            let res:any = Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/select`,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/select`,isloading);
            
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
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
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees`,data,isloading);
            this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers?res.data.ibzteammembers:[]));
            this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers?res.data.ibzdeptmembers:[]));
                let savedeptmember:SaveDeptMemberLogic = new SaveDeptMemberLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(res))});
            res = await savedeptmember.onExecute(context,res,isloading?true:false);

            return res;
        }
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
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees`,data,isloading);
            this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers?res.data.ibzteammembers:[]));
            this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers?res.data.ibzdeptmembers:[]));
                let savedeptmember:SaveDeptMemberLogic = new SaveDeptMemberLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(res))});
            res = await savedeptmember.onExecute(context,res,isloading?true:false);

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
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees`,data,isloading);
            this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers?res.data.ibzteammembers:[]));
            this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers?res.data.ibzdeptmembers:[]));
                let savedeptmember:SaveDeptMemberLogic = new SaveDeptMemberLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(res))});
            res = await savedeptmember.onExecute(context,res,isloading?true:false);

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
        let res:any = await Http.getInstance().post(`/ibzemployees`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers?res.data.ibzteammembers:[]));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers?res.data.ibzdeptmembers:[]));
            let savedeptmember:SaveDeptMemberLogic = new SaveDeptMemberLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(res))});
            res = await savedeptmember.onExecute(context,res,isloading?true:false);

        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}`,data,isloading);
                let savedeptmember:SaveDeptMemberLogic = new SaveDeptMemberLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(res))});
            res = await savedeptmember.onExecute(context,res,isloading?true:false);

            return res;
        }
        if(context.ibzorganization && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}`,data,isloading);
                let savedeptmember:SaveDeptMemberLogic = new SaveDeptMemberLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(res))});
            res = await savedeptmember.onExecute(context,res,isloading?true:false);

            return res;
        }
        if(context.ibzdepartment && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}`,data,isloading);
                let savedeptmember:SaveDeptMemberLogic = new SaveDeptMemberLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(res))});
            res = await savedeptmember.onExecute(context,res,isloading?true:false);

            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ibzemployees/${context.ibzemployee}`,data,isloading);
                let savedeptmember:SaveDeptMemberLogic = new SaveDeptMemberLogic({context:JSON.parse(JSON.stringify(context)),data:JSON.parse(JSON.stringify(res))});
            res = await savedeptmember.onExecute(context,res,isloading?true:false);

            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee){
            let res:any = Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}`,isloading);
            return res;
        }
        if(context.ibzorganization && context.ibzemployee){
            let res:any = Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}`,isloading);
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee){
            let res:any = Http.getInstance().delete(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}`,isloading);
            return res;
        }
            let res:any = Http.getInstance().delete(`/ibzemployees/${context.ibzemployee}`,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}`,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}`,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee){
            let res:any = await Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}`,isloading);
            
            return res;
        }
            let res:any = await Http.getInstance().get(`/ibzemployees/${context.ibzemployee}`,isloading);
            
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && true){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/getdraft`,isloading);
            res.data.ibzemployee = data.ibzemployee;
            
            return res;
        }
        if(context.ibzorganization && true){
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/getdraft`,isloading);
            res.data.ibzemployee = data.ibzemployee;
            
            return res;
        }
        if(context.ibzdepartment && true){
            let res:any = await Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/getdraft`,isloading);
            res.data.ibzemployee = data.ibzemployee;
            
            return res;
        }
        let res:any = await  Http.getInstance().get(`/ibzemployees/getdraft`,isloading);
        res.data.ibzemployee = data.ibzemployee;
        
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/checkkey`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/checkkey`,data,isloading);
            return res;
    }

    /**
     * InitPwd接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async InitPwd(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/initpwd`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/initpwd`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/initpwd`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/initpwd`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/save`,data,isloading);
            
            return res;
        }
        if(context.ibzorganization && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/save`,data,isloading);
            
            return res;
        }
        if(context.ibzdepartment && context.ibzemployee){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/save`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/save`,data,isloading);
            
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZEmployeeServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.ibzorganization && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.ibzdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/fetchdefault`,tempData,isloading);
            return res;
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = Http.getInstance().get(`/ibzemployees/fetchdefault`,tempData,isloading);
        return res;
    }
}