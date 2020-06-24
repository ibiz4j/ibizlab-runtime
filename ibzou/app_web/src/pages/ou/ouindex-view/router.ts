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
                caption: 'app.views.ouindexview.title',
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
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.optionview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-option-view/ibzdepartment-option-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.optionview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-option-view/ibzdepartment-option-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-grid-view/ibzemployee-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-edit-view/ibzteam-member-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzteammembers/:ibzteammember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteammember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzteammembers', parameterName: 'ibzteammember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-member-grid-view/ibzteam-member-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-grid-view/ibzdept-member-grid-view.vue'),
                },
                {
                    path: 'ibzposts/:ibzpost?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzpost.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzposts', parameterName: 'ibzpost' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzpost-grid-view/ibzpost-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.treeexpview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-tree-exp-view/ibzorganization-tree-exp-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-edit-view/ibzdepartment-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-view/ibzemployee-pickup-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/ibzdeptmembers/:ibzdeptmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzdeptmember.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzdeptmembers', parameterName: 'ibzdeptmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdept-member-edit-view/ibzdept-member-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-pickup-view/ibzorganization-pickup-view.vue'),
                },
                {
                    path: 'ibzteams/:ibzteam?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzteam.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzteams', parameterName: 'ibzteam' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-grid-view/ibzteam-grid-view.vue'),
                },
                {
                    path: 'ibzteams/:ibzteam?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzteam.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzteams', parameterName: 'ibzteam' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzteam-edit-view/ibzteam-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-edit-view/ibzemployee-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-pickup-grid-view/ibzdepartment-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzposts/:ibzpost?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzpost.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzposts', parameterName: 'ibzpost' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzpost-pickup-view/ibzpost-pickup-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.optionview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-option-view/ibzorganization-option-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-pickup-grid-view/ibzorganization-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-grid-view/ibzorganization-grid-view.vue'),
                },
                {
                    path: 'ibzposts/:ibzpost?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzpost.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzposts', parameterName: 'ibzpost' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzpost-pickup-grid-view/ibzpost-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-mpickup-view/ibzemployee-mpickup-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/editview/:editview?',
                    meta: {
                        caption: 'entities.ibzorganization.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzorganization-edit-view/ibzorganization-edit-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-pickup-grid-view/ibzemployee-pickup-grid-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-tree-exp-view/ibzdepartment-tree-exp-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.optionview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-option-view/ibzemployee-option-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.optionview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-option-view/ibzemployee-option-view.vue'),
                },
                {
                    path: 'ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.optionview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-option-view/ibzemployee-option-view.vue'),
                },
                {
                    path: 'ibzemployees/:ibzemployee?/optionview/:optionview?',
                    meta: {
                        caption: 'entities.ibzemployee.views.optionview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                            { pathName: 'optionview', parameterName: 'optionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzemployee-option-view/ibzemployee-option-view.vue'),
                },
                {
                    path: 'ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ibzdepartment.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
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
                            { pathName: 'ouindexview', parameterName: 'ouindexview' },
                            { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/ou/ibzdepartment-pickup-view/ibzdepartment-pickup-view.vue'),
                },
            ...indexRoutes,
            ],
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/optionview/:optionview?',
        meta: {
            caption: 'entities.ibzdepartment.views.optionview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-option-view/ibzdepartment-option-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/optionview/:optionview?',
        meta: {
            caption: 'entities.ibzdepartment.views.optionview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzdepartment-option-view/ibzdepartment-option-view.vue'),
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
        path: '/ibzorganizations/:ibzorganization?/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/optionview/:optionview?',
        meta: {
            caption: 'entities.ibzemployee.views.optionview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-option-view/ibzemployee-option-view.vue'),
    },
    {
        path: '/ibzorganizations/:ibzorganization?/ibzemployees/:ibzemployee?/optionview/:optionview?',
        meta: {
            caption: 'entities.ibzemployee.views.optionview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-option-view/ibzemployee-option-view.vue'),
    },
    {
        path: '/ibzdepartments/:ibzdepartment?/ibzemployees/:ibzemployee?/optionview/:optionview?',
        meta: {
            caption: 'entities.ibzemployee.views.optionview.title',
            info:'',
            parameters: [
                { pathName: 'ibzdepartments', parameterName: 'ibzdepartment' },
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-option-view/ibzemployee-option-view.vue'),
    },
    {
        path: '/ibzemployees/:ibzemployee?/optionview/:optionview?',
        meta: {
            caption: 'entities.ibzemployee.views.optionview.title',
            info:'',
            parameters: [
                { pathName: 'ibzemployees', parameterName: 'ibzemployee' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzemployee-option-view/ibzemployee-option-view.vue'),
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
        path: '/ibzorganizations/:ibzorganization?/optionview/:optionview?',
        meta: {
            caption: 'entities.ibzorganization.views.optionview.title',
            info:'',
            parameters: [
                { pathName: 'ibzorganizations', parameterName: 'ibzorganization' },
                { pathName: 'optionview', parameterName: 'optionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/ou/ibzorganization-option-view/ibzorganization-option-view.vue'),
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
            redirect: 'ouindexview'
        },
    ],
});

export default router;
