<template>
<div class='grid' style="height:100%">
  <i-form style="height:100%;display:flex;flex-direction: column;justify-content: space-between">
    <el-table v-if="isDisplay === true"
        :default-sort="{ prop: minorSortPSDEF, order: Object.is(minorSortDir, 'ASC') ? 'ascending' : Object.is(minorSortDir, 'DESC') ? 'descending' : '' }"  
        @sort-change="onSortChange($event)"  
        :border="isDragendCol"
        :highlight-current-row ="isSingleSelect"
        :row-class-name="getRowClassName"
        :cell-class-name="getCellClassName"
        max-height="items.length > 0 ? 'calc(100%-50px)' : '100%'"
        @row-click="rowClick($event)"  
        @select-all="selectAll($event)"  
        @select="select($event)"  
        @row-class-name="onRowClassName($event)"  
        @row-dblclick="rowDBLClick($event)"  
        ref='multipleTable' :data="items" :show-header="!isHideHeader">
            <template slot="empty">
                {{$t('app.gridpage.noData')}} 
            </template>
            <template v-if="!isSingleSelect">
                <el-table-column align="center" type='selection' :width="checkboxColWidth"></el-table-column>
            </template>
            <template v-if="getColumnState('id')">
                <el-table-column show-overflow-tooltip :prop="'id'" :label="$t('entities.jobsinfo.main_grid.columns.id')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.id')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.id}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('app')">
                <el-table-column show-overflow-tooltip :prop="'app'" :label="$t('entities.jobsinfo.main_grid.columns.app')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.app')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.app}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('handler')">
                <el-table-column show-overflow-tooltip :prop="'handler'" :label="$t('entities.jobsinfo.main_grid.columns.handler')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.handler')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.handler}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('cron')">
                <el-table-column show-overflow-tooltip :prop="'cron'" :label="$t('entities.jobsinfo.main_grid.columns.cron')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.cron')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.cron}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('last_time')">
                <el-table-column show-overflow-tooltip :prop="'last_time'" :label="$t('entities.jobsinfo.main_grid.columns.last_time')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.last_time')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.last_time}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('next_time')">
                <el-table-column show-overflow-tooltip :prop="'next_time'" :label="$t('entities.jobsinfo.main_grid.columns.next_time')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.next_time')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.next_time}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('status')">
                <el-table-column show-overflow-tooltip :prop="'status'" :label="$t('entities.jobsinfo.main_grid.columns.status')" :width="100"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.status')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.status" tag='CodeListJobStatus' codelistType='STATIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('timeout')">
                <el-table-column show-overflow-tooltip :prop="'timeout'" :label="$t('entities.jobsinfo.main_grid.columns.timeout')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.timeout')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.timeout}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('update_time')">
                <el-table-column show-overflow-tooltip :prop="'update_time'" :label="$t('entities.jobsinfo.main_grid.columns.update_time')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.jobsinfo.main_grid.columns.update_time')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD HH:mm:ss" :data="row.update_time"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="adaptiveState">
                <el-table-column></el-table-column>
            </template>
    </el-table>
  
    <row class='grid-pagination' v-show="items.length > 0">
        <page class='pull-right' @on-change="pageOnChange($event)" 
            @on-page-size-change="onPageSizeChange($event)"
            :transfer="true" :total="totalrow"
            show-sizer :current="curPage" :page-size="limit"
            :page-size-opts="[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]" show-elevator show-total>
            <span>
                <span class="page-column">
                    <poptip transfer placement="top-start">
                        <i-button icon="md-menu">{{$t('app.gridpage.choicecolumns')}}</i-button>
                        <div slot="content">
                            <template v-for="col in allColumns">
                                <div :key="col.name"><el-checkbox v-model="col.show" @change="onColChange()">{{$t(col.langtag)}}</el-checkbox></div>
                            </template>
                        </div>
                    </poptip>
                </span>
                <span class="page-button"><i-button icon="md-refresh" :title="$t('app.gridpage.refresh')" @click="pageRefresh()"></i-button></span>&nbsp;
                <span>
                    {{$t('app.gridpage.show')}}&nbsp;
                    <span>
                        <template v-if="items.length === 1">
                        1
                        </template>
                        <template v-else>
                            <span>{{(curPage - 1) * limit + 1}}&nbsp;-&nbsp;{{totalrow > curPage * limit ? curPage * limit : totalrow}}</span>
                        </template>
                    </span>&nbsp;
                    {{$t('app.gridpage.records')}}，{{$t('app.gridpage.totle')}}&nbsp;{{totalrow}}&nbsp;{{$t('app.gridpage.records')}}
                </span>
            </span>
        </page>
    </row>
  </i-form>
</div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util,ViewTool } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import AppCenterService from "@service/app/app-center-service";
import JobsInfoService from '@/service/jobs-info/jobs-info-service';
import MainService from './main-grid-service';
import JobsInfoUIService from '@/uiservice/jobs-info/jobs-info-ui-service';
import CodeListService from "@service/app/codelist-service";
import { FormItemModel } from '@/model/form-detail';


