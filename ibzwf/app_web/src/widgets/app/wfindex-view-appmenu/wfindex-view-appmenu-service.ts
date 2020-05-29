import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import WFIndexViewModel from './wfindex-view-appmenu-model';


/**
 * WFIndexView 部件服务对象
 *
 * @export
 * @class WFIndexViewService
 */
export default class WFIndexViewService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof WFIndexViewService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of WFIndexViewService.
     * 
     * @param {*} [opts={}]
     * @memberof WFIndexViewService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new WFIndexViewModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof WFIndexView
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/wfindex-viewappmenu', params);
    }

}