import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import OUIndexViewModel from './ouindex-view-appmenu-model';


/**
 * OUIndexView 部件服务对象
 *
 * @export
 * @class OUIndexViewService
 */
export default class OUIndexViewService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof OUIndexViewService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of OUIndexViewService.
     * 
     * @param {*} [opts={}]
     * @memberof OUIndexViewService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new OUIndexViewModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof OUIndexView
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/ouindex-viewappmenu', params);
    }

}