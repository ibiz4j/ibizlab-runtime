import AuthService from '../auth-service';

/**
 * 岗位权限服务对象基类
 *
 * @export
 * @class IBZPostAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZPostAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  IBZPostAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZPostAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof IBZPostAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}