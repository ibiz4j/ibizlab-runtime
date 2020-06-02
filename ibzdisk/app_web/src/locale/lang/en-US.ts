import sdfile_en_US from '@locale/lanres/entities/sdfile/sdfile_en_US';
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
            sdindexview: {
                caption: 'ibizlab-disk',
                title: 'ibizlab-disk',
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            sdindexview: {
                menuitem1: '文件',
            },
        },
    },
    entities: {
        sdfile: sdfile_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};