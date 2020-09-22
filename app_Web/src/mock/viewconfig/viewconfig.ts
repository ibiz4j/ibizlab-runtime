import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'

// 获取studio链接数据
mock.onGet('./assets/json/view-config.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
                "sysdepartmentpickupgridview": {
            "title": "部门选择表格视图",
            "caption": "部门",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysDepartmentPickupGridView",
            "viewtag": "06dc389605323456129e342bbdfbbd16"
        },
        "syspostpickupview": {
            "title": "岗位数据选择视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "SysPostPickupView",
            "viewtag": "09089840aeb5b072e9d6217cdad34c03"
        },
        "dictoptioneditview": {
            "title": "字典项",
            "caption": "字典项",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "dict",
            "viewname": "DictOptionEditView",
            "viewtag": "0986ae2314847b586b20edfbb40fc82b"
        },
        "sysdepartmenttreeexpview": {
            "title": "人员管理",
            "caption": "人员管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ou",
            "viewname": "SysDepartmentTreeExpView",
            "viewtag": "0f73ceaa7ce0ec11d9b6aaf27e05ad4f"
        },
        "wfmembergridview": {
            "title": "流程角色",
            "caption": "流程角色",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFMemberGridView",
            "viewtag": "135872676ba63d430b2f20bd20364286"
        },
        "sysrolegridview": {
            "title": "用户角色",
            "caption": "用户角色",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRoleGridView",
            "viewtag": "13c174556f45e9b10b66dc51834a6ab5"
        },
        "sysdepartmenteditview": {
            "title": "部门管理",
            "caption": "部门管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "SysDepartmentEditView",
            "viewtag": "16e80ec413946364504f9f79bce1e0ba"
        },
        "wfgrouppickupgridview": {
            "title": "角色/用户组选择表格视图",
            "caption": "角色/用户组",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupPickupGridView",
            "viewtag": "17ccd6d8d2bb7cf30158253da129ec1b"
        },
        "sysdepartmentgridview": {
            "title": "部门表格视图",
            "caption": "部门",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysDepartmentGridView",
            "viewtag": "1a71a212ed794d05b51b9c825b9cf19a"
        },
        "sysuserautheditview": {
            "title": "账号编辑视图",
            "caption": "账号绑定",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserAuthEditView",
            "viewtag": "1ee5253453314436a2c78ca1dfa87bc6"
        },
        "sysappgridview": {
            "title": "接入应用",
            "caption": "接入应用",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysAppGridView",
            "viewtag": "1ef170b14b7a70f4609a9f13692d1414"
        },
        "sysusermpickupview": {
            "title": "用户表数据多项选择视图",
            "caption": "系统用户",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserMPickupView",
            "viewtag": "1f8cf7e78d6d88588d1d568d1866cc77"
        },
        "sysposteditview": {
            "title": "岗位管理",
            "caption": "岗位管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "SysPostEditView",
            "viewtag": "22be3cbaf3e2beeb404f53573f0a917a"
        },
        "dictoptiongridview": {
            "title": "字典项",
            "caption": "字典项",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "dict",
            "viewname": "DictOptionGridView",
            "viewtag": "22e202992971f634c00e022b2cae335e"
        },
        "sysauthloggridview": {
            "title": "认证日志",
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
        "sysopenaccessgridview": {
            "title": "第三方认证平台",
            "caption": "第三方认证平台",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysOpenAccessGridView",
            "viewtag": "29ebd67c0eba9fb1464bcd1397112f6f"
        },
        "sysuserpickupview": {
            "title": "用户表数据选择视图",
            "caption": "系统用户",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserPickupView",
            "viewtag": "32fe9ab4a9e1b8d62b9ee802e4746965"
        },
        "sysopenaccesseditview": {
            "title": "第三方认证平台",
            "caption": "第三方认证平台",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysOpenAccessEditView",
            "viewtag": "349cda61e4dc5e38045ef7c77321d1c7"
        },
        "sysorganizationpickupgridview": {
            "title": "单位机构选择表格视图",
            "caption": "单位机构",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysOrganizationPickupGridView",
            "viewtag": "3cbffb72d0ebf81304545ddeda64c066"
        },
        "jobsregistrygridview": {
            "title": "注册",
            "caption": "注册",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "task",
            "viewname": "JobsRegistryGridView",
            "viewtag": "3fc39744066bd5343be378ec5703f556"
        },
        "wfprocessdefinitioneditview": {
            "title": "流程定义",
            "caption": "流程定义",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFProcessDefinitionEditView",
            "viewtag": "3fcd491c13d05ab7dcce8d2c920d0aec"
        },
        "sysappeditview": {
            "title": "接入应用",
            "caption": "接入应用",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysAppEditView",
            "viewtag": "3febdb3ae99351887f24b7c9db070de8"
        },
        "dictoptiongrideditview": {
            "title": "字典项",
            "caption": "字典项",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "dict",
            "viewname": "DictOptionGridEditView",
            "viewtag": "44488f30cf90677019077ed9ad33628e"
        },
        "sysorganizationeditview": {
            "title": "单位管理",
            "caption": "单位管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "SysOrganizationEditView",
            "viewtag": "456373e5385deb29b6863c5a22c8a29a"
        },
        "sysemployeeoptionview": {
            "title": "人员选项操作视图",
            "caption": "人员",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "ou",
            "viewname": "SysEmployeeOptionView",
            "viewtag": "463709b32df0a807dc1d2e6d2db77dd1"
        },
        "jobsinfoeditview": {
            "title": "任务",
            "caption": "任务",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "task",
            "viewname": "JobsInfoEditView",
            "viewtag": "49b6b437f10c4e73e47d87d5d0f76cfd"
        },
        "sysdeptmembergridview": {
            "title": "部门成员表格视图",
            "caption": "部门成员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysDeptMemberGridView",
            "viewtag": "523b25cb9c95d2ef731c39ca24cfe98a"
        },
        "syspermissionpickupview": {
            "title": "权限表数据选择视图",
            "caption": "权限/资源",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysPermissionPickupView",
            "viewtag": "53385c6effc6ba778dbccf82286fbe4f"
        },
        "jobsregistryeditview": {
            "title": "注册",
            "caption": "注册",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "task",
            "viewname": "JobsRegistryEditView",
            "viewtag": "56cc39a16e3269c082694b50f89338e3"
        },
        "wfremodeleditview": {
            "title": "发布新流程",
            "caption": "发布新流程",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFREModelEditView",
            "viewtag": "5856bfb8b576cc2ee743801b23e58299"
        },
        "sysorganizationtreeexpview": {
            "title": "部门管理",
            "caption": "部门管理",
            "viewtype": "DETREEEXPVIEW",
            "viewmodule": "ou",
            "viewname": "SysOrganizationTreeExpView",
            "viewtag": "5c403d904f82265cde504f205e98f95e"
        },
        "systeameditview": {
            "title": "组管理",
            "caption": "组管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "SysTeamEditView",
            "viewtag": "5f46660051966f3e0b4c377decd638b1"
        },
        "wfuserpickupview": {
            "title": "用户数据选择视图",
            "caption": "用户",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserPickupView",
            "viewtag": "61c5bff70bcf56e1dc0bb0900df9c98c"
        },
        "sysorganizationgridview": {
            "title": "单位管理",
            "caption": "单位管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysOrganizationGridView",
            "viewtag": "64f014192d8afcee483c623ee8a2b07b"
        },
        "syspostpickupgridview": {
            "title": "岗位选择表格视图",
            "caption": "岗位",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysPostPickupGridView",
            "viewtag": "65c16575fd8b1fa8bf111e17f573f697"
        },
        "sysdepartmentoptionview": {
            "title": "部门选项操作视图",
            "caption": "部门",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "ou",
            "viewname": "SysDepartmentOptionView",
            "viewtag": "67360f94c8e641ed5c329dee6dc6639e"
        },
        "sysuserrolegridview": {
            "title": "用户角色关系表表格视图",
            "caption": "用户角色关系",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserRoleGridView",
            "viewtag": "6736591aca71edc23df760e278378566"
        },
        "jobsloggridview": {
            "title": "日志",
            "caption": "日志",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "task",
            "viewname": "JobsLogGridView",
            "viewtag": "67b4d1e928a08679ce63051ccc88da9c"
        },
        "sysemployeegridview": {
            "title": "人员表格视图",
            "caption": "人员",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysEmployeeGridView",
            "viewtag": "67d7a9f7291d44a10ffc356769bcac1d"
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
            "title": "用户角色",
            "caption": "用户角色",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRoleEditView",
            "viewtag": "6bd0981f6dd67a59f211b5cf97ac8f30"
        },
        "wfmembereditview": {
            "title": "流程角色",
            "caption": "流程角色",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFMemberEditView",
            "viewtag": "6e1b35989dd6470b5c890369ab87b545"
        },
        "dictcataloggridview": {
            "title": "目录",
            "caption": "目录",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "dict",
            "viewname": "DictCatalogGridView",
            "viewtag": "74a6ce3ddf610ce7fb201662c6d4b8da"
        },
        "sysrolepickupgridview": {
            "title": "角色选择表格视图",
            "caption": "系统角色",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePickupGridView",
            "viewtag": "7c25865f5864a734477c7cb987632f4f"
        },
        "sysorganizationpickupview": {
            "title": "单位机构数据选择视图",
            "caption": "单位机构",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "SysOrganizationPickupView",
            "viewtag": "82ba8656757a5080e5265648aab13de7"
        },
        "dictcatalogpickupgridview": {
            "title": "字典选择表格视图",
            "caption": "字典",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "dict",
            "viewname": "DictCatalogPickupGridView",
            "viewtag": "842cfc03d5e93435fc52d317a55cdfd4"
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
        "systeammembergridview": {
            "title": "组管理",
            "caption": "组管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysTeamMemberGridView",
            "viewtag": "89ff98e46167a4688e63362931496818"
        },
        "wfgroupmpickupview": {
            "title": "角色/用户组数据多项选择视图",
            "caption": "角色/用户组",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupMPickupView",
            "viewtag": "90a777962337daaf4cffd846eecb1f0f"
        },
        "sysorganizationoptionview": {
            "title": "单位机构选项操作视图",
            "caption": "单位机构",
            "viewtype": "DEOPTVIEW",
            "viewmodule": "ou",
            "viewname": "SysOrganizationOptionView",
            "viewtag": "915900ff6a784bf46e91a9a6aec79cf0"
        },
        "syspermissionpickupgridview": {
            "title": "权限表选择表格视图",
            "caption": "权限/资源",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysPermissionPickupGridView",
            "viewtag": "95d8c933cf4df47634a25d791b3d8564"
        },
        "sysrolepermissioncustomview": {
            "title": "角色权限关系自定义视图",
            "caption": "角色权限关系",
            "viewtype": "DECUSTOMVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRolePermissionCustomView",
            "viewtag": "983f3ae1533a5cd62619dedb79bb4b28"
        },
        "sysrolempickupview": {
            "title": "角色数据多项选择视图",
            "caption": "系统角色",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "uaa",
            "viewname": "SysRoleMPickupView",
            "viewtag": "a1f8d44a9d7be49687062c63434b0f3f"
        },
        "syspostgridview": {
            "title": "岗位管理",
            "caption": "岗位管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysPostGridView",
            "viewtag": "a26ed59459b6d3b6f7ff36ad38b06c1b"
        },
        "dictcatalogpickupview": {
            "title": "字典数据选择视图",
            "caption": "字典",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "dict",
            "viewname": "DictCatalogPickupView",
            "viewtag": "a9c82814d9bcd23dbf78c4c073759d7c"
        },
        "sysemployeechangepwdview": {
            "title": "人员编辑视图",
            "caption": "人员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "SysEmployeeChangePwdView",
            "viewtag": "acaeba3ced75ad754dd6cf0b3b11fbcc"
        },
        "sysemployeepickupview": {
            "title": "人员数据选择视图",
            "caption": "人员",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "SysEmployeePickupView",
            "viewtag": "ad75752476891204e7b409cabc499e70"
        },
        "dictcatalogeditview": {
            "title": "目录",
            "caption": "目录",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "dict",
            "viewname": "DictCatalogEditView",
            "viewtag": "aef11c4ae15f8255ee53623adf148f2a"
        },
        "sysemployeempickupview": {
            "title": "人员数据多项选择视图",
            "caption": "人员",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "SysEmployeeMPickupView",
            "viewtag": "af7290279f8b7645020401c1beb9269e"
        },
        "wfgrouppickupview": {
            "title": "角色/用户组数据选择视图",
            "caption": "角色/用户组",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupPickupView",
            "viewtag": "b05c9353d499f973106e6ed4dde58074"
        },
        "sysemployeeeditview": {
            "title": "人员管理",
            "caption": "人员管理",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "SysEmployeeEditView",
            "viewtag": "b1abd7783d9e3b9393630428ebde3a86"
        },
        "wfgroupeditview": {
            "title": "流程角色",
            "caption": "流程角色",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupEditView",
            "viewtag": "b23a721ca159ac2490b768d795e85d17"
        },
        "systeammembereditview": {
            "title": "组成员编辑视图",
            "caption": "组成员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "SysTeamMemberEditView",
            "viewtag": "b2d81cb8d4121eb95c848e5b1cbfddd8"
        },
        "jobslogeditview": {
            "title": "日志",
            "caption": "日志",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "task",
            "viewname": "JobsLogEditView",
            "viewtag": "b4b9140b8844a2d60cfc7944cd4f5b79"
        },
        "index": {
            "title": "Runtime",
            "caption": "ibizlab",
            "viewtype": "APPINDEXVIEW",
            "viewmodule": "rt",
            "viewname": "Index",
            "viewtag": "b50d665e5fb8a9da01406754e0ab5f15"
        },
        "wfprocessdefinitiongridview": {
            "title": "流程定义",
            "caption": "流程定义",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFProcessDefinitionGridView",
            "viewtag": "bfa86be8c02420f87d5cf4ff9a768948"
        },
        "sysdeptmembereditview": {
            "title": "部门成员编辑视图",
            "caption": "部门成员",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "ou",
            "viewname": "SysDeptMemberEditView",
            "viewtag": "c52fb5e147b7ab7e6cfe158e2494de19"
        },
        "wfuserpickupgridview": {
            "title": "用户选择表格视图",
            "caption": "用户",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFUserPickupGridView",
            "viewtag": "c9c73c8d2e61bd29a304622f3d39b522"
        },
        "sysdepartmentpickupview": {
            "title": "部门选择视图",
            "caption": "部门",
            "viewtype": "DEPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "SysDepartmentPickupView",
            "viewtag": "d076f344eefde0fdc8d5ea6eab40e4c5"
        },
        "systeamgridview": {
            "title": "组管理",
            "caption": "组管理",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysTeamGridView",
            "viewtag": "d356c19266944e00bc8ebc1bbd85ca7c"
        },
        "sysdepartmentmpickupview": {
            "title": "部门数据多项选择视图",
            "caption": "部门",
            "viewtype": "DEMPICKUPVIEW",
            "viewmodule": "ou",
            "viewname": "SysDepartmentMPickupView",
            "viewtag": "df6caa8751fdf4ee4918b55727f025a9"
        },
        "jobsinfogridview": {
            "title": "任务",
            "caption": "任务",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "task",
            "viewname": "JobsInfoGridView",
            "viewtag": "e4856779577562e9880855e6c66d63e5"
        },
        "sysemployeepickupgridview": {
            "title": "人员选择表格视图",
            "caption": "人员",
            "viewtype": "DEPICKUPGRIDVIEW",
            "viewmodule": "ou",
            "viewname": "SysEmployeePickupGridView",
            "viewtag": "ed2bd80851a999d7a0d70ea15507ad0d"
        },
        "sysuserroleeditview": {
            "title": "用户角色",
            "caption": "用户角色",
            "viewtype": "DEEDITVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserRoleEditView",
            "viewtag": "edde313015e1db7c366028307d88d20c"
        },
        "wfgroupgridview": {
            "title": "流程角色",
            "caption": "流程角色",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "workflow",
            "viewname": "WFGroupGridView",
            "viewtag": "f498dfb24e88df7c70a5c09ecb587647"
        },
        "sysuserauthgridview": {
            "title": "账号表格视图",
            "caption": "账号绑定",
            "viewtype": "DEGRIDVIEW",
            "viewmodule": "uaa",
            "viewname": "SysUserAuthGridView",
            "viewtag": "fd7c41ae2348a07694aa65a26bca0df5"
        }
    }];
});

// 获取视图消息分组信息
mock.onGet('./assets/json/view-message-group.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
    }];
});