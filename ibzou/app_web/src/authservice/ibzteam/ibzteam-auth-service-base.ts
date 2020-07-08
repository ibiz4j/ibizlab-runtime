import AuthService from '../auth-service';
import IBZTeamUIService from '@/uiservice/ibzteam/ibzteam-ui-service';

/**
 * 组权限服务对象基类
 *
 * @export
 * @class IBZTeamAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZTeamAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof IBZTeamAuthServiceBase
     */
    public ibzteamUIService:any;

    /**
     * Creates an instance of  IBZTeamAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZTeamAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.ibzteamUIService = new IBZTeamUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof IBZTeamAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.ibzteamUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}