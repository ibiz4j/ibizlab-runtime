import AuthService from '../auth-service';
import IBZEmployeeUIService from '@/uiservice/ibzemployee/ibzemployee-ui-service';

/**
 * 人员权限服务对象基类
 *
 * @export
 * @class IBZEmployeeAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZEmployeeAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof IBZEmployeeAuthServiceBase
     */
    public ibzemployeeUIService:any;

    /**
     * Creates an instance of  IBZEmployeeAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZEmployeeAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.ibzemployeeUIService = new IBZEmployeeUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof IBZEmployeeAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.ibzemployeeUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}