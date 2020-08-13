<template>
    <div class='app-upicker'>
        <el-select ref="appUpicker" :value="refvalue" size='small' filterable
            @change="onSelect" :disabled="disabled" style='width:100%;' clearable
            @clear="onClear" @visible-change="onSelectOpen">
            <template v-if="items">
                <el-option v-for="(_item,index) in items" :key="index" :value="_item.value" :label="_item.label"></el-option>
            </template>
        </el-select>
		<span style='position: absolute;right: 5px;color: #c0c4cc;top:0;font-size: 13px;'>
            <i v-show="open" class='el-icon-arrow-up' @click="closeDropdown"></i> 
			<i v-show="!open" class='el-icon-arrow-down' @click="openDropdown"></i> 
        </span>
    </div>
</template>

<script lang = 'ts'>
import { Component, Vue, Prop, Model, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { AppModal } from '@/utils';

@Component({
})
export default class AppUpicker extends Vue {

	/**
	 * 请求到的数据
	 * @type {any[]}
	 * @memberof AppUpicker
	 */
	public itemList: any[] = []

	/**
	 * 列表项请求路径
	 *
	 * @type {string}
	 * @memberof AppUpicker
	 */
	public url: string = '';

	/**
	 * 请求参数和请求数据的映射关系
	 *
	 * @type {*}
	 * @memberof AppUpicker
	 */
	public interaction:any = {};

	/**
	 * 编辑器参数
	 *
	 * @type {*}
	 * @memberof AppUpicker
	 */
	@Prop() public itemParams?: any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppUpicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppUpicker
     */
    @Prop() public viewparams!: any;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppUpicker
     */
    @Prop() public data!: any;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppUpicker
     */
    @Prop() public name!: string;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof AppUpicker
     */
    @Prop() public disabled?: boolean;

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof AppUpicker
     */
    @Prop({default:true}) public showButton?: boolean;

    /**
     * 局部上下文导航参数
     * 
     * @type {any}
     * @memberof AppUpicker
     */
    @Prop() public localContext!:any;

    /**
     * 局部导航参数
     * 
     * @type {any}
     * @memberof AppUpicker
     */
    @Prop() public localParam!:any;

    /**
     * 值项名称
     *
     * @type {string}
     * @memberof AppUpicker
     */
    @Prop() public valueitem!: string;

    /**
     * 排序
     *
     * @type {string}
     * @memberof AppUpicker
     */
    @Prop() public sort?: string;

    /**
     * 值
     *
     * @type {*}
     * @memberof AppUpicker
     */
    @Model('change') public value?: any;

    /**
     * 当前值
     *
     * @type {string}
     * @memberof AppUpicker
     */
    public curvalue: string = '';

    /**
     * 下拉数组
     * @type {any[]}
     * @memberof AppUpicker
     */
    public items: any[] = [];

    /** 
     * 下拉图标指向状态管理
     * @type {boolean}
     * @memberof AppUpicker 
     */
    public open: boolean = false;

    /**
     * 输入状态
     *
     * @type {boolean}
     * @memberof AppUpicker
     */
    public inputState: boolean = false;

    /**
     * vue 生命周期
     *
     * @memberof AppUpicker
     */
    public created() {
		this.analysis(this.itemParams);
    }
    /**
     * 获取关联数据项值
     *
     * @readonly
     * @memberof AppUpicker
     */
    get refvalue() {
        if (this.valueitem && this.data) {
            return this.data[this.valueitem];
        }
        return this.curvalue;
    }

    /**
     * 展开下拉
     *
     * @memberof AppUpicker
     */
    public openDropdown() {
        const appUpicker: any = this.$refs.appUpicker;
        if(appUpicker) {
            appUpicker.focus();
        }
    }

    /**
     * 收起下拉
     *
     * @memberof AppUpicker
     */
    public closeDropdown() {
        const appUpicker: any = this.$refs.appUpicker;
        if(appUpicker) {
            appUpicker.blur();
        }
    }

    /**
     * 下拉切换回调
     * @param flag 
     * 
     * @memberof AppUpicker
     */
    public onSelectOpen(flag: boolean): void {
        this.open = flag;
        if (this.open) {
			this.fectchItemList(this.url);
        }
    }

    /**
     * 下拉选中
     *
     * @param {string} val
     * @memberof AppUpicker
     */
    public onSelect(val: string) {
        let index = this.items.findIndex((item) => Object.is(item.value, val));
        if (index >= 0) {
            let item:any = this.items[index];
            if (this.valueitem) {
                this.$emit('formitemvaluechange', { name: this.valueitem, value: item.value });
            }
            if (this.name) {
                this.$emit('formitemvaluechange', { name: this.name, value: item.label });
            }
        }
    }

    /**
     * 清除
     * 
     * @memberof AppUpicker
     */
    public onClear($event: any): void {
        if (this.valueitem) {
            this.$emit('formitemvaluechange', { name: this.valueitem, value: '' });
        }
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: '' });
        }
        this.$forceUpdate();
    }

    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppUpicker
     */
    @Watch('value',{immediate:true})
    public onValueChange(newVal: any, oldVal: any) {
        this.analysis(this.itemParams);
        if(newVal){
            this.curvalue = newVal;
            const value = this.data[this.valueitem];
            const index = this.items.findIndex((item: any) => Object.is(item.value, value));
            if (index !== -1) {
                return;
            }
            this.items = [];
            if (value) {
                this.items.push({text: newVal, value: value});
            }
        }
    }
	
	/**
	 * 解析编辑器参数
	 * @param {*} itemparams
     * 
	 * @memberof AppUpicker
	 */
    public analysis(itemparams:any) {
		Object.keys(itemparams).forEach((param)=>{
			if(param==='path'){
				this.url = itemparams[param]
			}else{
				this.interaction[param] = itemparams[param]
			}
        })
    }

	/**
	 * 请求下拉列表数据
	 * @param {string} url
     * 
	 * @memberof AppUpicker
	 */
	public fectchItemList(url:string) {
        let arg:any = {};
        this.handlePublicParams(arg);
		this.$http
			.get(url,arg.param)
			.then((response: any) => {
				if (response && response.status==200 && response.data) {
					this.itemList = response.data;
					// 提取需要的值（value，label）
					this.extractItem(this.itemList,this.items);
				}
			})
			.catch((response: any) => {
				if (!response || !response.status || !response.data) {
					this.$Notice.error({
						title: this.$t("app.commonWords.error") as string,
						desc: this.$t("app.commonWords.sysException") as string,
					});
					return;
				}
			});
	}

	/**
	 * 解析下拉列表数据
	 * @param {any[]} itemList 请求到的数据
	 * @param {any[]} items 下拉数组
     * 
     * @memberof AppUpicker
	 */
	public extractItem(itemList:any[],items:any[]) {
		this.items = [];
		itemList.forEach((item) => {
			this.items.push({
				label: item[this.interaction.label],
				value: item[this.interaction.value],
			});
        });
	}

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof AppUpicker
     */
    public handlePublicParams(arg: any): boolean {
        if (!this.data) {
            this.$Notice.error({ title: (this.$t('components.appPicker.error') as any), desc: (this.$t('components.appPicker.formdataException') as any) });
            return false;
        }
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.data,arg.context,arg.param,this.localContext);
            Object.assign(arg.context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.data,arg.param,arg.param,this.localParam);
            Object.assign(arg.param,_param);
        }
        return true;
    }
}
</script>
<style lang="less">
@import './app-upicker.less';
</style>
