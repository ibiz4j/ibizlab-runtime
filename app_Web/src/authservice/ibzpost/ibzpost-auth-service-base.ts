import AuthService from '../auth-service';
import IBZPostUIService from '@/uiservice/ibzpost/ibzpost-ui-service';

/**
 * 岗位权限服务对象基类
 *
 * @export
 * @class IBZPostAuthServiceBase
 * @extends {AuthService}
 */
export default class IBZPostAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof IBZPostAuthServiceBase
     */
    public ibzpostUIService:any;

    /**
     * Creates an instance of  IBZPostAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZPostAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.ibzpostUIService = new IBZPostUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof IBZPostAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.ibzpostUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}