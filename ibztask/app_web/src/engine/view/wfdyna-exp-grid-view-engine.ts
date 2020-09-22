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
            if(!res || res.length === 0) {
                return;
            }
            if(!this.view.isformDruipart){
                super.load(opts, isnotify);
            }else{
                if(isnotify){
                    super.load(opts, isnotify);
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
            return;
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

    /**
     * 选中变化
     *
     * @param {any[]} args
     * @memberof WFDynaExpGridViewEngine
     */
    public selectionChange(args: any[]): void {
        if (this.view) {
            this.view.selectedData = args;
            this.view.$emit('viewdataschange', args);
        }
        const state = args.length > 0 && !Object.is(args[0].srfkey, '') ? false : true;
        this.calcToolbarItemState(state);
    }

    /**
     * 计算工具栏状态
     *
     * @param {boolean} state
     * @param {*} [dataaccaction]
     * @memberof WFDynaExpGridViewEngine
     */
    public calcToolbarItemState(state: boolean, dataaccaction?: any) {
        const _this: any = this;
        if (!_this.view.linkModel || Object.keys(_this.view.linkModel).length === 0) {
            return;
        }
        _this.view.linkModel.forEach((item:any) => {
            item.disabled = state;
        });
        this.view.$forceUpdate();
    }
}