import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/ouindexview/:ouindexview?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'ouindexview';
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
                caption: 'app.views.ouindexview.caption',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'ouindexview', parameterName: 'ouindexview' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/ou/ouindex-view/ouindex-view.vue'),
            children: [
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysemployee.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-grid-view/sys-employee-grid-view.vue'),
                },
                {
                    path: 'sysposts/:syspost?/editview/:editview?',
                    meta: {
                        caption: 'entities.syspost.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysposts', parameterName: 'syspost' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-post-edit-view/sys-post-edit-view.vue'),
                },
                {
                    path: 'sysposts/:syspost?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.syspost.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysposts', parameterName: 'syspost' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-post-pickup-view/sys-post-pickup-view.vue'),
                },
                {
                    path: 'sysposts/:syspost?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.syspost.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysposts', parameterName: 'syspost' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-post-grid-view/sys-post-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.sysemployee.views.optionview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-option-view/sys-employee-option-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysemployees/:sysemployee?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.sysemployee.views.optionview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-option-view/sys-employee-option-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.sysemployee.views.optionview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-option-view/sys-employee-option-view.vue'),
                },
                {
                    path: 'sysemployees/:sysemployee?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.sysemployee.views.optionview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-option-view/sys-employee-option-view.vue'),
                },
                {
                    path: 'systeams/:systeam?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeam.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'systeams', parameterName: 'systeam' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-edit-view/sys-team-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysorganization.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-pickup-grid-view/sys-organization-pickup-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeammember.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-grid-view/sys-team-member-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-view/sys-employee-pickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.sysorganization.views.treeexpview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-tree-exp-view/sys-organization-tree-exp-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.pickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-pickup-view/sys-department-pickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.optionview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-option-view/sys-department-option-view.vue'),
                },
                {
                    path: 'sysdepartments/:sysdepartment?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.optionview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-option-view/sys-department-option-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/sysdeptmembers/:sysdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdeptmember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysdeptmembers', parameterName: 'sysdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-dept-member-edit-view/sys-dept-member-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.sysorganization.views.optionview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-option-view/sys-organization-option-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysemployee.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-pickup-view/sys-organization-pickup-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.treeexpview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-tree-exp-view/sys-department-tree-exp-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-pickup-grid-view/sys-department-pickup-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.mpickupview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-mpickup-view/sys-department-mpickup-view.vue'),
                },
                {
                    path: 'systeams/:systeam?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.systeam.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-pickup-grid-view/sys-employee-pickup-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysdepartment.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-department-edit-view/sys-department-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysorganization.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-edit-view/sys-organization-edit-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/systeammembers/:systeammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.systeammember.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'systeammembers', parameterName: 'systeammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-team-member-edit-view/sys-team-member-edit-view.vue'),
                },
                {
                    path: 'sysposts/:syspost?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.syspost.views.pickupgridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysposts', parameterName: 'syspost' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-post-pickup-grid-view/sys-post-pickup-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysorganization.views.gridview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-organization-grid-view/sys-organization-grid-view.vue'),
                },
                {
                    path: 'sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysemployee.views.editview.caption',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'sysemployees', parameterName: 'sysemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/sys-employee-edit-view/sys-employee-edit-view.vue'),
                },
            ...indexRoutes,
            ],
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
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/optionview/:optionview?',
        meta: {
            caption: 'entities.sysemployee.views.optionview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-option-view/sys-employee-option-view.vue'),
    },
    {
        path: '/sysorganizations/:sysorganization?/sysemployees/:sysemployee?/optionview/:optionview?',
        meta: {
            caption: 'entities.sysemployee.views.optionview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-option-view/sys-employee-option-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/sysemployees/:sysemployee?/optionview/:optionview?',
        meta: {
            caption: 'entities.sysemployee.views.optionview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-option-view/sys-employee-option-view.vue'),
    },
    {
        path: '/sysemployees/:sysemployee?/optionview/:optionview?',
        meta: {
            caption: 'entities.sysemployee.views.optionview.caption',
            info:'',
            parameters: [
                { pathName: 'sysemployees', parameterName: 'sysemployee' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-employee-option-view/sys-employee-option-view.vue'),
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
        path: '/sysorganizations/:sysorganization?/sysdepartments/:sysdepartment?/optionview/:optionview?',
        meta: {
            caption: 'entities.sysdepartment.views.optionview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-option-view/sys-department-option-view.vue'),
    },
    {
        path: '/sysdepartments/:sysdepartment?/optionview/:optionview?',
        meta: {
            caption: 'entities.sysdepartment.views.optionview.caption',
            info:'',
            parameters: [
                { pathName: 'sysdepartments', parameterName: 'sysdepartment' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-department-option-view/sys-department-option-view.vue'),
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
        path: '/sysorganizations/:sysorganization?/optionview/:optionview?',
        meta: {
            caption: 'entities.sysorganization.views.optionview.caption',
            info:'',
            parameters: [
                { pathName: 'sysorganizations', parameterName: 'sysorganization' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/sys-organization-option-view/sys-organization-option-view.vue'),
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
            redirect: 'ouindexview'
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
