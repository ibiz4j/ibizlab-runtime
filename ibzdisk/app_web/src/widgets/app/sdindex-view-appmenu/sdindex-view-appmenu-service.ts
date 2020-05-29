import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import SDIndexViewModel from './sdindex-view-appmenu-model';


/**
 * SDIndexView 部件服务对象
 *
 * @export
 * @class SDIndexViewService
 */
export default class SDIndexViewService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof SDIndexViewService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of SDIndexViewService.
     * 
     * @param {*} [opts={}]
     * @memberof SDIndexViewService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new SDIndexViewModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof SDIndexView
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/sdindex-viewappmenu', params);
    }

}