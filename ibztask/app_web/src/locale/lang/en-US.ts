import jobsinfo_en_US from '@locale/lanres/entities/jobs-info/jobs-info_en_US';
import jobslog_en_US from '@locale/lanres/entities/jobs-log/jobs-log_en_US';
import jobslock_en_US from '@locale/lanres/entities/jobs-lock/jobs-lock_en_US';
import jobsregistry_en_US from '@locale/lanres/entities/jobs-registry/jobs-registry_en_US';
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
            taskindexview: {
                caption: "ibizlab",
                title: "task",
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            taskindexview: {
                menuitem3: "注册",
                menuitem1: "任务",
                menuitem2: "日志",
            },
        },
    },
    entities: {
        jobsinfo: jobsinfo_en_US,
        jobslog: jobslog_en_US,
        jobslock: jobslock_en_US,
        jobsregistry: jobsregistry_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};