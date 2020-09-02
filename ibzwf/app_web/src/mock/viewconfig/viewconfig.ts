import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "wfindexview": {
            "title": "workflow",
            "caption": "ibizlab",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "workflow",
            "viewname": "WFIndexView",
            "viewtag": "096fd4090f21e0fa0f4a303ed9041bff"
        },
        "wfmembergridview": {
            "title": "成员表格视图",
            "caption": "成员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFMemberGridView",
            "viewtag": "135872676ba63d430b2f20bd20364286"
        },
        "wfgrouppickupgridview": {
            "title": "角色/用户组选择表格视图",
            "caption": "角色/用户组",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupPickupGridView",
            "viewtag": "17ccd6d8d2bb7cf30158253da129ec1b"
        },
        "wfprocessdefinitioneditview": {
            "title": "流程定义查看",
            "caption": "流程定义查看",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFProcessDefinitionEditView",
            "viewtag": "3fcd491c13d05ab7dcce8d2c920d0aec"
        },
        "wfremodeleditview": {
            "title": "流程模型编辑视图",
            "caption": "流程模型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFREModelEditView",
            "viewtag": "5856bfb8b576cc2ee743801b23e58299"
        },
        "wfuserpickupview": {
            "title": "用户数据选择视图",
            "caption": "用户",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserPickupView",
            "viewtag": "61c5bff70bcf56e1dc0bb0900df9c98c"
        },
        "wftaskgridview": {
            "title": "我的待办",
            "caption": "我的待办",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFTaskGridView",
            "viewtag": "66f4bcca719e75fa9645380cc81bc3e2"
        },
        "wfmembereditview": {
            "title": "成员编辑视图",
            "caption": "成员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFMemberEditView",
            "viewtag": "6e1b35989dd6470b5c890369ab87b545"
        },
        "wfusermpickupview": {
            "title": "用户数据多项选择视图",
            "caption": "用户",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserMPickupView",
            "viewtag": "84e5a5b589b434dfdc60a3d0ad087d37"
        },
        "wfgroupmpickupview": {
            "title": "角色/用户组数据多项选择视图",
            "caption": "角色/用户组",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupMPickupView",
            "viewtag": "90a777962337daaf4cffd846eecb1f0f"
        },
        "wfgrouppickupview": {
            "title": "角色/用户组数据选择视图",
            "caption": "角色/用户组",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupPickupView",
            "viewtag": "b05c9353d499f973106e6ed4dde58074"
        },
        "wfgroupeditview": {
            "title": "角色/用户组编辑视图",
            "caption": "角色/用户组",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupEditView",
            "viewtag": "b23a721ca159ac2490b768d795e85d17"
        },
        "wfprocessdefinitiongridview": {
            "title": "流程定义",
            "caption": "流程定义",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFProcessDefinitionGridView",
            "viewtag": "bfa86be8c02420f87d5cf4ff9a768948"
        },
        "wfuserpickupgridview": {
            "title": "用户选择表格视图",
            "caption": "用户",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserPickupGridView",
            "viewtag": "c9c73c8d2e61bd29a304622f3d39b522"
        },
        "wfusergridview": {
            "title": "用户表格视图",
            "caption": "用户",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserGridView",
            "viewtag": "cf0fdabd8378e07ca72ac167b1406756"
        },
        "wftaskeditview": {
            "title": "工作流任务编辑视图",
            "caption": "工作流任务",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFTaskEditView",
            "viewtag": "e3020680a441ab58a29db6fe2434f08b"
        },
        "wfgroupgridview": {
            "title": "角色/用户组表格视图",
            "caption": "角色/用户组",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupGridView",
            "viewtag": "f498dfb24e88df7c70a5c09ecb587647"
        },
        "wfusereditview": {
            "title": "用户编辑视图",
            "caption": "用户",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserEditView",
            "viewtag": "ffd6ce24e0a1aa780920b48721e502a7"
        }
    }];
});