@Component({
    components: {
      
    }
})
export default class MainBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof MainBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof MainBase
     */
    public getControlType(): string {
        return 'GRID'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof MainBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {MainService}
     * @memberof MainBase
     */
    public service: MainService = new MainService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {JobsInfoService}
     * @memberof MainBase
     */
    public appEntityService: JobsInfoService = new JobsInfoService({ $store: this.$store });
    


    /**
     * 转化数据
     *
     * @param {any} args
     * @memberof  MainBase
     */
    public transformData(args: any) {
        let _this: any = this;
        if(_this.service && _this.service.handleRequestData instanceof Function && _this.service.handleRequestData('transform',_this.context,args)){
            return _this.service.handleRequestData('transform',_this.context,args)['data'];
        }
    }

    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof MainBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof MainBase
     */
    public counterRefresh(){
        const _this:any =this;
        if(_this.counterServiceArray && _this.counterServiceArray.length >0){
            _this.counterServiceArray.forEach((item:any) =>{
                if(item.refreshData && item.refreshData instanceof Function){
                    item.refreshData();
                }
            })
        }
    }


    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof MainBase
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 界面UI服务对象
     *
     * @type {JobsInfoUIService}
     * @memberof MainBase
     */  
    public appUIService:JobsInfoUIService = new JobsInfoUIService(this.$store);

    /**
     * 界面行为模型
     *
     * @type {*}
     * @memberof MainBase
     */  
    public ActionModel:any ={
    };

    /**
     * 应用状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public appStateEvent: Subscription | undefined;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof MainBase
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof MainBase
     */
    public getData(): any {
        return this.selections[0];
    }

    /**
     * 打开新建数据视图
     *
     * @type {any}
     * @memberof MainBase
     */
    @Prop() public newdata: any;
    /**
     * 打开编辑数据视图
     *
     * @type {any}
     * @memberof MainBase
     */
    @Prop() public opendata: any;
    
    /**
    * 是否嵌入关系界面
    *
    * @type {boolean}
    * @memberof MainBase
    */
    @Prop({default:false}) public isformDruipart?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public fetchAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public createAction!: string;

    /**
     * 当前页
     *
     * @type {number}
     * @memberof MainBase
     */
    public curPage: number = 1;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof MainBase
     */
    public items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public isEnablePagingBar: boolean = true;

    /**
     * 是否禁用排序
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public isNoSort: boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof MainBase
     */
    public minorSortDir: string = '';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof MainBase
     */
    public minorSortPSDEF: string = '';

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof MainBase
     */
    public limit: number = 20;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public isHideHeader: boolean = false;

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: false }) public isSelectFirstDefault!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop() public isSingleSelect?: boolean;

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public selectedData?: string;

    /**
     * 选中值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('selectedData')
    public onValueChange(newVal: any, oldVal: any) {
        this.selections = [];
        if(this.selectedData){
            const refs: any = this.$refs;
            if (refs.multipleTable) {
                refs.multipleTable.clearSelection();
                JSON.parse(this.selectedData).forEach((selection:any)=>{
                    let selectedItem = this.items.find((item:any)=>{
                        return Object.is(item.srfkey, selection.srfkey);
                    });
                    if(selectedItem){
                        this.rowClick(selectedItem);
                    }
                });
            }
        }
    }

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof MainBase
     */
    @Prop({default: 2}) public gridRowActiveMode!: number;

    /**
     * 是否开启行编辑
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({default: false}) public isOpenEdit!: boolean;

    /**
     * 实际是否开启行编辑
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public actualIsOpenEdit: boolean = this.isOpenEdit;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof MainBase
     */
    public totalrow: number = 0;

    /**
     * 表格更新默认值项
     * 
     * @memberof MainBase
     */
    public defaultUpdateItems:Array<any> =[];

    /**
     * 选中行数据
     *
     * @type {any[]}
     * @memberof MainBase
     */
    public selections: any[] = [];

    /**
     * 拦截行选中
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public stopRowClick: boolean = false;

    /**
     * 当前编辑行数据
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public curEditRowData:any;




    /**
     * 表格是否显示
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public isDisplay:boolean = true;

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public refresh(args: any[]): void {
        this.load();
    }

    /**
    * 选项框列宽
    *
    * @type {number}
    * @memberof AppIndex
    */
    public checkboxColWidth: number = 50;

    /**
     * 是否允许拖动列宽
     *
     * @type {boolean}
     * @memberof AppEmbedPicker
     */
    public isDragendCol: boolean = true;
    
    /**
     * 所有列成员
     *
     * @type {any[]}
     * @memberof MainBase
     */
    public allColumns: any[] = [
        {
            name: 'id',
            label: '主键ID',
            langtag: 'entities.jobsinfo.main_grid.columns.id',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
        {
            name: 'app',
            label: '服务名',
            langtag: 'entities.jobsinfo.main_grid.columns.app',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
        {
            name: 'handler',
            label: '执行器任务HANDLER',
            langtag: 'entities.jobsinfo.main_grid.columns.handler',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
        {
            name: 'cron',
            label: '任务执行CRON',
            langtag: 'entities.jobsinfo.main_grid.columns.cron',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
        {
            name: 'last_time',
            label: '上次调度时间',
            langtag: 'entities.jobsinfo.main_grid.columns.last_time',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
        {
            name: 'next_time',
            label: '下次调度时间',
            langtag: 'entities.jobsinfo.main_grid.columns.next_time',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
        {
            name: 'status',
            label: '状态',
            langtag: 'entities.jobsinfo.main_grid.columns.status',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
        {
            name: 'timeout',
            label: '任务执行超时时间（秒）',
            langtag: 'entities.jobsinfo.main_grid.columns.timeout',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
        {
            name: 'update_time',
            label: '更新时间',
            langtag: 'entities.jobsinfo.main_grid.columns.update_time',
            show: true,
            unit: 'PX',
            isEnableRowEdit: false,
        },
    ]

    /**
     * 表格模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public gridItemsModel: any[] = [];

    /**
     * 获取界面行为权限状态
     *
     * @memberof MainBase
     */
    public getActionState(data:any){
        let targetData:any = this.transformData(data);
        let tempActionModel:any = JSON.parse(JSON.stringify(this.ActionModel));
        ViewTool.calcActionItemAuthState(targetData,tempActionModel,this.appUIService);
        return tempActionModel;
    }

    /**
     * 获取表格行模型
     *
     * @type {*}
     * @memberof MainBase
     */
    public getGridRowModel(){
        return {
          srfkey: new FormItemModel(),
        }
    }

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof MainBase
     */
    public deRules:any = {
    };

    /**
     * 值规则集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public rules: any = {
        srfkey: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '主键ID 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '主键ID 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 表格行编辑项校验
     *
     * @param {string} property 属性名
     * @param {*} data 行数据
     * @param {number} rowIndex 行索引
     * @returns Promise<any>
     * 
     * @memberof MainBase
     */
    public validate(property:string, data:any, rowIndex:number):Promise<any>{
        return new Promise((resolve, reject) => {
            this.$util.validateItem(property,data,this.rules).then(()=>{
                this.gridItemsModel[rowIndex][property].setError(null);
                resolve(true);
            }).catch(({ errors, fields }) => {
                this.gridItemsModel[rowIndex][property].setError(errors[0].message);
                resolve(false);
            });
        });
    }

    /**
     * 校验所有修改过的编辑项
     *
     * @returns Promise<any>
     * @memberof MainBase
     */
    public async validateAll(){
        let validateState = true;
        let index = -1;
        for(let item of this.items){
          index++;
          if(item.rowDataState === "create" || item.rowDataState === "update"){
            for(let property of Object.keys(this.rules)){
              if(!await this.validate(property,item,index)){
                validateState = false;
              }
            }
          }
        }
        return validateState;
    }

    /**
     * 表格数据加载
     *
     * @param {*} [arg={}]
     * @memberof MainBase
     */
    public load(opt: any = {}, pageReset: boolean = false): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'JobsInfoGridView'+(this.$t('app.gridpage.notConfig.fetchAction') as string) });
            return;
        }
        if(pageReset){
            this.curPage = 1;
        }
        const arg: any = {...opt};
        const page: any = {};
        if (this.isEnablePagingBar) {
            Object.assign(page, { page: this.curPage-1, size: this.limit });
        }
        // 设置排序
        if (!this.isNoSort && !Object.is(this.minorSortDir, '') && !Object.is(this.minorSortPSDEF, '')) {
            const sort: string = this.minorSortPSDEF+","+this.minorSortDir;
            Object.assign(page, { sort: sort });
        }
        Object.assign(arg, page);
        const parentdata: any = {};
        this.$emit('beforeload', parentdata);
        Object.assign(arg, parentdata);
        let tempViewParams:any = parentdata.viewparams?parentdata.viewparams:{};
        Object.assign(tempViewParams,JSON.parse(JSON.stringify(this.viewparams)));
        Object.assign(arg,{viewparams:tempViewParams});
        const post: Promise<any> = this.service.search(this.fetchAction,JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.errorMessage) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.errorMessage });
                }
                return;
            }
            const data: any = response.data;
            this.totalrow = response.total;
            this.items = JSON.parse(JSON.stringify(data));
            // 清空selections,gridItemsModel
            this.selections = [];
            this.gridItemsModel = [];
            this.items.forEach(()=>{this.gridItemsModel.push(this.getGridRowModel())});
            this.items.forEach((item:any)=>{
                Object.assign(item,this.getActionState(item));    
            });
            this.$emit('load', this.items);
            // 设置默认选中
            let _this = this;
            setTimeout(() => {
                if(_this.isSelectFirstDefault){
                  _this.rowClick(_this.items[0]);
                }
                if(_this.selectedData){
                    const refs: any = _this.$refs;
                    if (refs.multipleTable) {
                        refs.multipleTable.clearSelection();
                        JSON.parse(_this.selectedData).forEach((selection:any)=>{
                            let selectedItem = _this.items.find((item:any)=>{
                                return Object.is(item.srfkey, selection.srfkey);
                            });
                            if(selectedItem){
                                _this.rowClick(selectedItem);
                            }
                        });
                    }
                }
            }, 300);
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.errorMessage });
        });
    }

    /**
     * 删除
     *
     * @param {any[]} datas
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async remove(datas: any[]): Promise<any> {
        if(!this.removeAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'JobsInfoGridView'+(this.$t('app.gridpage.notConfig.removeAction') as string) });
            return;
        }
        let _datas:any[] = [];
        datas.forEach((record: any, index: number) => {
            if (Object.is(record.srfuf,"0")) {
                this.items.some((val: any, num: number) =>{
                    if(JSON.stringify(val) == JSON.stringify(record)){
                        this.items.splice(num,1);
                        this.gridItemsModel.splice(num,1);
                        return true;
                    }
                }); 
            }else{
               _datas.push(datas[index]);
            }
        });
        if (_datas.length === 0) {
            return;
        }
        let dataInfo = '';
        _datas.forEach((record: any, index: number) => {
            let srfmajortext = record.handler;
            if (index < 5) {
                if (!Object.is(dataInfo, '')) {
                    dataInfo += '、';
                }
                dataInfo += srfmajortext;
            } else {
                return false;
            }
        });

        if (_datas.length < 5) {
            dataInfo = dataInfo + ' '+(this.$t('app.gridpage.totle') as string) + _datas.length + (this.$t('app.gridpage.records') as string)+(this.$t('app.gridpage.data') as string);
        } else {
            dataInfo = dataInfo + '...' + ' '+(this.$t('app.gridpage.totle') as string) + _datas.length + (this.$t('app.gridpage.desc2') as string);
        }

        const removeData = () => {
            let keys: any[] = [];
            _datas.forEach((data: any) => {
                keys.push(data.srfkey);
            });
            let _removeAction = keys.length > 1 ? 'removeBatch' : this.removeAction ;
            let _keys = keys.length > 1 ? keys : keys[0] ;
            const context:any = JSON.parse(JSON.stringify(this.context));
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ jobsinfo: _keys }),Object.assign({ jobsinfo: _keys },{viewparams:this.viewparams}), this.showBusyIndicator);
            return new Promise((resolve: any, reject: any) => {
                post.then((response: any) => {
                    if (!response || response.status !== 200) {
                        this.$Notice.error({ title: '', desc: (this.$t('app.gridpage.delDataFail') as string)+',' + response.info });
                        return;
                    } else {
                        this.$Notice.success({ title: '', desc: (this.$t('app.gridpage.delSuccess') as string) });
                    }
                    //删除items中已删除的项
                    console.log(this.items);
                    _datas.forEach((data: any) => {
                        this.items.some((item:any,index:number)=>{
                            if(Object.is(item.srfkey,data.srfkey)){
                                this.items.splice(index,1);
                                this.gridItemsModel.splice(index,1);
                                return true;
                            }
                        });
                    });
                    this.totalrow -= _datas.length;
                    this.$emit('remove', null);
                    this.selections = [];
                    resolve(response);
                }).catch((response: any) => {
                    if (response && response.status === 401) {
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                        reject(response);
                        return;
                    }
                    reject(response);
                });
            });
        }

        dataInfo = dataInfo.replace(/[null]/g, '').replace(/[undefined]/g, '');
        this.$Modal.confirm({
            title: (this.$t('app.commonWords.warning') as string),
            content: (this.$t('app.gridpage.confirmDel') as string)+' ' + dataInfo + '，'+(this.$t('app.gridpage.notRecoverable') as string),
            onOk: () => {
                removeData();
            },
            onCancel: () => { }
        });
        return removeData;
    }


    /**
     * 批量添加
     *
     * @param {*} [arg={}]
     * @memberof MainBase
     */
    public addBatch(arg: any = {}): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'JobsInfoGridView'+(this.$t('app.gridpage.notConfig.fetchAction') as string) });
            return;
        }
        if(!arg){
            arg = {};
        }
        console.error((this.$t('app.gridpage.notBatch') as string));
    }

    /**
     * 数据导入
     *
     * @param {*} data
     * @memberof MainBase
     */
     public importExcel(data:any ={}):void{
        //导入excel
        const importDataModel:any ={
        }
        if(Object.keys(importDataModel).length == 0){
            this.$Notice.warning({ 'title': (this.$t("app.utilview.warning") as string), 'desc': (this.$t("app.utilview.info") as string) });
            return;
        }
        const view:any ={
            viewname: 'app-data-upload',
            title: this.$t("app.utilview.importview"),
            width: 900,
            height: 700
        }
        let container: Subject<any> = this.$appmodal.openModal(view, JSON.parse(JSON.stringify(this.context)), importDataModel);
        container.subscribe((result: any) => {
          if(Object.is(result.ret,'OK')){
            this.refresh(result.datas);
          }
      });
    }


    /**
     * 数据导出
     *
     * @param {*} data
     * @memberof MainBase
     */
    public exportExcel(data: any = {}): void {
        // 导出Excel
        const doExport = async (_data:any) => {
            const tHeader: Array<any> = [];
            const filterVal: Array<any> = [];
            this.allColumns.forEach((item: any) => {
              item.show && item.label ? tHeader.push(this.$t(item.langtag)) : "";
              item.show && item.name ? filterVal.push(item.name) : "";
            });
            const data = await this.formatExcelData(filterVal, _data);
            this.$export.exportExcel().then((excel:any)=>{
                excel.export_json_to_excel({
                  header: tHeader, //表头 必填
                  data, //具体数据 必填
                  filename: "任务信息"+(this.$t('app.gridpage.grid') as string), //非必填
                  autoWidth: true, //非必填
                  bookType: "xlsx" //非必填
                });
            }); 
        };
        const page: any = {};
        // 设置page，size
        if (Object.is(data.type, 'maxRowCount')) {
            Object.assign(page, { page: 0, size: data.maxRowCount });
        } else if (Object.is(data.type, 'activatedPage')) {
            try {
                doExport(JSON.parse(JSON.stringify(this.items)));
            } catch (error) {
                console.error(error);
            }
            return;
        }
        // 设置排序
        if (!this.isNoSort && !Object.is(this.minorSortDir, '') && !Object.is(this.minorSortPSDEF, '')) {
          const sort: string = this.minorSortPSDEF+","+this.minorSortDir;
            Object.assign(page, { sort: sort });
        }
        const arg: any = {};
        Object.assign(arg, page);
        // 获取query,搜索表单，viewparams等父数据
        const parentdata: any = {};
        this.$emit('beforeload', parentdata);
        Object.assign(arg, parentdata);
        const post: Promise<any> = this.service.search(this.fetchAction,JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: '', desc: (this.$t('app.gridpage.exportFail') as string)+',' + response.info });
                return;
            }
            try {
                doExport(JSON.parse(JSON.stringify(response.data)));
            } catch (error) {
                console.error(error);
            }
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            this.$Notice.error({ title: '', desc: (this.$t('app.gridpage.exportFail') as string) });
        });
    }


    /**
     * 导出数据格式化
     * 
     * @param {*} filterVal
     * @param {*} jsonData
     * @returns {[]}
     * @memberof MainBase
     */
    public async formatExcelData(filterVal:any, jsonData:any) {
        let codelistColumns:Array<any> = [
          {
            name: 'status',
            srfkey: 'CodeListJobStatus',
            codelistType : 'STATIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
        ];
        let _this = this;
        for (const codelist of codelistColumns) {
          // 动态代码表处理
          if (Object.is(codelist.codelistType, "DYNAMIC")) {
              let items = await _this.codeListService.getItems(codelist.srfkey);
              jsonData.forEach((row:any)=>{
                  row[codelist.name] = _this.getCodelistValue(items, row[codelist.name], codelist);
              });
          // 静态处理
          } else if(Object.is(codelist.codelistType, "STATIC")){
              let items = await _this.$store.getters.getCodeListItems(codelist.srfkey);
              jsonData.forEach((row:any)=>{
                  row[codelist.name] = _this.getCodelistValue(items, row[codelist.name], codelist);
              });
          }
        }
        return jsonData.map((v:any) => filterVal.map((j:any) => v[j]))
    }   


    /**
     * 解析代码表和vlaue，设置items
     *
     * @public
     * @param {any[]} items 代码表数据
     * @param {*} value
     * @returns {*}
     * @memberof MainBase
     */
    public getCodelistValue(items: any[], value: any, codelist: any,){
        if(!value){
            return this.$t('codelist.'+codelist.srfkey+'.empty');
        }
        if (items) {
            let result:any = [];
            if(Object.is(codelist.renderMode,"number")){
                items.map((_item: any, index: number)=>{
                    const nValue = parseInt((value as any), 10);
                    const codevalue = _item.value;
                    if((parseInt(codevalue, 10) & nValue) > 0){
                        result.push(_item);
                    } 
                });
            } else if(Object.is(codelist.renderMode,"string")){
                const arrayValue: Array<any> = (value as any).split(codelist.valueSeparator);
                arrayValue.map((value: any, index: number) => {
                    result.push([]);
                    let values: any[] = Object.is(this.$util.typeOf(value), 'number') ? [value] : [...(value as any).split(codelist.valueSeparator)];
                    values.map((val:any ,num: number)=>{
                        const item = this.getItem(items, val, codelist); 
                        if(item){
                          result[index].push(item);
                        } 
                    });
                });
            } else {
                let values: any[] = Object.is(this.$util.typeOf(value), 'number') ? [value] : [...(value as any).split(codelist.valueSeparator)];
                values.map((value:any ,index: number)=>{
                    const item = this.getItem(items, value, codelist); 
                    if(item){
                      result.push(item);
                    } 
                });
            }
            // 设置items
            if(result.length != 0){
              return result.join(codelist.valueSeparator);
            }else{
              return value;
            }
        }
    }

    /**
     * 获取代码项
     *
     * @public
     * @param {any[]} items
     * @param {*} value
     * @returns {*}
     * @memberof MainBase
     */
    public getItem(items: any[], value: any, codelist: any): any {
        const arr: Array<any> = items.filter(item => {return item.value == value});
        if (arr.length !== 1) {
            return undefined;
        }
        if(Object.is(codelist.codelistType,'STATIC')){
            return this.$t('codelist.'+codelist.srfkey+'.'+arr[0].value);
        }else{
            return arr[0].text;
        }
    }

    /**
     * 生命周期
     *
     * @memberof MainBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof MainBase
     */    
    public afterCreated(){
        this.setColState();
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('load', action)) {
                    this.load(data);
                }
                if (Object.is('remove', action)) {
                    this.remove(data);
                }
                if (Object.is('save', action)) {
                    this.save(data);
                }
            });
        }
        if(AppCenterService && AppCenterService.getMessageCenter()){
            this.appStateEvent = AppCenterService.getMessageCenter().subscribe(({ name, action, data }) =>{
                if(!Object.is(name,"JobsInfo")){
                    return;
                }
                if(Object.is(action,'appRefresh')){
                    this.refresh([data]);
                }
            })
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof MainBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof MainBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
        if(this.appStateEvent){
            this.appStateEvent.unsubscribe();
        }
    }

    /**
     * 获取选中行胡数据
     *
     * @returns {any[]}
     * @memberof MainBase
     */
    public getSelection(): any[] {
        return this.selections;
    }

    /**
     * 行双击事件
     *
     * @param {*} $event
     * @returns {void}
     * @memberof MainBase
     */
    public rowDBLClick($event: any): void {
        if (!$event || this.actualIsOpenEdit || Object.is(this.gridRowActiveMode,0)) {
            return;
        }
        this.selections = [];
        this.selections.push(JSON.parse(JSON.stringify($event)));

        const refs: any = this.$refs;
        if (refs.multipleTable) {
            refs.multipleTable.clearSelection();
            refs.multipleTable.toggleRowSelection($event);
        }

        this.$emit('rowdblclick', this.selections);
        this.$emit('selectionchange', this.selections);
    }

    /**
     * 复选框数据选中
     *
     * @param {*} $event
     * @returns {void}
     * @memberof MainBase
     */
    public select($event: any): void {
        if (!$event) {
            return;
        }
        this.selections = [];
        this.selections = [...JSON.parse(JSON.stringify($event))];
        this.$emit('selectionchange', this.selections);
    }

    /**
     * 复选框数据全部选中
     *
     * @param {*} $event
     * @memberof MainBase
     */
    public selectAll($event: any): void {
        if (!$event) {
            return;
        }
        this.selections = [];
        this.selections = [...JSON.parse(JSON.stringify($event))];
        this.$emit('selectionchange', this.selections);
    }

    
    /**
     * 行单击选中
     *
     * @param {*} $event
     * @returns {void}
     * @memberof MainBase
     */
    public rowClick($event: any, ifAlways: boolean = false): void {
        if (!ifAlways && (!$event || this.actualIsOpenEdit)) {
            return;
        }
        if(this.stopRowClick) {
            this.stopRowClick = false;
            return;
        }
        if(this.isSingleSelect){
            this.selections = [];
        }
        // 已选中则删除，没选中则添加
        let selectIndex = this.selections.findIndex((item:any)=>{
            return Object.is(item.jobsinfo,$event.jobsinfo);
        });
        if (Object.is(selectIndex,-1)){
          this.selections.push(JSON.parse(JSON.stringify($event)));
        } else {
          this.selections.splice(selectIndex,1);
        }

        const refs: any = this.$refs;
        if (refs.multipleTable) {
            if(this.isSingleSelect){
                refs.multipleTable.clearSelection();
                refs.multipleTable.setCurrentRow($event);
            }else{
                refs.multipleTable.toggleRowSelection($event); 
            }
        }

        this.$emit('selectionchange', this.selections);
    }


    /**
     * 页面变化
     *
     * @param {*} $event
     * @returns {void}
     * @memberof MainBase
     */
    public pageOnChange($event: any): void {
        if (!$event) {
            return;
        }
        if ($event === this.curPage) {
            return;
        }
        this.curPage = $event;
        this.load({});
    }

    /**
     * 分页条数变化
     *
     * @param {*} $event
     * @returns {void}
     * @memberof MainBase
     */
    public onPageSizeChange($event: any): void {
        if (!$event) {
            return;
        }
        if ($event === this.limit) {
            return;
        }
        this.limit = $event;
        if (this.curPage === 1) {
            this.load({});
        }
    }

    /**
     * 分页刷新
     *
     * @memberof MainBase
     */
    public pageRefresh(): void {
        this.load({});
    }

    /**
     * 排序变化
     *
     * @param {{ column: any, prop: any, order: any }} { column, prop, order }
     * @memberof MainBase
     */
    public onSortChange({ column, prop, order }: { column: any, prop: any, order: any }): void {
        const dir = Object.is(order, 'ascending') ? 'asc' : Object.is(order, 'descending') ? 'desc' : '';
        if (Object.is(dir, this.minorSortDir) && Object.is(this.minorSortPSDEF, prop)) {
            return;
        }
        this.minorSortDir = dir;
        this.minorSortPSDEF = prop ? prop : '';
        this.load({});
    }

    /**
     * 表格行选中样式
     *
     * @param {{ row: any, rowIndex: any }} { row, rowIndex }
     * @returns {string}
     * @memberof MainBase
     */
    public onRowClassName({ row, rowIndex }: { row: any, rowIndex: any }): string {
        const index = this.selections.findIndex((select: any) => Object.is(select.srfkey, row.srfkey));
        return index !== -1 ? 'grid-row-select' : '';
    }



    /**
     * 界面行为
     *
     * @param {*} row
     * @param {*} tag
     * @param {*} $event
     * @memberof MainBase
     */
	public uiAction(row: any, tag: any, $event: any) {
        // this.rowClick(row, true);
        $event.stopPropagation();
    }

    /**
     * 设置列状态
     *
     * @memberof MainBase
     */
    public setColState() {
		const _data: any = localStorage.getItem('jobs_info_main_grid');
		if (_data) {
			let columns = JSON.parse(_data);
			columns.forEach((col: any) => {
				let column = this.allColumns.find((item) => Object.is(col.name, item.name));
				if (column) {
					Object.assign(column, col);
				}
			});
		}
    }

    /**
     * 列变化
     *
     * @memberof MainBase
     */
    public onColChange() {
        localStorage.setItem('jobs_info_main_grid', JSON.stringify(this.allColumns));
    }

    /**
     * 获取列状态
     *
     * @param {string} name
     * @returns {boolean}
     * @memberof MainBase
     */
    public getColumnState(name: string): boolean {
        let column = this.allColumns.find((col: any) =>
            Object.is(name, col.name)
        );
        return column.show ? true : false;
    }

    /**
     * 表格列是否自适应布局
     *
     * @readonly
     * @type {boolean}
     * @memberof MainBase
     */
    get adaptiveState(): boolean {
        return !this.allColumns.find((column: any) => column.show && Object.is(column.unit, 'STAR'));
    }

    /**
     * 保存
     *
     * @param {*} $event
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async save(args: any[], params?: any, $event?: any, xData?: any){
        let _this = this;
        // 拷贝模式
        if(_this.viewparams && _this.viewparams.copymode && Object.is(_this.viewparams.copymode,'true') && _this.items && _this.items.length >0){
            for (const item of _this.items) {
                item.rowDataState = 'create';
            }
        }
        if(_this.items && _this.items.length >0){
            for (const item of _this.items) {
                if(Object.is(item.rowDataState, 'update')){
                    _this.updateDefault(item);
                }
            }
        }
        if(!await this.validateAll()){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.rulesException') as string) });
            return [];
        }
        let successItems:any = [];
        let errorItems:any = [];
        let errorMessage:any = [];
        for (const item of _this.items) {
            try {
                if(Object.is(item.rowDataState, 'create')){
                    if(!this.createAction){
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'JobsInfoGridView'+(this.$t('app.gridpage.notConfig.createAction') as string) });
                    }else{
                      Object.assign(item,{viewparams:this.viewparams});
                      let response = await this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                      successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }else if(Object.is(item.rowDataState, 'update')){
                    if(!this.updateAction){
                        this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'JobsInfoGridView'+(this.$t('app.gridpage.notConfig.updateAction') as string) });
                    }else{
                        Object.assign(item,{viewparams:this.viewparams});
                        if(item.jobsinfo){
                            Object.assign(this.context,{jobsinfo:item.jobsinfo});
                        }
                        let response = await this.service.update(this.updateAction,JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                        successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }
            } catch (error) {
                errorItems.push(JSON.parse(JSON.stringify(item)));
                errorMessage.push(error);
            }
        }
        this.$emit('save', successItems);
        this.refresh([]);
        if(errorItems.length === 0 && successItems.length >0 && !this.isformDruipart){
            this.$Notice.success({ title: '', desc: (this.$t('app.commonWords.saveSuccess') as string) });
        }else{
          errorItems.forEach((item:any,index:number)=>{
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: errorMessage[index].data.message });
            console.error(errorMessage[index]);
          });
        }
        return successItems;
    }

    /**
     * 新建行
     *
     * @param {*} $event
     * @returns {void}
     * @memberof MainBase
     */
    public newRow(args: any[], params?: any, $event?: any, xData?: any): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: 'JobsInfoGridView'+(this.$t('app.gridpage.notConfig.loaddraftAction') as string) });
            return;
        }
        let _this = this;
        Object.assign(args[0],{viewparams:this.viewparams});
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction, JSON.parse(JSON.stringify(this.context)), args[0], this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.errorMessage) {
                    this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.errorMessage });
                }
                return;
            }
            const data = response.data;
            this.createDefault(data);
            data.rowDataState = "create";
            _this.items.push(data);
            _this.gridItemsModel.push(_this.getGridRowModel());
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }
        });
    }

    /**
     * 表格编辑项值变更
     *  
     * @param row 行数据
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof MainBase
     */
    public onGridItemValueChange(row: any,$event: { name: string, value: any },rowIndex: number): void {
        if (!$event) {
            return;
        }
        if (!$event.name || Object.is($event.name, '') || !row.hasOwnProperty($event.name)) {
            return;
        }
        row[$event.name] = $event.value;
        this.gridEditItemChange(row, $event.name, $event.value, rowIndex);
    }

    /**
     * 表格编辑项值变化
     *
     * @public
     * @param row 行数据
     * @param property 列编辑项名
     * @param row 列编辑项值
     * @returns {void}
     * @memberof MainBase
     */
    public gridEditItemChange(row: any, property: string, value: any, rowIndex: number){
        row.rowDataState = row.rowDataState ? row.rowDataState : "update" ;
        if(Object.is(row.rowDataState,"update")){
            if(!value && this.defaultUpdateItems.includes(property)){
                row.hasUpdated = true;
            }
        }
        this.curEditRowData = row;
        this.validate(property,row,rowIndex);
    }

    /**
     * 表格编辑项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof MainBase
     */
    public updateGridEditItem(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        if (!mode || (mode && Object.is(mode, ''))) {
            return;
        }
        const arg: any = JSON.parse(JSON.stringify(data));
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.frontLogic(mode,JSON.parse(JSON.stringify(this.context)),arg, showloading);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.gridpage.formitemFailed') as string) });
                return;
            }
            const _data: any = response.data;
            if(!_data){
                return;
            }
            updateDetails.forEach((name: string) => {
                if (!_data.hasOwnProperty(name)) {
                    return;
                }
                data[name] = _data[name];
            });
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                return;
            }
        });
    }

    /**
     * 获取对应行class
     *
     * @param {*} $args row 行数据，rowIndex 行索引
     * @returns {void}
     * @memberof MainBase
     */
    public getRowClassName(args:{row: any,rowIndex: number}){
        let isSelected = this.selections.some((item:any)=>{
            return Object.is(item.jobsinfo,args.row.jobsinfo);
        });
        return isSelected ? "grid-selected-row" : "";
    }

    /**
     * 获取对应列class
     *
     * @param {*} $args row 行数据，column 列数据，rowIndex 行索引，列索引
     * @returns {void}
     * @memberof MainBase
     */
    public getCellClassName(args:{row: any, column: any, rowIndex: number, columnIndex:number}){
        if(args.column.property){
          let col = this.allColumns.find((item:any)=>{
              return Object.is(args.column.property,item.name);
          })
          if(col !== undefined){
              if(col.isEnableRowEdit && this.actualIsOpenEdit ){
                  return 'edit-cell';
              }
          }
        }
        return 'info-cell';
    }

    /**
     * 新建默认值
     * @param {*}  row 行数据
     * @memberof MainBase
     */
    public createDefault(row: any){                    
    }

    /**
     * 更新默认值
     * @param {*}  row 行数据
     * @memberof MainBase
     */
    public updateDefault(row: any){                    
    }

    /**
     * 校验属性值规则
     *
     * @public
     * @param {{ name: string }} { name }
     * @memberof MainBase
     */
    public verifyDeRules(name:string,rule:any = this.deRules,op:string = "AND",value:any) :{isPast:boolean}{
        let falg:any = {};
        if(!rule || !rule[name]){
            return falg;
        }
        let opValue = op == 'AND'? true :false;
        let startOp = (val:boolean)=>{
            if(falg.isPast){
                if(opValue){
                    falg.isPast = falg && val;
                }else{
                    falg.isPast = falg || val;
                }
            }else{
                falg.isPast = val;
            }
        }
        rule[name].forEach((item:any) => {
            // 常规规则
            if(item.type == 'SIMPLE'){
                startOp(!this.$verify.checkFieldSimpleRule(value,item.condOP,item.paramValue,item.ruleInfo,item.paramType,this.curEditRowData,item.isKeyCond));
            }
            // 数值范围
            if(item.type == 'VALUERANGE2'){
                startOp( !this.$verify.checkFieldValueRangeRule(value,item.minValue,item.isIncludeMinValue,item.maxValue,item.isIncludeMaxValue,item.ruleInfo,item.isKeyCond));
            }
            // 正则式
            if (item.type == "REGEX") {
                startOp(!this.$verify.checkFieldRegExRule(value,item.regExCode,item.ruleInfo,item.isKeyCond));
            }
            // 长度
            if (item.type == "STRINGLENGTH") {
                startOp(!this.$verify.checkFieldStringLengthRule(value,item.minValue,item.isIncludeMinValue,item.maxValue,item.isIncludeMaxValue,item.ruleInfo,item.isKeyCond)); 
            }
            // 系统值规则
            if(item.type == "SYSVALUERULE") {
                startOp(!this.$verify.checkFieldSysValueRule(value,item.sysRule.regExCode,item.ruleInfo,item.isKeyCond));
            }
            // 分组
            if(item.type == 'GROUP'){
                falg = this.verifyDeRules('group',item,"AND",value)
                if(item.isNotMode){
                   falg.isPast = !falg.isPast;
                }
            }
            
        });
        if(!falg.hasOwnProperty("isPast")){
            falg.isPast = true;
        }
        if(!value){
           falg.isPast = true;
        }
        return falg;
    }

    /**
     * 工作流提交
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async submitbatch(data: any,localdata:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data;
        const result: Promise<any> = this.service.submitbatch(_this.WFSubmitAction, JSON.parse(JSON.stringify(this.context)),arg,localdata,this.showBusyIndicator);
        result.then((response: any) => {
            if (!response || response.status !== 200) {
                if(response.data){
                    this.$Notice.error({ title: '', desc: (this.$t('app.formpage.workflow.submiterror') as string) + ', ' + response.data.message });
                }
                return;
            }
            this.$Notice.info({ title: '', desc: (this.$t('app.formpage.workflow.submitsuccess') as string) });
            resolve(response);
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: response.data.message });
                reject(response);
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: (this.$t('app.commonWords.wrong') as string), desc: (this.$t('app.commonWords.sysException') as string) });
                reject(response);
                return;
            }
            reject(response);
        });
        })
    }

}
</script>

<style lang='less'>
@import './main-grid.less';
</style>