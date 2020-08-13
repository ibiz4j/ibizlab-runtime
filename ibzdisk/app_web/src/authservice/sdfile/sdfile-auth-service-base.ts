import AuthService from '../auth-service';

/**
 * 文件权限服务对象基类
 *
 * @export
 * @class SDFileAuthServiceBase
 * @extends {AuthService}
 */
export default class SDFileAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  SDFileAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SDFileAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof SDFileAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}