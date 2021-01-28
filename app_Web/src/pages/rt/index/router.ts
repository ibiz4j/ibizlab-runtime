import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/index/:index?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'index';
                const params: any = {};
                if (to.params && to.params[routerParamsName]) {
                    Object.assign(params, qs.parse(to.params[routerParamsName], { delimiter: ';' }));
                }
                const url: string = '/appdata';
                const auth: Promise<any> = AuthGuard.getInstance().authGuard(url, params, router);
                auth.then(() => {
                    next();
                }).catch(() => {
                    next();
                });
            },
            meta: {  
                caption: 'app.views.index.caption',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'index', parameterName: 'index' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/rt/index/index.vue'),
            children: [
                {
                    path: 'paytrades/:paytrade?/editview/:editview?',
                    meta: {
                        caption: 'entities.paytrade.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'paytrades', parameterName: 'paytrade' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-trade-edit-view/pay-trade-edit-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.wfgroup.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-pickup-view/wfgroup-pickup-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysrole.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-mpickup-view/sys-role-mpickup-view.vue'),
                },
                {
                    path: 'msguseraccounts/:msguseraccount?/editview/:editview?',
                    meta: {
                        caption: 'entities.msguseraccount.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'msguseraccounts', parameterName: 'msguseraccount' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-user-account-edit-view/msg-user-account-edit-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.wfuser.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfusers', parameterName: 'wfuser' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfuser-mpickup-view/wfuser-mpickup-view.vue'),
                },
                {
                    path: 'sysuserauths/:sysuserauth?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserauth.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysuserauths', parameterName: 'sysuserauth' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-auth-grid-view/sys-user-auth-grid-view.vue'),
                },
                {
                    path: 'sysposts/:syspost?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.syspost.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysposts', parameterName: 'syspost' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-post-grid-view/sys-post-grid-view.vue'),
                },
                {
                    path: 'msgopenaccesses/:msgopenaccess?/editview/:editview?',
                    meta: {
                        caption: 'entities.msgopenaccess.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-open-access-edit-view/msg-open-access-edit-view.vue'),
                },
                {
                    path: 'msgtemplates/:msgtemplate?/editview/:editview?',
                    meta: {
                        caption: 'entities.msgtemplate.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'msgtemplates', parameterName: 'msgtemplate' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-template-edit-view/msg-template-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.sysorganization.views.treeexpview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-tree-exp-view/sys-organization-tree-exp-view.vue'),
                },
                {
                    path: 'sysopenaccesses/:sysopenaccess?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysopenaccess.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-open-access-edit-view/sys-open-access-edit-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/sysuserroles/:sysuserrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-grid-view/sys-user-role-grid-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/sysuserroles/:sysuserrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-grid-view/sys-user-role-grid-view.vue'),
                },
                {
                    path: 'sysuserroles/:sysuserrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-grid-view/sys-user-role-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-pickup-view/sys-department-pickup-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-pickup-view/sys-department-pickup-view.vue'),
                },
                {
                    path: 'paytrades/:paytrade?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.paytrade.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'paytrades', parameterName: 'paytrade' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-trade-grid-view/pay-trade-grid-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/wfmembers/:wfmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfusers', parameterName: 'wfuser' },
                            { pathName: 'wfmembers', parameterName: 'wfmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/wfmembers/:wfmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'wfmembers', parameterName: 'wfmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'),
                },
                {
                    path: 'wfmembers/:wfmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfmembers', parameterName: 'wfmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'),
                },
                {
                    path: 'jobslogs/:jobslog?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.jobslog.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'jobslogs', parameterName: 'jobslog' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-log-grid-view/jobs-log-grid-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysrole.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-pickup-grid-view/sys-role-pickup-grid-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/wfmembers/:wfmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfusers', parameterName: 'wfuser' },
                            { pathName: 'wfmembers', parameterName: 'wfmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/wfmembers/:wfmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'wfmembers', parameterName: 'wfmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'),
                },
                {
                    path: 'wfmembers/:wfmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfmembers', parameterName: 'wfmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/editview/:editview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-catalog-edit-view/dict-catalog-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
                },
                {
                    path: 'sysdeptmembers/:sysdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
                },
                {
                    path: 'wfprocessdefinitions/:wfprocessdefinition?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfprocessdefinition.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfprocess-definition-edit-view/wfprocess-definition-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysrole.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-edit-view/sys-role-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.treeexpview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-tree-exp-view/sys-department-tree-exp-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.treeexpview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-tree-exp-view/sys-department-tree-exp-view.vue'),
                },
                {
                    path: 'msgtemplates/:msgtemplate?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.msgtemplate.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'msgtemplates', parameterName: 'msgtemplate' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-template-grid-view/msg-template-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-grid-view/sys-department-grid-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-grid-view/sys-department-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-pickup-grid-view/sys-department-pickup-grid-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-pickup-grid-view/sys-department-pickup-grid-view.vue'),
                },
                {
                    path: 'sysopenaccesses/:sysopenaccess?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysopenaccess.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-open-access-grid-view/sys-open-access-grid-view.vue'),
                },
                {
                    path: 'systeams/:systeam?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeam.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'systeams', parameterName: 'systeam' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-grid-view/sys-team-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
                },
                {
                    path: 'sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
                },
                {
                    path: 'payopenaccesses/:payopenaccess?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.payopenaccess.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-open-access-grid-view/pay-open-access-grid-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysrole.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-grid-view/sys-role-grid-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.wfgroup.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-mpickup-view/wfgroup-mpickup-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfgroup.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-grid-view/wfgroup-grid-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-catalog-grid-view/dict-catalog-grid-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.wfuser.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfusers', parameterName: 'wfuser' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfuser-pickup-view/wfuser-pickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysemployee.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysemployee.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysemployee.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysemployee.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
                },
                {
                    path: 'wfremodels/:wfremodel?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfremodel.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfremodels', parameterName: 'wfremodel' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfremodel-edit-view/wfremodel-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
                },
                {
                    path: 'msgopenaccesses/:msgopenaccess?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.msgopenaccess.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-open-access-pickup-view/msg-open-access-pickup-view.vue'),
                },
                {
                    path: 'sysauthlogs/:sysauthlog?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysauthlog.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysauthlogs', parameterName: 'sysauthlog' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-auth-log-grid-view/sys-auth-log-grid-view.vue'),
                },
                {
                    path: 'sysposts/:syspost?/editview/:editview?',
                    meta: {
                        caption: 'entities.syspost.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysposts', parameterName: 'syspost' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-post-edit-view/sys-post-edit-view.vue'),
                },
                {
                    path: 'jobslogs/:jobslog?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobslog.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'jobslogs', parameterName: 'jobslog' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-log-edit-view/jobs-log-edit-view.vue'),
                },
                {
                    path: 'sysposts/:syspost?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.syspost.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysposts', parameterName: 'syspost' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-post-pickup-view/sys-post-pickup-view.vue'),
                },
                {
                    path: 'jobsinfos/:jobsinfo?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.jobsinfo.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-info-grid-view/jobs-info-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysuser.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-pickup-view/sys-user-pickup-view.vue'),
                },
                {
                    path: 'wfprocessdefinitions/:wfprocessdefinition?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfprocessdefinition.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfprocess-definition-grid-view/wfprocess-definition-grid-view.vue'),
                },
                {
                    path: 'systeams/:systeam?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeam.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'systeams', parameterName: 'systeam' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-edit-view/sys-team-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeammember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeammember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeammember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
                },
                {
                    path: 'systeams/:systeam?/systeammembers/:systeammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeammember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'systeams', parameterName: 'systeam' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeammember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
                },
                {
                    path: 'systeammembers/:systeammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeammember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysorganization.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-pickup-grid-view/sys-organization-pickup-grid-view.vue'),
                },
                {
                    path: 'sysapps/:sysapp?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysapp.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysapps', parameterName: 'sysapp' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-app-grid-view/sys-app-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysuser.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-mpickup-view/sys-user-mpickup-view.vue'),
                },
                {
                    path: 'jobsinfos/:jobsinfo?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobsinfo.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-info-edit-view/jobs-info-edit-view.vue'),
                },
                {
                    path: 'msguseraccounts/:msguseraccount?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.msguseraccount.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'msguseraccounts', parameterName: 'msguseraccount' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-user-account-grid-view/msg-user-account-grid-view.vue'),
                },
                {
                    path: 'sysuserauths/:sysuserauth?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserauth.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysuserauths', parameterName: 'sysuserauth' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-auth-edit-view/sys-user-auth-edit-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/editview/:editview?',
                    meta: {
                        caption: 'entities.dictoption.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-edit-view/dict-option-edit-view.vue'),
                },
                {
                    path: 'dictoptions/:dictoption?/editview/:editview?',
                    meta: {
                        caption: 'entities.dictoption.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-edit-view/dict-option-edit-view.vue'),
                },
                {
                    path: 'payopenaccesses/:payopenaccess?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.payopenaccess.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-open-access-pickup-grid-view/pay-open-access-pickup-grid-view.vue'),
                },
                {
                    path: 'msgopenaccesses/:msgopenaccess?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.msgopenaccess.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-open-access-pickup-grid-view/msg-open-access-pickup-grid-view.vue'),
                },
                {
                    path: 'msgopenaccesses/:msgopenaccess?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.msgopenaccess.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/notify/msg-open-access-grid-view/msg-open-access-grid-view.vue'),
                },
                {
                    path: 'jobsregistries/:jobsregistry?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.jobsregistry.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-registry-grid-view/jobs-registry-grid-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.wfuser.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfusers', parameterName: 'wfuser' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfuser-pickup-grid-view/wfuser-pickup-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-mpickup-view/sys-employee-mpickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-mpickup-view/sys-employee-mpickup-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-mpickup-view/sys-employee-mpickup-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-mpickup-view/sys-employee-mpickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysorganization.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-pickup-view/sys-organization-pickup-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.wfgroup.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-pickup-grid-view/wfgroup-pickup-grid-view.vue'),
                },
                {
                    path: 'jobsregistries/:jobsregistry?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobsregistry.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/task/jobs-registry-edit-view/jobs-registry-edit-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
                },
                {
                    path: 'sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfgroup.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-edit-view/wfgroup-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-mpickup-view/sys-department-mpickup-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-mpickup-view/sys-department-mpickup-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
                },
                {
                    path: 'syspermissions/:syspermission?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'syspermissions', parameterName: 'syspermission' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
                },
                {
                    path: 'sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                            { pathName: 'customview', parameterName: 'customview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-edit-view/sys-department-edit-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-edit-view/sys-department-edit-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/grideditview/:grideditview?',
                    meta: {
                        caption: 'entities.dictoption.views.grideditview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'grideditview', parameterName: 'grideditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-grid-edit-view/dict-option-grid-edit-view.vue'),
                },
                {
                    path: 'dictoptions/:dictoption?/grideditview/:grideditview?',
                    meta: {
                        caption: 'entities.dictoption.views.grideditview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'grideditview', parameterName: 'grideditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-grid-edit-view/dict-option-grid-edit-view.vue'),
                },
                {
                    path: 'payopenaccesses/:payopenaccess?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.payopenaccess.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-open-access-pickup-view/pay-open-access-pickup-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-catalog-pickup-grid-view/dict-catalog-pickup-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeammember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeammember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeammember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
                },
                {
                    path: 'systeams/:systeam?/systeammembers/:systeammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeammember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'systeams', parameterName: 'systeam' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeammember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
                },
                {
                    path: 'systeammembers/:systeammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeammember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysorganization.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-edit-view/sys-organization-edit-view.vue'),
                },
                {
                    path: 'payopenaccesses/:payopenaccess?/editview/:editview?',
                    meta: {
                        caption: 'entities.payopenaccess.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pay/pay-open-access-edit-view/pay-open-access-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysrole.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysroles', parameterName: 'sysrole' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-role-pickup-view/sys-role-pickup-view.vue'),
                },
                {
                    path: 'sysapps/:sysapp?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysapp.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysapps', parameterName: 'sysapp' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-app-edit-view/sys-app-edit-view.vue'),
                },
                {
                    path: 'sysposts/:syspost?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.syspost.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysposts', parameterName: 'syspost' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-post-pickup-grid-view/sys-post-pickup-grid-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.dictoption.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-grid-view/dict-option-grid-view.vue'),
                },
                {
                    path: 'dictoptions/:dictoption?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.dictoption.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-grid-view/dict-option-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysuser.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysusers', parameterName: 'sysuser' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/uaa/sys-user-pickup-grid-view/sys-user-pickup-grid-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-catalog-pickup-view/dict-catalog-pickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysorganization.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-grid-view/sys-organization-grid-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/msgopenaccesses/:msgopenaccess?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.msgopenaccess.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-open-access-pickup-grid-view/msg-open-access-pickup-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysdepartment.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-pickup-grid-view/sys-department-pickup-grid-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysdepartment.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-pickup-grid-view/sys-department-pickup-grid-view.vue'),
    },
    {
        path: '/paytrades/:paytrade?/editview/:editview?',
        meta: {
            caption: 'entities.paytrade.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'paytrades', parameterName: 'paytrade' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-trade-edit-view/pay-trade-edit-view.vue'),
    },
    {
        path: '/sysposts/:syspost?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.syspost.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysposts', parameterName: 'syspost' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-post-pickup-view/sys-post-pickup-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/editview/:editview?',
        meta: {
            caption: 'entities.dictoption.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                { pathName: 'dictoptions', parameterName: 'dictoption' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-option-edit-view/dict-option-edit-view.vue'),
    },
    {
        path: '/dictoptions/:dictoption?/editview/:editview?',
        meta: {
            caption: 'entities.dictoption.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'dictoptions', parameterName: 'dictoption' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-option-edit-view/dict-option-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.sysdepartment.views.treeexpview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-tree-exp-view/sys-department-tree-exp-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.sysdepartment.views.treeexpview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-tree-exp-view/sys-department-tree-exp-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/wfmembers/:wfmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'wfusers', parameterName: 'wfuser' },
                { pathName: 'wfmembers', parameterName: 'wfmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/wfmembers/:wfmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'wfmembers', parameterName: 'wfmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'),
    },
    {
        path: '/wfmembers/:wfmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'wfmembers', parameterName: 'wfmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'),
    },
    {
        path: '/msgopenaccesses/:msgopenaccess?/gridview/:gridview?',
        meta: {
            caption: 'entities.msgopenaccess.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-open-access-grid-view/msg-open-access-grid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysrole.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-grid-view/sys-role-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/editview/:editview?',
        meta: {
            caption: 'entities.sysdepartment.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-edit-view/sys-department-edit-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/editview/:editview?',
        meta: {
            caption: 'entities.sysdepartment.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-edit-view/sys-department-edit-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.wfgroup.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-pickup-grid-view/wfgroup-pickup-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdepartment.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-grid-view/sys-department-grid-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdepartment.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-grid-view/sys-department-grid-view.vue'),
    },
    {
        path: '/sysuserauths/:sysuserauth?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserauth.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysuserauths', parameterName: 'sysuserauth' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-auth-edit-view/sys-user-auth-edit-view.vue'),
    },
    {
        path: '/sysapps/:sysapp?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysapp.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysapps', parameterName: 'sysapp' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-app-grid-view/sys-app-grid-view.vue'),
    },
    {
        path: '/paytrades/:paytrade?/gridview/:gridview?',
        meta: {
            caption: 'entities.paytrade.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'paytrades', parameterName: 'paytrade' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-trade-grid-view/pay-trade-grid-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysuser.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-mpickup-view/sys-user-mpickup-view.vue'),
    },
    {
        path: '/sysposts/:syspost?/editview/:editview?',
        meta: {
            caption: 'entities.syspost.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysposts', parameterName: 'syspost' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-post-edit-view/sys-post-edit-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/gridview/:gridview?',
        meta: {
            caption: 'entities.dictoption.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                { pathName: 'dictoptions', parameterName: 'dictoption' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-option-grid-view/dict-option-grid-view.vue'),
    },
    {
        path: '/dictoptions/:dictoption?/gridview/:gridview?',
        meta: {
            caption: 'entities.dictoption.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'dictoptions', parameterName: 'dictoption' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-option-grid-view/dict-option-grid-view.vue'),
    },
    {
        path: '/sysauthlogs/:sysauthlog?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysauthlog.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysauthlogs', parameterName: 'sysauthlog' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-auth-log-grid-view/sys-auth-log-grid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysrole.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-pickup-view/sys-role-pickup-view.vue'),
    },
    {
        path: '/sysopenaccesses/:sysopenaccess?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysopenaccess.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-open-access-grid-view/sys-open-access-grid-view.vue'),
    },
    {
        path: '/msgtemplates/:msgtemplate?/gridview/:gridview?',
        meta: {
            caption: 'entities.msgtemplate.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'msgtemplates', parameterName: 'msgtemplate' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-template-grid-view/msg-template-grid-view.vue'),
    },
    {
        path: '/msgtemplates/:msgtemplate?/editview/:editview?',
        meta: {
            caption: 'entities.msgtemplate.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'msgtemplates', parameterName: 'msgtemplate' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-template-edit-view/msg-template-edit-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysuser.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-pickup-view/sys-user-pickup-view.vue'),
    },
    {
        path: '/sysopenaccesses/:sysopenaccess?/editview/:editview?',
        meta: {
            caption: 'entities.sysopenaccess.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysopenaccesses', parameterName: 'sysopenaccess' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-open-access-edit-view/sys-open-access-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysorganization.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-organization-pickup-grid-view/sys-organization-pickup-grid-view.vue'),
    },
    {
        path: '/jobsregistries/:jobsregistry?/gridview/:gridview?',
        meta: {
            caption: 'entities.jobsregistry.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-registry-grid-view/jobs-registry-grid-view.vue'),
    },
    {
        path: '/wfprocessdefinitions/:wfprocessdefinition?/editview/:editview?',
        meta: {
            caption: 'entities.wfprocessdefinition.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfprocess-definition-edit-view/wfprocess-definition-edit-view.vue'),
    },
    {
        path: '/sysapps/:sysapp?/editview/:editview?',
        meta: {
            caption: 'entities.sysapp.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysapps', parameterName: 'sysapp' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-app-edit-view/sys-app-edit-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/grideditview/:grideditview?',
        meta: {
            caption: 'entities.dictoption.views.grideditview.caption',
            info:'',
            parameters: [
                { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                { pathName: 'dictoptions', parameterName: 'dictoption' },
                { pathName: 'grideditview', parameterName: 'grideditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-option-grid-edit-view/dict-option-grid-edit-view.vue'),
    },
    {
        path: '/dictoptions/:dictoption?/grideditview/:grideditview?',
        meta: {
            caption: 'entities.dictoption.views.grideditview.caption',
            info:'',
            parameters: [
                { pathName: 'dictoptions', parameterName: 'dictoption' },
                { pathName: 'grideditview', parameterName: 'grideditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-option-grid-edit-view/dict-option-grid-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/editview/:editview?',
        meta: {
            caption: 'entities.sysorganization.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-organization-edit-view/sys-organization-edit-view.vue'),
    },
    {
        path: '/jobsinfos/:jobsinfo?/editview/:editview?',
        meta: {
            caption: 'entities.jobsinfo.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-info-edit-view/jobs-info-edit-view.vue'),
    },
    {
        path: '/msguseraccounts/:msguseraccount?/editview/:editview?',
        meta: {
            caption: 'entities.msguseraccount.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'msguseraccounts', parameterName: 'msguseraccount' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-user-account-edit-view/msg-user-account-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdeptmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdeptmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdeptmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdeptmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdeptmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdeptmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
    },
    {
        path: '/sysdeptmembers/:sysdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysdeptmember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-grid-view/sys-dept-member-grid-view.vue'),
    },
    {
        path: '/jobsregistries/:jobsregistry?/editview/:editview?',
        meta: {
            caption: 'entities.jobsregistry.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'jobsregistries', parameterName: 'jobsregistry' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-registry-edit-view/jobs-registry-edit-view.vue'),
    },
    {
        path: '/wfremodels/:wfremodel?/editview/:editview?',
        meta: {
            caption: 'entities.wfremodel.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'wfremodels', parameterName: 'wfremodel' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfremodel-edit-view/wfremodel-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.sysorganization.views.treeexpview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-organization-tree-exp-view/sys-organization-tree-exp-view.vue'),
    },
    {
        path: '/systeams/:systeam?/editview/:editview?',
        meta: {
            caption: 'entities.systeam.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'systeams', parameterName: 'systeam' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-edit-view/sys-team-edit-view.vue'),
    },
    {
        path: '/msgopenaccesses/:msgopenaccess?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.msgopenaccess.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-open-access-pickup-view/msg-open-access-pickup-view.vue'),
    },
    {
        path: '/payopenaccesses/:payopenaccess?/gridview/:gridview?',
        meta: {
            caption: 'entities.payopenaccess.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-open-access-grid-view/pay-open-access-grid-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.wfuser.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'wfusers', parameterName: 'wfuser' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfuser-pickup-view/wfuser-pickup-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysorganization.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-organization-grid-view/sys-organization-grid-view.vue'),
    },
    {
        path: '/sysposts/:syspost?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.syspost.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysposts', parameterName: 'syspost' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-post-pickup-grid-view/sys-post-pickup-grid-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/sysuserroles/:sysuserrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserrole.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-grid-view/sys-user-role-grid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/sysuserroles/:sysuserrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserrole.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-grid-view/sys-user-role-grid-view.vue'),
    },
    {
        path: '/sysuserroles/:sysuserrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserrole.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-grid-view/sys-user-role-grid-view.vue'),
    },
    {
        path: '/jobslogs/:jobslog?/gridview/:gridview?',
        meta: {
            caption: 'entities.jobslog.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'jobslogs', parameterName: 'jobslog' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-log-grid-view/jobs-log-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysemployee.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysemployee.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysemployee.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysemployee.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysuser.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-pickup-grid-view/sys-user-pickup-grid-view.vue'),
    },
    {
        path: '/msgopenaccesses/:msgopenaccess?/editview/:editview?',
        meta: {
            caption: 'entities.msgopenaccess.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'msgopenaccesses', parameterName: 'msgopenaccess' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-open-access-edit-view/msg-open-access-edit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysrole.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-edit-view/sys-role-edit-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/wfmembers/:wfmember?/editview/:editview?',
        meta: {
            caption: 'entities.wfmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'wfusers', parameterName: 'wfuser' },
                { pathName: 'wfmembers', parameterName: 'wfmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/wfmembers/:wfmember?/editview/:editview?',
        meta: {
            caption: 'entities.wfmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'wfmembers', parameterName: 'wfmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'),
    },
    {
        path: '/wfmembers/:wfmember?/editview/:editview?',
        meta: {
            caption: 'entities.wfmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'wfmembers', parameterName: 'wfmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/gridview/:gridview?',
        meta: {
            caption: 'entities.dictcatalog.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-catalog-grid-view/dict-catalog-grid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysrole.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-pickup-grid-view/sys-role-pickup-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysorganization.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-organization-pickup-view/sys-organization-pickup-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.dictcatalog.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-catalog-pickup-grid-view/dict-catalog-pickup-grid-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.wfuser.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'wfusers', parameterName: 'wfuser' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfuser-mpickup-view/wfuser-mpickup-view.vue'),
    },
    {
        path: '/syspermissions/:syspermission?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.syspermission.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'syspermissions', parameterName: 'syspermission' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-permission-mpickup-view/sys-permission-mpickup-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.systeammember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.systeammember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.systeammember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
    },
    {
        path: '/systeams/:systeam?/systeammembers/:systeammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.systeammember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'systeams', parameterName: 'systeam' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.systeammember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
    },
    {
        path: '/systeammembers/:systeammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.systeammember.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.wfgroup.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-mpickup-view/wfgroup-mpickup-view.vue'),
    },
    {
        path: '/syspermissions/:syspermission?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.syspermission.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'syspermissions', parameterName: 'syspermission' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-permission-pickup-grid-view/sys-permission-pickup-grid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
    },
    {
        path: '/syspermissions/:syspermission?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.caption',
            info:'',
            parameters: [
                { pathName: 'syspermissions', parameterName: 'syspermission' },
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
    },
    {
        path: '/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.caption',
            info:'',
            parameters: [
                { pathName: 'sysrolepermissions', parameterName: 'sysrolepermission' },
                { pathName: 'customview', parameterName: 'customview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-permission-custom-view/sys-role-permission-custom-view.vue'),
    },
    {
        path: '/msguseraccounts/:msguseraccount?/gridview/:gridview?',
        meta: {
            caption: 'entities.msguseraccount.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'msguseraccounts', parameterName: 'msguseraccount' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/notify/msg-user-account-grid-view/msg-user-account-grid-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysrole.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-role-mpickup-view/sys-role-mpickup-view.vue'),
    },
    {
        path: '/sysposts/:syspost?/gridview/:gridview?',
        meta: {
            caption: 'entities.syspost.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysposts', parameterName: 'syspost' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-post-grid-view/sys-post-grid-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.dictcatalog.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-catalog-pickup-view/dict-catalog-pickup-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysemployee.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysemployee.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysemployee.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysemployee.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/editview/:editview?',
        meta: {
            caption: 'entities.dictcatalog.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/dict/dict-catalog-edit-view/dict-catalog-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysemployee.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-mpickup-view/sys-employee-mpickup-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysemployee.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-mpickup-view/sys-employee-mpickup-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysemployee.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-mpickup-view/sys-employee-mpickup-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysemployee.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-mpickup-view/sys-employee-mpickup-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.wfgroup.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-pickup-view/wfgroup-pickup-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/editview/:editview?',
        meta: {
            caption: 'entities.sysemployee.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/editview/:editview?',
        meta: {
            caption: 'entities.sysemployee.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/editview/:editview?',
        meta: {
            caption: 'entities.sysemployee.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/editview/:editview?',
        meta: {
            caption: 'entities.sysemployee.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
    },
    {
        path: '/payopenaccesses/:payopenaccess?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.payopenaccess.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-open-access-pickup-grid-view/pay-open-access-pickup-grid-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/editview/:editview?',
        meta: {
            caption: 'entities.wfgroup.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-edit-view/wfgroup-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
        meta: {
            caption: 'entities.systeammember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
        meta: {
            caption: 'entities.systeammember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
        meta: {
            caption: 'entities.systeammember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
    },
    {
        path: '/systeams/:systeam?/systeammembers/:systeammember?/editview/:editview?',
        meta: {
            caption: 'entities.systeammember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'systeams', parameterName: 'systeam' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
        meta: {
            caption: 'entities.systeammember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
    },
    {
        path: '/systeammembers/:systeammember?/editview/:editview?',
        meta: {
            caption: 'entities.systeammember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'systeammembers', parameterName: 'systeammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
    },
    {
        path: '/jobslogs/:jobslog?/editview/:editview?',
        meta: {
            caption: 'entities.jobslog.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'jobslogs', parameterName: 'jobslog' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-log-edit-view/jobs-log-edit-view.vue'),
    },
    {
        path: '/wfprocessdefinitions/:wfprocessdefinition?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfprocessdefinition.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfprocess-definition-grid-view/wfprocess-definition-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.sysdeptmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.sysdeptmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.sysdeptmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.sysdeptmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.sysdeptmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.sysdeptmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
    },
    {
        path: '/sysdeptmembers/:sysdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.sysdeptmember.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.wfuser.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'wfusers', parameterName: 'wfuser' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfuser-pickup-grid-view/wfuser-pickup-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysdepartment.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-pickup-view/sys-department-pickup-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysdepartment.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-pickup-view/sys-department-pickup-view.vue'),
    },
    {
        path: '/systeams/:systeam?/gridview/:gridview?',
        meta: {
            caption: 'entities.systeam.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'systeams', parameterName: 'systeam' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-team-grid-view/sys-team-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysdepartment.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-mpickup-view/sys-department-mpickup-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysdepartment.views.mpickupview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-mpickup-view/sys-department-mpickup-view.vue'),
    },
    {
        path: '/jobsinfos/:jobsinfo?/gridview/:gridview?',
        meta: {
            caption: 'entities.jobsinfo.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'jobsinfos', parameterName: 'jobsinfo' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/task/jobs-info-grid-view/jobs-info-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysemployee.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysemployee.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysemployee.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysemployee.views.pickupgridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysusers', parameterName: 'sysuser' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysroles', parameterName: 'sysrole' },
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
    },
    {
        path: '/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'sysuserroles', parameterName: 'sysuserrole' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-role-edit-view/sys-user-role-edit-view.vue'),
    },
    {
        path: '/payopenaccesses/:payopenaccess?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.payopenaccess.views.pickupview.caption',
            info:'',
            parameters: [
                { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-open-access-pickup-view/pay-open-access-pickup-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfgroup.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-grid-view/wfgroup-grid-view.vue'),
    },
    {
        path: '/payopenaccesses/:payopenaccess?/editview/:editview?',
        meta: {
            caption: 'entities.payopenaccess.views.editview.caption',
            info:'',
            parameters: [
                { pathName: 'payopenaccesses', parameterName: 'payopenaccess' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pay/pay-open-access-edit-view/pay-open-access-edit-view.vue'),
    },
    {
        path: '/sysuserauths/:sysuserauth?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserauth.views.gridview.caption',
            info:'',
            parameters: [
                { pathName: 'sysuserauths', parameterName: 'sysuserauth' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/uaa/sys-user-auth-grid-view/sys-user-auth-grid-view.vue'),
    },
        ...globalRoutes,
        {
            path: '/login/:login?',
            name: 'login',
            meta: {  
                caption: '登录',
                viewType: 'login',
                requireAuth: false,
                ignoreAddPage: true,
            },
            beforeEnter: (to: any, from: any, next: any) => {
                router.app.$store.commit('resetRootStateData');
                next();
            },
            component: () => import('@components/login/login.vue'),
        },
        {
            path: '/lock',
            name: 'lock',
            meta: {  
                caption: '锁屏',
                viewType: 'lock',
                requireAuth: false,
                ignoreAddPage: true,
            },
            beforeEnter: (to: any, from: any, next: any) => {
                next();
            },
            component: () => import('@components/app-lock/app-lock.vue'),
        },
        {
            path: '/404',
            component: () => import('@components/404/404.vue')
        },
        {
            path: '/500',
            component: () => import('@components/500/500.vue')
        },
        {
            path: '*',
            redirect: 'index'
        },
    ],
});
// 解决路由跳转路由重复时报错
const originalPush = Router.prototype.push
Router.prototype.push = function push(location: any) {
    let result: any = originalPush.call(this, location);
    return result.catch((err: any) => err);
}
export default router;
