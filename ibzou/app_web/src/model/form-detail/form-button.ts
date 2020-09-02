import { FormDetailModel } from './form-detail';

/**
 * 按钮模型
 *
 * @export
 * @class FormButtonModel
 * @extends {FormDetailModel}
 */
export class FormButtonModel extends FormDetailModel {

    constructor(opts: any = {}) {
        super(opts);
        this.$disabled = opts.disabled;
        this.uiaction = opts.uiaction;
    }

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof FormButtonModel
     */
    private $disabled:boolean = false;

    /**
     * 按钮对应的界面行为
     *
     * @type {*}
     * @memberof FormButtonModel
     */
    public uiaction:any;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof FormButtonModel
     */
    public get disabled(): boolean {
        return this.$disabled;
    }

    /**
     * 设置是否启用
     *
     * @memberof FormButtonModel
     */
    public set disabled(val: boolean) {
        if(this.isPower) {
            this.$disabled = val;
        }
    }


}