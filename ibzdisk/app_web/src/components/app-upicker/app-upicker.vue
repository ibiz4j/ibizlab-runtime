<template>
		<el-select style="width: 100%;" size='small' @change="onSelect" v-model="value" :disabled="disabled" @visible-change="onSelectOpen">
			<el-option v-for="(item, index) in items" :key="index" :label="item.label" :value="item.value"></el-option>
		</el-select>
</template>

<script lang="ts">
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";
import { Subject } from "rxjs";
import { AppModal } from "@/utils";

@Component({})
export default class AppPicker extends Vue {

	/**
     * 表单数据
     *
     * @type {*}
     * @memberof AppPicker
     */
	@Prop() public data!: any;

	/**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppPicker
     */
    @Prop() public name!: string;
	
	/**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public context!: any;
	
	/**
	 * 编辑器禁用
	 *
	 * @type {boolean}
	 * @memberof AppUpicker
	 */
	@Prop() disabled?: boolean;

	/**
     * 视图参数
     *
     * @type {*}
     * @memberof SelectFormBase
     */
    @Prop() public viewparams: any;

	/**
	 * 请求参数和请求数据的映射关系
	 *
	 * @type {*}
	 * @memberof AppUpicker
	 */
	public interaction:any = {};

	/**
	 * 当前表单项绑定的值
	 *
	 * @type {string}
	 * @memberof AppUpicker
	 */
	public value: string = "";

	/**
	 * 编辑器参数
	 *
	 * @type {*}
	 * @memberof AppUpicker
	 */
	@Prop() public itemParams?: any;

	/**
	 * 编辑器参数
	 *
	 * @type {string}
	 * @memberof AppUpicker
	 */
	@Prop() public valueItem?: string;

	/**
	 * 列表项请求路径
	 *
	 * @type {string}
	 * @memberof AppUpicker
	 */
	public url: string = '';

	/**
	 * 下拉数组
	 * @type {any[]}
	 * @memberof AppPicker
	 */
	public items: any[] = [];

	/**
	 * 请求到的数据
	 * @type {any[]}
	 * @memberof AppPicker
	 */
	public itemList: any[] = [{a:1,b:"zhangsan"},{a:2,b:"lisi"},{a:3,b:"wangwu"}]

    /**
     * vue 生命周期
     *
     * @memberof AppPicker
     */
	public mounted() {
        // 解析编辑器参数
		this.analysis(this.itemParams);
        // 请求下拉数据
        this.fectchItemList(this.url);
	}

	/**
     * 下拉重新加载数据
     *
     * @memberof AppPicker
     */
	public onSelectOpen() {
		this.fectchItemList(this.url);
	}

	/**
	 * 解析编辑器参数
	 * @param {*} itemparams
	 * @memberof AppPicker
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
	 * @memberof AppPicker
	 */
	public fectchItemList(url:string) {
		this.$http
			.get(url)
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
	 * @memberof AppPicker
	 */
	public extractItem(itemList:any[],items:any[]) {
		this.items.length = 0;
		itemList.forEach((item) => {
			items.push({
				label: item[this.interaction.label],
				value: item[this.interaction.value],
			});
		});
	}
	
	public onSelect(val: string) {
        let index = this.items.findIndex((item) => Object.is(item.value, val));
        if (index >= 0) {
            this.onACSelect(this.items[index]);
        }
	}

	/**
     * 选中数据回调
     * @param item 
     */
    public onACSelect(item: any): void {
		if(this.name){
			this.$emit('formitemvaluechange', { name: this.name, value: item.value });
		}
		if(this.valueItem){
			this.$emit('formitemvaluechange', { name: this.valueItem, value: item.value });
		}
    }
}
</script>
<style lang="less">
@import './app-upicker.less';
</style>
