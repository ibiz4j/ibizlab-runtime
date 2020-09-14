import { Store } from 'vuex';
import EntityService from '@/service/entity-service';


/**
 * 计数器服务基类
 *
 * @export
 * @class CounterService
 */
export default class CounterService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {(any | null)}
     * @memberof CounterService
     */
    private $store: Store<any> | null = null;
    
    /**
     * 当前计数器数据
     * 
     * @protected
     * @type {*}
     * @memberof  CounterService
     */
    protected counterData:any ={};

    /**
     * 应用实体数据服务
     *
     * @protected
     * @type {EntityService}
     * @memberof CounterService
     */    
    protected appEntityService:EntityService = new EntityService();

    /**
     * 当前计数器导航上下文
     * 
     * @protected
     * @type {*}
     * @memberof  CounterService
     */
    protected context:any ={};

    /**
     * 当前计数器导航参数
     * 
     * @protected
     * @type {*}
     * @memberof  CounterService
     */
    protected viewparams:any ={};

    /**
     * 当前计数器定时器对象
     * 
     * @protected
     * @type {*}
     * @memberof  CounterService
     */
    protected timer:any;

    /**
     * Creates an instance of CounterService.
     * 
     * @param {*} [opts={}]
     * @memberof CounterService
     */
    constructor(opts: any = {}) {
        this.$store = opts.$store;
        this.context = opts.context?opts.context:{};
        this.viewparams = opts.viewparams?opts.viewparams:{};
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof CounterService
     */
    public getStore(): Store<any> | null {
        return this.$store;
    }

    /**
     * 获取计数器服务
     *
     * @protected
     * @param {string} name 实体名称
     * @returns {Promise<any>}
     * @memberof CounterService
     */
    public getService(name: string): Promise<any> {
        return (window as any)['counterServiceRegister'].getService(name);
    }

    /**
     * 销毁计数器
     *
     * @memberof ActionCounterCounterServiceBase
     */
    public destroyCounter(){
        if(this.timer) clearInterval(this.timer);
    }
  
}