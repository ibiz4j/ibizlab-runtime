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
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/select`,isloading);
        }
            return Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}/select`,isloading);
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
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments`,data,isloading);
        }
        let masterData:any = {};
        let ibzemployeesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzemployees'),'undefined')){
            ibzemployeesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzemployees') as any);
            if(ibzemployeesData && ibzemployeesData.length && ibzemployeesData.length > 0){
                ibzemployeesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.userid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzemployees = ibzemployeesData;
        let ibzdeptmembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzdeptmembers'),'undefined')){
            ibzdeptmembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzdeptmembers') as any);
            if(ibzdeptmembersData && ibzdeptmembersData.length && ibzdeptmembersData.length > 0){
                ibzdeptmembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.memberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzdeptmembers = ibzdeptmembersData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ibzdepartments`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers));
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
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}`,isloading);
        }
            let res:any = await Http.getInstance().get(`/ibzdepartments/${context.ibzdepartment}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
            this.tempStorage.setItem(context.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers));
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
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/save`,data,isloading);
        }
        let masterData:any = {};
        let ibzemployeesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzemployees'),'undefined')){
            ibzemployeesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzemployees') as any);
            if(ibzemployeesData && ibzemployeesData.length && ibzemployeesData.length > 0){
                ibzemployeesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.userid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzemployees = ibzemployeesData;
        let ibzdeptmembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzdeptmembers'),'undefined')){
            ibzdeptmembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzdeptmembers') as any);
            if(ibzdeptmembersData && ibzdeptmembersData.length && ibzdeptmembersData.length > 0){
                ibzdeptmembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.memberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzdeptmembers = ibzdeptmembersData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
            this.tempStorage.setItem(context.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers));
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
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}/checkkey`,data,isloading);
        }
            return Http.getInstance().post(`/ibzdepartments/${context.ibzdepartment}/checkkey`,data,isloading);
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
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/getdraft`,isloading);
        }
        let res:any = await  Http.getInstance().get(`/ibzdepartments/getdraft`,isloading);
        res.data.ibzdepartment = data.ibzdepartment;
            this.tempStorage.setItem(context.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
            this.tempStorage.setItem(context.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers));
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
            return Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}`,isloading);
        }
            return Http.getInstance().delete(`/ibzdepartments/${context.ibzdepartment}`,isloading);

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
            return Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/${context.ibzdepartment}`,data,isloading);
        }
        let masterData:any = {};
        let ibzemployeesData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzemployees'),'undefined')){
            ibzemployeesData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzemployees') as any);
            if(ibzemployeesData && ibzemployeesData.length && ibzemployeesData.length > 0){
                ibzemployeesData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.userid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzemployees = ibzemployeesData;
        let ibzdeptmembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzdeptmembers'),'undefined')){
            ibzdeptmembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzdeptmembers') as any);
            if(ibzdeptmembersData && ibzdeptmembersData.length && ibzdeptmembersData.length > 0){
                ibzdeptmembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.memberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzdeptmembers = ibzdeptmembersData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ibzdepartments/${context.ibzdepartment}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
            this.tempStorage.setItem(context.srfsessionkey+'_ibzdeptmembers',JSON.stringify(res.data.ibzdeptmembers));
            return res;
    }

    /**
     * FetchCurDept接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZDepartmentServiceBase
     */
    public async FetchCurDept(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.ibzorganization && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/fetchcurdept`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ibzdepartments/fetchcurdept`,tempData,isloading);
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
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/ibzdepartments/fetchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ibzdepartments/fetchdefault`,tempData,isloading);
    }
}