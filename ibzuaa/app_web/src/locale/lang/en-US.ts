import sysauthlog_en_US from '@locale/lanres/entities/sys-auth-log/sys-auth-log_en_US';
import sysapp_en_US from '@locale/lanres/entities/sys-app/sys-app_en_US';
import sysrolepermission_en_US from '@locale/lanres/entities/sys-role-permission/sys-role-permission_en_US';
import syspermission_en_US from '@locale/lanres/entities/sys-permission/sys-permission_en_US';
import sysuserrole_en_US from '@locale/lanres/entities/sys-user-role/sys-user-role_en_US';
import sysuser_en_US from '@locale/lanres/entities/sys-user/sys-user_en_US';
import sysrole_en_US from '@locale/lanres/entities/sys-role/sys-role_en_US';
import components_en_US from '@locale/lanres/components/components_en_US';
import codelist_en_US from '@locale/lanres/codelist/codelist_en_US';
import userCustom_en_US from '@locale/lanres/userCustom/userCustom_en_US';

export default {
    app: {
        commonWords:{
            error: "Error",
            success: "Success",
            ok: "OK",
            cancel: "Cancel",
        },
        local:{
            new: "New"
        },
        gridpage: {
            choicecolumns: "Choice columns",
            refresh: "refresh",
            show: "Show",
            records: "records",
            totle: "totle",
        },
        tabpage: {
            sureclosetip: {
                title: "Close warning",
                content: "Form data Changed, are sure close?",
            },
            closeall: "Close all",
            closeother: "Close other",
        },
        fileUpload: {
            caption: "Upload",
        },
        searchButton: {
            search: "Search",
            reset: "Reset",
        },
        calendar:{
          today: "today",
          month: "month",
          week: "week",
          day: "day",
          list: "list",
          dateSelectModalTitle: "select the time you wanted",
          gotoDate: "goto",
        },
        // 非实体视图
        views: {
            index: {
                caption: "ibizlab",
                title: "uaa",
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            main: {
                menuitem3: "用户",
                menuitem6: "角色",
                menuitem1: "认证日志",
                menuitem2: "接入应用",
            },
        },
    },
    entities: {
        sysauthlog: sysauthlog_en_US,
        sysapp: sysapp_en_US,
        sysrolepermission: sysrolepermission_en_US,
        syspermission: syspermission_en_US,
        sysuserrole: sysuserrole_en_US,
        sysuser: sysuser_en_US,
        sysrole: sysrole_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};