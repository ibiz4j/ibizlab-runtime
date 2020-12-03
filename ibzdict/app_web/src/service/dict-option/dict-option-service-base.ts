import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 字典项服务对象基类
 *
 * @export
 * @class DictOptionServiceBase
 * @extends {EntityServie}
 */
export default class DictOptionServiceBase extends EntityService {

    /**
     * Creates an instance of  DictOptionServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  DictOptionServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof DictOptionServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='dictoption';
        this.APPDEKEY = 'value_key';
        this.APPDENAME = 'dictoptions';
        this.APPDETEXT = 'label';
        this.APPNAME = 'web';
        this.SYSTEMNAME = 'ibzdict';
    }

// 实体接口

    /**
     * Select接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && context.dictoption){
            let res:any = Http.getInstance().get(`/dictcatalogs/${context.dictcatalog}/dictoptions/${context.dictoption}/select`,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().get(`/dictoptions/${context.dictoption}/select`,isloading);
            
            return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && true){
            let masterData:any = {};
            Object.assign(data,masterData);
            if(!data.srffrontuf || data.srffrontuf !== "1"){
                data[this.APPDEKEY] = null;
            }
            if(data.srffrontuf){
                delete data.srffrontuf;
            }
            let tempContext:any = JSON.parse(JSON.stringify(context));
            let res:any = await Http.getInstance().post(`/dictcatalogs/${context.dictcatalog}/dictoptions`,data,isloading);
            
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
        let res:any = await Http.getInstance().post(`/dictoptions`,data,isloading);
        
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && context.dictoption){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().put(`/dictcatalogs/${context.dictcatalog}/dictoptions/${context.dictoption}`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/dictoptions/${context.dictoption}`,data,isloading);
            
            return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && context.dictoption){
            let res:any = Http.getInstance().delete(`/dictcatalogs/${context.dictcatalog}/dictoptions/${context.dictoption}`,isloading);
            return res;
        }
            let res:any = Http.getInstance().delete(`/dictoptions/${context.dictoption}`,isloading);
            return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && context.dictoption){
            let res:any = await Http.getInstance().get(`/dictcatalogs/${context.dictcatalog}/dictoptions/${context.dictoption}`,isloading);
            
            return res;
        }
            let res:any = await Http.getInstance().get(`/dictoptions/${context.dictoption}`,isloading);
            
            return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && true){
            let res:any = await Http.getInstance().get(`/dictcatalogs/${context.dictcatalog}/dictoptions/getdraft`,isloading);
            res.data.dictoption = data.dictoption;
            
            return res;
        }
        let res:any = await  Http.getInstance().get(`/dictoptions/getdraft`,isloading);
        res.data.dictoption = data.dictoption;
        
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && context.dictoption){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/dictcatalogs/${context.dictcatalog}/dictoptions/${context.dictoption}/checkkey`,data,isloading);
            
            return res;
        }
            let res:any = Http.getInstance().post(`/dictoptions/${context.dictoption}/checkkey`,data,isloading);
            return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && context.dictoption){
            let masterData:any = {};
            Object.assign(data,masterData);
            let res:any = await Http.getInstance().post(`/dictcatalogs/${context.dictcatalog}/dictoptions/${context.dictoption}/save`,data,isloading);
            
            return res;
        }
        let masterData:any = {};
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/dictoptions/${context.dictoption}/save`,data,isloading);
            
            return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            let res:any = Http.getInstance().get(`/dictcatalogs/${context.dictcatalog}/dictoptions/fetchdefault`,tempData,isloading);
            return res;
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = Http.getInstance().get(`/dictoptions/fetchdefault`,tempData,isloading);
        return res;
    }

    /**
     * searchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DictOptionServiceBase
     */
    public async searchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        if(context.dictcatalog && true){
            let tempData:any = JSON.parse(JSON.stringify(data));
            return await Http.getInstance().post(`/dictcatalogs/${context.dictcatalog}/dictoptions/searchdefault`,tempData,isloading);
        }
        let tempData:any = JSON.parse(JSON.stringify(data));
        return await Http.getInstance().post(`/dictoptions/searchdefault`,tempData,isloading);
    }
}