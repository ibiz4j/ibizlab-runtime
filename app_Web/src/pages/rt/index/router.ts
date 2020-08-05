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
                caption: 'app.views.index.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.wfgroup.views.pickupview.title',
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
                        caption: 'entities.sysrole.views.mpickupview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzposts/:ibzpost?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzpost.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzposts', parameterName: 'ibzpost' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzpost-pickup-view/ibzpost-pickup-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.wfuser.views.mpickupview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
                },
                {
                    path: 'ibzteams/:ibzteam?/ibzteammembers/:ibzteammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzteams', parameterName: 'ibzteam' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
                },
                {
                    path: 'ibzteammembers/:ibzteammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/sysuserroles/:sysuserrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.gridview.title',
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
                        caption: 'entities.sysuserrole.views.gridview.title',
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
                        caption: 'entities.sysuserrole.views.gridview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-pickup-view/ibzdepartment-pickup-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-pickup-view/ibzdepartment-pickup-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/wfmembers/:wfmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfmember.views.editview.title',
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
                        caption: 'entities.wfmember.views.editview.title',
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
                        caption: 'entities.wfmember.views.editview.title',
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
                        caption: 'entities.jobslog.views.gridview.title',
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
                    path: 'ibzposts/:ibzpost?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzpost.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzposts', parameterName: 'ibzpost' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzpost-grid-view/ibzpost-grid-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.sysrole.views.pickupgridview.title',
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
                        caption: 'entities.wfmember.views.gridview.title',
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
                        caption: 'entities.wfmember.views.gridview.title',
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
                        caption: 'entities.wfmember.views.gridview.title',
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
                        caption: 'entities.dictcatalog.views.editview.title',
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
                    path: 'wfprocessdefinitions/:wfprocessdefinition?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfprocessdefinition.views.editview.title',
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
                        caption: 'entities.sysrole.views.editview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-mpickup-view/ibzdepartment-mpickup-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-mpickup-view/ibzdepartment-mpickup-view.vue'),
                },
                {
                    path: 'ibzposts/:ibzpost?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzpost.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzposts', parameterName: 'ibzpost' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzpost-edit-view/ibzpost-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.treeexpview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-tree-exp-view/ibzdepartment-tree-exp-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.treeexpview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-tree-exp-view/ibzdepartment-tree-exp-view.vue'),
                },
                {
                    path: 'ibzteams/:ibzteam?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteam.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzteams', parameterName: 'ibzteam' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-edit-view/ibzteam-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysrole.views.gridview.title',
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
                        caption: 'entities.wfgroup.views.mpickupview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-pickup-view/ibzorganization-pickup-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfgroup.views.gridview.title',
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
                        caption: 'entities.dictcatalog.views.gridview.title',
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
                        caption: 'entities.wfuser.views.pickupview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
                },
                {
                    path: 'ibzteams/:ibzteam?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzteams', parameterName: 'ibzteam' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
                },
                {
                    path: 'ibzteammembers/:ibzteammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-grid-view/ibzdepartment-grid-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-grid-view/ibzdepartment-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-grid-view/ibzorganization-grid-view.vue'),
                },
                {
                    path: 'wfremodels/:wfremodel?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfremodel.views.editview.title',
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
                    path: 'sysauthlogs/:sysauthlog?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysauthlog.views.gridview.title',
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
                    path: 'jobslogs/:jobslog?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobslog.views.editview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-edit-view/ibzorganization-edit-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysuser.views.pickupview.title',
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
                    path: 'jobsinfos/:jobsinfo?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.jobsinfo.views.gridview.title',
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
                    path: 'wfprocessdefinitions/:wfprocessdefinition?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfprocessdefinition.views.gridview.title',
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
                    path: 'sysapps/:sysapp?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sysapp.views.gridview.title',
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
                        caption: 'entities.sysuser.views.mpickupview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
                },
                {
                    path: 'ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
                },
                {
                    path: 'jobsinfos/:jobsinfo?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobsinfo.views.editview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-pickup-grid-view/ibzdepartment-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-pickup-grid-view/ibzdepartment-pickup-grid-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/editview/:editview?',
                    meta: {
                        caption: 'entities.dictoption.views.editview.title',
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
                        caption: 'entities.dictoption.views.editview.title',
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
                    path: 'jobsregistries/:jobsregistry?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.jobsregistry.views.gridview.title',
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
                        caption: 'entities.wfuser.views.pickupgridview.title',
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
                    path: 'ibzposts/:ibzpost?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzpost.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzposts', parameterName: 'ibzpost' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzpost-pickup-grid-view/ibzpost-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.treeexpview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-tree-exp-view/ibzorganization-tree-exp-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.wfgroup.views.pickupgridview.title',
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
                    path: 'ibzteams/:ibzteam?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteam.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzteams', parameterName: 'ibzteam' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-grid-view/ibzteam-grid-view.vue'),
                },
                {
                    path: 'jobsregistries/:jobsregistry?/editview/:editview?',
                    meta: {
                        caption: 'entities.jobsregistry.views.editview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-edit-view/ibzdepartment-edit-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-edit-view/ibzdepartment-edit-view.vue'),
                },
                {
                    path: 'sysusers/:sysuser?/sysuserroles/:sysuserrole?/editview/:editview?',
                    meta: {
                        caption: 'entities.sysuserrole.views.editview.title',
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
                        caption: 'entities.sysuserrole.views.editview.title',
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
                        caption: 'entities.sysuserrole.views.editview.title',
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
                        caption: 'entities.wfgroup.views.editview.title',
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
                    path: 'sysroles/:sysrole?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
                    meta: {
                        caption: 'entities.sysrolepermission.views.customview.title',
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
                        caption: 'entities.sysrolepermission.views.customview.title',
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
                        caption: 'entities.sysrolepermission.views.customview.title',
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
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/grideditview/:grideditview?',
                    meta: {
                        caption: 'entities.dictoption.views.grideditview.title',
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
                        caption: 'entities.dictoption.views.grideditview.title',
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
                    path: 'dictcatalogs/:dictcatalog?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.pickupgridview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
                },
                {
                    path: 'ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
                },
                {
                    path: 'sysroles/:sysrole?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.sysrole.views.pickupview.title',
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
                        caption: 'entities.sysapp.views.editview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-pickup-grid-view/ibzorganization-pickup-grid-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.dictoption.views.gridview.title',
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
                        caption: 'entities.dictoption.views.gridview.title',
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
                        caption: 'entities.sysuser.views.pickupgridview.title',
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
                        caption: 'entities.dictcatalog.views.pickupview.title',
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
            ...indexRoutes,
            ],
        },
    {
        path: '/dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/editview/:editview?',
        meta: {
            caption: 'entities.dictoption.views.editview.title',
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
            caption: 'entities.dictoption.views.editview.title',
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ibzdepartment.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-pickup-view/ibzdepartment-pickup-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ibzdepartment.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-pickup-view/ibzdepartment-pickup-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/editview/:editview?',
        meta: {
            caption: 'entities.ibzemployee.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/editview/:editview?',
        meta: {
            caption: 'entities.ibzemployee.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/editview/:editview?',
        meta: {
            caption: 'entities.ibzemployee.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/editview/:editview?',
        meta: {
            caption: 'entities.ibzemployee.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/wfmembers/:wfmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfmember.views.gridview.title',
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
            caption: 'entities.wfmember.views.gridview.title',
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
            caption: 'entities.wfmember.views.gridview.title',
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
        path: '/sysroles/:sysrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysrole.views.gridview.title',
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
        path: '/wfgroups/:wfgroup?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.wfgroup.views.pickupgridview.title',
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
        path: '/sysapps/:sysapp?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysapp.views.gridview.title',
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
        path: '/sysusers/:sysuser?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysuser.views.mpickupview.title',
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
        path: '/dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/gridview/:gridview?',
        meta: {
            caption: 'entities.dictoption.views.gridview.title',
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
            caption: 'entities.dictoption.views.gridview.title',
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
            caption: 'entities.sysauthlog.views.gridview.title',
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
            caption: 'entities.sysrole.views.pickupview.title',
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzteammember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzteammember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzteammember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
    },
    {
        path: '/ibzteams/:ibzteam?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzteammember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzteams', parameterName: 'ibzteam' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzteammember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
    },
    {
        path: '/ibzteammembers/:ibzteammember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzteammember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
    },
    {
        path: '/ibzteams/:ibzteam?/editview/:editview?',
        meta: {
            caption: 'entities.ibzteam.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzteams', parameterName: 'ibzteam' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-edit-view/ibzteam-edit-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.sysuser.views.pickupview.title',
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
        path: '/jobsregistries/:jobsregistry?/gridview/:gridview?',
        meta: {
            caption: 'entities.jobsregistry.views.gridview.title',
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
            caption: 'entities.wfprocessdefinition.views.editview.title',
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
            caption: 'entities.sysapp.views.editview.title',
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzemployee.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzemployee.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzemployee.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzemployee.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/grideditview/:grideditview?',
        meta: {
            caption: 'entities.dictoption.views.grideditview.title',
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
            caption: 'entities.dictoption.views.grideditview.title',
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
        path: '/jobsinfos/:jobsinfo?/editview/:editview?',
        meta: {
            caption: 'entities.jobsinfo.views.editview.title',
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
        path: '/jobsregistries/:jobsregistry?/editview/:editview?',
        meta: {
            caption: 'entities.jobsregistry.views.editview.title',
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
            caption: 'entities.wfremodel.views.editview.title',
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
        path: '/ibzteams/:ibzteam?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzteam.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzteams', parameterName: 'ibzteam' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-grid-view/ibzteam-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzteammember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzteammember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzteammember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
    },
    {
        path: '/ibzteams/:ibzteam?/ibzteammembers/:ibzteammember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzteammember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzteams', parameterName: 'ibzteam' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzteammember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
    },
    {
        path: '/ibzteammembers/:ibzteammember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzteammember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
    },
    {
        path: '/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.wfuser.views.pickupview.title',
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
        path: '/ibzorganizations/:ibzorganization?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.ibzorganization.views.treeexpview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzorganization-tree-exp-view/ibzorganization-tree-exp-view.vue'),
    },
    {
        path: '/sysusers/:sysuser?/sysuserroles/:sysuserrole?/gridview/:gridview?',
        meta: {
            caption: 'entities.sysuserrole.views.gridview.title',
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
            caption: 'entities.sysuserrole.views.gridview.title',
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
            caption: 'entities.sysuserrole.views.gridview.title',
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
            caption: 'entities.jobslog.views.gridview.title',
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
        path: '/sysusers/:sysuser?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.sysuser.views.pickupgridview.title',
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
        path: '/sysroles/:sysrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysrole.views.editview.title',
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
            caption: 'entities.wfmember.views.editview.title',
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
            caption: 'entities.wfmember.views.editview.title',
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
            caption: 'entities.wfmember.views.editview.title',
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdepartment.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-grid-view/ibzdepartment-grid-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzdepartment.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-grid-view/ibzdepartment-grid-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/gridview/:gridview?',
        meta: {
            caption: 'entities.dictcatalog.views.gridview.title',
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
            caption: 'entities.sysrole.views.pickupgridview.title',
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
        path: '/ibzposts/:ibzpost?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ibzpost.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzposts', parameterName: 'ibzpost' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzpost-pickup-view/ibzpost-pickup-view.vue'),
    },
    {
        path: '/dictcatalogs/:dictcatalog?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.dictcatalog.views.pickupgridview.title',
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
            caption: 'entities.wfuser.views.mpickupview.title',
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
            caption: 'entities.syspermission.views.mpickupview.title',
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
        path: '/ibzposts/:ibzpost?/editview/:editview?',
        meta: {
            caption: 'entities.ibzpost.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzposts', parameterName: 'ibzpost' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzpost-edit-view/ibzpost-edit-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.wfgroup.views.mpickupview.title',
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdepartment.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-edit-view/ibzdepartment-edit-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdepartment.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-edit-view/ibzdepartment-edit-view.vue'),
    },
    {
        path: '/syspermissions/:syspermission?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.syspermission.views.pickupgridview.title',
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
        path: '/ibzorganizations/:ibzorganization?/editview/:editview?',
        meta: {
            caption: 'entities.ibzorganization.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzorganization-edit-view/ibzorganization-edit-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.ibzdepartment.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-mpickup-view/ibzdepartment-mpickup-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.ibzdepartment.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-mpickup-view/ibzdepartment-mpickup-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/sysrolepermissions/:sysrolepermission?/customview/:customview?',
        meta: {
            caption: 'entities.sysrolepermission.views.customview.title',
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
            caption: 'entities.sysrolepermission.views.customview.title',
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
            caption: 'entities.sysrolepermission.views.customview.title',
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ibzemployee.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ibzemployee.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ibzemployee.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ibzemployee.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
    },
    {
        path: '/sysroles/:sysrole?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.sysrole.views.mpickupview.title',
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
        path: '/dictcatalogs/:dictcatalog?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.dictcatalog.views.pickupview.title',
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
        path: '/dictcatalogs/:dictcatalog?/editview/:editview?',
        meta: {
            caption: 'entities.dictcatalog.views.editview.title',
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
        path: '/wfgroups/:wfgroup?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.wfgroup.views.pickupview.title',
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
        path: '/wfgroups/:wfgroup?/editview/:editview?',
        meta: {
            caption: 'entities.wfgroup.views.editview.title',
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
        path: '/jobslogs/:jobslog?/editview/:editview?',
        meta: {
            caption: 'entities.jobslog.views.editview.title',
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
    },
    {
        path: '/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
        meta: {
            caption: 'entities.ibzdeptmember.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
    },
    {
        path: '/wfprocessdefinitions/:wfprocessdefinition?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfprocessdefinition.views.gridview.title',
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.ibzdepartment.views.treeexpview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-tree-exp-view/ibzdepartment-tree-exp-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.ibzdepartment.views.treeexpview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-tree-exp-view/ibzdepartment-tree-exp-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzorganization.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzorganization-grid-view/ibzorganization-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ibzemployee.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ibzemployee.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ibzemployee.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ibzemployee.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.wfuser.views.pickupgridview.title',
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
        path: '/ibzposts/:ibzpost?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ibzpost.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzposts', parameterName: 'ibzpost' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzpost-pickup-grid-view/ibzpost-pickup-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ibzorganization.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzorganization-pickup-view/ibzorganization-pickup-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ibzorganization.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzorganization-pickup-grid-view/ibzorganization-pickup-grid-view.vue'),
    },
    {
        path: '/ibzposts/:ibzpost?/gridview/:gridview?',
        meta: {
            caption: 'entities.ibzpost.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzposts', parameterName: 'ibzpost' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzpost-grid-view/ibzpost-grid-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.ibzemployee.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.ibzemployee.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.ibzemployee.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.ibzemployee.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ibzdepartment.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-pickup-grid-view/ibzdepartment-pickup-grid-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ibzdepartment.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-pickup-grid-view/ibzdepartment-pickup-grid-view.vue'),
    },
    {
        path: '/jobsinfos/:jobsinfo?/gridview/:gridview?',
        meta: {
            caption: 'entities.jobsinfo.views.gridview.title',
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
        path: '/sysusers/:sysuser?/sysuserroles/:sysuserrole?/editview/:editview?',
        meta: {
            caption: 'entities.sysuserrole.views.editview.title',
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
            caption: 'entities.sysuserrole.views.editview.title',
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
            caption: 'entities.sysuserrole.views.editview.title',
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
        path: '/wfgroups/:wfgroup?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfgroup.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-grid-view/wfgroup-grid-view.vue'),
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

export default router;
