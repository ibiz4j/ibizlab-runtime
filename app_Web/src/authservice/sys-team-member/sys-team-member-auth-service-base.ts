import AuthService from '../auth-service';

/**
 * 组成员权限服务对象基类
 *
 * @export
 * @class SysTeamMemberAuthServiceBase
 * @extends {AuthService}
 */
export default class SysTeamMemberAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  SysTeamMemberAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysTeamMemberAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof SysTeamMemberAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        let copyDefaultOPPrivs:any = JSON.parse(JSON.stringify(curDefaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        // 统一资源优先
        Object.keys(curDefaultOPPrivs).forEach((name:string) => {
            if(this.sysOPPrivsMap.get(name) && copyDefaultOPPrivs[name] === 0){
                curDefaultOPPrivs[name] = copyDefaultOPPrivs[name];
            }
        });
        return curDefaultOPPrivs;
    }

}