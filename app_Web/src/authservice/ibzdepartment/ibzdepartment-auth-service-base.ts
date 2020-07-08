import AuthService from '../auth-service';
import IBZDepartmentUIService from '@/uiservice/ibzdepartment/ibzdepartment-ui-service';

/**
 * 部门权限服务对象基类
 *
 * @export
 * @class IBZDepartmentAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZDepartmentAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof IBZDepartmentAuthServiceBase
     */
    public ibzdepartmentUIService:any;

    /**
     * Creates an instance of  IBZDepartmentAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZDepartmentAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.ibzdepartmentUIService = new IBZDepartmentUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof IBZDepartmentAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.ibzdepartmentUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}