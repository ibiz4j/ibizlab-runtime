import wfremodel_en_US from '@locale/lanres/entities/wfremodel/wfremodel_en_US';
import wfmember_en_US from '@locale/lanres/entities/wfmember/wfmember_en_US';
import wfgroup_en_US from '@locale/lanres/entities/wfgroup/wfgroup_en_US';
import wfuser_en_US from '@locale/lanres/entities/wfuser/wfuser_en_US';
import wfprocessdefinition_en_US from '@locale/lanres/entities/wfprocess-definition/wfprocess-definition_en_US';
import wfsystem_en_US from '@locale/lanres/entities/wfsystem/wfsystem_en_US';
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
            wfindexview: {
                caption: 'ibizlab-workflow',
                title: 'ibizlab-workflow',
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            wfindexview: {
                menuitem1: '流程定义',
                menuitem3: '发布新流程',
                menuitem2: '用户组',
            },
        },
    },
    entities: {
        wfremodel: wfremodel_en_US,
        wfmember: wfmember_en_US,
        wfgroup: wfgroup_en_US,
        wfuser: wfuser_en_US,
        wfprocessdefinition: wfprocessdefinition_en_US,
        wfsystem: wfsystem_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};