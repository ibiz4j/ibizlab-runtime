import jobslog_en_US from '@locale/lanres/entities/jobs-log/jobs-log_en_US';
import sysrolepermission_en_US from '@locale/lanres/entities/sys-role-permission/sys-role-permission_en_US';
import msguseraccount_en_US from '@locale/lanres/entities/msg-user-account/msg-user-account_en_US';
import sysuser_en_US from '@locale/lanres/entities/sys-user/sys-user_en_US';
import sysauthlog_en_US from '@locale/lanres/entities/sys-auth-log/sys-auth-log_en_US';
import wfmember_en_US from '@locale/lanres/entities/wfmember/wfmember_en_US';
import syspost_en_US from '@locale/lanres/entities/sys-post/sys-post_en_US';
import sysuserauth_en_US from '@locale/lanres/entities/sys-user-auth/sys-user-auth_en_US';
import sysdepartment_en_US from '@locale/lanres/entities/sys-department/sys-department_en_US';
import sysemployee_en_US from '@locale/lanres/entities/sys-employee/sys-employee_en_US';
import paytrade_en_US from '@locale/lanres/entities/pay-trade/pay-trade_en_US';
import msgtemplate_en_US from '@locale/lanres/entities/msg-template/msg-template_en_US';
import systeam_en_US from '@locale/lanres/entities/sys-team/sys-team_en_US';
import wfuser_en_US from '@locale/lanres/entities/wfuser/wfuser_en_US';
import payopenaccess_en_US from '@locale/lanres/entities/pay-open-access/pay-open-access_en_US';
import sysorganization_en_US from '@locale/lanres/entities/sys-organization/sys-organization_en_US';
import jobsregistry_en_US from '@locale/lanres/entities/jobs-registry/jobs-registry_en_US';
import sysopenaccess_en_US from '@locale/lanres/entities/sys-open-access/sys-open-access_en_US';
import dictcatalog_en_US from '@locale/lanres/entities/dict-catalog/dict-catalog_en_US';
import wfgroup_en_US from '@locale/lanres/entities/wfgroup/wfgroup_en_US';
import jobsinfo_en_US from '@locale/lanres/entities/jobs-info/jobs-info_en_US';
import wfremodel_en_US from '@locale/lanres/entities/wfremodel/wfremodel_en_US';
import sysuserrole_en_US from '@locale/lanres/entities/sys-user-role/sys-user-role_en_US';
import wfprocessdefinition_en_US from '@locale/lanres/entities/wfprocess-definition/wfprocess-definition_en_US';
import sysrole_en_US from '@locale/lanres/entities/sys-role/sys-role_en_US';
import syspermission_en_US from '@locale/lanres/entities/sys-permission/sys-permission_en_US';
import msgopenaccess_en_US from '@locale/lanres/entities/msg-open-access/msg-open-access_en_US';
import systeammember_en_US from '@locale/lanres/entities/sys-team-member/sys-team-member_en_US';
import sysdeptmember_en_US from '@locale/lanres/entities/sys-dept-member/sys-dept-member_en_US';
import dictoption_en_US from '@locale/lanres/entities/dict-option/dict-option_en_US';
import sysapp_en_US from '@locale/lanres/entities/sys-app/sys-app_en_US';
import components_en_US from '@locale/lanres/components/components_en_US';
import codelist_en_US from '@locale/lanres/codelist/codelist_en_US';
import userCustom_en_US from '@locale/lanres/userCustom/userCustom_en_US';
import commonLogic from '@/locale/logic/common/common-logic';

