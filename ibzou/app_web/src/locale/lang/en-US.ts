import ibzdeptmember_en_US from '@locale/lanres/ibzdept-member/ibzdept-member_en_US';
import ibzteammember_en_US from '@locale/lanres/ibzteam-member/ibzteam-member_en_US';
import ibzdepartment_en_US from '@locale/lanres/ibzdepartment/ibzdepartment_en_US';
import ibzemployee_en_US from '@locale/lanres/ibzemployee/ibzemployee_en_US';
import ibzorganization_en_US from '@locale/lanres/ibzorganization/ibzorganization_en_US';
import ibzteam_en_US from '@locale/lanres/ibzteam/ibzteam_en_US';
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
            ouindexview: {
                caption: 'ibizlab-ou',
                title: 'ibizlab-ou',
            },
        },
        utilview:{
            importview:"Import Data",
            warning:"warning",
            info:"Please configure the data import item"    
        },
        menus: {
            ouindexview: {
                menuitem1: '单位管理',
                menuitem2: '部门管理',
                menuitem3: '人员管理',
            },
        },
    },
    entities: {
        ibzdeptmember: ibzdeptmember_en_US,
        ibzteammember: ibzteammember_en_US,
        ibzdepartment: ibzdepartment_en_US,
        ibzemployee: ibzemployee_en_US,
        ibzorganization: ibzorganization_en_US,
        ibzteam: ibzteam_en_US,
    },
    components: components_en_US,
    codelist: codelist_en_US,
    userCustom: userCustom_en_US,
};