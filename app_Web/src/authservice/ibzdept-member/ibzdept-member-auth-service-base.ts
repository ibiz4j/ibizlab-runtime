import AuthService from '../auth-service';
import IBZDeptMemberUIService from '@/uiservice/ibzdept-member/ibzdept-member-ui-service';

/**
 * 部门成员权限服务对象基类
 *
 * @export
 * @class IBZDeptMemberAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZDeptMemberAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof IBZDeptMemberAuthServiceBase
     */
    public ibzdeptmemberUIService:any;

    /**
     * Creates an instance of  IBZDeptMemberAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZDeptMemberAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.ibzdeptmemberUIService = new IBZDeptMemberUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof IBZDeptMemberAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.ibzdeptmemberUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}