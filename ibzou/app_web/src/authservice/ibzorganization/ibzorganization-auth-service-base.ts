import AuthService from '../auth-service';
import IBZOrganizationUIService from '@/uiservice/ibzorganization/ibzorganization-ui-service';

/**
 * 单位机构权限服务对象基类
 *
 * @export
 * @class IBZOrganizationAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZOrganizationAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof IBZOrganizationAuthServiceBase
     */
    public ibzorganizationUIService:any;

    /**
     * Creates an instance of  IBZOrganizationAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZOrganizationAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.ibzorganizationUIService = new IBZOrganizationUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof IBZOrganizationAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.ibzorganizationUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}