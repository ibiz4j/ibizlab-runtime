import jobslog_zh_CN from '@locale/lanres/entities/jobs-log/jobs-log_zh_CN';
import sysrolepermission_zh_CN from '@locale/lanres/entities/sys-role-permission/sys-role-permission_zh_CN';
import ibzpost_zh_CN from '@locale/lanres/entities/ibzpost/ibzpost_zh_CN';
import sysuser_zh_CN from '@locale/lanres/entities/sys-user/sys-user_zh_CN';
import sysauthlog_zh_CN from '@locale/lanres/entities/sys-auth-log/sys-auth-log_zh_CN';
import wfmember_zh_CN from '@locale/lanres/entities/wfmember/wfmember_zh_CN';
import wfuser_zh_CN from '@locale/lanres/entities/wfuser/wfuser_zh_CN';
import ibzorganization_zh_CN from '@locale/lanres/entities/ibzorganization/ibzorganization_zh_CN';
import jobsregistry_zh_CN from '@locale/lanres/entities/jobs-registry/jobs-registry_zh_CN';
import dictcatalog_zh_CN from '@locale/lanres/entities/dict-catalog/dict-catalog_zh_CN';
import wfgroup_zh_CN from '@locale/lanres/entities/wfgroup/wfgroup_zh_CN';
import ibzteam_zh_CN from '@locale/lanres/entities/ibzteam/ibzteam_zh_CN';
import jobsinfo_zh_CN from '@locale/lanres/entities/jobs-info/jobs-info_zh_CN';
import wfremodel_zh_CN from '@locale/lanres/entities/wfremodel/wfremodel_zh_CN';
import sysuserrole_zh_CN from '@locale/lanres/entities/sys-user-role/sys-user-role_zh_CN';
import wfprocessdefinition_zh_CN from '@locale/lanres/entities/wfprocess-definition/wfprocess-definition_zh_CN';
import sysrole_zh_CN from '@locale/lanres/entities/sys-role/sys-role_zh_CN';
import ibzdeptmember_zh_CN from '@locale/lanres/entities/ibzdept-member/ibzdept-member_zh_CN';
import ibzdepartment_zh_CN from '@locale/lanres/entities/ibzdepartment/ibzdepartment_zh_CN';
import ibzteammember_zh_CN from '@locale/lanres/entities/ibzteam-member/ibzteam-member_zh_CN';
import syspermission_zh_CN from '@locale/lanres/entities/sys-permission/sys-permission_zh_CN';
import dictoption_zh_CN from '@locale/lanres/entities/dict-option/dict-option_zh_CN';
import ibzemployee_zh_CN from '@locale/lanres/entities/ibzemployee/ibzemployee_zh_CN';
import sysapp_zh_CN from '@locale/lanres/entities/sys-app/sys-app_zh_CN';
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
            save: "保存",
            codeNotExist: "代码表不存在",
            reqException: "请求异常",
            sysException: "系统异常",
            warning: "警告",
            wrong: "错误",
            rulesException: "值规则校验异常",
            saveSuccess: "保存成功",
            saveFailed: "保存失败",
            deleteSuccess: "删除成功！",
            deleteError: "删除失败！",
            delDataFail: "删除数据失败",
            noData: "暂无数据",
        },
        local:{
            new: "新建",
            add: "增加",
        },
        gridpage: {
            choicecolumns: "选择列",
            refresh: "刷新",
            show: "显示",
            records: "条",
            totle: "共",
            noData: "无数据",
            valueVail: "值不能为空",
            notConfig: {
                fetchAction: "视图表格fetchAction参数未配置",
                removeAction: "视图表格removeAction参数未配置",
                createAction: "视图表格createAction参数未配置",
                updateAction: "视图表格updateAction参数未配置",
                loaddraftAction: "视图表格loaddraftAction参数未配置",
            },
            data: "数据",
            delDataFail: "删除数据失败",
            delSuccess: "删除成功!",
            confirmDel: "确认要删除",
            notRecoverable: "删除操作将不可恢复？",
            notBatch: "批量添加未实现",
            grid: "表",
            exportFail: "数据导出失败",
            sum: "合计",
            formitemFailed: "表单项更新失败",
        },
        list: {
            notConfig: {
                fetchAction: "视图列表fetchAction参数未配置",
                removeAction: "视图表格removeAction参数未配置",
                createAction: "视图列表createAction参数未配置",
                updateAction: "视图列表updateAction参数未配置",
            },
            confirmDel: "确认要删除",
            notRecoverable: "删除操作将不可恢复？",
        },
        listExpBar: {
            title: "列表导航栏",
        },
        wfExpBar: {
            title: "流程导航栏",
        },
        calendarExpBar:{
            title: "日历导航栏",
        },
        treeExpBar: {
            title: "树视图导航栏",
        },
        portlet: {
            noExtensions: "无扩展插件",
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
          from: "从",
          to: "至",
        },
        // 非实体视图
        views: {
            index: {
                caption: "ibizlab",
                title: "Runtime",
            },
        },
        utilview:{
            importview:"导入数据",
            warning:"警告",
            info:"请配置数据导入项" 
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
            desc1: "操作失败,未能找到当前表单项",
            desc2: "无法继续操作",
            notconfig: {
                loadaction: "视图表单loadAction参数未配置",
                loaddraftaction: "视图表单loaddraftAction参数未配置",
                actionname: "视图表单'+actionName+'参数未配置",
                removeaction: "视图表单removeAction参数未配置",
            },
            saveerror: "保存数据发生错误",
            savecontent: "数据不一致，可能后台数据已经被修改,是否要重新加载数据？",
            valuecheckex: "值规则校验异常",
            savesuccess: "保存成功！",
            deletesuccess: "删除成功！",  
            workflow: {
                starterror: "工作流启动失败",
                startsuccess: "工作流启动成功",
                submiterror: "工作流提交失败",
                submitsuccess: "工作流提交成功",
            },
            updateerror: "表单项更新失败",     
        },
        gridBar: {
            title: "表格导航栏",
        },
        multiEditView: {
            notConfig: {
                fetchAction: "视图多编辑视图面板fetchAction参数未配置",
                loaddraftAction: "视图多编辑视图面板loaddraftAction参数未配置",
            },
        },
        dataViewExpBar: {
            title: "卡片视图导航栏",
        },
        kanban: {
            notConfig: {
                fetchAction: "视图列表fetchAction参数未配置",
                removeAction: "视图表格removeAction参数未配置",
            },
            delete1: "确认要删除 ",
            delete2: "删除操作将不可恢复？",
        },
        dashBoard: {
            handleClick: {
                title: "面板设计",
            },
        },
        dataView: {
            sum: "共",
            data: "条数据",
        },
        chart: {
            undefined: "未定义",
            quarter: "季度",   
            year: "年",
        },
        searchForm: {
            notConfig: {
                loadAction: "视图搜索表单loadAction参数未配置",
                loaddraftAction: "视图搜索表单loaddraftAction参数未配置",
            },
            custom: "存储自定义查询",
            title: "名称",
        },
        wizardPanel: {
            back: "上一步",
            next: "下一步",
            complete: "完成",
        },
        viewLayoutPanel: {
            appLogoutView: {
                prompt1: "尊敬的客户您好，您已成功退出系统，将在",
                prompt2: "秒后跳转至",
                logingPage: "登录页",
            },
            appWfstepTraceView: {
                title: "应用流程处理记录视图",
            },
            appWfstepDataView: {
                title: "应用流程跟踪视图",
            },
            appLoginView: {
                username: "用户名",
                password: "密码",
                login: "登录",
            },
        },
    },
    entities: {
        jobslog: jobslog_zh_CN,
        sysrolepermission: sysrolepermission_zh_CN,
        ibzpost: ibzpost_zh_CN,
        sysuser: sysuser_zh_CN,
        sysauthlog: sysauthlog_zh_CN,
        wfmember: wfmember_zh_CN,
        wfuser: wfuser_zh_CN,
        ibzorganization: ibzorganization_zh_CN,
        jobsregistry: jobsregistry_zh_CN,
        dictcatalog: dictcatalog_zh_CN,
        wfgroup: wfgroup_zh_CN,
        ibzteam: ibzteam_zh_CN,
        jobsinfo: jobsinfo_zh_CN,
        wfremodel: wfremodel_zh_CN,
        sysuserrole: sysuserrole_zh_CN,
        wfprocessdefinition: wfprocessdefinition_zh_CN,
        sysrole: sysrole_zh_CN,
        ibzdeptmember: ibzdeptmember_zh_CN,
        ibzdepartment: ibzdepartment_zh_CN,
        ibzteammember: ibzteammember_zh_CN,
        syspermission: syspermission_zh_CN,
        dictoption: dictoption_zh_CN,
        ibzemployee: ibzemployee_zh_CN,
        sysapp: sysapp_zh_CN,
    },
    components: components_zh_CN,
    codelist: codelist_zh_CN,
    userCustom: userCustom_zh_CN,
};