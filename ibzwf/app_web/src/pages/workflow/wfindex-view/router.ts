import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/wfindexview/:wfindexview?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'wfindexview';
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
                caption: 'app.views.wfindexview.caption',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'wfindexview', parameterName: 'wfindexview' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/workflow/wfindex-view/wfindex-view.vue'),
            children: [
                {
                    path: 'wfgroups/:wfgroup?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.wfgroup.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-pickup-grid-view/wfgroup-pickup-grid-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.wfuser.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfusers', parameterName: 'wfuser' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfuser-pickup-grid-view/wfuser-pickup-grid-view.vue'),
                },
                {
                    path: 'wfprocessdefinitions/:wfprocessdefinition?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfprocessdefinition.views.gridview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfprocess-definition-grid-view/wfprocess-definition-grid-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.wfuser.views.pickupview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfusers', parameterName: 'wfuser' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfuser-pickup-view/wfuser-pickup-view.vue'),
                },
                {
                    path: 'wfremodels/:wfremodel?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfremodel.views.editview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfremodels', parameterName: 'wfremodel' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfremodel-edit-view/wfremodel-edit-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/wfmembers/:wfmember?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfmember.views.editview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
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
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
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
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfmembers', parameterName: 'wfmember' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfgroup.views.gridview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-grid-view/wfgroup-grid-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.wfuser.views.mpickupview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfusers', parameterName: 'wfuser' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfuser-mpickup-view/wfuser-mpickup-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.wfgroup.views.mpickupview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-mpickup-view/wfgroup-mpickup-view.vue'),
                },
                {
                    path: 'wfusers/:wfuser?/wfmembers/:wfmember?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.wfmember.views.gridview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
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
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
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
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfmembers', parameterName: 'wfmember' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'),
                },
                {
                    path: 'wfgroups/:wfgroup?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfgroup.views.editview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfgroups', parameterName: 'wfgroup' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfgroup-edit-view/wfgroup-edit-view.vue'),
                },
                {
                    path: 'wfprocessdefinitions/:wfprocessdefinition?/editview/:editview?',
                    meta: {
                        caption: 'entities.wfprocessdefinition.views.editview.caption',
                        parameters: [
                            { pathName: 'wfindexview', parameterName: 'wfindexview' },
                            { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/workflow/wfprocess-definition-edit-view/wfprocess-definition-edit-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/wfusers/:wfuser?/wfmembers/:wfmember?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfmember.views.gridview.caption',
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
            parameters: [
                { pathName: 'wfmembers', parameterName: 'wfmember' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfmember-grid-view/wfmember-grid-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.wfuser.views.mpickupview.caption',
            parameters: [
                { pathName: 'wfusers', parameterName: 'wfuser' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfuser-mpickup-view/wfuser-mpickup-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.wfuser.views.pickupview.caption',
            parameters: [
                { pathName: 'wfusers', parameterName: 'wfuser' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfuser-pickup-view/wfuser-pickup-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.wfgroup.views.mpickupview.caption',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-mpickup-view/wfgroup-mpickup-view.vue'),
    },
    {
        path: '/wfprocessdefinitions/:wfprocessdefinition?/editview/:editview?',
        meta: {
            caption: 'entities.wfprocessdefinition.views.editview.caption',
            parameters: [
                { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfprocess-definition-edit-view/wfprocess-definition-edit-view.vue'),
    },
    {
        path: '/wfprocessdefinitions/:wfprocessdefinition?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfprocessdefinition.views.gridview.caption',
            parameters: [
                { pathName: 'wfprocessdefinitions', parameterName: 'wfprocessdefinition' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfprocess-definition-grid-view/wfprocess-definition-grid-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.wfuser.views.pickupgridview.caption',
            parameters: [
                { pathName: 'wfusers', parameterName: 'wfuser' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfuser-pickup-grid-view/wfuser-pickup-grid-view.vue'),
    },
    {
        path: '/wfusers/:wfuser?/wfmembers/:wfmember?/editview/:editview?',
        meta: {
            caption: 'entities.wfmember.views.editview.caption',
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
            parameters: [
                { pathName: 'wfmembers', parameterName: 'wfmember' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfmember-edit-view/wfmember-edit-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/editview/:editview?',
        meta: {
            caption: 'entities.wfgroup.views.editview.caption',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-edit-view/wfgroup-edit-view.vue'),
    },
    {
        path: '/wfremodels/:wfremodel?/editview/:editview?',
        meta: {
            caption: 'entities.wfremodel.views.editview.caption',
            parameters: [
                { pathName: 'wfremodels', parameterName: 'wfremodel' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfremodel-edit-view/wfremodel-edit-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.wfgroup.views.pickupgridview.caption',
            parameters: [
                { pathName: 'wfgroups', parameterName: 'wfgroup' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/workflow/wfgroup-pickup-grid-view/wfgroup-pickup-grid-view.vue'),
    },
    {
        path: '/wfgroups/:wfgroup?/gridview/:gridview?',
        meta: {
            caption: 'entities.wfgroup.views.gridview.caption',
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
            redirect: 'wfindexview'
        },
    ],
});

export default router;
