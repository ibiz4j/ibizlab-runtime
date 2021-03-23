import jobslog_zh_CN from '@locale/lanres/entities/jobs-log/jobs-log_zh_CN';
import sysrolepermission_zh_CN from '@locale/lanres/entities/sys-role-permission/sys-role-permission_zh_CN';
import msguseraccount_zh_CN from '@locale/lanres/entities/msg-user-account/msg-user-account_zh_CN';
import sysuser_zh_CN from '@locale/lanres/entities/sys-user/sys-user_zh_CN';
import sysauthlog_zh_CN from '@locale/lanres/entities/sys-auth-log/sys-auth-log_zh_CN';
import wfmember_zh_CN from '@locale/lanres/entities/wfmember/wfmember_zh_CN';
import syspost_zh_CN from '@locale/lanres/entities/sys-post/sys-post_zh_CN';
import sysuserauth_zh_CN from '@locale/lanres/entities/sys-user-auth/sys-user-auth_zh_CN';
import sysdepartment_zh_CN from '@locale/lanres/entities/sys-department/sys-department_zh_CN';
import metadynamicmodel_zh_CN from '@locale/lanres/entities/meta-dynamic-model/meta-dynamic-model_zh_CN';
import sysemployee_zh_CN from '@locale/lanres/entities/sys-employee/sys-employee_zh_CN';
import paytrade_zh_CN from '@locale/lanres/entities/pay-trade/pay-trade_zh_CN';
import msgtemplate_zh_CN from '@locale/lanres/entities/msg-template/msg-template_zh_CN';
import systeam_zh_CN from '@locale/lanres/entities/sys-team/sys-team_zh_CN';
import wfuser_zh_CN from '@locale/lanres/entities/wfuser/wfuser_zh_CN';
import payopenaccess_zh_CN from '@locale/lanres/entities/pay-open-access/pay-open-access_zh_CN';
import sysorganization_zh_CN from '@locale/lanres/entities/sys-organization/sys-organization_zh_CN';
import jobsregistry_zh_CN from '@locale/lanres/entities/jobs-registry/jobs-registry_zh_CN';
import sysopenaccess_zh_CN from '@locale/lanres/entities/sys-open-access/sys-open-access_zh_CN';
import dictcatalog_zh_CN from '@locale/lanres/entities/dict-catalog/dict-catalog_zh_CN';
import wfgroup_zh_CN from '@locale/lanres/entities/wfgroup/wfgroup_zh_CN';
import jobsinfo_zh_CN from '@locale/lanres/entities/jobs-info/jobs-info_zh_CN';
import wfremodel_zh_CN from '@locale/lanres/entities/wfremodel/wfremodel_zh_CN';
import sysuserrole_zh_CN from '@locale/lanres/entities/sys-user-role/sys-user-role_zh_CN';
import wfprocessdefinition_zh_CN from '@locale/lanres/entities/wfprocess-definition/wfprocess-definition_zh_CN';
import sysrole_zh_CN from '@locale/lanres/entities/sys-role/sys-role_zh_CN';
import syspermission_zh_CN from '@locale/lanres/entities/sys-permission/sys-permission_zh_CN';
import msgopenaccess_zh_CN from '@locale/lanres/entities/msg-open-access/msg-open-access_zh_CN';
import systeammember_zh_CN from '@locale/lanres/entities/sys-team-member/sys-team-member_zh_CN';
import sysdeptmember_zh_CN from '@locale/lanres/entities/sys-dept-member/sys-dept-member_zh_CN';
import dictoption_zh_CN from '@locale/lanres/entities/dict-option/dict-option_zh_CN';
import sysapp_zh_CN from '@locale/lanres/entities/sys-app/sys-app_zh_CN';
import components_zh_CN from '@locale/lanres/components/components_zh_CN';
import codelist_zh_CN from '@locale/lanres/codelist/codelist_zh_CN';
import userCustom_zh_CN from '@locale/lanres/userCustom/userCustom_zh_CN';
import commonLogic from '@/locale/logic/common/common-logic';

function getAppLocale(){
    const data:any = {
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
                deleteSuccess: "删除成功",
                deleteError: "删除失败",
                delDataFail: "删除数据失败",
                noData: "暂无数据",
                startsuccess:"启动成功",
                loadmore:"加载更多",
                nomore:"没有更多了",
                other:"其他",
                valueNotEmpty:"值不能为空",
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
                valueVail: "值不能为空",
                group:"分组",
                other:"其他",
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
                    caption: commonLogic.appcommonhandle("ibizlab",null),
                    title: commonLogic.appcommonhandle("Runtime",null),
                },
            },
            utilview:{
                importview:"导入数据",
                warning:"警告",
                info:"请配置数据导入项" 
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
                    menuitem31: commonLogic.appcommonhandle("存储管理",null),
                    menuitem32: commonLogic.appcommonhandle("动态模型",null),
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
                fold: "折叠",
                unfold: "展开",
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
                preactionmessage:"未配置计算上一步行为"
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
            jobslog: jobslog_zh_CN(),
            sysrolepermission: sysrolepermission_zh_CN(),
            msguseraccount: msguseraccount_zh_CN(),
            sysuser: sysuser_zh_CN(),
            sysauthlog: sysauthlog_zh_CN(),
            wfmember: wfmember_zh_CN(),
            syspost: syspost_zh_CN(),
            sysuserauth: sysuserauth_zh_CN(),
            sysdepartment: sysdepartment_zh_CN(),
            metadynamicmodel: metadynamicmodel_zh_CN(),
            sysemployee: sysemployee_zh_CN(),
            paytrade: paytrade_zh_CN(),
            msgtemplate: msgtemplate_zh_CN(),
            systeam: systeam_zh_CN(),
            wfuser: wfuser_zh_CN(),
            payopenaccess: payopenaccess_zh_CN(),
            sysorganization: sysorganization_zh_CN(),
            jobsregistry: jobsregistry_zh_CN(),
            sysopenaccess: sysopenaccess_zh_CN(),
            dictcatalog: dictcatalog_zh_CN(),
            wfgroup: wfgroup_zh_CN(),
            jobsinfo: jobsinfo_zh_CN(),
            wfremodel: wfremodel_zh_CN(),
            sysuserrole: sysuserrole_zh_CN(),
            wfprocessdefinition: wfprocessdefinition_zh_CN(),
            sysrole: sysrole_zh_CN(),
            syspermission: syspermission_zh_CN(),
            msgopenaccess: msgopenaccess_zh_CN(),
            systeammember: systeammember_zh_CN(),
            sysdeptmember: sysdeptmember_zh_CN(),
            dictoption: dictoption_zh_CN(),
            sysapp: sysapp_zh_CN(),
        },
        components: components_zh_CN(),
        codelist: codelist_zh_CN(),
        userCustom: userCustom_zh_CN(),
    };
    return data;
}
export default getAppLocale;