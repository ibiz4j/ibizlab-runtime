import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/appindexview/:appindexview?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'appindexview';
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
                caption: 'app.views.appindexview.title',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'appindexview', parameterName: 'appindexview' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/dict/app-index-view/app-index-view.vue'),
            children: [
                {
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/editview/:editview?',
                    meta: {
                        caption: 'entities.dictoption.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'appindexview', parameterName: 'appindexview' },
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
                            { pathName: 'appindexview', parameterName: 'appindexview' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-edit-view/dict-option-edit-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'appindexview', parameterName: 'appindexview' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-catalog-pickup-grid-view/dict-catalog-pickup-grid-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.dictoption.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'appindexview', parameterName: 'appindexview' },
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
                            { pathName: 'appindexview', parameterName: 'appindexview' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-grid-view/dict-option-grid-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/dictoptions/:dictoption?/grideditview/:grideditview?',
                    meta: {
                        caption: 'entities.dictoption.views.grideditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'appindexview', parameterName: 'appindexview' },
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
                            { pathName: 'appindexview', parameterName: 'appindexview' },
                            { pathName: 'dictoptions', parameterName: 'dictoption' },
                            { pathName: 'grideditview', parameterName: 'grideditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-option-grid-edit-view/dict-option-grid-edit-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'appindexview', parameterName: 'appindexview' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-catalog-pickup-view/dict-catalog-pickup-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/editview/:editview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'appindexview', parameterName: 'appindexview' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-catalog-edit-view/dict-catalog-edit-view.vue'),
                },
                {
                    path: 'dictcatalogs/:dictcatalog?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.dictcatalog.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'appindexview', parameterName: 'appindexview' },
                            { pathName: 'dictcatalogs', parameterName: 'dictcatalog' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/dict/dict-catalog-grid-view/dict-catalog-grid-view.vue'),
                },
            ...indexRoutes,
            ],
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
            redirect: 'appindexview'
        },
    ],
});

export default router;
