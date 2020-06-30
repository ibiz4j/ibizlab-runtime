import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 组服务对象基类
 *
 * @export
 * @class IBZTeamServiceBase
 * @extends {EntityServie}
 */
export default class IBZTeamServiceBase extends EntityService {

    /**
     * Creates an instance of  IBZTeamServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZTeamServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof IBZTeamServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='ibzteam';
        this.APPDEKEY = 'teamid';
        this.APPDENAME = 'ibzteams';
        this.APPDETEXT = 'teamname';
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
     * @memberof IBZTeamServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().get(`/ibzteams/${context.ibzteam}/select`,isloading);
        return res;
    }

    /**
     * Create接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamServiceBase
     */
    public async Create(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ibzteammembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzteammembers'),'undefined')){
            ibzteammembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzteammembers') as any);
            if(ibzteammembersData && ibzteammembersData.length && ibzteammembersData.length > 0){
                ibzteammembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.teammemberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzteammembers = ibzteammembersData;
        Object.assign(data,masterData);
        if(!data.srffrontuf || data.srffrontuf !== "1"){
            data[this.APPDEKEY] = null;
        }
        if(data.srffrontuf){
            delete data.srffrontuf;
        }
        let tempContext:any = JSON.parse(JSON.stringify(context));
        let res:any = await Http.getInstance().post(`/ibzteams`,data,isloading);
        this.tempStorage.setItem(tempContext.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers));
        return res;
    }

    /**
     * Update接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamServiceBase
     */
    public async Update(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ibzteammembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzteammembers'),'undefined')){
            ibzteammembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzteammembers') as any);
            if(ibzteammembersData && ibzteammembersData.length && ibzteammembersData.length > 0){
                ibzteammembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.teammemberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzteammembers = ibzteammembersData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().put(`/ibzteams/${context.ibzteam}`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers));
        return res;
    }

    /**
     * Remove接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamServiceBase
     */
    public async Remove(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().delete(`/ibzteams/${context.ibzteam}`,isloading);
        return res;
    }

    /**
     * Get接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamServiceBase
     */
    public async Get(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().get(`/ibzteams/${context.ibzteam}`,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers));
        return res;
    }

    /**
     * GetDraft接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamServiceBase
     */
    public async GetDraft(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await  Http.getInstance().get(`/ibzteams/getdraft`,isloading);
        res.data.ibzteam = data.ibzteam;
            this.tempStorage.setItem(context.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers));
        return res;
    }

    /**
     * CheckKey接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamServiceBase
     */
    public async CheckKey(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let res:any = await Http.getInstance().post(`/ibzteams/${context.ibzteam}/checkkey`,data,isloading);
        return res;
    }

    /**
     * Save接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamServiceBase
     */
    public async Save(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let masterData:any = {};
        let ibzteammembersData:any = [];
        if(!Object.is(this.tempStorage.getItem(context.srfsessionkey+'_ibzteammembers'),'undefined')){
            ibzteammembersData = JSON.parse(this.tempStorage.getItem(context.srfsessionkey+'_ibzteammembers') as any);
            if(ibzteammembersData && ibzteammembersData.length && ibzteammembersData.length > 0){
                ibzteammembersData.forEach((item:any) => {
                    if(item.srffrontuf){
                        if(Object.is(item.srffrontuf,"0")){
                            item.teammemberid = null;
                        }
                        delete item.srffrontuf;
                    }
                });
            }
        }
        masterData.ibzteammembers = ibzteammembersData;
        Object.assign(data,masterData);
            let res:any = await  Http.getInstance().post(`/ibzteams/${context.ibzteam}/save`,data,isloading);
            this.tempStorage.setItem(context.srfsessionkey+'_ibzteammembers',JSON.stringify(res.data.ibzteammembers));
        return res;
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof IBZTeamServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        let res:any = await Http.getInstance().get(`/ibzteams/fetchdefault`,tempData,isloading);
        return res;
    }
}