function getAppLocale(){
    const data:any = {
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
                other:"other",
                valueNotEmpty:"The value cannot be null",
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
                    caption: commonLogic.appcommonhandle("ibizlab",null),
                    title: commonLogic.appcommonhandle("Runtime",null),
                },
            },
            utilview:{
                importview:"Import Data",
                warning:"warning",
                info:"Please configure the data import item"    
            },
            menus: {
                index: {
                    menuitem7: commonLogic.appcommonhandle("单位人事",null),
                    menuitem1: commonLogic.appcommonhandle("单位管理",null),
                    menuitem2: commonLogic.appcommonhandle("部门管理",null),
                    menuitem3: commonLogic.appcommonhandle("人员管理",null),
                    menuitem12: commonLogic.appcommonhandle("岗位管理",null),
                    menuitem13: commonLogic.appcommonhandle("组管理",null),
                    menuitem8: commonLogic.appcommonhandle("系统权限",null),
                    menuitem4: commonLogic.appcommonhandle("用户角色",null),
                    menuitem9: commonLogic.appcommonhandle("认证日志",null),
                    menuitem21: commonLogic.appcommonhandle("接入应用",null),
                    menuitem22: commonLogic.appcommonhandle("第三方认证",null),
                    menuitem23: commonLogic.appcommonhandle("账户绑定",null),
                    menuitem10: commonLogic.appcommonhandle("流程管理",null),
                    menuitem6: commonLogic.appcommonhandle("流程定义",null),
                    menuitem5: commonLogic.appcommonhandle("流程角色",null),
                    menuitem11: commonLogic.appcommonhandle("发布新流程",null),
                    menuitem14: commonLogic.appcommonhandle("任务管理",null),
                    menuitem15: commonLogic.appcommonhandle("注册",null),
                    menuitem16: commonLogic.appcommonhandle("任务",null),
                    menuitem17: commonLogic.appcommonhandle("日志",null),
                    menuitem18: commonLogic.appcommonhandle("字典管理",null),
                    menuitem19: commonLogic.appcommonhandle("目录",null),
                    menuitem20: commonLogic.appcommonhandle("字典项",null),
                    menuitem24: commonLogic.appcommonhandle("消息通知",null),
                    menuitem25: commonLogic.appcommonhandle("第三方平台",null),
                    menuitem26: commonLogic.appcommonhandle("消息模板",null),
                    menuitem27: commonLogic.appcommonhandle("消息账户",null),
                    menuitem28: commonLogic.appcommonhandle("支付管理",null),
                    menuitem29: commonLogic.appcommonhandle("支付交易",null),
                    menuitem30: commonLogic.appcommonhandle("支付平台",null),
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
                fold: "fold",
                unfold: "upfold",
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
            jobslog: jobslog_en_US(),
            sysrolepermission: sysrolepermission_en_US(),
            msguseraccount: msguseraccount_en_US(),
            sysuser: sysuser_en_US(),
            sysauthlog: sysauthlog_en_US(),
            wfmember: wfmember_en_US(),
            syspost: syspost_en_US(),
            sysuserauth: sysuserauth_en_US(),
            sysdepartment: sysdepartment_en_US(),
            sysemployee: sysemployee_en_US(),
            paytrade: paytrade_en_US(),
            msgtemplate: msgtemplate_en_US(),
            systeam: systeam_en_US(),
            wfuser: wfuser_en_US(),
            payopenaccess: payopenaccess_en_US(),
            sysorganization: sysorganization_en_US(),
            jobsregistry: jobsregistry_en_US(),
            sysopenaccess: sysopenaccess_en_US(),
            dictcatalog: dictcatalog_en_US(),
            wfgroup: wfgroup_en_US(),
            jobsinfo: jobsinfo_en_US(),
            wfremodel: wfremodel_en_US(),
            sysuserrole: sysuserrole_en_US(),
            wfprocessdefinition: wfprocessdefinition_en_US(),
            sysrole: sysrole_en_US(),
            syspermission: syspermission_en_US(),
            msgopenaccess: msgopenaccess_en_US(),
            systeammember: systeammember_en_US(),
            sysdeptmember: sysdeptmember_en_US(),
            dictoption: dictoption_en_US(),
            sysapp: sysapp_en_US(),
        },
        components: components_en_US(),
        codelist: codelist_en_US(),
        userCustom: userCustom_en_US(),
    };
    return data;
}
export default getAppLocale;