import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 单位机构服务对象基类
 *
 * @export
 * @class IBZOrganizationServiceBase
 * @extends {EntityServie}
 */
export default class IBZOrganizationServiceBase extends EntityService {

    /**
     * Creates an instance of  IBZOrganizationServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZOrganizationServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof IBZOrganizationServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ibzorganization';
        this.APPDEKEY = 'orgid';
        this.APPDENAME = 'ibzorganizations';
        this.APPDETEXT = 'orgname';
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
     * @memberof IBZOrganizationServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}/select`,isloading);
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ibzdepartmentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzdepartments'),'undefined')){
            ibzdepartmentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzdepartments') as any);
            if(ibzdepartmentsData && ibzdepartmentsData.length && ibzdepartmentsData.length > 0){
                ibzdepartmentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.deptid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzdepartments = ibzdepartmentsData;
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzdepartments',JSON.stringify(res.data.ibzdepartments));
            this.tempStorage.setItem(context.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
            return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().post(`/ibzorganizations/${context.ibzorganization}/checkkey`,data,isloading);
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            let res:any = await Http.getInstance().get(`/ibzorganizations/${context.ibzorganization}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzdepartments',JSON.stringify(res.data.ibzdepartments));
            this.tempStorage.setItem(context.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
            return res;

    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ibzdepartmentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzdepartments'),'undefined')){
            ibzdepartmentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzdepartments') as any);
            if(ibzdepartmentsData && ibzdepartmentsData.length && ibzdepartmentsData.length > 0){
                ibzdepartmentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.deptid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzdepartments = ibzdepartmentsData;
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
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ibzorganizations`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzdepartments',JSON.stringify(res.data.ibzdepartments));
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().delete(`/ibzorganizations/${context.ibzorganization}`,isloading);

    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/ibzorganizations/getdraft`,isloading);
        res.data.ibzorganization = data.ibzorganization;
            this.tempStorage.setItem(context.srfsessionkey+'_ibzdepartments',JSON.stringify(res.data.ibzdepartments));
            this.tempStorage.setItem(context.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ibzdepartmentsData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzdepartments'),'undefined')){
            ibzdepartmentsData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzdepartments') as any);
            if(ibzdepartmentsData && ibzdepartmentsData.length && ibzdepartmentsData.length > 0){
                ibzdepartmentsData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.deptid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzdepartments = ibzdepartmentsData;
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
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ibzorganizations/${context.ibzorganization}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzdepartments',JSON.stringify(res.data.ibzdepartments));
            this.tempStorage.setItem(context.srfsessionkey+'_ibzemployees',JSON.stringify(res.data.ibzemployees));
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ibzorganizations/fetchdefault`,tempData,isloading);
    }

    /**
     * FetchSelectPOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async FetchSelectPOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ibzorganizations/fetchselectporg`,tempData,isloading);
    }

    /**
     * FetchSelectSOrg接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZOrganizationServiceBase
     */
    public async FetchSelectSOrg(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ibzorganizations/fetchselectsorg`,tempData,isloading);
    }
}