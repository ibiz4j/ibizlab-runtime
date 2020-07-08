import jobslog_en_US from '@locale/lanres/entities/jobs-log/jobs-log_en_US';
import sysrolepermission_en_US from '@locale/lanres/entities/sys-role-permission/sys-role-permission_en_US';
import ibzpost_en_US from '@locale/lanres/entities/ibzpost/ibzpost_en_US';
import sysuser_en_US from '@locale/lanres/entities/sys-user/sys-user_en_US';
import sysauthlog_en_US from '@locale/lanres/entities/sys-auth-log/sys-auth-log_en_US';
import wfmember_en_US from '@locale/lanres/entities/wfmember/wfmember_en_US';
import wfuser_en_US from '@locale/lanres/entities/wfuser/wfuser_en_US';
import ibzorganization_en_US from '@locale/lanres/entities/ibzorganization/ibzorganization_en_US';
import jobsregistry_en_US from '@locale/lanres/entities/jobs-registry/jobs-registry_en_US';
import dictcatalog_en_US from '@locale/lanres/entities/dict-catalog/dict-catalog_en_US';
import wfgroup_en_US from '@locale/lanres/entities/wfgroup/wfgroup_en_US';
import ibzteam_en_US from '@locale/lanres/entities/ibzteam/ibzteam_en_US';
import jobsinfo_en_US from '@locale/lanres/entities/jobs-info/jobs-info_en_US';
import wfremodel_en_US from '@locale/lanres/entities/wfremodel/wfremodel_en_US';
import sysuserrole_en_US from '@locale/lanres/entities/sys-user-role/sys-user-role_en_US';
import wfprocessdefinition_en_US from '@locale/lanres/entities/wfprocess-definition/wfprocess-definition_en_US';
import sysrole_en_US from '@locale/lanres/entities/sys-role/sys-role_en_US';
import ibzdeptmember_en_US from '@locale/lanres/entities/ibzdept-member/ibzdept-member_en_US';
import ibzdepartment_en_US from '@locale/lanres/entities/ibzdepartment/ibzdepartment_en_US';
import ibzteammember_en_US from '@locale/lanres/entities/ibzteam-member/ibzteam-member_en_US';
import syspermission_en_US from '@locale/lanres/entities/sys-permission/sys-permission_en_US';
import dictoption_en_US from '@locale/lanres/entities/dict-option/dict-option_en_US';
import ibzemployee_en_US from '@locale/lanres/entities/ibzemployee/ibzemployee_en_US';
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
            noData: "No data",
            valueVail: "Value cannot be empty",
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
                title: "Runtime",
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            index: {
                menuitem7: "单位人事",
                menuitem1: "单位管理",
                menuitem2: "部门管理",
                menuitem3: "人员管理",
                menuitem12: "岗位管理",
                menuitem13: "组管理",
                menuitem8: "系统权限",
                menuitem4: "用户角色",
                menuitem9: "认证日志",
                menuitem21: "接入应用",
                menuitem10: "流程管理",
                menuitem6: "流程定义",
                menuitem5: "流程角色",
                menuitem11: "发布新流程",
                menuitem14: "任务管理",
                menuitem15: "注册",
                menuitem16: "任务",
                menuitem17: "日志",
                menuitem18: "字典管理",
                menuitem19: "目录",
                menuitem20: "字典项",
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
    },
    entities: {
        jobslog: jobslog_en_US,
        sysrolepermission: sysrolepermission_en_US,
        ibzpost: ibzpost_en_US,
        sysuser: sysuser_en_US,
        sysauthlog: sysauthlog_en_US,
        wfmember: wfmember_en_US,
        wfuser: wfuser_en_US,
        ibzorganization: ibzorganization_en_US,
        jobsregistry: jobsregistry_en_US,
        dictcatalog: dictcatalog_en_US,
        wfgroup: wfgroup_en_US,
        ibzteam: ibzteam_en_US,
        jobsinfo: jobsinfo_en_US,
        wfremodel: wfremodel_en_US,
        sysuserrole: sysuserrole_en_US,
        wfprocessdefinition: wfprocessdefinition_en_US,
        sysrole: sysrole_en_US,
        ibzdeptmember: ibzdeptmember_en_US,
        ibzdepartment: ibzdepartment_en_US,
        ibzteammember: ibzteammember_en_US,
        syspermission: syspermission_en_US,
        dictoption: dictoption_en_US,
        ibzemployee: ibzemployee_en_US,
        sysapp: sysapp_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};