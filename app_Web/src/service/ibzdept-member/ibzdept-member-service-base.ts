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
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
        }
        if(context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
        }
            return Http.getInstance().get(`/ibzdeptmembers/${context.ibzdeptmember}/select`,isloading);
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
            return Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().put(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
        }
        if(context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().put(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().put(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ibzdeptmembers/${context.ibzdeptmember}`,data,isloading);
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
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
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
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
        }
        if(context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ibzdeptmembers/${context.ibzdeptmember}/checkkey`,data,isloading);
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
            return Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().delete(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().delete(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().delete(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}`,isloading);
        }
            return Http.getInstance().delete(`/ibzdeptmembers/${context.ibzdeptmember}`,isloading);

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
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers`,data,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers`,data,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers`,data,isloading);
        }
        if(context.ibzemployee && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers`,data,isloading);
        }
        if(context.ibzdepartment && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers`,data,isloading);
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
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/getdraft`,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && true){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/getdraft`,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && true){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/getdraft`,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/getdraft`,isloading);
        }
        if(context.ibzemployee && true){
            return Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/getdraft`,isloading);
        }
        if(context.ibzdepartment && true){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ibzdeptmembers/getdraft`,isloading);
        res.data.ibzdeptmember = data.ibzdeptmember;
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
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
        }
        if(context.ibzemployee && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzdeptmember){
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/${context.ibzdeptmember}/save`,data,isloading);
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
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzorganization && context.ibzdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzdeptmembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzdeptmembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzdepartment && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzdeptmembers/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ibzdeptmembers/fetchdefault`,tempData,isloading);
    }
}