import IBZEmployeeAuthServiceBase from './ibzemployee-auth-service-base';


/**
 * 人员权限服务对象
 *
 * @export
 * @class IBZEmployeeAuthService
 * @extends {IBZEmployeeAuthServiceBase}
 */
export default class IBZEmployeeAuthService extends IBZEmployeeAuthServiceBase {

    /**
     * Creates an instance of  IBZEmployeeAuthService.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZEmployeeAuthService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}