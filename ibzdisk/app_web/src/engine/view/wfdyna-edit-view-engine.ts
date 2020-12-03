import EditViewEngine from './edit-view-engine';

/**
 * 视图引擎基础
 *
 * @export
 * @class WFDynaEditViewEngine
 * @extends {EditViewEngine}
 */
export default class WFDynaEditViewEngine extends EditViewEngine {

    /**
     * Creates an instance of WFDynaEditViewEngine.
     * @memberof WFDynaEditViewEngine
     */
    constructor() {
        super();
    }
    
    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof WFDynaEditViewEngine
     */
    public load(opts: any = {}): void {
        if(this.view.getWFLinkModel && this.view.getWFLinkModel instanceof Function){
            this.view.getWFLinkModel();
        }
    }

}