import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "jobsregistrygridview": {
            "title": "任务注册信息表格视图",
            "caption": "任务注册信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "task",
            "viewname": "JobsRegistryGridView",
            "viewtag": "3fc39744066bd5343be378ec5703f556"
        },
        "jobsinfoeditview": {
            "title": "任务信息编辑视图",
            "caption": "任务信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "task",
            "viewname": "JobsInfoEditView",
            "viewtag": "49b6b437f10c4e73e47d87d5d0f76cfd"
        },
        "jobsregistryeditview": {
            "title": "任务注册信息编辑视图",
            "caption": "任务注册信息",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "task",
            "viewname": "JobsRegistryEditView",
            "viewtag": "56cc39a16e3269c082694b50f89338e3"
        },
        "jobsloggridview": {
            "title": "任务调度日志表格视图",
            "caption": "任务调度日志",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "task",
            "viewname": "JobsLogGridView",
            "viewtag": "67b4d1e928a08679ce63051ccc88da9c"
        },
        "taskindexview": {
            "title": "task",
            "caption": "ibizlab",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "task",
            "viewname": "TaskIndexView",
            "viewtag": "aa348881bb7ef951e281edc58131246b"
        },
        "jobslogeditview": {
            "title": "任务调度日志编辑视图",
            "caption": "任务调度日志",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "task",
            "viewname": "JobsLogEditView",
            "viewtag": "b4b9140b8844a2d60cfc7944cd4f5b79"
        },
        "jobsinfogridview": {
            "title": "任务信息表格视图",
            "caption": "任务信息",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "task",
            "viewname": "JobsInfoGridView",
            "viewtag": "e4856779577562e9880855e6c66d63e5"
        }
    }];
});

// 获取视图消息分组信息
mock.onGet('./assets/json/view-message-group.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
    }];
});