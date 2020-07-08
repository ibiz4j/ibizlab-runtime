import AuthService from '../auth-service';
import DictOptionUIService from '@/uiservice/dict-option/dict-option-ui-service';

/**
 * 字典项权限服务对象基类
 *
 * @export
 * @class DictOptionAuthServiceBase
 * @extends {AuthService}
 */
export default class DictOptionAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof DictOptionAuthServiceBase
     */
    public dictoptionUIService:any;

    /**
     * Creates an instance of  DictOptionAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  DictOptionAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.dictoptionUIService = new DictOptionUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof DictOptionAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.dictoptionUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}