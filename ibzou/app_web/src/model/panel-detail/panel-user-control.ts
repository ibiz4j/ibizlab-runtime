import { PanelDetailModel } from './panel-detail';

/**
 * 用户控件模型
 *
 * @export
 * @class PanelUserControlModel
 * @extends {PanelDetailModel}
 */
export class PanelUserControlModel extends PanelDetailModel {


    constructor(otps:any = {}) {
        super(otps);
    }
}