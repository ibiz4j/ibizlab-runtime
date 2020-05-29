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
        this.APPDETEXT = 'teammemberid';
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
            return Http.getInstance().get(`/ibzteammembers/${context.ibzteammember}/select`,isloading);
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
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/ibzteammembers/select`,tempData,isloading);
    }
}