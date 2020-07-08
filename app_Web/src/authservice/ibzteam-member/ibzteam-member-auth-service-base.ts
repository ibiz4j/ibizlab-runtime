import AuthService from '../auth-service';
import IBZTeamMemberUIService from '@/uiservice/ibzteam-member/ibzteam-member-ui-service';

/**
 * 组成员权限服务对象基类
 *
 * @export
 * @class IBZTeamMemberAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZTeamMemberAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof IBZTeamMemberAuthServiceBase
     */
    public ibzteammemberUIService:any;

    /**
     * Creates an instance of  IBZTeamMemberAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZTeamMemberAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.ibzteammemberUIService = new IBZTeamMemberUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof IBZTeamMemberAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.ibzteammemberUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}