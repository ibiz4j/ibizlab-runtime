/**
 * 表单成员模型
 *
 * @export
 * @class FormDetailModel
 */
export class FormDetailModel {

    /**
     * 是否有权限
     *
     * @type {boolean}
     * @memberof FormDetailModel
     */
    public isPower: boolean = true;

    /**
     * 成员标题
     *
     * @type {string}
     * @memberof FormDetailModel
     */
    public caption: string = '';

    /**
     * 成员类型
     *
     * @type {string}
     * @memberof FormDetailModel
     */
    public detailType: string = '';

    /**
     * 表单对象
     *
     * @type {*}
     * @memberof FormDetailModel
     */
    public form: any = null;

    /**
     * 成员名称
     *
     * @type {string}
     * @memberof FormDetailModel
     */
    public name: string = '';

    /**
     * 成员是否显示
     *
     * @type {boolean}
     * @memberof FormDetailModel
     */
    public $visible: boolean = true;

    /**
     * 成员是否显示(旧)
     *
     * @type {boolean}
     * @memberof FormDetailModel
     */
    public oldVisible: boolean = true;

   /**
     * 成员是否为受控内容
     *
     * @type {boolean}
     * @memberof FormDetailModel
     */
    public isControlledContent: boolean = false;

    /**
     * 成员是否显示标题
     *
     * @type {boolean}
     * @memberof FormDetailModel
     */
    public isShowCaption: boolean = true;
    

    /**
     * Creates an instance of FormDetailModel.
     * FormDetailModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof FormDetailModel
     */
    constructor(opts: any = {}) {
        this.caption = !Object.is(opts.caption, '') ? opts.caption : '';
        this.detailType = !Object.is(opts.detailType, '') ? opts.detailType : '';
        this.form = opts.form ? opts.form : {};
        this.name = !Object.is(opts.name, '') ? opts.name : '';
        this.$visible = opts.visible ? true : false;
        this.oldVisible = opts.visible ? true : false;
        this.isShowCaption = opts.isShowCaption ? true : false;
        this.isControlledContent = opts.isControlledContent ? true : false;
    }

    /**
     * 设置成员是否隐藏
     *
     * @memberof FormDetailModel
     */
    public set visible(val: boolean) {
        if(this.isPower) {
            this.$visible = val;
        }
    }

    /**
     * 获取成员是否隐藏
     *
     * @memberof FormDetailModel
     */
    public get visible() {
        return  this.$visible;
    }


    /**
     * 设置显示与隐藏
     *
     * @param {boolean} state
     * @memberof FormDetailModel
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
     * @memberof FormDetailModel
     */
    public setShowCaption(state: boolean): void {
        this.isShowCaption = state;
    }
}