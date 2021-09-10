import qs from 'qs';
import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

// 模拟数据
const mockDatas: Array<any> = [
];


//getwflink
mock.onGet(new RegExp(/^\/wfcore\/ibzrt-app-web\/systeammembers\/[a-zA-Z0-9\-\;]+\/usertasks\/[a-zA-Z0-9\-\;]+\/ways$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: getwflink");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status,[
        {"sequenceFlowId":"dfdsfdsfdsfdsfds","sequenceFlowName":"同意",
         "taskId":"aaaaddddccccddddd","processDefinitionKey":"support-workorders-approve-v1",
         "processInstanceId":"ddlfldldfldsfds","refViewKey":""},
        {"sequenceFlowId":"ddssdfdfdfdfsfdf","sequenceFlowName":"不同意",
         "taskId":"aaaaddddccccddddd","processDefinitionKey":"support-workorders-approve-v1",
         "processInstanceId":"ddfdsldlfdlldsf","refViewKey":"workorder_ltform_editview"}
        ]];
});

// getwfstep
mock.onGet(new RegExp(/^\/wfcore\/ibzrt-app-web\/systeammembers\/process-definitions-nodes$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: getwfstep");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, [
        {"userTaskId":"sddfddfd-dfdf-fdfd-fdf-dfdfd",
        "userTaskName":"待审",
        "cnt":0,
        "processDefinitionKey":"support-workorders-approve-v1",
        "processDefinitionName":"工单审批流程v1"
        },
        {"userTaskId":"sddfddfd-dfdf-fdfd-fdf-87927",
        "userTaskName":"待分配",
        "cnt":3,
        "processDefinitionKey":"support-workorders-approve-v1",
        "processDefinitionName":"工单审批流程v1"}
        ]];
});

// createBatch
mock.onPost(new RegExp(/^\/systeammembers\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: createBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// updateBatch
mock.onPut(new RegExp(/^\/systeammembers\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: updateBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// removeBatch
mock.onDelete(new RegExp(/^\/systeammembers\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: removeBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});


    
// CheckKey
mock.onPost(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// CheckKey
mock.onPost(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// CheckKey
mock.onPost(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// CheckKey
mock.onPost(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['teamid','teammemberid'];
    const matchArray:any = new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// CheckKey
mock.onPost(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// CheckKey
mock.onPost(new RegExp(/^\/systeammembers\/?([a-zA-Z0-9\-\;]{0,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teammemberid'];
    const matchArray:any = new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['teammemberid'] == tempValue['teammemberid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});

    
// Create
mock.onPost(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Create
mock.onPost(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Create
mock.onPost(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Create
mock.onPost(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['teamid','teammemberid'];
    const matchArray:any = new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Create
mock.onPost(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Create
mock.onPost(new RegExp(/^\/systeammembers\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teammemberid'];
    const matchArray:any = new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas[0]);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas[0]];
});







// GetDraft
mock.onGet(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});


// GetDraft
mock.onGet(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});


// GetDraft
mock.onGet(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});


// GetDraft
mock.onGet(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});


// GetDraft
mock.onGet(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

// GetDraft
mock.onGet(new RegExp(/^\/systeammembers\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});






    
// Save
mock.onPost(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Save
mock.onPost(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Save
mock.onPost(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Save
mock.onPost(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['teamid','teammemberid'];
    const matchArray:any = new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Save
mock.onPost(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Save
mock.onPost(new RegExp(/^\/systeammembers\/?([a-zA-Z0-9\-\;]{0,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teammemberid'];
    const matchArray:any = new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['teammemberid'] == tempValue['teammemberid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});

    
// Update
mock.onPut(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Update
mock.onPut(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Update
mock.onPut(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Update
mock.onPut(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['teamid','teammemberid'];
    const matchArray:any = new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Update
mock.onPut(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Update
mock.onPut(new RegExp(/^\/systeammembers\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teammemberid'];
    const matchArray:any = new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['teammemberid'] == tempValue['teammemberid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});


// FetchDefault
mock.onGet(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','deptid','userid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDefault
mock.onGet(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','userid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDefault
mock.onGet(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['deptid','userid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDefault
mock.onGet(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['teamid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDefault
mock.onGet(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['userid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/fetchdefault$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchDefault
mock.onGet(new RegExp(/^\/systeammembers\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchDefault
mock.onGet(new RegExp(/^\/systeammembers\/fetchdefault(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现


// Select
mock.onGet(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});


// Select
mock.onGet(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['orgid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});


// Select
mock.onGet(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});


// Select
mock.onGet(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['teamid','teammemberid'];
    const matchArray:any = new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});


// Select
mock.onGet(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});

// Select
mock.onGet(new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teammemberid'];
    const matchArray:any = new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});


// Get
mock.onGet(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['orgid','deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['orgid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teamid','teammemberid'];
    const matchArray:any = new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teammemberid'];
    const matchArray:any = new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['orgid','deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['orgid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysorganizations\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['deptid','userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysdepartments\/([a-zA-Z0-9\-\;]{1,35})\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teamid','teammemberid'];
    const matchArray:any = new RegExp(/^\/systeams\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['userid','teammemberid'];
    const matchArray:any = new RegExp(/^\/sysemployees\/([a-zA-Z0-9\-\;]{1,35})\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:systeammember 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['teammemberid'];
    const matchArray:any = new RegExp(/^\/systeammembers\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.teammemberid, tempValue.teammemberid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});
