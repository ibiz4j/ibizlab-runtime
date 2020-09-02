import { PanelDetailModel } from './panel-detail';
import { PanelTabPanelModel } from './panel-tab-panel';

/**
 * 分页面板模型
 *
 * @export
 * @class PanelTabPageModel
 * @extends {PanelDetailModel}
 */
export class PanelTabPageModel extends PanelDetailModel {


    /**
     * Creates an instance of PanelTabPageModel.
     * PanelTabPageModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof PanelTabPageModel
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 设置分页是否启用
     *
     * @param {boolean} state
     * @memberof PanelTabPageModel
     */
    public setVisible(state: boolean): void {
        this.visible = state;
        const tabPanel = this.getTabPanelModel();
        if (tabPanel) {
            tabPanel.setActiviePage();
        }
    }

    /**
     * 获取分页面板
     *
     * @returns {(PanelTabPanelModel | null)}
     * @memberof PanelTabPageModel
     */
    public getTabPanelModel(): PanelTabPanelModel | null {
        if (!this.panel) {
            return null;
        }
        const tabPanels: any[] = Object.values(this.panel.detailsModel).filter((model: any) => Object.is(model.itemType, 'TABPANEL'));
        let index = tabPanels.findIndex((tabPanel: any) => {
            return tabPanel.tabPages.some((tabPag: any) => Object.is(tabPag.name, this.name));
        });
        if (index === -1) {
            return null;
        }
        const tabPanel: PanelTabPanelModel = tabPanels[index];
        return tabPanel;
    }
}