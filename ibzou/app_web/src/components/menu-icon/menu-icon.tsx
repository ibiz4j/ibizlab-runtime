import { Vue, Component, Prop } from 'vue-property-decorator';
import './menu-icon.less';

/**
 * 平台菜单按钮适配
 *
 * @export
 * @class MenuIcon
 * @extends {Vue}
 */
@Component({})
export class MenuIcon extends Vue {

    /**
     * 项数据
     *
     * @type {*}
     * @memberof MenuIcon
     */
    @Prop()
    public item: any;

    /**
     * 绘制图标
     *
     * @returns {*}
     * @memberof MenuIcon
     */
    public render(): any {
        if (this.item) {
            if (this.item.iconcls) {
                return <i class={this.item.iconcls} />
            }
            if (this.item.icon) {
                return <img src={this.item.icon} />
            }
        }
        return <span />
    }

}