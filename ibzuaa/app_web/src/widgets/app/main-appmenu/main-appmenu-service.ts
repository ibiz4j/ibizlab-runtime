import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import MainModel from './main-appmenu-model';


/**
 * Main 部件服务对象
 *
 * @export
 * @class MainService
 */
export default class MainService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof MainService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of MainService.
     * 
     * @param {*} [opts={}]
     * @memberof MainService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new MainModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof Main
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/mainappmenu', params);
    }

}