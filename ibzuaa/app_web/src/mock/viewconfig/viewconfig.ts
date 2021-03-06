import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "sys_user_rolepickupview": {
            "title": "用户角色关系表数据选择视图",
            "caption": "用户角色关系",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USER_ROLEPickupView",
            "viewtag": "0a336ba91a0e94143e41ade26de43246"
        },
        "sysrolegridview": {
            "title": "角色",
            "caption": "角色",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRoleGridView",
            "viewtag": "13c174556f45e9b10b66dc51834a6ab5"
        },
        "sysusergridview": {
            "title": "用户",
            "caption": "用户",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserGridView",
            "viewtag": "1ea24a0d62ab391e6dbff850a804d9b2"
        },
        "sysappgridview": {
            "title": "接入应用",
            "caption": "接入应用",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysAppGridView",
            "viewtag": "1ef170b14b7a70f4609a9f13692d1414"
        },
        "sys_usermpickupview": {
            "title": "用户表数据多项选择视图",
            "caption": "系统用户",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USERMPickupView",
            "viewtag": "1f8cf7e78d6d88588d1d568d1866cc77"
        },
        "sys_permissioneditview2": {
            "title": "权限表编辑视图",
            "caption": "权限/资源",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "uaa",
            "viewname": "SYS_PERMISSIONEditView2",
            "viewtag": "24488cee58a4d8b8bf45f468b385cb9b"
        },
        "sysauthloggridview": {
            "title": "认证日志",
            "caption": "认证日志",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysAuthLogGridView",
            "viewtag": "255944d6d1a575d0eda2b68bc19314f3"
        },
        "sys_rolepickupview": {
            "title": "角色数据选择视图",
            "caption": "系统角色",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_ROLEPickupView",
            "viewtag": "26cc2d5c69f1525eaa415b7de1a0d4a6"
        },
        "sys_permissiongridview": {
            "title": "权限表表格视图",
            "caption": "权限/资源",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_PERMISSIONGridView",
            "viewtag": "289b56658be0136636e6183ba9888e5c"
        },
        "sysrolepermissiongridview": {
            "title": "角色权限关系表表格视图",
            "caption": "角色权限关系",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePermissionGridView",
            "viewtag": "29aee89d4b8aa6756862dc9f0b077feb"
        },
        "sysopenaccessgridview": {
            "title": "第三方认证平台",
            "caption": "第三方认证平台",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysOpenAccessGridView",
            "viewtag": "29ebd67c0eba9fb1464bcd1397112f6f"
        },
        "sysrolepermissionmpickupview": {
            "title": "角色权限关系表数据多项选择视图",
            "caption": "角色权限关系",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePermissionMPickupView",
            "viewtag": "2cd587cefc5e7ded579bf8fe5564a74e"
        },
        "sys_userpickupview": {
            "title": "用户表数据选择视图",
            "caption": "系统用户",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USERPickupView",
            "viewtag": "32fe9ab4a9e1b8d62b9ee802e4746965"
        },
        "sysrolepickupgridview_norepeat": {
            "title": "角色选择表格视图",
            "caption": "系统角色",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePickupGridView_norepeat",
            "viewtag": "33f07a06a447590e710527a19d5f02c7"
        },
        "sysopenaccesseditview": {
            "title": "第三方认证平台",
            "caption": "第三方认证平台",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysOpenAccessEditView",
            "viewtag": "349cda61e4dc5e38045ef7c77321d1c7"
        },
        "sysappeditview": {
            "title": "接入应用",
            "caption": "接入应用",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysAppEditView",
            "viewtag": "3febdb3ae99351887f24b7c9db070de8"
        },
        "sys_usereditview2": {
            "title": "用户表编辑视图",
            "caption": "系统用户",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "uaa",
            "viewname": "SYS_USEREditView2",
            "viewtag": "43725511a6bb71d484c70def89a910b7"
        },
        "sys_permissionpickupview": {
            "title": "权限表数据选择视图",
            "caption": "权限/资源",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_PERMISSIONPickupView",
            "viewtag": "53385c6effc6ba778dbccf82286fbe4f"
        },
        "sysuserroleeditview2": {
            "title": "用户",
            "caption": "用户",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "uaa",
            "viewname": "SysUserRoleEditView2",
            "viewtag": "5f3c84ff2431eb5d992a129e3a191305"
        },
        "sys_roleredirectview": {
            "title": "角色数据重定向视图",
            "caption": "系统角色",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_ROLERedirectView",
            "viewtag": "60e54bd07ebd398425da9a4999649c28"
        },
        "index": {
            "title": "uaa",
            "caption": "ibizlab",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "uaa",
            "viewname": "Index",
            "viewtag": "626d13441f128eec2b5b4fd472626ef9"
        },
        "sys_role_permissionpickupgridview": {
            "title": "角色权限关系表选择表格视图",
            "caption": "角色权限关系",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_ROLE_PERMISSIONPickupGridView",
            "viewtag": "6356f0e18071b7833d371645a32d09a0"
        },
        "sys_role_permissioneditview2": {
            "title": "角色权限关系表编辑视图",
            "caption": "角色权限关系",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "uaa",
            "viewname": "SYS_ROLE_PERMISSIONEditView2",
            "viewtag": "63c292726f05b3c86cfd48fb90245f23"
        },
        "sys_user_rolegridview": {
            "title": "用户角色关系表表格视图",
            "caption": "用户角色关系",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USER_ROLEGridView",
            "viewtag": "6736591aca71edc23df760e278378566"
        },
        "sys_userpickupgridview": {
            "title": "用户表选择表格视图",
            "caption": "系统用户",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USERPickupGridView",
            "viewtag": "6869875c7409bd1dddd3d0fc62c502db"
        },
        "sysroleeditview": {
            "title": "角色",
            "caption": "角色",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRoleEditView",
            "viewtag": "6bd0981f6dd67a59f211b5cf97ac8f30"
        },
        "sys_user_rolepickupgridview": {
            "title": "用户角色关系表选择表格视图",
            "caption": "用户角色关系",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USER_ROLEPickupGridView",
            "viewtag": "727613036152932e67097969f0ee5b3d"
        },
        "sysrolepickupgridview": {
            "title": "角色选择表格视图",
            "caption": "系统角色",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePickupGridView",
            "viewtag": "7c25865f5864a734477c7cb987632f4f"
        },
        "sys_permissionmpickupview": {
            "title": "权限表数据多项选择视图",
            "caption": "权限/资源",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_PERMISSIONMPickupView",
            "viewtag": "86bd4f6d4f771870e10b9717046a1b14"
        },
        "sysrolepermissionredirectview": {
            "title": "角色权限关系表数据重定向视图",
            "caption": "角色权限关系",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePermissionRedirectView",
            "viewtag": "93445da4f0b5711d28cc535077d34a87"
        },
        "sys_permissionpickupgridview": {
            "title": "权限表选择表格视图",
            "caption": "权限/资源",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_PERMISSIONPickupGridView",
            "viewtag": "95d8c933cf4df47634a25d791b3d8564"
        },
        "sysroleeditview2": {
            "title": "角色",
            "caption": "角色",
            "viewtype": "DEEDITVIEW2",
            "viewmodule": "uaa",
            "viewname": "SysRoleEditView2",
            "viewtag": "96d56b07de869933ed16226add364ab5"
        },
        "sysrolepermissioncustomview": {
            "title": "角色权限关系自定义视图",
            "caption": "角色权限关系",
            "viewtype": "DECUSTOMVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePermissionCustomView",
            "viewtag": "983f3ae1533a5cd62619dedb79bb4b28"
        },
        "sys_permissioneditview": {
            "title": "权限表编辑视图",
            "caption": "权限/资源",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_PERMISSIONEditView",
            "viewtag": "a15736efd87b97c3cee2dae84ab88e74"
        },
        "sysusereditview": {
            "title": "用户",
            "caption": "用户",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserEditView",
            "viewtag": "a1a6ce3160dc33b09f22deaa5f301fda"
        },
        "sys_rolempickupview": {
            "title": "角色数据多项选择视图",
            "caption": "系统角色",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_ROLEMPickupView",
            "viewtag": "a1f8d44a9d7be49687062c63434b0f3f"
        },
        "sys_role_permissioneditview": {
            "title": "角色权限关系表编辑视图",
            "caption": "角色权限关系",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_ROLE_PERMISSIONEditView",
            "viewtag": "a93a129850b81c3c921aa1911ec9eb8c"
        },
        "sysrolepickupview_norepeat": {
            "title": "角色数据选择视图",
            "caption": "系统角色",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePickupView_norepeat",
            "viewtag": "ba8e31e716b14bba81cdf1281fc76197"
        },
        "sys_permissionredirectview": {
            "title": "权限表数据重定向视图",
            "caption": "权限/资源",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_PERMISSIONRedirectView",
            "viewtag": "d818f976305327fde2c09de9064ebefb"
        },
        "sys_user_roleredirectview": {
            "title": "用户角色关系表数据重定向视图",
            "caption": "用户角色关系",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USER_ROLERedirectView",
            "viewtag": "dec1737b837ff7a9dcf8717212860792"
        },
        "sysrolepermissionpickupview": {
            "title": "角色权限关系表数据选择视图",
            "caption": "角色权限关系",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePermissionPickupView",
            "viewtag": "eb57310ddf77a7cd59132cd74f197829"
        },
        "sysuserroleeditview": {
            "title": "用户",
            "caption": "用户",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserRoleEditView",
            "viewtag": "edde313015e1db7c366028307d88d20c"
        },
        "sys_userredirectview": {
            "title": "用户表数据重定向视图",
            "caption": "系统用户",
            "viewtype": "DEREDIRECTVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USERRedirectView",
            "viewtag": "f274f75a31e0c301efcc8d16698fb059"
        },
        "sys_user_rolempickupview": {
            "title": "用户角色关系表数据多项选择视图",
            "caption": "用户角色关系",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SYS_USER_ROLEMPickupView",
            "viewtag": "f9ea95b9d193ee076ea0d826270f8753"
        }
    }];
});

// 获取视图消息分组信息
mock.onGet('./assets/json/view-message-group.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
    }];
});