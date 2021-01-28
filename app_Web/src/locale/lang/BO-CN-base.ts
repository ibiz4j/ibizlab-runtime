import jobslog_BO_CN from '@locale/lanres/entities/jobs-log/jobs-log_BO_CN';
import sysrolepermission_BO_CN from '@locale/lanres/entities/sys-role-permission/sys-role-permission_BO_CN';
import msguseraccount_BO_CN from '@locale/lanres/entities/msg-user-account/msg-user-account_BO_CN';
import sysuser_BO_CN from '@locale/lanres/entities/sys-user/sys-user_BO_CN';
import sysauthlog_BO_CN from '@locale/lanres/entities/sys-auth-log/sys-auth-log_BO_CN';
import wfmember_BO_CN from '@locale/lanres/entities/wfmember/wfmember_BO_CN';
import syspost_BO_CN from '@locale/lanres/entities/sys-post/sys-post_BO_CN';
import sysuserauth_BO_CN from '@locale/lanres/entities/sys-user-auth/sys-user-auth_BO_CN';
import sysdepartment_BO_CN from '@locale/lanres/entities/sys-department/sys-department_BO_CN';
import sysemployee_BO_CN from '@locale/lanres/entities/sys-employee/sys-employee_BO_CN';
import paytrade_BO_CN from '@locale/lanres/entities/pay-trade/pay-trade_BO_CN';
import msgtemplate_BO_CN from '@locale/lanres/entities/msg-template/msg-template_BO_CN';
import systeam_BO_CN from '@locale/lanres/entities/sys-team/sys-team_BO_CN';
import wfuser_BO_CN from '@locale/lanres/entities/wfuser/wfuser_BO_CN';
import payopenaccess_BO_CN from '@locale/lanres/entities/pay-open-access/pay-open-access_BO_CN';
import sysorganization_BO_CN from '@locale/lanres/entities/sys-organization/sys-organization_BO_CN';
import jobsregistry_BO_CN from '@locale/lanres/entities/jobs-registry/jobs-registry_BO_CN';
import sysopenaccess_BO_CN from '@locale/lanres/entities/sys-open-access/sys-open-access_BO_CN';
import dictcatalog_BO_CN from '@locale/lanres/entities/dict-catalog/dict-catalog_BO_CN';
import wfgroup_BO_CN from '@locale/lanres/entities/wfgroup/wfgroup_BO_CN';
import jobsinfo_BO_CN from '@locale/lanres/entities/jobs-info/jobs-info_BO_CN';
import wfremodel_BO_CN from '@locale/lanres/entities/wfremodel/wfremodel_BO_CN';
import sysuserrole_BO_CN from '@locale/lanres/entities/sys-user-role/sys-user-role_BO_CN';
import wfprocessdefinition_BO_CN from '@locale/lanres/entities/wfprocess-definition/wfprocess-definition_BO_CN';
import sysrole_BO_CN from '@locale/lanres/entities/sys-role/sys-role_BO_CN';
import syspermission_BO_CN from '@locale/lanres/entities/sys-permission/sys-permission_BO_CN';
import msgopenaccess_BO_CN from '@locale/lanres/entities/msg-open-access/msg-open-access_BO_CN';
import systeammember_BO_CN from '@locale/lanres/entities/sys-team-member/sys-team-member_BO_CN';
import sysdeptmember_BO_CN from '@locale/lanres/entities/sys-dept-member/sys-dept-member_BO_CN';
import dictoption_BO_CN from '@locale/lanres/entities/dict-option/dict-option_BO_CN';
import sysapp_BO_CN from '@locale/lanres/entities/sys-app/sys-app_BO_CN';
import components_BO_CN from '@locale/lanres/components/components_BO_CN';
import codelist_BO_CN from '@locale/lanres/codelist/codelist_BO_CN';
import userCustom_BO_CN from '@locale/lanres/userCustom/userCustom_BO_CN';
import commonLogic from '@/locale/logic/common/common-logic';

