import sysrolepermission_zh_CN from '@locale/lanres/entities/sys-role-permission/sys-role-permission_zh_CN';
import sysuser_zh_CN from '@locale/lanres/entities/sys-user/sys-user_zh_CN';
import sysauthlog_zh_CN from '@locale/lanres/entities/sys-auth-log/sys-auth-log_zh_CN';
import wfmember_zh_CN from '@locale/lanres/entities/wfmember/wfmember_zh_CN';
import wfuser_zh_CN from '@locale/lanres/entities/wfuser/wfuser_zh_CN';
import ibzorganization_zh_CN from '@locale/lanres/entities/ibzorganization/ibzorganization_zh_CN';
import wfgroup_zh_CN from '@locale/lanres/entities/wfgroup/wfgroup_zh_CN';
import wfremodel_zh_CN from '@locale/lanres/entities/wfremodel/wfremodel_zh_CN';
import sysuserrole_zh_CN from '@locale/lanres/entities/sys-user-role/sys-user-role_zh_CN';
import wfprocessdefinition_zh_CN from '@locale/lanres/entities/wfprocess-definition/wfprocess-definition_zh_CN';
import sysrole_zh_CN from '@locale/lanres/entities/sys-role/sys-role_zh_CN';
import ibzdeptmember_zh_CN from '@locale/lanres/entities/ibzdept-member/ibzdept-member_zh_CN';
import ibzdepartment_zh_CN from '@locale/lanres/entities/ibzdepartment/ibzdepartment_zh_CN';
import syspermission_zh_CN from '@locale/lanres/entities/sys-permission/sys-permission_zh_CN';
import ibzemployee_zh_CN from '@locale/lanres/entities/ibzemployee/ibzemployee_zh_CN';
import components_zh_CN from '@locale/lanres/components/components_zh_CN';
import codelist_zh_CN from '@locale/lanres/codelist/codelist_zh_CN';
import userCustom_zh_CN from '@locale/lanres/userCustom/userCustom_zh_CN';

export default {
    app: {
        commonWords:{
            error: "失败",
            success: "成功",
            ok: "确认",
            cancel: "取消",
        },
        local:{
            new: "新建"
        },
        gridpage: {
            choicecolumns: "选择列",
            refresh: "刷新",
            show: "显示",
            records: "条",
            totle: "共",
        },
        tabpage: {
            sureclosetip: {
                title: "关闭提醒",
                content: "表单数据已经修改，确定要关闭？",
            },
            closeall: "关闭所有",
            closeother: "关闭其他",
        },
        fileUpload: {
            caption: "上传",
        },
        searchButton: {
            search: "搜索",
            reset: "重置",
        },
        calendar:{
          today: "今天",
          month: "月",
          week: "周",
          day: "天",
          list: "列",
          dateSelectModalTitle: "选择要跳转的时间",
          gotoDate: "跳转",
        },
        // 非实体视图
        views: {
            index: {
                caption: "ibizlab-runtime",
                title: "ibizlab",
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
        },
        menus: {
            index: {
                menuitem7: "单位人事",
                menuitem1: "单位管理",
                menuitem2: "部门管理",
                menuitem3: "人员管理",
                menuitem8: "系统权限",
                menuitem4: "用户角色",
                menuitem9: "认证日志",
                menuitem10: "流程管理",
                menuitem6: "流程定义",
                menuitem5: "流程角色",
                menuitem11: "发布新流程",
            },
        },
    },
    entities: {
        sysrolepermission: sysrolepermission_zh_CN,
        sysuser: sysuser_zh_CN,
        sysauthlog: sysauthlog_zh_CN,
        wfmember: wfmember_zh_CN,
        wfuser: wfuser_zh_CN,
        ibzorganization: ibzorganization_zh_CN,
        wfgroup: wfgroup_zh_CN,
        wfremodel: wfremodel_zh_CN,
        sysuserrole: sysuserrole_zh_CN,
        wfprocessdefinition: wfprocessdefinition_zh_CN,
        sysrole: sysrole_zh_CN,
        ibzdeptmember: ibzdeptmember_zh_CN,
        ibzdepartment: ibzdepartment_zh_CN,
        syspermission: syspermission_zh_CN,
        ibzemployee: ibzemployee_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};