<template>
    <div class="app-map-position">
        <el-input
            size="small"
            @focus="handleMapShow"
            v-model="value"
            :placeholder="placeholder ? placeholder : $t('components.appMapPosition.title')">
        </el-input>
        <el-dialog
            :title="$t('components.appMapPosition.title')"
            class="map-modal"
            :visible.sync="dialogShow">
            <div class="search-toolbar">
                <el-input id="map__search" size="small" @change="handleSearch" v-model="searchAddress" />
                <div id="map__result" class="content-result" v-show="resultShow"></div>
            </div>
            <div class="map__content">
                <el-amap
                    :center="center" 
                    :amap-manager="amapManager"
                    zoom="12"
                    :events="events"
                    ref="map">
                    <el-amap-marker
                        class="map-marker"
                        vid="component-marker"
                        :position="marker.position">
                        <div>
                            <img src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png">
                            <span class="input-map__marker">{{ marker.address }}</span>
                        </div>
                    </el-amap-marker>
                </el-amap>
                
            </div>
            <template slot="footer">
                <el-button
                    type="primary"
                    size="small"
                    @click="handleSubmit">
                    {{ $t('components.appMapPosition.submit') }}
                </el-button>
            </template>
        </el-dialog>
    </div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Watch, Model } from 'vue-property-decorator';
import { Subject, Subscription } from 'rxjs';
import { AMapManager } from 'vue-amap';

@Component({})
export default class AppMapPosition extends Vue  {
    
    /**
     * 双向绑定表单项值
     *
     * @type {*}
     * @memberof AppMapPosition
     */  
    @Model('change') public value: any;

    /**
     * 占位内容
     *
     * @type {*}
     * @memberof AppMapPosition
     */ 
    @Prop() public placeholder?: string;

    /**
     * 经度
     *
     * @type {*}
     * @memberof AppMapPosition
     */ 
    @Prop() public longitude?: any;

    /**
     * 纬度
     *
     * @type {*}
     * @memberof AppMapPosition
     */ 
    @Prop() public latitude?: any;

    /**
     * 地址
     *
     * @type {*}
     * @memberof AppMapPosition
     */ 
    @Prop() public address?: any;

    /**
     * 模式（address、longitude、latitude）
     *
     * @type {*}
     * @memberof AppMapPosition
     */ 
    @Prop({default: 'address'}) public mode: any;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    @Prop() public data: any;

    /**
     * 表单通讯对象
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    @Prop() public formState!: Subject<any>;

    /**
     * 搜索框显示值
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public searchAddress: string = '';

    /**
     * AMap SDK对象
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public amapManager: any = new AMapManager();

    /**
     * 地图中心点
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public center: any[] = [104.09427199999999, 30.660396];

    /**
     * 地图模态框显示状态
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public dialogShow: boolean = false;

    /**
     * 地图标点信息
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public marker: any = {};

    /**
     * 初始化地图标点
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public markerResult: any = {};

    /**
     * 事件集合
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public events: any = {};

    /**
     * 获取地址需求AMap插件对象
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public geocoder: any;

    /**
     * 当前 window
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public win: any;

    /**
     * 搜索结果显示框状态
     *
     * @type {*}
     * @memberof AppMapPosition
     */
    public resultShow: boolean = false;

    /**
     * Vue生命周期
     *
     * @memberof AppMapPosition
     */
    public created() {
        this.win = window as any;
        if(this.formState) {
            this.formState.subscribe(({ type, data }) => {
                if(Object.is('load', type)) {
                    this.initMap();
                }
            })
        }
    }

    /**
     * Vue生命周期
     *
     * @memberof AppMapPosition
     */
    public mounted() {
        let amap: any = this.win.AMap;
        amap.plugin(["AMap.Geocoder"], () => {
            this.geocoder = new amap.Geocoder({
                extensions: "all",
            })
        })
        this.initMapEvents();
    }

    /**
     * 根据当前模式初始化地图
     *
     * @memberof AppMapPosition
     */
    public initMap() {
        if(!this.mode) {
            return;
        }
        if(Object.is(this.mode, 'address')) {
            this.initByAddress()
        } else if(Object.is(this.mode, 'longitude')) {
            this.initByLng();
        } else if(Object.is(this.mode, 'latitude')) {
            this.initByLat();
        }
    }

    /**
     * mode = address，初始化地图
     *
     * @memberof AppMapPosition
     */
    public initByAddress() {
        if(this.longitude && this.latitude && this.data && this.value) {
            const position = [this.data[this.longitude], this.data[this.latitude]];
            Object.assign(this.marker, {
                position: position,
                address: this.value,
                visible: true
            });
            this.center = position;
            this.searchAddress = this.marker.address;
            Object.assign(this.markerResult, this.marker);
        } else {
            Object.assign(this.marker, {
                position: [104.09427199999999, 30.660396],
                address: '四川省成都市成华区猛追湾街道四川电视塔天府熊猫塔',
                visible: true
            })
            this.searchAddress = this.marker.address;
        }
    }

    /**
     * mode = longitude，初始化地图
     *
     * @memberof AppMapPosition
     */
    public initByLng() {
        if(this.latitude && this.data && this.value) {
            this.handleMarker(this.value, this.data[this.latitude], this);
        } else {
            Object.assign(this.marker, {
                position: [104.09427199999999, 30.660396],
                address: '四川省成都市成华区猛追湾街道四川电视塔天府熊猫塔',
                visible: true
            })
            this.searchAddress = this.marker.address;
        }
    }

