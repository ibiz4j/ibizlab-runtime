import GridViewEngine from './grid-view-engine';

/**
 * 视图引擎基础
 *
 * @export
 * @class WFDynaExpGridViewEngine
 * @extends {GridViewEngine}
 */
export default class WFDynaExpGridViewEngine extends GridViewEngine {

    /**
     * Creates an instance of WFDynaExpGridViewEngine.
     * @memberof WFDynaExpGridViewEngine
     */
    constructor() {
        super();
    }
    
    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof WFDynaExpGridViewEngine
     */
    public load(opts: any = {},isnotify:boolean=false): void {
        this.view.getWFStepModel().then((res:any) =>{
            if(!this.view.isformDruipart){
                super.load(opts);
            }else{
                if(isnotify){
                    super.load(opts);
                }
            }
        })
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof WFDynaExpGridViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'grid')) {
            this.GridEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }

    /**
     * 事件处理
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof WFDynaExpGridViewEngine
     */
    public GridEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'load')) {
            this.GridLoad(args);
        }
        super.MDCtrlEvent(eventName, args);
    }

    /**
     * 表格加载完成
     *
     * @param {any[]} args
     * @memberof WFDynaExpGridViewEngine
     */
    public GridLoad(args: any[]) {
        this.view.getWFStepModel();
    }
}