import AuthService from '../auth-service';

/**
 * 组成员权限服务对象基类
 *
 * @export
 * @class IBZTeamMemberAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZTeamMemberAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  IBZTeamMemberAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZTeamMemberAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof IBZTeamMemberAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}