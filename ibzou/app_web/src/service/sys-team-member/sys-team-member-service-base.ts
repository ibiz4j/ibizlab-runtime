import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组成员服务对象基类
 *
 * @export
 * @class SysTeamMemberServiceBase
 * @extends {EntityServie}
 */
export default class SysTeamMemberServiceBase extends EntityService {

    /**
     * Creates an instance of  SysTeamMemberServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysTeamMemberServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SysTeamMemberServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='systeammember';
        this.APPDEKEY = 'teammemberid';
        this.APPDENAME = 'systeammembers';
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
     * @memberof SysTeamMemberServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.systeammember){
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/select`,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.systeammember){
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/select`,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.systeammember){
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/select`,isloading);
            
            return res;
        }
        if(context.systeam && context.systeammember){
            let res:any = Http.getInstance().get(`/systeams/${context.systeam}/systeammembers/${context.systeammember}/select`,isloading);
            
            return res;
        }
        if(context.sysemployee && context.systeammember){
            let res:any = Http.getInstance().get(`/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/select`,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().get(`/systeammembers/${context.systeammember}/select`,isloading);
            
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysTeamMemberServiceBase
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
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers`,data,isloading);
            
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
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers`,data,isloading);
            
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
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers`,data,isloading);
            
            return res;
        }
        if(context.systeam && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/systeams/${context.systeam}/systeammembers`,data,isloading);
            
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
            let res:any = await Http.getInstance().post(`/sysemployees/${context.sysemployee}/systeammembers`,data,isloading);
            
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
        let res:any = await Http.getInstance().post(`/systeammembers`,data,isloading);
        
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysTeamMemberServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,data,isloading);
            
            return res;
        }
        if(context.systeam && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/systeams/${context.systeam}/systeammembers/${context.systeammember}`,data,isloading);
            
            return res;
        }
        if(context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/systeammembers/${context.systeammember}`,data,isloading);
            
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysTeamMemberServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.systeammember){
            let res:any = Http.getInstance().delete(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,isloading);
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.systeammember){
            let res:any = Http.getInstance().delete(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,isloading);
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.systeammember){
            let res:any = Http.getInstance().delete(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,isloading);
            return res;
        }
        if(context.systeam && context.systeammember){
            let res:any = Http.getInstance().delete(`/systeams/${context.systeam}/systeammembers/${context.systeammember}`,isloading);
            return res;
        }
        if(context.sysemployee && context.systeammember){
            let res:any = Http.getInstance().delete(`/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,isloading);
            return res;
        }
            let res:any = Http.getInstance().delete(`/systeammembers/${context.systeammember}`,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysTeamMemberServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.systeammember){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.systeammember){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.systeammember){
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,isloading);
            
            return res;
        }
        if(context.systeam && context.systeammember){
            let res:any = await Http.getInstance().get(`/systeams/${context.systeam}/systeammembers/${context.systeammember}`,isloading);
            
            return res;
        }
        if(context.sysemployee && context.systeammember){
            let res:any = await Http.getInstance().get(`/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}`,isloading);
            
            return res;
        }
            let res:any = await Http.getInstance().get(`/systeammembers/${context.systeammember}`,isloading);
            
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysTeamMemberServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && true){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/getdraft`,isloading);
            res.data.systeammember = data.systeammember;
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && true){
            let res:any = await Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers/getdraft`,isloading);
            res.data.systeammember = data.systeammember;
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && true){
            let res:any = await Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/getdraft`,isloading);
            res.data.systeammember = data.systeammember;
            
            return res;
        }
        if(context.systeam && true){
            let res:any = await Http.getInstance().get(`/systeams/${context.systeam}/systeammembers/getdraft`,isloading);
            res.data.systeammember = data.systeammember;
            
            return res;
        }
        if(context.sysemployee && true){
            let res:any = await Http.getInstance().get(`/sysemployees/${context.sysemployee}/systeammembers/getdraft`,isloading);
            res.data.systeammember = data.systeammember;
            
            return res;
        }
        let res:any = await  Http.getInstance().get(`/systeammembers/getdraft`,isloading);
        res.data.systeammember = data.systeammember;
        
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysTeamMemberServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.systeam && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/systeams/${context.systeam}/systeammembers/${context.systeammember}/checkkey`,data,isloading);
            
            return res;
        }
        if(context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/checkkey`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/systeammembers/${context.systeammember}/checkkey`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysTeamMemberServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/save`,data,isloading);
            
            return res;
        }
        if(context.sysorganization && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/save`,data,isloading);
            
            return res;
        }
        if(context.sysdepartment && context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/save`,data,isloading);
            
            return res;
        }
        if(context.systeam && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/systeams/${context.systeam}/systeammembers/${context.systeammember}/save`,data,isloading);
            
            return res;
        }
        if(context.sysemployee && context.systeammember){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/sysemployees/${context.sysemployee}/systeammembers/${context.systeammember}/save`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/systeammembers/${context.systeammember}/save`,data,isloading);
            
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SysTeamMemberServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.sysorganization && context.sysdepartment && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysorganization && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysorganizations/${context.sysorganization}/sysemployees/${context.sysemployee}/systeammembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysdepartment && context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysdepartments/${context.sysdepartment}/sysemployees/${context.sysemployee}/systeammembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.systeam && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/systeams/${context.systeam}/systeammembers/fetchdefault`,tempData,isloading);
            return res;
        }
        if(context.sysemployee && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/sysemployees/${context.sysemployee}/systeammembers/fetchdefault`,tempData,isloading);
            return res;
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = Http.getInstance().get(`/systeammembers/fetchdefault`,tempData,isloading);
        return res;
    }
}