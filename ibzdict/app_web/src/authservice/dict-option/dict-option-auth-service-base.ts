import AuthService from '../auth-service';

/**
 * 字典项权限服务对象基类
 *
 * @export
 * @class DictOptionAuthServiceBase
 * @extends {AuthService}
 */
export default class DictOptionAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  DictOptionAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  DictOptionAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof DictOptionAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}