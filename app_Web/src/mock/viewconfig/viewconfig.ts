import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "ibzdepartmentpickupview": {
            "title": "部门选择视图",
            "caption": "部门",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDepartmentPickupView",
            "viewtag": "10dd7f45f36233049c4af9ca417089f5"
        },
        "ibzemployeeeditview": {
            "title": "人员编辑视图",
            "caption": "人员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "IBZEmployeeEditView",
            "viewtag": "119fe650e7efd26bd14bd413cae37ded"
        },
        "wfmembergridview": {
            "title": "成员表格视图",
            "caption": "成员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFMemberGridView",
            "viewtag": "135872676ba63d430b2f20bd20364286"
        },
        "sysrolegridview": {
            "title": "角色表格视图",
            "caption": "系统角色",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRoleGridView",
            "viewtag": "13c174556f45e9b10b66dc51834a6ab5"
        },
        "wfgrouppickupgridview": {
            "title": "角色/用户组选择表格视图",
            "caption": "角色/用户组",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupPickupGridView",
            "viewtag": "17ccd6d8d2bb7cf30158253da129ec1b"
        },
        "sysusermpickupview": {
            "title": "用户表数据多项选择视图",
            "caption": "系统用户",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserMPickupView",
            "viewtag": "1f8cf7e78d6d88588d1d568d1866cc77"
        },
        "sysauthloggridview": {
            "title": "认证日志表格视图",
            "caption": "认证日志",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysAuthLogGridView",
            "viewtag": "255944d6d1a575d0eda2b68bc19314f3"
        },
        "sysrolepickupview": {
            "title": "角色数据选择视图",
            "caption": "系统角色",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePickupView",
            "viewtag": "26cc2d5c69f1525eaa415b7de1a0d4a6"
        },
        "ibzorganizationoptionview": {
            "title": "单位机构选项操作视图",
            "caption": "单位机构",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "ou",
            "viewname": "IBZOrganizationOptionView",
            "viewtag": "2ed85bebb69b8d23388420b95163228a"
        },
        "sysuserpickupview": {
            "title": "用户表数据选择视图",
            "caption": "系统用户",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserPickupView",
            "viewtag": "32fe9ab4a9e1b8d62b9ee802e4746965"
        },
        "wfprocessdefinitioneditview": {
            "title": "实体编辑视图",
            "caption": "流程定义",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFProcessDefinitionEditView",
            "viewtag": "3fcd491c13d05ab7dcce8d2c920d0aec"
        },
        "ibzemployeegridview": {
            "title": "人员表格视图",
            "caption": "人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "IBZEmployeeGridView",
            "viewtag": "40fe6b28b9f7902341da46bb74a02d59"
        },
        "syspermissionpickupview": {
            "title": "权限表数据选择视图",
            "caption": "权限/资源",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysPermissionPickupView",
            "viewtag": "53385c6effc6ba778dbccf82286fbe4f"
        },
        "ibzemployeechangepwdview": {
            "title": "人员编辑视图",
            "caption": "人员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "IBZEmployeeChangePwdView",
            "viewtag": "55cd5acdacb8aecec7d4574216e10625"
        },
        "wfremodeleditview": {
            "title": "流程模型编辑视图",
            "caption": "流程模型",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFREModelEditView",
            "viewtag": "5856bfb8b576cc2ee743801b23e58299"
        },
        "ibzdeptmembergridview": {
            "title": "部门成员表格视图",
            "caption": "部门成员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDeptMemberGridView",
            "viewtag": "61541167ccebbc3f174242ce73e436dd"
        },
        "wfuserpickupview": {
            "title": "用户数据选择视图",
            "caption": "用户",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserPickupView",
            "viewtag": "61c5bff70bcf56e1dc0bb0900df9c98c"
        },
        "ibzorganizationtreeexpview": {
            "title": "单位机构树导航视图",
            "caption": "部门管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ou",
            "viewname": "IBZOrganizationTreeExpView",
            "viewtag": "6435e95f9bd03acceda6b7fd610873db"
        },
        "sysuserrolegridview": {
            "title": "用户角色关系表表格视图",
            "caption": "用户角色关系",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserRoleGridView",
            "viewtag": "6736591aca71edc23df760e278378566"
        },
        "sysuserpickupgridview": {
            "title": "用户表选择表格视图",
            "caption": "系统用户",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserPickupGridView",
            "viewtag": "6869875c7409bd1dddd3d0fc62c502db"
        },
        "sysroleeditview": {
            "title": "角色编辑视图",
            "caption": "系统角色",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRoleEditView",
            "viewtag": "6bd0981f6dd67a59f211b5cf97ac8f30"
        },
        "wfmembereditview": {
            "title": "成员编辑视图",
            "caption": "成员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFMemberEditView",
            "viewtag": "6e1b35989dd6470b5c890369ab87b545"
        },
        "ibzdepartmentgridview": {
            "title": "部门表格视图",
            "caption": "部门",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDepartmentGridView",
            "viewtag": "7362390ee25dac238b23fa9ab05ea4ac"
        },
        "sysrolepickupgridview": {
            "title": "角色选择表格视图",
            "caption": "系统角色",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePickupGridView",
            "viewtag": "7c25865f5864a734477c7cb987632f4f"
        },
        "wfusermpickupview": {
            "title": "用户数据多项选择视图",
            "caption": "用户",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserMPickupView",
            "viewtag": "84e5a5b589b434dfdc60a3d0ad087d37"
        },
        "syspermissionmpickupview": {
            "title": "权限表数据多项选择视图",
            "caption": "权限/资源",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysPermissionMPickupView",
            "viewtag": "86bd4f6d4f771870e10b9717046a1b14"
        },
        "wfgroupmpickupview": {
            "title": "角色/用户组数据多项选择视图",
            "caption": "角色/用户组",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupMPickupView",
            "viewtag": "90a777962337daaf4cffd846eecb1f0f"
        },
        "ibzdepartmenteditview": {
            "title": "部门编辑视图",
            "caption": "部门",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDepartmentEditView",
            "viewtag": "90c0ced2720b85d5e051e7935a93d3c5"
        },
        "syspermissionpickupgridview": {
            "title": "权限表选择表格视图",
            "caption": "权限/资源",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysPermissionPickupGridView",
            "viewtag": "95d8c933cf4df47634a25d791b3d8564"
        },
        "ibzorganizationeditview": {
            "title": "单位机构编辑视图",
            "caption": "单位机构",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "IBZOrganizationEditView",
            "viewtag": "95e33ff2469ba40d3e0c00f5c3f61501"
        },
        "ibzdepartmentmpickupview": {
            "title": "部门数据多项选择视图",
            "caption": "部门",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDepartmentMPickupView",
            "viewtag": "97224ac0397dbe38b4679b4060ee29e5"
        },
        "sysrolepermissioncustomview": {
            "title": "角色权限关系自定义视图",
            "caption": "角色权限关系",
            "viewtype": "DECUSTOMVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePermissionCustomView",
            "viewtag": "983f3ae1533a5cd62619dedb79bb4b28"
        },
        "ibzdepartmentoptionview": {
            "title": "部门选项操作视图",
            "caption": "部门",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDepartmentOptionView",
            "viewtag": "9cdad5e2bed51cdcd90b4b7fb3104a5a"
        },
        "ibzemployeeoptionview": {
            "title": "人员选项操作视图",
            "caption": "人员",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "ou",
            "viewname": "IBZEmployeeOptionView",
            "viewtag": "9cf7a70099bff83a10f6ae65c4d54692"
        },
        "ibzemployeepickupview": {
            "title": "人员数据选择视图",
            "caption": "人员",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "IBZEmployeePickupView",
            "viewtag": "9ffa35efe3d70cf4b9fa4e83dd1979c6"
        },
        "sysrolempickupview": {
            "title": "角色数据多项选择视图",
            "caption": "系统角色",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRoleMPickupView",
            "viewtag": "a1f8d44a9d7be49687062c63434b0f3f"
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
        "index": {
            "title": "Runtime",
            "caption": "ibizlab",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "rt",
            "viewname": "Index",
            "viewtag": "b50d665e5fb8a9da01406754e0ab5f15"
        },
        "ibzdeptmembereditview": {
            "title": "部门成员编辑视图",
            "caption": "部门成员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDeptMemberEditView",
            "viewtag": "bf5e850471bab461fbb6739578e510c5"
        },
        "wfprocessdefinitiongridview": {
            "title": "实体表格视图",
            "caption": "流程定义",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFProcessDefinitionGridView",
            "viewtag": "bfa86be8c02420f87d5cf4ff9a768948"
        },
        "ibzdepartmenttreeexpview": {
            "title": "部门树导航视图",
            "caption": "人员管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDepartmentTreeExpView",
            "viewtag": "c0cdac5d5b5691ae8a326f5972aec67f"
        },
        "ibzorganizationgridview": {
            "title": "单位机构表格视图",
            "caption": "单位机构",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "IBZOrganizationGridView",
            "viewtag": "c42bc30741bd6add20b00494231dfa24"
        },
        "ibzemployeepickupgridview": {
            "title": "人员选择表格视图",
            "caption": "人员",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "IBZEmployeePickupGridView",
            "viewtag": "c84df2684f29705ac6c5dec67df9f217"
        },
        "wfuserpickupgridview": {
            "title": "用户选择表格视图",
            "caption": "用户",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserPickupGridView",
            "viewtag": "c9c73c8d2e61bd29a304622f3d39b522"
        },
        "ibzorganizationpickupview": {
            "title": "单位机构数据选择视图",
            "caption": "单位机构",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "IBZOrganizationPickupView",
            "viewtag": "ccff36439eacae953f85ff636c9dac74"
        },
        "ibzorganizationpickupgridview": {
            "title": "单位机构选择表格视图",
            "caption": "单位机构",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "IBZOrganizationPickupGridView",
            "viewtag": "cf8e6d455f8e88e66bbbe1bdb4c84274"
        },
        "ibzemployeempickupview": {
            "title": "人员数据多项选择视图",
            "caption": "人员",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "IBZEmployeeMPickupView",
            "viewtag": "d946240b09028ae684e1eb31281a4caf"
        },
        "ibzdepartmentpickupgridview": {
            "title": "部门选择表格视图",
            "caption": "部门",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "IBZDepartmentPickupGridView",
            "viewtag": "e3284e895913f7d38d1bcbe898bda0b7"
        },
        "sysuserroleeditview": {
            "title": "用户角色关系表编辑视图",
            "caption": "用户角色关系",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserRoleEditView",
            "viewtag": "edde313015e1db7c366028307d88d20c"
        },
        "wfgroupgridview": {
            "title": "角色/用户组表格视图",
            "caption": "角色/用户组",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupGridView",
            "viewtag": "f498dfb24e88df7c70a5c09ecb587647"
        }
    }];
});