import MDViewEngine from './md-view-engine';


/**
 * 视图引擎基础
 *
 * @export
 * @class GridViewEngine
 * @extends {MDViewEngine}
 */
export default class MapViewEngine extends MDViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof GridViewEngine
     */
    protected map: any;

    /**
     * Creates an instance of GridViewEngine.
     * @memberof MapViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof MapViewEngine
     */
    public init(options: any = {}): void {
        this.map = options.map;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof MapViewEngine
     */
    public load(opts: any = {},isnotify:boolean=false): void {
        if(!this.view.isformDruipart){
            super.load(opts, isnotify);
        }else{
            if(isnotify){
                super.load(opts, isnotify);
            }
        }
    }


    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof MapViewEngine
     */
    public getMDCtrl(): any {
        return this.map;
    }


}