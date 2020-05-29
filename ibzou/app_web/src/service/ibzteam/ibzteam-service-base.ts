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
     * @memberof IBZTeamServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/ibzteams/${context.ibzteam}/select`,isloading);
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
        return Http.getInstance().get(`/ibzteams/select`,tempData,isloading);
    }
}