import { FormDetailModel } from './form-detail';

/**
 * 分组面板模型
 *
 * @export
 * @class FormGroupPanelModel
 * @extends {FormDetailModel}
 */
export class FormGroupPanelModel extends FormDetailModel {

    /**
     * 实体界面行为组
     *
     * @type {*}
     * @memberof FormGroupPanelModel
     */
    public uiActionGroup: any = {};
    
    /**
     * 受控内容组
     *
     * @type {*}
     * @memberof FormGroupPanelModel
     */
    public showMoreModeItems: any = [];

    /**
     * 是否为管理容器
     *
     * @type {*}
     * @memberof FormGroupPanelModel
     */
    public isManageContainer: boolean = false;

    /**
     * 管理容器状态 true显示 false隐藏
     *
     * @type {*}
     * @memberof FormGroupPanelModel
     */
    public manageContainerStatus: boolean = true;

    /**
     * Creates an instance of FormGroupPanelModel.
     * 创建 FormGroupPanelModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof FormGroupPanelModel
     */
    constructor(opts: any = {}) {
        super(opts);
        Object.assign(this.uiActionGroup, opts.uiActionGroup);
        this.showMoreModeItems = opts.showMoreModeItems;
        this.isManageContainer = opts.isManageContainer ? true : false;
    }

    /**
     * 设置管理容器状态
     *
     * @param {boolean} state
     * @memberof FormGroupPanelModel
     */
    public setManageContainerStatus(state: boolean): void {
        this.manageContainerStatus = state;
    }
}