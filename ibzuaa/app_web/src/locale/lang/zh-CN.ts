import sysauthlog_zh_CN from '@locale/lanres/sys-auth-log/sys-auth-log_zh_CN';
import sysrolepermission_zh_CN from '@locale/lanres/sys-role-permission/sys-role-permission_zh_CN';
import syspermission_zh_CN from '@locale/lanres/sys-permission/sys-permission_zh_CN';
import sysuserrole_zh_CN from '@locale/lanres/sys-user-role/sys-user-role_zh_CN';
import sysuser_zh_CN from '@locale/lanres/sys-user/sys-user_zh_CN';
import sysrole_zh_CN from '@locale/lanres/sys-role/sys-role_zh_CN';
import components_zh_CN from '@locale/lanres/components/components_zh_CN';
import codelist_zh_CN from '@locale/lanres/codelist/codelist_zh_CN';
import userCustom_zh_CN from '@locale/lanres/userCustom/userCustom_zh_CN';

export default {
    app: {
        commonWords:{
            error: '失败',
            success: '成功',
            ok: '确认',
            cancel: '取消',
        },
        gridpage: {
            choicecolumns: '选择列',
            refresh: '刷新',
            show: '显示',
            records: '条',
            totle: '共',
        },
        tabpage: {
            sureclosetip: {
                title: '关闭提醒',
                content: '表单数据已经修改，确定要关闭？',
            },
            closeall: '关闭所有',
            closeother: '关闭其他',
        },
        fileUpload: {
            caption: '上传',
        },
        searchButton: {
            search: '搜索',
            reset: '重置',
        },
        calendar:{
          today: '今天',
          month: '月',
          week: '周',
          day: '天',
          list: '列',
          dateSelectModalTitle: '选择要跳转的时间',
          gotoDate: '跳转',
        },
        // 非实体视图
        views: {
            index: {
                caption: 'ibizlab-uaa',
                title: 'ibizlab-uaa',
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
        },
        menus: {
            main: {
                menuitem3: '用户',
                menuitem6: '角色',
                menuitem1: '认证日志',
            },
        },
    },
    entities: {
        sysauthlog: sysauthlog_zh_CN,
        sysrolepermission: sysrolepermission_zh_CN,
        syspermission: syspermission_zh_CN,
        sysuserrole: sysuserrole_zh_CN,
        sysuser: sysuser_zh_CN,
        sysrole: sysrole_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};