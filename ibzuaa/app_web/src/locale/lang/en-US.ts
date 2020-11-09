import sysrolepermission_en_US from '@locale/lanres/entities/sys-role-permission/sys-role-permission_en_US';
import sysuser_en_US from '@locale/lanres/entities/sys-user/sys-user_en_US';
import sysauthlog_en_US from '@locale/lanres/entities/sys-auth-log/sys-auth-log_en_US';
import sysuserauth_en_US from '@locale/lanres/entities/sys-user-auth/sys-user-auth_en_US';
import sysopenaccess_en_US from '@locale/lanres/entities/sys-open-access/sys-open-access_en_US';
import sysuserrole_en_US from '@locale/lanres/entities/sys-user-role/sys-user-role_en_US';
import sysrole_en_US from '@locale/lanres/entities/sys-role/sys-role_en_US';
import syspermission_en_US from '@locale/lanres/entities/sys-permission/sys-permission_en_US';
import sysapp_en_US from '@locale/lanres/entities/sys-app/sys-app_en_US';
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
            save: "Save",
            codeNotExist: 'Code list does not exist',
            reqException: "Request exception",
            sysException: "System abnormality",
            warning: "Warning",
            wrong: "Error",
            rulesException: "Abnormal value check rule",
            saveSuccess: "Saved successfully",
            saveFailed: "Save failed",
            deleteSuccess: "Successfully deleted!",
            deleteError: "Failed to delete",
            delDataFail: "Failed to delete data",
            noData: "No data",
            startsuccess:"Start successful",
            loadmore:"Load more",
            nomore:"No more",
            other:"other"
        },
        local:{
            new: "New",
            add: "Add",
        },
        gridpage: {
            choicecolumns: "Choice columns",
            refresh: "refresh",
            show: "Show",
            records: "records",
            totle: "totle",
            valueVail: "Value cannot be empty",
            group:"Group",
            other:"Other",
            notConfig: {
                fetchAction: "The view table fetchaction parameter is not configured",
                removeAction: "The view table removeaction parameter is not configured",
                createAction: "The view table createaction parameter is not configured",
                updateAction: "The view table updateaction parameter is not configured",
                loaddraftAction: "The view table loadtrafaction parameter is not configured",
            },
            data: "Data",
            delDataFail: "Failed to delete data",
            delSuccess: "Delete successfully!",
            confirmDel: "Are you sure you want to delete",
            notRecoverable: "delete will not be recoverable?",
            notBatch: "Batch addition not implemented",
            grid: "Grid",
            exportFail: "Data export failed",
            sum: "Total",
            formitemFailed: "Form item update failed",
        },
        list: {
            notConfig: {
                fetchAction: "View list fetchAction parameter is not configured",
                removeAction: "View table removeAction parameter is not configured",
                createAction: "View list createAction parameter is not configured",
                updateAction: "View list updateAction parameter is not configured",
            },
            confirmDel: "Are you sure you want to delete",
            notRecoverable: "delete will not be recoverable?",
        },
        listExpBar: {
            title: "List navigation bar",
        },
        wfExpBar: {
            title: "Process navigation bar",
        },
        calendarExpBar:{
            title: "Calendar navigation bar",
        },
        treeExpBar: {
            title: "Tree view navigation bar",
        },
        portlet: {
            noExtensions: "No extensions",
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
          from: "From",
          to: "To",
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
                menuitem4: "第三方认证",
            },
        },
        formpage:{
            error: "Error",
            desc1: "Operation failed, failed to find current form item",
            desc2: "Can't continue",
            notconfig: {
                loadaction: "View form loadAction parameter is not configured",
                loaddraftaction: "View form loaddraftAction parameter is not configured",
                actionname: "View form actionName parameter is not configured",
                removeaction: "View form removeAction parameter is not configured",
            },
            saveerror: "Error saving data",
            savecontent: "The data is inconsistent. The background data may have been modified. Do you want to reload the data?",
            valuecheckex: "Value rule check exception",
            savesuccess: "Saved successfully!",
            deletesuccess: "Successfully deleted!",  
            workflow: {
                starterror: "Workflow started successfully",
                startsuccess: "Workflow failed to start",
                submiterror: "Workflow submission failed",
                submitsuccess: "Workflow submitted successfully",
            },
            updateerror: "Form item update failed",       
        },
        gridBar: {
            title: "Table navigation bar",
        },
        multiEditView: {
            notConfig: {
                fetchAction: "View multi-edit view panel fetchAction parameter is not configured",
                loaddraftAction: "View multi-edit view panel loaddraftAction parameter is not configured",
            },
        },
        dataViewExpBar: {
            title: "Card view navigation bar",
        },
        kanban: {
            notConfig: {
                fetchAction: "View list fetchAction parameter is not configured",
                removeAction: "View table removeAction parameter is not configured",
            },
            delete1: "Confirm to delete ",
            delete2: "the delete operation will be unrecoverable!",
        },
        dashBoard: {
            handleClick: {
                title: "Panel design",
            },
        },
        dataView: {
            sum: "total",
            data: "data",
        },
        chart: {
            undefined: "Undefined",
            quarter: "Quarter",   
            year: "Year",
        },
        searchForm: {
            notConfig: {
                loadAction: "View search form loadAction parameter is not configured",
                loaddraftAction: "View search form loaddraftAction parameter is not configured",
            },
            custom: "Store custom queries",
            title: "Name",
        },
        wizardPanel: {
            back: "Back",
            next: "Next",
            complete: "Complete",
            preactionmessage:"The calculation of the previous behavior is not configured"
        },
        viewLayoutPanel: {
            appLogoutView: {
                prompt1: "Dear customer, you have successfully exited the system, after",
                prompt2: "seconds, we will jump to the",
                logingPage: "login page",
            },
            appWfstepTraceView: {
                title: "Application process processing record view",
            },
            appWfstepDataView: {
                title: "Application process tracking view",
            },
            appLoginView: {
                username: "Username",
                password: "Password",
                login: "Login",
            },
        },
    },
    entities: {
        sysrolepermission: sysrolepermission_en_US,
        sysuser: sysuser_en_US,
        sysauthlog: sysauthlog_en_US,
        sysuserauth: sysuserauth_en_US,
        sysopenaccess: sysopenaccess_en_US,
        sysuserrole: sysuserrole_en_US,
        sysrole: sysrole_en_US,
        syspermission: syspermission_en_US,
        sysapp: sysapp_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};