function getAppLocale(){
    const data:any = {
        app: {
             commonWords:{
                error: "ཕམ་པ།",
                success: "ལེགས་འགྲུབ།",
                ok: "ངོས་འཛིན་",
                cancel: "མེད་པར་བཟོ་བ་",
                save: "ཉར་ཚགས།",
                codeNotExist: "ཚབ་ཨང་རེའུ་མིག",
                reqException: "རེ་ཞུའི་རྒྱུན་འགལ།",
                sysException: "རྒྱུད་ཁོངས་རྒྱུན་འགལ།",
                warning: "ཐ་ཚིག་",
                wrong: "ནོར་འཁྲུལ།",
                rulesException: "གྲངས་ཐང་སྒྲིག་སྲོལ་དག་བཤེར་རྒྱུན་འགལ།",
                saveSuccess: "ཉར་ཚགས་ལེགས་འགྲུབ་བྱུང་།",
                saveFailed: "ཉར་ཚགས་ཕམ་པ།",
                deleteSuccess: "སུབ་པ་གྲུབ་འབྲས་ཐོབ་པའི་ངང་",
                deleteError: "སུབ་པ་ཕམ་པ།",
                delDataFail: "བསུབ་པའི་གཞི་གྲངས་ཕམ་པ།",
                noData: "གནས་སྐབས་གཞི་གྲངས་མེད་པ་",
                startsuccess:"འགོ་སློང་ལེགས་གྲུབ་",
                loadmore:"མང་ཙམ་བླུགས་རོགས།",
                nomore:"དེ་ལས་མང་བ་མི་འདུག",
                other:"གཞན་དག",
                valueNotEmpty:"སྟོང་མི་ཆོག",
            },
            local:{
                new: "གསར་འཛུགས།",
                add: "སྣོན་པ་",
            },
            gridpage: {
                choicecolumns: "གདམ་གསེས་གཞུང་སྟར།",
                refresh: "གསར་འདོན་",
                show: "མངོན་པ་",
                records: "ལྕུག་མ།",
                totle: "མཉམ་དུ།",
                valueVail: "སྟོང་མི་ཆོག",
                group:"ཚོ་བགོས་",
                other:"གཞན་དག",
                notConfig: {
                    fetchAction: "མཐོང་རིས་རེའུ་མིགfetchActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    removeAction: "མཐོང་རིས་རེའུ་མིགremoveActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    createAction: "མཐོང་རིས་རེའུ་མིགcreateActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    updateAction: "མཐོང་རིས་རེའུ་མིགupdateActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    loaddraftAction: "མཐོང་རིས་རེའུ་མིགloaddraftActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                },
                data: "གཞི་གྲངས།",
                delDataFail: "བསུབ་པའི་གཞི་གྲངས་ཕམ་པ།",
                delSuccess: "ལེགས་པར་སུབ་པ།",
                confirmDel: "ངོས་འཛིན་བསུབ་དགོས་།",
                notRecoverable: "བསུབ་པའི་བཀོལ་སྤྱོད་སླར་གསོ་བྱེད་མི་ཐུབ།",
                notBatch: "སྡེབ་འབོར་སྦྱོར་རྟ་མངོན་འགྱུར་བྱུང་མེད་།",
                grid: "རེའུ་མིག",
                exportFail: "གཞི་གྲངས་ཕྱིར་འདྲེན་ཕམ་པ།",
                sum: "བསྡོམས་འབོར་",
                formitemFailed: "རེའུ་མིག་ཁེར་རྐྱང་གསར་སྒྱུར་ཕམ་སོང་།",
            },
            list: {
                notConfig: {
                    fetchAction: "མཐོང་རིས་རེའུ་མིག་fetchActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ།",
                    removeAction: "མཐོང་རིས་རེའུ་མིག་removeActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད།",
                    createAction: "མཐོང་རིས་རེའུ་མིག་createActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    updateAction: "མཐོང་རིས་རེའུ་མིག་updateActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ།",
                },
                confirmDel: "ངོས་འཛིན་བསུབ་དགོས་།",
                notRecoverable: "བསུབ་པའི་བཀོལ་སྤྱོད་སླར་གསོ་བྱེད་མི་ཐུབ།",
            },
            listExpBar: {
                title: "རེའུ་མིག་ཕྱོགས་སྟོན་སྡེ་",
            },
            wfExpBar: {
                title: "རྒྱུན་རིམ་ཕྱོགས་སྟོན་སྡེ་",
            },
            calendarExpBar:{
                title: "ལོ་ཐོ་ཕྱོགས་ཁྲིད་སྡེ་",
            },
            treeExpBar: {
                title: "སྡོང་མཐོང་པར་རིས་ཕྱོགས་སྟོན།",
            },
            portlet: {
                noExtensions: "རྒྱ་སྐྱེད་མེད་པའི་བསྒར་ལྷུ།",
            },
            tabpage: {
                sureclosetip: {
                    title: "སྒོ་རྒྱག་དྲན་སྐུལ་",
                    content: "རེའུ་མིག་གི་གཞི་གྲངས་ལ་བཟོ་བཅོས་བྱས་ཟིན།སྒོ་རྒྱག་རྒྱུ་གཏན་འཁེལ་བྱས།",
                },
                closeall: "ཡོད་ཚད་ཁ་རྒྱག",
                closeother: "གཞན་དག་སྒོ་རྒྱག་།",
            },
            fileUpload: {
                caption: "ཡར་བསྐུར་",
            },
            searchButton: {
                search: "བཤེར་འཚོལ་",
                reset: "བསྐྱར་འཇོག",
            },
            calendar:{
            today: "དེ་རིང་",
            month: "ཟླ་བ།",
            week: "གཟའ་འཁོར།",
            day: "གནམ་",
            list: "གཞུང་།",
            dateSelectModalTitle: "བདམས་ནས་མཆོང་བའི་དུས་ཚོད་།",
            gotoDate: "མཆོང་བ།མཆོང་བ།",
            from: "ནས།",
            to: "སླེབས་པ་",
            },
            // 非实体视图
            views: {
                index: {
                    caption: commonLogic.appcommonhandle("ibizlab",null),
                    title: commonLogic.appcommonhandle("Runtime",null),
                },
            },
            utilview:{
                importview:"ནང་འདྲེན་གཞི་གྲངས།",
                warning:"ཐ་ཚིག་",
                info:"གཞི་གྲངས་ནང་འདྲེན་རྣམ་གྲངས་བཀོད་སྒྲིག་བྱེད་རོགས་།" 
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
                desc1: "བཀོལ་སྤྱོད་མ་ཐུབ་པར་མིག་སྔའི་རེའུ་མིག་གི་རྣམ་གྲངས་རྐྱང་པ་རྙེད་མ་ཐུབ་པ།",
                desc2: "མུ་མཐུད་དུ་བཀོལ་སྤྱོད་བྱེད་ཐབས་མེད།",
                notconfig: {
                    loadaction: "མཐོང་རིས་རེའུ་མིགloadActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    loaddraftaction: "མཐོང་རིས་རེའུ་མིག loaddraftActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    actionname: "མཐོང་རིས་རེའུ་མིག'+actionName+'ཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    removeaction: "མཐོང་རིས་རེའུ་མིགremoveActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                },
                saveerror: "གཞི་གྲངས་ཉར་ཚགས་ནོར་འཁྲུལ་བྱུང་བ་",
                savecontent: "གྲངས་གཞི་གཅིག་པ་མ་རེད།ཕལ་ཆེར་རྒྱབ་སྟེགས་ཀྱི་གྲངས་གཞི་བཟོ་བཅོས་བརྒྱབ་ཟིན་པས།གཞི་གྲངས་བསྐྱར་དུ་སྣོན་དགོས་སམ།",
                valuecheckex: "གྲངས་ཐང་སྒྲིག་སྲོལ་དག་བཤེར་རྒྱུན་འགལ།",
                savesuccess: "ཉར་ཚགས་ལེགས་འགྲུབ་བྱུང་།",
                deletesuccess: "ལེགས་འགྲུབ་བསུབ་པ།",  
                workflow: {
                    starterror: "ལས་ཀའི་རྒྱུན་འགོ་སློང་ཕམ་པ།",
                    startsuccess: "ལས་ཀའི་རྒྱུན་གྱི་འགོ་སློང་ཐུབ་པ།",
                    submiterror: "ལས་དོན་ཡར་ཕུལ་ཕམ་།",
                    submitsuccess: "ལས་ཀའི་རྒྱུན་ལ་ཕུལ་གྲུབ་འབྲས་ཐོབ་པའི་ངང་།",
                },
                updateerror: "རེའུ་མིག་ཁེར་རྐྱང་གསར་སྒྱུར་ཕམ་སོང་།",     
            },
            gridBar: {
                title: "རེའུ་མིག་ཕྱོགས་སྟོན།",
            },
            multiEditView: {
                notConfig: {
                    fetchAction: "མཐོང་རིས་མང་བའི་རྩོམ་སྒྲིག་མཐོང་རིས་ངོས་པང་fetchActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    loaddraftAction: "མཐོང་རིས་མང་བའི་རྩོམ་སྒྲིག་མཐོང་རིས་ངོས་པང་loaddraftActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                },
            },
            dataViewExpBar: {
                title: "ཁཱ་མཐོང་རིས་ཕྱོགས་སྟོན།",
            },
            kanban: {
                notConfig: {
                    fetchAction: "མཐོང་རིས་རེའུ་མིག་fetchActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    removeAction: "མཐོང་རིས་རེའུ་མིགremoveActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                },
                delete1: "ངོས་འཛིན་བསུབ་དགོས་།",
                delete2: "བསུབ་པའི་བཀོལ་སྤྱོད་སླར་གསོ་བྱེད་མི་ཐུབ།",
                fold: "ལྟེབ་",
                unfold: "བཀྲམ་པ་",
            },
            dashBoard: {
                handleClick: {
                    title: "ངོས་པང་ཇུས་འགོད་",
                },
            },
            dataView: {
                sum: "མཉམ་དུ།",
                data: "དོན་ཚན་གཞི་གྲངས།",
            },
            chart: {
                undefined: "མཚན་ཉིད་མ་བཞག་པ།",
                quarter: "དུས་ཚིགས་",   
                year: "ལོ་",
            },
            searchForm: {
                notConfig: {
                    loadAction: "མཐོང་རིས་བཤེར་འཚོལ་རེའུ་མིགloadActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                    loaddraftAction: "མཐོང་རིས་བཤེར་འཚོལ་རེའུ་མིགloaddraftActionཞུགས་གྲངས་བཀོད་སྒྲིག་བྱས་མེད་པ་",
                },
                custom: "གསོག་འཇོག་མཚན་ཉིད་རང་འདྲི་",
                title: "མིང་།",
            },
            wizardPanel: {
                back: "གོམ་གང་སྔོན་མ།",
                next: "གོམ་པ་རྗེས་མ་",
                complete: "གྲུབ་པ་",
                preactionmessage:"བཀོད་སྒྲིག་མེད་པར་རྩིས་རྒྱག་སྐབས་རྐང་ཐང་མར་འགྲོ་དགོས།"
            },
            viewLayoutPanel: {
                appLogoutView: {
                    prompt1: "གུས་པར་འོས་པའི་མཁོ་མཁན་ཁྱེད་རང་གི་གྲུབ་འབྲས་ཐོབ་པའི་ངང་ཕྱིར་འཐེན་མ་ལག་དང་།མ་འོངས་པར་།",
                    prompt2: "སྐར་ཆ་རྗེས་མཆོང་ནས་",
                    logingPage: "ཐོ་འཇུག་ལྡེབ་ངོས།",
                },
                appWfstepTraceView: {
                    title: "ཉེར་སྤྱོད་རྒྱུན་རིམ་སྒྲིག་གཅོད་ཟིན་ཐོའི་མཐོང་རིས་",
                },
                appWfstepDataView: {
                    title: "ཉེར་སྤྱོད་རྒྱུན་རིམ་རྗེས་འདེད་མཐོང་རིས་",
                },
                appLoginView: {
                    username: "སྤྱོད་མཁན་གྱི་མིང་",
                    password: "གསང་ཨང་",
                    login: "ཐོ་འགོད།",
                },
            },
        },
        entities: {
            jobslog: jobslog_BO_CN(),
            sysrolepermission: sysrolepermission_BO_CN(),
            msguseraccount: msguseraccount_BO_CN(),
            sysuser: sysuser_BO_CN(),
            sysauthlog: sysauthlog_BO_CN(),
            wfmember: wfmember_BO_CN(),
            syspost: syspost_BO_CN(),
            sysuserauth: sysuserauth_BO_CN(),
            sysdepartment: sysdepartment_BO_CN(),
            sysemployee: sysemployee_BO_CN(),
            paytrade: paytrade_BO_CN(),
            msgtemplate: msgtemplate_BO_CN(),
            systeam: systeam_BO_CN(),
            wfuser: wfuser_BO_CN(),
            payopenaccess: payopenaccess_BO_CN(),
            sysorganization: sysorganization_BO_CN(),
            jobsregistry: jobsregistry_BO_CN(),
            sysopenaccess: sysopenaccess_BO_CN(),
            dictcatalog: dictcatalog_BO_CN(),
            wfgroup: wfgroup_BO_CN(),
            jobsinfo: jobsinfo_BO_CN(),
            wfremodel: wfremodel_BO_CN(),
            sysuserrole: sysuserrole_BO_CN(),
            wfprocessdefinition: wfprocessdefinition_BO_CN(),
            sysrole: sysrole_BO_CN(),
            syspermission: syspermission_BO_CN(),
            msgopenaccess: msgopenaccess_BO_CN(),
            systeammember: systeammember_BO_CN(),
            sysdeptmember: sysdeptmember_BO_CN(),
            dictoption: dictoption_BO_CN(),
            sysapp: sysapp_BO_CN(),
        },
        components: components_BO_CN(),
        codelist: codelist_BO_CN(),
        userCustom: userCustom_BO_CN(),
    };
    return data;
}
export default getAppLocale;