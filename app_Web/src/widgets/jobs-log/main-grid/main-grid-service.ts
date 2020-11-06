import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import JobsLogService from '@/service/jobs-log/jobs-log-service';
import MainModel from './main-grid-model';


/**
 * Main 部件服务对象
 *
 * @export
 * @class MainService
 */
export default class MainService extends ControlService {

    /**
     * 任务调度日志服务对象
     *
     * @type {JobsLogService}
     * @memberof MainService
     */
    public appEntityService: JobsLogService = new JobsLogService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof MainService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of MainService.
     * 
     * @param {*} [opts={}]
     * @memberof MainService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new MainModel();
    }

    /**
     * 备份原生数据
     *
     * @type {*}
     * @memberof MainService
     */
    private copynativeData:any;

    /**
     * 远端数据
     *
     * @type {*}
     * @memberof MainService
     */
    private remoteCopyData:any = {};


    /**
     * 处理数据
     *
     * @public
     * @param {Promise<any>} promise
     * @returns {Promise<any>}
     * @memberof MainService
     */
    public doItems(promise: Promise<any>, deKeyField: string, deName: string): Promise<any> {
        return new Promise((resolve, reject) => {
            promise.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    data.forEach((item:any,index:number) =>{
                        item[deName] = item[deKeyField];
                        data[index] = item;
                    });
                    resolve(data);
                } else {
                    reject([])
                }
            }).catch((response: any) => {
                reject([])
            });
        });
    }

    /**
     * 获取跨实体数据集合
     *
     * @param {string} serviceName 服务名称
     * @param {string} interfaceName 接口名称
     * @param {*} data
     * @param {boolean} [isloading]
     * @returns {Promise<any[]>}
     * @memberof  MainService
     */
    @Errorlog
    public getItems(serviceName: string, interfaceName: string, context: any = {}, data: any, isloading?: boolean): Promise<any[]> {
        data.page = data.page ? data.page : 0;
        data.size = data.size ? data.size : 1000;

        return Promise.reject([])
    }

    /**
     * 添加数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MainService
     */
    @Errorlog
    public add(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestDataWithUpdate(action,context,data,true);
        return new Promise((resolve: any, reject: any) => {
            const _appEntityService: any = this.appEntityService;
            let result: Promise<any>;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            }else{
                result =_appEntityService.Create(Context,Data, isloading);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });      
        });
    }

    /**
     * 删除数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MainService
     */
    @Errorlog
    public delete(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data,true);
        return new Promise((resolve: any, reject: any) => {
            const _appEntityService: any = this.appEntityService;
            let result: Promise<any>;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            }else{
                result =_appEntityService.Remove(Context,Data, isloading);
            }
            result.then((response) => {
                resolve(response);
            }).catch(response => {
                reject(response);
            });      
        });
    }

    /**
     * 修改数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MainService
     */
    @Errorlog
    public update(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestDataWithUpdate(action,context,data,true);
        return new Promise((resolve: any, reject: any) => {
            const _appEntityService: any = this.appEntityService;
            let result: Promise<any>;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data,isloading);
            }else{
                result =_appEntityService.Update(Context,Data,isloading);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });      
        });
    }

    /**
     * 获取数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MainService
     */
    @Errorlog
    public get(action: string, context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data,true);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.Get(Context,Data, isloading);
            }
            result.then((response) => {
                //处理返回数据，补充判断标识
                if(response.data){
                    Object.assign(response.data,{srfuf:'0'});
                }
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MainService
     */
    @Errorlog
    public search(action: string,context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data,true);
        return new Promise((resolve: any, reject: any) => {
            const _appEntityService: any = this.appEntityService;
            let result: Promise<any>;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            }else{
                result =_appEntityService.FetchDefault(Context,Data, isloading);
            }
            result.then((response) => {
                this.setCopynativeData(response.data);
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });      
        });
    }


    /**
     * 加载草稿
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MainService
     */
    @Errorlog
    public loadDraft(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data,true);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                result = this.appEntityService.GetDraft(Context,Data, isloading);
            }
            result.then((response) => {
                //处理返回数据，补充判断标识
                if(response.data){
                    Object.assign(response.data,{srfuf:'0'});
                    //仿真主键数据
                    response.data.id = Util.createUUID();
                }
                this.setRemoteCopyData(response);
                this.handleResponse(action, response, true);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }


    /**
     * 前台逻辑
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof MainService
     */
    @Errorlog
    public frontLogic(action:string,context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const {data:Data,context:Context} = this.handleRequestData(action,context,data,true);
        return new Promise((resolve: any, reject: any)=>{
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](Context,Data, isloading);
            } else {
                return Promise.reject({ status: 500, data: { title: '失败', message: '系统异常' } });
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        })
    }

    /**
     * 处理请求数据(修改或增加数据)
     * 
     * @param action 行为 
     * @param data 数据
     * @memberof MainService
     */
    public handleRequestDataWithUpdate(action: string,context:any ={},data: any = {},isMerge:boolean = false){
        let model: any = this.getMode();
        if (!model && model.getDataItems instanceof Function) {
            return data;
        }
        let dataItems: any[] = model.getDataItems();
        let requestData:any = {};
        if(isMerge && (data && data.viewparams)){
            Object.assign(requestData,data.viewparams);
        }
        dataItems.forEach((item:any) =>{
            if(item && item.dataType && Object.is(item.dataType,'FONTKEY')){
                if(item && item.prop && item.name ){
                    requestData[item.prop] = context[item.name];
                }
            }else{
                if(item && item.isEditable && item.prop && item.name && data.hasOwnProperty(item.name)){
                    requestData[item.prop] = data[item.name];
                }
            }
        });
        let tempContext:any = JSON.parse(JSON.stringify(context));
        if(tempContext && tempContext.srfsessionid){
            tempContext.srfsessionkey = tempContext.srfsessionid;
            delete tempContext.srfsessionid;
        }
        return {context:tempContext,data:requestData};
    }

    /**
     * 处理工作流数据
     * 
     * @param data 传入数据
     *  @memberof MainService
     */
    public handleWFData(data:any, isMerge:boolean = false){
        let model: any = this.getMode();
        if (!model && model.getDataItems instanceof Function) {
            return data;
        }
        let dataItems: any[] = model.getDataItems();
        let requestData:any = {};
        dataItems.forEach((item:any) =>{
            if(item && item.prop){
                if(item.dataType){
                    if(!Object.is(item.dataType,'QUERYPARAM')){
                        requestData[item.prop] = data[item.name];
                    }
                }else{
                    requestData[item.prop] = data[item.name];
                }  
            }
        });
        if(isMerge && (data.viewparams && Object.keys(data.viewparams).length > 0)){
            Object.assign(requestData,data.viewparams);
        }
        // 删除前端srffrontuf标识
        if(requestData.hasOwnProperty('srffrontuf')){
            delete requestData.srffrontuf;
        }
        //补充工作流所需主键
        requestData.srfkey = data.jobslog;
        //补充全量数据
        requestData = this.fillNativeData(requestData);
        return requestData;
    }

    /**
     * 补充全量数据
     *
     * @param {*} [data]
     * @memberof MainService
     */
    public fillNativeData(data:any){
        if(this.copynativeData && this.copynativeData.length >0){
            let targetData:any = this.copynativeData.find((item:any) =>{
                return item.id === data.srfkey;
            })
            data = Object.assign(targetData,data);
            return data;
        }
    }

    /**
     * 提交工作流
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof MainService
     */
    @Errorlog
    public submitbatch(action: string,context: any = {}, data: any,localdata:any,isloading?: boolean): Promise<any> {
        let tempData:any = [];
        if(data && data.length > 0){
            data.forEach((item:any) => {
                let data:any = this.handleWFData(item,true);
                tempData.push(data);
            });
        }
        context = this.handleRequestData(action,context,data,true).context;
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            const _appEntityService: any = this.appEntityService;
            if (_appEntityService[action] && _appEntityService[action] instanceof Function) {
                result = _appEntityService[action](context,tempData, localdata,isloading);
            } else {
                result = this.appEntityService.wfSubmitBatch(context,tempData,localdata,isloading);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 设置远端数据
     * 
     * @param result 远端请求结果 
     * @memberof MainService
     */
    public setRemoteCopyData(result:any){
        if (result && result.status === 200) {
            this.remoteCopyData = Util.deepCopy(result.data);
        }
    }

    /**
     * 获取远端数据
     * 
     * @memberof MainService
     */
    public getRemoteCopyData(){
        return this.remoteCopyData;
    }

    /**
     * 设置备份原生数据
     * 
     * @param data 远端请求结果 
     * @memberof MainService
     */
    public setCopynativeData(data:any){
        this.copynativeData = Util.deepCopy(data);
    }

    /**
     * 获取备份原生数据
     * 
     * @memberof MainService
     */
    public getCopynativeData(){
        return this.copynativeData;
    }    
}