import { PanelDetailModel } from './panel-detail';

/**
 * 按钮模型
 *
 * @export
 * @class PanelButtonModel
 * @extends {PanelDetailModel}
 */
export class PanelButtonModel extends PanelDetailModel {

    constructor(opts: any = {}) {
        super(opts);
        this.$disabled = opts.disabled;
        this.uiaction = opts.uiaction;
    }

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof PanelButtonModel
     */
    private $disabled:boolean = false;

    /**
     * 按钮对应的界面行为
     *
     * @type {*}
     * @memberof PanelButtonModel
     */
    public uiaction:any;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof PanelButtonModel
     */
    public get disabled(): boolean {
        return this.$disabled;
    }

    /**
     * 设置是否启用
     *
     * @memberof PanelButtonModel
     */
    public set disabled(val: boolean) {
        if(this.isPower) {
            this.$disabled = val;
        }
    }


}