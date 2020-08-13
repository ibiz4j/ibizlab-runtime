import AuthService from '../auth-service';

/**
 * 人员权限服务对象基类
 *
 * @export
 * @class IBZEmployeeAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZEmployeeAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  IBZEmployeeAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZEmployeeAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof IBZEmployeeAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}