    /**
     * mode = latitude，初始化地图
     *
     * @memberof AppMapPosition
     */
    public initByLat() {
        if(this.longitude && this.data && this.value) {
            this.handleMarker(this.data[this.longitude], this.value, this);
        } else {
           Object.assign(this.marker, {
                position: [104.09427199999999, 30.660396],
                address: '四川省成都市成华区猛追湾街道四川电视塔天府熊猫塔',
                visible: true
            })
            this.searchAddress = this.marker.address;
        }
    }

    /**
     * 初始化地图事件
     *
     * @memberof AppMapPosition
     */
    public initMapEvents() {
        const that: any = this;
        that.events = {
            click($event: any) {
                that.mapClick($event);
            },
            init($event: any) {
                that.map = $event;
            }
        };
    }

    /**
     * 展开模态框
     *
     * @memberof AppMapPosition
     */
    public handleMapShow() {
        this.resultShow = false;
        this.dialogShow = true;
        if(!this.markerResult || JSON.stringify(this.markerResult) == "{}") {
            return;
        }
        this.searchAddress = this.markerResult.address;
        Object.assign(this.marker, this.markerResult);
        this.center = this.markerResult.position;
    }
    
    /**
     * 处理地图标点
     * 
     * @param {*} lng 经度
     * @param {*} lat 纬度
     * @param {*} that this指针
     * @param {boolean} flag 是否更新结果集
     * @memberof AppMapPosition
     */
    public async handleMarker(lng: any, lat: any, that: any, flag: boolean = true) {
        const address = await this.getAddress(lng, lat).catch((error) => {
            console.warn(error);
        });
        if(!address) {
            return;
        }
        Object.assign(that.marker, { position: [lng, lat], address: address, visible: true });
        that.searchAddress = address;
        that.center = [lng, lat];
        if(flag) {
            Object.assign(this.markerResult, this.marker);
        }
    }

    /**
     * 搜索地址
     * 
     * @memberof AppMapPosition
     */
    public handleSearch() {
        this.center = [];
        const that = this;
        let placeSearch: any;
        //  调用服务搜索结果
        that.win.AMap.service(["AMap.PlaceSearch"], () => {
            placeSearch = new this.win.AMap.PlaceSearch({
                pageSize: 5,
                city: '成都',
                citylimit: false,
                panel: 'map__result',
            })
            placeSearch.search(that.searchAddress, (status: any, result: any) => {
                if (status == 'complete' && result.info == 'OK') {
                    this.resultShow = true;
                    if(result.poiList.pois) {
                        that.handleMarker(result.poiList.pois[0].location.R, result.poiList.pois[0].location.Q, that, false);
                    }
                }
            })
        })
        //  监听搜索结果列表点击事件
        that.win.AMap.event.addListener(placeSearch,"listElementClick", (e: any) => {
            if(e.data.location) {
                that.handleMarker(e.data.location.R, e.data.location.Q, that, false);
            }
        })
    }

    /**
     * 地图点击事件
     * 
     * @memberof AppMapPosition
     */
    public mapClick($event: any) {
        if(!$event && !$event.lnglat) {
            return;
        }
        const that = this;
        that.handleMarker($event.lnglat.lng, $event.lnglat.lat, that, false);
    }

    /**
     * 调用服务，根据经纬度获取地址信息
     * 
     * @param {*} lng 经度
     * @param {*} lat 纬度
     * @memberof AppMapPosition
     */
    public getAddress(lng: any, lat: any) {
        return new Promise((resolve, reject) => {
            this.geocoder.getAddress([lng,lat],(status:any,result: any) => {
                if (status === 'complete' && result.info === 'OK') {
                    if (result && result.regeocode) {
                        const address = result.regeocode.formattedAddress;
                        resolve(address);
                    }
                }
            })
        })
    }

    /**
     * 点击模态确认按钮，提交数据
     * 
     * @memberof AppMapPosition
     */
    public handleSubmit() {
        this.dialogShow = false;
        Object.assign(this.markerResult, this.marker);
        if(!this.markerResult || !this.mode) {
            return;
        }
        if(Object.is(this.mode, 'address')) {
            this.$emit('change', this.markerResult.address);
            const lng = { name: this.longitude, value: this.markerResult.position[0].toString() };
            const lat = { name: this.latitude, value: this.markerResult.position[1].toString() };
            this.$emit('itemChange', lng, lat);
        } else if(Object.is(this.mode, 'longitude')) {
            this.$emit('change', this.markerResult.position[0]);
            const address = { name: this.address, value: this.markerResult.address };
            const lat = { name: this.latitude, value: this.markerResult.position[1].toString() };
            this.$emit('itemChange', address, lat);
        } else if(Object.is(this.mode, 'latitude')) {
            this.$emit('change', this.markerResult.position[1]);
            const address = { name: this.address, value: this.markerResult.address };
            const lng = { name: this.longitude, value: this.markerResult.position[0].toString() };
            this.$emit('itemChange', address, lng);
        }
    }

}
</script>

<style lang='less'>
@import './app-map-position.less';
</style>