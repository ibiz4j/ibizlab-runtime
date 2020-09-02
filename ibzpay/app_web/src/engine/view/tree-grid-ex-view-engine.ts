import MDViewEngine from './md-view-engine';


/**
 * 视图引擎基础
 *
 * @export
 * @class TreeGridExViewEngine
 * @extends {MDViewEngine}
 */
export default class TreeGridExViewEngine extends MDViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof TreeGridExViewEngine
     */
    protected treegridex: any;

    /**
     * Creates an instance of TreeGridExViewEngine.
     * @memberof TreeGridExViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof TreeGridExViewEngine
     */
    public init(options: any = {}): void {
        this.treegridex = options.treegridex;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof TreeGridExViewEngine
     */
    public load(opts: any = {},isnotify:boolean=false): void {
        if(!this.view.isformDruipart){
            super.load(opts);
        }else{
            if(isnotify){
                super.load(opts);
            }
        }
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof TreeGridExViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'treegridex')) {
            this.MDCtrlEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }


    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof TreeGridExViewEngine
     */
    public getMDCtrl(): any {
        return this.treegridex;
    }

    /**
     * 事件处理
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof TreeGridExViewEngine
     */
    public MDCtrlEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'rowdblclick') && this.gridRowAllowActive(2)) {
            this.doEdit(args);
            return;
        }
        if (Object.is(eventName, 'selectionchange')) {
            this.selectionChange(args);
            if (this.gridRowAllowActive(1)) {
                this.doEdit(args);
            }
            return;
        }
        super.MDCtrlEvent(eventName, args);
    }

    /**
     * 表格是否被允许激活
     *
     * @param {number} mode
     * @returns {boolean}
     * @memberof TreeGridExViewEngine
     */
    public gridRowAllowActive(mode: number): boolean {
        return this.view.gridRowActiveMode === mode ? true : false;
    }
}