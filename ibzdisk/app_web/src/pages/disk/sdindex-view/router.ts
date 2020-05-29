import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/sdindexview/:sdindexview?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'sdindexview';
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
                caption: 'app.views.sdindexview.caption',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'sdindexview', parameterName: 'sdindexview' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/disk/sdindex-view/sdindex-view.vue'),
            children: [
                {
                    path: 'sdfiles/:sdfile?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sdfile.views.gridview.caption',
                        parameters: [
                            { pathName: 'sdindexview', parameterName: 'sdindexview' },
                            { pathName: 'sdfiles', parameterName: 'sdfile' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/disk/sdfile-grid-view/sdfile-grid-view.vue'),
                },
                {
                    path: 'sdfiles/:sdfile?/editview/:editview?',
                    meta: {
                        caption: 'entities.sdfile.views.editview.caption',
                        parameters: [
                            { pathName: 'sdindexview', parameterName: 'sdindexview' },
                            { pathName: 'sdfiles', parameterName: 'sdfile' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/disk/sdfile-edit-view/sdfile-edit-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/sdfiles/:sdfile?/gridview/:gridview?',
        meta: {
            caption: 'entities.sdfile.views.gridview.caption',
            parameters: [
                { pathName: 'sdfiles', parameterName: 'sdfile' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/disk/sdfile-grid-view/sdfile-grid-view.vue'),
    },
    {
        path: '/sdfiles/:sdfile?/editview/:editview?',
        meta: {
            caption: 'entities.sdfile.views.editview.caption',
            parameters: [
                { pathName: 'sdfiles', parameterName: 'sdfile' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/disk/sdfile-edit-view/sdfile-edit-view.vue'),
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
            redirect: 'sdindexview'
        },
    ],
});

export default router;
