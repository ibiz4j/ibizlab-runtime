import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "wfmembergridview": {
            "title": "成员表格视图",
            "caption": "成员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFMemberGridView",
            "viewtag": "2543a3f227c806c6433bf9710717de93"
        },
        "wfindexview": {
            "title": "workflow",
            "caption": "ibizlab",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "workflow",
            "viewname": "WFIndexView",
            "viewtag": "380EA9D7-5F04-46C1-9E82-2877EE29336A"
        },
        "wfusermpickupview": {
            "title": "用户数据多项选择视图",
            "caption": "用户",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserMPickupView",
            "viewtag": "3b32fb97ab849d5f36e8a283c85b5098"
        },
        "wfuserpickupview": {
            "title": "用户数据选择视图",
            "caption": "用户",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserPickupView",
            "viewtag": "5592ca3571d551675c5306a0a9f1352e"
        },
        "wfgroupmpickupview": {
            "title": "角色/用户组数据多项选择视图",
            "caption": "角色/用户组",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupMPickupView",
            "viewtag": "5db49698557288612b9247b259ffbcd7"
        },
        "wftaskgridview": {
            "title": "我的待办",
            "caption": "我的待办",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFTaskGridView",
            "viewtag": "67f605f39e4d0d7cfa524ea97bc29ced"
        },
        "wfusereditview": {
            "title": "用户编辑视图",
            "caption": "用户",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserEditView",
            "viewtag": "77dd35badedcc0f6b98e83ee1ff82bda"
        },
        "wftaskeditview": {
            "title": "工作流任务编辑视图",
            "caption": "工作流任务",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFTaskEditView",
            "viewtag": "84f38898137b7bd1f9f135ac74b4b850"
        },
        "wfprocessdefinitioneditview": {
            "title": "流程定义查看",
            "caption": "流程定义查看",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFProcessDefinitionEditView",
            "viewtag": "9aad4530afb58f5c348a5b21d9c7ae72"
        },
        "wfprocessdefinitiongridview": {
            "title": "流程定义",
            "caption": "流程定义",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFProcessDefinitionGridView",
            "viewtag": "a06aed382ebc28e6521b4398880388cd"
        },
        "wfuserpickupgridview": {
            "title": "用户选择表格视图",
            "caption": "用户",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserPickupGridView",
            "viewtag": "a9dfca1bcb877df49bfed9a2bd177d14"
        },
        "wfmembereditview": {
            "title": "成员编辑视图",
            "caption": "成员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFMemberEditView",
            "viewtag": "ac7cba0b131aa74021747169735a4f90"
        },
        "wfgroupeditview": {
            "title": "角色/用户组编辑视图",
            "caption": "角色/用户组",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupEditView",
            "viewtag": "aeb28973b7182f671fa50aa5d87e9346"
        },
        "wfgrouppickupview": {
            "title": "角色/用户组数据选择视图",
            "caption": "角色/用户组",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupPickupView",
            "viewtag": "bfd32eedd618add6408b75a98f40f809"
        },
        "wfremodeleditview": {
            "title": "流程模型编辑视图",
            "caption": "流程模型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFREModelEditView",
            "viewtag": "c0e7fb60c35f15d4f23800acae7afbd1"
        },
        "wfgrouppickupgridview": {
            "title": "角色/用户组选择表格视图",
            "caption": "角色/用户组",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupPickupGridView",
            "viewtag": "c539c8d177b0401b79fa0808de6f13dd"
        },
        "wfusergridview": {
            "title": "用户表格视图",
            "caption": "用户",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserGridView",
            "viewtag": "ec44dccb75670532aa3e9bfae73c4259"
        },
        "wfgroupgridview": {
            "title": "角色/用户组表格视图",
            "caption": "角色/用户组",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupGridView",
            "viewtag": "f11ad9a3b9260fb68a2a2e870419bffa"
        }
    }];
});