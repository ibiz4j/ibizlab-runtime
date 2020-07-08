import AuthService from '../auth-service';
import SDFileUIService from '@/uiservice/sdfile/sdfile-ui-service';

/**
 * 文件权限服务对象基类
 *
 * @export
 * @class SDFileAuthServiceBase
 * @extends {AuthService}
 */
export default class SDFileAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof SDFileAuthServiceBase
     */
    public sdfileUIService:any;

    /**
     * Creates an instance of  SDFileAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SDFileAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.sdfileUIService = new SDFileUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof SDFileAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.sdfileUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}