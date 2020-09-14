import { PanelDetailModel } from './panel-detail';

/**
 * 用户控件模型
 *
 * @export
 * @class PanelControlModel
 * @extends {PanelDetailModel}
 */
export class PanelControlModel extends PanelDetailModel {


    constructor(otps:any = {}) {
        super(otps);
    }
}