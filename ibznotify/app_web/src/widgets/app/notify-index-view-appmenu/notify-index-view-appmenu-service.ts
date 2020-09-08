import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import NotifyIndexViewModel from './notify-index-view-appmenu-model';


/**
 * NotifyIndexView 部件服务对象
 *
 * @export
 * @class NotifyIndexViewService
 */
export default class NotifyIndexViewService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof NotifyIndexViewService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of NotifyIndexViewService.
     * 
     * @param {*} [opts={}]
     * @memberof NotifyIndexViewService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new NotifyIndexViewModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof NotifyIndexView
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/notify-index-viewappmenu', params);
    }

}