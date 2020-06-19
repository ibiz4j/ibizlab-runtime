import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import TaskIndexViewModel from './task-index-view-appmenu-model';


/**
 * TaskIndexView 部件服务对象
 *
 * @export
 * @class TaskIndexViewService
 */
export default class TaskIndexViewService extends ControlService {

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof TaskIndexViewService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of TaskIndexViewService.
     * 
     * @param {*} [opts={}]
     * @memberof TaskIndexViewService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new TaskIndexViewModel();
    }

    /**
     * 获取数据
     *
     * @returns {Promise<any>}
     * @memberof TaskIndexView
     */
    @Errorlog
    public get(params: any = {}): Promise<any> {
        return Http.getInstance().get('v7/task-index-viewappmenu', params);
    }

}