import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PayIndexViewModel from './pay-index-view-appmenu-model';


/**
 * PayIndexView 部件服务对象
 *
 * @export
 * @class PayIndexViewService
 */
export default class PayIndexViewService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof PayIndexViewService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of PayIndexViewService.
     * 
     * @param {*} [opts={}]
     * @memberof PayIndexViewService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new PayIndexViewModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof PayIndexView
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/pay-index-viewappmenu', params);
    }

}