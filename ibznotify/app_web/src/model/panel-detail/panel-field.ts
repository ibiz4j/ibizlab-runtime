import { PanelDetailModel } from './panel-detail';

/**
 * 面板属性项模型
 *
 * @export
 * @class PanelFieldModel
 * @extends {PanelDetailModel}
 */
export class PanelFieldModel extends PanelDetailModel {

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof PanelFieldModel
     */
    public disabled: boolean = false;

    /**
     * 错误信息
     *
     * @type {string}
     * @memberof PanelFieldModel
     */
    public error: string = '';

    /**
     * 表单项启用条件
     * 
     * 0 不启用
     * 1 新建
     * 2 更新
     * 3 全部启用
     *
     * @type {(number | 0 | 1 | 2 | 3)}
     * @memberof PanelFieldModel
     */
    public enableCond: number | 0 | 1 | 2 | 3 = 3;

    /**
     * Creates an instance of PanelFieldModel.
     * PanelFieldModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof PanelFieldModel
     */
    constructor(opts: any = {}) {
        super(opts);
        this.disabled = opts.disabled ? true : false;
        this.enableCond = opts.enableCond;
    }

    /**
     * 设置是否启用
     *
     * @param {boolean} state
     * @memberof PanelFieldModel
     */
    public setDisabled(state: boolean): void {
        this.disabled = state;
    }

    /**
     * 设置信息内容
     *
     * @param {string} error
     * @memberof PanelFieldModel
     */
    public setError(error: string): void {
        this.error = error;
    }

    /**
     * 设置是否启用
     *
     * @param {string} srfuf
     * @memberof PanelFieldModel
     */
    public setEnableCond(srfuf: string): void {
        // 是否有权限
        const isReadOk: boolean = true;
        const _srfuf: number = parseInt(srfuf, 10);
        let state: boolean = true;

        if (isReadOk) {
            if (_srfuf === 1) {
                if ((this.enableCond & 2) === 2) {
                    state = false;
                }
            } else {
                if ((this.enableCond & 1) === 1) {
                    state = false;
                }
            }
        }
        this.setDisabled(state);
    }

} 