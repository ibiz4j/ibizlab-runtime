import ibzdeptmember_zh_CN from '@locale/lanres/entities/ibzdept-member/ibzdept-member_zh_CN';
import ibzteammember_zh_CN from '@locale/lanres/entities/ibzteam-member/ibzteam-member_zh_CN';
import ibzdepartment_zh_CN from '@locale/lanres/entities/ibzdepartment/ibzdepartment_zh_CN';
import ibzemployee_zh_CN from '@locale/lanres/entities/ibzemployee/ibzemployee_zh_CN';
import ibzorganization_zh_CN from '@locale/lanres/entities/ibzorganization/ibzorganization_zh_CN';
import ibzpost_zh_CN from '@locale/lanres/entities/ibzpost/ibzpost_zh_CN';
import ibzteam_zh_CN from '@locale/lanres/entities/ibzteam/ibzteam_zh_CN';
import components_zh_CN from '@locale/lanres/components/components_zh_CN';
import codelist_zh_CN from '@locale/lanres/codelist/codelist_zh_CN';
import userCustom_zh_CN from '@locale/lanres/userCustom/userCustom_zh_CN';

export default {
    app: {
        commonWords:{
            error: "失败",
            success: "成功",
            ok: "确认",
            cancel: "取消",
        },
        local:{
            new: "新建"
        },
        gridpage: {
            choicecolumns: "选择列",
            refresh: "刷新",
            show: "显示",
            records: "条",
            totle: "共",
        },
        tabpage: {
            sureclosetip: {
                title: "关闭提醒",
                content: "表单数据已经修改，确定要关闭？",
            },
            closeall: "关闭所有",
            closeother: "关闭其他",
        },
        fileUpload: {
            caption: "上传",
        },
        searchButton: {
            search: "搜索",
            reset: "重置",
        },
        calendar:{
          today: "今天",
          month: "月",
          week: "周",
          day: "天",
          list: "列",
          dateSelectModalTitle: "选择要跳转的时间",
          gotoDate: "跳转",
        },
        // 非实体视图
        views: {
            ouindexview: {
                caption: "ibizlab",
                title: "organizational-unit",
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
        },
        menus: {
            ouindexview: {
                menuitem1: "单位管理",
                menuitem2: "部门管理",
                menuitem3: "人员管理",
                menuitem4: "岗位管理",
                menuitem5: "组管理",
            },
        },
    },
    entities: {
        ibzdeptmember: ibzdeptmember_zh_CN,
        ibzteammember: ibzteammember_zh_CN,
        ibzdepartment: ibzdepartment_zh_CN,
        ibzemployee: ibzemployee_zh_CN,
        ibzorganization: ibzorganization_zh_CN,
        ibzpost: ibzpost_zh_CN,
        ibzteam: ibzteam_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};