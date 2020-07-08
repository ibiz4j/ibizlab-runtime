import AuthService from '../auth-service';
import DictCatalogUIService from '@/uiservice/dict-catalog/dict-catalog-ui-service';

/**
 * 字典权限服务对象基类
 *
 * @export
 * @class DictCatalogAuthServiceBase
 * @extends {AuthService}
 */
export default class DictCatalogAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof DictCatalogAuthServiceBase
     */
    public dictcatalogUIService:any;

    /**
     * Creates an instance of  DictCatalogAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  DictCatalogAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.dictcatalogUIService = new DictCatalogUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof DictCatalogAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.dictcatalogUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}