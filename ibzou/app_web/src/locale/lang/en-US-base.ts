import syspost_en_US from '@locale/lanres/entities/sys-post/sys-post_en_US';
import sysdepartment_en_US from '@locale/lanres/entities/sys-department/sys-department_en_US';
import sysemployee_en_US from '@locale/lanres/entities/sys-employee/sys-employee_en_US';
import systeam_en_US from '@locale/lanres/entities/sys-team/sys-team_en_US';
import sysorganization_en_US from '@locale/lanres/entities/sys-organization/sys-organization_en_US';
import systeammember_en_US from '@locale/lanres/entities/sys-team-member/sys-team-member_en_US';
import sysdeptmember_en_US from '@locale/lanres/entities/sys-dept-member/sys-dept-member_en_US';
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
                createFailed:"Create Failed",
                isExist:"Exist",
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
                ouindexview: {
                    caption: commonLogic.appcommonhandle("ibizlab",null),
                    title: commonLogic.appcommonhandle("organizational-unit",null),
                },
            },
            utilview:{
                importview:"Import Data",
                warning:"warning",
                info:"Please configure the data import item"    
            },
            menus: {
                ouindexview: {
                    menuitem1: commonLogic.appcommonhandle("单位管理",null),
                    menuitem2: commonLogic.appcommonhandle("部门管理",null),
                    menuitem3: commonLogic.appcommonhandle("人员管理",null),
                    menuitem4: commonLogic.appcommonhandle("岗位管理",null),
                    menuitem5: commonLogic.appcommonhandle("组管理",null),
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
            syspost: syspost_en_US(),
            sysdepartment: sysdepartment_en_US(),
            sysemployee: sysemployee_en_US(),
            systeam: systeam_en_US(),
            sysorganization: sysorganization_en_US(),
            systeammember: systeammember_en_US(),
            sysdeptmember: sysdeptmember_en_US(),
        },
        components: components_en_US(),
        codelist: codelist_en_US(),
        userCustom: userCustom_en_US(),
    };
    return data;
}
export default getAppLocale;