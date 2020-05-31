import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组成员服务对象基类
 *
 * @export
 * @class IBZTeamMemberServiceBase
 * @extends {EntityServie}
 */
export default class IBZTeamMemberServiceBase extends EntityService {

    /**
     * Creates an instance of  IBZTeamMemberServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZTeamMemberServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof IBZTeamMemberServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ibzteammember';
        this.APPDEKEY = 'teammemberid';
        this.APPDENAME = 'ibzteammembers';
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
     * @memberof IBZTeamMemberServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/select`,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/select`,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/select`,isloading);
        }
        if(context.ibzteam && context.ibzteammember){
            return Http.getInstance().get(`/ibzteams/${context.ibzteam}/ibzteammembers/${context.ibzteammember}/select`,isloading);
        }
        if(context.ibzemployee && context.ibzteammember){
            return Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/select`,isloading);
        }
            return Http.getInstance().get(`/ibzteammembers/${context.ibzteammember}/select`,isloading);
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamMemberServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/checkkey`,data,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/checkkey`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/checkkey`,data,isloading);
        }
        if(context.ibzteam && context.ibzteammember){
            return Http.getInstance().post(`/ibzteams/${context.ibzteam}/ibzteammembers/${context.ibzteammember}/checkkey`,data,isloading);
        }
        if(context.ibzemployee && context.ibzteammember){
            return Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ibzteammembers/${context.ibzteammember}/checkkey`,data,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamMemberServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/save`,data,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/save`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/save`,data,isloading);
        }
        if(context.ibzteam && context.ibzteammember){
            return Http.getInstance().post(`/ibzteams/${context.ibzteam}/ibzteammembers/${context.ibzteammember}/save`,data,isloading);
        }
        if(context.ibzemployee && context.ibzteammember){
            return Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}/save`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ibzteammembers/${context.ibzteammember}/save`,data,isloading);
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamMemberServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && true){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/getdraft`,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && true){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers/getdraft`,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/getdraft`,isloading);
        }
        if(context.ibzteam && true){
            return Http.getInstance().get(`/ibzteams/${context.ibzteam}/ibzteammembers/getdraft`,isloading);
        }
        if(context.ibzemployee && true){
            return Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzteammembers/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ibzteammembers/getdraft`,isloading);
        res.data.ibzteammember = data.ibzteammember;
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamMemberServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,data,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().put(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,data,isloading);
        }
        if(context.ibzteam && context.ibzteammember){
            return Http.getInstance().put(`/ibzteams/${context.ibzteam}/ibzteammembers/${context.ibzteammember}`,data,isloading);
        }
        if(context.ibzemployee && context.ibzteammember){
            return Http.getInstance().put(`/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,data,isloading);
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ibzteammembers/${context.ibzteammember}`,data,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamMemberServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
        if(context.ibzteam && context.ibzteammember){
            return Http.getInstance().get(`/ibzteams/${context.ibzteam}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
        if(context.ibzemployee && context.ibzteammember){
            return Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ibzteammembers/${context.ibzteammember}`,isloading);
            return res;

    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamMemberServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && context.ibzteammember){
            return Http.getInstance().delete(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
        if(context.ibzteam && context.ibzteammember){
            return Http.getInstance().delete(`/ibzteams/${context.ibzteam}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
        if(context.ibzemployee && context.ibzteammember){
            return Http.getInstance().delete(`/ibzemployees/${context.ibzemployee}/ibzteammembers/${context.ibzteammember}`,isloading);
        }
            return Http.getInstance().delete(`/ibzteammembers/${context.ibzteammember}`,isloading);

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamMemberServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers`,data,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers`,data,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers`,data,isloading);
        }
        if(context.ibzteam && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzteams/${context.ibzteam}/ibzteammembers`,data,isloading);
        }
        if(context.ibzemployee && true){
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzemployees/${context.ibzemployee}/ibzteammembers`,data,isloading);
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
        let res:any = await Http.getInstance().post(`/ibzteammembers`,data,isloading);
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamMemberServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && context.ibzdepartment && context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzorganization && context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzemployees/${context.ibzemployee}/ibzteammembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzdepartment && context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/ibzemployees/${context.ibzemployee}/ibzteammembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzteam && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzteams/${context.ibzteam}/ibzteammembers/fetchdefault`,tempData,isloading);
        }
        if(context.ibzemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzemployees/${context.ibzemployee}/ibzteammembers/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ibzteammembers/fetchdefault`,tempData,isloading);
    }
}