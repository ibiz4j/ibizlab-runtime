/**
 * 表单成员模型
 *
 * @export
 * @class PanelDetailModel
 */
export class PanelDetailModel {

    /**
     * 是否有权限
     *
     * @type {boolean}
     * @memberof PanelDetailModel
     */
    public isPower: boolean = true;

    /**
     * 成员标题
     *
     * @type {string}
     * @memberof PanelDetailModel
     */
    public caption: string = '';

    /**
     * 成员类型
     *
     * @type {string}
     * @memberof PanelDetailModel
     */
    public itemType: string = '';

    /**
     * 面板对象
     *
     * @type {*}
     * @memberof PanelDetailModel
     */
    public panel: any = null;

    /**
     * 成员名称
     *
     * @type {string}
     * @memberof PanelDetailModel
     */
    public name: string = '';

    /**
     * 成员是否显示
     *
     * @type {boolean}
     * @memberof PanelDetailModel
     */
    public $visible: boolean = true;

    /**
     * 成员是否显示(旧)
     *
     * @type {boolean}
     * @memberof PanelDetailModel
     */
    public oldVisible: boolean = true;

    /**
     * 成员是否显示标题
     *
     * @type {boolean}
     * @memberof PanelDetailModel
     */
    public isShowCaption: boolean = true;
    

    /**
     * Creates an instance of PanelDetailModel.
     * PanelDetailModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof PanelDetailModel
     */
    constructor(opts: any = {}) {
        this.caption = !Object.is(opts.caption, '') ? opts.caption : '';
        this.itemType = !Object.is(opts.itemType, '') ? opts.itemType : '';
        this.panel = opts.panel ? opts.panel : {};
        this.name = !Object.is(opts.name, '') ? opts.name : '';
        this.$visible = opts.visible ? true : false;
        this.oldVisible = opts.visible ? true : false;
        this.isShowCaption = opts.isShowCaption ? true : false;
    }

    /**
     * 设置成员是否隐藏
     *
     * @memberof PanelDetailModel
     */
    public set visible(val: boolean) {
        if(this.isPower) {
            this.$visible = val;
        }
    }

    /**
     * 获取成员是否隐藏
     *
     * @memberof PanelDetailModel
     */
    public get visible() {
        return  this.$visible;
    }


    /**
     * 设置显示与隐藏
     *
     * @param {boolean} state
     * @memberof PanelDetailModel
     */
    public setVisible(state: boolean): void {
        if(this.isPower) {
            this.visible = state;
        }
    }

    /**
     * 设置显示标题栏
     *
     * @param {boolean} state
     * @memberof PanelDetailModel
     */
    public setShowCaption(state: boolean): void {
        this.isShowCaption = state;
    }
}