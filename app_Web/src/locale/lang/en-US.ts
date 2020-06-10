import sysrolepermission_en_US from '@locale/lanres/entities/sys-role-permission/sys-role-permission_en_US';
import sysuser_en_US from '@locale/lanres/entities/sys-user/sys-user_en_US';
import sysauthlog_en_US from '@locale/lanres/entities/sys-auth-log/sys-auth-log_en_US';
import wfmember_en_US from '@locale/lanres/entities/wfmember/wfmember_en_US';
import wfuser_en_US from '@locale/lanres/entities/wfuser/wfuser_en_US';
import ibzorganization_en_US from '@locale/lanres/entities/ibzorganization/ibzorganization_en_US';
import wfgroup_en_US from '@locale/lanres/entities/wfgroup/wfgroup_en_US';
import wfremodel_en_US from '@locale/lanres/entities/wfremodel/wfremodel_en_US';
import sysuserrole_en_US from '@locale/lanres/entities/sys-user-role/sys-user-role_en_US';
import wfprocessdefinition_en_US from '@locale/lanres/entities/wfprocess-definition/wfprocess-definition_en_US';
import sysrole_en_US from '@locale/lanres/entities/sys-role/sys-role_en_US';
import ibzdeptmember_en_US from '@locale/lanres/entities/ibzdept-member/ibzdept-member_en_US';
import ibzdepartment_en_US from '@locale/lanres/entities/ibzdepartment/ibzdepartment_en_US';
import syspermission_en_US from '@locale/lanres/entities/sys-permission/sys-permission_en_US';
import ibzemployee_en_US from '@locale/lanres/entities/ibzemployee/ibzemployee_en_US';
import components_en_US from '@locale/lanres/components/components_en_US';
import codelist_en_US from '@locale/lanres/codelist/codelist_en_US';
import userCustom_en_US from '@locale/lanres/userCustom/userCustom_en_US';

export default {
    app: {
        commonWords:{
            error: 'Error',
            success: 'Success',
            ok: 'OK',
            cancel: 'Cancel',
        },
        local:{
            new: 'New'
        },
        gridpage: {
            choicecolumns: 'Choice columns',
            refresh: 'refresh',
            show: 'Show',
            records: 'records',
            totle: 'totle',
        },
        tabpage: {
            sureclosetip: {
                title: 'Close warning',
                content: 'Form data Changed, are sure close?',
            },
            closeall: 'Close all',
            closeother: 'Close other',
        },
        fileUpload: {
            caption: 'Upload',
        },
        searchButton: {
            search: 'Search',
            reset: 'Reset',
        },
        calendar:{
          today: 'today',
          month: 'month',
          week: 'week',
          day: 'day',
          list: 'list',
          dateSelectModalTitle: 'select the time you wanted',
          gotoDate: 'goto',
        },
        // 非实体视图
        views: {
            index: {
                caption: 'ibizlab-runtime',
                title: 'ibizlab',
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            index: {
                menuitem7: '单位人事',
                menuitem1: '单位管理',
                menuitem2: '部门管理',
                menuitem3: '人员管理',
                menuitem8: '系统权限',
                menuitem4: '用户角色',
                menuitem9: '认证日志',
                menuitem10: '流程管理',
                menuitem6: '流程定义',
                menuitem5: '流程角色',
                menuitem11: '发布新流程',
            },
        },
    },
    entities: {
        sysrolepermission: sysrolepermission_en_US,
        sysuser: sysuser_en_US,
        sysauthlog: sysauthlog_en_US,
        wfmember: wfmember_en_US,
        wfuser: wfuser_en_US,
        ibzorganization: ibzorganization_en_US,
        wfgroup: wfgroup_en_US,
        wfremodel: wfremodel_en_US,
        sysuserrole: sysuserrole_en_US,
        wfprocessdefinition: wfprocessdefinition_en_US,
        sysrole: sysrole_en_US,
        ibzdeptmember: ibzdeptmember_en_US,
        ibzdepartment: ibzdepartment_en_US,
        syspermission: syspermission_en_US,
        ibzemployee: ibzemployee_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};