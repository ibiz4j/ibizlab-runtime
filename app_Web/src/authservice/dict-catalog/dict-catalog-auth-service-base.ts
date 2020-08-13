import AuthService from '../auth-service';

/**
 * 字典权限服务对象基类
 *
 * @export
 * @class DictCatalogAuthServiceBase
 * @extends {AuthService}
 */
export default class DictCatalogAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  DictCatalogAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  DictCatalogAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof DictCatalogAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}